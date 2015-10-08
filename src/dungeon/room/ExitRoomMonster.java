package dungeon.room;

import dungeon.Dungeon;

/**
 * Class ExitRoomMonster from the package dungeon.room.
 * This class inherit from the super class MonsterRoom.
 * This class represent the boss exit of the dungeon.
 * @author Guyot Clement - Cornaire Francis
 * Licence 3 Miage - 2015/2016
 */

public class ExitRoomMonster extends MonsterRoom{

	/**
	 * This method allow to create an exit room with the monster.
	 * @param type - the type of room.
	 * @param hidden - if the room is hidden or not.
	 * @param dungeon - the dungeon which is related.
	 */
	public ExitRoomMonster(String type,boolean hidden,Dungeon dungeon) {
		super(type,hidden,dungeon,dungeon.randomMonst());
	}
	
	/**
	 * The event method of this class
	 * It will finish the dungeon at the end of the fight (event method of super is called, which manage the fight)
	 */
	public void event(){
		System.out.println("You arrived to the exit");
		System.out.println("But it's not over yet");
		super.event();

		this.dg.getPlayer().setFinishedGame(true);
	}
}
