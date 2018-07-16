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
import com.hga.appturismo.imagenes.ImagenSwip;
import com.hga.appturismo.modelo.ModeloHotel;

import java.util.Locale;

public class DescripcionHotelActivity extends AppCompatActivity  implements TextToSpeech.OnInitListener{
    private TextToSpeech tts;
    private ModeloHotel modeloHotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_hotel);

        getDatos();
        actualizarContenido();
    }

    private void getDatos() {
        Bundle bundle=getIntent().getExtras();
        if (bundle!=null){
            modeloHotel = (ModeloHotel) bundle.get("modeloHotel");
        }else {
            modeloHotel =new ModeloHotel();
        }
    }

    /**
     * Modificar la vista con datos del controlador
     */
    private void actualizarContenido() {
        TextView textViewNombreText= findViewById(R.id.textViewNombreText);
        textViewNombreText.setText(modeloHotel.getNombre());

        TextView textViewDireccionText= findViewById(R.id.textViewDireccionText);
        textViewDireccionText.setText(modeloHotel.getDireccion());

        TextView textViewTelefonoText= findViewById(R.id.textViewTelefonoText);
        textViewTelefonoText.setText(String.valueOf(modeloHotel.getTelefono()));

        TextView textViewPagWebText= findViewById(R.id.textViewPagWebText);
        textViewPagWebText.setText(String.valueOf(modeloHotel.getPaginaWeb()));

        TextView textViewEmailText= findViewById(R.id.textViewEmailText);
        textViewEmailText.setText(String.valueOf(modeloHotel.getEmail()));

        Button buttonTrazarRuta= findViewById(R.id.buttonTrazarRuta);

        Button buttonAudio = findViewById(R.id.buttonAudio);
        buttonAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut();
            }
        });

        buttonTrazarRuta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tts!=null)
                    tts.stop();
                LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)||locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                    Intent intent = new Intent(DescripcionHotelActivity.this, MapaHotelesActivity.class);
                    intent.putExtra("nombre", modeloHotel.getNombre());
                    startActivity(intent);
                }else{
                    Toast.makeText(DescripcionHotelActivity.this,"Habilite el GPS",Toast.LENGTH_SHORT).show();
                }
            }
        });
        //imagenes
        ViewPager viewPager = findViewById(R.id.imagenTurismo);
        ImagenSwip imagenSwip = new ImagenSwip(modeloHotel.getImagenes(), this);
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
        String text = "Servicio de Hospedaje: "+ modeloHotel.getNombre()
                +". Direccion: "+ modeloHotel.getDireccion()
                +". Teléfono: "+ modeloHotel.getTelefono();
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
