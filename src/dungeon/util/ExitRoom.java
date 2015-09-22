package dungeon.util;

public class ExitRoom extends Room{

	public ExitRoom(String type,String instruction,boolean hidden) {
		super(type,instruction,hidden);
	}

	public void event(Player player){
		System.out.println("Your journey in this dungeon is over,you just arrived to the exit!");
	}
	
}
