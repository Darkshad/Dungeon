package test;

import static org.junit.Assert.*;
import dungeon.Dungeon;
import dungeon.character.Player;

import org.junit.Test;
import dungeon.object.Weapon;

public class TestWeapon {

	@Test
	public void createWeapon() {
		Dungeon d1 = new Dungeon();
		Weapon w1 = new Weapon("gun",d1,50);
		assertEquals(w1.getObjects(),"gun");
		assertEquals(w1.getDamage(),50);
		assertNotEquals(w1.getDamage(),10);
		assertNotEquals(w1.getObjects(),"toto");
	}

	@Test
	public void useWeapon(){
		Dungeon d1 = new Dungeon();
		Weapon w1 = new Weapon("kick",d1,10);
		Weapon w2 = new Weapon("gun",d1,50);
		Player p1 = new Player("toto",200,w1,30);
		p1.takeObjects(w2);
		assertTrue(p1.getInventory().contains(w2));
		assertFalse(p1.getInventory().contains(w1));
		assertEquals(p1.getWeapon(),w1);
		assertNotEquals(p1.getWeapon(),w2);
		d1.setPlayer(p1);
		w2.use();
		assertTrue(p1.getInventory().contains(w1));
		assertFalse(p1.getInventory().contains(w2));
		assertEquals(p1.getWeapon(),w2);
		assertNotEquals(p1.getWeapon(),w1);
	}
}
