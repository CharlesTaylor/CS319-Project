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
    final static int[] randRates  = new int[]{100,75,50,25};

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
        bufferSize = new int[]{15,15,15,15};
        buffers = new ArrayDeque[]{
                new ArrayDeque<Location>(bufferSize[0]),
                new ArrayDeque<Location>(bufferSize[1]),
                new ArrayDeque<Location>(bufferSize[2]),
                new ArrayDeque<Location>(bufferSize[3])};
        randomize = new Random(Integer.parseInt(seed));
//        generate = new GenThread[4];
//        for(int i = 0; i < generate.length;i++)
//        {
//            generate[i] = new GenThread(game,bufferSize[i]-buffers[i].size(), Location.LocType.values()[i],randomize);
//            generate[i].start();
//        }

    }
	public static LocationFactory getInstance(Game game) {
		if(instance == null) {
			instance = new LocationFactory(game);
		}
		return instance;
	}
    Random randomize;
    String seed;
    private int bufferSize[];
    private ArrayDeque[] buffers;
    //GenThread[] generate;

    /**
     * setBufferSize method resets the bufferSize to change number of maps kept in the deque
     *
     *
     * @param bufferSize new bufferSize for the keeping Locations
     */
    public void setBufferSize(int bufferSize,int bufferNO)
    {
        this.bufferSize[bufferNO] = bufferSize;
    }
    /**
     * getLocation methods returns a Location that kept in the deque
     * @return newLocation
     */
    public Location getLocation(Location.LocType type){

//        try{
//            if(generate !=null && generate[type.ordinal()] !=null && generate[type.ordinal()].isAlive())
//            {
//                generate[type.ordinal()].join();
//
//                buffers[type.ordinal()].addAll(generate[type.ordinal()].getLocs());
//            }
//
//
//            return (Location)buffers[type.ordinal()].pollFirst();
//        }catch( InterruptedException e){
//            e.printStackTrace();
//        }finally{
//            if(bufferSize[type.ordinal()] - buffers[type.ordinal()].size()-1 >0){
//
//                generate[type.ordinal()] = new GenThread(game,bufferSize[type.ordinal()]-buffers[type.ordinal()].size(),type,randomize);
//                generate[type.ordinal()].start();
//            }
//        }

        //Randomize and fill the location according to seed and do this part separately
        generate(type);

        return (Location) buffers[type.ordinal()].pop();
    }

    private void generate(Location.LocType type){

        boolean[] passables = new boolean[]{true,true,true,true,false,false};
        List<Thing> things = new ArrayList<Thing>();
        for(Thing t : game.getAllThings()){
            if(randomize.nextInt()%randRates[type.ordinal()]==0){
                things.add(t);
            }
        }
        List<HostileCharacter> characters = new ArrayList<HostileCharacter>();
        for(Character c : game.getAllCharacters()){
            if(randomize.nextInt()%randRates[type.ordinal()]==0){
                characters.add((HostileCharacter)c);
            }
        }
        List<String> typeDesc = game.getAllDescriptions()[type.ordinal()];
        buffers[type.ordinal()].add( new Location(game.getMap(),passables,things,characters,typeDesc.get( Math.abs(randomize.nextInt())%typeDesc.size())));

    }




}
