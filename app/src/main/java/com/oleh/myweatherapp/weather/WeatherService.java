package com.oleh.myweatherapp.weather;

public interface WeatherService {
    Weather getWeatherByCoordinates(double lat, double lon);
    Weather getWeatherByLocation(String locationQuery);
}
