package com.hga.appturismo.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.LocationManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hga.appturismo.R;
import com.hga.appturismo.imagenes.ImagenSwip;
import com.hga.appturismo.modelo.ModeloLugarTuristico;
import com.hga.appturismo.util.Constants;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DescripcionLugarTuristicoActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    private TextToSpeech tts;
    private ModeloLugarTuristico modeloLugarTuristico;
    private String email;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_turistico);

        recuperarDatos();
        mostrarContenido();
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (tts != null) {
            tts.shutdown();
        }
    }

    @Override
    public void onInit(int status) {
        if (tts == null)
            tts = new TextToSpeech(this, this);
        if (status == TextToSpeech.SUCCESS) {
            int result = tts.setLanguage(Locale.getDefault());
            if (result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "Este lenguaje no es soportado");
            } else {
                //btn.setEnabled(true);
                speakOut();
            }
        } else {
            Log.e("TTS", "Inicializacion del lenguaje es fallida");

        }
    }

    private void recuperarDatos() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            modeloLugarTuristico = (ModeloLugarTuristico) bundle.get("lugar");
        } else {
            modeloLugarTuristico = new ModeloLugarTuristico();
        }
    }

    /**
     * Modificar la vista con datos del controlador
     */
    private void mostrarContenido() {
        //texto a modificar
        TextView textViewProvinciaText = findViewById(R.id.textViewProvinciaText);
        textViewProvinciaText.setText(modeloLugarTuristico.getProvincia());

        TextView textViewTipoText = findViewById(R.id.textViewTipoText);
        textViewTipoText.setText(modeloLugarTuristico.getTipo());

        TextView textViewNombreText = findViewById(R.id.textViewNombreText);
        textViewNombreText.setText(modeloLugarTuristico.getNombre());

        TextView textViewDescripcionText = findViewById(R.id.textViewDescripcionTextView);
        textViewDescripcionText.setText(modeloLugarTuristico.getDescripcion());

        TextView textViewActividadText = findViewById(R.id.textViewActividadTextView);
        textViewActividadText.setText(modeloLugarTuristico.getActividad());

        TextView textViewDireccionText = findViewById(R.id.textViewDireccionText);
        textViewDireccionText.setText(modeloLugarTuristico.getDireccion());

        if (modeloLugarTuristico.getTelefono() > 0) {
            TextView textViewTelefonoText = findViewById(R.id.textViewTelefonoText);
            textViewTelefonoText.setText(String.valueOf(String.valueOf(modeloLugarTuristico.getTelefono())));
        } else {
            LinearLayout linearLayoutTelefono = findViewById(R.id.linearLayoutTelefono);
            linearLayoutTelefono.setVisibility(View.GONE);
        }

        TextView textViewHorariosText = findViewById(R.id.textViewHorariosTextLugar);
        textViewHorariosText.setText(modeloLugarTuristico.getHorario());

        if (modeloLugarTuristico.getLinea().isEmpty()) {
            LinearLayout linearLayoutLinea = findViewById(R.id.linearLayoutLinea);
            linearLayoutLinea.setVisibility(View.GONE);
        } else {
            TextView textViewLineaText = findViewById(R.id.textViewLineaText);
            textViewLineaText.setText(modeloLugarTuristico.getLinea());
        }
        if (modeloLugarTuristico.getFecha().isEmpty()) {
            LinearLayout linearLayoutFecha = findViewById(R.id.linearLayoutFecha);
            linearLayoutFecha.setVisibility(View.GONE);
        } else {
            calendar = new GregorianCalendar();
            calendar.setTimeInMillis(Long.parseLong(modeloLugarTuristico.getFecha()));
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM, yyyy");
            dateFormat.setTimeZone(calendar.getTimeZone());

            TextView textViewFechaText = findViewById(R.id.textViewFechaText);
            textViewFechaText.setText(dateFormat.format(calendar.getTime()));
        }

        if (modeloLugarTuristico.getHorario().isEmpty()) {
            LinearLayout linearLayoutHorario = findViewById(R.id.linearLayoutHorario);
            linearLayoutHorario.setVisibility(View.GONE);
        } else {
            textViewHorariosText.setText(modeloLugarTuristico.getHorario());
        }
        if (modeloLugarTuristico.getActividad().isEmpty()) {
            LinearLayout linearLayoutActividad = findViewById(R.id.linearLayoutActividad);
            linearLayoutActividad.setVisibility(View.GONE);
        } else {
            textViewActividadText.setText(modeloLugarTuristico.getActividad());
        }

        //botones
        Button buttonAudio = findViewById(R.id.buttonAudio);
        buttonAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut();
            }
        });
        Button buttonTrazarRuta = findViewById(R.id.buttonTrazarRuta);
        buttonTrazarRuta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tts != null)
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
        ViewPager viewPager = findViewById(R.id.imagenTurismo);
        ImagenSwip imagenSwip = new ImagenSwip(modeloLugarTuristico.getImagenes(), this);
        viewPager.setAdapter(imagenSwip);

        SharedPreferences sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE);
        int rol = sharedPreferences.getInt("rol", 0);
        if (rol == Constants.USUARIO_ROL_ADMIN && !modeloLugarTuristico.getRegistradoPor().isEmpty()) {
            LinearLayout linearLayout = findViewById(R.id.linearLayoutRegistradoPor);
            linearLayout.setVisibility(View.VISIBLE);

            TextView textViewRegistradoPor = findViewById(R.id.textViewRegistradoPorText);
            textViewRegistradoPor.setText(modeloLugarTuristico.getRegistradoPor());
        }
    }

    private void speakOut() {
        if (tts == null)
            tts = new TextToSpeech(this, this);
        String text = "Lugar Turístico: " + modeloLugarTuristico.getNombre()
                + ". Descripcion: " + modeloLugarTuristico.getDescripcion()
                + ". Actividades: " + modeloLugarTuristico.getActividad()
                + ". Provincia: " + modeloLugarTuristico.getProvincia();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
}
