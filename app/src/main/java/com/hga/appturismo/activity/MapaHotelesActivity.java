package com.hga.appturismo.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.hga.appturismo.R;
import com.hga.appturismo.mapas.DirectionFinder;
import com.hga.appturismo.mapas.DirectionFinderListener;
import com.hga.appturismo.mapas.Route;
import com.hga.appturismo.modelo.ModeloHotel;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class MapaHotelesActivity extends MapsActivity implements GoogleMap.OnMarkerClickListener,OnMapReadyCallback,DirectionFinderListener {
    private ModeloHotel modeloHotel;
    @Override
    public void onMapReady(GoogleMap googleMap) {
        super.onMapReady(googleMap);
        setHotel();
        //marcador principal
        setMarcadoresHoteles();
        miUbicacion();
        trazarRuta();
        mMap.animateCamera(cameraUpdate);
    }

    private void setHotel() {
        Bundle bundle=getIntent().getExtras();
        if (bundle!=null) {
            String nombreMarcador = bundle.getString("nombre");
            modeloHotel = listaHotel.getItem(nombreMarcador);
        }
    }

    private void trazarRuta() {
        if (myLocationGPS != null &&cameraUpdate!=null&& modeloHotel !=null) {
            String origin = myLocationGPS.getLatitude() + "," + myLocationGPS.getLongitude();
            String destination = modeloHotel.getGpsX() + "," + modeloHotel.getGpsY();
            try {
                new DirectionFinder(this, origin, destination).execute();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    protected void setMarcadoresHoteles() {
        ArrayList<ModeloHotel> hoteles=listaHotel.list();
        for (ModeloHotel lugar :hoteles){
            LatLng lugarHotel = new LatLng(lugar.getGpsX(), lugar.getGpsY());
            mMap.addMarker(new MarkerOptions().position(lugarHotel)
                    .title(lugar.getNombre())
                    .snippet(lugar.getDireccion())
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador_hotel)));
            cameraUpdate = CameraUpdateFactory.newLatLngZoom(lugarHotel, ZOOM_MAP);
        }

        mMap.setOnMarkerClickListener(this);
    }

    @Override
   public boolean onMarkerClick(Marker marker) {
       final String name = marker.getTitle();
       ArrayList<ModeloHotel> listaHotels = listaHotel.list();
       for (final ModeloHotel mHotel : listaHotels) {
           if (mHotel.getNombre().equals(name)) {
               Snackbar.make(findViewById(R.id.map), "" + marker.getTitle(), Snackbar.LENGTH_LONG).setAction("Ver detalles", new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent intent = new Intent(MapaHotelesActivity.this, DescripcionHotelActivity.class);
                       intent.putExtra("modeloHotel",mHotel );
                       startActivity(intent);
                   }
               }).show();
           }
       }
       return true;
   }
    @Override
    public void onDirectionFinderStart() {
        progressDialog = ProgressDialog.show(this, "Espere un momento.", "Buscando ruta..!", true);

        if (originMarkers != null) {
            for (Marker marker : originMarkers) {
                marker.remove();
            }
        }

        if (destinationMarkers != null) {
            for (Marker marker : destinationMarkers) {
                marker.remove();
            }
        }

        if (polylinePaths != null) {
            for (Polyline polyline : polylinePaths) {
                polyline.remove();
            }
        }
    }

    @Override
    public void onDirectionFinderSuccess(List<Route> route) {
        progressDialog.dismiss();
        polylinePaths = new ArrayList<>();
        originMarkers = new ArrayList<>();
        destinationMarkers = new ArrayList<>();


        for (Route ruta : route) {
            ((TextView) findViewById(R.id.tvDuration)).setText(ruta.duration.text);
            ((TextView) findViewById(R.id.tvDistance)).setText(ruta.distance.text);

            originMarkers.add(mMap.addMarker(new MarkerOptions()
                    .title("Yo")
                    .snippet(ruta.startAddress)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                    .position(ruta.startLocation)));

            PolylineOptions polylineOptions = new PolylineOptions().
                    geodesic(true).
                    color(Color.BLUE).
                    width(8);

            for (int i = 0; i < ruta.points.size(); i++)
                polylineOptions.add(ruta.points.get(i));

            polylinePaths.add(mMap.addPolyline(polylineOptions));

            cameraUpdate = CameraUpdateFactory.newLatLngZoom(ruta.startLocation, ZOOM_MAP);
        }
        if (polylinePaths.isEmpty()){
            Toast.makeText(this, "Ruta no encontrada", Toast.LENGTH_LONG).show();
        }
    }
}
