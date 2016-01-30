package com.example.dam.calculadorahipoteca;


import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity2 extends Activity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TableLayout tl = (TableLayout) findViewById(R.id.tl);


        double capital = getIntent().getDoubleExtra("capital",0);
        double interes = getIntent().getDoubleExtra("interes",0);
        double interesProp,capitalPagado,capAux,capRes;
        capRes=capital;capAux=0;
        double cuota= getIntent().getDoubleExtra("cuota",0);
        int tiempo = (int) getIntent().getDoubleExtra("tiempo",0);

        for (int i =0; i<tiempo; i++){
            TableRow tr = new TableRow(this);
            tl.addView(tr);

            TextView tvT = new TextView(this);
            tvT.setText(Integer.toString(i));
            tr.addView(tvT);

            TextView tvC  =new TextView(this);
            tr.addView(tvC);
            tvC.setText(Double.toString(cuota));


            interesProp=capRes*interes;

            TextView tvI= new TextView(this);
            tr.addView(tvI);
            tvI.setText(Double.toString(interesProp));


            capitalPagado=cuota-interesProp;
            capAux+=capitalPagado;
            capRes-=capitalPagado;


            TextView tvCap = new TextView(this);
            tr.addView(tvCap);
            tvCap.setText(Double.toString(capital));


            TextView tvCaAm = new TextView(this);
            tr.addView(tvCaAm);
            tvCaAm.setText(Double.toString(capAux));


            EditText caRes=new EditText(this);
            tr.addView(caRes);
            caRes.setText(Double.toString(capRes));




        }

    }


}





