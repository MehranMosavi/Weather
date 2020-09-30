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

import static com.example.weather.Common.LANG_KEY;
import static com.example.weather.Common.OPENWEATHERMAP_TOKEN;
import static com.example.weather.Common.LAT_KEY;
import static com.example.weather.Common.LON_KEY;
import static com.example.weather.Common.UNIT_KEY;

public class WeatherActivity extends AppCompatActivity {

    Intent intent;
    TextView txtName;
    TextView txtTemp;
    TextView txtPress;
    TextView txtDescription;
    TextView txtWindSpeed;
    TextView txtLat;
    TextView txtLon;
    Double lat,lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        init();

        WeatherService service = APIUtils.getWeatherService();
        Call<Weather> call = service.getCurrentWeather(lat, lon, OPENWEATHERMAP_TOKEN, "metric");
        call.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                if(response.isSuccessful())
                {
                    Weather weather = response.body();

                    txtName.setText(weather.getName());
                    txtTemp.setText(String.valueOf(weather.getMain().getTemp()));
                    txtPress.setText(String.valueOf(weather.getMain().getPressure()));
                    txtDescription.setText("Null");
                    txtWindSpeed.setText(String.valueOf(weather.getWind().getSpeed()));
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

    private void init()
    {
        intent = getIntent();
        txtName = findViewById(R.id.weatherActivity_txt_CityName);
        txtTemp = findViewById(R.id.weatherActivity_txt_Temp);
        txtPress = findViewById(R.id.weatherActivity_txt_Pressure);
        txtDescription = findViewById(R.id.weatherActivity_txt_Description);
        txtWindSpeed = findViewById(R.id.weatherActivity_txt_WindSpeed);
        txtLat = findViewById(R.id.weatherActivity_txt_Latitude);
        txtLon = findViewById(R.id.weatherActivity_txt_Longitude);

        lat = getIntent().getDoubleExtra(LAT_KEY,0);
        lon = getIntent().getDoubleExtra(LON_KEY,0);

        txtLat.setText(""+lat);
        txtLon.setText(""+lon);
    }
}