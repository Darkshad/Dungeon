package dungeon.object;
import dungeon.Dungeon;
import dungeon.object.Objects;


/**
 * Class ObjectsCanBeTaken from package dungeon.object
 * 
 * @author Guyot Clement - Cornaire Francis
 * 
 * This class is used to make a difference between the objects 
 * the player can takes in his inventory and the others.
 * The class is abstract because some class inherits from this class
 *
 */
public abstract class ObjectsCanNotBeTaken extends Objects {
	
	// Attributes
	protected boolean canBeTaken = false;
	
	// Constructor
	
	/**
	 * This method permit to create an object who can't be in the player's inventory
	 * @param name - the name of the object
	 * @param dg - the dungeon
	 */
	public ObjectsCanNotBeTaken(String name, Dungeon dg) {
		super(name, dg); // super permit to use the constructor of the super class(Objects)
	}
	
	// Methods
	
	/**
	 * This method is used to know if an object can be taken by the player or not
	 * @return True if an object can be taken, False either.
	 */
	public boolean canBeTaken() {
		return this.canBeTaken;
	}
	
	/**
	 * This method is abstract because she's used in the class bomb
	 */
	public abstract void use();
}