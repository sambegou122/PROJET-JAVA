/**
 * 
 */
package board;

import caracter.*;

/**
 * @author max
 *
 */
public class Tile {

	
	/**
	 * Attributes
	 */
	
	protected Personnage personnage;
	protected int capacity;
	protected Army army;
	protected TileType type;
	protected int positionX;
	protected int positionY;
	
	
	/**
	 * Constructor
	 * @param t Tile type
	 * @param x position x
	 * @param y position y
	 */
	public Tile(TileType t, int x ,int y) {
		this.type=t;
		this.positionX=x;
		this.positionY=y;
		this.capacity=t.capacity();
	}
	
	/**
	 * get the character on the tile.
	 * @return Personnage the character
	 */
	public Personnage getCaracter() {
		return this.personnage;
	}
	
	/**
	 * get Tile's capacity
	 * @return capacity
	 */
	public int getCapacity() {
		return this.capacity;
	}
	
	/**
	 * get Tile's position x
	 * @return position x
	 */
	public int getPositionX() {
		return this.positionX;
	}
	
	/**
	 * get Tile's position y
	 * @return position y
	 */
	public int getPositionY() {
		return this.positionY;
	}
	
	/**
	 * get the army on the tile.
	 * @return army
	 */
	public Army getArmy() {
		return this.army;
	}
	
	/**
	 * get the Tile type
	 * @return Tile type
	 */
	public TileType getType() {
		return this.type;
	}
	
	/**
	 * set the character on tile given n in parameter
	 * @param p the character
	 */
	public void setCaracter(Personnage p) {
		this.personnage=p;
	}
	
	/**
	 * set Tile's capacity with n given in parameter
	 * @param n new capacity
	 */
	public void setCapacity(int n) {
		this.capacity=n;
	}
	
	/**
	 * set Army on the Tile
	 * @param a the army
	 */
	public void setArmy(Army a) {
		this.army=a;
	}
}
