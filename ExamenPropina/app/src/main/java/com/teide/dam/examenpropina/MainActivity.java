package com.teide.dam.examenpropina;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,SeekBar.OnSeekBarChangeListener {

    private EditText precio;
    private EditText numpersonas;
    private SeekBar propina;
    private TextView valorPropina;
    private Button pagar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precio = (EditText) findViewById(R.id.precio);
        numpersonas = (EditText) findViewById(R.id.numPersonas);
        propina = (SeekBar) findViewById(R.id.seekBar);
        valorPropina = (TextView) findViewById(R.id.valorPropina);
        pagar = (Button) findViewById(R.id.pagar);
        pagar.setOnClickListener(this);
        propina.setOnSeekBarChangeListener(this);


    }

    public Double precioComensales() {


        int personas = Integer.parseInt(numpersonas.getText().toString());
        double precioPers = Double.parseDouble(precio.getText().toString());
        double propinas = Double.parseDouble(valorPropina.getText().toString());
        double propinaFinal = (propinas * precioPers) /100; //HE CAMBIADO EL VALOR DE PROPINA PARA HACERLO DEL % DEL PRECIO
        double totalPersona = precioPers / personas;
        double totalPropina = propinaFinal / personas;


        return totalPersona + totalPropina;
    }



        @Override
        public void onClick (View v){


            if (precio.getText().toString().isEmpty() ||
                    (numpersonas.getText().toString().isEmpty())) {

                pagar.setEnabled(false);

            } else {
                pagar.setEnabled(true);

            }


            Intent i = new Intent(this,Main2Activity.class);
            i.putExtra("valorPropina", Integer.parseInt(valorPropina.getText().toString().trim()));
            i.putExtra("precioComensal", Double.parseDouble(precioComensales().toString().trim()));
            startActivity(i);



        }

        @Override
        public void onProgressChanged (SeekBar seekBar,int progress, boolean fromUser){

            propina.setMax(75);

            valorPropina.setText(String.valueOf(progress));

        }

        @Override
        public void onStartTrackingTouch (SeekBar seekBar){

        }

        @Override
        public void onStopTrackingTouch (SeekBar seekBar){

        }
    }




