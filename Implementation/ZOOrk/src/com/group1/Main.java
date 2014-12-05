package com.group1;

import com.group1.UImanage.Reader;
import com.group1.datamanage.UserManagement;
import com.group1.game.Game;
import com.group1.game.Player;

import java.util.Scanner;

public class Main {
    public static final String EXIT = "exit";

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        UserManagement mng = new UserManagement();

        System.out.println(mng.newUser( scan.next(),scan.next(),scan.next()));

        Player player = new Player( "Necati",null,16,16);
        Game game = new Game( player);
        Reader reader = new Reader(game);
        scan.nextLine();
        String input = scan.nextLine();
        //Game Loop
        while(!input.equalsIgnoreCase(EXIT)){
            System.out.println(reader.analyze(input));
            input = scan.nextLine();
        }


    }
}
