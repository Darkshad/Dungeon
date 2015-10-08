package dungeon.room;
import dungeon.Dungeon;

/**
 * Class TrapRoom from package dungeon.room.
 * The class inherit from the super class Room.
 * The class represent a room where there is a trap.
 * @author Guyot Clement - Cornaire Francis
 * Licence 3 Miage - 2015/2016
 */
public class TrapRoom extends Room{

	// Constructor
	
	/**
	 * This method permit to create a trap room.
	 * @param type - the type of room.
	 * @param hidden - if the room is hidden or not.
	 * @param dungeon - the dungeon.
	 */
	public TrapRoom(String type,boolean hidden,Dungeon dungeon) {
		super(type,hidden,dungeon);
	}

	// Methods
	
	/**
	 * This method permit to start the event of this room.
	 * When a player go in a trap room, he die and the game is finished.
	 */
	public void event() {
		System.out.println("It's a trap");
		this.dg.getPlayer().setHealthPoints(0);
		this.dg.getPlayer().setFinishedGame(true);
	}
	
}
