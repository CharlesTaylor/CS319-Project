package com.group1.UImanage;

import com.group1.game.Direction;
import com.group1.game.Game;

/**
 * Created by Fatih on 02/12/2014.
 */
public class Reader {
    private Game game;
    public Reader(Game game){
        this.game = game;
    }

    /**
     * analyze method, analyzes given string and calls methods from game.getCharacter()
     *      given:
     *          String format is like → action receiver tool
     *                                → action direction
     *                                etc
     * @param input String
     * @return returning message
     *
     */
    public String analyze( String input){
        //TODO
        String[] parts = input.split( " ");
        if(parts[0].equalsIgnoreCase("go"))
        {
            switch( parts[1].charAt(0)){
                case 'n':case 'N':
                    return game.getPlayer().go(Direction.North);
                    //break;
                case 'e':case 'E':
                    return game.getPlayer().go(Direction.East);
                    //break;
                case 's':case 'S':
                    return game.getPlayer().go(Direction.South);
                    //break;
                case 'w':case 'W':
                    return game.getPlayer().go(Direction.West);
                    //break;
            }
        }


        return "null";
    }
}
