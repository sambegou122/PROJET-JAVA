package game;

import java.util.*;
import caracter.*;
import main.Player;
import board.*;

public class MilitaryGame extends Game{
	
	public MilitaryGame(int width, int height) {
		super(width,height);
	}
	
	public String choix() {
		Random r = new Random();
		String[] choice = {"rien","poser"};
		return choice[r.nextInt(2)];
		
	}

	

	
	/**
	 * @param a represents the ally tile if it belongs to the same player as the deputy tile
	 * @param dep represents the tile deployed by the player
	 * type :  void function
	 * 
	 * • if an enemy army is strictly smaller in size than the deployed army, its size is reduced by half, if the
			number of warriors is less than 1 the active player becomes the owner of the tile, the army which occupied
			the territory rallies to its cause (however, we do not apply the rule for recalculating armies, it is not to
			strictly speaking a deployment) and the deployed army earns 2 gold coins;
			• if an allied army (a player's army) is strictly smaller than the deployed army, its size increases
			of a unit (it therefore gains a warrior, always within the limit of 5 warriors) and the deployed army gains a
			gold coin ;
			• if an army is of a size greater than or equal to the deployed army, it is not affected, whether enemy or
			ally;
			• if there is no army, nothing happens
				 */
	public void action(Tile a , Tile dep) {
		
		if(a.getArmy().getPlayer().equals(dep.getArmy().getPlayer())) {
			System.out.println("La tuile " + a.getType() + " appartient au même joueur "+ a.getArmy().getPlayer().getNom());
			
			if(a.getArmy().getTaille()<dep.getArmy().getTaille()) {
				System.out.println("L'armée deployée est supérieure à l'armée de la tuille  ");
				if(a.getArmy().getTaille()<5) {
					Warrior g = new Warrior(0, a , a.getArmy().getPlayer());
					a.getArmy().addWarrior(g);
					
					System.out.println("L'armée du joueur " +a.getArmy().getPlayer().getNom() + " gagne un guerrier. ");
					
				}
				
				dep.getArmy().setPO(dep.getArmy().getPO() +1 );
				
				System.out.println("Son nombre de pièces d'or augmente de 1 et son nombre de pieces d'or est  " + dep.getArmy().getPO());
				
			}
			
			
		}
		else {
			
			if(a.getArmy().getTaille() + a.getType().power()<dep.getArmy().getTaille() + dep.getType().power()) {
				System.out.println("La taille de l'armée deployée appartenant au joueur " 
			+ dep.getArmy().getPlayer().getNom() + " est supérieur à celle de l'armée ennemi qui est celui du joueur "+
			a.getArmy().getPlayer().getNom());
				a.getArmy().setTaille((a.getArmy().getTaille())/2);
				System.out.println("La taille de l'armée ennemi diminue de moitié ");
				if(a.getArmy().getTaille()<1) {
					a.getArmy().setPlayer(dep.getArmy().getPlayer());
					System.out.println("L'armée ennemi a perdu son territoire ");
	
				}
				
			}
		}
		System.out.println("L'armée deployée est inférieure à l'armée de la tuille donc rien ne se passe. ");
			
		
		
	}

	
	
