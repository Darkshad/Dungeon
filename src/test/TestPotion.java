package test;

import static org.junit.Assert.*;
import dungeon.Dungeon;
import dungeon.object.*;
import dungeon.character.Player;

import org.junit.Test;

public class TestPotion {

	@Test
	public void createPotion() {
		Dungeon d1 = new Dungeon();
		Potion p1 = new Potion("popo",d1);
		assertEquals(p1.getPotion(),50);
		assertEquals(p1.getObjects(),"popo");
	}
	
	@Test
	public void usePotion(){
		Dungeon d1 = new Dungeon();
		Player player = new Player("toto",200,new Weapon("kick",d1,20),30);	
		Potion p1 = new Potion("popo",d1);
		d1.setPlayer(player);
		p1.use();
		assertFalse(player.getInventory().contains(p1)); //test if the potion are remove from the inventory
		assertEquals(player.getHealthPoint(),250); //test if the potion give health point to the player 
	}
}
