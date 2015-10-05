package dungeon.room;
import dungeon.Dungeon;


public class TrapRoom extends Room{

	public TrapRoom(String type,boolean hidden,Dungeon dungeon) {
		super(type,hidden,dungeon);
	}

	public void event() {
		System.out.println("It's a trap");
		this.dg.getPlayer().setHealthPoints(0);
		this.dg.getPlayer().setFinishedGame(true);
	}
	
}
