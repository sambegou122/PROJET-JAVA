package caracter;
import board.*;
import main.Player;

public class Worker extends Personnage {
	
	protected int resource;
	
	public Worker(int PO, Tile position, Player p) {
		super(PO, position, p);
		this.resource=0;
	}
	
	/**
	 * The worker will trade the number of resources for gold the resource is depending in which Tile type he is
	 * @return the gold earn
	 */
	public int work() {
		int n =  this.resource*this.Position.getType().nbPO();
		this.resource=0;
		return n;
	}
	
	/**
	 * Up the number of resources by 1
	 */
	public void farm() {
		this.resource+=1;
	}
	
	
	/**
	 * @return number of resource
	 */
	public int getResource() {
		return this.resource;
	}
	
	
}	
	