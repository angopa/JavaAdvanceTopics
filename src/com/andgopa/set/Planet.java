package com.andgopa.set;

/**
 * Created by Andres Gonzalez on 1/13/18
 */
public class Planet extends HeavenlyBody {
    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBody satellite) {
        if (satellite.getKey().getBodyType() == BodyTypes.MOON) {
            return super.addSatellite(satellite);
        }
        return false;
    }
}
