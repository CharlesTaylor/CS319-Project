package com.group1.game;

import com.group1.UImanage.Reader;
import com.group1.datamanage.User;
import com.group1.datamanage.UserManagement;

/**
 * Created by Fatih on 02/12/2014.
 */
public class GameSystem {

    private  Player player;
    private Game game;
    private Reader reader;
    private UserManagement mng;
    private User user;
    private Map map;
    public GameSystem(Player player){
        mng = new UserManagement();

    }

    private void startGame(Player player,Game game){
        this.player = player;
        game = new Game( player);
        reader = new Reader( game);
    }

    public void login(String name, String pass){
        if(mng.checkIDPassword(name,pass)){
            user = mng.getUser(name);
        }
        generateGame( user);
    }

    private void generateGame(User user) {
        String data = user.getData();
        if( data.isEmpty()){
            //Generate Game According to Default Settings
        }else{
            //Generate Game According to data

        }
        startGame(player,game);
    }
}
