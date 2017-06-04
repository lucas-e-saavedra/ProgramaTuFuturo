package com.tutacode.infonube.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tutacode.infonube.R;

import java.util.List;

/**
 * Created by ChakaLaptop on 03-Jun-17.
 */

public class AdapterArticulos extends BaseAdapter{
    private Articulo[] misItems;
    private Context miContext;

    public AdapterArticulos(Context ctx){
        super();
        miContext = ctx;
    }

    public void asignarItems(Articulo[] items){
        misItems = items;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if(misItems == null){
            return 0;
        } else {
            return misItems.length;
        }
    }

    @Override
    public Articulo getItem(int position) {
        if(getCount()>position){
            return misItems[position];
        }else{
            return null;
        }
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View miCelda = LayoutInflater.from(miContext).inflate(R.layout.celda_articulo, parent, false);

        ImageView imagen = (ImageView) miCelda.findViewById(R.id.imagenArticulo);
        TextView nombre = (TextView) miCelda.findViewById(R.id.nombreArticulo);
        TextView precio = (TextView) miCelda.findViewById(R.id.precioArticulo);

        Articulo miArticulo = getItem(position);

        imagen.setImageResource(R.mipmap.ic_launcher);
        nombre.setText(miArticulo.Descripcion);
        precio.setText(miArticulo.Color);

        return miCelda;
    }
}
