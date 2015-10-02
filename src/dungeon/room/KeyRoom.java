package dungeon.room;

import dungeon.character.Player;

public class KeyRoom extends Room{
	//Attributs
	
	private boolean locked;

	public KeyRoom(String type,String instruction,boolean hidden) {
		super(type,instruction,hidden);
		this.locked = true;
	}

	public void event(Player player){
		System.out.println("The door is locked, you have to found a key to open her");
		System.out.println("If you have it in your inventory, tap object");
	}
	
}
