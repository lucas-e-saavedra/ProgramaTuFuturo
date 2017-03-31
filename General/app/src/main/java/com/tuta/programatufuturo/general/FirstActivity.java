package com.tuta.programatufuturo.general;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {
    EditText inputNombre;
    Spinner inputPronombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        inputNombre = (EditText) findViewById(R.id.et_nombre);
        inputPronombre = (Spinner) findViewById(R.id.sp_pronombre);
    }

    public void saludar(View v){
        String textoSaludo = "Hola "+inputPronombre.getSelectedItem().toString()+" "+inputNombre.getText().toString();
        new AlertDialog.Builder(this).setTitle(R.string.app_name).setMessage(textoSaludo)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                        startActivity(intent);
                    }
                }).create().show();
    }
}
