package game;

import java.util.*;
import main.Player;
import board.*;

public abstract class Game {

	/*
	 * Attributes
	 */
	protected List<Player> Players;
	protected Board board;
	
	

	/**
	 * Create a game with a board with a width and height given in parameter and create an Array list for player
	 * @param width Width of the board
	 * @param height Height of the board
	 */
	public Game(int width,int height) {
		this.board = new Board(width,height);
		this.Players = new ArrayList<Player>();
	}


	/**
	 * @param i
	 * @return
	 */
	public Player getPlayer(int i) {
		return Players.get(i);
	}

	/**
	 * @param p
	 */
	public void addPlayer(Player p) {
		Players.add(p);
	}

	/**
	 * @return
	 */
	public Board getBoard() {
		return board;
	}
	
	/**
	 * The function start a game check the documentation of the other game to know what the function is doing
	 */
	public void play() {}
	
	/**
	 * @return
	 */
	public String choix() {
		Random r = new Random();
		String[] choice = {"rien","recolte","poser"};
		return choice[r.nextInt(3)];
	}
	
	/***
	 * Check the documentation of the game you want to know what the function is doing especially
	 * @param p Player who put a unit
	 */
	public void pose(Player p) {}
	
	

	
	/**
	 * Check the documentation of the game you want to know what the function is doing especially
	 * @param p Player who has to feed his army
	 * @return boolean is the army is fed
	 */
	public boolean nourrir(Player p) {
		return true;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
