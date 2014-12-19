package com.group1.datamanage;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Fatih on 30/11/2014.
 */
public class UserManagement {
	
	private static UserManagement instance = null;
	protected UserManagement(){
        try{
            userMap = getUsers();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

    }
	public static UserManagement getInstance() {
		if(instance == null) {
			instance = new UserManagement();
	}
		return instance;
	}
    Map<String,User> userMap;




    private Map<String,User> getUsers() throws FileNotFoundException{

        Scanner readFile = new Scanner(new FileReader("Data\\users.dat"));
        userMap = new HashMap<String, User>();

        while(readFile.hasNextLine()){
            String[] temp = readFile.nextLine().split( " ");
            userMap.put(temp[0],new User(temp[0],temp[1]));
        }
        // TODO
        return userMap;
    }


    public boolean checkIDPassword(String id,String pass){
        return userMap.get(id).tryPassword(pass);
    }
    public User getUser( String id){ return userMap.get(id);}
    public boolean newUser( String id, String pass, String passAgain){
        if(pass.equals(passAgain) && !userMap.containsKey(id))
        {
            try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Data\\users.dat", true)))) {
                out.println(id + " " + Integer.toHexString(pass.hashCode()));
                return true;
            }catch (IOException e) {
                e.printStackTrace();
            }


        }
        return false;
    }
}
