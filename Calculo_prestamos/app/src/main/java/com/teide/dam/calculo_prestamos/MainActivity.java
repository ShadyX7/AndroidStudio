package com.teide.dam.calculo_prestamos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText capital;
    private EditText interes;
    private EditText tiempo;
    private Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        capital = (EditText) findViewById(R.id.resCapital);
        interes = (EditText) findViewById(R.id.resInteres);
        tiempo = (EditText) findViewById(R.id.resTiempo);
        calcular = (Button) findViewById(R.id.btnCalcular);
        calcular.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (capital.getText().toString().trim().isEmpty() ||
                (interes.getText().toString().trim().isEmpty() ||
                        (tiempo.getText().toString().trim().isEmpty()))) {

        } else {

            Intent i = new Intent(this,Main2Activity.class);
            i.putExtra("capital",Double.parseDouble(capital.getText().toString().trim()));
            i.putExtra("interes",Double.parseDouble( interes.getText().toString().trim()));
            i.putExtra("tiempo",Integer.parseInt(tiempo.getText().toString().trim()));
            startActivity(i);
            
        }
    }

}