package dungeon.util;

public class IntersectionRoom extends Room {
	public IntersectionRoom(String type,String instruction,boolean hidden) {
		super(type,instruction,hidden);
	}
	
	public void event(Player player) {
		System.out.println("This room is normal and empty\n");
	}

}
