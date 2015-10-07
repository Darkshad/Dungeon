package dungeon.object;
import dungeon.Dungeon;
import dungeon.object.Objects;

/**
 * Class ObjectsCanBeTaken inherit from the class Objects
 * The class is abstract because some class inherits from this class.
 * 
 * @author Guyot Clement - Cornaire Francis
 * 
 */
public abstract class ObjectsCanBeTaken extends Objects {
	
	// Attributes
	
	protected boolean canBeTaken = true;
	
	// Constructor
	
	/**
	 * This method permit to create an objects who can be add to the inventory of the player.
	 * @param name - the name of this object
	 * @param dg - the dungeon
	 */
	public ObjectsCanBeTaken(String name, Dungeon dg) {
		super(name, dg);
	}
	
	/**
	 * This method permit to know if an object can be add to the inventory or not.
	 * @return True if an object can be taken, False either.
	 */
	public boolean canBeTaken() {
		return this.canBeTaken;
	}
	
	/**
	 * This method is abstract because she's used in the class who inherits
	 * from this class.
	 */
	public abstract void use();
}
