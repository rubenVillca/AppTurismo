package com.hga.appturismo.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.hga.appturismo.R;
import com.hga.appturismo.bdFirebase.ListaResponse;
import com.hga.appturismo.bdFirebase.ServiceResetFirebase;
import com.hga.appturismo.bdFirebase.TurismoCliente;
import com.hga.appturismo.bdFirebase.TurismoFirebaseService;
import com.hga.appturismo.bdSQLite.SqliteHotel;
import com.hga.appturismo.bdSQLite.SqliteLugar;
import com.hga.appturismo.bdSQLite.SqliteRestaurante;
import com.hga.appturismo.bdSQLite.SqliteUsuario;
import com.hga.appturismo.imagenes.ImagenAcontecimientosSwip;
import com.hga.appturismo.modelo.ModeloHotel;
import com.hga.appturismo.modelo.ModeloLugarTuristico;
import com.hga.appturismo.modelo.ModeloPuntaje;
import com.hga.appturismo.modelo.ModeloRestaurante;
import com.hga.appturismo.modelo.ModeloUsuario;
import com.hga.appturismo.typeAdapterJson.HotelResponseTypeAdapter;
import com.hga.appturismo.typeAdapterJson.LugarResponseTypeAdapter;
import com.hga.appturismo.typeAdapterJson.PuntajeResponseTypeAdapter;
import com.hga.appturismo.typeAdapterJson.RestauranteResponseTypeAdapter;
import com.hga.appturismo.typeAdapterJson.UsuarioResponseTypeAdapter;
import com.hga.appturismo.util.Constants;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<ModeloLugarTuristico> modeloLugarTuristicos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setMenu();
        crearContenido();
        getAcontecimientos();
        showAcontecimientosView();
    }

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
            case R.id.btnRevisor:
                Intent reviewer=new Intent(this,ListaSugerirLugarActivity.class);
                startActivity(reviewer);

            default:
                System.out.println("Error!. la accion selecionada no esta asociada a ninguna funcion");
                break;
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
                menu.findItem(R.id.action_reset).setVisible(true);//para resetear datos habilita a true y seleccionar
                menu.findItem(R.id.action_close_login).setVisible(false);
                break;
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
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
                resetDatosSQlite();
                break;
        }
        return super.onOptionsItemSelected(item);
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

    private void getAcontecimientos() {
        SqliteLugar lugar = new SqliteLugar(this);
        modeloLugarTuristicos= lugar.listAcontecimientosActivos();
    }

    private void showAcontecimientosView() {
        LinearLayout layoutAcontecimientos = findViewById(R.id.layout_container_acontecimientos);
        LinearLayout layoutPortada = findViewById(R.id.layout_container_portada);

        if (modeloLugarTuristicos.isEmpty()) {
            layoutAcontecimientos.setVisibility(View.GONE);
            layoutPortada.setVisibility(View.VISIBLE);
        } else {
            layoutAcontecimientos.setVisibility(View.VISIBLE);
            layoutPortada.setVisibility(View.GONE);

            ViewPager viewPager = findViewById(R.id.imagenAcontecimiento);
            ImagenAcontecimientosSwip imagenSwip = new ImagenAcontecimientosSwip(modeloLugarTuristicos, this);
            viewPager.setAdapter(imagenSwip);
        }
    }

    private void setMenu() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
        LinearLayout linearLayoutReviewer = findViewById(R.id.layout_container_revisor);

        ImageView btnInsertar = findViewById(R.id.btnInsertSite);
        btnInsertar.setOnClickListener(this);

        ImageButton btnUsuario = findViewById(R.id.btnListUsuarios);
        btnUsuario.setOnClickListener(this);

        ImageButton btnAddUser = findViewById(R.id.btnAddUsuarios);
        btnAddUser.setOnClickListener(this);

        ImageButton btnReviewer = findViewById(R.id.btnRevisor);
        btnReviewer.setOnClickListener(this);

        switch (rol) {
            case Constants.USUARIO_ROL_ADMIN:
                linearLayoutAddSite.setVisibility(View.VISIBLE);
                linearLayoutUser.setVisibility(View.VISIBLE);
                linearLayoutAddUser.setVisibility(View.VISIBLE);
                linearLayoutReviewer.setVisibility(View.GONE);

                break;
            case Constants.USUARIO_ROL_REVISOR:
                linearLayoutAddSite.setVisibility(View.VISIBLE);
                linearLayoutUser.setVisibility(View.GONE);
                linearLayoutAddUser.setVisibility(View.GONE);
                linearLayoutReviewer.setVisibility(View.VISIBLE);
                break;
            default:
                linearLayoutAddSite.setVisibility(View.VISIBLE);
                linearLayoutUser.setVisibility(View.GONE);
                linearLayoutAddUser.setVisibility(View.GONE);
                linearLayoutReviewer.setVisibility(View.GONE);
                break;
        }
    }

    private void resetDataFirebase() {
        ServiceResetFirebase serviceResetFirebase =new ServiceResetFirebase(this);
        serviceResetFirebase.resetDatosFirebase();
    }

    private void resetDatosSQlite() {
        setVisibleScrollBar(true);

        SqliteHotel sqliteHotel=new SqliteHotel(this);
        sqliteHotel.deletePuntaje();
        sqliteHotel.deleteImagenes();

        setProgressBar(1);
    }

    private void setVisibleScrollBar(boolean isVisible) {
        if (isVisible) {
            findViewById(R.id.scrollView).setVisibility(View.INVISIBLE);
            findViewById(R.id.menuMain).setVisibility(View.INVISIBLE);

            findViewById(R.id.progressBarLayout).setVisibility(View.VISIBLE);
        }else{
            findViewById(R.id.scrollView).setVisibility(View.VISIBLE);
            findViewById(R.id.menuMain).setVisibility(View.VISIBLE);

            findViewById(R.id.progressBarLayout).setVisibility(View.GONE);
        }
    }

    private void setProgressBar(int advance){
        ProgressBar progressBar = findViewById(R.id.progressBarHorizontal);
        progressBar.setMax(6);
        switch (advance){
            case 0:
                progressBar.setProgress(advance);
                showTextLarge("Error al sincronizar");
                setVisibleScrollBar(false);
                break;
            case 1:
                updateSQLiteHotel();
                progressBar.setProgress(advance-1);
                break;
            case 2:
                showTextSmall("Sincronizacion hoteles exitosa");
                updateSQLiteRestaurantes();
                progressBar.setProgress(advance-1);
                break;
            case 3:
                showTextSmall("Sincronizacion restaurantes exitosa");
                updateSQLiteLugares();
                progressBar.setProgress(advance-1);
                break;
            case 4:
                showTextSmall("Sincronizacion lugares turisticos exitosa");
                updateSQLitePuntaje();
                progressBar.setProgress(advance-1);
                break;
            case 5:
                showTextLarge("Sincronizacion puntaje");
                progressBar.setProgress(advance-1);
                updateSQLiteUsusarios();
                break;
            case 6:
                showTextLarge("Sincronizacion exitosa");
                progressBar.setProgress(advance-1);
                getAcontecimientos();
                showAcontecimientosView();
                setVisibleScrollBar(false);

                break;
        }
    }

    private void updateSQLiteUsusarios() {
        TurismoFirebaseService turismoFirebaseService = (new TurismoCliente(new UsuarioResponseTypeAdapter())).getService();

        Call<ListaResponse> responseCall = turismoFirebaseService.getListUsuarios();
        responseCall.enqueue(new Callback<ListaResponse>() {
            @Override
            public void onResponse(@NonNull Call<ListaResponse> call, @NonNull Response<ListaResponse> response) {
                if (response.isSuccessful()) {
                    ListaResponse listaResponse = response.body();

                    if (listaResponse != null) {
                        SqliteUsuario usuario = new SqliteUsuario(MainActivity.this);
                        ArrayList<ModeloUsuario> listModeloUsuario = listaResponse.getListUsuarios();
                        usuario.update(listModeloUsuario);
                    }

                    setProgressBar(6);
                }else{
                    setProgressBar(0);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ListaResponse> call, @NonNull Throwable t) {
                setProgressBar(0);
            }
        });
    }

    private void updateSQLiteHotel() {
        TurismoFirebaseService turismoFirebaseService = (new TurismoCliente(new HotelResponseTypeAdapter())).getService();

        Call<ListaResponse> responseCall = turismoFirebaseService.getListHotel();
        responseCall.enqueue(new Callback<ListaResponse>() {
            @Override
            public void onResponse(@NonNull Call<ListaResponse> call, @NonNull Response<ListaResponse> response) {
                if (response.isSuccessful()) {
                    ListaResponse listaResponse = response.body();

                    if (listaResponse != null) {
                        SqliteHotel hotel = new SqliteHotel(MainActivity.this);
                        ArrayList<ModeloHotel> listModeloHotel = listaResponse.getListModeloHotel();
                        hotel.update(listModeloHotel);
                    }

                    setProgressBar(2);
                }else{
                    setProgressBar(0);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ListaResponse> call, @NonNull Throwable t) {
                setProgressBar(0);
            }
        });
    }

    private void updateSQLiteRestaurantes() {
        TurismoFirebaseService turismoFirebaseService = (new TurismoCliente(new RestauranteResponseTypeAdapter())).getService();

        Call<ListaResponse> responseCall = turismoFirebaseService.getListRestaurante();
        responseCall.enqueue(new Callback<ListaResponse>() {
            @Override
            public void onResponse(@NonNull Call<ListaResponse> call, @NonNull Response<ListaResponse> response) {
                if (response.isSuccessful()) {
                    ListaResponse listaResponse = response.body();

                    if (listaResponse != null) {
                        SqliteRestaurante restaurante = new SqliteRestaurante(MainActivity.this);
                        ArrayList<ModeloRestaurante> restauranteArrayList = listaResponse.getListModeloRestaurante();
                        restaurante.update(restauranteArrayList);
                    }
                    setProgressBar(3);
                }else{
                    setProgressBar(0);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ListaResponse> call, @NonNull Throwable t) {
                setProgressBar(0);
            }
        });
    }

    private void updateSQLiteLugares() {
        TurismoFirebaseService turismoFirebaseService = (new TurismoCliente(new LugarResponseTypeAdapter())).getService();

        Call<ListaResponse> responseCall = turismoFirebaseService.getListLugarTuristico();
        responseCall.enqueue(new Callback<ListaResponse>() {
            @Override
            public void onResponse(@NonNull Call<ListaResponse> call, @NonNull Response<ListaResponse> response) {
                if (response.isSuccessful()) {
                    ListaResponse listaResponse = response.body();

                    if (listaResponse != null) {
                        SqliteLugar sqliteLugar = new SqliteLugar(MainActivity.this);
                        ArrayList<ModeloLugarTuristico> lugarTuristico = listaResponse.getListModeloLugarTuristico();
                        sqliteLugar.update(lugarTuristico);
                    }
                    setProgressBar(4);
                }else {
                    setProgressBar(0);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ListaResponse> call, @NonNull Throwable t) {
                setProgressBar(0);
            }
        });
    }

    private void updateSQLitePuntaje() {
        TurismoFirebaseService turismoFirebaseService = (new TurismoCliente(new PuntajeResponseTypeAdapter())).getService();

        Call<ListaResponse> responseCall = turismoFirebaseService.getListPuntaje();
        responseCall.enqueue(new Callback<ListaResponse>() {
            @Override
            public void onResponse(@NonNull Call<ListaResponse> call, @NonNull Response<ListaResponse> response) {
                if (response.isSuccessful()) {
                    ListaResponse listaResponse = response.body();

                    if (listaResponse != null) {
                        SqliteHotel hotel = new SqliteHotel(MainActivity.this);
                        ArrayList<ModeloPuntaje> listPuntaje = listaResponse.getListPuntaje();
                        hotel.updatePuntajeSQLite(listPuntaje);//actualizar hotel sqlite
                    }
                    setProgressBar(5);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ListaResponse> call, @NonNull Throwable t) {
                setProgressBar(5);
            }
        });
    }

    private void showTextLarge(String message){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    private void showTextSmall(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
