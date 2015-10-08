package dungeon.character;
import java.util.Random;
import dungeon.object.Weapon;

/**
 * Class monster of the package dungeon.character
 * The class inherit from the super class character.
 * @author Guyot Clement - Cornaire Francis
 * Licence 3 Miage - 2015/2016
 */
public class Monster extends Character {
	
	/**
	 * This constructor permit to create a monster.
	 * @param name - the name of the monster.
	 * @param hP - the health points of the monster.
	 * @param weapon - the weapon of the monster.
	 * @param acc - the probability of the monster to failed his attack.
	 */
	public Monster(String name,int hP,Weapon weapon,int acc) {
		super(name,hP,weapon,acc);
	}
	
	/**
	 * This method permit to the monster to choose to do nothing in a fight round.
	 */
	public void waitMonster() {
		System.out.println(this.name + " choose to do nothing \n");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * This method permit to simulate an attack by the monster.
	 * The monster choose to attack or to do nothing.
	 * The choice of the monster is define by a random.
	 */
	public void turn(Character p) {
		Random rand = new Random();
		int choice = rand.nextInt(2);

		switch (choice) {
		case 1:
			this.attack(p);
			break;
			
		default:
			this.waitMonster();
			break;
		}
	}
}
