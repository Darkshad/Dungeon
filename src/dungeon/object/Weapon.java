package dungeon.object;

import dungeon.character.Player;


public class Weapon extends Objects {
	
	// Attributes
	
	protected int damage;
	
	// Constructor
	
	public Weapon(String name, int damage){
		super(name);
		this.damage = damage;
	}
	
	// Methods
	
	public int getDamage() {
		return this.damage;
	}
	
	public void use(Player p){
		p.takeObjects(p.getWeapon());
		p.changeWeapon(new Weapon(this.name,this.damage));
		p.getInventory().remove(this);
	}
	
}
