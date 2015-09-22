package dungeon.util;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public abstract class Player extends Character {
	
	// Attributes
	
	protected List<Objects> inventory;

	// Constructor

	public Player(String name, int healthPoints, Weapon weapon, int accuracy) {
		super(name, healthPoints, weapon, accuracy);
		inventory = new LinkedList<Objects>();
	}

	// Methods

	
	public void changeWeapon(Weapon w1) {
		this.weapon = w1;
	}
	
	// Ramasser les objets 
	public void takeObjects(Objects o) {
		this.inventory.add(o);
	}
	
	// Afficher la liste des objets disponible pour le joueur
	public void printObjects() {
		int i;
		i = 1;
		Iterator<Objects> it = this.inventory.iterator();
		while (it.hasNext()) {
			System.out.println(i + " " + this.name + "\n");
			it.next();
			i++;
		}
	}

	// Faire un choix dans la liste d'objets.
	public void choiceObjets() {
		Scanner sc = new Scanner(System.in); // Creation du scanner qui nous permet de recuperer le choix du joueur
		System.out.println("Make a choice in the list and tap the number of you're choice\n");
		this.printObjects();
		String line = sc.nextLine();
		try {
			int n = Integer.parseInt(line);
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
		sc.close();
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
