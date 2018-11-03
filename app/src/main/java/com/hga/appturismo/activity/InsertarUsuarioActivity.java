package com.hga.appturismo.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.hga.appturismo.R;
import com.hga.appturismo.bdFirebase.TurismoAplicacion;
import com.hga.appturismo.bdSQLite.DBSQLiteParent;
import com.hga.appturismo.bdSQLite.SqliteUsuario;
import com.hga.appturismo.modelo.ModeloUsuario;
import com.hga.appturismo.util.Constants;


/**
 * Created by HGA on 11/10/2017
 */

public class InsertarUsuarioActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText txt_nombre;
    private EditText txt_apellido;
    private EditText txt_email;
    private EditText txt_telefono;
    private EditText txt_pwd;
    private EditText txt_rol_user;


    private Spinner spinnerRolUser;

    private View focusView = null;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_usuario);
        init();
        initSpinnerRolUser();
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
        spinnerRolUser = findViewById(R.id.spinner_rolUser);
        txt_nombre = findViewById(R.id.txt_nombre);
        txt_apellido = findViewById(R.id.txt_apellido);
        txt_email = findViewById(R.id.txt_email);
        txt_email.setEnabled(true);
        txt_telefono = findViewById(R.id.txt_telefono);
        txt_pwd = findViewById(R.id.txt_pwd);
        button = findViewById(R.id.btn_editar_usuario);
        button.setOnClickListener(this);
    }

    private void insertarUsuarioFirebaseUser(ModeloUsuario modeloUsuario) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(modeloUsuario.getEmail(), modeloUsuario.getContrasenia()).addOnCompleteListener(
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //modeloUsuario.setIdFirebase(firebaseAuth.getCurrentUser().getUid());//no usado
                            Toast.makeText(InsertarUsuarioActivity.this, "Usuario creado exitosamente", Toast.LENGTH_SHORT).show();
                            resetData();
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
    private void resetData(){
        txt_nombre.setText("");
        txt_apellido.setText("");
        txt_email.setText("");
        txt_telefono.setText("");
        txt_pwd.setText("");
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    private ModeloUsuario insertarUsuarioFirebaseStorage() {
        ModeloUsuario modeloUsuario = getModeloUsuario();

        TurismoAplicacion app = (TurismoAplicacion) getApplicationContext();

        DatabaseReference databaseReference;
        databaseReference = app.getDataBaseReferenceUsuario("");

        databaseReference.child(modeloUsuario.getIdFirebase()).setValue(modeloUsuario);//insertar en bd bdFirebase

        return modeloUsuario;
    }

    private ModeloUsuario getModeloUsuario() {
        ModeloUsuario modeloUsuario = new ModeloUsuario();
        //modeloUsuario.setRol(spinnerRolUser.getSelectedItem().toString());
        modeloUsuario.setNombre(txt_nombre.getText().toString());
        modeloUsuario.setApellido(txt_apellido.getText().toString());
        modeloUsuario.setEmail(txt_email.getText().toString());
        modeloUsuario.setIdFirebase(modeloUsuario.getEmail());
        modeloUsuario.setContrasenia(txt_pwd.getText().toString());
        modeloUsuario.setTelefono(txt_telefono.getText().toString());
        modeloUsuario.setRol(spinnerRolUser.getSelectedItemPosition()==0?Constants.USUARIO_ROL_ADMIN:Constants.USUARIO_ROL_REVISOR);
        return modeloUsuario;
    }

    private void initSpinnerRolUser() {
        ArrayAdapter<CharSequence> adapterUsuario = ArrayAdapter.createFromResource(this, R.array.tipo_rol_user, android.R.layout.simple_spinner_item);
        adapterUsuario.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRolUser.setAdapter(adapterUsuario);
    }
    public void insertarUsuarioSQLite(View view) {
        SqliteUsuario usuario = new SqliteUsuario(this);
        Intent intent;

        switch (spinnerRolUser.getSelectedItemPosition()) {
            case 0://Administrador
                if (isValidUser()) {

                }
                break;
            case 1://Revisor
                if (isValidUser()) {
                }
                break;
            default:
                Toast.makeText(this, "Ocurrio un error: " + spinnerRolUser.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
                break;
        }
    }
    private boolean isValidUser() {
        boolean isValidUser = true;

        txt_rol_user.setError(null);
        txt_nombre.setError(null);
        txt_apellido.setError(null);
        txt_email.setError(null);
        txt_telefono.setError(null);
        txt_pwd.setError(null);
        focusView=null;
        //para el error en spinner Usuario
        TextView txt_rol_user = (TextView) spinnerRolUser.getSelectedView();
        txt_rol_user.setError(null);
        txt_rol_user.setTextColor(Color.RED);

        String userRol = txt_rol_user.getText().toString();
        String nombre = txt_nombre.getText().toString();
        String apellido = txt_apellido.getText().toString();
        String email = txt_email.getText().toString();
        String telefono = txt_telefono.getText().toString();
        String pwd = txt_pwd.getText().toString();

        if (userRol.isEmpty()) {
            txt_rol_user.setError("Seleccione un Rol");
            focusView = txt_rol_user;
            isValidUser = false;
        }
        if (nombre.isEmpty()) {
            txt_nombre.setError("Llenar Nombre");
            focusView = txt_nombre;
            isValidUser = false;
        }
        if (apellido.isEmpty()) {
            txt_apellido.setError("Llenar Apellido");
            focusView = txt_apellido;
            isValidUser = false;
        }
        if (email.isEmpty()) {
            txt_email.setError("Ingrese la email");
            focusView = txt_email;
            isValidUser = false;
        }
        if (telefono.isEmpty()) {
            txt_telefono.setError("Llenar descripción");
            focusView = txt_telefono;
            isValidUser = false;
        }
        if (pwd.isEmpty()) {
            txt_pwd.setError("Llenar contraseña");
            focusView = txt_pwd;
            isValidUser = false;
        }
        if (focusView!=null) {
            focusView.requestFocus();
        }
        return isValidUser;
    }

    @Override
    public void onClick(View view) {
        if (!txt_email.getText().toString().isEmpty()||!txt_pwd.getText().toString().isEmpty()) {
            ModeloUsuario modeloUsuario = insertarUsuarioFirebaseStorage();
            insertarUsuarioFirebaseUser(modeloUsuario);
        }else{
            Toast.makeText(this,"Email y contraseña son campos requerido",Toast.LENGTH_SHORT).show();
        }
    }
}
