package dungeon.room;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import dungeon.Dungeon;


/**
 * Class Room from the package dungeon.room.
 * An important class for the dungeon; it's manage room implementation and different type of room  
 * @author Guyot Clement - Cornaire Francis
 * Licence 3 Miage - 2015/2016
 */

public abstract class Room {
	
	// Attributes
	
	protected final String type;
	protected boolean hidden ;
	protected boolean eventHappened;
	protected Dungeon dg;
	protected Map<String,Room> neighbors = new HashMap<String,Room>();
	
	// Constructor
	/**
	 * This method allow to create an room.
	 * @param type - the type of room.
	 * @param hidden - if the room is hidden or not.
	 * @param dungeon - the dungeon which is related.
	 */
	public Room(String type,boolean hidden,Dungeon dungeon){
		this.type = type;
		this.hidden = hidden;
		this.eventHappened = false;
		this.dg = dungeon;
	}
	
	// Methods
	/**
	 * Return a room in this room neighbor depending of the instruction
	 * Can return null if the instruction is not referred in neighbor
	 * @return A room referred to the instruction else null
	 */
	public Room go(String instruction){
		if (neighbors.containsKey(instruction))
			return neighbors.get(instruction);
		else
			return null;
	}
	
	/**
	 * Set the a neighbor for the room
	 * @param instruction the instruction which will be attributed to the room
	 * @param neigbor the room we want to make neighbor of this room
	 */
	public void setneighbors(String instruction, Room neighbor){
		neighbors.put(instruction,neighbor);
	}
	
	/**
	 * Get the neighbor of this room
	 * @return the neighbor
	 */
	public Map<String,Room> getNeighbors() {
		return this.neighbors;
	}
	
	/**
	 * Get the name of the room
	 * @return the type
	 */
	public String getType(){
		return this.type;
	}
	
	/**
	 * The method which need to manage event.It's abstract,so it allow the sub class to varies this method for different type of room
	 */
	public abstract void event();
	
	/**
	 * Check if the room is hidden 
	 * @return true if yes, false if not
	 */
	public boolean isHidden() {	
		return this.hidden;
	}
	
	/**
	 * Make the room hidden 
	 */
	public void nowHidden() {
		this.hidden = true;
	}
	
	/**
	 * Describe this room
	 * it will show the neighbor room of this room
	 */
	public void describeRoom() {
		Iterator<Room> itRoom = (neighbors.values()).iterator();
		Iterator<String> itInstruction = (neighbors.keySet()).iterator();
		while(itRoom.hasNext() && itInstruction.hasNext()) { //we travel trough the map key and value to show the room neighbor
			Room current = itRoom.next();
			String instruction = itInstruction.next(); //if not hidden we can say were the neighbor is,
			if(!current.isHidden())
				System.out.println("There is a door in the " + instruction + " of this room");
			else //if not,we are not revealing where is the neighbor but we are showing the user that is something on this room
				System.out.println("There is a " + instruction.substring(instruction.lastIndexOf(' ')+1) + " in this room"); //behind the wall = wall in this exemple
			
		}
	}
	
	/**
	 * Start the event of the room
	 */
	public void startEvent(){
		this.event();
		if(this.eventHappened == false) //after the first try,the event don't need to be launched again
			this.eventHappened = true;
	}

	/**
	 * Check if the room is locked
	 * it always return false,only true if its a KeyRoom which need a key (this method is overloaded in the class KeyRoom)
	 * @return False
	 */
	public boolean isLocked() {
		return false;
	}

	/**
	 * The method for unlocking a room.
	 * Nothing to do with room who are not locked
	 * only useful for KeyRoom (This method is overloaded in the class KeyRoom
	 */
	public void unlock() {
	}

	
}
	
	

