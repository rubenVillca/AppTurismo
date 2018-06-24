package com.hga.appturismo.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hga.appturismo.R;
import com.hga.appturismo.api.TurismoAplicacion;
import com.hga.appturismo.modelo.ModeloUsuario;
import com.hga.appturismo.util.Constants;

/**
 * Created by HGA on 11/10/2017
 */

public class EditarUsuarioActivity extends AppCompatActivity {
    private TurismoAplicacion app;
    private DatabaseReference databaseReference;

    private ModeloUsuario modeloUsuarioOld;
    private ModeloUsuario modeloUsuarioNew;

    private EditText txt_nombre;
    private EditText txt_apellido;
    private EditText txt_email;
    private EditText txt_telefono;
    private EditText txt_pwd;

    private Button button_editar;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_usuario);
        getDatos();
        initLayout();
        initPerfil();
    }

    private void getDatos() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            modeloUsuarioOld = (ModeloUsuario) bundle.get("modeloUsuario");
        } else {
            modeloUsuarioOld = new ModeloUsuario();
            SharedPreferences sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE);
            int rol=sharedPreferences.getInt("rol",0);
            modeloUsuarioOld.setRol(rol);
        }
    }

    private void initPerfil() {
        if (modeloUsuarioOld.getEmail().isEmpty()) {
            SharedPreferences sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE);
            email = sharedPreferences.getString("email", "");
            if (!email.isEmpty()) {
                recuperarPerfilFirebase(ModeloUsuario.encriptar(email), email);
            }
        } else {
            recuperarPerfilFirebase(ModeloUsuario.encriptar(modeloUsuarioOld.getEmail()), modeloUsuarioOld.getEmail());
        }
    }

    private void recuperarPerfilFirebase(String emailEncriptado, final String email) {
        DatabaseReference usuario = FirebaseDatabase.getInstance().getReference().child(Constants.FIREBASE_DATABASE_USUARIO).child(emailEncriptado);

        usuario.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                    modeloUsuarioOld.setNombre(dataSnapshot.child("nombre").getValue().toString());
                    modeloUsuarioOld.setApellido(dataSnapshot.child("apellido").getValue().toString());
                    modeloUsuarioOld.setContrasenia(dataSnapshot.child("contrasenia").getValue().toString());
                    modeloUsuarioOld.setEmail(dataSnapshot.child("email").getValue().toString());
                    modeloUsuarioOld.setIdFirebase(dataSnapshot.child("idFirebase").getValue().toString());
                    modeloUsuarioOld.setIdSqlite(Integer.parseInt(dataSnapshot.child("idSqlite").getValue().toString()));
                    modeloUsuarioOld.setTelefono(dataSnapshot.child("telefono").getValue().toString());

                    mostrarPerfilUsuario();
                } catch (NullPointerException e) {
                    e.printStackTrace();
                    txt_email.setText(email);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                txt_email.setText(email);
                Log.e("Error", "Error!", databaseError.toException());
            }
        });
    }

    private void mostrarPerfilUsuario() {
        txt_nombre.setText(modeloUsuarioOld.getNombre());
        txt_apellido.setText(modeloUsuarioOld.getApellido());
        txt_email.setText(modeloUsuarioOld.getEmail());
        txt_telefono.setText(String.valueOf(modeloUsuarioOld.getTelefono()));
        txt_pwd.setText(modeloUsuarioOld.getContrasenia());
    }

    /**
     * recuperar las variables de la vista activity_editar_usuario
     * que se usaran en la opracion de edicion
     */
    private void initLayout() {
        txt_nombre = (EditText) findViewById(R.id.txt_nombre);
        txt_apellido = (EditText) findViewById(R.id.txt_apellido);
        txt_email = (EditText) findViewById(R.id.txt_email);
        txt_telefono = (EditText) findViewById(R.id.txt_telefono);
        txt_pwd = (EditText) findViewById(R.id.txt_pwd);

        button_editar = (Button) findViewById(R.id.btn_editar_usuario);
        button_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recuperarDatos();
                actualizarFirebase();
                actualizarSQLite();
                goMainActivity();
            }
        });
    }

    /**
     * recuperar los datos insertados en el layout "activity_editar_usuario"
     * y guardarlos en el objeto modeloUsuarioOld
     */
    private void recuperarDatos() {
        modeloUsuarioNew = new ModeloUsuario();
        modeloUsuarioNew.setNombre(txt_nombre.getText().toString());
        modeloUsuarioNew.setApellido(txt_apellido.getText().toString());
        modeloUsuarioNew.setEmail(txt_email.getText().toString());
        modeloUsuarioNew.setTelefono(txt_telefono.getText().toString());
        modeloUsuarioNew.setContrasenia(txt_pwd.getText().toString());
        modeloUsuarioNew.setIdFirebase(modeloUsuarioNew.getEmail());
        modeloUsuarioNew.setIdSqlite(modeloUsuarioOld.getIdSqlite());
        modeloUsuarioNew.setRol(modeloUsuarioOld.getRol());
        modeloUsuarioNew.setEstado(modeloUsuarioOld.getEstado());
    }

    /**
     * guardar los cambios en firebase para usuario
     */
    private void actualizarFirebase() {
        app = (TurismoAplicacion) getApplicationContext();
        databaseReference = app.getDataBaseReferenceUsuario(modeloUsuarioNew.getIdFirebase());
        databaseReference.setValue(modeloUsuarioNew);

        if (modeloUsuarioNew.getContrasenia().length() > 5) {//actualizar contrasena solo si esta tiene mas de 5 caracteres
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

            assert user != null;
            user.updatePassword(modeloUsuarioNew.getContrasenia()).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Log.d("Contrasena actualizada", "el usuario actualizao la contraseña");
                    }
                }
            });
        }
    }

    /**
     * actualizar los datos en la base d datos SQLite
     */
    private void actualizarSQLite() {

    }

    private void goMainActivity() {
        Toast.makeText(this, "Perfil de usuario modificado correctamente", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
