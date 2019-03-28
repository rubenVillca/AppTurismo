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
import com.hga.appturismo.modelo.ModeloRestaurante;
import com.hga.appturismo.util.Constants;

import java.util.Locale;

public class DescripcionRestauranteActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    private TextToSpeech tts;
    private ModeloRestaurante modeloRestaurante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_restaurante);

        recuperarDatos();
        actualizarContenido();
    }
    private void recuperarDatos() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            modeloRestaurante = (ModeloRestaurante) bundle.get("modeloRestaurante");
        }else {
            modeloRestaurante =new ModeloRestaurante();
        }
    }
    /**
     * Modificar la vista con datos del controlador
     */
    private void actualizarContenido() {
        TextView textViewNombre = findViewById(R.id.textViewNombreText);
        textViewNombre.setText(modeloRestaurante.getNombre());

        TextView textViewActividad = findViewById(R.id.textViewActividadTextView);
        textViewActividad.setText(modeloRestaurante.getActividad());

        TextView textViewDireccion = findViewById(R.id.textViewDireccionText);
        textViewDireccion.setText(modeloRestaurante.getDireccion());

        TextView textViewHorario = findViewById(R.id.textViewHorariosTextRestaurante);
        textViewHorario.setText(modeloRestaurante.getHorario());

        if (modeloRestaurante.getTelefono() > 0) {
            TextView textViewTelefonoText = findViewById(R.id.textViewTelefonoText);
            textViewTelefonoText.setText(String.valueOf(String.valueOf(modeloRestaurante.getTelefono())));
        } else {
            LinearLayout linearLayoutTelefono = findViewById(R.id.linearLayoutTelefono);
            linearLayoutTelefono.setVisibility(View.GONE);
        }

        if (modeloRestaurante.getLinea().isEmpty()) {
            LinearLayout linearLayoutLinea =findViewById(R.id.linearLayoutLinea);
            linearLayoutLinea.setVisibility(View.GONE);
        }else {
            TextView textViewLineaText = findViewById(R.id.textViewLineaText);
            textViewLineaText.setText(modeloRestaurante.getLinea());
        }
        if (modeloRestaurante.getPaginaWeb().isEmpty()) {
            LinearLayout linearLayoutPaginaWeb =findViewById(R.id.linearLayoutPaginaWeb);
            linearLayoutPaginaWeb.setVisibility(View.GONE);
        }else {
            TextView textViewPagWebText = findViewById(R.id.textViewPagWebText);
            textViewPagWebText.setText(modeloRestaurante.getPaginaWeb());
        }
        if (modeloRestaurante.getEmail().isEmpty()) {
            LinearLayout linearLayoutEmail =findViewById(R.id.linearLayoutEmail);
            linearLayoutEmail.setVisibility(View.GONE);
        }else {
            TextView textViewEmailText = findViewById(R.id.textViewEmailText);
            textViewEmailText.setText(modeloRestaurante.getEmail());
        }

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
                if (tts!=null)
                    tts.stop();
                LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                    Intent intent = new Intent(DescripcionRestauranteActivity.this, MapaRestaurantesActivity.class);
                    intent.putExtra("nombre", modeloRestaurante.getNombre());
                    startActivity(intent);
                } else {
                    Toast.makeText(DescripcionRestauranteActivity.this, "Habilite el GPS", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //imagenes
        ViewPager viewPager = findViewById(R.id.imagenTurismo);
        ImagenSwip imagenSwip = new ImagenSwip(modeloRestaurante.getImagenes(), this);
        viewPager.setAdapter(imagenSwip);

        SharedPreferences sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE);
        int rol = sharedPreferences.getInt("rol", 0);
        if (rol== Constants.USUARIO_ROL_ADMIN && !modeloRestaurante.getRegistradoPor().isEmpty()){
            LinearLayout linearLayout=findViewById(R.id.linearLayoutRegistradoPor);
            linearLayout.setVisibility(View.VISIBLE);

            TextView textViewRegistradoPor= findViewById(R.id.textViewRegistradoPorText);
            textViewRegistradoPor.setText(modeloRestaurante.getRegistradoPor());
        }
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
        String text = "Servicio de Alimentación: "+ modeloRestaurante.getNombre()
                +". Direccion: "+ modeloRestaurante.getDireccion();

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
