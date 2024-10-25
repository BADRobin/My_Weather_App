package com.oleh.myweatherapp;



import android.os.Bundle;



import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.oleh.myweatherapp.weather.Weather;


public class WeatherDetailActivity extends AppCompatActivity {
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_weather_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            fab = findViewById(R.id.fab);

            return insets;
        });

        Weather weather = (Weather) getIntent().getSerializableExtra("weather");

        LottieAnimationView weatherIcon = findViewById(R.id.weatherIcon);

        TextView textView = findViewById(R.id.textView);



        textView.setText("Temperature: " + weather.getTemp() + " °C");


        switch (weather.getIconCode()) {
            case RAIN:
                weatherIcon.setAnimation(R.raw.rain);
                break;
            case RAIN_NIGHT:
                weatherIcon.setAnimation(R.raw.rain_night);
                break;
            case CLEAR:
                weatherIcon.setAnimation(R.raw.clear);
                break;
            case CLEAR_NIGHT:
                weatherIcon.setAnimation(R.raw.moon);
                break;
            case FEW_CLOUDS:
                weatherIcon.setAnimation(R.raw.few_clouds);
                break;
            case FEW_CLOUDS_NIGHT:
                weatherIcon.setAnimation(R.raw.few_clouds_night);
                break;
            case SCATTERED_CLOUDS:
                weatherIcon.setAnimation(R.raw.scattered_clouds);
                break;
            case SCATTERED_CLOUDS_NIGHT:
                weatherIcon.setAnimation(R.raw.scattered_clouds_night);
                break;

            case OVERCAST_CLOUDS:
                weatherIcon.setAnimation(R.raw.overcast_clouds);
                break;
            case OVERCAST_CLOUDS_NIGHT:
                weatherIcon.setAnimation(R.raw.overcast_clouds_night);
                break;

            case DRIZZLE:
                weatherIcon.setAnimation(R.raw.drizzle);
                break;
            case DRIZZLE_NIGHT:
                weatherIcon.setAnimation(R.raw.drizzle_night);
                break;
            case THUNDERSTORM:
                weatherIcon.setAnimation(R.raw.thunderstorm);
                break;
            case THUNDERSTORM_NIGHT:
                weatherIcon.setAnimation(R.raw.thunderstorm_night);
                break;

            case SNOW:
                weatherIcon.setAnimation(R.raw.snow);
                break;
            case SNOW_NIGHT:
                weatherIcon.setAnimation(R.raw.snow_night);
                break;

            case SMOKE:
                weatherIcon.setAnimation(R.raw.smoke);
                break;
            case SMOKE_NIGHT:
                weatherIcon.setAnimation(R.raw.smoke_night);
                break;

            default:
                weatherIcon.setAnimation(R.raw.error);
        }



    }




}

