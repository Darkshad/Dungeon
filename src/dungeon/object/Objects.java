package dungeon.object;

import dungeon.Dungeon;

public abstract class Objects {
	
	// Attributes
	Dungeon dg;
	
	protected String name;
	
	// Constructor
	
	public Objects(String name,Dungeon dg){
		this.name = name;
		this.dg = dg;
	}
	
	// Methods
	
	public String getObjects(){
		return this.name;
	}
	
	public abstract void use();
	
	public abstract boolean canBeTaken();

	public String getName() {
		return name;
	}
}
