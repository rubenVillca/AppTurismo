package com.hga.appturismo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hga.appturismo.R;
import com.hga.appturismo.util.Constants;

public class BuscarPorProvinciaActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_por_provincia);

        initButton();
    }

    private void initButton() {
        Button btnProvinciaArani = findViewById(R.id.btnProvinciaArani);
        btnProvinciaArani.setOnClickListener(this);

        Button btnProvinciaArque = findViewById(R.id.btnProvinciaArque);
        btnProvinciaArque.setOnClickListener(this);

        Button btnProvinciaAyopaya = findViewById(R.id.btnProvinciaAyopaya);
        btnProvinciaAyopaya.setOnClickListener(this);

        Button btnProvinciaBolivar = findViewById(R.id.btnProvinciaBolivar);
        btnProvinciaBolivar.setOnClickListener(this);

        Button btnProvinciaCampero = findViewById(R.id.btnProvinciaCampero);
        btnProvinciaCampero.setOnClickListener(this);

        Button btnProvinciaCapinota = findViewById(R.id.btnProvinciaCapinota);
        btnProvinciaCapinota.setOnClickListener(this);

        Button btnProvinciaCercado = findViewById(R.id.btnProvinciaCercado);
        btnProvinciaCercado.setOnClickListener(this);

        Button btnProvinciaChapare = findViewById(R.id.btnProvinciaChapare);
        btnProvinciaChapare.setOnClickListener(this);

        Button btnProvinciaEstebanArze = findViewById(R.id.btnProvinciaEstebanArze);
        btnProvinciaEstebanArze.setOnClickListener(this);

        Button btnProvinciaGermanJordan = findViewById(R.id.btnProvinciaGermanJordan);
        btnProvinciaGermanJordan.setOnClickListener(this);

        Button btnProvinciaJoseCarrasco = findViewById(R.id.btnProvinciaJoseCarrasco);
        btnProvinciaJoseCarrasco.setOnClickListener(this);

        Button btnProvinciaMizque = findViewById(R.id.btnProvinciaMizque);
        btnProvinciaMizque.setOnClickListener(this);

        Button btnProvinciaPunata = findViewById(R.id.btnProvinciaPunata);
        btnProvinciaPunata.setOnClickListener(this);

        Button btnProvinciaQuillacollo = findViewById(R.id.btnProvinciaQuillacollo);
        btnProvinciaQuillacollo.setOnClickListener(this);

        Button btnProvinciaTapacari = findViewById(R.id.btnProvinciaTapacari);
        btnProvinciaTapacari.setOnClickListener(this);

        Button btnProvinciaTiraque = findViewById(R.id.btnProvinciaTiraque);
        btnProvinciaTiraque.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this,ListaLugaresActivity.class);

        int idProvincia=v.getId();
        switch (idProvincia){
            case R.id.btnProvinciaArani:
                intent.putExtra("lugarSeleccionado", Constants.FIREBASE_PROVINCIA_ARANI);
                intent.putExtra("isProvincia",true);
                break;
            case R.id.btnProvinciaArque:
                intent.putExtra("lugarSeleccionado",Constants.FIREBASE_PROVINCIA_ARQUE);
                intent.putExtra("isProvincia",true);
                break;
            case R.id.btnProvinciaAyopaya:
                intent.putExtra("lugarSeleccionado",Constants.FIREBASE_PROVINCIA_AYOPAYA);
                intent.putExtra("isProvincia",true);
                break;
            case R.id.btnProvinciaBolivar:
                intent.putExtra("lugarSeleccionado",Constants.FIREBASE_PROVINCIA_BOLIVAR);
                intent.putExtra("isProvincia",true);
                break;
            case R.id.btnProvinciaCampero:
                intent.putExtra("lugarSeleccionado",Constants.FIREBASE_PROVINCIA_CAMPERO);
                intent.putExtra("isProvincia",true);
                break;
            case R.id.btnProvinciaCapinota:
                intent.putExtra("lugarSeleccionado",Constants.FIREBASE_PROVINCIA_CAPINOTA);
                intent.putExtra("isProvincia",true);
                break;
            case R.id.btnProvinciaCercado:
                intent.putExtra("lugarSeleccionado",Constants.FIREBASE_PROVINCIA_CERCADO);
                intent.putExtra("isProvincia",true);
                break;
            case R.id.btnProvinciaChapare:
                intent.putExtra("lugarSeleccionado",Constants.FIREBASE_PROVINCIA_CHAPARE);
                intent.putExtra("isProvincia",true);
                break;
            case R.id.btnProvinciaEstebanArze:
                intent.putExtra("lugarSeleccionado",Constants.FIREBASE_PROVINCIA_ESTEBAN_ARZE);
                intent.putExtra("isProvincia",true);
                break;
            case R.id.btnProvinciaGermanJordan:
                intent.putExtra("lugarSeleccionado",Constants.FIREBASE_PROVINCIA_GERMAN_JORDAN);
                intent.putExtra("isProvincia",true);
                break;
            case R.id.btnProvinciaJoseCarrasco:
                intent.putExtra("lugarSeleccionado",Constants.FIREBASE_PROVINCIA_JOSE_CARRASCO_TORRICO);
                intent.putExtra("isProvincia",true);
                break;
            case R.id.btnProvinciaMizque:
                intent.putExtra("lugarSeleccionado",Constants.FIREBASE_PROVINCIA_MIZQUE);
                intent.putExtra("isProvincia",true);
                break;
            case R.id.btnProvinciaPunata:
                intent.putExtra("lugarSeleccionado",Constants.FIREBASE_PROVINCIA_PUNATA);
                intent.putExtra("isProvincia",true);
                break;
            case R.id.btnProvinciaQuillacollo:
                intent.putExtra("lugarSeleccionado",Constants.FIREBASE_PROVINCIA_QUILLACOLLO);
                intent.putExtra("isProvincia",true);
                break;
            case R.id.btnProvinciaTapacari:
                intent.putExtra("lugarSeleccionado",Constants.FIREBASE_PROVINCIA_TAPACARI);
                intent.putExtra("isProvincia",true);
                break;
            case R.id.btnProvinciaTiraque:
                intent.putExtra("lugarSeleccionado",Constants.FIREBASE_PROVINCIA_TIRAQUE);
                intent.putExtra("isProvincia",true);
                break;
        }
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }



    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}
