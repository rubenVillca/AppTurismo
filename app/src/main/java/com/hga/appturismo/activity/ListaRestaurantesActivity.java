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
import com.hga.appturismo.adapterRecycler.RestauranteAdapterRecycler;
import com.hga.appturismo.bdFirebase.ListaResponse;
import com.hga.appturismo.bdSQLite.SqliteRestaurante;
import com.hga.appturismo.typeAdapterJson.PuntajeResponseTypeAdapter;
import com.hga.appturismo.typeAdapterJson.RestauranteResponseTypeAdapter;
import com.hga.appturismo.bdFirebase.TurismoCliente;
import com.hga.appturismo.bdFirebase.TurismoFirebaseService;
import com.hga.appturismo.modelo.ModeloPuntaje;
import com.hga.appturismo.modelo.ModeloRestaurante;
import com.hga.appturismo.util.Constants;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaRestaurantesActivity extends AppCompatActivity {
    private RestauranteAdapterRecycler adapterRecycler;
    private ArrayList<ModeloRestaurante> modeloRestaurantes;
    private ArrayList<ModeloPuntaje> modeloPuntajes;
    private SqliteRestaurante restauranteSQLite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_restaurantes);
        restauranteSQLite =new SqliteRestaurante(this);

        initRecyclerView();

        if (Constants.IS_READ_FIREBASE)
            loadFirebase();
        else
            loadSQLite();
    }

    private void initRecyclerView() {
        modeloRestaurantes = new ArrayList<>();
        modeloPuntajes=new ArrayList<>();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        RecyclerView recyclerView = findViewById(R.id.restauranteRecyclerView);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapterRecycler = new RestauranteAdapterRecycler(modeloRestaurantes, modeloPuntajes,R.layout.cardview_list, this);
        recyclerView.setAdapter(adapterRecycler);

    }

    private void loadFirebase() {
        TurismoFirebaseService turismoFirebaseService = (new TurismoCliente(new RestauranteResponseTypeAdapter())).getService();

        Call<ListaResponse> restautanteResponseCall = turismoFirebaseService.getListRestaurante();
        restautanteResponseCall.enqueue(new Callback<ListaResponse>() {
            @Override
            public void onResponse(@NonNull Call<ListaResponse> call, @NonNull Response<ListaResponse> response) {
                if (response.isSuccessful()) {
                    ListaResponse listaResponse = response.body();

                    modeloRestaurantes.clear();
                    if (listaResponse != null) {
                        ArrayList<ModeloRestaurante> restauranteArrayList = listaResponse.getListModeloRestaurante();
                        SharedPreferences sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE);
                        int rol = sharedPreferences.getInt("rol", 0);
                        if (rol==Constants.USUARIO_ROL_ADMIN) {
                            modeloRestaurantes.addAll(restauranteArrayList);
                        }else {
                         for (ModeloRestaurante restaurante:restauranteArrayList){
                             if (restaurante.getEstado().equals(Constants.ESTADO_LUGAR_VISIBLE)){
                                 modeloRestaurantes.add(restaurante);
                             }
                         }
                        }
                    }
                    loadJSONFirebasePuntaje();
                    adapterRecycler.notifyDataSetChanged();
                    restauranteSQLite.update(modeloRestaurantes);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ListaResponse> call, @NonNull Throwable t) {
                loadSQLite();
                Log.d("Error", t.getMessage());
            }
        });
    }

    private void loadJSONFirebasePuntaje() {
        TurismoFirebaseService turismoFirebaseService=(new TurismoCliente(new PuntajeResponseTypeAdapter())).getService();

        Call<ListaResponse> responseCall=turismoFirebaseService.getListPuntaje();
        responseCall.enqueue(new Callback<ListaResponse>() {
            @Override
            public void onResponse(@NonNull Call<ListaResponse> call, @NonNull Response<ListaResponse> response) {
                if (response.isSuccessful()){
                    ListaResponse listaResponse =response.body();

                    modeloPuntajes.clear();
                    if (listaResponse != null) {
                        ArrayList<ModeloPuntaje> puntajeArrayList = listaResponse.getListPuntaje();
                        modeloPuntajes.addAll(puntajeArrayList);
                    }
                    adapterRecycler.notifyDataSetChanged();

                    restauranteSQLite.updatePuntajeSQLite(modeloPuntajes);//actualizar sqlite puntaje
                }
            }

            @Override
            public void onFailure(@NonNull Call<ListaResponse> call, @NonNull Throwable t) {
                //loadSQLite();
                Log.d("Error",t.getMessage());
            }
        });
    }

    private void loadSQLite() {
        modeloRestaurantes.clear();
        modeloRestaurantes.addAll(restauranteSQLite.listActive());

        modeloPuntajes.clear();
        modeloPuntajes.addAll(restauranteSQLite.getPuntaje());

        adapterRecycler.notifyDataSetChanged();
    }

    public void goMapRestaurante(View view) {
        Intent intent = new Intent(this, MapaRestaurantesActivity.class);
        startActivity(intent);
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
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                if (adapterRecycler != null)
                    adapterRecycler.getFilter().filter(newText);
                return true;
            }
        });
    }
}
