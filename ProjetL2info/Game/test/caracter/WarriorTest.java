package caracter;
import board.*;
import main.Player;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class WarriorTest {
	
	private Tile Position;
	private Tile Position2;
	private Warrior Personne;
	private Player p;
	
	
	@Before
	public void before() {
		this.Position=new Tile(TileType.FORET,10,10);
		this.Position2 = new Tile (TileType.DESERT ,11 ,11);
		this.p = new Player("Test", 35);
		this.Personne = new Warrior(15 , Position, this.p );
		
		
	}

	@Test
	public void testGetPosition() {
		assertSame(this.Personne.getPosition(), this.Position);
	}
	
	@Test
	public void testSetPosition() {
		this.Personne.setPosition(this.Position2);
		assertSame(this.Personne.getPosition(), this.Position2);
		
		
	}
	
	@Test
	public void testGetPO() {
		assertTrue(this.Personne.getPO() == 15);
		
		
	}
	
	@Test
	public void testSetPO() {
		this.Personne.setPO(20);
		assertTrue(this.Personne.getPO() == 20);
		
		
	}
	
	@Test
	public void testPay() {
		assertTrue(this.Personne.pay() == 1);
		
		
	}
}