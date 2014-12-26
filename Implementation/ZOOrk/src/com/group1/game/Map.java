package com.group1.game;

/**
 * Created by Fatih on 27/11/2014.
 */
public class Map {

    public static final int SIZE = 64;
    private final double SIZEMULT = 2;
    int size;
    String name;

    public Location[][] getLocations() {
        return locations;
    }

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
        locations[initial/2][initial/2] = locationFactory.getLocation(Location.LocType.Plains);
    }

    public Location getLocation( int x,int y){
        if(x == SIZE -1 || y == SIZE -1 || x ==0 || y == 0){
            enlarge();
            game.getPlayer().setXY((int)(size/SIZEMULT+x),(int)(size/SIZEMULT+y));

        }
        if(locations[x][y] == null) {
            if (x > 48 && y > 48 && x < 64 && y < 64)
                locations[x][y] = locationFactory.getLocation(Location.LocType.Dungeon);
            else if (x > 28 && y > 28 && x < 34 && y < 34)
                locations[x][y] = locationFactory.getLocation(Location.LocType.Village);
            else if (x > 48 && y > 0 && x < 64 && y < 16)
                locations[x][y] = locationFactory.getLocation(Location.LocType.Castle);
            else
                locations[x][y] = locationFactory.getLocation(Location.LocType.Plains);
        }
        return locations[x][y];
    }

    public int getSize() {
        return size;
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
