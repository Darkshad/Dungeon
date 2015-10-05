package dungeon.room;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import dungeon.Dungeon;



public abstract class Room {
	
	// Attributes
	
	protected final String type;
	protected boolean hidden ;
	protected boolean eventHappened;
	protected Dungeon dg;
	protected Map<String,Room> neighbors = new HashMap<String,Room>();
	
	// Constructor
	public Room(String type,boolean hidden,Dungeon dungeon){
		this.type = type;
		this.hidden = hidden;
		this.eventHappened = false;
		this.dg = dungeon;
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
	
	public Map<String,Room> getNeighbors() {
		return this.neighbors;
	}
	
	public String getType(){
		return this.type;
	}
	
	public abstract void event();
	
	public boolean isHidden() {	
		return this.hidden;
	}
	
	public void nowHidden() {
		this.hidden = true;
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
				System.out.println("There is a " + instruction.substring(instruction.lastIndexOf(' ')+1) + " in this room"); //behind the wall = wall in this exemple
			
		}
	}
	
	public void startEvent(){
		this.event();
		if(this.eventHappened == false)
			this.eventHappened = true;
	}

	public boolean isLocked() {
		return false;
	}

	public void unlock() {
	}

	
}
	
	

