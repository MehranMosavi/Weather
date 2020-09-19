package com.example.weather.Remote;

public class APIUtils {

    public static final String BASE_URL="https://api.openweathermap.org/data/2.5/";


    public static WeatherService getWeatherService(){
        return RetroClient.getClient(BASE_URL).create(WeatherService.class);
    }
}
