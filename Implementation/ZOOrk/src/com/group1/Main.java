package com.group1;

import com.group1.IOmanage.Reader;
import com.group1.datamanage.UserManagement;
import com.group1.game.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.group1.game.Character;
import com.thoughtworks.xstream.*;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class Main {
    public static final String EXIT = "exit";
    public static final String LOGIN = "login";
    public static final String REGISTER = "register";


    public static void main(String[] args) throws FileNotFoundException {
	// write your code here
        Game game = new Game(null);
        game.setAll();
//        encode.writeObject(list);
//        encode.close();
        System.out.println();//Welcome Message Here
//        String input = scan.nextLine();
//        while(!input.equalsIgnoreCase(EXIT)){
//
//            UserManagement mng = UserManagement.getInstance();
//            while(!input.equalsIgnoreCase(LOGIN)){
//                String[] in = input.split( " ");
//                if(in[0].equalsIgnoreCase(REGISTER)){
//                    if(in.length == 4){
//                        boolean flag = mng.newUser(in[1],in[2],in[3]);
//                    }
//                }
//            }
//
//            Player player = new Player( "Necati",null,16,16);
//            Game game = new Game( player);
//            Reader reader = Reader.getInstance( game);
//            scan.nextLine();
//            input = scan.nextLine();
//            //Game Loop
//            while(!input.equalsIgnoreCase(EXIT)){
//
//                System.out.println(reader.analyze(input));
//                input = scan.nextLine();
//            }
//        }
    }


}
