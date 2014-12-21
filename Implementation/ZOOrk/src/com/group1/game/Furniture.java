package com.group1.game;

/**
 * Created by Fatih on 27/11/2014.
 */
public class Furniture implements Thing {

    String name;
    public Furniture( String name){
        this.name = name;
    }
    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String interact() {
        return null;
    }
}
