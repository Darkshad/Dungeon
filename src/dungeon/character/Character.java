package dungeon.character;

import java.util.Random;

import dungeon.object.Weapon;

public abstract class Character {
	
	// Attributes
	
	protected String name;
	protected int healthPoints;
	protected Weapon weapon;
	protected int accuracy;
	
	// Constructor
	
	public Character(String name, int healthPoints, Weapon weapon, int accuracy){
		this.name = name;
		this.healthPoints = healthPoints;
		this.weapon = weapon;
		this.accuracy = accuracy;
	}
	
	// Methods
	
	public String getName(){
		return this.name;
	}
	
	public Weapon getWeapon(){
		return this.weapon;
	}
	
	public int getHealthPoint(){
		return this.healthPoints;
	}
	
	public void setHealthPoints(int i){
		this.healthPoints = i ;
	}
	
	public void setWeapon(Weapon weapon1){
		this.weapon = weapon1;
	}
	
	public boolean isDead(){
		return (this.healthPoints <= 0);
	}
	
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
	
	abstract void turn(Character character1) throws InterruptedException;
}
