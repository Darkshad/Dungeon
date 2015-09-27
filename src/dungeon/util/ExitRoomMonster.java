package dungeon.util;

import dungeon.Dungeon;

public class ExitRoomMonster extends Room{

	private MonsterRoom monsterRoom;
	
	public ExitRoomMonster(String type,String instruction,boolean hidden) {
		super(type,instruction,hidden);
		monsterRoom = new MonsterRoom(type,instruction,hidden,Dungeon.randomMonst());
	}
	
	public void event(Player player){
		System.out.println("You arrived to the exit");
		System.out.println("But it's not over yet");
		this.monsterRoom.event(player);

		player.setFinishedGame(true);
	}
}
