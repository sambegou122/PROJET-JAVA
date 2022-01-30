package caracter;
import board.*;
import main.Player;

public class Warrior extends Personnage {
	
	public Warrior(int PO, Tile Position, Player p) {
		super(PO, Position, p);
	}
	
	public int pay() {
		return this.Position.getType().foodNeeded();
	}


}
