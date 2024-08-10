package com.oleh.myweatherapp;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
//import android.view.animation.Animation;
//import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.oleh.myweatherapp.network.NetworkService;
import com.oleh.myweatherapp.network.OkHttpService;
import com.oleh.myweatherapp.pexelImage.PexelImage;
import com.oleh.myweatherapp.pexelImage.PexelImageImpl;
import com.oleh.myweatherapp.pexelImage.PexelImageService;
import com.oleh.myweatherapp.storage.Location;
import com.oleh.myweatherapp.weather.Weather;
import com.oleh.myweatherapp.weather.WeatherService;
import com.oleh.myweatherapp.weather.WeatherServiceImpl;
import com.squareup.picasso.Picasso;

import java.util.List;

public class WeatherPageAdapter extends RecyclerView.Adapter<WeatherPagerViewHolder> {

    private final List<Location> locations;
    FloatingActionButton fab;

    public WeatherPageAdapter(List<Location> locations) {
        this.locations = locations;
    }

    @NonNull
    @Override
    public WeatherPagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.page_weather, parent, false);
        WeatherPagerViewHolder holder = new WeatherPagerViewHolder(itemView);
        fab = itemView.findViewById(R.id.fab);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherPagerViewHolder holder, int position) {

        Location location = locations.get(position);
        String locationText = location.getCity() + ", " + location.getCountryCode();
        holder.getCityTextView().setText(locationText);

        NetworkService networkService = new OkHttpService();
        WeatherService weatherService = new WeatherServiceImpl(networkService);
        PexelImageService pexelImageService = new PexelImageImpl(networkService);

        new Thread(() -> {
            Animation fadeInCityName = AnimationUtils.loadAnimation(holder.getCityTextView().getContext(), R.anim.fade_in);
            holder.getCityTextView().startAnimation(fadeInCityName);
            Weather weather = weatherService.getWeatherByLocation(locationText);

            new Handler(Looper.getMainLooper()).post(() -> {


                Animation animation = AnimationUtils.loadAnimation(holder.getWeatherIcon().getContext(), R.anim.move_weather_icon);
                Animation fadeIn = AnimationUtils.loadAnimation(holder.getTempTextView().getContext(), R.anim.fade_in);

                holder.getTempTextView().startAnimation(fadeIn);
                holder.getTempTextView().setText(weather.getTemp() + " \u2103");

                switch (weather.getIconCode()) {
                    case RAIN:
                        holder.getWeatherIcon().setAnimation(R.raw.rain);
                        break;
                    case RAIN_NIGHT:
                        holder.getWeatherIcon().setAnimation(R.raw.rain_night);
                        break;
                    case CLEAR:
                        holder.getWeatherIcon().setAnimation(R.raw.clear);
                        break;
                    case CLEAR_NIGHT:
                        holder.getWeatherIcon().setAnimation(R.raw.moon);
                        break;
                    case FEW_CLOUDS:
                        holder.getWeatherIcon().setAnimation(R.raw.few_clouds);
                        break;
                    case FEW_CLOUDS_NIGHT:
                        holder.getWeatherIcon().setAnimation(R.raw.few_clouds_night);
                        break;
                    case SCATTERED_CLOUDS:
                        holder.getWeatherIcon().setAnimation(R.raw.scattered_clouds);
                        break;
                    case SCATTERED_CLOUDS_NIGHT:
                        holder.getWeatherIcon().setAnimation(R.raw.scattered_clouds_night);
                        break;

                    case OVERCAST_CLOUDS:
                        holder.getWeatherIcon().setAnimation(R.raw.overcast_clouds);
                        break;
                    case OVERCAST_CLOUDS_NIGHT:
                        holder.getWeatherIcon().setAnimation(R.raw.overcast_clouds_night);
                        break;

                    case DRIZZLE:
                        holder.getWeatherIcon().setAnimation(R.raw.drizzle);
                        break;
                    case DRIZZLE_NIGHT:
                        holder.getWeatherIcon().setAnimation(R.raw.drizzle_night);
                        break;
                    case THUNDERSTORM:
                        holder.getWeatherIcon().setAnimation(R.raw.thunderstorm);
                        break;
                    case THUNDERSTORM_NIGHT:
                        holder.getWeatherIcon().setAnimation(R.raw.thunderstorm_night);
                        break;

                    case SNOW:
                        holder.getWeatherIcon().setAnimation(R.raw.snow);
                        break;
                    case SNOW_NIGHT:
                        holder.getWeatherIcon().setAnimation(R.raw.snow_night);
                        break;

                    case SMOKE:
                        holder.getWeatherIcon().setAnimation(R.raw.smoke);
                        break;
                    case SMOKE_NIGHT:
                        holder.getWeatherIcon().setAnimation(R.raw.smoke_night);
                        break;

                    default:
                        holder.getWeatherIcon().setAnimation(R.raw.error);
                }
                holder.getWeatherIcon().startAnimation(animation);


            });
            fab.setOnClickListener(view -> showBottomDialog());
        }).start();

        new Thread(() -> {


            PexelImage image = pexelImageService.getRandomImagesForQuery(locationText);

            new Handler(Looper.getMainLooper()).post(() -> {
                Picasso.get().load(image.getPortraitURL()).into(holder.getBackgroundImageView());
            });
        }).start();
    }

    private void showBottomDialog() {

        final Dialog dialog = new Dialog(fab.getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheetlayout);


        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }

    @Override
    public int getItemCount() {
        return locations.size();
    }
}
