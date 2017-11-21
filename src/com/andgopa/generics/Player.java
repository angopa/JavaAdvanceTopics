package com.andgopa.generics;

/**
 * Created by Andres Gonzalez on 11/20/17
 */
public abstract class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
