package victorlopez.estudio.casa.com.ruletacasino;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CheckBox validaEdad;
    private Button entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        validaEdad = (CheckBox) findViewById(R.id.validaEdad);
        entrar = (Button) findViewById(R.id.entrar);
        entrar.setOnClickListener(this);
        validaEdad.setOnClickListener(this);

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

        if (validaEdad.isChecked()){
            entrar.setVisibility(View.VISIBLE);
        }else{
            entrar.setVisibility(View.INVISIBLE);
        }
        if (v.getId() == R.id.entrar) {
            if (validaEdad.isChecked()) {
                Intent i = new Intent(this, Main2Activity.class);
                startActivity(i);
            }

        }
    }
}

