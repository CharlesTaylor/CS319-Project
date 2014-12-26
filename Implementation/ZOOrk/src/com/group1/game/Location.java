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

    public List<HostileCharacter> getCharacters() {
        return characters;
    }

    public enum LocType{ Plains,Village,Dungeon,Castle};

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
    private List<HostileCharacter> characters;

    //Constructor for Loading Locations
    public Location( Map map, boolean passable[],List<Thing> things, List<HostileCharacter> characters,String description){
        this.map = map;
        this.x = x;this.y =y;
        this.passable = passable;
        this.things = things;
        this.characters = characters;
        this.description = description;
    }

//    public Location( boolean []passable,List<Thing> things, Character character){
//        this.passable = passable;
//        this.things = things;
//        characters = new ArrayList<Character>();
//        characters.add(character);
//    }


    public void setXY(int x,int y){
        this.x=x;
        this.y=y;
    }


    public void setCharacters(List<HostileCharacter> characters) {
        this.characters = characters;
    }

    public String getMessage(){
        if(things == null) {
            things = new ArrayList<Thing>();
            System.out.println( "Characters null");
        }
        if(characters == null)
        {
            characters = new ArrayList<HostileCharacter>();

        }
        StringBuilder build = new StringBuilder(things.size() * 10+characters.size()*10+30);

        build.append(description);
        if(things.size() !=0)
        {
            build.append( "There is ");
        }
            for( Thing t : things){
                build.append("a ");
                build.append(t.getName());
                build.append( ", ");
        }
        if(things.size() !=0)
        {
            build.append( " at this location.");
        }

        if(characters.size() !=0)
        {
            build.append( "Also there is ");
        }
        for( Character c : characters){
            build.append("a ");
            build.append(c.getName());
            build.append( ", ");
        }
        if(characters.size() !=0)
        {
            build.append( "at this location.");
        }
        return build.toString();
    }
}
