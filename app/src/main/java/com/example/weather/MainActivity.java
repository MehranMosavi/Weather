package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ToggleButton;

import static com.example.weather.Common.KEY_LAT;
import static com.example.weather.Common.KEY_LON;

public class MainActivity extends AppCompatActivity {

    Button btnEnter;
    ToggleButton tbLatitude,tbLongitude;
    EditText etLatitude,etLongitude;
    double lat,lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WeatherActivity.class);

                lat = Double.parseDouble(etLatitude.getText().toString());
                lon = Double.parseDouble(etLongitude.getText().toString());

                if (tbLatitude.isChecked() == false)
                    lat *= -1;

                if (tbLongitude.isChecked() == false)
                    lon *= -1;

                intent.putExtra(KEY_LAT, lat);
                intent.putExtra(KEY_LON, lon);

                startActivity(intent);
            }
        });
    }

    public void init()
    {

        etLatitude = findViewById(R.id.mainActivity_et_Latitude);
        etLongitude = findViewById(R.id.mainActivity_et_Longitude);

        tbLatitude = findViewById(R.id.mainActivity_tb_Latitude);
        tbLongitude = findViewById(R.id.mainActivity_tb_Longitude);

        btnEnter = findViewById(R.id.btnEnter);
    }
}