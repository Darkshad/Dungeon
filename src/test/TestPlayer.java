package test;

import static org.junit.Assert.*;
import java.util.Iterator;
import dungeon.util.*;
import org.junit.Test;
import java.util.LinkedList;
import java.util.List;

public class TestPlayer {

	@Test
	public void testCreationPlayer() {
		Weapon w1 = new Weapon("gun",25);
		Weapon w2 = new Weapon("kick",10);
		Player p1 = new Player("toto",200,w1,50);
		assertEquals(p1.getHealthPoint(),200);
		assertEquals(p1.getName(),"toto");
		assertFalse(p1.getName() == "nicolas");
		assertSame(p1.getWeapon(),w1);
		assertNotSame(p1.getWeapon(),w2);
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
		LinkedList<Objects> w1 = new LinkedList<Objects>();
		Player p1 = new Player("toto",200,new Weapon("kick",10),50);
		assertEquals(p1.getInventory(),w1);
	}
	
	@Test
	public void testChangeWeapon(){
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
	public void testChoiceObjects(){
		Player p1 = new Player("toto",200,new Weapon("kick",10),50);
		Weapon w1 = new Weapon("gun",20);
		Potion pt1 = new Potion("popo");
		p1.takeObjects(w1);
		p1.takeObjects(pt1);
		p1.choiceObjets();
	}
}
