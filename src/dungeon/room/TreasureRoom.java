package dungeon.room;

import dungeon.character.Player;
import dungeon.object.Objects;;

public class TreasureRoom extends Room {

		//Attribut
	private Objects obj;
				
	//Constructor 
	public TreasureRoom (String type,String instruction,boolean hidden,Objects o) {
		super(type,instruction,hidden);
		this.obj = o;
	}
				
	public void event(Player j) {
		if(!this.eventHappened) {
			System.out.println("You found a treasure");
			System.out.println("It's a " + obj.getName());
			j.takeObjects(this.obj);
		}
		else
			System.out.println("There was a treasure in this room but you already took it");
		}
	}


