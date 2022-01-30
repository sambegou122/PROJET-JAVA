package board;
import caracter.*;
import main.Player;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TileTest {
	
	private Tile tileForet;
	private Tile tileMontagne;
	private Tile tileDesert;
	private Tile tileOcean;
	private Tile tilePlaine;
	private Army Armee;
	private Personnage worker;
	private Player p;
	
	@Before
	public void before() {
		this.tileForet=new Tile(TileType.FORET,10,10);
		this.tileMontagne=new Tile(TileType.MONTAGNE,10,10);
		this.tileDesert=new Tile(TileType.DESERT,10,10);
		this.tileOcean=new Tile(TileType.OCEAN,10,10);
		this.tilePlaine=new Tile(TileType.PLAINE,10,10);
		this.p = new Player("Test", 35);
		this.Armee = new Army(this.tileForet, 4, this.p);
		this.worker= new Worker(10, this.tileMontagne, this.p);
		this.tileMontagne.setCaracter(this.worker);
		this.tileForet.setArmy(this.Armee);
	}

	@Test
	public void testGetPositionX() {
		assertTrue(this.tileDesert.getPositionX()==10);
	}
	
	@Test
	public void testGetPositionY() {
		assertTrue(this.tileDesert.getPositionY()==10);
	}
	
	@Test
	public void testGetCapacity() {
		assertTrue(this.tileDesert.getCapacity()==3);
		assertTrue(this.tileMontagne.getCapacity()==3);
		assertTrue(this.tileOcean.getCapacity()==0);
		assertTrue(this.tileForet.getCapacity()==5);
		assertTrue(this.tilePlaine.getCapacity()==5);
	}
	
	
	@Test
	public void testGetArmyAndGetPersonnage() {
		assertSame(this.Armee,this.tileForet.getArmy());
		assertSame(this.worker, this.tileMontagne.getCaracter());
	}
	
	
	@Test
	public void testGetType() {
		assertTrue(this.tileDesert.getType()==TileType.DESERT);
		assertTrue(this.tileMontagne.getType()==TileType.MONTAGNE);
		assertTrue(this.tileOcean.getType()==TileType.OCEAN);
		assertTrue(this.tileForet.getType()==TileType.FORET);
		assertTrue(this.tilePlaine.getType()==TileType.PLAINE);
	}
	
	@Test
	public void testSetCapacity() {
		this.tileOcean.setCapacity(5);
		assertTrue(this.tileOcean.getCapacity()==5);
	}
	
	@Test
	public void testSetArmy() {
		this.tilePlaine.setArmy(this.Armee);
		assertSame(this.tilePlaine.getArmy(),this.Armee);
	}
	
	@Test
	public void testSetCaracter() {
		this.tilePlaine.setCaracter(this.worker);
		assertSame(this.tilePlaine.getCaracter(),this.worker);
	}

}
