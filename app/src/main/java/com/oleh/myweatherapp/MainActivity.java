package com.oleh.myweatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.oleh.myweatherapp.network.NetworkService;
import com.oleh.myweatherapp.network.OkHttpService;
import com.oleh.myweatherapp.pexelImage.PexelImage;
import com.oleh.myweatherapp.pexelImage.PexelImageImpl;
import com.oleh.myweatherapp.pexelImage.PexelImageService;
import com.oleh.myweatherapp.weather.Weather;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Weather weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Button button1 = findViewById(R.id.button1);


        button1.setOnClickListener(view -> {
            Intent intent = new Intent(this, PagerActivity.class);

            startActivity(intent);
        });


//        NetworkService networkService = new OkHttpService();
//        WeatherService weatherService = new WeatherServiceImpl(networkService);
//
//        LocationDAO locationDao = new LocationStorage(this);
//        locationDao.deleteAll();
//
//        new Thread(() -> {
//            Weather weather = weatherService.getWeatherByLocation("Berlin, DE");
//            Location location = new Location(
//                    "Berlin",
//                    "DE",
//                    weather.getLat(),
//                    weather.getLon()
//            );
//            locationDao.addLocation(location);
//
//            Log.d("YOYO", locationDao.getAllLocations().toString());
//        }).start();


//        Map<String, String> params = new HashMap<>();
//        params.put("query", "Mykolaiv, UA");
//
//
//        Map <String, String> headers = new HashMap<>();
//        headers.put("Authorization", "VcVEvxy7V62yi9PAr8Xw9MbN133BcFXQ7YBEHfe2cAB3HJVA5xv7rHjx");

//        NetworkService networkService = new OkHttpService();
//        PexelImageService pexelImageService = new PexelImageImpl(networkService);
//        new Thread(() -> {
//            List<PexelImage> images = pexelImageService.getImagesForQuery("Mykolaiv, UA");
//            NetworkResponse response = networkService.getResponse("https://api.pexels.com/v1/search", params, headers);
//            Log.d("Yo" )

//        }).start();


    }
}