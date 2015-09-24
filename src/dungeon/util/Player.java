package dungeon.util;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import dungeon.Dungeon;

public  class Player extends Character {
	
	// Attributes
	
	protected List<Objects> inventory;
	protected boolean inFight;

	// Constructor

	public Player(String name, int healthPoints, Weapon weapon, int accuracy) {
		super(name, healthPoints, weapon, accuracy);
		inventory = new LinkedList<Objects>();
		inFight = false;
	}

	// Methods

	
	public void changeWeapon(Weapon w1) {
		this.weapon = w1;
	}
	
	// Ramasser les objets 
	public void takeObjects(Objects o) {
		this.inventory.add(o);
	}
	
<<<<<<< HEAD
	
	public List<Objects> getInventory(){
		return this.inventory;
=======
	public void setInFight(boolean etat) {
		this.inFight = etat;
>>>>>>> b4b71b35df517e17f32113d4c1d4535b06cbaa01
	}
	
	// Afficher la liste des objets disponible pour le joueur
	public void printObjects() {
		int i;
		i = 1;
		Iterator<Objects> it = this.inventory.iterator();
		while (it.hasNext()) {
			System.out.println(i + " " + it.next().getName() + "\n");
			i++;
		}
	}

	// Faire un choix dans la liste d'objets.
	public void choiceObjets() {
		System.out.println("Make a choice in the list and tap the number of you're choice\n");
		this.printObjects();
		String line = Dungeon.getCommand();
		try {
			int n = Integer.parseInt(line); // Transformer le choix du joueur en un entier pour recuperer l'objet
			
			this.inventory.get(n).use(this);
		} 	
		catch (NumberFormatException e) {
			System.out.println("You have to choose an object from the list.\n");
			this.choiceObjets();
		}	
		catch(IndexOutOfBoundsException e){
			System.out.println("You have to choose an object from the list\n");
			this.choiceObjets();
		}
		System.out.println("You're choice is : " + line + "\n");
	}

	public void turn(Character character1) {
		System.out.println("What do you want to do ?\n");
		System.out.println("Type 'Attack' to attacq the monster or 'Inventory' to use an item\n");
		String command = Dungeon.getCommand();
		
		while(command != "Attack" || command != "Inventory" ) {
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
	
}
