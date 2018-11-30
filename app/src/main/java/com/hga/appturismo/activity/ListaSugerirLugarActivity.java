package com.hga.appturismo.activity;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.hga.appturismo.R;
import com.hga.appturismo.adapterRecycler.LugarAdapterRecycler;
import com.hga.appturismo.adapterRecycler.SugerenciaAdapterRecycler;
import com.hga.appturismo.bdFirebase.ListaResponse;
import com.hga.appturismo.bdFirebase.TurismoCliente;
import com.hga.appturismo.bdFirebase.TurismoFirebaseService;
import com.hga.appturismo.bdSQLite.SqliteHotel;
import com.hga.appturismo.bdSQLite.SqliteLugar;
import com.hga.appturismo.bdSQLite.SqliteRestaurante;
import com.hga.appturismo.modelo.ModeloHotel;
import com.hga.appturismo.modelo.ModeloLugarTuristico;
import com.hga.appturismo.modelo.ModeloPuntaje;
import com.hga.appturismo.modelo.ModeloRestaurante;
import com.hga.appturismo.typeAdapterJson.LugarResponseTypeAdapter;
import com.hga.appturismo.util.Constants;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaSugerirLugarActivity extends AppCompatActivity {

    private SugerenciaAdapterRecycler adapterRecycler;
    private ArrayList<ModeloLugarTuristico> lugaresTuristicos;
    private ArrayList<ModeloRestaurante> restaurantes;
    private ArrayList<ModeloHotel> hotels;
    private SqliteLugar lugarTuristicoSQL;
    private SqliteRestaurante restauranteSQL;
    private SqliteHotel hotelSQL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_sugerir_lugar);

        lugarTuristicoSQL = new SqliteLugar(this);
        restauranteSQL = new SqliteRestaurante(this);
        hotelSQL = new SqliteHotel(this);

        initRecyclerView();

        if (Constants.IS_READ_FIREBASE)
            loadFirebaseLugarTuristico();
        else
            loadSQLite();
    }

    private void loadFirebaseLugarTuristico() {
        TurismoFirebaseService turismoFirebaseService = (new TurismoCliente(new LugarResponseTypeAdapter())).getService();

        Call<ListaResponse> lugarResponseCall = turismoFirebaseService.getListLugarTuristico();
        lugarResponseCall.enqueue(new Callback<ListaResponse>() {
            @Override
            public void onResponse(@NonNull Call<ListaResponse> call, @NonNull Response<ListaResponse> response) {
                if (response.isSuccessful()) {
                    ListaResponse listaResponse = response.body();
                    //lista de lugares turisticos a mostrar
                    lugaresTuristicos.clear();
                    if (listaResponse != null) {
                        //lista de todos los lugares turisticos
                        ArrayList<ModeloLugarTuristico> turisticoArrayList = listaResponse.getListModeloLugarTuristico();

                        //recorrer toda la lista
                        for (ModeloLugarTuristico modeloLugarTuristico : turisticoArrayList) {
                            if (modeloLugarTuristico.getEstado().equals(Constants.ESTADO_LUGAR_SUG_INSERTAR)) {
                                lugaresTuristicos.add(modeloLugarTuristico);
                            }
                        }
                    }
                    adapterRecycler.notifyDataSetChanged();
                    lugarTuristicoSQL.update(lugaresTuristicos);

                    loadFirebaseHotel();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ListaResponse> call, @NonNull Throwable t) {
                loadSQLite();
                Log.d("Error", t.getMessage());
            }
        });
    }

    private void loadFirebaseHotel() {
        TurismoFirebaseService turismoFirebaseService = (new TurismoCliente(new LugarResponseTypeAdapter())).getService();

        Call<ListaResponse> lugarResponseCall = turismoFirebaseService.getListHotel();
        lugarResponseCall.enqueue(new Callback<ListaResponse>() {
            @Override
            public void onResponse(@NonNull Call<ListaResponse> call, @NonNull Response<ListaResponse> response) {
                if (response.isSuccessful()) {
                    ListaResponse listaResponse = response.body();

                    hotels.clear();
                    if (listaResponse != null) {
                        ArrayList<ModeloHotel> turisticoArrayList = listaResponse.getListModeloHotel();

                        for (ModeloHotel modeloHotel : turisticoArrayList) {
                            if (modeloHotel.getEstado().equals(Constants.ESTADO_LUGAR_SUG_INSERTAR)) {
                                hotels.add(modeloHotel);
                            }
                        }
                    }
                    adapterRecycler.notifyDataSetChanged();
                    hotelSQL.update(hotels);

                    loadFirebaseRestaurante();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ListaResponse> call, @NonNull Throwable t) {
                loadSQLite();
                Log.d("Error", t.getMessage());
            }
        });
    }

    private void loadFirebaseRestaurante() {
        TurismoFirebaseService turismoFirebaseService = (new TurismoCliente(new LugarResponseTypeAdapter())).getService();

        Call<ListaResponse> lugarResponseCall = turismoFirebaseService.getListRestaurante();
        lugarResponseCall.enqueue(new Callback<ListaResponse>() {
            @Override
            public void onResponse(@NonNull Call<ListaResponse> call, @NonNull Response<ListaResponse> response) {
                if (response.isSuccessful()) {
                    ListaResponse listaResponse = response.body();

                    restaurantes.clear();
                    if (listaResponse != null) {
                        ArrayList<ModeloRestaurante> turisticoArrayList = listaResponse.getListModeloRestaurante();

                        for (ModeloRestaurante restaurante : turisticoArrayList) {
                            if (restaurante.getEstado().equals(Constants.ESTADO_LUGAR_SUG_INSERTAR)) {
                                restaurantes.add(restaurante);
                            }
                        }
                    }
                    adapterRecycler.notifyDataSetChanged();
                    restauranteSQL.update(restaurantes);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ListaResponse> call, @NonNull Throwable t) {
                loadSQLite();
                Log.d("Error", t.getMessage());
            }
        });
    }

    private void loadSQLite() {
        lugaresTuristicos.clear();

        lugaresTuristicos.addAll(lugarTuristicoSQL.listSugeridos());
        hotels.addAll(hotelSQL.listSugeridos());
        restaurantes.addAll(restauranteSQL.listSugeridos());
        adapterRecycler.notifyDataSetChanged();
    }

    private void initRecyclerView() {
        lugaresTuristicos = new ArrayList<>();
        hotels=new ArrayList<>();
        restaurantes=new ArrayList<>();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        RecyclerView recyclerView = findViewById(R.id.sugerirRecyclerView);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapterRecycler = new SugerenciaAdapterRecycler(hotels,restaurantes,lugaresTuristicos, R.layout.cardview_list_sugerencias, this);
        recyclerView.setAdapter(adapterRecycler);
    }
}
