package com.tutacode.infonube;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.tutacode.infonube.data.APIArticulos;
import com.tutacode.infonube.data.RespuestaConsultaDeArticulos;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView unTextView;
    Button unBoton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unTextView = (TextView) findViewById(R.id.textView);
        unBoton =  (Button) findViewById(R.id.button);
        unBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consultarListaDeArticulos();
            }
        });
    }

    void consultarListaDeArticulos(){
        Log.d("ETIQUETA LOGS","inicio la consulta de articulos");
        unBoton.setVisibility(View.GONE);
        APIArticulos apiArticulos = APIArticulos.retrofit.create(APIArticulos.class);
        apiArticulos.consultarListaDeArticulos().enqueue(new Callback<RespuestaConsultaDeArticulos>() {
            @Override
            public void onResponse(Call<RespuestaConsultaDeArticulos> call, Response<RespuestaConsultaDeArticulos> response) {
                unBoton.setVisibility(View.VISIBLE);
                RespuestaConsultaDeArticulos respuesta = response.body();
                unTextView.setText(respuesta.ultimaActualizacion);
            }

            @Override
            public void onFailure(Call<RespuestaConsultaDeArticulos> call, Throwable t) {
                unBoton.setVisibility(View.VISIBLE);
                unTextView.setText("ERROR");
            }
        });

    }
}
