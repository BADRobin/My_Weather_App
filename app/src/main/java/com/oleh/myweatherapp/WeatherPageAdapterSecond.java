//package com.oleh.myweatherapp;
//
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Looper;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.oleh.myweatherapp.network.NetworkService;
//import com.oleh.myweatherapp.network.OkHttpService;
//import com.oleh.myweatherapp.storage.Location;
//import com.oleh.myweatherapp.weather.Weather;
//import com.oleh.myweatherapp.weather.WeatherService;
//import com.oleh.myweatherapp.weather.WeatherServiceImpl;
//
//import java.util.List;
//
//public class WeatherPageAdapterSecond extends RecyclerView.Adapter<WeatherPagerViewHolder> {
//    private final List<Location> locations;
//
//
//    public WeatherPageAdapterSecond(List<Location> locations) {
//        this.locations = locations;
//    }
//
//
//
//
//    @NonNull
//    @Override
//    public WeatherPagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.bottomsheetlayout, parent, false);
//        WeatherPagerViewHolder holder = new WeatherPagerViewHolder(itemView);
//
//
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull WeatherPagerViewHolder holder, int position) {
//        Location location = locations.get(position);
//        String locationText = location.getCity() + ", " + location.getCountryCode();
//
//
//        NetworkService networkService = new OkHttpService();
//        WeatherService weatherService = new WeatherServiceImpl(networkService);
//
//        new Thread(() -> {
//
//            Weather weather = weatherService.getWeatherByLocation(locationText);
//
//            new Handler(Looper.getMainLooper()).post(() -> {
//
//
//                holder.getTempFeelsLikeTextView().setText(weather.getTempFeelsLike() + " ");
//                holder.getMaxTempTextView().setText(weather.getMaxTemp() + " ");
//                holder.getMinTempTextView().setText(weather.getMinTemp() + " ");
//                holder.getWeatherDescriptionTextView().setText(weather.getWeatherDescription());
//
//
//            });
//
//
//        }).start();
//    }
//
//    @Override
//    public int getItemCount() {
//        return locations.size();
//    }
//}
