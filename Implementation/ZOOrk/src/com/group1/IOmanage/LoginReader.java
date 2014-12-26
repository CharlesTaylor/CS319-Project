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
    public String analyze(String input) {

        String[] parts = input.split( " ");
        if(parts[0].equalsIgnoreCase("login")){
            if(parts.length > 2){
                if (!gameSys.login(parts[1],parts[2])) {
                    return "Login Failed";
                }
            }
        }
        else if(parts[0].equalsIgnoreCase("register")){
            if(parts.length > 3){
                if(gameSys.getMng().newUser(parts[1],parts[2],parts[3])){
                    return "Register Success";
                }
                else
                {
                    return "Register Failed";
                }
            }
        }
        return "";
    }
}
