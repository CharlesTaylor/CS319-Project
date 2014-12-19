package com.group1;

import com.group1.IOmanage.Reader;
import com.group1.datamanage.UserManagement;
import com.group1.game.Game;
import com.group1.game.GameSystem;
import com.group1.game.Player;

import java.util.Scanner;

public class Main {
    public static final String EXIT = "exit";
    public static final String LOGIN = "login";
    public static final String REGISTER = "register";


    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        GameSystem gameSystem = GameSystem.getInstance();

        System.out.println();//Welcome Message Here
        String input = scan.nextLine();
        while(!input.equalsIgnoreCase(EXIT)){

            UserManagement mng = UserManagement.getInstance();
            while(!input.equalsIgnoreCase(LOGIN)){
                String[] in = input.split( " ");
                if(in[0].equalsIgnoreCase(REGISTER)){
                    if(in.length == 4){
                        boolean flag = mng.newUser(in[1],in[2],in[3]);
                    }
                }
            }

            Player player = new Player( "Necati",null,16,16);
            Game game = new Game( player);
            Reader reader = Reader.getInstance( game);
            scan.nextLine();
            input = scan.nextLine();
            //Game Loop
            while(!input.equalsIgnoreCase(EXIT)){

                System.out.println(reader.analyze(input));
                input = scan.nextLine();
            }
        }
    }
}
