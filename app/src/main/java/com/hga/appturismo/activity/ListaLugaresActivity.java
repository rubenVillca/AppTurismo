package com.hga.appturismo.activity;

import android.content.Intent;
import android.content.SharedPreferences;
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
import com.hga.appturismo.bdFirebase.ListaResponse;
import com.hga.appturismo.bdFirebase.TurismoCliente;
import com.hga.appturismo.bdFirebase.TurismoFirebaseService;
import com.hga.appturismo.bdSQLite.SqliteLugar;
import com.hga.appturismo.modelo.ModeloLugarTuristico;
import com.hga.appturismo.modelo.ModeloPuntaje;
import com.hga.appturismo.typeAdapterJson.LugarResponseTypeAdapter;
import com.hga.appturismo.typeAdapterJson.PuntajeResponseTypeAdapter;
import com.hga.appturismo.util.Constants;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaLugaresActivity extends AppCompatActivity {
    private LugarAdapterRecycler adapterRecycler;
    private ArrayList<ModeloLugarTuristico> lugaresTuristicos;
    private ArrayList<ModeloPuntaje> modeloPuntajes;
    private SqliteLugar lugarTuristico;
    private String lugarSeleccionado = "";//provincia o tipo de lugar
    private boolean isProvincia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_lugares);
        lugarTuristico = new SqliteLugar(this);

        init();

        initRecyclerView();

        if (Constants.IS_READ_FIREBASE)
            loadFirebaseLugarTuristico();
        else
            loadSQLite();
    }

    private void init() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.getString("lugarSeleccionado") != null) {
            lugarSeleccionado = bundle.getString("lugarSeleccionado");
            isProvincia=bundle.getBoolean("isProvincia");
        }else{
            lugarSeleccionado ="";
            isProvincia=true;
        }
        if (!isProvincia){
            setTitle("Tipo: "+lugarSeleccionado);
        }
    }

    public void goMapLugar(View view) {
        Intent intent = new Intent(this, MapaLugaresActivity.class);
        intent.putExtra("isProvincia",isProvincia);
        startActivity(intent);
    }

    private void initRecyclerView() {
        lugaresTuristicos = new ArrayList<>();
        modeloPuntajes = new ArrayList<>();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        RecyclerView recyclerView = findViewById(R.id.lugarRecyclerView);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapterRecycler = new LugarAdapterRecycler(lugaresTuristicos, modeloPuntajes, R.layout.cardview_list, this);
        recyclerView.setAdapter(adapterRecycler);


    }

    /**
     * leer de firebase la lista de lugares turisticos
     */
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
                        //si existe un lugar seleccionado
                        if (!lugarSeleccionado.isEmpty()) {
                            //recorrer toda la lista
                            for (ModeloLugarTuristico modeloLugarTuristico : turisticoArrayList) {
                                //recuperar rol de las variables globales
                                SharedPreferences sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE);
                                int rol = sharedPreferences.getInt("rol", 0);
                                //si el estado es visivle
                                if (modeloLugarTuristico.getEstado().equals(Constants.ESTADO_LUGAR_VISIBLE)||rol==Constants.USUARIO_ROL_ADMIN) {
                                    //si se busca por provincia
                                    if (isProvincia && modeloLugarTuristico.getProvincia().equals(lugarSeleccionado)) {
                                        lugaresTuristicos.add(modeloLugarTuristico);
                                    }
                                    //si no es por provincia
                                    if (!isProvincia && modeloLugarTuristico.getTipo().equals(lugarSeleccionado)) {
                                        lugaresTuristicos.add(modeloLugarTuristico);
                                    }
                                    //para seleccionar lugares del tipo acontecimiento //crear uno similar en mainActivity.java
                                    //if(modeloLugarTuristico.getTipo().equals(Constants.TIPO_LUGAR_ACONTECIMIENTO));
                                }
                            }
                        } else{
                            lugaresTuristicos.addAll(turisticoArrayList);
                        }
                    }
                    loadFirebasePuntaje();
                    adapterRecycler.notifyDataSetChanged();
                    lugarTuristico.update(lugaresTuristicos);
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
     * leer de json bdFirebase la lista de lugares y s
     */
    private void loadFirebasePuntaje() {
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
                    lugarTuristico.updatePuntajeSQLite(modeloPuntajes);
                }
            }
        });
    }

    private void loadSQLite() {
        lugaresTuristicos.clear();
        lugaresTuristicos.addAll(lugarTuristico.list());
        adapterRecycler.notifyDataSetChanged();
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
