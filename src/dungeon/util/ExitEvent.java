package dungeon.util;

public class ExitEvent implements Event {
	public void start(Player j) {
		System.out.println("Your journey in this dungeon is over,you just arrived to the exit!");
	}

}
