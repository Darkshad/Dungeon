package dungeon.room;
import dungeon.Dungeon;

/**
 * Class EntranceRoom from package dungeon.room.
 * This class inherit from the super class Room.
 * This class represent the entrance of the dungeon.
 * @author Guyot Clement - Cornaire Francis
 * Licence 3 Miage - 2015/2016
 */
public class EntranceRoom extends Room {
	
	// Constructor
	
	/**
	 * This method permit to create an entrance room.
	 * @param type - the type of room.
	 * @param hidden - if the room is hidden or not.
	 * @param dungeon - the dungeon.
	 */
	public EntranceRoom(String type,boolean hidden,Dungeon dungeon) {
		super(type,hidden,dungeon);
	}
	
	// Methods
	
	/**
	 * The method start the event of the entrance room.
	 * There isn't a particular event, it's just a print to welcome the player in the dungeon.
	 */
	public void event() {
		if(!this.eventHappened) {
			System.out.println("Welcome to the dungeon.");
			System.out.println("Get ready for some crazy challenge!!\n");
		}
		else
			System.out.println("You are in the entrance\n");
			
	}

}
