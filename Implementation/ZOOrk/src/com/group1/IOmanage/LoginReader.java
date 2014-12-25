package com.group1.IOmanage;

import com.group1.game.Game;
import com.group1.game.GameSystem;

/**
 * Created by Fatih on 25/12/2014.
 */
public class LoginReader implements Reader {
    private static Reader instance = null;
    protected LoginReader(GameSystem gameSys)
    {
        this.gameSys = gameSys;
    }
    public static Reader getInstance(GameSystem gameSys)
    {
        if(instance == null)
        {
            instance = new LoginReader(gameSys);
        }
        return instance;
    }
    private GameSystem gameSys;

    @Override
    public String analyze(int input) {
        switch (input){
            case 1:
                return "Choose a username\n";
        }
    }
}
