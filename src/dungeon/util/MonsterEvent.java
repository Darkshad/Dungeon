package dungeon.util;

public class MonsterEvent implements Event {
		private Monster monster;
		
		//Constructor
		public MonsterEvent(Monster m) {
			this.monster = m;
		}
		
		//Method
		public void start(Player j) {
			if(monster.getHealthPoint() >= 0) {
				System.out.println("A savage monster appears");
				System.out.println("You have to fight a " + monster.getName());
				
				while(!monster.isDead() || !j.isDead()) {
					monster.turn(j);
					j.turn(monster);
				}
				
				if(monster.isDead()) 
					System.out.println("You just defeated a " + monster.getName());
				if(j.isDead()) 
					System.out.println("You got killed by " + monster.getName());
				
			}
			
		}
		
}
