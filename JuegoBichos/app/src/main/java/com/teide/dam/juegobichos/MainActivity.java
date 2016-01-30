package com.teide.dam.juegobichos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentManager;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton jugar;
    private ImageButton salir;
    private ImageButton instrucciones;
    private RelativeLayout panelJuego;
    private TextView tituloPuntos;
    private TextView tituloVivos;
    public TextView puntos;
    private TextView vivos;
    private int puntosVuelta;
    private HiloJuego hiloJuego;
    private MediaPlayer empezar,aplasta,menuCancion;
    private int dificultad = 0;
    private int tiempoNivel = 1000;
    float volumenMaxAplasta = 100*.01f;
    private int perder = 0;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        jugar = (ImageButton) findViewById(R.id.jugar);
        salir = (ImageButton) findViewById(R.id.salir);
        instrucciones = (ImageButton) findViewById(R.id.instrucciones);
        panelJuego = (RelativeLayout) findViewById(R.id.panelJuego);
        puntos = (TextView) findViewById(R.id.puntos);
        vivos = (TextView) findViewById(R.id.vivos);
        tituloPuntos = (TextView) findViewById(R.id.TextView);
        tituloVivos = (TextView) findViewById(R.id.textView2);
        jugar.setOnClickListener(this);
        salir.setOnClickListener(this);
        instrucciones.setOnClickListener(this);

        menuCancion = MediaPlayer.create(this, R.raw.menusong);
        menuCancion.setLooping(true);
        menuCancion.start();

        cambiarFondo();



    }

    public void cambiarPerder(int num){

        perder = num;
    }

    public void cambiarFondo(){

        panelJuego.setBackgroundResource(R.drawable.menuimg);
        tituloPuntos.setVisibility(View.INVISIBLE);
        tituloVivos.setVisibility(View.INVISIBLE);
        vivos.setVisibility(View.INVISIBLE);
        puntos.setVisibility(View.INVISIBLE);
    }

    public void fondoJuego(){

        panelJuego.setBackgroundResource(R.drawable.cesped);
        tituloPuntos.setVisibility(View.VISIBLE);
        tituloVivos.setVisibility(View.VISIBLE);
        vivos.setVisibility(View.VISIBLE);
        puntos.setVisibility(View.VISIBLE);

    }

    public void metodoJugar(){

    empezar  = MediaPlayer.create(this,R.raw.boton);
    empezar.seekTo(50);
    empezar.start();
    menuCancion.stop();
    hiloJuego = new HiloJuego(this,panelJuego,vivos,puntos);
    TaskHelper.execute(hiloJuego);
    fondoJuego();


}

    public void metodoSalir(){

        empezar  = MediaPlayer.create(this,R.raw.boton);
        empezar.seekTo(50);
        empezar.start();
        menuCancion.stop();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        System.exit(0);
    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.jugar) {

            metodoJugar();

        } else if (v.getId() == R.id.salir) {
            metodoSalir();
        }

        else if (v.getId() == R.id.instrucciones){

            FragmentManager fragmentManager = getFragmentManager();
            DialogoInstrucciones dialogo = new DialogoInstrucciones();
            dialogo.show(fragmentManager,"tagInstruccion");


        }


        else{
            //panelJuego.removeView(v);
            if (perder ==0) {

               HiloImagen himg = new HiloImagen((ImageView) v, panelJuego);
                TaskHelper.execute(himg);

                if ((String.valueOf(v.getTag()).equals("bichoRojo"))){
                    tiempoNivel = tiempoNivel -20;
                    puntosVuelta = puntosVuelta+10;
                    puntos.setText(String.valueOf(puntosVuelta));

                }

                 if ((String.valueOf(v.getTag()).equals("insecticida"))){
                     tiempoNivel = tiempoNivel + 50;
                    panelJuego.removeAllViewsInLayout();
                     vivos.setText("0");
                     hiloJuego.cambiarVivos(1);

                  }

                else {
                    puntos.setText(String.valueOf(++puntosVuelta));
                }

                hiloJuego.hayMuerte();

                fondoJuego();


                dificultad = dificultad + 1;

                if (dificultad == 10) {
                    dificultad = 0;
                    tiempoNivel = tiempoNivel - 50;



                    if (tiempoNivel <= 100) tiempoNivel = 100;
                    hiloJuego.setTiempo(tiempoNivel);
                }


                if (aplasta != null) aplasta.release();
                aplasta = MediaPlayer.create(this, R.raw.aplastar);
                aplasta.setVolume(volumenMaxAplasta, volumenMaxAplasta);
                aplasta.start();


            }

        }





}


}



