package test;

import static org.junit.Assert.*;
import dungeon.Dungeon;
import dungeon.object.*;

import org.junit.Test;
import dungeon.character.*;

/**
 * Class TestMonster from the package dungeon.test.
 * This class is in charge of the test of the class Monster
 * @author Guyot Clement - Cornaire Francis
 * Licence 3 Miage - 2015/2016
 */

public class TestMonster {

	
	/* In this test class we don't test all of the character's class methods
	 * because they're tested in the test class TestPlayer.java
	 */
	
	
	@Test
	public void testCreateMonster() {
		Dungeon d1 = new Dungeon();
		Weapon w1 = new Weapon("baton",d1,20);
		Monster m1 = new Monster("troll",150,w1,30);
		assertEquals(m1.getName(),"troll");
		assertNotEquals(m1.getName(),"dragon");
		assertEquals(m1.getHealthPoint(),150);
		assertNotEquals(m1.getHealthPoint(),20);
		assertEquals(m1.getWeapon(),w1);
		assertNotEquals(m1.getWeapon(),new Weapon("baton",d1,30));
		assertEquals(m1.getAccuracy(),30);
		assertNotEquals(m1.getAccuracy(),20);
	}
}
