package com.group1.game;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Fatih on 27/11/2014.
 *
 */
public abstract class Character {
    private int strength;
    /**
     * Characters name
     */
    private String name;
    /**
     *
     * Character's current Location
     */
    private Location current;
    /**
     * Characters Item List, inventory
     */
    private List<Item> inventory;

    private int hitpoint;

    private int strength;

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
<<<<<<< HEAD
    public String attack(Character character,Item item) {
        StringBuilder build = new StringBuilder(150);
        character.setHitpoint(character.getHitpoint() - character.getStrength() * item.getDamage());
        build.append(" Remaining strength of the ");
        build.append(character.getName());
        build.append(" : ");
        build.append(character.getStrength());
        return build.toString();
=======
    public String attack(Character character,Item item){
        character.setHitpoint( character.getHitpoint() - strength * item.getDamage());
        return "Message";
    }

>>>>>>> origin/master

    }
    public String getName() {
        return name;
    }


    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
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
