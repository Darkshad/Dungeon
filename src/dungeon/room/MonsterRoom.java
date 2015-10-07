package dungeon.room;

import dungeon.Dungeon;
import dungeon.character.*;

public class MonsterRoom extends Room {
	
	//Attributes
	Monster monster;
	
	//Constructor
	public MonsterRoom(String type,boolean hidden,Dungeon dungeon,Monster monster) {
		super(type,hidden,dungeon);
		this.monster = monster;
	}
	
	public Monster getMonster() {
		return this.monster;
	}
		
	public void event() {
		Player player = this.dg.getPlayer();
		if(!this.eventHappened) {
			player.setInFight(true);
			System.out.println("A savage monster appears");
			System.out.println("You have to fight the " + monster.getName() + "\n");
			
			System.out.println(player.getName() + " Hp: " +player.getHealthPoint());
			System.out.println(monster.getName() + " Hp: " +monster.getHealthPoint() + "\n");
			
			while(!monster.isDead() && !player.isDead()) {				
				monster.turn(player);
				
				System.out.println(player.getName() + " Hp: " +player.getHealthPoint());
				System.out.println(monster.getName() + " Hp: " +monster.getHealthPoint() + "\n");
				
				if(!player.isDead())
					player.turn(monster);
			}
			
			if(monster.isDead()) 
				System.out.println("You just defeated the monster\n");
			if(player.isDead()) {
				System.out.println("You got killed by the " + monster.getName() + "\n");
				player.setFinishedGame(true);
			}			
			player.setInFight(false);
		}
		else {
			System.out.println("You came in to a room where you killed a monster\n");
		}
	
	}
}

