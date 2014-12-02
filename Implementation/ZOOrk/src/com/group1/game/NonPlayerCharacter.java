package com.group1.game;

import java.util.List;

/**
 * Created by Fatih on 02/12/2014.
 */
public abstract class NonPlayerCharacter extends Character {
    /**
     * Constructor for NonPlayerCharacter, Designed to work both when initialization and loading the game
     *NonPlayer
     * @param name      String name to assign to character
     * @param inventory List of Items Character has
     * @param x location of the character
     * @param y location of the character
     */
    public NonPlayerCharacter(String name, List<Item> inventory, int x, int y) {
        super(name, inventory, x, y);
    }
}
