package com.tutacode.infonube;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.tutacode.infonube.data.APIArticulos;
import com.tutacode.infonube.data.AdapterArticulos;
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
    ListView listaDeArticulos;
    AdapterArticulos miAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unTextView = (TextView) findViewById(R.id.textView);
        unBoton =  (Button) findViewById(R.id.button);
        listaDeArticulos = (ListView) findViewById(R.id.listaArticulos);
        miAdapter = new AdapterArticulos(this);
        listaDeArticulos.setAdapter(miAdapter);
        unBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consultarListaDeArticulos();
            }
        });
    }

    void consultarListaDeArticulos() {
        unTextView.setText("consultando lista de articuos");
        unBoton.setVisibility(View.GONE);
        Log.d("ETIQUETA LOGS", "inicio la consulta de articulos");
        Retrofit RETRO=new Retrofit.Builder().baseUrl("https://script.google.com").addConverterFactory(GsonConverterFactory.create()).build();
        APIArticulos Interface = RETRO.create(APIArticulos.class);
        Interface.consultarListaDeArticulos().enqueue(new Callback<RespuestaConsultaDeArticulos>() {
            @Override
            public void onResponse(Call<RespuestaConsultaDeArticulos> call, Response<RespuestaConsultaDeArticulos> response) {
                unBoton.setVisibility(View.VISIBLE);
                RespuestaConsultaDeArticulos respuesta = response.body();
                unTextView.setText(respuesta.ultimaActualizacion);
                miAdapter.asignarItems(respuesta.contenido);
            }

            @Override
            public void onFailure(Call<RespuestaConsultaDeArticulos> call, Throwable t) {
                unBoton.setVisibility(View.VISIBLE);
                unTextView.setText("ERROR");
            }
        });

    }

}
