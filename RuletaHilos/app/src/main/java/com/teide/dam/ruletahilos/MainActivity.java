package com.teide.dam.ruletahilos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView imagen;
    private Button jugar;
    private TextView numero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        imagen = (ImageView) findViewById(R.id.imagen);
        jugar = (Button) findViewById(R.id.jugar);
        numero = (TextView) findViewById(R.id.numero);
    }

    public void jugar (View v){

    HiloJuego hj = new HiloJuego(imagen,jugar,numero);
        hj.execute();

    }
}
