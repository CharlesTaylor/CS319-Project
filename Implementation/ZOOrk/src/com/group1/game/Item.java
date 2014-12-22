package com.group1.game;

import java.io.Serializable;

/**
 * Created by Fatih on 27/11/2014.
 */
public class Item implements Thing{
    private String name, message;
    private int damage;//if this is 0 it is not a weapon
    private int foodValue;//if this is 0 it is not a food



    public Item( String name,int damage,int foodValue, String message){
        this.name = name;
        this.damage = damage;
        this.foodValue = foodValue;
        this.message = message;
    }
    @Override
    public String getMessage()
    {
        return message; // returns message about usage of the item
    }

    @Override
    public String interact()
    {
        return null;
    }

    public String getName()
    {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getFoodValue() {
        return foodValue;
    }
}