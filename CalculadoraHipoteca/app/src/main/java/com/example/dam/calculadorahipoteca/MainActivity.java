package com.example.dam.calculadorahipoteca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity implements View.OnClickListener{

    private EditText et,eti,ett;
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         et = (EditText) findViewById(R.id.et1);
         eti =(EditText) findViewById(R.id.eti);
         ett = (EditText) findViewById(R.id.ett);


         btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

            double capital = Double.parseDouble(et.getText().toString().trim());
            double interes = ((Double.parseDouble(eti.getText().toString().trim())) / 100) / 12;
            double tiempo = Double.parseDouble(ett.getText().toString().trim()) * 12;
            double cuota = (capital * interes) / (1 - Math.pow((1 + interes),-tiempo));



            Intent i = new Intent(this, MainActivity2.class);
            i.putExtra("capital",capital);
            i.putExtra("tiempo", tiempo);
            i.putExtra("cuota", cuota);
            i.putExtra("interes", interes);
            startActivity(i);


    }




  /*
  * cuota = (capital*interes)/1-(1+interes)^-tiempo
  *
  *
  * */
}
