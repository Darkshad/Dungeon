package test;


import java.io.IOException;

import dungeon.Dungeon;
import dungeon.util.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestRoom {
	@Test
	public void testExitRoomMonster() throws IOException{
		Player p1 = new Player("lille1",100,new Weapon("sword",30),50);
		Dungeon dg = new Dungeon(p1);
		dg.createDungeon("levels/TestExitRoomMonster.txt");
		
		dg.start();
	}

}
