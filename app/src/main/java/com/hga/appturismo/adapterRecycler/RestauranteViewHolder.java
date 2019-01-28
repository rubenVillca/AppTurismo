package com.hga.appturismo.adapterRecycler;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hga.appturismo.R;

class RestauranteViewHolder extends RecyclerView.ViewHolder {
    public TextView nameCardView;
    public ImageView imageCardView;
    public FloatingActionButton btn_editar;
    public FloatingActionButton btn_eliminar;
    public CheckBox estrella1;
    public CheckBox estrella2;
    public CheckBox estrella3;
    public CheckBox estrella4;
    public CheckBox estrella5;
    public TextView promedio;
    public LinearLayout layoutEstrellas;

    public RestauranteViewHolder(View itemView) {
        super(itemView);
        nameCardView = itemView.findViewById(R.id.nameCardView);
        imageCardView = itemView.findViewById(R.id.imageCardView);
        btn_editar = itemView.findViewById(R.id.btn_editar);
        btn_eliminar = itemView.findViewById(R.id.btn_eliminar);
        estrella1 = itemView.findViewById(R.id.star1);
        estrella2 = itemView.findViewById(R.id.star2);
        estrella3 = itemView.findViewById(R.id.star3);
        estrella4 = itemView.findViewById(R.id.star4);
        estrella5 = itemView.findViewById(R.id.star5);
        promedio = itemView.findViewById(R.id.promedioCardView);
        layoutEstrellas = itemView.findViewById(R.id.calificacion);
    }
}