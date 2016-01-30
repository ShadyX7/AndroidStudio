package victorlopez.estudio.casa.com.ruletacasino;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;
import java.util.Random;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    private SeekBar dineroDisponible;
    private TextView numDinero;
    private RadioButton rojo;
    private RadioButton negro;
    private RadioButton cero;
    private SeekBar cantidadApuesta;
    private TextView numCantidad;
    private Button jugar;
    private Button salir;
    private ImageView cajaImagen;
    private TextView resultadoGanador;
    private int apuestaRojo = R.drawable.rojo;
    private int apuestaNegro = R.drawable.negro;
    private int apuestaCero = R.drawable.cero;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        dineroDisponible = (SeekBar) findViewById(R.id.seekBar);
        numDinero = (TextView) findViewById(R.id.numDinero);
        rojo = (RadioButton) findViewById(R.id.radioButton);
        negro = (RadioButton) findViewById(R.id.radioButton2);
        cero = (RadioButton) findViewById(R.id.radioButton3);
        cantidadApuesta = (SeekBar) findViewById(R.id.seekBar2);
        numCantidad = (TextView) findViewById(R.id.numCantidad);
        jugar = (Button) findViewById(R.id.jugar);
        salir = (Button) findViewById(R.id.salir);
        cajaImagen = (ImageView) findViewById(R.id.imageView2);
        resultadoGanador = (TextView) findViewById(R.id.apuestaGanadora);
        jugar.setOnClickListener(this);
        salir.setOnClickListener(this);
        dineroDisponible.setOnSeekBarChangeListener(this);
        cantidadApuesta.setOnSeekBarChangeListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void jugar() {

        NumberFormat moneda = NumberFormat.getCurrencyInstance();// Se crea un formato de moneda asociado al País en el que se encuentre el usuario.
        Random r = new Random();

        int aleatorio = r.nextInt(37);
        int resultado;
        int cantidadGanada;
        int dineroSobrante = dineroDisponible.getProgress();
        int dineroApostado = Integer.parseInt(numCantidad.getText().toString().trim());
        int cifra1 = 0;
        cifra1 = aleatorio/10;
        int cifra2 = aleatorio - (cifra1 * 10);
        int cifraTotal = cifra1 + cifra2;

        if (cifraTotal == 0){
            resultado = 0;
            cajaImagen.setImageResource(apuestaCero);


        } else {
            if (cifraTotal%2 == 0) {
                resultado = 1;
                cajaImagen.setImageResource(apuestaRojo);
            } else{
                resultado = 2;
                cajaImagen.setImageResource(apuestaNegro);
            }

        }


        if ((rojo.isChecked() && resultado == 1) || (negro.isChecked() && resultado == 2) || cero.isChecked() && resultado == 0) {
            if (cero.isChecked() && resultado == 0){
                resultadoGanador.setText("ENHORABUENA, HAS GANADO " + (String.valueOf(moneda.format(dineroApostado * 2))));
                cantidadGanada = dineroSobrante + (dineroApostado * 2);
                dineroDisponible.setMax(cantidadGanada);
            }else {
                resultadoGanador.setText("ENHORABUENA, HAS GANADO " + (String.valueOf(moneda.format(dineroApostado))));
                cantidadGanada = dineroSobrante + dineroApostado;
                dineroDisponible.setMax(cantidadGanada);
            }

        } else {
            if (aleatorio != 0) {
                resultadoGanador.setText("LO SIENTO, HAS PERDIDO " + (String.valueOf(moneda.format(dineroApostado))));
                cantidadGanada = dineroSobrante - dineroApostado;
                dineroDisponible.setMax(cantidadGanada);

            }else{

                resultadoGanador.setText("LO SIENTO, HAS PERDIDO " + (String.valueOf(moneda.format(dineroApostado * 2))));
                cantidadGanada = dineroSobrante - (dineroApostado * 2);
                dineroDisponible.setMax(cantidadGanada);
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == salir.getId()){
            System.exit(0);
        }else {
            jugar();
            cajaImagen.setVisibility(View.VISIBLE);
            resultadoGanador.setVisibility(View.VISIBLE);
        }

    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        cantidadApuesta.setMax(dineroDisponible.getProgress());
        numDinero.setText(String.valueOf(dineroDisponible.getProgress()));
        numCantidad.setText(String.valueOf(cantidadApuesta.getProgress()));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
