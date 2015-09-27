package dungeon.util;

public class EntranceRoom extends Room {
	
	public EntranceRoom(String type,String instruction,boolean hidden) {
		super(type,instruction,hidden);
	}
	
	public void event(Player player) {
		if(!this.eventHappened) {
			System.out.println("Welcome to the dungeon.");
			System.out.println("Get ready for some crazy challenge!!\n");
		}
		else
			System.out.println("You are in the entrance\n");
			
	}

}
