package dungeon.util;
public abstract class Objects {
	
	// Attributes
	
	protected String name;
	
	// Constructor
	
	public Objects(String name){
		this.name = name;
	}
	
	// Methods
	
	public String getObjects(){
		return this.name;
	}
	
	abstract void use(Player p);
}
