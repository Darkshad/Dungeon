package dungeon.room;
import dungeon.character.Player;

public class TrapRoom extends Room{

	public TrapRoom(String type,String instruction,boolean hidden) {
		super(type,instruction,hidden);
	}

	public void event(Player player) {
		System.out.println("It's a trap");
		player.setHealthPoints(0);
	}
	
}
