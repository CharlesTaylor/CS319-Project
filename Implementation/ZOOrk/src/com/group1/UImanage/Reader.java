package com.group1.UImanage;

import com.group1.game.Direction;
import com.group1.game.Game;

/**
 * Created by Fatih on 02/12/2014.
 */
public class Reader {
    Game game;
    public Reader(Game game){
        this.game = game;
    }


    public void analyze( String input){
        //TODO
        String[] parts = input.split( " ");
        if(parts[0].equalsIgnoreCase("go"))
        {
            switch( parts[1].charAt(0)){
                case 'n':case 'N':
                    game.getPlayer().go(Direction.North);
                    break;
                case 'e':case 'E':
                    game.getPlayer().go(Direction.East);
                    break;
                case 's':case 'S':
                    game.getPlayer().go(Direction.South);
                    break;
                case 'w':case 'W':
                    game.getPlayer().go(Direction.West);
                    break;
            }
        }



    }
}
