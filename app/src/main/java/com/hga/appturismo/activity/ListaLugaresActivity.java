package com.hga.appturismo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.hga.appturismo.R;
import com.hga.appturismo.adapterRecycler.LugarAdapterRecycler;
import com.hga.appturismo.api.ListaResponse;
import com.hga.appturismo.typeAdapter.LugarResponseTypeAdapter;
import com.hga.appturismo.api.TurismoCliente;
import com.hga.appturismo.api.TurismoFirebaseService;
import com.hga.appturismo.typeAdapter.PuntajeResponseTypeAdapter;
import com.hga.appturismo.base_datos.DataBaseSync;
import com.hga.appturismo.modelo.ModeloLugarTuristico;
import com.hga.appturismo.modelo.ModeloPuntaje;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaLugaresActivity extends AppCompatActivity {
    private LugarAdapterRecycler adapterRecycler;
    private ArrayList<ModeloLugarTuristico> lugaresTuristicos;
    private ArrayList<ModeloPuntaje> modeloPuntajes;
    private DataBaseSync dataBaseSync;
    private String provincia = "";

    public void goMapLugar(View view) {
        Intent intent = new Intent(this, MapaLugaresActivity.class);
        startActivity(intent);
    }

    private void initRecyclerView() {
        lugaresTuristicos = new ArrayList<>();
        modeloPuntajes = new ArrayList<>();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.lugarRecyclerView);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapterRecycler = new LugarAdapterRecycler(lugaresTuristicos, modeloPuntajes, R.layout.cardview_list, this);
        recyclerView.setAdapter(adapterRecycler);
    }

    /**
     * leer de json la lista de lugares turisticos
     */
    private void loadJSONLugarTuristico() {
        TurismoFirebaseService turismoFirebaseService = (new TurismoCliente(new LugarResponseTypeAdapter())).getService();

        Call<ListaResponse> lugarResponseCall = turismoFirebaseService.getListLugarTuristico();
        lugarResponseCall.enqueue(new Callback<ListaResponse>() {
            @Override
            public void onResponse(@NonNull Call<ListaResponse> call, @NonNull Response<ListaResponse> response) {
                if (response.isSuccessful()) {
                    ListaResponse listaResponse = response.body();

                    lugaresTuristicos.clear();
                    if (listaResponse != null) {
                        ArrayList<ModeloLugarTuristico> turisticoArrayList = listaResponse.getListModeloLugarTuristico();
                        if (!provincia.equals("")) {
                            for (ModeloLugarTuristico modeloLugarTuristico : turisticoArrayList) {
                                if (modeloLugarTuristico.getProvincia().equals(provincia)) {
                                    lugaresTuristicos.add(modeloLugarTuristico);
                                }
                            }
                        } else {
                            lugaresTuristicos.addAll(turisticoArrayList);
                        }
                    }
                    loadJSONPuntaje();
                    adapterRecycler.notifyDataSetChanged();
                    dataBaseSync.updateLugarTuristicoSQLite(lugaresTuristicos);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ListaResponse> call, @NonNull Throwable t) {
                loadSQLite();
                Log.d("Error", t.getMessage());
            }
        });
    }

    /**
     * leer de json firebase la lista de lugares y s
     */
    private void loadJSONPuntaje() {
        TurismoFirebaseService turismoFirebaseService = (new TurismoCliente(new PuntajeResponseTypeAdapter())).getService();

        Call<ListaResponse> lugarResponseCall = turismoFirebaseService.getListPuntaje();
        lugarResponseCall.enqueue(new Callback<ListaResponse>() {
            @Override
            public void onFailure(@NonNull Call<ListaResponse> call, @NonNull Throwable t) {
                //loadPuntajeSQLite();
                Log.d("Error", t.getMessage());
            }

            @Override
            public void onResponse(@NonNull Call<ListaResponse> call, @NonNull Response<ListaResponse> response) {
                if (response.isSuccessful()) {
                    ListaResponse listaResponse = response.body();

                    modeloPuntajes.clear();
                    if (listaResponse != null) {
                        ArrayList<ModeloPuntaje> turisticoArrayList = listaResponse.getListPuntaje();
                        modeloPuntajes.addAll(turisticoArrayList);
                    }
                    adapterRecycler.notifyDataSetChanged();
                    dataBaseSync.updatePuntajeSQLite(modeloPuntajes);
                }
            }
        });
    }

    private void loadSQLite() {
        DataBaseSync dataBaseSync = new DataBaseSync(this);
        lugaresTuristicos.clear();
        lugaresTuristicos.addAll(dataBaseSync.getListaLugarTuristco());
        adapterRecycler.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_lugares);
        dataBaseSync = new DataBaseSync(this);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.getString("provincia") != null) {
            provincia = bundle.getString("provincia");
        }else{
            provincia="";
        }
        initRecyclerView();
        loadJSONLugarTuristico();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);

        MenuItem search = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(search);
        search(searchView);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void search(SearchView searchView) {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextChange(String newText) {

                if (adapterRecycler != null)
                    adapterRecycler.getFilter().filter(newText);
                return true;
            }

            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }
        });
    }
}
