package com.teide.dam.examenpropina;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.NumberFormat;

public class Main2Activity extends AppCompatActivity {

    private LinearLayout color;
    private TextView totalPersona;
    private int valorPropina;
    private double precioComensal;

    //NUEVO
    NumberFormat moneda = NumberFormat.getCurrencyInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        color = (LinearLayout) findViewById(R.id.color);
        totalPersona = (TextView) findViewById(R.id.totalPersona);


        valorPropina = getIntent().getIntExtra("valorPropina", 0);
        precioComensal = getIntent().getDoubleExtra("precioComensal", 0);

        // NUEVO
        if (valorPropina <= 25) {
            color.setBackgroundColor(Color.RED);
        } else{
            if (valorPropina > 25 && valorPropina <= 50) {
                color.setBackgroundColor(Color.YELLOW);
            } else {
                color.setBackgroundColor(Color.GREEN);
            }
        }


        totalPersona.setText(String.valueOf(moneda.format(precioComensal)));


    }
}
