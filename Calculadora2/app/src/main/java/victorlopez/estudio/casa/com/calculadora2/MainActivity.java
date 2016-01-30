package victorlopez.estudio.casa.com.calculadora2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    Double num1, num2, resul;
    String operador;

    public void onClickIgual(View miView) {
        TextView tv = (TextView) findViewById(R.id.txtNumero);
        num2 = Double.parseDouble(tv.getText().toString());

        if (operador.equals("+")) {
            resul = num1 + num2;
        } else if (operador.equals("-")) {
            resul = num1 - num2;
        } else if (operador.equals("*")) {
            resul = num1 * num2;
        } else if (operador.equals("/")) {
            resul = num1 / num2;
        }
        tv.setText(resul.toString());
    }


    public void onClickSuma(View miView) {
        operador = "+";
        onClickOperacionCapturaNumero1(miView);
    }

    public void onClickResta(View miView) {
        operador = "-";
        onClickOperacionCapturaNumero1(miView);
    }

    public void onClickMultiplicacion(View miView) {
        operador = "*";
        onClickOperacionCapturaNumero1(miView);
    }

    public void onClickDivision(View miView) {
        operador = "/";
        onClickOperacionCapturaNumero1(miView);
    }


    public void onClickOperacionCapturaNumero1(View miView) {
        TextView tv = (TextView) findViewById(R.id.txtNumero);
        num1 = Double.parseDouble(tv.getText().toString());
        tv.setText("");
    }


    public void onClickLimpia(View miView) {
        num1 = 0.0;
        num2 = 0.0;
        TextView tv = (TextView) findViewById(R.id.txtNumero);
        tv.setText("");
    }


    public void onClickBtn1(View miView) {
        TextView tv = (TextView) findViewById(R.id.txtNumero);
        tv.setText(tv.getText() + "1");
    }

    public void onClickBtn2(View miView) {
        TextView tv = (TextView) findViewById(R.id.txtNumero);
        tv.setText(tv.getText() + "2");
    }

    public void onClickBtn3(View miView) {
        TextView tv = (TextView) findViewById(R.id.txtNumero);
        tv.setText(tv.getText() + "3");
    }

    public void onClickBtn4(View miView) {
        TextView tv = (TextView) findViewById(R.id.txtNumero);
        tv.setText(tv.getText() + "4");
    }

    public void onClickBtn5(View miView) {
        TextView tv = (TextView) findViewById(R.id.txtNumero);
        tv.setText(tv.getText() + "5");
    }

    public void onClickBtn6(View miView) {
        TextView tv = (TextView) findViewById(R.id.txtNumero);
        tv.setText(tv.getText() + "6");
    }

    public void onClickBtn7(View miView) {
        TextView tv = (TextView) findViewById(R.id.txtNumero);
        tv.setText(tv.getText() + "7");
    }

    public void onClickBtn8(View miView) {
        TextView tv = (TextView) findViewById(R.id.txtNumero);
        tv.setText(tv.getText() + "8");
    }

    public void onClickBtn9(View miView) {
        TextView tv = (TextView) findViewById(R.id.txtNumero);
        tv.setText(tv.getText() + "9");
    }

    public void onClickBtn0(View miView) {
        TextView tv = (TextView) findViewById(R.id.txtNumero);
        tv.setText(tv.getText() + "0");
    }

    public void onClickBtnPunto(View miView) {
        TextView tv = (TextView) findViewById(R.id.txtNumero);
        tv.setText(tv.getText() + ".");
    }

}
