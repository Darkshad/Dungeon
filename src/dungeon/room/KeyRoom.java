package dungeon.room;
import dungeon.Dungeon;

/**
 * Class KeyRoom from the package dungeon.room.
 * This Class inherit from the super class Room.
 * This class permit to represent a locked room,
 * the player need to find a key to unlock her.
 * 
 * @author Guyot Clement - Cornaire Francis.
 * Licence 3 Miage - 2015/2016
 */
public class KeyRoom extends Room{
	
	//Attributes
	
	private boolean locked;
	
	// Constructor
	
	/**
	 * The constructor permit to create a locked room.
	 * @param type - the type of room.
	 * @param hidden - the room is hidden or not.
	 * @param dungeon - the dungeon
	 */
	public KeyRoom(String type,boolean hidden,Dungeon dungeon) {
		super(type,hidden,dungeon);
		this.locked = true;
	}

	/**
	 * The method permit to know if the room is locked or not
	 * @return True if the room is locked, False either.
	 */
	public boolean isLocked() {
		return this.locked;
	}
	
	/**
	 * This method permit to unlock the room.
	 */
	public void unlock() {
		this.locked = false;
	}
	
	/**
	 * This method permit to start the event of the room.
	 * Each room has a special event.
	 */
	@Override
	public void event(){
		if(this.dg.getPlayer().getInFight()) 
		{
			if(this.isLocked()) {
				System.out.println("The door is locked, you have to found a key to open her");
				System.out.println("If you have it,use it");
				this.dg.getPlayer().choiceObjets();
				if(this.isLocked()) {
					System.out.println("Go search for the key and come back when you have it");
					this.dg.goBack();
				}
			}
			else
				System.out.println("You are in a room who was locked");
		}
		else 
			System.out.println("You cant do this action!you are in a fight \n");
	}
	
}
