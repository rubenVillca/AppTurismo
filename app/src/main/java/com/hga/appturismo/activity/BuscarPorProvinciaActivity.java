package com.hga.appturismo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hga.appturismo.R;

public class BuscarPorProvinciaActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_por_provincia);

        initButton();
    }

    private void initButton() {
        Button btnProvinciaArani = (Button) findViewById(R.id.btnProvinciaArani);
        btnProvinciaArani.setOnClickListener(this);

        Button btnProvinciaArque = (Button) findViewById(R.id.btnProvinciaArque);
        btnProvinciaArque.setOnClickListener(this);

        Button btnProvinciaAyopaya = (Button) findViewById(R.id.btnProvinciaAyopaya);
        btnProvinciaAyopaya.setOnClickListener(this);

        Button btnProvinciaBolivar = (Button) findViewById(R.id.btnProvinciaBolivar);
        btnProvinciaBolivar.setOnClickListener(this);

        Button btnProvinciaCampero = (Button) findViewById(R.id.btnProvinciaCampero);
        btnProvinciaCampero.setOnClickListener(this);

        Button btnProvinciaCapinota = (Button) findViewById(R.id.btnProvinciaCapinota);
        btnProvinciaCapinota.setOnClickListener(this);

        Button btnProvinciaCercado = (Button) findViewById(R.id.btnProvinciaCercado);
        btnProvinciaCercado.setOnClickListener(this);

        Button btnProvinciaChapare = (Button) findViewById(R.id.btnProvinciaChapare);
        btnProvinciaChapare.setOnClickListener(this);

        Button btnProvinciaEstebanArze = (Button) findViewById(R.id.btnProvinciaEstebanArze);
        btnProvinciaEstebanArze.setOnClickListener(this);

        Button btnProvinciaGermanJordan = (Button) findViewById(R.id.btnProvinciaGermanJordan);
        btnProvinciaGermanJordan.setOnClickListener(this);

        Button btnProvinciaJoseCarrasco = (Button) findViewById(R.id.btnProvinciaJoseCarrasco);
        btnProvinciaJoseCarrasco.setOnClickListener(this);

        Button btnProvinciaMizque = (Button) findViewById(R.id.btnProvinciaMizque);
        btnProvinciaMizque.setOnClickListener(this);

        Button btnProvinciaPunata = (Button) findViewById(R.id.btnProvinciaPunata);
        btnProvinciaPunata.setOnClickListener(this);

        Button btnProvinciaQuillacollo = (Button) findViewById(R.id.btnProvinciaQuillacollo);
        btnProvinciaQuillacollo.setOnClickListener(this);

        Button btnProvinciaTapacari = (Button) findViewById(R.id.btnProvinciaTapacari);
        btnProvinciaTapacari.setOnClickListener(this);

        Button btnProvinciaTiraque = (Button) findViewById(R.id.btnProvinciaTiraque);
        btnProvinciaTiraque.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this,ListaLugaresActivity.class);

        int idProvincia=v.getId();
        switch (idProvincia){
            case R.id.btnProvinciaArani:
                intent.putExtra("lugarSeleccionado","Arani");
                intent.putExtra("isProvincia",true);
                break;
            case R.id.btnProvinciaArque:
                intent.putExtra("lugarSeleccionado","Arque");
                intent.putExtra("isProvincia",true);
                break;
            case R.id.btnProvinciaAyopaya:
                intent.putExtra("lugarSeleccionado","Ayopaya");
                intent.putExtra("isProvincia",true);
                break;
            case R.id.btnProvinciaBolivar:
                intent.putExtra("lugarSeleccionado","Bolívar");
                intent.putExtra("isProvincia",true);
                break;
            case R.id.btnProvinciaCampero:
                intent.putExtra("lugarSeleccionado","Narciso Campero");
                intent.putExtra("isProvincia",true);
                break;
            case R.id.btnProvinciaCapinota:
                intent.putExtra("lugarSeleccionado","Capinota");
                intent.putExtra("isProvincia",true);
                break;
            case R.id.btnProvinciaCercado:
                intent.putExtra("lugarSeleccionado","Cercado");
                intent.putExtra("isProvincia",true);
                break;
            case R.id.btnProvinciaChapare:
                intent.putExtra("lugarSeleccionado","Chapare");
                intent.putExtra("isProvincia",true);
                break;
            case R.id.btnProvinciaEstebanArze:
                intent.putExtra("lugarSeleccionado","Esteban Arce");
                intent.putExtra("isProvincia",true);
                break;
            case R.id.btnProvinciaGermanJordan:
                intent.putExtra("lugarSeleccionado","Germán Jordán");
                intent.putExtra("isProvincia",true);
                break;
            case R.id.btnProvinciaJoseCarrasco:
                intent.putExtra("lugarSeleccionado","José Carrasco");
                intent.putExtra("isProvincia",true);
                break;
            case R.id.btnProvinciaMizque:
                intent.putExtra("lugarSeleccionado","Mizque");
                intent.putExtra("isProvincia",true);
                break;
            case R.id.btnProvinciaPunata:
                intent.putExtra("lugarSeleccionado","Punata");
                intent.putExtra("isProvincia",true);
                break;
            case R.id.btnProvinciaQuillacollo:
                intent.putExtra("lugarSeleccionado","Quillacollo");
                intent.putExtra("isProvincia",true);
                break;
            case R.id.btnProvinciaTapacari:
                intent.putExtra("lugarSeleccionado","Tapacarí");
                intent.putExtra("isProvincia",true);
                break;
            case R.id.btnProvinciaTiraque:
                intent.putExtra("lugarSeleccionado","Tiraque");
                intent.putExtra("isProvincia",true);
                break;
        }
        startActivity(intent);
    }
}
