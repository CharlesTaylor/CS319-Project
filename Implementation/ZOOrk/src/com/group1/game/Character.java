package com.group1.game;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Fatih on 27/11/2014.
 *
 */
public abstract class Character {

    boolean awake;

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    boolean dead;
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
    public String attack(HostileCharacter character,Item item) {
        StringBuilder build = new StringBuilder(300);
        character.setHitpoint(character.getHitpoint() - getStrength() * item.getDamage());
        build.append(getName());
        build.append(" inflicted ");
        build.append( getStrength()*item.getDamage());
        build.append(" damage to ");
        build.append(character.getName());
        build.append(". ");
        build.append( character.getName());
        build.append( "fought back and ");
        setHitpoint(getHitpoint() - name.length()* character.getWeapon().getDamage());
        build.append(" inflicted ");
        build.append( character.getWeapon().getDamage() );
        build.append(" damage to ");
        build.append(getName());
        return build.toString();
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
