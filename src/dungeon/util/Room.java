package dungeon.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public abstract class Room {
	
	// Attributes
	
	protected final String type;
	protected final String instruction;
	protected final boolean hidden ;
	protected boolean eventHappened;
	protected Map<String,Room> neighbors = new HashMap<String,Room>();
	
	// Constructor
	public Room(String type, String instruction,boolean hidden){
		this.type = type;
		this.instruction = instruction;
		this.hidden = hidden;
		this.eventHappened = false;
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
	
	public String getType(){
		return this.type;
	}
	
	public abstract void event(Player player);
	
	public boolean isHidden() {	
		return this.hidden;
	}
	
	public void describeRoom() {
		Iterator<Room> itRoom = (neighbors.values()).iterator();
		Iterator<String> itInstruction = (neighbors.keySet()).iterator();
		while(itRoom.hasNext() && itInstruction.hasNext()) {
			Room current = itRoom.next();
			String instruction = itInstruction.next();
			if(!current.isHidden())
				System.out.println("There is a door in the " + instruction + " of this room");
			else 
				System.out.println("There is a " + instruction.substring(instruction.lastIndexOf(' ')+1) + "in this room"); //behind the wall = wall in this exemple
			
			if(itRoom.hasNext() && itInstruction.hasNext()) {
				itRoom.next();
				itInstruction.next();
			}
		}
		System.out.println("\n");
	}
	
	public void startEvent(Player player){
		this.event(player);
		if(this.eventHappened == false)
			this.eventHappened = true;
	}

}
	
	

