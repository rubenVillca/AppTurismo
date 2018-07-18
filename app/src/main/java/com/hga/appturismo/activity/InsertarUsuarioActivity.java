package com.hga.appturismo.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.hga.appturismo.R;
import com.hga.appturismo.bdFirebase.TurismoAplicacion;
import com.hga.appturismo.modelo.ModeloUsuario;
import com.hga.appturismo.util.Constants;

/**
 * Created by HGA on 11/10/2017
 */

public class InsertarUsuarioActivity extends AppCompatActivity {
    private EditText txt_nombre;
    private EditText txt_apellido;
    private EditText txt_email;
    private EditText txt_telefono;
    private EditText txt_pwd;

    private LinearLayout layout_rol_user;
    private LinearLayout editar_layout_nombre_user;
    private LinearLayout editar_layout_apellido_user;
    private LinearLayout editar_layout_email_user;
    private LinearLayout editar_layout_telefono_user;
    private LinearLayout editar_layout_pwd_user;

    private Spinner spinnerRolUser;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_usuario);
        init();
        updateEditEmail();
    }

    private void updateEditEmail() {
        SharedPreferences sharedPreferences=getSharedPreferences("USER",MODE_PRIVATE);
        String email=sharedPreferences.getString("email","");
        if (email.isEmpty()) {
            txt_email.setEnabled(true);
        }
    }

    private void init() {
        txt_nombre = (EditText) findViewById(R.id.txt_nombre);
        txt_apellido = (EditText) findViewById(R.id.txt_apellido);
        txt_email = (EditText) findViewById(R.id.txt_email);
        txt_email.setEnabled(true);
        txt_telefono = (EditText) findViewById(R.id.txt_telefono);
        txt_pwd = (EditText) findViewById(R.id.txt_pwd);
        button = (Button) findViewById(R.id.btn_editar_usuario);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModeloUsuario modeloUsuario = insertarUsuarioFirebase();
                insertarUsuarioAutenticate(modeloUsuario);
            }
        });
    }

    private void insertarUsuarioAutenticate(ModeloUsuario modeloUsuario) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(modeloUsuario.getEmail(), modeloUsuario.getContrasenia()).addOnCompleteListener(
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //modeloUsuario.setIdFirebase(firebaseAuth.getCurrentUser().getUid());//no usado
                            Toast.makeText(InsertarUsuarioActivity.this, "Usuario creado exitosamente", Toast.LENGTH_SHORT).show();
                            goLogin();
                        }else{
                            Toast.makeText(InsertarUsuarioActivity.this, "Contraseña demasiado corta", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }

    private void goLogin() {
        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    private ModeloUsuario insertarUsuarioFirebase() {
        ModeloUsuario modeloUsuario = new ModeloUsuario();
        //modeloUsuario.setRol(spinnerRolUser.getSelectedItem().toString());
        modeloUsuario.setNombre(txt_nombre.getText().toString());
        modeloUsuario.setApellido(txt_apellido.getText().toString());
        modeloUsuario.setEmail(txt_email.getText().toString());
        modeloUsuario.setIdFirebase(modeloUsuario.getEmail());
        modeloUsuario.setContrasenia(txt_pwd.getText().toString());
        modeloUsuario.setTelefono(txt_telefono.getText().toString());
        modeloUsuario.setRol(Constants.USUARIO_ROL_REVISOR);

        TurismoAplicacion app = (TurismoAplicacion) getApplicationContext();

        DatabaseReference databaseReference;
        databaseReference = app.getDataBaseReferenceUsuario("");

        databaseReference.child(modeloUsuario.getIdFirebase()).setValue(modeloUsuario);//insertar en bd bdFirebase

        return modeloUsuario;
    }
    private void initSpinnerRolUser() {
        ArrayAdapter<CharSequence> adapterUsuario = ArrayAdapter.createFromResource(this, R.array.rol_user, android.R.layout.simple_spinner_item);
        adapterUsuario.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRolUser.setAdapter(adapterUsuario);

        ArrayAdapter<CharSequence> adapterRolUser = ArrayAdapter.createFromResource(this, R.array.rol_user, android.R.layout.simple_spinner_item);
        adapterRolUser.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRolUser.setAdapter(adapterRolUser);
        spinnerRolUser.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 1://usuario administrador
                        layout_rol_user.setVisibility(View.VISIBLE);
                        editar_layout_nombre_user.setVisibility(View.VISIBLE);
                        editar_layout_apellido_user.setVisibility(View.VISIBLE);
                        editar_layout_email_user.setVisibility(View.VISIBLE);
                        editar_layout_telefono_user.setVisibility(View.VISIBLE);
                        editar_layout_pwd_user.setVisibility(View.VISIBLE);
                        break;
                    case 2://usuario revisor
                        layout_rol_user.setVisibility(View.GONE);
                        editar_layout_nombre_user.setVisibility(View.VISIBLE);
                        editar_layout_apellido_user.setVisibility(View.VISIBLE);
                        editar_layout_email_user.setVisibility(View.VISIBLE);
                        editar_layout_telefono_user.setVisibility(View.VISIBLE);
                        editar_layout_pwd_user.setVisibility(View.VISIBLE);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
