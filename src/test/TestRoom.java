package test;

import static org.junit.Assert.*;
import dungeon.Dungeon;
import dungeon.character.Monster;
import dungeon.character.Player;
import dungeon.object.Weapon;
import dungeon.room.EntranceRoom;
import dungeon.room.ExitRoom;
import dungeon.room.IntersectionRoom;
import dungeon.room.KeyRoom;
import dungeon.room.MonsterRoom;
import dungeon.room.Room;
import dungeon.room.TrapRoom;

import org.junit.Test;

public class TestRoom {
	

	/**
	 * Test all methods in the class Room
	 */

	@Test
	public void testCreateRoom(){
		Dungeon d1 = new Dungeon();
		KeyRoom r = new KeyRoom("key",false,d1);
		assertEquals(r.getType(),"key");
		assertNotEquals(r.getType(),"trap");
		assertEquals(r.isHidden(),false);
		assertNotEquals(r.isHidden(),true);		
	}


	@Test
	public void testRoom() {
		Dungeon dg = new Dungeon();
		Room entrance = new EntranceRoom("Entrance",false,dg);
		Room trap = new TrapRoom("Trap",true,dg);
		Room intersection = new IntersectionRoom("Intersection",false,dg);

		entrance.setneighbors("Ouest", intersection);
		entrance.setneighbors("under the table", trap);
		assertEquals("Entrance",entrance.getType());
		

		entrance.describeRoom();
		
		entrance.unlock();
		
		assertEquals("Trap",entrance.go("under the table").getType());
		assertEquals("Intersection",entrance.getNeighbors().get("Ouest").getType());
		assertEquals(null,entrance.go("South"));
		
		assertTrue(entrance.go("under the table").isHidden());
		assertFalse(entrance.go("Ouest").isHidden());
		
		intersection.nowHidden();
		assertTrue(entrance.go("Ouest").isHidden());
		
		assertFalse(entrance.go("Ouest").isLocked());
		assertFalse(entrance.go("under the table").isLocked());
		
	}
	
	/**
	 * Test testable methods in the class MonsterRoom 
	 */	
	@Test
	public void testMonsterRoom() {
		Dungeon dg = new Dungeon();
		Monster dragon = new Monster("Dragon",20,(new Weapon("Sword",dg,15)),10);
		MonsterRoom mr = new MonsterRoom("Monster",false,dg,dragon);
		
		assertEquals(dragon,mr.getMonster());
	}
	
	/**
	 * Test testable methods in the class KeyRoom
	 */	
	@Test
	public void testKeyRoom() {
		Dungeon dg = new Dungeon();
		KeyRoom kr = new KeyRoom("Key",false,dg);
		
		assertTrue(kr.isLocked());
		kr.unlock();
		assertFalse(kr.isLocked());
	}
	
	/**
	 * Test testable event() method in the sub class of Room  
	 */	
	@Test
	public void testEvent() {
		Dungeon dg = new Dungeon();
		Weapon w1 = new Weapon("gun",dg,25);
		Player p1 = new Player("toto",200,w1,50);
		dg.setPlayer(p1);
		
		Room entrance = new EntranceRoom("Entrance",false,dg);
		Room intersection = new IntersectionRoom("Intersection",false,dg);
		Room exit = new ExitRoom("Exit",false,dg);
		Room trap = new TrapRoom("Trap",true,dg);
		
		entrance.startEvent();
		entrance.startEvent();
		intersection.startEvent();
		exit.startEvent();
		trap.startEvent();
		
		assertTrue(p1.isDead());
			
	}
}
