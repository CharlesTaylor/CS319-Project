package com.group1.game;

import java.util.List;

/**
 * Created by Fatih on 02/12/2014.
 */
public class HostileCharacter extends NonPlayerCharacter {


    boolean awake;



    /**
     * Constructor for HostileCharacter, Designed to work both when initialization and loading the game
     * NonPlayer
     *
     * @param name      String name to assign to character
     * @param inventory List of Items Character has
     * @param x location of the HostileCharacter
     * @param y location of the HostileCharacter
     */
    public HostileCharacter(String name, List<Item> inventory, int x, int y) {
        super(name, inventory, x, y);
    }

    public boolean isAwake() {
        return awake;
    }

    public void setAwake(boolean awake) {
        this.awake = awake;
    }
}
