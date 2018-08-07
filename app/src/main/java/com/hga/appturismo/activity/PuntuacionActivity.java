package com.hga.appturismo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.hga.appturismo.R;

/**
 * Created by HGA on 04/12/2017
 */

public class PuntuacionActivity extends AppCompatActivity {
    LinearLayout puntaje;
    CheckBox star;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_lugares);

        puntaje = findViewById(R.id.puntuacion);
        for (int i = 1; i <= 5; i++) {
            star = puntaje.findViewWithTag(String.valueOf(i));
            star.setOnClickListener(starsListener);
        }
    }
        private View.OnClickListener starsListener = new View.OnClickListener() {
        public void onClick(View view) {
            int tag = Integer.valueOf((String) view.getTag());
            System.out.println("Puntaje: "+tag);
            //desmarcar todas las  estrellas
            for (int i = 1; i <= 5; i++)  {
                star = puntaje.findViewWithTag(String.valueOf(i));
                star.setChecked(false);
            }
            //marcar los seleccionado
            for (int i = 1 ; i <= tag; i++) {
                star = puntaje.findViewWithTag(String.valueOf(i));
                star.setChecked(true);
            }

        }

    };
}