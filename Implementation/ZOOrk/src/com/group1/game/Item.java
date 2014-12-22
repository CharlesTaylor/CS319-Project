package com.group1.game;

import java.io.Serializable;

/**
 * Created by Fatih on 27/11/2014.
 */
public class Item implements Thing{
    private String name;
    private int damage;//if this is 0 it is not a weapon
    private int foodValue;//if this is 0 it is not a food



    public Item( String name,int damage,int foodValue){
        this.name = name;
        this.damage = damage;
        this.foodValue = foodValue;
    }
    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public String interact() {
        return null;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getFoodValue() {
        return foodValue;
    }
}