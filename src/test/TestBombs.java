package test;

import static org.junit.Assert.*;
import dungeon.Dungeon;
import dungeon.character.*;
import dungeon.object.*;

import org.junit.Test;

/**
 * Class TestBombs from the package dungeon.test.
 * This class is in charge of the test of the class Bombs
 * @author Guyot Clement - Cornaire Francis
 * Licence 3 Miage - 2015/2016
 */

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
		d1.setPlayer(p1);
		b1.use();
		assertEquals(p1.getHealthPoint(),170);
		assertNotEquals(p1.getHealthPoint(),230);
	}

}
