package com.group1.game;
import com.group1.IOmanage.GameReader;
import com.group1.IOmanage.LoginReader;
import com.group1.IOmanage.Reader;
import com.group1.datamanage.User;
import com.group1.datamanage.UserManagement;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.io.*;
import java.util.Scanner;


import java.util.ArrayList;


/**
* Created by Fatih on 02/12/2014.
*/
public class GameSystem {
	public static final String EXIT = "exit";
	public static final String LOGOUT = "logout";
	private static GameSystem instance = null;
	protected GameSystem(){
		mng = UserManagement.getInstance();
		read = new Scanner(System.in);
		reader = LoginReader.getInstance(this);
	}
	public static GameSystem getInstance(){
		if( instance == null){
			instance = new GameSystem();
		}
		return instance;
	}
	private Player player;
	private Game game;
	private Reader reader;
	private UserManagement mng;
	private User user;

	public UserManagement getMng() {
		return mng;
	}

	private Map map;
	private Scanner read;
	
	private void startGame(Player player,Game game){
		this.player = player;
		game = new Game( player);
		reader = GameReader.getInstance(game);
		System.out.println(player.getCurrent().getMessage());
	}
	public boolean login(String name, String pass){
		if(mng.checkIDPassword(name,pass)){
			user = mng.getUser(name);
			generateGame( user);
			return true;
		}
		return false;

	}

	public void saveGame(){
		XStream xstream = new XStream(new StaxDriver());
		File userfile = new File("Data//Users//SaveGames//" + user.getUsername() +".xml");
		Writer writer;
		try {
			if(!userfile.exists()){
				writer = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream("Data//Users//SaveGames//" + user.getUsername() +".xml"), "utf-8"));
				writer.write("");
			}

			xstream.toXML(game, new FileWriter( new File("Data//Users//SaveGames//" + user.getUsername() +".xml")));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	private void generateGame(User user) {
		boolean fileExists = true;
		XStream xstream = new XStream(new StaxDriver());
		String 	data = user.getData();
		FileWriter userFile = null;
		File userfile =new File("Data//Users//SaveGames//" + user.getUsername() +".xml");

		if( !userfile.exists()){
			//Generate Game According to Default Settings
			player = new Player(user.getUsername(),new ArrayList<Item>(),Map.SIZE/2,Map.SIZE/2);
			player.setSeed(new Integer((int) (Math.random() * 1000)).toString());
			game = new Game( player);
			game.setAll();
			map = new Map( game,Map.SIZE);
			game.setMap(map);
			player.setMap(map);
		}else{
			//Generate Game According to data

			game = (Game) xstream.fromXML(new File("Data//Users//SaveGames//" + user.getUsername() +".xml"));
			player = game.getPlayer();
		}
		startGame(player,game);

	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public void run(){

		String input = read.nextLine();
		while( !input.equalsIgnoreCase(EXIT)){
			if(input.equalsIgnoreCase(LOGOUT))
			{
				reader = LoginReader.getInstance(this);
			}
			System.out.println(reader.analyze( input));
			if(reader instanceof GameReader)
				System.out.println(game.getPlayer().getCurrent().getMessage());

			input = read.nextLine();

		}


	}
}