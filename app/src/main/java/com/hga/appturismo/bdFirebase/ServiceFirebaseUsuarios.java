package com.hga.appturismo.bdFirebase;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.hga.appturismo.activity.MainActivity;
import com.hga.appturismo.modelo.ModeloUsuario;
import com.hga.appturismo.provider.Listas;

import java.util.ArrayList;

/**
 * Created by HGA on 21/7/2018
 */
public class ServiceFirebaseUsuarios extends ServiceFirebase {

    ServiceFirebaseUsuarios(MainActivity mainActivity) {
        super(mainActivity);
    }

    public void insert(TurismoAplicacion app, Listas listas) {
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
                                Toast.makeText(mainActivity, "Usuario no creado, por que la contraseña es demasiado corta o porque el usuario ya existe", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
            );
        }
    }

    public void delete(final TurismoAplicacion app,ArrayList<ModeloUsuario> modeloUsuarios) {
        //eliminar usuario autenticate bdFirebase
        //final FirebaseAuth auth = FirebaseAuth.getInstance();//solo un usuario puede ver la lista de usuarios
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        for (final ModeloUsuario modeloUsuario:modeloUsuarios){
            if (user != null) {
                AuthCredential credential = EmailAuthProvider.getCredential(modeloUsuario.getEmail().trim(), modeloUsuario.getContrasenia().trim());
                user.reauthenticate(credential).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        user.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    DatabaseReference postReference;
                                    //eliminar usuarios bdFirebase
                                    postReference = app.getDataBaseReferenceUsuario(modeloUsuario.getIdFirebase());
                                    postReference.removeValue();//eliminar de bdFirebase

                                    Log.d("Eliminado usuario", "Cuenta de usuario en bdFirebase eliminada.");
                                }
                            }
                        });
                    }
                });
            }
        }
    }
}
