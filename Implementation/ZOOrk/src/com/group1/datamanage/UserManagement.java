package com.group1.datamanage;

import java.util.List;
import java.util.Map;

/**
 * Created by Fatih on 30/11/2014.
 */
public class UserManagement {

    Map<String,User> userList;


    public UserManagement(){
        userList = getUsers();
    }

    private Map<String,User> getUsers() {


        // TODO
        return null;
    }


    public boolean checkIDPassword(String id,String pass){
        return userList.get(id).tryPassword(pass);
    }
    public User getUser( String id){ return userList.get(id);}
}
