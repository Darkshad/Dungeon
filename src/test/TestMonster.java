package test;

import static org.junit.Assert.*;
import dungeon.object.*;

import org.junit.Test;
import dungeon.character.*;
public class TestMonster {

	
	/* In this test class we don't test all of the character's class methods
	 * because they're tested in the test class TestPlayer.java
	 */
	
	
	@Test
	public void testCreateMonster() {
		Weapon w1 = new Weapon("baton",20);
		Monster m1 = new Monster("troll",150,w1,30);
		assertEquals(m1.getName(),"troll");
		assertNotEquals(m1.getName(),"dragon");
		assertEquals(m1.getHealthPoint(),150);
		assertNotEquals(m1.getHealthPoint(),20);
		assertEquals(m1.getWeapon(),w1);
		assertNotEquals(m1.getWeapon(),new Weapon("baton",30));
		assertEquals(m1.getAccuracy(),30);
		assertNotEquals(m1.getAccuracy(),20);
	}
	
	@Test
	public void testTurn(){
		Monster m1 = new Monster("troll",150,new Weapon("baton",30),30);
		Player p1 = new Player("toto",200,new Weapon("gun",50),30);
		m1.turn(p1);
	}

}
