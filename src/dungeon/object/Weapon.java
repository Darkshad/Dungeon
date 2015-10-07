package dungeon.object;

import dungeon.Dungeon;
import dungeon.character.Player;


public class Weapon extends ObjectsCanBeTaken{
	
	// Attributes
	
	protected int damage;
	
	// Constructor
	
	public Weapon(String name,Dungeon dg,int damage){
		super(name,dg);
		this.damage = damage;
	}
	
	// Methods
	
	public int getDamage() {
		return this.damage;
	}
	
	public void use(){
		Player p = this.dg.getPlayer();
		p.takeObjects(p.getWeapon());
		p.changeWeapon(this);
		p.getInventory().remove(this);
	}
	
}
