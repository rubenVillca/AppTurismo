package com.hga.appturismo.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.hga.appturismo.R;
import com.hga.appturismo.api.TurismoAplicacion;
import com.hga.appturismo.base_datos.DataBaseSync;
import com.hga.appturismo.modelo.ModeloHotel;
import com.hga.appturismo.modelo.ModeloLugarTuristico;
import com.hga.appturismo.modelo.ModeloRestaurante;
import com.hga.appturismo.modelo.ModeloUsuario;
import com.hga.appturismo.provider.Listas;
import com.hga.appturismo.util.Constants;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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
                SearchView searchView = (SearchView) findViewById(R.id.action_search);
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
            case R.id.btnInsertar:
                Intent insertarLugar = new Intent(this, InsertarLugarActivity.class);
                startActivity(insertarLugar);
                break;
            case R.id.btnUsuarios:
                Intent listaUsuarios = new Intent(this, ListaUsuariosActivity.class);
                startActivity(listaUsuarios);
                break;
            default:
                System.out.println("error!. la accion selecionada no esta asociadda a ninguna funcion");
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        crearContenido();
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
                menu.findItem(R.id.action_reset).setVisible(true);//para resetear firebase y sqlite
                menu.findItem(R.id.action_close_login).setVisible(true);
                break;
            case Constants.USUARIO_ROL_NORMAL:
                menu.findItem(R.id.action_login).setVisible(false);
                menu.findItem(R.id.action_user_insert).setVisible(false);
                menu.findItem(R.id.action_edit_profile).setVisible(true);
                menu.findItem(R.id.action_reset).setVisible(false);
                menu.findItem(R.id.action_close_login).setVisible(true);
                break;
            default://no logueado
                menu.findItem(R.id.action_login).setVisible(true);
                menu.findItem(R.id.action_user_insert).setVisible(true);
                menu.findItem(R.id.action_edit_profile).setVisible(false);
                menu.findItem(R.id.action_reset).setVisible(true);//para resetear datos habilita a true y seleccionar
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
                resetData();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void crearContenido() {
        ImageButton btnMapaLugares = (ImageButton) findViewById(R.id.btnMapaLugar);
        btnMapaLugares.setOnClickListener(this);

        ImageButton btnMapaHoteles = (ImageButton) findViewById(R.id.btnMapaHoteles);
        btnMapaHoteles.setOnClickListener(this);

        ImageButton btnMapaRestaurantes = (ImageButton) findViewById(R.id.btnMapaRestaurantes);
        btnMapaRestaurantes.setOnClickListener(this);
        SharedPreferences sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE);
        int rol = sharedPreferences.getInt("rol", 0);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout_container_admin);
        LinearLayout linearLayoutUser = (LinearLayout) findViewById(R.id.layout_container_users);

        ImageView btnInsertar = (ImageView) findViewById(R.id.btnInsertar);
        btnInsertar.setOnClickListener(this);

        ImageButton btnUsuario = (ImageButton) findViewById(R.id.btnUsuarios);
        btnUsuario.setOnClickListener(this);

        switch (rol) {
            case Constants.USUARIO_ROL_ADMIN:
                linearLayout.setVisibility(View.VISIBLE);
                linearLayoutUser.setVisibility(View.VISIBLE);
                break;
            case Constants.USUARIO_ROL_NORMAL:
                linearLayout.setVisibility(View.VISIBLE);
                linearLayoutUser.setVisibility(View.GONE);
                break;
            default:
                linearLayout.setVisibility(View.GONE);
                linearLayoutUser.setVisibility(View.GONE);
                break;
        }
    }

    private DatabaseReference getDatabaseReferenceProvincia(TurismoAplicacion app, String provincia) {
        DatabaseReference postReference;
        switch (provincia) {
            case Constants.FIREBASE_PROVINCIA_ARANI:
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_ARANI);
                break;
            case Constants.FIREBASE_PROVINCIA_ARQUE:
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_ARQUE);
                break;
            case Constants.FIREBASE_PROVINCIA_AYOPAYA:
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_AYOPAYA);
                break;
            case Constants.FIREBASE_PROVINCIA_BOLIVAR:
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_BOLIVAR);
                break;
            case Constants.FIREBASE_PROVINCIA_CAMPERO:
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_CAMPERO);
                break;
            case Constants.FIREBASE_PROVINCIA_CAPINOTA:
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_CAPINOTA);
                break;
            case Constants.FIREBASE_PROVINCIA_CERCADO:
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_CERCADO);
                break;
            case Constants.FIREBASE_PROVINCIA_CHAPARE:
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_CHAPARE);
                break;
            case Constants.FIREBASE_PROVINCIA_ESTEBAN_ARZE:
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_ESTEBAN_ARZE);
                break;
            case Constants.FIREBASE_PROVINCIA_GERMAN_JORDAN:
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_GERMAN_JORDAN);
                break;
            case Constants.FIREBASE_PROVINCIA_JOSE_CARRASCO_TORRICO:
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_JOSE_CARRASCO_TORRICO);
                break;
            case Constants.FIREBASE_PROVINCIA_MIZQUE:
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_MIZQUE);
                break;
            case Constants.FIREBASE_PROVINCIA_PUNATA:
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_PUNATA);
                break;
            case Constants.FIREBASE_PROVINCIA_QUILLACOLLO:
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_QUILLACOLLO);
                break;
            case Constants.FIREBASE_PROVINCIA_TAPACARI:
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_TAPACARI);
                break;
            case Constants.FIREBASE_PROVINCIA_TIRAQUE:
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_TIRAQUE);
                break;
            default:
                postReference = app.getDataBaseReferenceLugarTuristico("");
                break;
        }
        return postReference;
    }

    public void goProvinciaActivity(View view) {
        Intent buscarPorProvincia = new Intent(this, BuscarPorProvinciaActivity.class);
        startActivity(buscarPorProvincia);
    }

    public void goTipoActivity(View view) {
        Intent buscarPorTipo = new Intent(this, BuscarPorTipoActivity.class);
        startActivity(buscarPorTipo);
    }
    private void resetData() {
        TurismoAplicacion app = (TurismoAplicacion) getApplicationContext();

        eliminarDatosSQlite();
        eliminarDatosFirebase(app);
        insertDatosFirebase(app);
    }

    private void eliminarDatosSQlite() {
        DataBaseSync dataBaseSync=new DataBaseSync(this);
        dataBaseSync.deleteAllSQLite();
    }

    private void eliminarDatosFirebase(final TurismoAplicacion app) {
        DatabaseReference postReference;
        //eliminar hoteles firebase
        postReference = app.getDataBaseReferenceHotel("");
        postReference.removeValue();
        //eliminar restaurantes firebase
        postReference = app.getDataBaseReferenceRestaurante("");
        postReference.removeValue();
        //eliinar lugares turisticos firebase
        postReference = getDatabaseReferenceProvincia(app, "");
        postReference.removeValue();
        //eliminar usuario autenticate firebase
        /*FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();//solo un usuario puede ver la lista de usuarios
        assert user != null;
        user.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    DatabaseReference postReference;
                    //eliminar usuarios firebase
                    postReference = app.getDataBaseReferenceUsuario();
                    postReference.removeValue();//eliminar de firebase

                    Log.d("Eliminado usuario", "Cuenta de usuario en firebase eliminada.");
                }
            }
        });*/
    }

    private void insertDatosFirebase(TurismoAplicacion app) {
        DatabaseReference postReference;

        Listas listas = new Listas();
        //insertar hoteles
        postReference = app.getDataBaseReferenceHotel("");
        ArrayList<ModeloHotel> listHotel = listas.getListaHoteles();
        for (ModeloHotel hotel : listHotel) {
            postReference.push().setValue(hotel);
        }
        //insertar restaurantes
        postReference = app.getDataBaseReferenceRestaurante("");
        ArrayList<ModeloRestaurante> restaurantes = listas.getListaRestaurantes();
        for (ModeloRestaurante r : restaurantes) {
            postReference.push().setValue(r);
        }
        //insertar lugares turisticos por provincia
        ArrayList<ModeloLugarTuristico> modeloLugarTuristicos = listas.getListaLugares();
        for (ModeloLugarTuristico modeloLugarTuristico : modeloLugarTuristicos) {
            String provincia = modeloLugarTuristico.getProvincia();
            postReference = getDatabaseReferenceProvincia(app, provincia);
            postReference.push().setValue(modeloLugarTuristico);
        }
        //insertar usuarios autenhticate firebase and database firebase
        /*ArrayList<ModeloUsuario> usuarios = listas.getListaUsuarios();
        for (ModeloUsuario m : usuarios) {
            postReference = app.getDataBaseReferenceUsuario(m.getIdFirebase());
            postReference.setValue(m);

            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
            firebaseAuth.createUserWithEmailAndPassword(m.getEmail().trim(), m.getContrasenia().trim()).addOnCompleteListener(
                    new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                //modeloUsuario.setIdFirebase(firebaseAuth.getCurrentUser().getUid());//no usado
                                Toast.makeText(MainActivity.this, "Usuario creado exitosamente", Toast.LENGTH_SHORT).show();

                            } else {
                                Toast.makeText(MainActivity.this, "Usuario no creado," +
                                        " por que la contraseña es demasiado corta" +
                                        " o porque el usuario ya existe", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
            );
        }*/

    }
}
