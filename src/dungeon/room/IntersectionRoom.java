package dungeon.room;

import dungeon.Dungeon;


public class IntersectionRoom extends Room {
	public IntersectionRoom(String type,boolean hidden,Dungeon dungeon) {
		super(type,hidden,dungeon);
	}
	
	public void event() {
		System.out.println("This room is normal and empty\n");
	}

}
