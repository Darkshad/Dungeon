package dungeon.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public abstract class Room {
	
	// Attributes
	
	protected final String type;
	protected final String instruction;
	protected final boolean hidden ;
	protected Map<String,Room> neighbors = new HashMap<String,Room>();
	
	// Constructor
	public Room(String type, String instruction,boolean hidden){
		this.type = type;
		this.instruction = instruction;
		this.hidden = hidden;
	}
	
	
	// Methods
	
	public Room go(String instruction){
		if (neighbors.containsKey(instruction))
			return neighbors.get(instruction);
		else
			return null;
	}
	
	
	public void setneighbors(String instruction, Room neighbor){
		neighbors.put(instruction,neighbor);
	}
	
	public String getCurrentRoom(){
		return this.type;
	}
	
	public abstract void event(Player player);
	
	public boolean isHidden() {	
		return this.hidden;
	}
	
	public void describeRoom() {
		Iterator<Room> it = (neighbors.values()).iterator();
		while(it.hasNext()) {
			Room current = it.next();
			if(!current.isHidden())
				System.out.println("There is a door in the " + current.instruction + " of this room \n");
			else 
				System.out.println("There is a " + instruction.substring(instruction.lastIndexOf(' ')+1) + "in this room"); //behind the wall = wall in this exemple
			it.next();
		}
	}
	
	public void startEvent(Player player){
		this.event(player);
	}

}
	
	

