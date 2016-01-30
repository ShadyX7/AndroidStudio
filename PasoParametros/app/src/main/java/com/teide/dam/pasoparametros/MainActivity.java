package com.teide.dam.pasoparametros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText nombre;
    private Spinner colores;
    private Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nombre = (EditText) findViewById(R.id.editText);
        colores = (Spinner) findViewById(R.id.spinner);
        enviar = (Button) findViewById(R.id.button);






    }

    @Override
    public void onClick(View v) {

        if(nombre.getText().toString().trim().isEmpty()){



        }
        else{
            Intent i = new Intent(this,SecundariaActivity.class);
            i.putExtra("palabra",nombre.getText().toString().trim());
            i.putExtra("color", colores.getSelectedItemPosition());
            startActivity(i);
        }
    }
}
