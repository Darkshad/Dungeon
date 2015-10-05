package test;


import java.io.IOException;

import dungeon.Dungeon;
import dungeon.character.Player;
import dungeon.object.Weapon;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestRoom {
	@Test
	public void testExitRoomMonster() throws IOException{
		Dungeon dg = new Dungeon();
		Player p1 = new Player("lille1",100,new Weapon("sword",dg,30),50);
		dg.setPlayer(p1);
		p1.takeObjects(new Weapon("bazooka",dg,200));

		dg.createDungeon("levels/TestExitRoomMonster.txt");
		
		dg.start();
	}
	
	@Test
	public void testKeyRoom() throws IOException{
		Dungeon dg = new Dungeon();
		Player p1 = new Player("lille1",100,new Weapon("sword",dg,30),50);
		dg.setPlayer(p1);

		dg.createDungeon("levels/TestKeyRoom.txt");
		
		dg.start();
	}

}
