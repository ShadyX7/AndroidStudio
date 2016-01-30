package com.teide.dam.calculo_prestamos;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import junit.framework.Test;

import java.text.NumberFormat;

public class Main2Activity extends AppCompatActivity {

    private int tiempo;
    private double cuota;
    private double interes;
    private double interes_precio;
    private double capital;
    private double capital_precio;
    private double capital_amortizado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        NumberFormat moneda = NumberFormat.getCurrencyInstance();// Se crea un formato de moneda asociado al País en el que se encuentre el usuario.
        moneda.setMaximumFractionDigits(2);// Se ponen como limite a este formato, 2 digitos como máximo.


        capital = getIntent().getDoubleExtra("capital", 0);// Inicializamos el capital a 0.
        interes = getIntent().getDoubleExtra("interes", 0);// Inicializamos el interes a 0.
        tiempo = getIntent().getIntExtra("tiempo", 0);// Inicializamos el tiempo a 0.
        tiempo = tiempo * 12; //Los años los pasamos a meses
        interes = (interes / 100) / 12; //El interes dado en porcentaje lo desglosamos y lo dividimos entre 12 meses (Que tiene un año).
        cuota = capital * interes / (1 - Math.pow(1 + interes, -tiempo));


        TableLayout H = (TableLayout) findViewById(R.id.TablaGeneral);
        for (int i = 1; i < tiempo + 1; i++) {// Tendra tantas filas como meses haya ingresado el usuario.
            interes_precio = capital * interes;
            capital_precio = cuota - interes_precio;
            capital_amortizado = capital_amortizado + capital_precio;// El capital_amortizado en el mes 1, esta inicializado a 0.
            capital = capital - capital_precio;// Va restando el capital pagado al capital total del usuario.

            TableRow tr = new TableRow(this);// Se crea una fila
            H.addView(tr); // Se añade esta fila a la Tabla creada (TablaGeneral).

            TextView columnMes = new TextView(this); // Se crea una caja de texto.
            tr.addView(columnMes);// Se añade esta caja de texto al TableRow.
            columnMes.setText(Integer.toString(i));// Se añade a partir de 1 ( 1,2,3,4...) en la columna de Tiempo como tantos meses tenga.
            columnMes.setBackgroundColor(Color.parseColor("#b588ff"));
            columnMes.setPadding(30, 30, 30, 30);


            TextView columnCuota = new TextView(this);// Se crea una caja de texto.
            tr.addView(columnCuota); // Se añade esta caja de texto al TableRow
            columnCuota.setText(moneda.format(cuota));// Se añade el valor de cuota en esta caja de texto.
            columnCuota.setBackgroundColor(Color.parseColor("#fff682"));
            columnCuota.setPadding(30, 30, 30, 30);


            TextView columnInteres = new TextView(this);// Se crea una caja de texto.
            tr.addView(columnInteres);// Se añade esta caja de texto al TableRow.
            columnInteres.setText(moneda.format(interes_precio));// Se añade el valor del interés a esta caja de texto.
            columnInteres.setBackgroundColor(Color.parseColor("#fff682"));
            columnInteres.setPadding(30, 30, 30, 30);

            TextView columnCapital = new TextView(this);// Se crea una caja de texto.
            tr.addView(columnCapital);// Se añade esta caja de texto al TableRow.
            columnCapital.setText(moneda.format(capital_precio));// Se añade el valor del capital a esta caja de texto.
            columnCapital.setBackgroundColor(Color.parseColor("#fff682"));
            columnCapital.setPadding(30, 30, 30, 30);

            TextView columnAmortizado = new TextView(this);// Se crea una caja de texto.
            tr.addView(columnAmortizado);// Se añade esta caja de texto al TableRow.
            columnAmortizado.setText(moneda.format(capital_amortizado));// Se añade el valor del capital amortizado a esta caja de texto.
            columnAmortizado.setBackgroundColor(Color.parseColor("#8fe871"));
            columnAmortizado.setPadding(30, 30, 30, 30);


            TextView columnPendiente = new TextView(this);// Se crea una caja de texto.
            tr.addView(columnPendiente);// Se añade esta caja de texto al TableRow.
            columnPendiente.setText(moneda.format(capital));// Se añade el valor del capital pendiente a esta caja de texto.
            columnPendiente.setBackgroundColor(Color.parseColor("#8fe871"));
            columnPendiente.setPadding(30, 30, 30, 30);


        }


    }


}

