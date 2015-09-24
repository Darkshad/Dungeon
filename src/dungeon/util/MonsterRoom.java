package dungeon.util;

public class MonsterRoom extends Room {
	
	//Attributes
	Monster monster;
	
	//Constructor
	public MonsterRoom(String type,String instruction,boolean hidden,Monster monster) {
		super(type,instruction,hidden);
		this.monster = monster;
	}
		
	public void event(Player player) {
		player.setInFight(true);
		if(monster.getHealthPoint() >= 0) {
			System.out.println("A savage monster appears");
			System.out.println("You have to fight the " + monster.getName());
			while(!monster.isDead() || !player.isDead()) {
				monster.turn(player);
				player.turn(monster);
			}
			
			if(monster.isDead()) 
				System.out.println("You just defeated the monster");
			if(player.isDead()) 
				System.out.println("You got killed by the monster");
			
		}
		player.setInFight(false);
	}
}

