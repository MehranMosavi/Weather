package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

import static com.example.weather.Common.LANG_KEY;
import static com.example.weather.Common.LAT_KEY;
import static com.example.weather.Common.LON_KEY;
import static com.example.weather.Common.UNIT_KEY;

public class MainActivity extends AppCompatActivity {

    EditText etLat, etLon;
    ToggleButton tbLang, tbUnit, tbLat, tbLon;
    Button button;
    String tvLang = null;
    String tvUnit = null;
    Double lat, lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


    }

    private void init() {
        tbLang = findViewById(R.id.mainActivity_tb_Language);
        tbUnit = findViewById(R.id.mainActivity_tb_Unit);
        tbLat = findViewById(R.id.mainActivity_tb_Latitude);
        tbLon = findViewById(R.id.mainActivity_tb_Longitude);
        etLat = findViewById(R.id.mainActivity_et_Latitude);
        etLon = findViewById(R.id.mainActivity_et_Longitude);
        button = findViewById(R.id.btnEnter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                lat = Double.parseDouble(etLat.getText().toString());
                lon = Double.parseDouble(etLon.getText().toString());

                if (!tbLat.isChecked())
                {
                    lat *= -1;
                }

                if (!tbLon.isChecked())
                {
                    lon *= -1;
                }

                if (tbLang.isChecked())
                {
                    tvLang = "fa";
                }
                else
                {
                    tvLang = "en";
                }

                if (tbUnit.isChecked())
                {
                    tvUnit = "metric";
                }
                else
                {
                    tvUnit = "imperial";
                }

                Intent intent = new Intent(MainActivity.this, WeatherActivity.class);

                intent.putExtra(UNIT_KEY, tvUnit);
                intent.putExtra(LANG_KEY, tvLang);
                intent.putExtra(LAT_KEY, lat);
                intent.putExtra(LON_KEY, lon);

                Log.d("MMM", "Test");

                startActivity(intent);
            }
        });
    }
}