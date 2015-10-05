package dungeon.room;
import dungeon.Dungeon;


public class EntranceRoom extends Room {
	
	public EntranceRoom(String type,boolean hidden,Dungeon dungeon) {
		super(type,hidden,dungeon);
	}
	
	public void event() {
		if(!this.eventHappened) {
			System.out.println("Welcome to the dungeon.");
			System.out.println("Get ready for some crazy challenge!!\n");
		}
		else
			System.out.println("You are in the entrance\n");
			
	}

}
