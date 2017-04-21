package com.tutacode.listas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> adapterPersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listViewPersonas = (ListView) findViewById(R.id.lvPersonas);
        adapterPersonas = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, consultarPersonas());
        listViewPersonas.setAdapter(adapterPersonas);

        listViewPersonas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent detalle = new Intent(MainActivity.this, DetailActivity.class);
                detalle.putExtra("nombre", adapterPersonas.getItem(i));
                startActivity(detalle);
            }
        });
        listViewPersonas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                String unaPersona = adapterPersonas.getItem(i);
                adapterPersonas.remove(unaPersona);
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mnu_listapersonas, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.mnu_add){
            adapterPersonas.addAll(consultarPersonas());
            return true;
        }
        if(item.getItemId() == R.id.mnu_clear){
            adapterPersonas.clear();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /*String[] consultarPersonas(){
                String[] listaDePersonas = new String[10];
                listaDePersonas[0] = "Alan";
                listaDePersonas[1] = "Belen";
                listaDePersonas[2] = "Carlos";
                listaDePersonas[3] = "David";
                listaDePersonas[4] = "Elena";
                listaDePersonas[5] = "Fernanda";
                listaDePersonas[6] = "Gonzalo";
                listaDePersonas[7] = "Hector";
                listaDePersonas[8] = "Ines";
                listaDePersonas[9] = "Jaime";
                return listaDePersonas;
            }*/
    List<String> consultarPersonas(){
        List<String> listaDePersonas = new ArrayList<>();
        listaDePersonas.add("Alan");
        listaDePersonas.add("Belen");
        listaDePersonas.add("Carlos");
        listaDePersonas.add("David");
        listaDePersonas.add("Elena");
        listaDePersonas.add("Fernanda");
        listaDePersonas.add("Gonzalo");
        listaDePersonas.add("Hector");
        listaDePersonas.add("Ines");
        listaDePersonas.add("Jaime");
        return listaDePersonas;
    }
}
