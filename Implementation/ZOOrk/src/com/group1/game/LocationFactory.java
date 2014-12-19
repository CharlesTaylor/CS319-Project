package com.group1.game;

import java.util.ArrayDeque;

/**
 * Created by Fatih on 02/12/2014.
 */
public class LocationFactory {
	
	private static LocationFactory instance = null;
	 /**
     * Constructor for LocationFactory class
     * This class generates and keeps a list of locations to feed into Map
     *
     *
     * @param seed a string to manipulate randomness
     */
	protected LocationFactory(String seed){
        this.seed = seed;
        buffer = new ArrayDeque<Location>();
        bufferSize =5;
    }
	public static LocationFactory getInstance(String seed) {
		if(instance == null) {
			instance = new LocationFactory(seed);
		}
		return instance;
	}
    String seed;
    private int bufferSize;
    private ArrayDeque<Location> buffer;
   

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
        Location newLocation = null;
        //Randomize and fill the location according to seed and do this part separately
        buffer.add(newLocation);


        return buffer.pollFirst();
    }





}
