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
import com.hga.appturismo.adapterRecycler.HotelAdapterRecycler;
import com.hga.appturismo.bdFirebase.ListaResponse;
import com.hga.appturismo.typeAdapter.HotelResponseTypeAdapter;
import com.hga.appturismo.typeAdapter.PuntajeResponseTypeAdapter;
import com.hga.appturismo.bdFirebase.TurismoCliente;
import com.hga.appturismo.bdFirebase.TurismoFirebaseService;
import com.hga.appturismo.bdSQLite.DataBaseSync;
import com.hga.appturismo.modelo.ModeloHotel;
import com.hga.appturismo.modelo.ModeloPuntaje;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaHotelesActivity extends AppCompatActivity {
    private HotelAdapterRecycler adapterRecycler;
    private ArrayList<ModeloHotel> modeloHotels;
    private ArrayList<ModeloPuntaje> modeloPuntajes;
    private DataBaseSync dataBaseSync;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_hoteles);
        dataBaseSync=new DataBaseSync(this);

        initRecyclerView();
        //loadJSONFirebaseHotel();
        loadSQLite();
    }
    private void initRecyclerView() {
        modeloHotels =new ArrayList<>();
        modeloPuntajes=new ArrayList<>();

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.hotelRecyclerView);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapterRecycler = new HotelAdapterRecycler(modeloHotels,modeloPuntajes, R.layout.cardview_list,this);
        recyclerView.setAdapter(adapterRecycler);
    }

    private void loadJSONFirebaseHotel() {
        TurismoFirebaseService turismoFirebaseService=(new TurismoCliente(new HotelResponseTypeAdapter())).getService();

        Call<ListaResponse> responseCall=turismoFirebaseService.getListHotel();
        responseCall.enqueue(new Callback<ListaResponse>() {
            @Override
            public void onResponse(@NonNull Call<ListaResponse> call, @NonNull Response<ListaResponse> response) {
                if (response.isSuccessful()){
                    ListaResponse listaResponse =response.body();

                    modeloHotels.clear();
                    if (listaResponse != null) {
                        ArrayList<ModeloHotel> hotelArrayList = listaResponse.getListModeloHotel();
                        modeloHotels.addAll(hotelArrayList);
                    }
                    adapterRecycler.notifyDataSetChanged();

                    loadJSONFirebasePuntaje();


                    dataBaseSync.updateHotelSQLite(modeloHotels);//actualizar hotel sqlite
                }
            }

            @Override
            public void onFailure(@NonNull Call<ListaResponse> call, @NonNull Throwable t) {
                loadSQLite();
                Log.d("Error",t.getMessage());
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

                    dataBaseSync.updatePuntajeSQLite(modeloPuntajes);//actualizar sqlite puntaje
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
        modeloHotels.clear();
        modeloHotels.addAll(dataBaseSync.getListaHoteles());
        adapterRecycler.notifyDataSetChanged();
    }

    public void goMapHotel(View view) {
        Intent intent = new Intent(this,MapaHotelesActivity.class);
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
