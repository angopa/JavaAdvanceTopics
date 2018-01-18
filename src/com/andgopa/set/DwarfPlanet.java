package com.andgopa.set;

/**
 * Created by Andres Gonzalez on 1/13/18
 */
public class DwarfPlanet extends HeavenlyBody {

    public DwarfPlanet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.DWARF_PLANET);
    }
}
