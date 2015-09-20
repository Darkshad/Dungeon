package dungeon.util;

public class TreasureEvent implements Event {
		//Attribut
		private Objects obj;
		
		//Constructor 
		public TreasureEvent (Objects o) {
			this.obj = o;
		}
		
		public void start(Player j) {
				System.out.println("You found a treasure \n");
				System.out.println("It's a" + obj.getName());
				j.takeObjects(this.obj);
		}

}
