package com.oleh.myweatherapp;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;


import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.widget.Toolbar;

import android.os.Handler;
import android.util.Log;


import com.oleh.myweatherapp.network.NetworkService;
import com.oleh.myweatherapp.network.OkHttpService;
import com.oleh.myweatherapp.pexelImage.PexelImage;
import com.oleh.myweatherapp.pexelImage.PexelImageImpl;
import com.oleh.myweatherapp.pexelImage.PexelImageService;
import com.oleh.myweatherapp.storage.Location;
import com.oleh.myweatherapp.weather.Weather;
import com.oleh.myweatherapp.storage.LocationDAO;
import com.oleh.myweatherapp.storage.LocationStorage;

import com.oleh.myweatherapp.weather.WeatherService;
import com.oleh.myweatherapp.weather.WeatherServiceImpl;


public class MainActivity extends AppCompatActivity {
    private Weather weather;

    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        drawerLayout = findViewById(R.id.drawer_layout);

        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();


        }

//        NetworkService networkService = new OkHttpService();
//        WeatherService weatherService = new WeatherServiceImpl(networkService);
//
//        LocationDAO locationDao = new LocationStorage(this);
////        locationDao.deleteAll();
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


    }


}