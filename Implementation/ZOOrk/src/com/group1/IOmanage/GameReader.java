package com.group1.IOmanage;
import java.util.Scanner;

import com.group1.game.*;
import com.group1.game.Character;


public class GameReader implements Reader
{
    private static Reader instance = null;
    protected GameReader(Game game)
    {
        this.game = game;
    }
    public static Reader getInstance(Game game)
    {
        if(instance == null)
        {
            instance = new GameReader(game);
        }
        return instance;
    }
    private Game game;

    /**
     * analyze method, analyzes given string and calls methods from game.getCharacter()
     * given:
     * String format is like � action receiver tool
     * � action direction
     * etc
     * @param input String
     * @return returning message
     *
     */
    public String analyze( String input)
    {
        //TODO

        Player character = game.getPlayer();
        Location location = character.getCurrent();
        String[] parts = input.split( " ");
        if(parts[0].equalsIgnoreCase("go"))
        {
            if (parts.length > 1) {
                switch (parts[1].charAt(0)) {
                    case 'n':
                    case 'N':
                        return game.getPlayer().go(Direction.North);
                    //break;
                    case 'e':
                    case 'E':
                        return game.getPlayer().go(Direction.East);
                    //break;
                    case 's':
                    case 'S':
                        return game.getPlayer().go(Direction.South);
                    //break;
                    case 'w':
                    case 'W':
                        return game.getPlayer().go(Direction.West);
                    //break;
                    default:
                        System.out.println("invalid command");
                        analyze("go");

                }
            }
                if (parts.length == 1)
                    return wantMoreCommand("go");
        }
        if(parts[0].equalsIgnoreCase("attack"))
        {
            if (parts.length > 2)
            {
                for(Character c : location.getCharacters())
                {
                    if(c.getName().equalsIgnoreCase(parts[1]))
                    {
                        for(Item i : character.getInventory())
                        {
                            if(i.getName().equalsIgnoreCase(parts[2]))
                                return character.attack(c, i);
                            if(  c.isDead()) {
                                character.getCurrent().getCharacters().remove(c);
                                character.getCurrent().getThings().addAll(c.getInventory());
                                c = null;
                            }

                        }

                    }
                }
            }
            if(parts.length == 1)
            {
                return wantMoreCommand("attacktowhoandwithwhat");
            }
            if(parts.length == 2)
            {
                return wantMoreCommand("attacktowhoorwithwhat");
            }
        }
        if(parts[0].equalsIgnoreCase("interact"))
        {
            if(parts.length >1)
            {
                for(Thing t : game.getPlayer().getCurrent().getThings())
                {
                    if (t.getName().equalsIgnoreCase(parts[1]))
                    {
                        return game.getPlayer().interact(t);
                    }
                }
            }

            else
                return wantMoreCommand("interact");

        }
        if(parts[0].equalsIgnoreCase("use"))
        {
            if (parts.length > 1)
            {
                for(Item i : character.getInventory())
                {
                    if(i.getName().equalsIgnoreCase(parts[1]))
                    {
                        return game.getPlayer().use(i);
                    }
                }
            }
            if(parts.length == 1)
            {
                return wantMoreCommand("use");
            }
        }
        if(parts[0].equalsIgnoreCase("take"))
        {
            if (parts.length > 1)
            {
                for(Item i : character.getInventory())
                {
                    if(i.getName().equalsIgnoreCase(input))
                    {
                        return game.getPlayer().take(i);
                    }
                }
            }
            if(parts.length == 1)
            {
                return wantMoreCommand("take");
            }
        }
        if(parts[0].equalsIgnoreCase("look"))
        {
            if (parts.length > 1)
            {
                switch( parts[1].charAt(0))
                {
                    case 'n' :case 'N':
                    return game.getPlayer().look(Direction.North);
                    //break;
                    case 'e':case 'E':
                    return game.getPlayer().look(Direction.East);
                    //break;
                    case 's':case 'S':
                    return game.getPlayer().look(Direction.South);
                    //break;
                    case 'w':case 'W':
                    return game.getPlayer().look(Direction.West);
                    //break;
                    default:
                        System.out.println( "invalid command");
                        analyze("look");
                }
            }
            if(parts.length == 1)
            {
                return wantMoreCommand("look");
            }
        }
        if(parts[0].equalsIgnoreCase("inspect"))
        {
            if (parts.length > 1)
            {
                for(Thing t : game.getPlayer().getCurrent().getThings())
                {
                    if (t.getName().equalsIgnoreCase(parts[1]))
                    {
                        return game.getPlayer().interact(t);
                    }
                }
            }
            if(parts.length == 1)
            {
                return wantMoreCommand("inspect");
            }
        }
        return "null";
    }
    public String wantMoreCommand(String lastCommand)
    {

        Player character = game.getPlayer();
        boolean found = false;

        Scanner scan = new Scanner(System.in);
        if(lastCommand.equalsIgnoreCase("go"))
        {
            System.out.println("go where? \nNorth \nEast \nSouth \nWest");
            String input = scan.nextLine();
            switch(input.charAt(0))
            {
                case 'n' :case 'N':
                return game.getPlayer().go(Direction.North);
                //break;
                case 'e':case 'E':
                return game.getPlayer().go(Direction.East);
                //break;
                case 's':case 'S':
                return game.getPlayer().go(Direction.South);
                //break;
                case 'w':case 'W':
                return game.getPlayer().go(Direction.West);
                //break;
                default:
                    System.out.println( "invalid command");
                    break;
            }
        }
        if(lastCommand.equalsIgnoreCase("interact"))
        {
            System.out.println("interact with what?");
            System.out.println(game.getPlayer().getCurrent().getThings());
            String input = scan.nextLine();
            for(Thing t : game.getPlayer().getCurrent().getThings())
            {
                if (t.getName().equalsIgnoreCase(input))
                {
                    found = true;
                    return game.getPlayer().interact(t);
                }
            }
            if(found = false)
                return "invalid command";

        }
        if(lastCommand.equalsIgnoreCase("attacktowhoandwithwhat"))
        {
            Location location = character.getCurrent();
            System.out.println("Attack to who and with what?");
            System.out.println(location.getCharacters());
            if(game.getPlayer().getInventory().size()==0)
                return "Your inventory is empty. To be able to attack you should have something in your inventory.";
            else
            {
                System.out.println(game.getPlayer().getInventory());
                String input = scan.nextLine();
                String[] parts = input.split(" ");
                for (Character c : location.getCharacters()) {
                    if (c.getName().equalsIgnoreCase(parts[0])) {
                        for (Item i : game.getPlayer().getInventory()) {
                            if (i.getName().equalsIgnoreCase(parts[0])) {
                                found = true;
                                return game.getPlayer().attack(c, i);
                            } else if (i.getName().equalsIgnoreCase(parts[2])) {
                                found = true;
                                return game.getPlayer().attack(c, i);
                            }
                        }

                    }
                }
            }
            if(found = false)
                return "invalid command";
        }
        if(lastCommand.equalsIgnoreCase("use"))
        {
            String input;
            if(character.getInventory().size()==0)
                return "Your inventory is empty. To be able to use something you should have something in your inventory.";
            else
            {
                System.out.println("use what?");
                System.out.println(character.getInventory());
                input = scan.nextLine();
            }
            for(Item i : character.getInventory())
            {
                if(i.getName().equalsIgnoreCase(input))
                {
                    found=true;
                    return game.getPlayer().use(i);
                }
            }

            if(found = false)
                return "invalid command";

        }
        if(lastCommand.equalsIgnoreCase("take"))
        {
            System.out.println("take what?");
            System.out.println(character.getInventory());
            String input = scan.nextLine();
            for(Item i : character.getInventory())
            {
                if(i.getName().equalsIgnoreCase(input))
                {
                    found = true;
                    return game.getPlayer().take(i);
                }
            }

            if(found = false)
                return "invalid command";

        }
        if(lastCommand.equalsIgnoreCase("look"))
        {
            System.out.println("look where?");
            System.out.println("North \nEast \nWest \nSouth");
            String input = scan.nextLine();
            switch( input.charAt(0))
            {
                case 'n' :case 'N':
                return game.getPlayer().look(Direction.North);
                //break;
                case 'e':case 'E':
                return game.getPlayer().look(Direction.East);
                //break;
                case 's':case 'S':
                return game.getPlayer().look(Direction.South);
                //break;
                case 'w':case 'W':
                return game.getPlayer().look(Direction.West);
                //break;
                default:
                    System.out.println( "invalid command");
                    break;
            }

        }
        if(lastCommand.equalsIgnoreCase("inspect"))
        {
            System.out.println("inspect what?");
            if(game.getPlayer().getCurrent().getThings().size()==0)
                return "There is nothing here that you can inspect.";
            else
            {
                System.out.println(game.getPlayer().getCurrent().getThings());
                String input = scan.nextLine();
                for(Thing t : game.getPlayer().getCurrent().getThings())
                {
                    if (t.getName().equalsIgnoreCase(input))
                    {
                        found = true;
                        return game.getPlayer().interact(t);
                    }
                }
                if(found = false)
                    return "invalid command";
            }

        }
        return null;

    }
}