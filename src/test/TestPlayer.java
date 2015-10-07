package test;

import static org.junit.Assert.*;


import org.junit.Test;

import dungeon.character.Player;
import dungeon.object.*;

import java.util.LinkedList;

public class TestPlayer {

	@Test
	public void testCreatePlayer() {
		Weapon w1 = new Weapon("gun",25);
		Weapon w2 = new Weapon("kick",10);
		Player p1 = new Player("toto",200,w1,50);
		assertEquals(p1.getHealthPoint(),200);
		assertEquals(p1.getName(),"toto");
		assertNotEquals(p1.getName(),"nicolas");
		assertSame(p1.getWeapon(),w1);
		assertNotSame(p1.getWeapon(),w2);
		assertEquals(p1.getAccuracy(),50);
		assertNotEquals(p1.getAccuracy(),30);
	}

	@Test
	public void testTakeObjects(){
		Weapon w1 = new Weapon("gun",25);
		Player p1 = new Player("toto",200,new Weapon("kick",10),50);
		p1.takeObjects(w1);
		assertTrue(p1.getInventory().contains(w1));
	}
	
	@Test
	public void testGetInventory(){
		Player p1 = new Player("toto",200,new Weapon("kick",10),50);
		LinkedList<Objects> l1 = new LinkedList<Objects>();
		Weapon w1 = new Weapon("gun",40);
		l1.add(w1);
		p1.takeObjects(w1);
		assertEquals(p1.getInventory(),l1);
	}
	
	@Test
	public void testSetWeapon(){
		Weapon w1 = new Weapon("gun",40);
		Weapon w2 = new Weapon("kick",20);
		Player p1 = new Player("toto",200,w1,50);
		assertEquals(p1.getWeapon(),w1);
		assertNotEquals(p1.getWeapon(),w2);
		p1.setWeapon(w2);
		assertEquals(p1.getWeapon(),w2);
		assertNotEquals(p1.getWeapon(),w1);
	}
	
	@Test // To verify this test you should be look the result in the console to see the print.
	public void testPrintObject(){
		Player p1 = new Player("toto",200,new Weapon("kick",10),50);
		Weapon w1 = new Weapon("gun",50);
		Weapon w2 = new Weapon("pistol",40);
		p1.takeObjects(w2);
		p1.takeObjects(w1);
		p1.printObjects();
	}
	
	@Test
	public void testIsDead(){
		Player p1 = new Player("toto",200,new Weapon("gun",50),30);
		assertFalse(p1.isDead());
		p1.setHealthPoints(0);
		assertTrue(p1.isDead());
	}
	@Test
	public void testTakeObject(){
		Player p1 = new Player("toto",200,new Weapon("gun",50),30);
		Weapon w1 = new Weapon("gun",50);
		assertEquals(p1.getInventory().size(),0);
		assertNotEquals(p1.getInventory().size(),1);
		p1.takeObjects(w1);
		assertEquals(p1.getInventory().size(),1);
		assertNotEquals(p1.getInventory().size(),0);
	}
	
	@Test
	public void testGetSetInFight(){
		Player p1 = new Player("toto",200,new Weapon("kick",20),30);
		boolean etat = true;
		boolean etat2 = false;
		assertFalse(p1.getInFight());
		p1.setInFight(etat);
		assertTrue(p1.getInFight());
		p1.setInFight(etat2);
		assertFalse(p1.getInFight());
	}
	
	@Test
	public void testGetSetFinishedTheGame(){
		Player p1 = new Player("toto",200,new Weapon("kick",20),30);
		boolean statut = true;
		assertFalse(p1.finishedTheGame());
		p1.setFinishedGame(statut);
		assertTrue(p1.finishedTheGame());
	} 
	
	@Test
	public void testGetSetName(){
		Player p1 = new Player("toto",200,new Weapon("kick",20),30);
		assertEquals(p1.getName(),"toto");
		p1.setName("clement");
		assertNotEquals(p1.getName(),"toto");
		assertEquals(p1.getName(),"clement");
	}
}
