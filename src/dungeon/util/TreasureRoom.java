package dungeon.util;

public class TreasureRoom extends Room {

		//Attribut
	private Objects obj;
				
	//Constructor 
	public TreasureRoom (String type,String instruction,boolean hidden,Objects o) {
		super(type,instruction,hidden);
		this.obj = o;
	}
				
	public void event(Player j) {
		System.out.println("You found a treasure \n");
		System.out.println("It's a" + obj.getName());
		j.takeObjects(this.obj);
		}
	}


