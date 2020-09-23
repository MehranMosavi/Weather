package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weather.Models.Weather;
import com.example.weather.Remote.APIUtils;
import com.example.weather.Remote.WeatherService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.weather.Common.KEY_LAT;
import static com.example.weather.Common.KEY_LON;
import static com.example.weather.Common.OPENWEATHERMAP_TOKEN;

public class WeatherActivity extends AppCompatActivity {

    double lat,lon;
    TextView txtCityName, txtTemp, txtPressure, txtDescription, txtWindSpeed, txtLat, txtLon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        init();

        WeatherService service = APIUtils.getWeatherService();
        Call<Weather> call = null;
        call = service.getCurrentWeather(lat,lon,OPENWEATHERMAP_TOKEN,"metric");
        assert call !=null;
        call.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                if (response.isSuccessful())
                {
                    Weather weather = response.body();
                    txtCityName.setText(weather.getName());
                }
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {

            }
        });

    }

    public void init()
    {
        txtCityName = findViewById(R.id.weatherActivity_txt_CityName);
        txtTemp = findViewById(R.id.weatherActivity_txt_Temp);
        txtPressure = findViewById(R.id.weatherActivity_txt_Pressure);
        txtDescription = findViewById(R.id.weatherActivity_txt_Description);
        txtWindSpeed = findViewById(R.id.weatherActivity_txt_WindSpeed);
        txtLat = findViewById(R.id.weatherActivity_txt_Latitude);
        txtLon = findViewById(R.id.weatherActivity_txt_Longitude);

        Intent intent = getIntent();
        lat = getIntent().getDoubleExtra(KEY_LAT,0);
        lon = getIntent().getDoubleExtra(KEY_LON,0);

        txtLat.setText("" + lat);
        txtLon.setText("" + lon);
    }

}