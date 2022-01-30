/**
 * 
 */
package caracter;
import board.*;
import main.Player;
import java.util.*;
/**
 * @author max
 *
 */
public class Army {
	/** 
	 * Attributes
	 * */
	
	protected List<Warrior> warriors;
	protected int taille;
	protected Tile Posi;
	protected int PO;
	protected Player player;
	
	/** 
	 * the constructor
	 * @param Posi Army's position
	 * @param t Army's number
	 * @param p Player
	 * */
	
	public Army(Tile Posi ,int t, Player p) {
		this.warriors = new ArrayList<Warrior>();
		this.taille =t;
		this.Posi = Posi;
		this.PO = 0;
		this.player=p;
		for(int i = 0; i<t;i++){
		     Warrior w = new Warrior(0,Posi,p);
		     this.warriors.add(w);
		}
	}
	


	/** 
	 * get Army's position
	 * @return the position
	 * */
	public Tile getPosi() {
		return this.Posi;
	}
	
	/** 
	 * set Army's position
	 * @param newPosi
	 */
	public void setPosi(Tile newPosi) {
		this.Posi = newPosi;
	}
	
	/** 
	 * get Army's number
	 * @return number
	 * */
	public int getTaille() {
		return this.taille;
	}
	
	/** 
	 * set Army's number
	 * @param n
	 */
	public void setTaille(int n) {
		if(n<=5) {
			this.taille = n;
			
		}
		
	}
	
	
	/** 
	 * add warrior w in Army
	 * */
	public void addWarrior(Warrior w) {
		if(this.taille < this.Posi.getCapacity() && this.taille<5) {
			this.warriors.add(w);
			w.setPosition(this.getPosi());
			this.taille+=1;
				
			
		}
		
	}
	
	/** 
	 * get Army's warriors
	 * @param i index
	 * @return warrior at index i
	 * */
	public Warrior getWarrior(int i){
		return this.warriors.get(i);
	}
	
	
	
	/** 
	 * get Army's PO
	 * @return PO
	 * */
	public int getPO() {
		return this.PO;
	}
	
	/**
	 * change Army's PO
	 * @param p
	 */
	public void setPO(int p) {
		this.PO = p;
	}
	
	
	/**
	 * increase the number of PO;
	 * @param npo
	 */
	public void addPO(int npo) {
		this.PO = this.PO + npo;
	}
	
	/**
	 * @return the Player of Army
	 */
	public Player getPlayer() {
		return this.player;
	}
	
	/**
	 * @param p The new Player
	 * change the Player of Army
	 */
	public void setPlayer(Player p) {
		this.player=p;
	}
	
	/**
	 * harvest food
	 */
	public int work(){
		return this.Posi.getType().givingFood();
	}
	
	
	/**
	 * 
	 * @return the number of food require to feed army
	 */
	public int pay() {
		int i = 0;
		
		for(Warrior w : this.warriors) {
			i+=w.pay();
					
		}
		return i;
		
			
	}


	
	/**
	 * @return List of the warriors
	 */
	public List<Warrior> getWarriors() {
		return this.warriors;
	}



	/**
	 * @param warriors The list of warriors
	 * set the of warriors of army
	 */
	public void setWarriors(List<Warrior> warriors) {
		this.warriors = warriors;
	}
	

}
