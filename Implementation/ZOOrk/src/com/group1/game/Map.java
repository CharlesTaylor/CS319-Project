package com.group1.game;

/**
 * Created by Fatih on 27/11/2014.
 */
public class Map {

    private final double SIZEMULT = 2;
    int size;
    String name;
    Game game;
    Location[][] locations;
    LocationFactory locationFactory;

    /**
     * Constuctor for Map class
     * @param game, game object to access other objects
     * @param initial int, shows the initial size of the square map
     *
     */
    public Map(Game game,int initial){
        this.size = initial;
        this.game = game;
        locationFactory = new LocationFactory( game);
        locations = new Location[initial][initial];
    }

    public Location getLocation( int x,int y){
        return locations[x][y];
    }

    /**
     * enlarge method
     * enlarges the map with the following pattern
     *
     *                          **   to #**#
     *
     *               * to old locations
     *               # to newly generated locations
     * this method is called when player is near the borders of the map,
     * it takes no parameter but it multiplies size by SIZEMULT constant of the class
     *
     */
    private void enlarge(){
        Location[][] newLocations = new Location[(int)(size*SIZEMULT)][(int)(size*SIZEMULT)];
        for( int i = 0 ; i < size;i++)
            for(int j = 0; j < size;j++)
                newLocations[size+i][size+j] = locations[i][j];
        locations = newLocations;
        size = locations.length;
        System.gc();
    }


}
