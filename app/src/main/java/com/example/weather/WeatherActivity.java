package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.example.weather.Common.KEY_LAT;
import static com.example.weather.Common.KEY_LON;

public class WeatherActivity extends AppCompatActivity {

    TextView txtLat,txtLon;
    float lat,lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        init();

        txtLat.setText("lat= "+ KEY_LAT);
        txtLon.setText("lat= "+ KEY_LON);

    }

    public void init()
    {
        txtLat = findViewById(R.id.txtlat);
        txtLon = findViewById(R.id.txtlon);

        lat = getIntent().getIntExtra(KEY_LAT,0);
        lon = getIntent().getIntExtra(KEY_LON,0);
    }
}