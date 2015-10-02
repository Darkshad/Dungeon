package dungeon.room;

import dungeon.character.Player;
import dungeon.Dungeon;

public class ExitRoomMonster extends MonsterRoom{

	
	public ExitRoomMonster(String type,String instruction,boolean hidden) {
		super(type,instruction,hidden,Dungeon.randomMonst());

	}
	
	public void event(Player player){
		System.out.println("You arrived to the exit");
		System.out.println("But it's not over yet");
		super.event(player);

		player.setFinishedGame(true);
	}
}
