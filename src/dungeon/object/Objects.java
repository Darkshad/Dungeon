package dungeon.object;
import dungeon.character.Player;

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
	
	public abstract void use(Player p);

	public String getName() {
		return name;
	}
}
