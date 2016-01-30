package com.teide.dam.ruletahilos;

import android.os.AsyncTask;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 * Created by root on 8/01/16.
 */
public class HiloJuego extends AsyncTask<Void,Void, Void> {

    private ImageView imagen;
    private Button jugar;
    private TextView numero;


    public HiloJuego(ImageView imagen, Button jugar, TextView numero) {
        this.imagen = imagen;
        this.jugar = jugar;
        this.numero = numero;
    }

    @Override
    protected Void doInBackground(Void... params) {
        Random r = new Random();
        int tiempo = r.nextInt(6)+5;
        for (int i = 0; i<tiempo;i++){
            try {


                publishProgress();
                Thread.sleep(r.nextInt(251) + 250);
            }catch (Exception e){}

        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {

        ArrayList numNegros = new ArrayList();
        ArrayList numRojos = new ArrayList();

        //numeros Negros
        Integer num2 = new Integer(2);
        Integer num4 = new Integer(4);
        Integer num6 = new Integer(6);
        Integer num8 = new Integer(8);
        Integer num10 = new Integer(10);
        Integer num11 = new Integer(11);
        Integer num13 = new Integer(13);
        Integer num15 = new Integer(15);
        Integer num17 = new Integer(17);
        Integer num20 = new Integer(20);
        Integer num22 = new Integer(22);
        Integer num24 = new Integer(24);
        Integer num26 = new Integer(26);
        Integer num28 = new Integer(28);
        Integer num29 = new Integer(29);
        Integer num31 = new Integer(31);
        Integer num33 = new Integer(33);
        Integer num35 = new Integer(35);

        numNegros.add(num2);
        numNegros.add(num4);
        numNegros.add(num6);
        numNegros.add(num8);
        numNegros.add(num10);
        numNegros.add(num11);
        numNegros.add(num13);
        numNegros.add(num15);
        numNegros.add(num17);
        numNegros.add(num20);
        numNegros.add(num22);
        numNegros.add(num24);
        numNegros.add(num26);
        numNegros.add(num28);
        numNegros.add(num29);
        numNegros.add(num31);
        numNegros.add(num33);
        numNegros.add(num35);


        //numero Rojos
        Integer num1 = new Integer(1);
        Integer num3 = new Integer(3);
        Integer num5 = new Integer(5);
        Integer num7 = new Integer(7);
        Integer num9 = new Integer(9);
        Integer num12 = new Integer(12);
        Integer num14 = new Integer(14);
        Integer num16 = new Integer(16);
        Integer num18 = new Integer(18);
        Integer num19 = new Integer(19);
        Integer num21 = new Integer(21);
        Integer num23 = new Integer(23);
        Integer num25 = new Integer(25);
        Integer num27 = new Integer(27);
        Integer num30 = new Integer(30);
        Integer num32 = new Integer(32);
        Integer num34 = new Integer(34);
        Integer num36 = new Integer(36);

        numRojos.add(num1);
        numRojos.add(num3);
        numRojos.add(num5);
        numRojos.add(num7);
        numRojos.add(num9);
        numRojos.add(num12);
        numRojos.add(num14);
        numRojos.add(num16);
        numRojos.add(num18);
        numRojos.add(num19);
        numRojos.add(num21);
        numRojos.add(num23);
        numRojos.add(num25);
        numRojos.add(num27);
        numRojos.add(num30);
        numRojos.add(num32);
        numRojos.add(num34);
        numRojos.add(num36);


        Random rm = new Random();
        String negros = (numNegros.get(rm.nextInt(numNegros.size()))).toString();
        String rojos = (numRojos.get(rm.nextInt(numRojos.size()))).toString();


        super.onProgressUpdate(values);
        if (imagen.getTag() == null || imagen.getTag().toString().equals("rojo")) {
                numero.setText(negros);
                imagen.setImageResource(R.drawable.negro);
                imagen.setTag("negro");

        } else {
                numero.setText(rojos);
                imagen.setImageResource(R.drawable.rojo);
                imagen.setTag("rojo");
            }
        }



    @Override

    protected void onPreExecute(){
        super.onPreExecute();
        jugar.setEnabled(false);
    }

    protected void onPostExecute(Void aVoid){
        super.onPostExecute(aVoid);
        jugar.setEnabled(true);
    }

}
