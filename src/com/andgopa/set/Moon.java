package com.andgopa.set;

/**
 * Created by Andres Gonzalez on 1/13/18
 */
public class Moon extends HeavenlyBody {

    public Moon(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.MOON);
    }

    @Override
    public boolean addSatellite(HeavenlyBody satellite) {
        if (satellite.getKey().getBodyType() == BodyTypes.MOON) {
            return super.addSatellite(satellite);
        } else {
            return false;
        }
    }
}
