package dungeon.object;
import dungeon.Dungeon;

/**
 * Class Bombs from package dungeon.object
 * @author guyot clement - cornaire francis
 * Licence 3 Miage - 2015/2016
 */

public class Bombs extends ObjectsCanNotBeTaken {
	
	// Attributes
	
	protected int damage;
	
	// Constructor
	
	/**
	 * The constructor permit to create an object Bombs.
	 * @param name - the name of the bomb.
	 * @param dg - a dungeon.
	 * @param damage - the damages of the bomb.
	 */
	public Bombs(String name,Dungeon dg, int damage){
		super(name,dg); //super permit to use the constructor of the super class (ObjectsCanNotBeTaken
		this.damage = damage;
	}
	
	// Methods
	
	/**
	 * This method permit to get the damages causes by the bomb.
	 * The method doesn't need a parameters.
	 * @return the damages of the bomb.
	 */
	public int getDamage(){
		return this.damage;
	}
	
	/**
	 * This method is to use a bomb.
	 * The method substract to the player's healthpoints the damage of the bomb.
	 * It print a message to the player to inform him he loses healthpoints.
	 */
	public void use(){
		this.dg.getPlayer().setHealthPoints((this.dg.getPlayer().getHealthPoint())-this.damage);
		System.out.println("Its a trapped treasure!");
		System.out.println("The bomb exploded!!!");
		System.out.println(this.dg.getPlayer().getName() + " lost " + this.damage);
	}
	
}
