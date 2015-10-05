package test;

import java.io.IOException;

import dungeon.Dungeon;
import dungeon.character.Player;
import dungeon.object.Potion;
import dungeon.object.Weapon;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestDungeon {

	@Test
	public void testCreateDungeon() throws IOException {
		Dungeon dg = new Dungeon();
		Dungeon dg2 = new Dungeon();
		dg.createDungeon("levels/TestLevel1.txt");
		dg2.createDungeon("levels/TestLevel2.txt");
		
		assertEquals("Entrance",dg.getCurrentRoom().getType());
		assertEquals("Monster",dg.getCurrentRoom().go("Ouest").getType());
		assertEquals("Monster",dg.getCurrentRoom().go("North").getType());
		assertEquals("Intersection",dg.getCurrentRoom().go("Ouest").go("North").getType());
		assertEquals("Monster",dg.getCurrentRoom().go("Ouest").go("North").go("Est").getType());
		assertEquals("Intersection",dg.getCurrentRoom().go("Ouest").go("North").go("Ouest").getType());
		assertEquals("Intersection",dg.getCurrentRoom().go("Ouest").go("North").go("Ouest").go("North").getType());
		assertEquals("Intersection",dg.getCurrentRoom().go("Ouest").go("North").go("Ouest").go("North").go("Ouest").getType());
		assertEquals("Intersection",dg.getCurrentRoom().go("Ouest").go("North").go("Ouest").go("North").go("Ouest").go("Ouest").getType());
		assertEquals("Exit",dg.getCurrentRoom().go("Ouest").go("North").go("Ouest").go("North").go("Ouest").go("Ouest").go("North").getType());
		
		assertEquals("Entrance",dg2.getCurrentRoom().getType());
		assertEquals("Intersection",dg2.getCurrentRoom().go("Est").getType());
		assertEquals("Exit",dg2.getCurrentRoom().go("Est").go("North").getType());
		assertEquals("Intersection",dg2.getCurrentRoom().go("Est").go("North").go("Ouest").getType());
	}

	@Test
	public void testStartDungeon() throws IOException {
		Dungeon dg = new Dungeon();
		Player p1 = new Player("lille1",100,new Weapon("sword",dg,15),75);
		dg.setPlayer(p1);
		p1.takeObjects(new Potion("popo",dg));
		p1.takeObjects(new Weapon("gun",dg,50));

		dg.createDungeon("levels/TestLevel3.txt");
		dg.start();
		
	}
	

	
}
