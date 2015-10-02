package dungeon.character;

import java.util.Random;
import dungeon.object.Weapon;

public class Monster extends Character {
	
	public Monster(String name,int hP,Weapon weapon,int acc) {
		super(name,hP,weapon,acc);
	}
	
	public void waitMonster() {
		System.out.println(this.name + " choose to do nothing \n");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
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
