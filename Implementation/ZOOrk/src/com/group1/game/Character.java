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
    String name;
    /**
     * Character's current Location
     */
    Location current;
    /**
     * Characters Item List, inventory
     */
    List<Item> inventory;

    /**
     * Constructor for Character, Designed to work both when initialization and loading the game
     * @param name String name to assign to character
     * @param inventory List of Items Character has
     * @param current Location of the Character
     */
    public  Character( String name, List<Item> inventory, Location current){
        this.name = name;

        if(inventory ==null)    this.inventory = new ArrayList<Item>();
        else    this.inventory = inventory;

        this.current = current;
    }


    /**
    * Character atacks to the target character according to its stats and equipment
     * This method designed to be called from Character object inside Location object
     * inside Map object inside Game object inside Parser object
     * game.map.loc.char.attack(game.map.loc.char2);
    *
    * @param  Character to be attacked
    * @return resulting boolean or string message depending on the implementation
    */
    public boolean attack( Character target){
        return false;
    }




}
