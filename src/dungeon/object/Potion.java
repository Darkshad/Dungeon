package dungeon.object;
import dungeon.Dungeon;
import dungeon.character.Player;

/**
 * Class Potion from the package dungeon.object
 * The class inherit from the class ObjectsCanBeTaken
 * 
 * @author Guyot Clement - Cornaire Francis
 * Licence 3 Miage - 2015/2016
 */
public class Potion extends ObjectsCanBeTaken {
	
	// Attributes
	
	protected int soin;
	
	// Constructor
	
	/**
	 * This constructor permit to create an object Potion.
	 * @param name - The name of the potion
	 * @param dg - the dungeon
	 */
	public Potion(String name,Dungeon dg){
		super(name,dg);
		this.soin =  50;
	}
	
	// Methods
	
	/**
	 * This method is used to know how much healpoints the potion give to the player.
	 * 
	 * @return the number of healthpoints the potion gives to the player
	 */
	public int getPotion() {
		return this.soin;
	}
	
	/**
	 * This method execute the actions of the potion.
	 * The potion give to player (this.soin) healthpoints.
	 * Next, the potion is removed from the inventory.
	 */
	public void use(){
		Player p = this.dg.getPlayer();
		p.setHealthPoints(p.getHealthPoint()+this.soin);
		p.getInventory().remove(this);
	}
	
}
