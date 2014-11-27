package com.group1.game;

/**
 * Created by Fatih on 27/11/2014.
 */
public class Character {
    String name;
    Location current;


    public  Character(){


    }
    /**
    * Character atacks to the target character according to its stats and equipment
     * This method designed to be called from Character object inside Location object
     * inside Map object inside Game object inside Parser object
     * game.map.loc.char.attack(game.map.loc.char2);
    *
    * @param  Character to be atacked
    * @return resulting boolean or string message depending on the implementation
    */
    public boolean attack( Character target){


        return false;
    }




}
