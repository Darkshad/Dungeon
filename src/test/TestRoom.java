package test;


import java.io.IOException;

import dungeon.Dungeon;
import dungeon.character.Player;
import dungeon.object.*;

import org.junit.Test;

public class TestRoom {
	@Test
	public void testExitRoomMonster() throws IOException{
		Dungeon d1 = new Dungeon();
		Player p1 = new Player("lille1",100,new Weapon("sword",d1,30),50);
		p1.takeObjects(new Potion("popo",d1));
		p1.takeObjects(new Weapon("bazooka",d1,200));
		d1.createDungeon("levels/TestExitRoomMonster.txt");
		
		d1.start();
	}

}
