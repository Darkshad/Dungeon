package test;

import static org.junit.Assert.*;
import dungeon.character.Player;

import org.junit.Test;
import dungeon.object.Weapon;

public class TestWeapon {

	@Test
	public void createWeapon() {
		Weapon w1 = new Weapon("gun",50);
		assertEquals(w1.getObjects(),"gun");
		assertEquals(w1.getDamage(),50);
		assertNotEquals(w1.getDamage(),10);
		assertNotEquals(w1.getObjects(),"toto");
	}

	@Test
	public void useWeapon(){
		Weapon w1 = new Weapon("kick",10);
		Weapon w2 = new Weapon("gun",50);
		Player p1 = new Player("toto",200,w1,30);
		p1.takeObjects(w2);
		assertTrue(p1.getInventory().contains(w2));
		assertFalse(p1.getInventory().contains(w1));
		assertEquals(p1.getWeapon(),w1);
		assertNotEquals(p1.getWeapon(),w2);
		w2.use(p1);
		assertTrue(p1.getInventory().contains(w1));
		assertFalse(p1.getInventory().contains(w2));
		assertEquals(p1.getWeapon(),w2);
		assertNotEquals(p1.getWeapon(),w1);
	}
}
