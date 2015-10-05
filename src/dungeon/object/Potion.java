package dungeon.object;
import dungeon.Dungeon;
import dungeon.character.Player;
public class Potion extends ObjectsCanBeTaken {
	
	// Attributes
	
	protected int soin;
	
	// Constructor
	
	public Potion(String name,Dungeon dg){
		super(name,dg);
		this.soin =  50;
	}
	
	// Methods
	
	public int getPotion() {
		return this.soin;
	}

	public void use(){
		Player p = this.dg.getPlayer();
		p.setHealthPoints(p.getHealthPoint()+this.soin);
		p.getInventory().remove(this);
	}
	
}
