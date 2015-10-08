package dungeon.room;

import dungeon.Dungeon;

/**
 * Class IntersectionRoom from the package dungeon.room.
 * This class inherit from the super class Room.
 * This class represent a room with no particular event
 * @author Guyot Clement - Cornaire Francis
 * Licence 3 Miage - 2015/2016
 */

public class IntersectionRoom extends Room {
	/**
	 * This method allow to create an Intersection room
	 * @param type - the type of room.
	 * @param hidden - if the room is hidden or not.
	 * @param dungeon - the dungeon which is related.
	 */
	public IntersectionRoom(String type,boolean hidden,Dungeon dungeon) {
		super(type,hidden,dungeon);
	}
	
	/**
	 * The event method of this class
	 * there is no particular event in this room
	 */
	public void event() {
		System.out.println("This room is normal and empty\n");
	}

}
