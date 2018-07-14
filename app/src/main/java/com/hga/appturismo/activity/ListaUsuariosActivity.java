package com.hga.appturismo.activity;

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

import com.hga.appturismo.R;
import com.hga.appturismo.adapterRecycler.UsuarioAdapterRecycler;
import com.hga.appturismo.bdFirebase.ListaResponse;
import com.hga.appturismo.bdFirebase.TurismoCliente;
import com.hga.appturismo.bdFirebase.TurismoFirebaseService;
import com.hga.appturismo.typeAdapter.UsuarioResponseTypeAdapter;
import com.hga.appturismo.bdSQLite.DataBaseSync;
import com.hga.appturismo.modelo.ModeloUsuario;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by HGA on 26/11/2017
 */

public class ListaUsuariosActivity extends AppCompatActivity {
    private UsuarioAdapterRecycler adapterRecycler;
    private ArrayList<ModeloUsuario> modeloUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);

        initRecyclerView();
        //loadJSONFirebase();
        loadSQLite();
    }

    private void initRecyclerView() {
        modeloUsuarios = new ArrayList<>();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.usuarioRecyclerView);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapterRecycler = new UsuarioAdapterRecycler(modeloUsuarios, R.layout.cardview_list_users, this);
        recyclerView.setAdapter(adapterRecycler);
    }

    private void loadJSONFirebase() {
        TurismoFirebaseService turismoFirebaseService = (new TurismoCliente(new UsuarioResponseTypeAdapter())).getService();

        Call<ListaResponse> usuarioResponseCall = turismoFirebaseService.getListUsuarios();
        usuarioResponseCall.enqueue(new Callback<ListaResponse>() {
            @Override
            public void onResponse(@NonNull Call<ListaResponse> call, @NonNull Response<ListaResponse> response) {
                if (response.isSuccessful()) {
                    ListaResponse listaResponse = response.body();

                    modeloUsuarios.clear();
                    if (listaResponse != null) {
                        modeloUsuarios.addAll(listaResponse.getListUsuarios());
                    }
                    adapterRecycler.notifyDataSetChanged();

                    DataBaseSync dataBaseSync = new DataBaseSync(ListaUsuariosActivity.this);
                    dataBaseSync.updateUsuariosSQLite(modeloUsuarios);
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
        DataBaseSync dataBaseSync = new DataBaseSync(this);
        modeloUsuarios.clear();
        modeloUsuarios.addAll(dataBaseSync.getListaUsuarios());
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
