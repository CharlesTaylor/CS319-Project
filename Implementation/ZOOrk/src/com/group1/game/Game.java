package com.group1.game;

/**
 * Created by Fatih on 27/11/2014.
 */
public class Game {

    Player player;
    public Game( Player player){
        this.player = player;
    }
    public Player getPlayer() { return player;}
    public boolean saveGame(){
        return false;
    }//Move this to GameSystem
}
