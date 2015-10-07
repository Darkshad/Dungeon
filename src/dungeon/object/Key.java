package dungeon.object;
import dungeon.Dungeon;
import dungeon.room.Room;

/**
 * Class key from package dungeon.object
 * This class inherit from the class ObjectsCanBeTaken
 * 
 * @author Guyot Clement -Cornaire Francis
 * Licence 3 Miage - 2015/2016
 */
public class Key extends ObjectsCanBeTaken{
	
	// Constructor
	
	/**
	 * This method permit to create an object Key
	 * @param name - the name of the key
	 * @param dg - the dungeon
	 */
	public Key(String name,Dungeon dg){
		super(name,dg);
	}

	// Methods
	
	/**
	 * This method execute the actions of the key
	 * If the player is in a locked room, then the key can open the door, next the key is removed from the inventory
	 * and a message is print to the player to inform him the door is unlocked.
	 * If the player is not in a locked room then the use function print a message 
	 * to inform the player the key do nothing.
	 */
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