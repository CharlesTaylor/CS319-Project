package com.group1.game;

import java.util.*;

/**
 * Created by Fatih on 21/12/2014.
 */
public class GenThread extends Thread {

    int numOfLocations;
    Random randomize;
    Game game;
    int randrate;
    List listofLocs;
    public GenThread(Game game,int numOfLocations,int randrate, Random randomize){
        this.game = game;
        this.randrate = randrate;
        this.numOfLocations = numOfLocations;
        this.randomize = randomize;
        listofLocs = new ArrayList(numOfLocations);
    }
    public void run(){
        for( int i = 0; i < numOfLocations ;i++){
            boolean[] passables = new boolean[]{true,true,true,true,false,false};
            List<Thing> things = new ArrayList<Thing>();
            for(Thing t : game.getAllThings()){
                if(randomize.nextInt()%randrate==0){
                    things.add(t);
                }
            }
            List<Character> characters = new ArrayList<Character>();
            for(Character c : game.getAllCharacters()){
                if(randomize.nextInt()%randrate==0){
                    characters.add(c);
                }
            }
            //listofLocs.add( new Location(passables,things,characters));
        }
    }
    public List<Location> getLocs(){
        return Collections.unmodifiableList(listofLocs);
    }
}
