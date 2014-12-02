package com.group1.game;

import java.util.ArrayDeque;

/**
 * Created by Fatih on 02/12/2014.
 */
public class LocationFactory {
    String seed;
    private int bufferSize;
    private ArrayDeque<Location> buffer;
    /**
     * Constructor for LocationFactory class
     * This class generates and keeps a list of locations to feed into Map
     *
     *
     * @param seed a string to manipulate randomness
     */
    public LocationFactory(String seed){
        this.seed = seed;
        buffer = new ArrayDeque<Location>();
        bufferSize =5;
    }
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
