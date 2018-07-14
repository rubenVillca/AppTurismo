package com.hga.appturismo.bdFirebase;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.hga.appturismo.activity.MainActivity;
import com.hga.appturismo.bdFirebase.TurismoAplicacion;
import com.hga.appturismo.modelo.ModeloHotel;
import com.hga.appturismo.modelo.ModeloLugarTuristico;
import com.hga.appturismo.modelo.ModeloRestaurante;
import com.hga.appturismo.modelo.ModeloUsuario;
import com.hga.appturismo.provider.Listas;
import com.hga.appturismo.util.Constants;

import java.util.ArrayList;

/**
 * Created by HGA on 8/7/2018
 */
public class ResetFirebase {
    private TurismoAplicacion app;
    private MainActivity mainActivity;

    public ResetFirebase(TurismoAplicacion app, MainActivity mainActivity) {
        this.app = app;
        this.mainActivity = mainActivity;
    }

    /**
     * Eliminar datos existentes en bdFirebase e insertar los datos de la clase Listas en bdFirebase
     */
    public void resetDatosFirebase() {
        deleteHoteles(app);
        deleteRestaurantes(app);
        deleteLugaresTuristicos(app);
        //deleteUsuarios();

        Listas listas = new Listas();

        insertHoteles(app, listas);
        insertRestaurantes(app, listas);
        insertLugaresTuristicos(app, listas);
        //insertUsuarios(app, listas);
    }

    private void insertUsuarios(TurismoAplicacion app, Listas listas) {
        DatabaseReference postReference;//insertar usuarios autenhticate bdFirebase and database bdFirebase
        ArrayList<ModeloUsuario> usuarios = listas.getListaUsuarios();
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
                                Toast.makeText(mainActivity, "Usuario creado exitosamente", Toast.LENGTH_SHORT).show();

                            } else {
                                Toast.makeText(mainActivity, "Usuario no creado," +
                                        " por que la contraseña es demasiado corta" +
                                        " o porque el usuario ya existe", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
            );
        }
    }

    private void insertLugaresTuristicos(TurismoAplicacion app, Listas listas) {
        DatabaseReference postReference;//insertar lugares turisticos por provincia
        ArrayList<ModeloLugarTuristico> modeloLugarTuristicos = listas.getListaLugares();

        for (ModeloLugarTuristico modeloLugarTuristico : modeloLugarTuristicos) {
            String provincia = modeloLugarTuristico.getProvincia();
            postReference = getDatabaseReferenceProvincia(app, provincia);
            postReference.push().setValue(modeloLugarTuristico);
        }
    }

    private void insertRestaurantes(TurismoAplicacion app, Listas listas) {
        DatabaseReference postReference;//insertar restaurantes
        postReference = app.getDataBaseReferenceRestaurante("");
        ArrayList<ModeloRestaurante> restaurantes = listas.getListaRestaurantes();
        for (ModeloRestaurante r : restaurantes) {
            postReference.push().setValue(r);
        }
    }

    private void insertHoteles(TurismoAplicacion app, Listas listas) {
        DatabaseReference postReference;//insertar hoteles
        postReference = app.getDataBaseReferenceHotel("");
        ArrayList<ModeloHotel> listHotel = listas.getListaHoteles();
        for (ModeloHotel hotel : listHotel) {
            postReference.push().setValue(hotel);
        }
    }

    private void deleteUsuarios() {
        //eliminar usuario autenticate bdFirebase
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();//solo un usuario puede ver la lista de usuarios
        assert user != null;
        user.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    DatabaseReference postReference;
                    //eliminar usuarios bdFirebase
                    postReference = app.getDataBaseReferenceUsuario();
                    postReference.removeValue();//eliminar de bdFirebase

                    Log.d("Eliminado usuario", "Cuenta de usuario en bdFirebase eliminada.");
                }
            }
        });
    }

    private void deleteLugaresTuristicos(TurismoAplicacion app) {
        DatabaseReference postReference;//eliinar lugares turisticos bdFirebase
        postReference = app.getDataBaseReferenceLugarTuristico("");
        postReference.removeValue();
    }

    private void deleteRestaurantes(TurismoAplicacion app) {
        DatabaseReference postReference;//eliminar restaurantes bdFirebase
        postReference = app.getDataBaseReferenceRestaurante("");
        postReference.removeValue();
    }

    private void deleteHoteles(TurismoAplicacion app) {
        DatabaseReference postReference;//eliminar hoteles bdFirebase
        postReference = app.getDataBaseReferenceHotel("");
        postReference.removeValue();
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
}
