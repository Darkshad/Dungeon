package dungeon.room;
import dungeon.Dungeon;
import dungeon.object.Objects;

/**
 * Class TreasureRoom from the package dungeon.room
 * This class inherit from the super class Room.
 * This class represent a room in witch there is a treasure.
 * @author Guyot Clement - Cornaire Francis
 * Licence 3 Miage - 2015/2016
 */
public class TreasureRoom extends Room {

	//Attributes
	
	private Objects obj;
				
	//Constructor 
	
	/**
	 * The construtor permit to create a tresure room. 
	 * @param type - the type of the room.
	 * @param hidden - if the room is hidden or not.
	 * @param dungeon - the dungeon.
	 * @param o - the object in the treasure.
	 */
	public TreasureRoom (String type,boolean hidden,Dungeon dungeon,Objects o) {
		super(type,hidden,dungeon);
		this.obj = o;
	}
				
	// Methods
	
	/**
	 * The method permit to start the event of the class treasure.
	 * If the object is an object the player can be taken then the object is add to the inventor.
	 * Else if it's a trap-treasure like a bomb, the object is used.
	 */
	public void event() {
		if(!this.eventHappened) {
			System.out.println("You found a treasure");
			System.out.println("It's a " + obj.getObjects());
			if(obj.canBeTaken())
				this.dg.getPlayer().takeObjects(this.obj);
			else
				obj.use();
		}
		else
			System.out.println("There was a treasure in this room but you already took it");
		}
	}


