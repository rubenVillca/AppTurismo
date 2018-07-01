package com.hga.appturismo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hga.appturismo.R;

/**
 * Created by HGA on 30/6/2018
 */
public class BuscarPorTipoActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_por_tipo);

        initButton();
    }

    private void initButton() {

    }

    @Override
    public void onClick(View view) {

    }
}
