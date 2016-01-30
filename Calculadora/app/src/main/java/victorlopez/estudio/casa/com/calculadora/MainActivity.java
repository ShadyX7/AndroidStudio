package victorlopez.estudio.casa.com.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText txtn1, txtn2;
    Button btnS, btnR, btnD, btnM;
    TextView txtR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtn1 = (EditText) findViewById(R.id.txtn1);
        txtn2 = (EditText) findViewById(R.id.txtn2);
        btnS = (Button) findViewById(R.id.btnSuma);
        btnR = (Button) findViewById(R.id.btnResta);
        btnD = (Button) findViewById(R.id.btnDiv);
        btnM = (Button) findViewById(R.id.btnMulti);
        txtR = (TextView) findViewById(R.id.txtRes);

        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(txtn1.getText().toString());
                int num2 = Integer.parseInt(txtn2.getText().toString());
                int resS = num1 + num2;
                txtR.setText("Resultado: " + resS);

            }
        });

        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(txtn1.getText().toString());
                int num2 = Integer.parseInt(txtn2.getText().toString());
                int resR = num1 - num2;
                txtR.setText("Resultado: " + resR);

            }
        });

        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(txtn1.getText().toString());
                int num2 = Integer.parseInt(txtn2.getText().toString());
                int resM = num1 * num2;
                txtR.setText("Resultado: " + resM);

            }
        });

        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(txtn1.getText().toString());
                int num2 = Integer.parseInt(txtn2.getText().toString());
                int resD = num1 / num2;
                txtR.setText("Resultado: " + resD);

            }
        });


    }


}
