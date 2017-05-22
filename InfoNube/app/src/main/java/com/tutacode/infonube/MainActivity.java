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
import com.tutacode.infonube.data.Articulo;
import com.tutacode.infonube.data.RespuestaConsultaDeArticulos;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

    void consultarListaDeArticulos() {
        unTextView.setText("consultando lista de articuos");
        Log.d("ETIQUETA LOGS", "inicio la consulta de articulos");
        Retrofit RETRO=new Retrofit.Builder().baseUrl("https://script.google.com").addConverterFactory(GsonConverterFactory.create()).build();
        APIArticulos Interface = RETRO.create(APIArticulos.class);
        Interface.consultarListaDeArticulos().enqueue(new Callback<RespuestaConsultaDeArticulos>() {
            @Override
            public void onResponse(Call<RespuestaConsultaDeArticulos> call, Response<RespuestaConsultaDeArticulos> response) {
                unTextView.setText(response.body().ultimaActualizacion);
                Articulo[] Art = response.body().contenido;
                if (Art.length < 3){
                    unTextView.setText("La lista tiene mas de 3 articulos");
                }
                else {
                    unTextView.setText("hay mas de 3");
                }
            }

            @Override
            public void onFailure(Call<RespuestaConsultaDeArticulos> call, Throwable t) {
                unTextView.setText("Hiciste cagada");
            }
        });

    }

}
