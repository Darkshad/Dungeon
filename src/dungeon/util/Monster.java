package dungeon.util;

import java.util.Random;

public class Monster extends Character {
	
	public Monster(String name,int hP,Weapon weapon,int acc) {
		super(name,hP,weapon,acc);
	}
	
	public void waitMonster() {
		System.out.println("Monster choose to do nothing");
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
