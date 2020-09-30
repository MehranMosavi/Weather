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

import static com.example.weather.Common.OPENWEATHERMAP_TOKEN;
import static com.example.weather.MainActivity.LAT_KEY;
import static com.example.weather.MainActivity.LON_KEY;

public class WeatherActivity extends AppCompatActivity {

    Intent intent;
    TextView name, temp, press, humidity;

    Weather weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        init();
        getData();
    }

    private void init()
    {
        intent = getIntent();
        name = findViewById(R.id.weatherActivity_txt_CityName);
        temp = findViewById(R.id.weatherActivity_txt_Temp);
        press = findViewById(R.id.weatherActivity_txt_Pressure);
        humidity = findViewById(R.id.weatherActivity_txt_WindSpeed);
        humidity = findViewById(R.id.weatherActivity_txt_Description);
    }

    private void getData()
    {
        WeatherService service = APIUtils.getWeatherService();
        Call<Weather> call = service.getCurrentWeather(Double.parseDouble(intent.getStringExtra(MainActivity.LAT_KEY)), Double.parseDouble(intent.getStringExtra(MainActivity.LON_KEY)), OPENWEATHERMAP_TOKEN, "metric");
        call.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                if(response.isSuccessful())
                {
                    weather = response.body();
                    setData();
                }
                else
                {
                    Toast.makeText(WeatherActivity.this, "ERROR", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                Toast.makeText(WeatherActivity.this, "ERROR", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setData()
    {
        name.setText(weather.getName());
        temp.setText(String.valueOf(weather.getMain().getTemp()));
        press.setText(String.valueOf(weather.getMain().getPressure()));
        humidity.setText(String.valueOf(weather.getMain().getHumidity()));
    }
}