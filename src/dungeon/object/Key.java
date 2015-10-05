package dungeon.object;
import dungeon.Dungeon;
import dungeon.room.Room;

public class Key extends ObjectsCanBeTaken{
	
	// Constructor
	
	public Key(String name,Dungeon dg){
		super(name,dg);
	}

	
	public void use() {
		Room room = this.dg.getCurrentRoom();
		if(room.isLocked()) {
			room.unlock();
			this.dg.getPlayer().getInventory().remove(this);
			System.out.println("The door is now open");
		}
		else
			System.out.println("There is no room to unlock");
	}
}