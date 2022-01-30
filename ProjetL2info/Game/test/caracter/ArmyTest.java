package caracter;
import board.*;
import main.Player;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ArmyTest {
	
	private Tile tileForet;
	private Tile tileMontagne;
	private Warrior guerrier1;
	private Warrior guerrier2;
	private Army Armee;
	private Player p;
	
	
	@Before
	public void before() {
		this.tileForet=new Tile(TileType.FORET,10,10);
		this.tileMontagne=new Tile(TileType.MONTAGNE,10,10);
		this.p = new Player("Test", 35);
		this.guerrier1=new Warrior(10, this.tileForet, this.p);
		this.guerrier2=new Warrior(10, this.tileMontagne, this.p);
		this.Armee = new Army(this.tileForet, 4, this.p);
		
	}
	
	@Test
	public void testGetAndSetTaille() {
		assertTrue(this.Armee.getTaille()==4);
		this.Armee.setTaille(10);
		assertFalse(this.Armee.getTaille() == 10);
		this.Armee.setTaille(5);
		assertTrue(this.Armee.getTaille()==5);
	}
	
	@Test
	public void testGetAndSetPOAndAddPO() {
		assertTrue(this.Armee.getPO()==0);
		this.Armee.setPO(10);
		assertTrue(this.Armee.getPO()==10);
		this.Armee.addPO(4);
		assertTrue(this.Armee.getPO()==14);
	}
	
	@Test
	public void testGetAndSetPosi() {
		assertSame(this.Armee.getPosi(), this.tileForet);
		this.Armee.setPosi(this.tileMontagne);
		assertSame(this.Armee.getPosi(), this.tileMontagne);
	}
	
	@Test
	public void testAddWarriors_GetAndSetWarriors() {
		assertTrue(this.Armee.getWarriors().size()==4);
		this.Armee.addWarrior(this.guerrier1);
		assertTrue(this.Armee.getTaille() == 5);
		assertTrue(this.Armee.getWarriors().size()==5);
		assertTrue(this.Armee.getWarriors().contains(this.guerrier1));
		assertSame(this.Armee.getWarrior(4), this.guerrier1);
		//we can't add a new warrior because the size of of the warriors is limited to 5
		assertFalse(this.Armee.getTaille() == 6);
		assertFalse(this.Armee.getWarriors().size()==6);
		assertFalse(this.Armee.getWarriors().contains(this.guerrier2));
		
	}
	
	@Test
	public void testGetAndSetPlayer() {
		assertSame(this.Armee.getPlayer(), this.p);
		Player Z = new Player("test2",35);
		this.Armee.setPlayer(Z);
		assertSame(this.Armee.getPlayer(), Z);
	}
	
	@Test
	public void testWorkAndSetPay() {
		assertTrue(this.Armee.work()==2);
		assertTrue(this.Armee.pay()==4);
	}
	
	
	
	

}