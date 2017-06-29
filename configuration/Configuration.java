package com.software.dzungvu.configuration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by DzungVu on 6/29/2017.
 */

public class Configuration {
    public static String API_KEY="4f9d2641c76c10869bbf5dc2d044c6a7";
    public static String API_LINK="http://api.openweathermap.org/data/2.5/forecast/daily";

    public static String apiRequest(String lat, String lng){
        StringBuilder stringBuilder = new StringBuilder(API_LINK);
        stringBuilder.append(String.format("?lat=%s&lon=%s&cnt=6&appid=%s", lat, lng, API_KEY));
        return stringBuilder.toString();
    }

    public static String unixTimeStampToDateTimeToShowBig (double unixTimeStamp){
        DateFormat dateFormat= new SimpleDateFormat("EE dd MM yyyy HH:mm");
        Date date = new Date();
        date.setTime((long)unixTimeStamp*1000);
        return dateFormat.format(date);
    }

    public static String unixTimeStampToDateTime (double unixTimeStamp){
        DateFormat dateFormat= new SimpleDateFormat("EE(dd-MM)");
        Date date = new Date();
        date.setTime((long)unixTimeStamp*1000);
        return dateFormat.format(date);
    }

    public static String getImage(String icon){
        return (String.format("http://openweathermap.org/img/w/%s.png", icon));
    }

    public static String getDateNow(){
        DateFormat dateFormat = new SimpleDateFormat("EE dd MM yyyy HH:mm");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
