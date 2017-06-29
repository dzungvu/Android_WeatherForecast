package com.software.dzungvu.model;

import java.util.List;

/**
 * Created by DzungVu on 6/29/2017.
 */

public class OpenWeatherMap {
    private City city;
    private int cod;
    private double message;
    private int cnt;
    private List<MyList>list;

    public OpenWeatherMap() {
    }

    public OpenWeatherMap(City city, int cod, double message, int cnt, List<MyList> list) {
        this.city = city;
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public List<MyList> getList() {
        return list;
    }

    public void setList(List<MyList> list) {
        this.list = list;
    }
}
