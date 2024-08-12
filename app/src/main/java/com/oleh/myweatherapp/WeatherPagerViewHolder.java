package com.oleh.myweatherapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class WeatherPagerViewHolder extends RecyclerView.ViewHolder {

    private final ImageView backgroundImageView;

    private final LottieAnimationView weatherIcon;

    private final TextView cityTextView;
    private final TextView tempTextView;
    private final TextView tempFeelsLikeTextView;
    private final TextView minTempTextView;
    private final TextView maxTempTextView;
    private final TextView weatherDescriptionTextView;
    private final FloatingActionButton fab;


    public WeatherPagerViewHolder(@NonNull View itemView) {
        super(itemView);
        backgroundImageView = itemView.findViewById(R.id.backgroundImageView);

        weatherIcon = itemView.findViewById(R.id.weatherIcon);

        cityTextView = itemView.findViewById(R.id.cityTextView);
        tempTextView = itemView.findViewById(R.id.tempTextView);
        tempFeelsLikeTextView = itemView.findViewById(R.id.weatherDescriptionTextView);
        minTempTextView = itemView.findViewById(R.id.tempFeelsLikeTextView);
        maxTempTextView = itemView.findViewById(R.id.minTempTextView);
        weatherDescriptionTextView = itemView.findViewById(R.id.maxTempTextView);
        fab = itemView.findViewById(R.id.fab);
    }


    public ImageView getBackgroundImageView() {
        return backgroundImageView;
    }


    public LottieAnimationView getWeatherIcon() {
        return weatherIcon;
    }

    public TextView getCityTextView() {
        return cityTextView;
    }

    public TextView getTempTextView() {
        return tempTextView;
    }

    public TextView getTempFeelsLikeTextView() {
        return tempFeelsLikeTextView;
    }

    public TextView getMinTempTextView() {
        return minTempTextView;
    }

    public TextView getMaxTempTextView() {
        return maxTempTextView;
    }

    public TextView getWeatherDescriptionTextView() {
        return weatherDescriptionTextView;
    }

    public  FloatingActionButton getFab() {
        return fab;
    }
}
