package dungeon.object;
import dungeon.character.Player;

public class Bombs extends Objects {
	
	// Attributes
	
	protected int damage;
	
	// Constructor
	
	public Bombs(String name, int damage){
		super(name);
		this.damage = damage;
	}
	
	// Methods
	
	public void use(Player p){
		p.setHealthPoints(p.getHealthPoint()-this.damage);
	}
	
}
