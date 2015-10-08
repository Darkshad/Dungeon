package dungeon.character;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import dungeon.Dungeon;
import dungeon.object.*;

/**
 * Class Player of the package dungeon.character
 * This class inherit from the super class Character
 * @author Guyot Clement - Cornaire Francis
 * Licence 3 Miage - 2015/2016
 */
public  class Player extends Character {
	
	// Attributes
	
	protected List<Objects> inventory;
	protected boolean inFight;
	protected boolean finishedGame;

	// Constructor

	/**
	 * The constructor permit to create a player.
	 * @param name - the name of the player
	 * @param healthPoints - the health points of the player. 
	 * @param weapon - the weapon of the player.
	 * @param accuracy - the probability of the player to failed his attack.
	 */
	public Player(String name, int healthPoints, Weapon weapon, int accuracy) {
		super(name, healthPoints, weapon, accuracy); // super permit to use the super constructor of the character class.
		this.inventory = new LinkedList<Objects>(); // we used a linked list to access to the element with their index.
		this.inFight = false; // At the beginning the player is not in fight with a monster.
		this.finishedGame = false;
	}

	// Methods

	/**
	 * This method permit to a player to take an object from a treasure in his inventory. 
	 * @param o - the object
	 */
	public void takeObjects(Objects o) {
		this.inventory.add(o);
	}
	
	/**
	 * This method permit to know what the player has in his inventory.
	 * @return the list of objects the player has in his inventory.
	 */
	public List<Objects> getInventory(){
		return this.inventory;
	}
	
	/**
	 * This method permit to know if a player is in fight or not
	 * @return True if a player is in fight, False either.
	 */
	public boolean getInFight(){
		return this.inFight;
	}
	
	/**
	 * This method permit to change the attributes inFight
	 * The attributes takes the value of the parameter etat.
	 * If the player meet a monster the attributes switch on true and if he defeat the monster the attributes switch on false.
	 * At the beginning the attributes is on false.
	 * @param etat - the new value of the attributes inFight
	 */
	public void setInFight(boolean etat) {
		this.inFight = etat;
	}
	
	
	/**
	 * This method is used to print the inventory in the console.
	 * The player can see what he has in his inventory.
	 */
	public void printObjects() {
		int i;
		i = 1;
		Iterator<Objects> it = this.inventory.iterator();
		while (it.hasNext()) {
			System.out.println(i + " " + it.next().getObjects() + "\n");
			i++;
		}
	}

	
	/**
	 * This method permit to the player to make a choice in the inventory.
	 */
	public void choiceObjets() {
		System.out.println("Make a choice in the list and tap the number of you're choice,or tap exit for nothing\n");
		this.printObjects();
		String line = Dungeon.getCommand(); // This line get the command the player tap on the keyboard
		if(!line.equals("Exit")) {
			try {
				int n = Integer.parseInt(line); // Change the choice of the player (string) in an integer.
				System.out.println("You're choice is : " + this.inventory.get(n-1).getObjects() + "\n");
				this.inventory.get(n-1).use();
			} 	
			catch (NumberFormatException e) { // This exception is throw if the player tap a letter or punctuation.
				System.out.println("You have to choose an object from the list.\n");
				this.choiceObjets();
			}	
			catch(IndexOutOfBoundsException e){ // This exception is throw if the player tap a number < 0 or > list size.
				System.out.println("You have to choose an object from the list\n");
				this.choiceObjets();
			}
		}
		
	}
	
	/**
	 * This method permit to simulate a fight round for a player.
	 */
	public void turn(Character character1) {
		System.out.println("What do you want to do ?\n");
		System.out.println("Type 'Attack' to attack the monster or 'Inventory' to use an item\n");
		String command = Dungeon.getCommand();
		
		while(!command.equals("Attack") && !command.equals("Inventory") ) {
			System.out.println("You have to choose a valide commande \n");
			command = Dungeon.getCommand();
		}
		
		if (command.equals("Attack"))
				this.attack(character1);
		else
				this.choiceObjets();
	}
	
	/**
	 * This method permit to change the name of the player
	 * @param name - the name of the player
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method permit to change the attributes when the game is finish
	 * @param statut - the statut of the game.
	 */
	public void setFinishedGame(boolean statut ) {
		this.finishedGame = statut; 
	}
	
	/**
	 * This method permit to know if the game is finish or not.
	 * @return True if the game is finished, false either.
	 */
	public boolean finishedTheGame() {
		return this.finishedGame;
	}
	
	/**
	 * This method is used to know the situation of the player during the game.
	 */
	public void statut() {
		System.out.println(this.name + " Health points:" + this.healthPoints);
		System.out.println("	weapon equipped: name " + this.weapon.getObjects() + ", Damage " + this.weapon.getDamage() + "\n");
	}
	
}
