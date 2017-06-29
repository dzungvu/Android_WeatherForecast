package com.software.dzungvu.configuration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by DzungVu on 6/30/2017.
 */

public class ConfigurationNow {
    public static String API_KEY = "4f9d2641c76c10869bbf5dc2d044c6a7";
    public static String API_LINK = "http://api.openweathermap.org/data/2.5/weather";

    public static String apiRequest(String lat, String lng){
        String stream = null;
        StringBuilder stringBuilder = new StringBuilder(API_LINK);
        stringBuilder.append(String.format("?lat=%s&lon=%s&appid=%s", lat, lng, API_KEY));
        stream = stringBuilder.toString();
        return stream;
    }

    public static String getDayNow(){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        return dateFormat.format(date);
    }

}
