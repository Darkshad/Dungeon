package dungeon.room;

import dungeon.Dungeon;
import dungeon.object.Objects;

public class TreasureRoom extends Room {

		//Attribut
	private Objects obj;
				
	//Constructor 
	public TreasureRoom (String type,boolean hidden,Dungeon dungeon,Objects o) {
		super(type,hidden,dungeon);
		this.obj = o;
	}
				
	public void event() {
		if(!this.eventHappened) {
			System.out.println("You found a treasure");
			System.out.println("It's a " + obj.getName());
			if(obj.canBeTaken())
				this.dg.getPlayer().takeObjects(this.obj);
			else
				obj.use();
		}
		else
			System.out.println("There was a treasure in this room but you already took it");
		}
	}


