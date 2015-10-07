package test;


import java.io.IOException;

import dungeon.Dungeon;
import dungeon.character.Player;
import dungeon.object.*;

import org.junit.Test;

public class TestRoom {
	@Test
	public void testExitRoomMonster() throws IOException{
		Player p1 = new Player("lille1",100,new Weapon("sword",30),50);
		p1.takeObjects(new Potion("popo"));
		p1.takeObjects(new Weapon("bazooka",200));
		Dungeon dg = new Dungeon(p1);
		dg.createDungeon("levels/TestExitRoomMonster.txt");
		
		dg.start();
	}

}
