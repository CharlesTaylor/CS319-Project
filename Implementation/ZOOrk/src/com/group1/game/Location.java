package com.group1.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fatih on 27/11/2014.
 */
public class Location {

    private Map map;
    private int x,y;
    private String description;
    /**
     *Indicates if Location is passable, can be changed as Boolean[3] passable,
     *to indicate directions from this location depending of the implementation
     */
    private boolean passable[];

    private enum LocType{ Plains,Village,Dungeon,Castle};

    public List<Thing> getThings() {
        return things;
    }

    public boolean isPassable(Direction d) {
        return passable[d.ordinal()];
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
    public Location( Map map,int x, int y, boolean passable[],List<Thing> things, List<Character> characters){
        this.map = map;
        this.x = x;this.y =y;
        this.passable = passable;
        this.things = things;
        this.characters = characters;
    }

    public Location( boolean []passable,List<Thing> things, Character character){
        this.passable = passable;
        this.things = things;
        characters = new ArrayList<Character>();
        characters.add(character);
    }

    private List<Thing> fill(String seed) {
        //TODO
        return null;
    }


    public Location getAdjacent(Direction d){
        switch(d){
            case North:
                return map.getLocation(x,y+1);
            case South:
                return map.getLocation(x,y-1);
            case East:
                return map.getLocation(x+1,y);
            case West:
                return map.getLocation(x-1,y);
        }
        return null;
    }

    public String getMessage(){
        StringBuilder build = new StringBuilder(things.size() * 10+characters.size()*10+30);

        build.append(description);
        if(things.size() !=0)
        {
            build.append( " There are");
        }
        for( Thing t : things){
            build.append(t.getMessage());
            build.append( ", ");
        }
        if(things.size() !=0)
        {
            build.append( " in this Location. ");
        }

        if(characters.size() !=0)
        {
            build.append( "Also there are");
        }
        for( Character c : characters){
            build.append(c.getName());
            build.append( ", ");
        }
        if(things.size() !=0)
        {
            build.append( "in this Location. ");
        }
        return build.toString();
    }
}
