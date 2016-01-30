package com.teide.dam.juegobichos;

import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by Victor on 21/01/2016.
 */
public class HiloImagen extends AsyncTask<Void, Void, Integer> {


        private ImageView mancha;

        private RelativeLayout panelJuego;

        private int var = 0;


        public HiloImagen(ImageView mancha, RelativeLayout panelJuego) {

            this.mancha = mancha;
            this.panelJuego = panelJuego;

        }

        @Override
        protected Integer doInBackground(Void... params) {

            try {
                var = 1;
                publishProgress();
                Thread.sleep(50);

                var = 5;
                publishProgress();

                var = 2;
                publishProgress();
                Thread.sleep(50);

                var = 5;
                publishProgress();

                var = 3;
                publishProgress();
                Thread.sleep(50);

                var = 5;
                publishProgress();

                var = 4;
                publishProgress();
                Thread.sleep(50);

                var = 5;
                publishProgress();


            } catch (Exception e){}




            return null;
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            mancha.setClickable(false);



        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);



        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);


         if (var == 1)  {
             mancha.setImageResource(R.drawable.mancha);
             mancha.setImageAlpha(500);
         }


           if (var == 2)  {
                mancha.setImageResource(R.drawable.mancha);
                mancha.setImageAlpha(350);
            }


            if (var == 3)  {
                mancha.setImageResource(R.drawable.mancha);
                mancha.setImageAlpha(200);
            }


            if (var == 4)  {
                mancha.setImageResource(R.drawable.mancha);
                mancha.setImageAlpha(50);
            }


            if (var == 5) panelJuego.removeView(mancha);


        }




    }



