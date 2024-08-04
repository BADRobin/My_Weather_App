package com.oleh.myweatherapp.storage;

import java.util.List;

public interface LocationDAO {
    List<Location> getAllLocations();

    Location getLocation(int index);

    void addLocation(Location location);

    void updateLocation(int index, Location location);

    void deleteLocation(int index);

    void deleteLocation(Location location);

    void deleteAll();
}
