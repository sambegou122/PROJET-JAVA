package main;

import board.*;
import caracter.*;
import java.util.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class PlayerTest {
	private Player p1;
	private Player p2;
	
	@Before
	public void before() {
		this.p1 = new Player("test1",15);
		this.p2 = new Player("test2",15);
	}
	
	@Test
	public void getNbWarriorTest() {
		assertTrue(this.p1.getNbWarriors()==35);
	}
	
	@Test
	public void setNbWarriorTest() {
		this.p1.setNbWarriors(30);
		assertTrue(this.p1.getNbWarriors()==30);
	}
	
	@Test
	public void  getPoTest() {
		assertTrue(this.p1.getPo()==15);
	}
	
	@Test
	public void  setPoTest() {
		this.p1.setPo(10);
		assertTrue(this.p1.getPo()==10);
	}
	
	@Test
	public void getFoodTest() {
		assertTrue(this.p1.getFood()==10);
	}
	
	@Test
	public void setFoodTest() {
		this.p1.setFood(1);
		assertTrue(this.p1.getFood()==1);
	}
	
	
	@Test
	public void getNameTest() {
		assertEquals(this.p1.getNom(),"test1");
	}
	
	@Test
	public void setNameTest() {
		this.p1.setNom("test3");
		assertEquals(this.p1.getNom(),"test3");
	}
	
	@Test
	public void addArmyAndGetArmyTest() {
		Tile t = new Tile(TileType.MONTAGNE,0,0);
		Army a = new Army(t,3,this.p2);
		this.p1.addArmy(a);
		assertSame(a.getPlayer(),this.p1);
		assertSame(this.p1.getArmy(0),a);
	}
	
	@Test
	public void setCaractereAndGetCaractereTest() {
		Tile t = new Tile(TileType.MONTAGNE,0,0);
		Worker w = new Worker(10,t,this.p2);
		this.p1.setCaractere(w);
		assertSame(w.getPlayer(),this.p1);
		assertSame(this.p1.getCaractere(0),w);
	}
	
	@Test
	public void setArmysAndGetArmysTest() {
		Tile t = new Tile(TileType.MONTAGNE,0,0);
		Army a = new Army(t,3,this.p1);
		List<Army> newArmys = new ArrayList<Army>();
		newArmys.add(a);
		this.p1.setArmys(newArmys);
		assertSame(this.p1.getArmys(),newArmys);
	}
	
	@Test
	public void setCaracteresAndGetCaracteresTest() {
		Tile t = new Tile(TileType.MONTAGNE,0,0);
		Worker w = new Worker(10,t,this.p1);
		List<Worker> newWorkers = new ArrayList<Worker>();
		newWorkers.add(w);
		this.p1.setCaracteres(newWorkers);
		assertSame(this.p1.getCaracteres(),newWorkers);
	}
	
	@Test
	public void equalsTest() {
		assertFalse(this.p1.equals(this.p2));
		Player p3 = new Player("test1",15);
		assertTrue(this.p1.equals(p3));
	}
	
	@Test
	public void NourrirTest() {
		Tile t = new Tile(TileType.MONTAGNE,0,0);
		Army a = new Army(t,3,this.p1);
		this.p1.addArmy(a);
		assertTrue(this.p1.nourrir(a));
	}
	
	
	
	
	
	
	
	
	
}
