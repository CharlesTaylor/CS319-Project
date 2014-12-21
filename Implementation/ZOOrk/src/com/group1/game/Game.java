package com.group1.game;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.io.File;
import java.util.List;
import java.util.Scanner;

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
    private List<String> allDescriptions;
    private List<Thing> allThings;
    private List<Character> allCharacters;
    public Game( Player player){
        this.player = player;
    }

    public List<Thing> getAllThings() {
        return allThings;
    }

    public void setAll() {
        XStream xstream = new XStream(new StaxDriver());
        allThings =(List) xstream.fromXML(new File("Data//things.xml"));
        allCharacters = (List) xstream.fromXML(new File("Data//characters.xml"));
    }

    public List<Character> getAllCharacters() {
        return allCharacters;
    }

    public void setAllCharacters(List<Character> allCharacters) {
        this.allCharacters = allCharacters;
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
