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

    public Location(int locationId, String description, Map<String, Integer> exists) {
        this.locationId = locationId;
        this.description = description;
        if (exists != null) {
            this.exist = new HashMap<>(exists);
        } else {
            this.exist = new HashMap<>();
        }

        this.exist.put("Q", 0);
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
