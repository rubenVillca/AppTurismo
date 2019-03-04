package com.hga.appturismo.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.hga.appturismo.R;
import com.hga.appturismo.bdFirebase.ServiceFirebaseHoteles;
import com.hga.appturismo.bdFirebase.ServiceFirebaseLugaresTour;
import com.hga.appturismo.bdFirebase.ServiceFirebaseRestaurantes;
import com.hga.appturismo.bdFirebase.TurismoAplicacion;
import com.hga.appturismo.bdSQLite.SqliteHotel;
import com.hga.appturismo.bdSQLite.SqliteLugar;
import com.hga.appturismo.bdSQLite.SqliteRestaurante;
import com.hga.appturismo.imagenes.ImagenSwip;
import com.hga.appturismo.modelo.ModeloHotel;
import com.hga.appturismo.modelo.ModeloImagen;
import com.hga.appturismo.modelo.ModeloLugarTuristico;
import com.hga.appturismo.modelo.ModeloRestaurante;
import com.hga.appturismo.util.Constants;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DescripcionSugerenciaActivity extends AppCompatActivity implements View.OnClickListener{
    private ModeloRestaurante modeloRestaurante;
    private ModeloHotel modeloHotel;
    private ModeloLugarTuristico modeloLugarTuristico;
    private String type;
    private TurismoAplicacion aplicacion;

    private TextView textViewProvinciaText;
    private TextView textViewNombreText;
    private TextView textViewTipoText;
    private TextView textViewDescripcionText;
    private TextView textViewLineaText;
    private TextView textViewFechaText;
    private TextView textViewDireccionText;
    private TextView textViewTelefonoText;
    private TextView textViewHorariosTextLugar;
    private TextView textViewActividadText;
    private TextView textViewRegistradoPorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_sugerencia_turistico);

        crearContenido();
    }

    private void crearContenido() {
        setModelos();
        setTextView();
        setValue();
        setButtonAction();
    }

    private void setButtonAction() {
        Button buttonAceptar = findViewById(R.id.buttonAceptarSugerencia);
        buttonAceptar.setOnClickListener(this);

        Button buttonRechazar = findViewById(R.id.buttonRechazarSugerencia);
        buttonRechazar.setOnClickListener(this);
    }

    private void setTextView() {
        textViewProvinciaText = findViewById(R.id.textViewProvinciaText);
        textViewNombreText = findViewById(R.id.textViewNombreText);
        textViewTipoText = findViewById(R.id.textViewTipoText);
        textViewDescripcionText = findViewById(R.id.textViewDescripcion);
        textViewLineaText = findViewById(R.id.textViewLineaText);
        textViewFechaText = findViewById(R.id.textViewFechaText);
        textViewDireccionText = findViewById(R.id.textViewDireccionText);
        textViewTelefonoText = findViewById(R.id.textViewTelefonoText);
        textViewHorariosTextLugar = findViewById(R.id.textViewHorariosTextLugar);
        textViewActividadText = findViewById(R.id.textViewActividad);
        textViewRegistradoPorText = findViewById(R.id.textViewRegistradoPorText);
    }

    private void setModelos() {
        Bundle bundle=getIntent().getExtras();
        if (bundle!=null&&bundle.get("type")!=null){
            type=(String)bundle.get("type");
            switch (type){
                case "turistico":
                    modeloLugarTuristico=(ModeloLugarTuristico)bundle.get("modelTuristico");
                    break;
                case "hotel":
                    modeloHotel = (ModeloHotel) bundle.get("modelHotel");
                    break;
                case "restaurante":
                    modeloRestaurante=(ModeloRestaurante)bundle.get("modelRestaurante");
                    break;
                default:break;
            }
        }else {
            modeloHotel =new ModeloHotel();
            modeloRestaurante=new ModeloRestaurante();
            modeloLugarTuristico=new ModeloLugarTuristico();
            type="";
        }
    }

    private void setValue() {
        ViewPager viewPager = findViewById(R.id.imagenTurismo);
        ImagenSwip imagenSwip = new ImagenSwip(new ArrayList<ModeloImagen>(), this);
        if (type.equals("turistico")) {
            setValueLugarTuristico();
            imagenSwip = new ImagenSwip(modeloLugarTuristico.getImagenes(), this);
        }
        if (type.equals("restaurante")) {
            setValueRestaurante();
            imagenSwip = new ImagenSwip(modeloRestaurante.getImagenes(), this);
        }
        if (type.equals("hotel")) {
            setValueHotel();
            imagenSwip = new ImagenSwip(modeloHotel.getImagenes(), this);
        }

        viewPager.setAdapter(imagenSwip);
    }

    private void setValueHotel() {
        textViewProvinciaText.setText(modeloHotel.getProvincia());
        textViewNombreText.setText(modeloHotel.getNombre());
        //textViewTipoText.setText(modeloHotel.get());
        textViewDescripcionText.setText(modeloHotel.getActividad());
        textViewLineaText.setText(modeloHotel.getLinea());
        //textViewFechaText.setText(modeloHotel.get());
        textViewDireccionText.setText(modeloHotel.getDireccion());
        textViewTelefonoText.setText(String.valueOf(modeloHotel.getTelefono()));
        //textViewHorariosTextLugar.setText(modeloHotel.get());
        //textViewActividadText.setText(modeloHotel.get());
        textViewRegistradoPorText.setText(modeloHotel.getRegistradoPor());
    }

    private void setValueRestaurante() {
        textViewProvinciaText.setText(modeloRestaurante.getProvincia());
        textViewNombreText.setText(modeloRestaurante.getNombre());
        //textViewTipoText.setText(modeloRestaurante.get());
        textViewActividadText.setText(modeloRestaurante.getActividad());
        textViewLineaText.setText(modeloRestaurante.getLinea());
        //textViewFechaText.setText(modeloRestaurante.get());
        textViewDireccionText.setText(modeloRestaurante.getDireccion());
        textViewTelefonoText.setText(String.valueOf(modeloRestaurante.getTelefono()));
        textViewHorariosTextLugar.setText(modeloRestaurante.getHorario());
        //textViewActividadText.setText(modeloRestaurante.get());
        textViewRegistradoPorText.setText(modeloRestaurante.getRegistradoPor());
    }

    private void setValueLugarTuristico() {
        textViewProvinciaText.setText(modeloLugarTuristico.getProvincia());
        textViewNombreText.setText(modeloLugarTuristico.getNombre());
        textViewTipoText.setText(modeloLugarTuristico.getTipo());
        textViewLineaText.setText(modeloLugarTuristico.getLinea());
        textViewDireccionText.setText(modeloLugarTuristico.getDireccion());
        textViewTelefonoText.setText(String.valueOf(modeloLugarTuristico.getTelefono()));
        textViewHorariosTextLugar.setText(modeloLugarTuristico.getHorario());
        textViewActividadText.setText(modeloLugarTuristico.getActividad());
        textViewRegistradoPorText.setText(modeloLugarTuristico.getRegistradoPor());

        Calendar calendar=new GregorianCalendar();
        calendar.setTimeInMillis(Long.parseLong(modeloLugarTuristico.getFecha()));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM, yyyy");
        dateFormat.setTimeZone(calendar.getTimeZone());

        textViewFechaText.setText(dateFormat.format(calendar.getTime()));
    }

    @Override
    public void onClick(View view) {
        aplicacion=new TurismoAplicacion();
        if (view.getId()==R.id.buttonAceptarSugerencia){
            showDialogValidar();
        }
        if (view.getId()==R.id.buttonRechazarSugerencia){
            showDialogRechazar();
        }
    }

    private void showDialogRechazar() {
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Importante");
        dialogo1.setMessage("¿Desea rechazar la Sugerencia?");
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                rechazarSugerencia();
            }
        });
        dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {

            }
        });
        dialogo1.show();
    }

    private void rechazarSugerencia() {
        if(type.equals("turistico")) {
            ServiceFirebaseLugaresTour serviceFirebaseLugaresTour = new ServiceFirebaseLugaresTour();
            serviceFirebaseLugaresTour.deleteLugarTuristico(aplicacion,modeloLugarTuristico);

            SqliteLugar sqliteLugar=new SqliteLugar(this);
            sqliteLugar.remove(modeloLugarTuristico);
        }
        if (type.equals("restaurante")){
            ServiceFirebaseRestaurantes serviceFirebaseRestaurantes=new ServiceFirebaseRestaurantes();
            serviceFirebaseRestaurantes.deleteRestaurante(aplicacion,modeloRestaurante);

            SqliteRestaurante sqliteRestaurante=new SqliteRestaurante(this);
            sqliteRestaurante.remove(modeloRestaurante);
        }
        if (type.equals("hotel")){
            ServiceFirebaseHoteles serviceFirebaseHoteles=new ServiceFirebaseHoteles();
            serviceFirebaseHoteles.deleteHotel(aplicacion,modeloHotel);

            SqliteHotel sqliteHotel=new SqliteHotel(this);
            sqliteHotel.remove(modeloHotel);
        }

        Toast.makeText(this,"Sugerencia Rechazada",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,ListaSugerirLugarActivity.class);
        startActivity(intent);
    }

    private void showDialogValidar() {
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Importante");
        dialogo1.setMessage("¿ Aprueba la Sugerencia?");
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                aceptarSugerencia();
            }
        });
        dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {

            }
        });
        dialogo1.show();
    }

    private void aceptarSugerencia() {
        DatabaseReference databaseReference;
        if(type.equals("turistico")) {
            modeloLugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
            ServiceFirebaseLugaresTour serviceFirebaseLugaresTour = new ServiceFirebaseLugaresTour();
            serviceFirebaseLugaresTour.deleteLugarTuristico(aplicacion,modeloLugarTuristico);

            databaseReference = aplicacion.getDataBaseReferenceLugarTuristico(modeloLugarTuristico.getProvincia());
            databaseReference.push().setValue(modeloLugarTuristico);

            SqliteLugar sqliteLugar=new SqliteLugar(this);
            sqliteLugar.remove(modeloLugarTuristico);
            sqliteLugar.insert(modeloLugarTuristico);
        }
        if (type.equals("restaurante")){
            modeloRestaurante.setEstado(Constants.ESTADO_RESTAURANTE_VISIBLE);
            ServiceFirebaseRestaurantes serviceFirebaseRestaurantes=new ServiceFirebaseRestaurantes();
            serviceFirebaseRestaurantes.deleteRestaurante(aplicacion,modeloRestaurante);

            databaseReference = aplicacion.getDataBaseReferenceRestaurante("");
            databaseReference.push().setValue(modeloRestaurante);

            SqliteRestaurante sqliteRestaurante=new SqliteRestaurante(this);
            sqliteRestaurante.remove(modeloRestaurante);
            sqliteRestaurante.insert(modeloRestaurante);
        }
        if (type.equals("hotel")){
            modeloHotel.setEstado(Constants.ESTADO_HOTEL_VISIBLE);
            ServiceFirebaseHoteles serviceFirebaseHoteles=new ServiceFirebaseHoteles();
            serviceFirebaseHoteles.deleteHotel(aplicacion,modeloHotel);

            databaseReference = aplicacion.getDataBaseReferenceHotel("");
            databaseReference.push().setValue(modeloHotel);

            SqliteHotel sqliteHotel=new SqliteHotel(this);
            sqliteHotel.remove(modeloHotel);
            sqliteHotel.insert(modeloHotel);
        }

        Toast.makeText(this,"Sugerencia Aceptada",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,ListaSugerirLugarActivity.class);
        startActivity(intent);
    }
}
