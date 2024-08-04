package com.oleh.myweatherapp;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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


    public WeatherPageAdapter(List<Location> locations) {
        this.locations = locations;
    }

    @NonNull
    @Override
    public WeatherPagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.page_weather, parent, false);
        WeatherPagerViewHolder holder = new WeatherPagerViewHolder(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherPagerViewHolder holder, int position) {

        Location location = locations.get(position);
        String locationText = location.getCity() + ", " + location.getCountryCode();
        holder.getCityTextView().setText(locationText);

        NetworkService networkService = new OkHttpService();
        WeatherService weatherService = new WeatherServiceImpl(networkService);
        PexelImageService pexelImageService  = new PexelImageImpl(networkService);

        new Thread(() -> {
            Weather weather = weatherService.getWeatherByLocation(locationText);
            String iconURL = "https://openweathermap.org/img/wn/" + weather.getIconCode() + "@2x.png";

            new Handler(Looper.getMainLooper()).post(()-> {
               holder.getTempTextView().setText(weather.getTemp() + " ");

//               Picasso.get().load(iconURL).into(holder.getWeatherIcon());

                switch (weather.getIconCode()) {
                    case RAIN:
                        holder.getWeatherIcon().setAnimation(R.raw.rain);
                        break;
                    case RAIN_NIGHT:
                        holder.getWeatherIcon().setAnimation(R.raw.rain);
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
                        holder.getWeatherIcon().setAnimation(R.raw.drizzle);
                        break;

                    case SNOW:
                        holder.getWeatherIcon().setAnimation(R.raw.snow);
                        break;
                    case SNOW_NIGHT:
                        holder.getWeatherIcon().setAnimation(R.raw.snow);
                        break;

                    case SMOKE:
                        holder.getWeatherIcon().setAnimation(R.raw.snow);
                        break;
                    case SMOKE_NIGHT:
                        holder.getWeatherIcon().setAnimation(R.raw.snow);
                        break;

                    default:
                        holder.getWeatherIcon().setAnimation(R.raw.error);
                }
           } );
        }).start();

        new Thread(() -> {
//            List<PexelImage> images = pexelImageService.getImagesByQuery("Mykolaiv, UA");

            PexelImage image = pexelImageService.getRandomImagesForQuery(locationText);

            new Handler(Looper.getMainLooper()).post(() -> {
                Picasso.get().load(image.getPortraitURL()).into(holder.getBackgroundImageView());
            });
        }).start();
    }

    @Override
    public int getItemCount() {
        return locations.size();
    }
}
