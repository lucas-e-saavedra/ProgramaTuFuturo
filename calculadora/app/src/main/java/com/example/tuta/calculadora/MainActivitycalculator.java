package com.example.tuta.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivitycalculator extends AppCompatActivity {
    EditText ET_Peso;
    EditText ET_Altura;
    TextView TV_RESULTADO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activitycalculator);
        ET_Peso = (EditText) findViewById(R.id.I_Peso);
        ET_Altura = (EditText) findViewById(R.id.I_Altura);
        TV_RESULTADO = (TextView) findViewById(R.id.L_Resultado);
    }
    public void ActionCalcular (View Boton){
        String TextoPeso = ET_Peso.getText().toString();
        String TextoAltura = ET_Altura.getText().toString();
        float V_PESO = Float.parseFloat(TextoPeso);
        float V_ALTURA = Float.parseFloat(TextoAltura);
        float V_RESULTADO = V_PESO / (V_ALTURA*V_ALTURA);
        TV_RESULTADO.setText(String.valueOf(V_RESULTADO));
        if (V_RESULTADO < 19f) {
            TV_RESULTADO.setTextColor(getResources().getColor(R.color.Rojo));
        }
        else if (V_RESULTADO < 25f) {
            TV_RESULTADO.setTextColor(getResources().getColor(R.color.Verde));
        }
        else {
            TV_RESULTADO.setTextColor(getResources().getColor(R.color.Rojo));
        }
    }
}
