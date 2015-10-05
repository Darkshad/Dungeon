package dungeon.room;

import dungeon.Dungeon;

public class ExitRoomMonster extends MonsterRoom{

	
	public ExitRoomMonster(String type,boolean hidden,Dungeon dungeon) {
		super(type,hidden,dungeon,dungeon.randomMonst());
	}
	
	public void event(){
		System.out.println("You arrived to the exit");
		System.out.println("But it's not over yet");
		super.event();

		this.dg.getPlayer().setFinishedGame(true);
	}
}
