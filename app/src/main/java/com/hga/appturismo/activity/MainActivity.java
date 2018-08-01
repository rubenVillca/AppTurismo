package com.hga.appturismo.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.hga.appturismo.R;
import com.hga.appturismo.adapterRecycler.RestauranteAdapterRecycler;
import com.hga.appturismo.bdFirebase.ResetFirebase;
import com.hga.appturismo.bdFirebase.TurismoAplicacion;
import com.hga.appturismo.bdSQLite.DBSQLiteManager;
import com.hga.appturismo.bdSQLite.SqliteLugar;
import com.hga.appturismo.imagenes.ImagenAcontecimientosSwip;
import com.hga.appturismo.imagenes.ImagenSwip;
import com.hga.appturismo.modelo.ModeloImagen;
import com.hga.appturismo.modelo.ModeloLugarTuristico;
import com.hga.appturismo.util.Constants;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<ModeloLugarTuristico> modeloLugarTuristicos;
    private SqliteLugar lugar;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnMapaLugar:
                Intent listaLugar = new Intent(this, ListaLugaresActivity.class);
                startActivity(listaLugar);
                break;
            case R.id.btnMapaHoteles:
                Intent listaHotel = new Intent(this, ListaHotelesActivity.class);
                startActivity(listaHotel);
                break;
            case R.id.btnMapaRestaurantes:
                Intent listaRestaurante = new Intent(this, ListaRestaurantesActivity.class);
                startActivity(listaRestaurante);
                break;
            case R.id.action_search:
                SearchView searchView = findViewById(R.id.action_search);
                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        Toast.makeText(MainActivity.this, "Texto buscar: " + query, Toast.LENGTH_SHORT).show();
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {

                        return false;
                    }
                });
                break;
            case R.id.btnInsertSite:
                Intent insertarLugar = new Intent(this, InsertarLugarActivity.class);
                startActivity(insertarLugar);
                break;
            case R.id.btnListUsuarios:
                Intent listaUsuarios = new Intent(this, ListaUsuariosActivity.class);
                startActivity(listaUsuarios);
                break;
            case R.id.btnAddUsuarios:
                Intent addUsuarios = new Intent(this, InsertarUsuarioActivity.class);
                startActivity(addUsuarios);
                break;
            default:
                System.out.println("Error!. la accion selecionada no esta asociada a ninguna funcion");
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setMenu();
        setLitaModeloLugares();
        crearContenido();
        setAcontecimientosView();
    }

    private void setAcontecimientosView() {
        ViewPager viewPager = findViewById(R.id.imagenAcontecimiento);
        ImagenAcontecimientosSwip imagenSwip = new ImagenAcontecimientosSwip(modeloLugarTuristicos, this);
        viewPager.setAdapter(imagenSwip);
    }

    private void setMenu() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setLitaModeloLugares() {
        modeloLugarTuristicos=new ArrayList<>();
        lugar=new SqliteLugar(this);
        ArrayList<ModeloLugarTuristico> aux=lugar.list();
        for (ModeloLugarTuristico lugarTuristico:aux){
            if (lugarTuristico.getTipo().equals(Constants.TIPO_LUGAR_ACONTECIMIENTOS)){
                modeloLugarTuristicos.add(lugarTuristico);
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        SharedPreferences sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE);
        int rol = sharedPreferences.getInt("rol", 0);

        switch (rol) {
            case Constants.USUARIO_ROL_ADMIN:
                menu.findItem(R.id.action_login).setVisible(false);
                menu.findItem(R.id.action_user_insert).setVisible(true);
                menu.findItem(R.id.action_edit_profile).setVisible(true);
                menu.findItem(R.id.action_sincronizar).setVisible(true);
                menu.findItem(R.id.action_reset).setVisible(true);//para resetear bdFirebase y sqlite
                menu.findItem(R.id.action_close_login).setVisible(true);
                break;
            case Constants.USUARIO_ROL_REVISOR:
                menu.findItem(R.id.action_login).setVisible(false);
                menu.findItem(R.id.action_user_insert).setVisible(false);
                menu.findItem(R.id.action_edit_profile).setVisible(true);
                menu.findItem(R.id.action_sincronizar).setVisible(true);
                menu.findItem(R.id.action_reset).setVisible(true);//para descartivar la opcion de reseteo poner false aqui

                menu.findItem(R.id.action_close_login).setVisible(true);
                break;
            default://no logueado
                menu.findItem(R.id.action_login).setVisible(true);
                menu.findItem(R.id.action_user_insert).setVisible(false);
                menu.findItem(R.id.action_edit_profile).setVisible(false);
                menu.findItem(R.id.action_sincronizar).setVisible(true);
                menu.findItem(R.id.action_reset).setVisible(false);//para resetear datos habilita a true y seleccionar
                menu.findItem(R.id.action_close_login).setVisible(false);
                break;
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        //noinspection SimplifiableIfStatement
        switch (item.getItemId()) {
            case R.id.action_login:
                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.action_user_insert:
                intent = new Intent(this, InsertarUsuarioActivity.class);
                startActivity(intent);
                break;
            case R.id.action_close_login:
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();//h
                firebaseAuth.signOut();
                SharedPreferences.Editor sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE).edit();
                sharedPreferences.putString("email", "");
                sharedPreferences.putInt("rol", 0);
                sharedPreferences.apply();//..h

                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.action_edit_profile:
                intent = new Intent(this, EditarUsuarioActivity.class);
                startActivity(intent);
                break;
            case R.id.action_reset:
                resetDataFirebase();
                resetDatosSQlite();
                break;
            case R.id.action_sincronizar:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void crearContenido() {
        ImageButton btnMapaLugares = findViewById(R.id.btnMapaLugar);
        btnMapaLugares.setOnClickListener(this);

        ImageButton btnMapaHoteles = findViewById(R.id.btnMapaHoteles);
        btnMapaHoteles.setOnClickListener(this);

        ImageButton btnMapaRestaurantes = findViewById(R.id.btnMapaRestaurantes);
        btnMapaRestaurantes.setOnClickListener(this);
        SharedPreferences sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE);
        int rol = sharedPreferences.getInt("rol", 0);
        //contenedores de botones para insertar
        LinearLayout linearLayoutAddSite = findViewById(R.id.layout_container_add_site);
        LinearLayout linearLayoutUser = findViewById(R.id.layout_container_user_list);
        LinearLayout linearLayoutAddUser = findViewById(R.id.layout_container_add_user);

        ImageView btnInsertar = findViewById(R.id.btnInsertSite);
        btnInsertar.setOnClickListener(this);

        ImageButton btnUsuario = findViewById(R.id.btnListUsuarios);
        btnUsuario.setOnClickListener(this);

        ImageButton btnAddUser = findViewById(R.id.btnAddUsuarios);
        btnAddUser.setOnClickListener(this);

        switch (rol) {
            case Constants.USUARIO_ROL_ADMIN:
                linearLayoutAddSite.setVisibility(View.VISIBLE);
                linearLayoutUser.setVisibility(View.VISIBLE);
                linearLayoutAddUser.setVisibility(View.VISIBLE);

                break;
            case Constants.USUARIO_ROL_REVISOR:
                linearLayoutAddSite.setVisibility(View.VISIBLE);
                linearLayoutUser.setVisibility(View.GONE);
                linearLayoutAddUser.setVisibility(View.GONE);
                break;
            default:
                linearLayoutAddSite.setVisibility(View.GONE);
                linearLayoutUser.setVisibility(View.GONE);
                linearLayoutAddUser.setVisibility(View.GONE);
                break;
        }
    }

    public void goProvinciaActivity(View view) {
        Intent buscarPorProvincia = new Intent(this, BuscarPorProvinciaActivity.class);
        startActivity(buscarPorProvincia);
    }

    public void goTipoActivity(View view) {
        Intent buscarPorTipo = new Intent(this, BuscarPorTipoActivity.class);
        //if(modeloLugarTuristico.getTipo().equals(Constants.TIPO_LUGAR_ACONTECIMIENTO));
        startActivity(buscarPorTipo);
    }

    private void resetDataFirebase() {
        TurismoAplicacion app = (TurismoAplicacion) getApplicationContext();

        ResetFirebase resetFirebase=new ResetFirebase(app,this);
        resetFirebase.resetDatosFirebase();
    }

    private void resetDatosSQlite() {
        DBSQLiteManager DBSQLiteManager =new DBSQLiteManager();
        DBSQLiteManager.resetSQLite(this);
    }
}
