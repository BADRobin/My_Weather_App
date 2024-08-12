package com.oleh.myweatherapp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.oleh.myweatherapp.network.NetworkService;
import com.oleh.myweatherapp.network.OkHttpService;

import com.oleh.myweatherapp.pexelImage.PexelImageImpl;
import com.oleh.myweatherapp.pexelImage.PexelImageService;
import com.oleh.myweatherapp.storage.Location;
import com.oleh.myweatherapp.weather.Weather;
import com.oleh.myweatherapp.weather.WeatherService;
import com.oleh.myweatherapp.weather.WeatherServiceImpl;


import java.util.List;

public class WeatherPageAdapterFragment extends Fragment {
    private final List<Location> locations;
    public TextView tempFeelsLikeTextVie;
    public TextView minTempTextView;
    public TextView maxTempTextView;
    public TextView weatherDescriptionTextView;

    public WeatherPageAdapterFragment(List<Location> locations) {
        this.locations = locations;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottomsheetlayout, container, false);
        tempFeelsLikeTextVie = view.findViewById(R.id.tempFeelsLikeTextView);
        minTempTextView = view.findViewById(R.id.minTempTextView);
        maxTempTextView = view.findViewById(R.id.maxTempTextView);
        weatherDescriptionTextView = view.findViewById(R.id.weatherDescriptionTextView);

        return view;
    }


    public void onBindViewHolder(@NonNull WeatherPagerViewHolder holder, int position) {

        Location location = locations.get(position);
        String locationText = location.getCity() + ", " + location.getCountryCode();
        holder.getCityTextView().setText(locationText);

        NetworkService networkService = new OkHttpService();
        WeatherService weatherService = new WeatherServiceImpl(networkService);
        PexelImageService pexelImageService = new PexelImageImpl(networkService);

        new Thread(() -> {

            Weather weather = weatherService.getWeatherByLocation(locationText);

            new Handler(Looper.getMainLooper()).post(() -> {


                holder.getTempFeelsLikeTextView().setText(weather.getTempFeelsLike() + " ");
                holder.getMaxTempTextView().setText(weather.getMaxTemp() + " ");
                holder.getMinTempTextView().setText(weather.getMinTemp() + " ");
                holder.getWeatherDescriptionTextView().setText(weather.getWeatherDescription());



            });



        }).start();


    }
}
