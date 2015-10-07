package dungeon.object;
import dungeon.Dungeon;


public class Bombs extends ObjectsCanNotBeTaken {
	
	// Attributes
	
	protected int damage;
	
	// Constructor
	
	public Bombs(String name,Dungeon dg, int damage){
		super(name,dg);
		this.damage = damage;
	}
	
	// Methods
	
	public int getDamage(){
		return this.damage;
	}
	
	public void use(){
		this.dg.getPlayer().setHealthPoints((this.dg.getPlayer().getHealthPoint())-this.damage);
		System.out.println("Its a trapped treasure!");
		System.out.println("The bomb exploded!!!");
		System.out.println(this.dg.getPlayer().getName() + " lost " + this.damage);
	}
	
}
