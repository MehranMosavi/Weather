package com.example.weather.Remote;

public class APIUtils {

    //public static final String BASE_URL = "http://171.22.27.174/api/v1/";
    public static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";


    /** getter methods for service interfaces */

    public static WeatherService getWeatherService(){
        return RetroClient.getClient(BASE_URL).create(WeatherService.class);
    }
}


