package com.group1.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fatih on 27/11/2014.
 */
public class Location {

    /**
     *Indicates if Location is passable, can be changed as Boolean[3] passable,
     *to indicate directions from this location depending of the implementation
     */
    private boolean passable;

    private enum LocType{ Plains,Village,Dungeon,Castle};

    public List<Thing> getThings() {
        return things;
    }

    public boolean isPassable() {
        return passable;
    }

    /**
     * List of Thing's inside this location, will be randomly generated if location is new, while loading it will be
     * generated according to given List
     */
    private List<Thing> things;
    private List<Character> characters;
    //Constructor for Generating Locations
    public Location(){
        things = fill(null);
    }
    //Constructor for Loading Locations
    public Location( boolean passable,List<Thing> things, List<Character> characters){
        this.passable = passable;
        this.things = things;
        this.characters = characters;
    }

    public Location( boolean passable,List<Thing> things, Character character){
        this.passable = passable;
        this.things = things;
        characters = new ArrayList<>();
        characters.add(character);
    }

    private List<Thing> fill(String seed) {
        //TODO
        return null;
    }
}
