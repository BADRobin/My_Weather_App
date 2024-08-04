package com.oleh.myweatherapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;

public class WeatherPagerViewHolder extends RecyclerView.ViewHolder {

    private final ImageView backgroundImageView;
    //    private final ImageView weatherIcon;
    private final LottieAnimationView weatherIcon;

    private final TextView cityTextView;
    private final TextView tempTextView;

    public WeatherPagerViewHolder(@NonNull View itemView) {
        super(itemView);
        backgroundImageView = itemView.findViewById(R.id.backgroundImageView);
//        weatherIcon = itemView.findViewById(R.id.weatherIcon);
        weatherIcon = itemView.findViewById(R.id.weatherIcon);

        cityTextView = itemView.findViewById(R.id.cityTextView);
        tempTextView = itemView.findViewById(R.id.tempTextView);
    }


    public ImageView getBackgroundImageView() {
        return backgroundImageView;
    }

    //    public ImageView getWeatherIcon() {
//        return weatherIcon;
//    }
    public LottieAnimationView getWeatherIcon() {
        return weatherIcon;
    }

    public TextView getCityTextView() {
        return cityTextView;
    }

    public TextView getTempTextView() {
        return tempTextView;
    }


}
