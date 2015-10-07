package dungeon.character;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import dungeon.Dungeon;
import dungeon.object.*;

public  class Player extends Character {
	
	// Attributes
	
	protected List<Objects> inventory;
	protected boolean inFight;
	protected boolean finishedGame;

	// Constructor

	public Player(String name, int healthPoints, Weapon weapon, int accuracy) {
		super(name, healthPoints, weapon, accuracy);
		this.inventory = new LinkedList<Objects>();
		this.inFight = false;
		this.finishedGame = false;
	}

	// Methods

	
	public void changeWeapon(Weapon w1) {
		this.weapon = w1;
	}
	
	// Ramasser les objets 
	public void takeObjects(Objects o) {
		this.inventory.add(o);
	}
	
	
	public List<Objects> getInventory(){
		return this.inventory;
	}

	public boolean getInFight(){
		return this.inFight;
	}
	
	public void setInFight(boolean etat) {
		this.inFight = etat;
	}
	
	
	// Afficher la liste des objets disponible pour le joueur
	public void printObjects() {
		int i;
		i = 1;
		Iterator<Objects> it = this.inventory.iterator();
		while (it.hasNext()) {
			System.out.println(i + " " + it.next().getObjects() + "\n");
			i++;
		}
	}

	// Faire un choix dans la liste d'objets.
	public void choiceObjets() {
		System.out.println("Make a choice in the list and tap the number of you're choice,or tap exit for nothing\n");
		this.printObjects();
		String line = Dungeon.getCommand();
		if(!line.equals("Exit")) {
			try {
				int n = Integer.parseInt(line); // Transformer le choix du joueur en un entier pour recuperer l'objet
				System.out.println("You're choice is : " + this.inventory.get(n-1).getObjects() + "\n");
				this.inventory.get(n-1).use();
			} 	
			catch (NumberFormatException e) {
				System.out.println("You have to choose an object from the list.\n");
				this.choiceObjets();
			}	
			catch(IndexOutOfBoundsException e){
				System.out.println("You have to choose an object from the list\n");
				this.choiceObjets();
			}
		}
		
	}

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
	
	public void setName(String name) {
		this.name = name;
	}

	public void setFinishedGame(boolean statut ) {
		this.finishedGame = statut; 
	}
	
	public boolean finishedTheGame() {
		return this.finishedGame;
	}
	
	public void statut() {
		System.out.println(this.name + " Health points:" + this.healthPoints);
		System.out.println("	weapon equipped: name " + this.weapon.getObjects() + ", Damage " + this.weapon.getDamage() + "\n");
	}
	
}
