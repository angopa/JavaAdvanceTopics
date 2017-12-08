package com.andgopa.collections.adventure;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andres Gonzalez on 12/7/17
 */
public class Location {
    private final int locationId;
    private final String description;
    private final Map<String, Integer> exist;

    public Location(int locationId, String description) {
        this.locationId = locationId;
        this.description = description;
        this.exist = new HashMap<>();
    }

    public void addExist(String direction, int location) {
        exist.put(direction, location);
    }

    public int getLocationId() {
        return locationId;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExist() {
        return new HashMap<>(exist);
    }
}
