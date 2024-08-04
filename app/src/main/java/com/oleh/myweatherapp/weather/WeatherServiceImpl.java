package com.oleh.myweatherapp.weather;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oleh.myweatherapp.network.NetworkResponse;
import com.oleh.myweatherapp.network.NetworkService;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class WeatherServiceImpl implements WeatherService {

    private final static String APP_ID = "7fef8a552b9ff7d75b007d79f3621525";

    private final NetworkService networkService;

    public WeatherServiceImpl(NetworkService networkService) {
        this.networkService = networkService;
    }

    public Weather getWeather(String url, Map<String, String> queryParameters) {
        NetworkResponse response = networkService.getResponse(url, queryParameters);
        String body = response.getBody();

        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode rootNode = mapper.readTree(body);

            Weather weather = new Weather(
                    rootNode.get("coord").get("lat").asDouble(),
                    rootNode.get("coord").get("lon").asDouble(),
                    rootNode.get("weather").get(0).get("description").asText(),
                    rootNode.get("weather").get(0).get("icon").asText(),
                    rootNode.get("main").get("temp").asDouble(),
                    rootNode.get("main").get("feels_like").asDouble(),
                    rootNode.get("main").get("temp_min").asDouble(),
                    rootNode.get("main").get("temp_max").asDouble(),
                    rootNode.get("name").asText()
            );

            return weather;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public Weather getWeatherByCoordinates(double lat, double lon) {
        String url = "https://api.openweathermap.org/data/2.5/weather";

        Map<String, String> params = new HashMap<>();
        params.put("appid", APP_ID);
        params.put("lat", String.valueOf(lat));
        params.put("lon", String.valueOf(lon));
        params.put("units", "metric");

        return getWeather(url, params);
    }

    @Override
    public Weather getWeatherByLocation(String locationQuery) {
        String url = "https://api.openweathermap.org/data/2.5/weather";

        Map<String, String> params = new HashMap<>();
        params.put("appid", APP_ID);
        params.put("q", locationQuery);
        params.put("units", "metric");

        return getWeather(url, params);
    }
}