package com.group1.game;

import java.util.List;

/**
 * Created by Fatih on 27/11/2014.
 */
public class Player extends Character {
    String seed;

    /**
     * Constructor for Player, Designed to work both when initialization and loading the game
     *
     * @param name      String name to assign to Player
     * @param inventory List of Items Player has
     * @param current   Location of the Player
     */
    public Player(String name, List<Item> inventory, Location current) {
        super(name, inventory, current);
    }

    /**
     * Player moves according to given direction if it is possible,
     * result given with an appropriate string message
     * This method designed to be called from Player object inside Game object inside Parser object
     * game.player.move(Direction d);
     *
     * @param  Direction to move
     * @return resulting boolean or string message depending on the implementation
     */
    public boolean go( Direction d){
        return false;
    }
    /**
     * Player interacts with given Thing if it is possible,
     * result given with an appropriate string message
     * This method designed to be called from Player object inside Game object inside Parser object
     * game.player.interact(Thing t);
     *
     * @param  Thing to interact
     * @return resulting boolean or string message depending on the implementation
     */
    public boolean interact( Thing t){
        return false;
    }

}
