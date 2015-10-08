package dungeon.object;
import dungeon.Dungeon;
import dungeon.character.Player;

/**
 * Class Weapon from package dungeon.object
 * The class inherit from the class ObjectsCanBeTaken
 * @author Guyot Clement - Cornaire Francis
 * Licence 3 Miage - 2015/2016
 */
public class Weapon extends ObjectsCanBeTaken{
	
	// Attributes
	
	protected int damage;
	
	// Constructor
	
	/**
	 * This method permit to create a Weapon
	 * @param name - the name of the weapon
	 * @param dg - the dungeon
	 * @param damage - the damage of the weapon
	 */
	public Weapon(String name,Dungeon dg,int damage){
		super(name,dg);
		this.damage = damage;
	}
	
	// Methods
	
	/**
	 * The method permit to know the damage of the weapon
	 * @return the damage of the weapon
	 */
	public int getDamage() {
		return this.damage;
	}
	
	/**
	 * The method is used to make the actions of the weapon
	 * The method use replace the current weapon of the player in the inventory
	 * Next, it change weapon by selected weapon
	 * Finally it remove from the inventory the new weapon of the player
	 */
	public void use(){
		Player p = this.dg.getPlayer();
		p.takeObjects(p.getWeapon());
		p.setWeapon(this);
		p.getInventory().remove(this);
	}
	
}
