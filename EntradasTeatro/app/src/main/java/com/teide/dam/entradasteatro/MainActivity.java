package com.teide.dam.entradasteatro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private RadioGroup sexo;
    private RadioButton hombre;
    private Spinner numEntradas;
    private CheckBox menor25, discapacidad, trabajadores;
    private Button calcular;
    private EditText cajaResul;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sexo = (RadioGroup)findViewById(R.id.radioGroup);
        hombre = (RadioButton)findViewById(R.id.radioButton);
        numEntradas = (Spinner)findViewById(R.id.spinner);
        menor25 = (CheckBox)findViewById(R.id.checkBox);
        discapacidad = (CheckBox)findViewById(R.id.checkBox2);
        trabajadores = (CheckBox)findViewById(R.id.checkBox3);
        calcular = (Button)findViewById(R.id.button);
        calcular.setOnClickListener(this);
        cajaResul = (EditText)findViewById(R.id.cajatxt2);

    }

    public Double operaciones(){
        int parseo;
        double resultado = 0;
        double descuento;

        if (sexo.getCheckedRadioButtonId() == hombre.getId()){
           resultado = numEntradas.getSelectedItemId()+1;
        }else{
            resultado = (numEntradas.getSelectedItemId()+1)*0.80;
        }
        if (menor25.isChecked()) {
            descuento = resultado * 0.05;
            resultado = resultado - descuento;
        }
        if (discapacidad.isChecked()){
            descuento = resultado * 0.10;
            resultado = resultado - descuento;
        }
        if (trabajadores.isChecked()){
            descuento = resultado * 0.12;
            resultado = resultado - descuento;
        }

        resultado = resultado * 100;
        parseo = (int) resultado;
        resultado = parseo;
        resultado = resultado / 100;
        return resultado;
    }


    @Override
    public void onClick(View v) {

        cajaResul.setVisibility(View.VISIBLE);
        cajaResul.setText("Precio: " + operaciones().toString() + "$");


    }
}
