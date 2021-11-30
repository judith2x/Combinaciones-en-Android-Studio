package com.example.combinaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText objetoselegidos, numeroelementos;
    Button botonlimpiar, botoncalcular;
    TextView resultadocombinacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objetoselegidos=(EditText)findViewById(R.id.objetoselegidos);
        numeroelementos=(EditText)findViewById(R.id.numeroelementos);
        resultadocombinacion=(TextView)findViewById(R.id.resultadocombinacion);
        botoncalcular=(Button)findViewById(R.id.botoncalcular);
        botoncalcular.setOnClickListener(this);
        botonlimpiar=(Button)findViewById(R.id.botonlimpiar);
        botonlimpiar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.botoncalcular:
                int numobjetos=Integer.valueOf(objetoselegidos.getText().toString());
                int numtotal=Integer.valueOf(numeroelementos.getText().toString());
                if(numobjetos>=numtotal){
                    Toast.makeText(this, "El número de objetos seleccionados no puede ser igual o mayor que el número total de elementos", Toast.LENGTH_LONG).show();
                }else{

                    double factorialden=1;
                    for(int i=1; i<=numtotal; i++){
                        factorialden=i*factorialden;
                    }

                    double factorialdek=1;
                    for(int i=1; i<=numobjetos; i++){
                        factorialdek=i*factorialdek;
                    }

                    int totalitoderesta=numtotal-numobjetos;
                    double factorialdetotalitoderesta=1;
                    for(int i=1; i<=totalitoderesta; i++){
                        factorialdetotalitoderesta=i*factorialdetotalitoderesta;
                    }

                    double multiplicaciontotales=factorialdek*factorialdetotalitoderesta;
                    double resultadofactorial= factorialden/multiplicaciontotales;
                    resultadocombinacion.setText("EL RESULTADO DE LA COMBINACIÓN ES: "+resultadofactorial);
                }
                break;
            case R.id.botonlimpiar:
                resultadocombinacion.setText("");
                numeroelementos.setText("");
                objetoselegidos.setText("");
                break;
        }
    }
}
