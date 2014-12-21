package com.group1.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fatih on 27/11/2014.
 *
 */
public abstract class Character {
    /**
     * Characters name
     */
    private String name;
    /**
     * Character's current Location
     */
    private Location current;
    /**
     * Characters Item List, inventory
     */
    private List<Item> inventory;

    private int hitpoint;

    /**
     * Constructor for Character, Designed to work both when initialization and loading the game
     * @param name String name to assign to character
     */
    public  Character( String name){
        this.name = name;


        this.current = current;
    }


    /**
     * Player attacks given target with the given item if it is possible,
     * result given with an appropriate string message
     * Damage will be calculated according to users stats, and equipment
     * This method designed to be called from Player object inside Game object inside Parser object
     * game.player.attack(character,item);
     *
     * @param  character to interact
     * @param item to attack with
     * @return resulting boolean or string message depending on the implementation
     */
    public String attack(Character character,Item item){ return "Message";}


    public String getName() {
        return name;
    }

    public Location getCurrent() {
        return current;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public int getHitpoint() {
        return hitpoint;
    }

    public void setHitpoint(int hitpoint) {
        this.hitpoint = hitpoint;
    }

    public void setCurrent(Location current) {
        this.current = current;
    }
}
