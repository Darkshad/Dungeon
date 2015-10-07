package dungeon.room;

import dungeon.Dungeon;


public class KeyRoom extends Room{
	//Attributs
	
	private boolean locked;

	public KeyRoom(String type,boolean hidden,Dungeon dungeon) {
		super(type,hidden,dungeon);
		this.locked = true;
	}

	public boolean isLocked() {
		return this.locked;
	}
	
	public void unlock() {
		this.locked = false;
	}
	
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
