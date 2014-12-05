package com.group1.game;

/**
 * Created by Fatih on 27/11/2014.
 */
public class Game {

    private Player player;

    /**
     * Constructor for Game
     * This class connects separate pieces of the program
     * for example Reader calls methods of the Player class
     * with help of this class, game.player.foo();
     *
     * @param player      String name to assign to character
     */
    public Game( Player player){
        this.player = player;
    }


    /**
     * getPlayer() method returns the player object to the caller
     *
     *@return player
    */
    public Player getPlayer(){ return player; }

    /**
     * getPlayer() method returns the player object to the caller
     *
     *@deprecated
     *@return status
     */
    public boolean saveGame(){
        return false;
    }//Move this to GameSystem
}
