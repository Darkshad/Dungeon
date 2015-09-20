package dungeon.util;
public class Potion extends Objects {
	
	// Attributes
	
	protected int soin;
	
	// Constructor
	
	public Potion(String name){
		super(name);
		this.soin =  50;
	}
	
	// Methods
	
	public int getPotion() {
		return this.soin;
	}

	public void use(Player p){
		p.setHealthPoints(p.getHealthPoint()+this.soin);
	}
	
}
