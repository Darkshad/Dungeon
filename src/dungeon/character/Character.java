package dungeon.character;
import java.util.Random;

import dungeon.object.Weapon;

/**
 * Class Character
 * The class is abstract because some class inherit from this class.
 * This class is used to define a character of the dungeon.
 * @author Guyot Clement - Cornaire Francis
 * Licence 3 Miage - 2015/2016
 */
public abstract class Character {
	
	// Attributes
	
	protected String name;
	protected int healthPoints;
	protected Weapon weapon;
	protected int accuracy;
	
	// Constructor
	
	/**
	 * The constructor permit to create a character
	 * @param name - the name of the character
	 * @param healthPoints - the health points of the character
	 * @param weapon - the weapon of the character to fight other character in the dungeon
	 * @param accuracy - the probability of missing a knock in a fight
	 */
	public Character(String name, int healthPoints, Weapon weapon, int accuracy){
		this.name = name;
		this.healthPoints = healthPoints;
		this.weapon = weapon;
		this.accuracy = accuracy;
	}
	
	// Methods
	
	/**
	 * This method is used to know the name of the character.
	 * @return - the name of the player
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * This method is used to know the weapon of the character. 
	 * @return - the weapon of the character
	 */
	public Weapon getWeapon(){
		return this.weapon;
	}
	
	/**
	 * This method is used to know the health points of the character.
	 * @return - the health points of the character.
	 */
	public int getHealthPoint(){
		return this.healthPoints;
	}
	
	/**
	 * This method is used to know the probability of a character missing his attack.
	 * @return - the accuracy of the character
	 */
	public int getAccuracy(){
		return this.accuracy;
	}
	
	/**
	 * This method is used to change the health points of the player.
	 * It's used when the potion add health points or a character loose points in an attack. 
	 * @param i - the health points.
	 */
	public void setHealthPoints(int i){
		this.healthPoints = i ;
	}
	
	/**
	 * This method permit to change the current weapon of the character.
	 * @param weapon1 - the weapon you want to equip to the character.
	 */
	public void setWeapon(Weapon weapon1){
		this.weapon = weapon1;
	}
	
	/**
	 * This method is used to know if the character is dead or not.
	 * @return True if the character is dead, False either.
	 */
	public boolean isDead(){
		return (this.healthPoints <= 0);
	}
	
	/**
	 * This method is used to simulate an attack.
	 * @param character1 - the character.
	 */
	public void attack(Character character1) {
		int dmg = weapon.getDamage();
		Random rand = new Random();
		
		System.out.println(this.name + " attacked"); 
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(rand.nextInt(100) < this.accuracy) {
			character1.setHealthPoints(character1.getHealthPoint()-dmg);
			
			if (character1.getHealthPoint() < 0)
				character1.setHealthPoints(0);
			
			System.out.println(character1.name + " lost " + dmg +" healths points\n");
		}
		else 
			System.out.println("But he missed\n"); 
	}
	
	/**
	 * This method is abstract because it's used in the inherited class.
	 * It simulate a fight round. 
	 * @param character1
	 * @throws InterruptedException
	 */
	abstract void turn(Character character1) throws InterruptedException;
}
