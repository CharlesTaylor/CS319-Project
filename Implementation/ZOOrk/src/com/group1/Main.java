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
        Scanner scan = new Scanner(System.in);
        GameSystem gameSystem = GameSystem.getInstance();
        List<Character> list = new ArrayList<Character>();
        list.add(new HostileCharacter( "Troll", new Item( "Gorehowl",10,0) ));
        list.add(new HostileCharacter( "Grue", new Item( "Knife",4,0) ));
        list.add(new HostileCharacter( "Grinch", new Item( "Christmas_Ball_of_Doom",100,0) ));
        list.add(new HostileCharacter( "Ogre", new Item( "Ogre_Club",13,0) ));
        list.add(new HostileCharacter( "Spectre", new Item( "Scythe",12,0) ));
        list.add(new HostileCharacter( "imp", new Item( "Imp_Sword",2,0) ));
        list.add(new HostileCharacter( "Dark_Elf", new Item( "Bow",15,0) ));
        list.add(new HostileCharacter( "Necromancer", new Item( "Skull",21,0) ));
        list.add(new HostileCharacter( "Hitler", new Item( "Reich",15,0) ));
        list.add(new HostileCharacter( "Wild_Boar", new Item( "Sharp_Fangs",4,0) ));
        list.add(new HostileCharacter( "Goomba", new Item( "Head_Butt",2,0) ));
        list.add(new HostileCharacter( "Slime", new Item( "Slime",1,0) ));
        list.add(new HostileCharacter( "Centaur_HeadHunter", new Item( "Sniper_Rifle",21,0) ));
        list.add(new HostileCharacter( "Bogart", new Item( "Staff",3,0) ));
        list.add(new HostileCharacter( "Siren", new Item( "Fork",8,0) ));
        list.add(new HostileCharacter( "Cyclops", new Item( "SledgeHammer",15,0) ));

        XStream xstream = new XStream(new StaxDriver());
        String xml = xstream.toXML(list);

        BufferedOutputStream stream =  new BufferedOutputStream(new FileOutputStream("data//characters.xml"));
        try {
            stream.write(xml.getBytes());
            stream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

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
