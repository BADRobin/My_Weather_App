package com.oleh.myweatherapp.weather;

import com.oleh.myweatherapp.network.WeatherIconCode;

import java.io.Serializable;
import java.util.Objects;

public class Weather implements Serializable {

    private final double lat;
    private final double lon;
    private final String weatherDescription;
    private final WeatherIconCode iconCode;
    private final int temp;
    private final int tempFeelsLike;
    private final int minTemp;
    private final int maxTemp;
    private final String locationName;

    public Weather(double lat, double lon, String weatherDescription, String iconCode, int temp, int tempFeelsLike, int minTemp, int maxTemp, String locationName) {
        this.lat = lat;
        this.lon = lon;
        this.weatherDescription = weatherDescription;
        this.iconCode = WeatherIconCode.fromString(iconCode);
        this.temp = temp;
        this.tempFeelsLike = tempFeelsLike;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.locationName = locationName;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public WeatherIconCode getIconCode() {
        return iconCode;
    }

    public int getTemp() {
        return temp;
    }

    public int getTempFeelsLike() {
        return tempFeelsLike;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public String getLocationName() {
        return locationName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weather weather = (Weather) o;
        return Double.compare(lat, weather.lat) == 0 && Double.compare(lon, weather.lon) == 0 && Double.compare(temp, weather.temp) == 0 && Double.compare(tempFeelsLike, weather.tempFeelsLike) == 0 && Double.compare(minTemp, weather.minTemp) == 0 && Double.compare(maxTemp, weather.maxTemp) == 0 && Objects.equals(weatherDescription, weather.weatherDescription) && Objects.equals(iconCode, weather.iconCode) && Objects.equals(locationName, weather.locationName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lat, lon, weatherDescription, iconCode, temp, tempFeelsLike, minTemp, maxTemp, locationName);
    }

    @Override
    public String toString() {
        return "Weather{" +
                "lat=" + lat +
                ", lon=" + lon +
                ", weatherDescription='" + weatherDescription + '\'' +
                ", iconCode='" + iconCode + '\'' +
                ", temp=" + temp +
                ", tempFeelsLike=" + tempFeelsLike +
                ", minTemp=" + minTemp +
                ", maxTemp=" + maxTemp +
                ", locationName='" + locationName + '\'' +
                '}';
    }
}
