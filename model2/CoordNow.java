package com.software.dzungvu.model2;

/**
 * Created by DzungVu on 6/27/2017.
 */

public class CoordNow {
    private double lat;
    private double lon;

    public CoordNow(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
