package com.tutacode.listas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView tvNombrePasajero =  (TextView) findViewById(R.id.tvNombrePasajero);
        tvNombrePasajero.setText(getIntent().getStringExtra("nombre"));
    }
}
