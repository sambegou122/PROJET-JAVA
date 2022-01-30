package caracter;
import board.*;
import main.Player;

public abstract class Personnage {
	
	
	/**
	 * Attributes
	 */
	protected int PO;
	protected Tile Position;
	protected Player player;
	
	/**
	 * constructor
	 * @param PO Personnage's PO 
	 * @param position Personnage's Position
	 * @param p Player
	 */
	public Personnage(int PO, Tile position, Player p) {
		this.PO = PO;
		this.Position = position;
		this.player=p;
	}
	
	
	/**
	 * get Personnage's Position
	 * @return position
	 */
	public Tile getPosition() {
		return this.Position;
	}
	
	
	/**
	 * set Personnage's Position
	 */
	public void setPosition(Tile newPosition) {
		this.Position = newPosition;

	}
	
	/**
	 * get Personnage's PO
	 * @return PO
	 */
	public int getPO() {
		return this.PO;
	}
	
	/**
	 * set Personnage's PO with newPo
	 */
	public void setPO(int newPo) {
		this.PO = newPo;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public void setPlayer(Player p) {
		this.player=p;
	}
	
	public int pay() {
		this.PO += this.Position.getType().givingPO();
		return this.Position.getType().givingPO();
	}



}
