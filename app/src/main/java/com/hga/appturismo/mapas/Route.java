package com.hga.appturismo.mapas;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

public class Route {
    public Distance distance;
    public Distance distanceWalking;
    public Duration duration;
    public Duration durationWalking;
    public String endAddress;
    public LatLng endLocation;
    public String startAddress;
    public LatLng startLocation;

    public List<LatLng> points;
}
