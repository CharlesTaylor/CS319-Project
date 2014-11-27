package com.group1.game;

/**
 * Created by Fatih on 27/11/2014.
 */
public class Player extends Character {



    String seed;

    public Player(){

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

}
