package com.group1.game;

/**
 * Created by Fatih on 27/11/2014.
 */
public class Furniture implements Thing {

    String name, message;
    public Furniture( String name, String message){
        this.name = name;
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
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
