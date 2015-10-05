package dungeon.room;
import dungeon.Dungeon;


public class ExitRoom extends Room{

	public ExitRoom(String type,boolean hidden,Dungeon dungeon) {
		super(type,hidden,dungeon);
	}

	public void event(){
		System.out.println("Your journey in this dungeon is over,you just arrived to the exit!");
		this.dg.getPlayer().setFinishedGame(true);
	}
	
}
