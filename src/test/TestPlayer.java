package test;

import static org.junit.Assert.*;


import org.junit.Test;
import dungeon.Dungeon;
import dungeon.character.Player;
import dungeon.object.*;
import java.util.LinkedList;

public class TestPlayer {

	@Test
	public void testCreationPlayer() {
		Dungeon dg = new Dungeon();
		Weapon w1 = new Weapon("gun",dg,25);
		Weapon w2 = new Weapon("kick",dg,10);
		Player p1 = new Player("toto",200,w1,50);
		assertEquals(p1.getHealthPoint(),200);
		assertEquals(p1.getName(),"toto");
		assertFalse(p1.getName() == "nicolas");
		assertSame(p1.getWeapon(),w1);
		assertNotSame(p1.getWeapon(),w2);
	}

	@Test
	public void testTakeObjects(){
		Dungeon dg = new Dungeon();
		Weapon w1 = new Weapon("gun",dg,25);
		Player p1 = new Player("toto",200,new Weapon("kick",dg,10),50);
		p1.takeObjects(w1);
		assertTrue(p1.getInventory().contains(w1));
	}
	
	@Test
	public void testGetInventory(){
		LinkedList<Objects> w1 = new LinkedList<Objects>();
		Dungeon dg = new Dungeon();
		Player p1 = new Player("toto",200,new Weapon("kick",dg,10),50);
		assertEquals(p1.getInventory(),w1);
	}
	
	@Test
	public void testChangeWeapon(){
	}
	
	@Test // To verify this test you should be look the result in the console to see the print.
	public void testPrintObject(){
		Dungeon dg = new Dungeon();
		Player p1 = new Player("toto",200,new Weapon("kick",dg,10),50);
		Weapon w1 = new Weapon("gun",dg,50);
		Weapon w2 = new Weapon("pistol",dg,40);
		p1.takeObjects(w2);
		p1.takeObjects(w1);
		p1.printObjects();
	}
	
	@Test
	public void testChoiceObjects(){
		Dungeon dg = new Dungeon();
		Player p1 = new Player("toto",200,new Weapon("kick",dg,10),50);
		dg.setPlayer(p1);
		Weapon w1 = new Weapon("gun",dg,20);
		Potion pt1 = new Potion("popo",dg);
		p1.takeObjects(w1);
		p1.takeObjects(pt1);
		p1.choiceObjets();
	}
}
