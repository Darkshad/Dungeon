package dungeon.util;

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
	
	public void attack(Character character1){
		 this.healthPoints -= character1.getWeapon().getDamage();
	}
	
	abstract void turn(Character character1);
}
