

package main;

import game.*;

public class Main {
	
	public static void main(String[] args) {
		Game jeuA = new AgriculturalGame(10,10);
		Game jeuM = new MilitaryGame(10,10);
		for(int i =0; i<args.length;i++) {
			jeuA.addPlayer(new Player(args[i],15));
			jeuM.addPlayer(new Player(args[i],15));
		}
		jeuA.play();
	}
}