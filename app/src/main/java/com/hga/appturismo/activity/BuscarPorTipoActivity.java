package com.hga.appturismo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

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
        Button buttonSitiosNaturales = findViewById(R.id.btn_sitiosNaturales);
        buttonSitiosNaturales.setOnClickListener(this);

        Button buttonPatrimonio_Urbano = findViewById(R.id.btn_patrimonioUrbano);
        buttonPatrimonio_Urbano.setOnClickListener(this);

        Button buttonEtnografia = findViewById(R.id.btn_etnografia);
        buttonEtnografia.setOnClickListener(this);

        Button buttonRealizacioneTecnicas = findViewById(R.id.btn_realizacioneTecnicas);
        buttonRealizacioneTecnicas.setOnClickListener(this);

        Button buttonAcontecimientosPro = findViewById(R.id.btn_acontecimientosPro);
        buttonAcontecimientosPro.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(this,ListaLugaresActivity.class);

        int idTipo=view.getId();
        switch (idTipo){
            case R.id.btn_sitiosNaturales:
                intent.putExtra("lugarSeleccionado",getString(R.string.tipo_sitios_naturales));
                intent.putExtra("isProvincia",false);
                break;
            case R.id.btn_patrimonioUrbano:
                intent.putExtra("lugarSeleccionado",getString(R.string.tipo_patrimonio_urbano));
                intent.putExtra("isProvincia",false);
                break;
            case R.id.btn_etnografia:
                intent.putExtra("lugarSeleccionado",getString(R.string.tipo_etnografia_folklore));
                intent.putExtra("isProvincia",false);
                break;
            case R.id.btn_realizacioneTecnicas:
                intent.putExtra("lugarSeleccionado",getString(R.string.tipo_realizaciones_tecnicas_cientificas));
                intent.putExtra("isProvincia",false);
                break;
            case R.id.btn_acontecimientosPro:
                intent.putExtra("lugarSeleccionado", getString(R.string.tipo_acontecimientos_programados));
                intent.putExtra("isProvincia",false);
                break;
                default: break;
        }
        startActivity(intent);
    }
}
