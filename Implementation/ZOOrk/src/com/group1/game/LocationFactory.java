package com.group1.game;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Fatih on 02/12/2014.
 */
public class LocationFactory {

    private static final int RAND_RAT = 100;

    Game game;
	private static LocationFactory instance = null;
	 /**
     * Constructor for LocationFactory class
     * This class generates and keeps a list of locations to feed into Map
     *
     *
     * @param game to access game elements
     */

	protected LocationFactory(Game game){
        this.game = game;
        this.seed = game.getPlayer().getSeed();
        buffer = new ArrayDeque<Location>();
        bufferSize =5;
        randomize = new Random(Integer.parseInt(seed));

    }
	public static LocationFactory getInstance(Game game) {
		if(instance == null) {
			instance = new LocationFactory(game);
		}
		return instance;
	}
    Random randomize;
    String seed;
    private int bufferSize;
    private ArrayDeque<Location> buffer;
    GenThread generate;

    /**
     * setBufferSize method resets the bufferSize to change number of maps kept in the deque
     *
     *
     * @param bufferSize new bufferSize for the keeping Locations
     */
    public void setBufferSize(int bufferSize)
    {
        this.bufferSize = bufferSize;
    }
    /**
     * getLocation methods returns a Location that kept in the deque
     * @return newLocation
     */
    public Location getLocation(){
        try{
            if(generate !=null && generate.isAlive())
                generate.join();

            buffer.addAll(generate.getLocs());

            return buffer.pollFirst();
        }catch( InterruptedException e){
            e.printStackTrace();
        }finally{
            if(bufferSize -buffer.size()-1 >0){

                generate = new GenThread(game,bufferSize-buffer.size(),RAND_RAT,randomize);
                generate.start();
            }
        }

        //Randomize and fill the location according to seed and do this part separately


        return null;
    }

    private Location generate(){
        boolean[] passables = new boolean[]{true,true,true,true,false,false};
        List<Thing> things = new ArrayList<Thing>();
        for(Thing t : game.getAllThings()){
            if(randomize.nextInt()%RAND_RAT==0){
                things.add(t);
            }
        }
        List<Character> characters = new ArrayList<Character>();
        for(Character c : game.getAllCharacters()){
            if(randomize.nextInt()%RAND_RAT==0){
                characters.add(c);
            }
        }
        return new Location(null,0,0,passables,things,characters);
    }




}
