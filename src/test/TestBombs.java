package test;

import static org.junit.Assert.*;
import dungeon.Dungeon;
import dungeon.character.*;
import dungeon.object.*;

import org.junit.Test;

public class TestBombs {

	@Test
	public void testBombs() {
		Dungeon d1 = new Dungeon();
		Bombs b1 = new Bombs("bomb",d1,30);
		assertEquals(b1.getObjects(),"bomb");
		assertNotEquals(b1.getObjects(),"bombe");
		assertEquals(b1.getDamage(),30);
		assertNotEquals(b1.getDamage(),50);
		Player p1 = new Player("toto",200,new Weapon("kick",d1,10),40);
		b1.use();
		assertEquals(p1.getHealthPoint(),170);
		assertNotEquals(p1.getHealthPoint(),230);
	}

}
