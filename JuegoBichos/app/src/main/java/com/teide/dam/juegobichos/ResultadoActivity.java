package com.teide.dam.juegobichos;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class ResultadoActivity extends Activity implements View.OnClickListener{

    private MediaPlayer fondoSong;
    private TextView puntuacion;
    private ImageButton jugarNuevo;
    private ImageView salir;

    private Integer puntosFinales;
    private MediaPlayer sonidoJugar, sonidoSalir;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_resultado);



        puntuacion = (TextView)findViewById(R.id.puntuacion);
        jugarNuevo = (ImageButton)findViewById(R.id.playAgain);
        salir = (ImageButton)findViewById(R.id.salir);
        jugarNuevo.setOnClickListener(this);
        salir.setOnClickListener(this);

        //puntuacion.setText(String.valueOf(puntos));


        puntosFinales = getIntent().getIntExtra("puntos",0);

        puntuacion.setText(String.valueOf(puntosFinales));

        fondoSong = MediaPlayer.create(this, R.raw.fondover);
        fondoSong.setLooping(true);
        fondoSong.start();


        this.setFinishOnTouchOutside(false);



    }



    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.playAgain){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);

            sonidoJugar =  MediaPlayer.create(this,R.raw.menu);
            sonidoJugar.start();
            fondoSong.stop();

        }else{

            sonidoSalir = MediaPlayer.create(this,R.raw.exit);
            sonidoSalir.start();

            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            System.exit(0);

        }

}


}

