package test;

import static org.junit.Assert.*;
import dungeon.object.*;
import dungeon.character.Player;

import org.junit.Test;

public class TestPotion {

	@Test
	public void createPotion() {
		Potion p1 = new Potion("popo");
		assertEquals(p1.getPotion(),50);
		assertEquals(p1.getObjects(),"popo");
	}
	
	@Test
	public void usePotion(){
		Player player = new Player("toto",200,new Weapon("kick",20),30);	
		Potion p1 = new Potion("popo");
		p1.use(player);
		assertFalse(player.getInventory().contains(p1)); //test if the potion are remove from the inventory
		assertEquals(player.getHealthPoint(),250); //test if the potion give health point to the player 
	}
}
