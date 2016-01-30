package victorlopez.estudio.casa.com.calculoimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    private EditText nombre;
    private NumberPicker peso;
    private SeekBar altura;
    private TextView valor;
    private Button calcular;
    private int numValor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        nombre = (EditText) findViewById(R.id.nom);
        peso = (NumberPicker) findViewById(R.id.peso);
        altura = (SeekBar) findViewById(R.id.altura);
        valor = (TextView) findViewById(R.id.valorAltura);
        calcular = (Button) findViewById(R.id.calcular);
        calcular.setOnClickListener(this);
        altura.setOnSeekBarChangeListener(this);
        peso.setOnClickListener(this);

        peso.setMinValue(0);
        peso.setMaxValue(500);
        peso.setWrapSelectorWheel(false);
        numValor = peso.getValue();




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onClick(View v) {

        if (nombre.getText().toString().trim().isEmpty()|| 
                //(numValor == 0) ||
                   (valor.getText().toString().trim() == "0")){

            calcular.setEnabled(false);
        }else{
            calcular.setEnabled(true);
        }


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {


        valor.setText(String.valueOf(altura.getProgress()));

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }



}
