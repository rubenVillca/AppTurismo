package com.hga.appturismo.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.hga.appturismo.R;
import com.hga.appturismo.bdFirebase.TurismoAplicacion;
import com.hga.appturismo.imagenes.ImagenSwip;
import com.hga.appturismo.modelo.ModeloHotel;
import com.hga.appturismo.modelo.ModeloImagen;
import com.hga.appturismo.modelo.ModeloLugarTuristico;
import com.hga.appturismo.modelo.ModeloRestaurante;

import java.util.ArrayList;

public class DescripcionSugerenciaActivity extends AppCompatActivity {
    private ModeloRestaurante modeloRestaurante;
    private ModeloHotel modeloHotel;
    private ModeloLugarTuristico modeloLugarTuristico;
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_sugerencia_turistico);

        init();
        setValue();
    }

    private void setValue() {
        TextView textViewProvinciaText = findViewById(R.id.textViewProvinciaText);
        TextView textViewNombreText = findViewById(R.id.textViewNombreText);
        TextView textViewTipoText = findViewById(R.id.textViewTipoText);
        TextView textViewDescripcionText = findViewById(R.id.textViewDescripcionText);
        TextView textViewLineaText = findViewById(R.id.textViewLineaText);
        TextView textViewFechaText = findViewById(R.id.textViewFechaText);
        TextView textViewDireccionText = findViewById(R.id.textViewDireccionText);
        TextView textViewTelefonoText = findViewById(R.id.textViewTelefonoText);
        TextView textViewHorariosTextLugar = findViewById(R.id.textViewHorariosTextLugar);
        TextView textViewActividadText = findViewById(R.id.textViewActividadText);
        TextView textViewRegistradoPorText = findViewById(R.id.textViewRegistradoPorText);
        TurismoAplicacion app=(TurismoAplicacion)getApplicationContext();

        ViewPager viewPager = findViewById(R.id.imagenTurismo);
        ImagenSwip imagenSwip = new ImagenSwip(new ArrayList<ModeloImagen>(), this);
        if (type.equals("turistico")) {
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


            imagenSwip = new ImagenSwip(modeloLugarTuristico.getImagenes(), this);
        }
        if (type.equals("restaurante")) {
            textViewProvinciaText.setText(modeloRestaurante.getProvincia());
            textViewNombreText.setText(modeloRestaurante.getNombre());
            //textViewTipoText.setText(modeloRestaurante.get());
            textViewDescripcionText.setText(modeloRestaurante.getDescripcion());
            textViewLineaText.setText(modeloRestaurante.getLinea());
            //textViewFechaText.setText(modeloRestaurante.get());
            textViewDireccionText.setText(modeloRestaurante.getDireccion());
            textViewTelefonoText.setText(String.valueOf(modeloRestaurante.getTelefono()));
            //textViewHorariosTextLugar.setText(modeloRestaurante.get());
            //textViewActividadText.setText(modeloRestaurante.get());
            textViewRegistradoPorText.setText(modeloRestaurante.getRegistradoPor());

            imagenSwip = new ImagenSwip(modeloRestaurante.getImagenes(), this);
        }
        if (type.equals("hotel")) {
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

            imagenSwip = new ImagenSwip(modeloHotel.getImagenes(), this);
        }


        viewPager.setAdapter(imagenSwip);

    }

    private void init() {
        Bundle bundle=getIntent().getExtras();
        if (bundle!=null){
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
            }

        }else {
            modeloHotel =new ModeloHotel();
            modeloRestaurante=new ModeloRestaurante();
            modeloLugarTuristico=new ModeloLugarTuristico();
            type="";
        }
    }


}
