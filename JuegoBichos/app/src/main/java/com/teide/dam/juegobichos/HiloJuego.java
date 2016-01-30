package com.teide.dam.juegobichos;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by root on 12/01/16.
 */
public class HiloJuego extends AsyncTask < Void, Void, Integer >{

    private MainActivity activity;
    private RelativeLayout panelJuego;
    private TextView puntos;
    private TextView vivos;
    private int numVivos, alto, ancho;
    private static final int MAX = 15;
    private Random r = new Random();
    private int tiempo = 900;
    private int contadorPuntos = 0;
    private int contadorInsecicida = 0;
    private  MediaPlayer musicaFondo,gameover;

    private ImageView bicho;
    private ImageView bicho2;
    private ImageView insecticida;
    float volumenMaxFondo = 70;




    public HiloJuego(MainActivity activity,RelativeLayout panelJuego, TextView vivos, TextView puntos) {
        this.activity = activity;
        this.panelJuego = panelJuego;
        this.vivos = vivos;
        this.puntos = puntos;


    }

    @Override
    protected Integer doInBackground(Void... params) {
        Random r = new Random();
        while (numVivos < MAX){
            try {
                publishProgress();
                Thread.sleep(tiempo);
            }catch (Exception e){}



        }


        activity.cambiarPerder(1);

        musicaFondo.release();

        if (gameover != null)  gameover.release();
        gameover = MediaPlayer.create(activity, R.raw.gameover);
        gameover.seekTo(1000);
        gameover.start();

        try {

            publishProgress();
            Thread.sleep(2500);
        }catch (Exception e){}

        return null;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //jugar.setVisibility(View.INVISIBLE);

           vivos.setText("0");
           panelJuego.removeAllViews();
           ancho = panelJuego.getWidth();
           alto = panelJuego.getHeight();
           if (musicaFondo != null) musicaFondo.release();
           musicaFondo = MediaPlayer.create(activity, R.raw.musica);
           musicaFondo.setLooping(true);
           musicaFondo.setVolume(volumenMaxFondo, volumenMaxFondo);
           musicaFondo.start();


    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);

       /*if (gameover != null) gameover.release();
        gameover = MediaPlayer.create(activity, R.raw.fondover);
        gameover.start();*/

        Intent i = new Intent(activity, ResultadoActivity.class);
        i.putExtra("puntos", Integer.parseInt(puntos.getText().toString().trim()));
        activity.startActivity(i);

        panelJuego.removeAllViews();


    }


    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);

        contadorPuntos = r.nextInt(10)+1;
        contadorInsecicida = r.nextInt(10);

        if (Integer.parseInt(puntos.getText().toString().trim()) <= 10)contadorPuntos = 1;


        if (7 <  contadorPuntos) {
            int a = r.nextInt(ancho - 130) + 10;
            int b = r.nextInt(alto - 130) + 10;

            bicho2 = new ImageView(activity);
            bicho2.setImageResource(R.drawable.bugdos);
            bicho2.setTag("bichoRojo");
            bicho2.setX(a);
            bicho2.setY(b);
            bicho2.setOnClickListener(activity);
            panelJuego.addView(bicho2);
            numVivos++;
            vivos.setText(String.valueOf(numVivos));
        }

         else if ((Integer.parseInt(puntos.getText().toString().trim()) > 150) && 8 < contadorInsecicida){

            int c = r.nextInt(ancho - 130) + 10;
            int d = r.nextInt(alto - 130) + 10;

            insecticida = new ImageView(activity);
            insecticida.setImageResource(R.drawable.insecticida);
            insecticida.setTag("insecticida");
            insecticida.setX(c);
            insecticida.setY(d);
            insecticida.setOnClickListener(activity);
             panelJuego.addView(insecticida);


        }

        else{
            int x = r.nextInt(ancho - 130) + 10;
            int y = r.nextInt(alto - 130) + 10;

            bicho = new ImageView(activity);
            bicho.setImageResource(R.drawable.bug);
            bicho.setX(x);
            bicho.setY(y);
            bicho.setOnClickListener(activity);
            panelJuego.addView(bicho);
            numVivos++;
            vivos.setText(String.valueOf(numVivos));

        }


        if ( Integer.parseInt(vivos.getText().toString().trim()) >= 13)   vivos.setTextColor(Color.RED);
        if ( Integer.parseInt(vivos.getText().toString().trim()) < 13)   vivos.setTextColor(Color.parseColor("#e6ff00"));



    }

    public void setTiempo(int tiempo){
            this.tiempo = tiempo;

    }

    public void hayMuerte() {
        vivos.setText(String.valueOf(--numVivos));

    }

    public void cambiarVivos(int vivosCero){

        numVivos = vivosCero;
    }

    }


