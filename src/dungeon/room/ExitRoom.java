package dungeon.room;
import dungeon.Dungeon;

/**
 * Class ExitRoom from the package dungeon.room.
 * This class inherit from the super class Room.
 * This class represent the normal exit of the dungeon.
 * @author Guyot Clement - Cornaire Francis
 * Licence 3 Miage - 2015/2016
 */

public class ExitRoom extends Room{

	/**
	 * This method allow to create an exit room.
	 * @param type - the type of room.
	 * @param hidden - if the room is hidden or not.
	 * @param dungeon - the dungeon which is related.
	 */
	public ExitRoom(String type,boolean hidden,Dungeon dungeon) {
		super(type,hidden,dungeon);
	}

	/**
	 * The event method of this class
	 * It will finish the dungeon once you got in this room
	 */
	public void event(){
		System.out.println("Your journey in this dungeon is over,you just arrived to the exit!");
		this.dg.getPlayer().setFinishedGame(true);
	}
	
}
