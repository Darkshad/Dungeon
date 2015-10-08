package test;

import java.io.IOException;

import dungeon.Dungeon;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Class TestDungeon from the package dungeon.test.
 * This class is in charge of the test of the class Dungeon
 * @author Guyot Clement - Cornaire Francis
 * Licence 3 Miage - 2015/2016
 */

public class TestDungeon {

	@Test
	public void testCreateDungeon() throws IOException {
		Dungeon dg = new Dungeon();
		dg.createDungeon("levels/TestLevel1.txt");
		
		assertEquals("Entrance",dg.getCurrentRoom().getType());
		assertEquals("Trap",dg.getCurrentRoom().go("Ouest").getType());
		assertEquals(null,dg.getCurrentRoom().go("Est"));
		assertEquals("ExitRoomMonster",dg.getCurrentRoom().go("Ouest").go("Ouest").getType());
		assertEquals("Treasure",dg.getCurrentRoom().go("Ouest").go("Ouest").go("Ouest").getType());
		assertEquals("Intersection",dg.getCurrentRoom().go("Ouest").go("Ouest").go("Ouest").go("Ouest").getType());
		assertEquals("KeyRoom",dg.getCurrentRoom().go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").getType());
		assertEquals("Monster",dg.getCurrentRoom().go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").getType());
		assertEquals("Treasure",dg.getCurrentRoom().go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").getType());
		assertEquals("Exit",dg.getCurrentRoom().go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").getType());
		assertEquals("Treasure",dg.getCurrentRoom().go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").getType());
		assertEquals("Treasure",dg.getCurrentRoom().go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").getType());
		assertEquals("Treasure",dg.getCurrentRoom().go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("South").getType());
		assertEquals("Treasure",dg.getCurrentRoom().go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("South").go("Est").getType());
		assertEquals("Treasure",dg.getCurrentRoom().go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("Ouest").go("South").go("Est").go("North").getType());
		
		
	}

}
