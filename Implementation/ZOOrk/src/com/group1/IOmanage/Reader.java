package com.group1.IOmanage;
import java.util.Scanner;

import com.group1.game.Direction;
import com.group1.game.Game;
import com.group1.game.Location;
import com.group1.game.Thing;
import com.group1.game.Item;
import com.group1.game.Character;

/**
* Created by Fatih on 02/12/2014.
*/
public class Reader 
{
	private static Reader instance = null;
	protected Reader(Game game)
	{
		this.game = game;
	}
	public static Reader getInstance(Game game) 
	{
		if(instance == null) 
        		instance = new Reader(game);
		
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

		Character character = null;
		String[] parts = input.split( " ");
		if(parts[0].equalsIgnoreCase("go"))
		{
			if (parts.length > 1)
			{
				switch( parts[1].charAt(0))
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
						analyze("go");
						
			   }
			if (parts.length == 1)
				return wantMoreCommand("go");
			}		
	    }
		if(parts[0].equalsIgnoreCase("interact"))
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
				return wantMoreCommand("interact");
			}
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
					if(i.getName().equalsIgnoreCase(parts[1]))
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

		Character character = null;

		Scanner scan = new Scanner(System.in);
		if(lastCommand.equalsIgnoreCase("go"))
		{
			System.out.println("go where?");
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
			String input = scan.nextLine();
			for(Thing t : game.getPlayer().getCurrent().getThings())
			{
				if (t.getName().equalsIgnoreCase(input))
				{
					return game.getPlayer().interact(t);
				}
			}
		}
		if(lastCommand.equalsIgnoreCase("use"))
		{
			System.out.println("use what?");
			String input = scan.nextLine();
			for(Item i : character.getInventory())
			{
				if(i.getName().equalsIgnoreCase(input))
				{
					return game.getPlayer().use(i);
				}
			}
			
		}
		if(lastCommand.equalsIgnoreCase("take"))
		{
			System.out.println("take what?");
			String input = scan.nextLine();
			for(Item i : character.getInventory())
			{
				if(i.getName().equalsIgnoreCase(input))
				{
					return game.getPlayer().take(i);
				}
			}
			
		}
		if(lastCommand.equalsIgnoreCase("look"))
		{
			System.out.println("look where?");
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
			String input = scan.nextLine();
			for(Thing t : game.getPlayer().getCurrent().getThings())
			{
				if (t.getName().equalsIgnoreCase(input))
				{
					return game.getPlayer().interact(t);
				}
			}
		}
		
		return "null";
	}
}
