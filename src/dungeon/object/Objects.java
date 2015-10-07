package dungeon.object;
import dungeon.Dungeon;

/**
 * Class Objects from package dungeon.object
 * 
 * @author Guyot Clement - Cornaire Francis
 * Licence 3 Miage - 2015/2016
 */
public abstract class Objects {
	
	// Attributes
	
	Dungeon dg;
	protected String name;
	
	// Constructor
	
	/** This method permit to create an object
	 * @param name
	 * @param dg
	 */
	public Objects(String name,Dungeon dg){
		this.name = name;
		this.dg = dg;
	}
	
	// Methods
	
	/**
	 * The method permit to know the name of the objects.
	 * @return the name of the objects.
	 */
	public String getObjects(){
		return this.name;
	}
	
	public abstract void use();
	
	public abstract boolean canBeTaken();

}
