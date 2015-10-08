package dungeon.room;

import dungeon.Dungeon;
import dungeon.character.*;

/**
 * Class MonsterRoom from the package dungeon.room.
 * This class inherit from the super class Room.
 * This class represent the a room with a monster to fight
 * @author Guyot Clement - Cornaire Francis
 * Licence 3 Miage - 2015/2016
 */

public class MonsterRoom extends Room {
	
	//Attributes
	Monster monster;
	
	//Constructor
	/**
	 * This method allow to create an MonsterRoom
	 * @param type - the type of room.
	 * @param hidden - if the room is hidden or not.
	 * @param dungeon - the dungeon which is related.
	 * @param monster - the monster of the room you have to fight
	 */
	public MonsterRoom(String type,boolean hidden,Dungeon dungeon,Monster monster) {
		super(type,hidden,dungeon);
		this.monster = monster;
	}
	
	/**
	 * Get the monster of this room
	 * @return the monster
	 */
	public Monster getMonster() {
		return this.monster;
	}
	
	/**
	 * The event method of this class
	 * It will launch a fight between the player and the monster
	 * It will finish the game if the player loose the fight 
	 */
	public void event() {
		Player player = this.dg.getPlayer();
		if(!this.eventHappened) { // we check first if we didn't fought the monster already
			player.setInFight(true); // we set the player in fight,so he can't use a key in the middle of the fight
			System.out.println("A savage monster appears");
			System.out.println("You have to fight the " + monster.getName() + "\n");
			
			System.out.println(player.getName() + " Hp: " +player.getHealthPoint());
			System.out.println(monster.getName() + " Hp: " +monster.getHealthPoint() + "\n");
			
			while(!monster.isDead() && !player.isDead()) {	// while both of them are alive,
				monster.turn(player); //the monster play his turn 
				
				System.out.println(player.getName() + " Hp: " +player.getHealthPoint());
				System.out.println(monster.getName() + " Hp: " +monster.getHealthPoint() + "\n");
				
				if(!player.isDead()) //if he didn't killed the player in his turn,
					player.turn(monster); //it's the player turn
			}
			 //at the end,one will be dead
			if(monster.isDead()) //if the monster is dead,the player can continue
				System.out.println("You just defeated the monster\n");
			if(player.isDead()) { //if the player is dead,we stop the game
				System.out.println("You got killed by the " + monster.getName() + "\n");
				player.setFinishedGame(true);
			}			
			player.setInFight(false); //the player is no longer in fight here
		}
		else {
			System.out.println("You came in to a room where you killed a monster\n"); //If he already killed the monster,no need to launch the fight again
		}
	
	}
}

