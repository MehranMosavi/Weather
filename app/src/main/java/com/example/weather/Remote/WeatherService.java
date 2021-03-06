package com.example.weather.Remote;

import com.example.weather.Models.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {
    @GET("weather")
    Call<Weather> getCurrentWeather(@Query("lat") Double latitude, @Query("lon") Double longitude, @Query("appid") String api_key, @Query("units") String units, @Query("lang") String lang);
}
