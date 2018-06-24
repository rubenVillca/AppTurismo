package com.hga.appturismo.activity;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hga.appturismo.R;
import com.hga.appturismo.modelo.ModeloLugarTuristico;
import com.hga.appturismo.util.ImagenSwip;

import java.util.Locale;

public class DescripcionLugarTuristicoActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    private TextToSpeech tts;
    private ViewPager viewPager;
    private ImagenSwip imagenSwip;
    private ModeloLugarTuristico modeloLugarTuristico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_turistico);

        recuperarDatos();
        actualizarContenido();
    }
    private void recuperarDatos() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            modeloLugarTuristico = (ModeloLugarTuristico) bundle.get("lugar");
        }else {
            modeloLugarTuristico =new ModeloLugarTuristico();
        }
    }
    /**
     * Modificar la vista con datos del controlador
     */
    private void actualizarContenido() {
        //texto a modificar
        TextView textViewProvinciaText = (TextView) findViewById(R.id.textViewProvinciaText);
        textViewProvinciaText.setText(modeloLugarTuristico.getProvincia());

        TextView textViewTipoText = (TextView) findViewById(R.id.textViewTipoText);
        textViewTipoText.setText(modeloLugarTuristico.getTipo());

        TextView textViewNombreText = (TextView) findViewById(R.id.textViewNombreText);
        textViewNombreText.setText(modeloLugarTuristico.getNombre());

        TextView textViewDescripcionText = (TextView) findViewById(R.id.textViewDescripcionText);
        textViewDescripcionText.setText(modeloLugarTuristico.getDescripcion());

        TextView textViewDireccionText = (TextView) findViewById(R.id.textViewDireccionText);
        textViewDireccionText.setText(modeloLugarTuristico.getDireccion());

        TextView textViewTelefonoText = (TextView) findViewById(R.id.textViewTelefonoText);
        textViewTelefonoText.setText(String.valueOf(String.valueOf(modeloLugarTuristico.getTelefono())));

        TextView textViewHorariosText = (TextView) findViewById(R.id.textViewHorariosText);
        textViewHorariosText.setText(modeloLugarTuristico.getHorario());

        TextView textViewActividadText = (TextView) findViewById(R.id.textViewActividadText);
        textViewActividadText.setText(modeloLugarTuristico.getActividad());


        //botones
        Button buttonAudio = (Button) findViewById(R.id.buttonAudio);
        buttonAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut();
            }
        });
        Button buttonTrazarRuta = (Button) findViewById(R.id.buttonTrazarRuta);
        buttonTrazarRuta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tts!=null)
                    tts.stop();
                LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                    Intent intent = new Intent(DescripcionLugarTuristicoActivity.this, MapaLugaresActivity.class);
                    intent.putExtra("nombre", modeloLugarTuristico.getNombre());
                    startActivity(intent);
                } else {
                    Toast.makeText(DescripcionLugarTuristicoActivity.this, "Habilite el GPS", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //imagenes
        viewPager = (ViewPager) findViewById(R.id.imagenTurismo);
        imagenSwip = new ImagenSwip(modeloLugarTuristico.getImagenes(), this);
        viewPager.setAdapter(imagenSwip);
    }

    @Override
    public void onInit(int status) {
        if (tts==null)
            tts = new TextToSpeech(this, this);
        if(status == TextToSpeech.SUCCESS){
            int result = tts.setLanguage(Locale.getDefault());
            if (result == TextToSpeech.LANG_NOT_SUPPORTED){
                Log.e("TTS","Este lenguaje no es soportado");
            }else{
                //btn.setEnabled(true);
                speakOut();
            }
        }else{Log.e("TTS","Inicializacion del lenguaje es fallida");

        }
    }
    private void speakOut() {
        if (tts==null)
            tts = new TextToSpeech(this, this);
        String text = "Lugar Turístico: "+ modeloLugarTuristico.getNombre()
                +". Descripción: "+ modeloLugarTuristico.getDescripcion()
                +". Provincia: "+ modeloLugarTuristico.getProvincia();
        tts.speak(text,TextToSpeech.QUEUE_FLUSH,null);
    }

    @Override
    protected void onStop()
    {
        super.onStop();

        if(tts != null){
            tts.shutdown();
        }
    }

}
