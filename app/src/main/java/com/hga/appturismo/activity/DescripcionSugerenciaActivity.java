package com.hga.appturismo.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hga.appturismo.R;
import com.hga.appturismo.imagenes.ImagenSwip;
import com.hga.appturismo.modelo.ModeloHotel;
import com.hga.appturismo.modelo.ModeloImagen;
import com.hga.appturismo.modelo.ModeloLugarTuristico;
import com.hga.appturismo.modelo.ModeloRestaurante;

import java.util.ArrayList;

public class DescripcionSugerenciaActivity extends AppCompatActivity implements View.OnClickListener{
    private ModeloRestaurante modeloRestaurante;
    private ModeloHotel modeloHotel;
    private ModeloLugarTuristico modeloLugarTuristico;
    private String type;

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
        textViewDescripcionText = findViewById(R.id.textViewDescripcionText);
        textViewLineaText = findViewById(R.id.textViewLineaText);
        textViewFechaText = findViewById(R.id.textViewFechaText);
        textViewDireccionText = findViewById(R.id.textViewDireccionText);
        textViewTelefonoText = findViewById(R.id.textViewTelefonoText);
        textViewHorariosTextLugar = findViewById(R.id.textViewHorariosTextLugar);
        textViewActividadText = findViewById(R.id.textViewActividadText);
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
        textViewDescripcionText.setText(modeloHotel.getDescripcion());
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
        textViewDescripcionText.setText(modeloRestaurante.getDescripcion());
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
        textViewDescripcionText.setText(modeloLugarTuristico.getDescripcion());
        textViewLineaText.setText(modeloLugarTuristico.getLinea());
        textViewFechaText.setText(modeloLugarTuristico.getFecha());
        textViewDireccionText.setText(modeloLugarTuristico.getDireccion());
        textViewTelefonoText.setText(String.valueOf(modeloLugarTuristico.getTelefono()));
        textViewHorariosTextLugar.setText(modeloLugarTuristico.getHorario());
        textViewActividadText.setText(modeloLugarTuristico.getActividad());
        textViewRegistradoPorText.setText(modeloLugarTuristico.getRegistradoPor());
    }

    @Override
    public void onClick(View view) {
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

            }
        });
        dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {

            }
        });
        dialogo1.show();
    }

    private void showDialogValidar() {
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Importante");
        dialogo1.setMessage("¿ Aprueba la Sugerencia?");
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {

            }
        });
        dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {

            }
        });
        dialogo1.show();
    }
}
