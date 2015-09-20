package dungeon.util;

import java.util.HashMap;
import java.util.Map;


public class Room {
	
	// Attributes
	
	protected final String type;
	protected final String instruction;
	protected Event e1;
	protected Map<String,Room> neighbors = new HashMap<String,Room>();
	
	// Constructor
	public Room(String type, String instruction, Event e1){
		this.type = type;
		this.instruction = instruction;
		this.e1 = e1;
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
	
	public void startEvent(Player p1){
		e1.start(p1);
	}

}
	
	

