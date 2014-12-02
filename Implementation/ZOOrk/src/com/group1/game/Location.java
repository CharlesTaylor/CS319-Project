package com.group1.game;

import java.util.List;

/**
 * Created by Fatih on 27/11/2014.
 */
public class Location {

    /**
     *Indicates if Location is passable, can be changed as Boolean[3] passable,
     *to indicate directions from this location depending of the implementation
     */
    boolean passable;

    /**
     * List of Thing's inside this location, will be randomly generated if location is new, while loading it will be
     * generated according to given List
     */
    List<Thing> things;

    //Constructor for Generating Locations
    public Location(){
        things = fill(null);
    }
    //Constructor for Loading Locations
    public Location( boolean passable,List<Thing> things){
        this.passable = passable;
        this.things = things;
    }

    private List<Thing> fill(String seed) {
        //TODO
        return null;
    }
}
