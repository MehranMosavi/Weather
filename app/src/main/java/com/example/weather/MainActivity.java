package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText lat, lon;
    Button button;

    public static String LAT_KEY = "com.example.retro.LAT";
    public static String LON_KEY = "com.example.retro.LON";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init()
    {
        lat = findViewById(R.id.mainActivity_et_Latitude);
        lon = findViewById(R.id.mainActivity_et_Longitude);
        button = findViewById(R.id.btnEnter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, WeatherActivity.class).putExtra(LAT_KEY, lat.getText().toString()).putExtra(LON_KEY, lon.getText().toString()));
            }
        });
    }
}