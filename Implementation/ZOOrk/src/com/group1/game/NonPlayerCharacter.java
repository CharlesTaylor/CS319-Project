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
     */
    public NonPlayerCharacter(String name) {
        super(name);
    }
}
