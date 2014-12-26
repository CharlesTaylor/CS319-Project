package com.group1.datamanage;

/**
 * Created by Fatih on 27/11/2014.
 */
public class User {

    private String username;

    public String getUsername() {
        return username;
    }

    //Password to be crypted possibly
    private String password;
    private String seed;
    private String data;
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }


    public String getSeed(){
        return seed;
    }
    public String getData(){ return data;}
    public boolean tryPassword(String pass){
        return password.equals(pass);
    }
}
