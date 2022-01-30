package game;

import java.util.*;

import board.*;
import main.Player;
import caracter.*;

public class AgriculturalGame extends Game{
	
	
	public AgriculturalGame(int width, int height) {
		super(width,height);
	}
	
	
	/**
	 * The function start an Agricultural Game
	 * The game is playing in 6 turn or if every tile is taken the game stop
	 * The player with the most money win the game.
	 * Every ending turn you have to pay your worker you put on the board.
	 * The coast is depending on the TileType you are for instance a Tile Type MONTAGNE coast 5 gold
	 */
	public void play() {
		int turn = 0;
		System.out.println("Voici à quoi ressemble la carte pour cette partie");
		this.board.printBoard();
		while(turn<6 && this.board.getDispo().size()!=0) {
			System.out.println("Tour : "+(turn+1));
			for(Player p : this.Players) {
				System.out.println(p.getNom()+" commence son tour");
				String choice = super.choix();
				if(choice.equals("poser")) {
					pose(p);
					if(this.board.getDispo().size()==0) {
						break;
					}
				}
				else if(choice.equals("recolte")) {
					recolt(p);
				}
				else {
					System.out.println(p.getNom()+" décide ne rien faire.");
				}
				List<Worker> workers = p.getCaracteres();
				List<Worker> newWorkers= new ArrayList<Worker>();
				for(Worker worker : workers) {
					if(worker.pay()>p.getPo()) {
						System.out.println(p.getNom()+" ne peut plus payer son ouvrier de ce fait il perd le territoire.");
						worker.getPosition().setCaracter(null);
						this.board.getDispo().add(worker.getPosition());
					}
					else {
						newWorkers.add(worker);
						System.out.println(p.getNom()+" paye pour un montant de "+worker.pay()+" pièce d'or.");
						p.setPo(p.getPo()-worker.pay());
						worker.farm();
						if(worker.getPosition().getType()==TileType.FORET || worker.getPosition().getType()==TileType.PLAINE) {
							System.out.println(p.getNom()+" reçoit une pièce d'or.");
							p.setPo(p.getPo()+1);
						}
						else if(worker.getPosition().getType()==TileType.DESERT) {
							System.out.println(p.getNom()+" reçoit deux pièces d'or.");
							p.setPo(p.getPo()+2);
						}
					}
				}
				System.out.println(p.getNom()+" termine son tour.");
				p.setCaracteres(newWorkers);
			}
			turn++;
		}
		win();
	}
	
	/**
	 * @param p the player will put a worker
	 * Put a worker in the available Tile
	 */
	public void pose(Player p) {
		int size = this.board.getDispo().size();
		Random r = new Random();
		Tile choisi = this.board.getDispo().get(r.nextInt(size));
		Worker worker = new Worker(0,choisi,p);
		p.setCaractere(worker);
		this.board.getDispo().remove(choisi);
		System.out.println(p.getNom()+" a posé un ouvrier à la case de coordonnée "+choisi.getPositionX()+" en x et "+choisi.getPositionY()+" en y.");
	}
	
	/**
	 * Worker's Player is trading his recolt for gold
	 * Depending what he is trading for instance rock value is 8
	 * @param p Player
	 */
	public void recolt(Player p) {
		List<Worker> workers = p.getCaracteres();
		for(Worker w: workers) {
			int n = w.work();
			System.out.println(p.getNom()+" a gagné "+n+" PO.");
			p.setPo(p.getPo()+n);
		}
	}
	
	
	/**
	 * The function give the name of the winner
	 */
	public void win() {
		int riche = 0;
		Player gagnant = new Player("gagnant",10);
		for(Player p: this.Players) {
			List<Worker> workers = p.getCaracteres();
			int n = 0;
			for(Worker w: workers) {
				n += w.getPO();
			}
			if(riche<n) {
				riche = n;
				gagnant = p;
			}
		}
		System.out.println("Le gagnant est "+gagnant.getNom()+" avec une richesse de "+riche+".");
	}
}
