package com.software.dzungvu.model2;


import java.util.List;

/**
 * Created by DzungVu on 6/27/2017.
 */

public class OpenWeatherMapNow {
    private CoordNow coord;
    private List<Weather> weather;
    private String base;
    private MainNow main;
    private Wind wind;
    private RainNow rain;
    private CloudsNow clouds;
    private int dt;
    private Sys sys;
    private int id;
    private String name;
    private int cod;

    public OpenWeatherMapNow() {
    }

    public OpenWeatherMapNow(CoordNow coord, List<Weather> weather, String base, MainNow main, Wind wind, RainNow rain, CloudsNow clouds, int dt, Sys sys, int id, String name, int cod) {
        this.coord = coord;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.wind = wind;
        this.rain = rain;
        this.clouds = clouds;
        this.dt = dt;
        this.sys = sys;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    public CoordNow getCoord() {
        return coord;
    }

    public void setCoord(CoordNow coord) {
        this.coord = coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public MainNow getMain() {
        return main;
    }

    public void setMain(MainNow main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public RainNow getRain() {
        return rain;
    }

    public void setRain(RainNow rain) {
        this.rain = rain;
    }

    public CloudsNow getClouds() {
        return clouds;
    }

    public void setClouds(CloudsNow clouds) {
        this.clouds = clouds;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
}
