package com.hga.appturismo.activity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.hga.appturismo.R;
import com.hga.appturismo.bdSQLite.SqliteHotel;
import com.hga.appturismo.bdSQLite.SqliteLugar;
import com.hga.appturismo.bdSQLite.SqliteRestaurante;
import com.hga.appturismo.bdSQLite.SqliteUsuario;

import java.util.ArrayList;
import java.util.List;


@SuppressLint("Registered")
public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {
    public static int ZOOM_MAP = 13;
    protected GoogleMap mMap;

    protected SqliteUsuario listaUsuarios;
    protected SqliteRestaurante listaRestaurante;
    protected SqliteHotel listaHotel;
    protected SqliteLugar listaLugarTuristico;

    protected Location myLocationGPS;
    protected CameraUpdate cameraUpdate;
    protected ProgressDialog progressDialog;

    protected List<Marker> originMarkers = new ArrayList<>();
    protected List<Marker> destinationMarkers = new ArrayList<>();
    protected List<Polyline> polylinePaths = new ArrayList<>();
    protected static final int timeUpdate = 100;//tiempo para actualizar en el mapa

    private Marker markerPosicion=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        listaUsuarios = new SqliteUsuario(this);
        listaRestaurante = new SqliteRestaurante(this);
        listaHotel = new SqliteHotel(this);
        listaLugarTuristico = new SqliteLugar(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);//botones de zoom
    }

    protected void actualizarUbicacion(Location location) {
        if (location != null) {
            LatLng ubicacionActual = new LatLng(location.getLatitude(), location.getLongitude());
            CameraUpdate miUbicacion = CameraUpdateFactory.newLatLngZoom(ubicacionActual, ZOOM_MAP);

            if (markerPosicion==null){
                markerPosicion=mMap.addMarker(new MarkerOptions().position(ubicacionActual).title("Ubicacion actual"));

                mMap.animateCamera(miUbicacion);
                //mMap.moveCamera(CameraUpdateFactory.newLatLng(ubicacionActual));
            }else{
                markerPosicion.setPosition(ubicacionActual);
            }
        }
    }

    //para el gps
    protected void miUbicacion() {

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

            if (locationManager != null) {
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, timeUpdate, 0, locListener);
                myLocationGPS = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

                if (myLocationGPS == null) {//si en gps network_provider esta desactivado usar GPS_PROVIDER para obtener la ubicacion actual
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, timeUpdate, 0, locListener);
                    myLocationGPS = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                }
                if (myLocationGPS != null) {//si recupero la ubicacion desde el GPS
                    LatLng ubicacionActual = new LatLng(myLocationGPS.getLatitude(), myLocationGPS.getLongitude());
                    markerPosicion=mMap.addMarker(new MarkerOptions().position(ubicacionActual).title("Mi Posicion"));
                    cameraUpdate = CameraUpdateFactory.newLatLngZoom(ubicacionActual, ZOOM_MAP);
                }
            }
        }

    }

    protected LocationListener locListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            actualizarUbicacion(location);
        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {
        }

        @Override
        public void onProviderEnabled(String s) {
        }

        @Override
        public void onProviderDisabled(String s) {
        }
    };
}
