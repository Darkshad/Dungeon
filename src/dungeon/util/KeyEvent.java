package dungeon.util;

import dungeon.util.Player;

public class KeyEvent implements Event{

	// Attributes
	
	protected boolean locked;

	// Constructor
	
	public KeyEvent(boolean locked){
		this.locked = locked;
	}
	
	public void start(Player player1){
		System.out.println("The door is locked, you have to found a key to open her");
		System.out.println("If you have it in your inventory, tap object");
		
	}
	
}
