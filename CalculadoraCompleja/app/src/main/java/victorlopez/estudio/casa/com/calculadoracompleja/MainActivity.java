package victorlopez.estudio.casa.com.calculadoracompleja;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    ArrayList<String> arrayList = new ArrayList<String>();
    String string1 = "";
    String string2 = "";

    public void onClick1(View vista1) {

        TextView textView3 = (TextView) findViewById(R.id.textView3);
        Button button = (Button) vista1;
        string1 = (String) button.getText().toString();
        if (!string1.contains("+") && !string1.contains("-") && !string1.contains("*") && !string1.contains("/")) {

            string2 = string1 + string2;

            if (arrayList.size() > 0) {

                arrayList.remove((arrayList.size() - 1));
            }

            arrayList.add(string2);
        } else {

            arrayList.add(string1);
            arrayList.add(string1);
            string2 = "";

        }

        //textView3.setText(textView3.getText().toString()+string1);
        textView3.setText(arrayList.toString());
    }


    public void onClick(View vista2) {

        TextView textView2 = (TextView) findViewById(R.id.textView5);

        int calc = 0;
        int c = arrayList.size();

        while (c != -1) {

            if (c > 3) {
                if (arrayList.get(3).contains("*") || arrayList.get(3).contains("/")) {

                    if (arrayList.get(3).contains("*")) {
                        calc = Integer.parseInt(arrayList.get(2)) * Integer.parseInt(arrayList.get(4));
                    }
                    if (arrayList.get(3).contains("/")) {
                        calc = Integer.parseInt(arrayList.get(2)) / Integer.parseInt(arrayList.get(4));
                    }

                    arrayList.remove(2);
                    arrayList.remove(2);
                    arrayList.remove(2);
                    arrayList.add(2, Integer.toString(calc));
                    c = arrayList.size();
                } else {

                    if (arrayList.get(1).contains("+")) {
                        calc = Integer.parseInt(arrayList.get(0)) + Integer.parseInt(arrayList.get(2));
                    }

                    if (arrayList.get(1).contains("-")) {
                        calc = Integer.parseInt(arrayList.get(0)) - Integer.parseInt(arrayList.get(2));
                    }
                    if (arrayList.get(1).contains("*")) {
                        calc = Integer.parseInt(arrayList.get(0)) * Integer.parseInt(arrayList.get(2));
                    }
                    if (arrayList.get(1).contains("/")) {
                        calc = Integer.parseInt(arrayList.get(0)) / Integer.parseInt(arrayList.get(2));
                    }

                    arrayList.remove(0);
                    arrayList.remove(0);
                    arrayList.remove(0);
                    arrayList.add(0, Integer.toString(calc));
                    c = arrayList.size();
                }


            } else {

                if (arrayList.get(1).contains("+")) {
                    calc = Integer.parseInt(arrayList.get(0)) + Integer.parseInt(arrayList.get(2));
                }

                if (arrayList.get(1).contains("-")) {
                    calc = Integer.parseInt(arrayList.get(0)) - Integer.parseInt(arrayList.get(2));
                }
                if (arrayList.get(1).contains("*")) {
                    calc = Integer.parseInt(arrayList.get(0)) * Integer.parseInt(arrayList.get(2));
                }
                if (arrayList.get(1).contains("/")) {
                    calc = Integer.parseInt(arrayList.get(0)) / Integer.parseInt(arrayList.get(2));
                }

                arrayList.remove(0);
                arrayList.remove(0);
                arrayList.remove(0);
                arrayList.add(0, Integer.toString(calc));
                c = arrayList.size();
            }
        }

        textView2.setText(Integer.toString(calc));
    }

    public void limpiar (View vistas){

        TextView textView3 = (TextView)findViewById(R.id.textView3);
        TextView textView5 = (TextView)findViewById(R.id.textView5);

        string1 = "";
        string2 = "";
        textView3.setText("");
        textView5.setText("0");
        arrayList.clear();
    }
}