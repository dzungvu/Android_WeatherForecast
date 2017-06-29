package com.software.dzungvu.model;

/**
 * Created by DzungVu on 6/29/2017.
 */

public class Temp {
    private double day;
    private double min;
    private double max;
    private double night;
    private double eve;
    private double morn;

    public Temp(double day, double min, double max, double night, double eve, double morn) {
        this.day = day;
        this.min = min;
        this.max = max;
        this.night = night;
        this.eve = eve;
        this.morn = morn;
    }

    public Temp() {
    }

    public double getDay() {
        return day - 273.15;
    }

    public void setDay(double day) {
        this.day = day;
    }

    public double getMin() {
        return min - 273.15;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max - 273.15;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getNight() {
        return night - 273.15;
    }

    public void setNight(double night) {
        this.night = night;
    }

    public double getEve() {
        return eve - 273.15;
    }

    public void setEve(double eve) {
        this.eve = eve;
    }

    public double getMorn() {
        return morn - 273.15;
    }

    public void setMorn(double morn) {
        this.morn = morn;
    }
}
