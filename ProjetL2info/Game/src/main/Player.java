
package main;
import caracter.*;
import java.util.*;

/**
 * @author 
 *
 */
public class Player{
	
	/**
	 * Attributes
	 */
	private int nbWarriors;
	private int po;
	private int food;
	private List<Worker> caracteres;
	private List<Army> armys;
	private String nom;
	
	
	/**
	 * Create a player with the name and starting gold in parameter
	 * The player as initially 35 Warriors
	 * @param Nom
	 * @param startingGold
	 */
	public Player(String Nom, int startingGold) {
		this.po = startingGold;
		this.food = 10;
		this.nbWarriors = 35;
		this.caracteres = new ArrayList<Worker>();
		this.armys = new ArrayList<Army>();
		this.nom = Nom;
	}
	
	/**
	 * @return value of number Warriors
	 */
	public int getNbWarriors() {
		return this.nbWarriors;
	}


	/**
	 * set new value of number Warriors
	 * @param nbWarriors
	 */
	public void setNbWarriors(int nbWarriors) {
		this.nbWarriors = nbWarriors;
	}


	/**
	 * @return value of gold coin
	 */
	public int getPo() {
		return this.po;
	}


	/**
	 * set the new value of gold coin
	 * @param po
	 */
	public void setPo(int po) {
		this.po = po;
	}


	/**
	 * @return remaining food
	 */
	public int getFood() {
		return this.food;
	}


	/**
	 * set the remaining food 
	 * @param food 
	 */
	public void setFood(int food) {
		this.food = food;
	}


	/**
	 * @return Player's name
	 */
	public String getNom() {
		return this.nom;
	}


	/**
	 * Set a new name
	 * @param nom name of the player
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @param i index
	 * @return get the army at the index i
	 */
	public Army getArmy(int i) {
		return this.armys.get(i);
	}
	
	/**
	 * @param a add an army on the list
	 */
	public void addArmy(Army a) {
		a.setPlayer(this);
		this.armys.add(a);
	}
	
	/**
	 * @param i index of the list
	 * @return the worker at the index i
	 */
	public Personnage getCaractere(int i) {
		return this.caracteres.get(i);
	}
	
	/**
	 * @return list of workers
	 */
	public List<Worker> getCaracteres(){
		return this.caracteres;
	}
	
	/**
	 * set a new list of workers
	 * @param newWorkers
	 */
	public void setCaracteres(List<Worker> newWorkers) {
		this.caracteres = newWorkers;
	}
	
	/**
	 * add a Worker in the list.
	 * @param p worker
	 */
	public void setCaractere(Worker p) {
		p.setPlayer(this);
		this.caracteres.add(p);
	}
	
	/**
	 * @return Army list of the Player
	 */
	public List<Army> getArmys(){
		return this.armys;
	}
	
	/**
	 * Set a new army
	 * @param A the new army
	 */
	public void setArmys(List<Army> A){
		this.armys = A;
	}
	
	/**
	 * Check if the object is equals to the Player. 
	 * To check if they are equals they have the same name and same numbers of Warriors
	 * @param o Object
	 * @return boolean true they are equals, false else
	 */
	public boolean equals(Object o) {
		if(o instanceof Player) {
			Player other = (Player) o;
			if(other.getNom().equals(this.nom) && this.nbWarriors == other.getNbWarriors()) {
				return true;
			}
		}
		return false;
	}
	

	
	/**
	 * @return boolean true if the army are fed
	 */
	public boolean nourrir(Army a) {
		if(a.pay()>this.food) {
			System.out.println("Une armée n'a pas été nourri");
			return false;	
		}
		else {
			this.food=this.food-a.pay();
			System.out.println(this.food+" nourriture restante.");
			return true;
		}
		
	}

	
	
	
	
	
}