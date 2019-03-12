package com.example.hp.examenmdm;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.examenmdm.Entidades.Datos;

import java.util.ArrayList;

public class Adapteroperaciones extends ArrayAdapter {
    public Adapteroperaciones(Context context,  ArrayList<Datos> operacionesList) {
        super(context,0,operacionesList);

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.operaciones_row, parent, false
            );
        }

        TextView textViewName = convertView.findViewById(R.id.tvSNombre);

        Datos currentItem = (Datos) getItem(position);

        if (currentItem != null) {
            textViewName.setText(currentItem.getOpereciones());
        }

        return convertView;

    }

}
