package dungeon.util;

public class MonsterRoom extends Room {
	
	//Attributes
	Monster monster;
	
	//Constructor
	public MonsterRoom(String type,String instruction,boolean hidden,Monster monster) {
		super(type,instruction,hidden);
		this.monster = monster;
	}
	
	public Monster getMonster() {
		return this.monster;
	}
		
	public void event(Player player) {
		player.setInFight(true);
		if(!this.eventHappened) {
			System.out.println("A savage monster appears");
			System.out.println("You have to fight the " + monster.getName() + "\n");
			
			System.out.println(player.name + " Hp: " +player.getHealthPoint());
			System.out.println(monster.name + " Hp: " +monster.getHealthPoint() + "\n");
			
			while(!monster.isDead() && !player.isDead()) {				
				monster.turn(player);
				
				System.out.println(player.name + " Hp: " +player.getHealthPoint());
				System.out.println(monster.name + " Hp: " +monster.getHealthPoint() + "\n");
				
				if(!player.isDead())
					player.turn(monster);
			}
			
			if(monster.isDead()) 
				System.out.println("You just defeated the monster\n");
			if(player.isDead()) {
				System.out.println("You got killed by the " + monster.getName() + "\n");
				player.setFinishedGame(true);
			}			
		}
		else {
			System.out.println("You came in to a room where you killed a monster\n");
		}
		
		player.setInFight(false);
	}
}

