package com.example.admin.weatherapplication.Pojo.Weather;

public class Coord {

    private double lon ;

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    private double lat;

    @Override
    public String toString() {
        return new StringBuilder("[").append(this.lat).append(this.lon).append("]").toString();
    }
}
