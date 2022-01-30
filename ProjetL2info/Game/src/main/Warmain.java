package main;

import game.*;

public class Warmain {
	
	public static void main(String[] args) {
		
		Game jeuM = new MilitaryGame(10,10);
		for(int i =0; i<args.length;i++) {
			jeuM.addPlayer(new Player(args[i],15));
		}
		jeuM.play();
	}
}