	/**
	 * @param P represent a player 
	 * a player transform the resources of the tile occupied by his army
	 */
	public void transforme(Player P) {
		
		int ressource =0;
		for (Army a : P.getArmys()) {
			ressource = ressource + a.work() ;
			P.setFood(P.getFood()+ ressource) ;
		}
		
		
		
	}
	
	
	/**
	 *@param P represent a player 
	 *this function choise a random free tile and verified around the player and do action 
	 */
	public void pose(Player P) {
		int size = this.board.getDispo().size();
		Random r = new Random();
		Tile choisi = this.board.getDispo().get(r.nextInt(size));
		int b = r.nextInt(choisi.getCapacity())+1;
		if(P.getNbWarriors()>=b) {
			Army arme = new Army(choisi,b, P);
			P.addArmy(arme);
			P.setNbWarriors(P.getNbWarriors()-b) ;
			choisi.setArmy(arme);
			System.out.println(P.getNom()+" a deployé son armée dans la tuile "  +choisi.getType() 
			+ " au cordonnée " + choisi.getPositionX() +" "+choisi.getPositionY());
			if(choisi.getPositionX() >0 ) {
				int x = choisi.getPositionX();
				int y = choisi.getPositionY();
				Tile GAUCHE = this.board.getTile(x-1, y);
				System.out.println(P.getNom()+" vérifie à sa gauche ");
				if(GAUCHE.getCapacity()>0 && GAUCHE.getArmy()!=null) {
					action(GAUCHE, choisi);
				}
				else {
					if(GAUCHE.getType()!=TileType.OCEAN) {
						System.out.println(" La tuile de Gauche n'est pas occupée ");
						
					}
					else {
						System.out.println(" La tuile de Gauche est de type OCEAN ");
						
					}
					
					
					
				}
			}
			if(choisi.getPositionX() < this.board.getWidth()-1 ) {
				int x = choisi.getPositionX();
				int y = choisi.getPositionY();
				Tile DROITE = this.board.getTile(x+1, y);
				System.out.println(P.getNom()+" vérifie à sa Droite ");
				if(DROITE.getCapacity()>0 && DROITE.getArmy()!=null) {
					action(DROITE, choisi);
				}
				else {
					if(DROITE.getType()!=TileType.OCEAN) {
						System.out.println(" La tuile de Droite n'est pas occupée ");
						
					}
					else {
						System.out.println(" La tuile de Droite est type OCEAN ");
						
					}
					
					
				}
			}
			if(choisi.getPositionY() >0) {
				int x = choisi.getPositionX();
				int y = choisi.getPositionY();
				Tile HAUT = this.board.getTile(x, y-1);
				System.out.println(P.getNom()+" vérifie en Haut ");
				if(HAUT.getCapacity()>0 && HAUT.getArmy()!=null) {
					action(HAUT, choisi);
				}
				else {
					
					if(HAUT.getType()!=TileType.OCEAN) {
						System.out.println(" La tuile d'en Haut n'est pas occupée ");
						
					}
					else {
						System.out.println(" La tuile d'en Haut est de type OCEAN ");
						
					}
					
					
				}
			}
			if(choisi.getPositionY() <this.board.getWidth()-1) {
				int x = choisi.getPositionX();
				int y = choisi.getPositionY();
				Tile BAS = this.board.getTile(x, y+1);
				System.out.println(P.getNom()+" vérifie en Bas ");
				if(BAS.getCapacity()>0 && BAS.getArmy()!=null) {
					action(BAS, choisi);
				}
				else {
					if(BAS.getType()!=TileType.OCEAN) {
						System.out.println(" La tuile d'en Bas n'est pas occupée ");
						
					}
					else {
						System.out.println(" La tuile d'en bas est de type OCEAN ");
						
					}
					
					
				}
			}
			this.board.getDispo().remove(choisi);
			
			
			
			
		}
		
		
		
	}
	
	
	
	/**
	 * this function 
	 */
	public void win() {
		int riche = 0;
		int bonus = 0;
		Player gagnant = new Player("gagnant",10);
		for(Player p: this.Players) {
			List<Army> myArmy = p.getArmys();
			int n = 0;
			for(Army w: myArmy) {
				bonus = w.getPosi().getType().bonus();
				n += w.getPO() +bonus + p.getPo();
				if(p.getArmys().size()>=10) {
					n+=5;
					
				}
			}
			if(riche<n) {
				riche = n;
				gagnant.setNom(p.getNom());
			}
			
		}
		if(gagnant.getNom().equals("gagnant")){
			System.out.println("Aucun d'entre eux n'as gagné ");
			
		}
		else {
			System.out.println("Le gagnant est "+gagnant.getNom()+" avec un nombre de point de "+riche+".");
			
		}
		
	}
	

	
	
	public void play() {
		int tour =0;
		System.out.println("Voici la table de jeux");
		this.board.printBoard();
		while(tour<10 && this.board.getDispo().size()>0) {
			System.out.println("TOUR : " +(tour+1));
			
			for(Player P : this.Players) {
				
				String c = choix();
			
				if(c.equals("poser") && this.board.getDispo().size()>0) {
					pose(P);
				}
				else {
					System.out.println(P.getNom() +" choisi de rien faire");
				}
				
				transforme(P);
				if(nourrir(P)) {
					System.out.println(P.getNom() +" a nourri ces guerriers.");
					
				}
				else {
					System.out.println(P.getNom() +" n'a pas réussi à nourir tous ces guerriers.");
				}
				
				
			}
			tour +=1 ;
			
			
		}
		win();
	}
	
	public boolean nourrir(Player p) {
		List<Army> newArmy = new ArrayList<Army>();
		List<Army> A = p.getArmys();
		for(Army a: A) {
			if(p.nourrir(a)) {
				newArmy.add(a);
			}
			else {
				p.setPo(p.getPo()+1);
				this.board.getDispo().add(a.getPosi());
				a.setPlayer(null);
				a.getPosi().setArmy(null);
				a.setPosi(null);
			}
		}
		p.setArmys(newArmy);
		return newArmy.size()==A.size();
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
}
