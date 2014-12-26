package com.group1.game;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Fatih on 27/11/2014.
 */
public class Game {

    private Player player;

    public List<String>[] getAllDescriptions() {
        return allDescriptions;
    }

    public void setAllDescriptions(List<String>[] allDescriptions) {
        this.allDescriptions = allDescriptions;
    }

    /**
     * Constructor for Game
     * This class connects separate pieces of the program
     * for example Reader calls methods of the Player class
     * with help of this class, game.player.foo();
     *
     * @param player      String name to assign to character
     */
    private List<String>[] allDescriptions;//Plains,Castle,Dungeon,Village
    private List<Thing> allThings;
    private List<Character> allCharacters;
    private Map map;
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
        Scanner read = null;
        try {
            read = new Scanner( new File("Data//descriptions.dat"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        allDescriptions = new List[4];
        for(int i = 0; i < allDescriptions.length;i++){
            allDescriptions[i] = new ArrayList<String>();
            while(read.hasNextLine()){
                String temp = read.nextLine();
                //System.out.println(temp);
                if(temp.equals("$"))
                    break;
                allDescriptions[i].add(temp);

            }
        }

    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public List<Character> getAllCharacters() {
        return allCharacters;
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
