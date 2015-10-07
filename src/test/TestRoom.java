package test;

import static org.junit.Assert.*;
import java.io.IOException;
import dungeon.room.*;

import dungeon.Dungeon;
import dungeon.character.Player;
import dungeon.object.*;

import org.junit.Test;

public class TestRoom {
	
	@Test
	public void testCreateRoom(){
		Dungeon d1 = new Dungeon();
		KeyRoom r = new KeyRoom("key",false,d1);
		assertEquals(r.getType(),"key");
		assertNotEquals(r.getType(),"trap");
		assertEquals(r.isHidden(),false);
		assertNotEquals(r.isHidden(),true);		
	}
	/*
	@Test
	public void testExitRoomMonster() throws IOException{
		Dungeon d1 = new Dungeon();
		Player p1 = new Player("lille1",100,new Weapon("sword",d1,30),50);
		p1.takeObjects(new Potion("popo",d1));
		p1.takeObjects(new Weapon("bazooka",d1,200));
		d1.createDungeon("levels/TestExitRoomMonster.txt");
		
		d1.start();
	}*/

}
