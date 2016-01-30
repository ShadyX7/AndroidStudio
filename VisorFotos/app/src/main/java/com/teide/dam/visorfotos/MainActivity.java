package com.teide.dam.visorfotos;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.IllegalFormatCodePointException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btnAtras, btnAdelante;
    private ImageView imageView;
    public int[] imagenes = {R.drawable.slimshadylp, R.drawable.eminemshow, R.drawable.encore, R.drawable.relapse,R.drawable.recovery, R.drawable.mmlp2};
    private int posicion = 0, posicionFinal = imagenes.length -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAtras = (ImageButton) findViewById(R.id.btnAtras);
        btnAdelante = (ImageButton) findViewById(R.id.btnAdelante);
        imageView = (ImageView) findViewById(R.id.imageView);
        btnAtras.setOnClickListener(this);
        btnAdelante.setOnClickListener(this);


        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (posicion <= 0) {
                    posicion = posicionFinal;
                } else {
                    posicion = posicion - 1;
                }


                imageView.setImageResource(imagenes[posicion]);

            }
        });



    btnAdelante.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
                    if (posicion >= posicionFinal) {

                        posicion = 0;

                    } else {
                        posicion = posicion + 1;
                    }


                    imageView.setImageResource(imagenes[posicion]);

                }
            });

        }

    @Override
    public void onClick(View v) {

    }
}




