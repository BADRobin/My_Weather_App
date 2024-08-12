package com.oleh.myweatherapp.storage;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.fasterxml.jackson.core.JsonProcessingException;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class LocationStorage implements LocationDAO {

    private final Activity activity;
    private final String STORAGE_KEY = "locations";
    private final String FILE_NAME = "weatherLocations";


    public LocationStorage(Activity activity) {
        this.activity = activity;
    }

    @Override
    public List<Location> getAllLocations() {
        SharedPreferences sharedPref = activity.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        String jsonValues = sharedPref.getString(STORAGE_KEY, "[]");

        ObjectMapper mapper = new ObjectMapper();
        List<Location> locations = new ArrayList<>();
        try {
            JsonNode rootNode = mapper.readTree(jsonValues);
            for (JsonNode node : rootNode) {
                Location location = new Location(
                        node.get("city").asText(),
                        node.get("countryCode").asText(),
                        node.get("lat").asDouble(),
                        node.get("lon").asDouble()
                );
                locations.add(location);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return locations;
    }

    @Override
    public Location getLocation(int index) {
        List<Location> locations = getAllLocations();
        if (index >= locations.size() || index < 0) {
            return null;
        }
        return locations.get(index);
    }

    @Override
    public void addLocation(Location location) {
        List<Location> locations = getAllLocations();
        locations.add(location);
        saveToPreferences(locations);
    }

    @Override
    public void updateLocation(int index, Location location) {
        List<Location> locations = getAllLocations();
        locations.set(index, location);
        saveToPreferences(locations);
    }

    @Override
    public void deleteLocation(int index) {
        List<Location> locations = getAllLocations();
        locations.remove(index);
        saveToPreferences(locations);
    }

    @Override
    public void deleteLocation(Location location) {
        List<Location> locations = getAllLocations();
        locations.remove(location);
        saveToPreferences(locations);
    }

    @Override
    public void deleteAll() {
        List<Location> locations = new ArrayList<>();
        saveToPreferences(locations);
    }

    private void saveToPreferences(List<Location> locations) {
        ObjectMapper mapper = new ObjectMapper();

        String jsonValues = null;
        try {
            jsonValues = mapper.writeValueAsString(locations);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        SharedPreferences sharedPref = activity.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(STORAGE_KEY, jsonValues);
        editor.apply();
    }
}