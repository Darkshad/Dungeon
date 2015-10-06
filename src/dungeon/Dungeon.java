package dungeon;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

import dungeon.character.*;
import dungeon.room.*;
import dungeon.object.*;

public class Dungeon {
	Player player;
	Room currentRoom;
	static Scanner scannerCommand = new Scanner(System.in); 
	static Random rand = new Random();
	private Stack<Room> roomCrossed = new Stack<Room>();
	


	//Methods
	public Player getPlayer() {
		return this.player;
	}
	
	public void setPlayer(Player p) {
		this.player = p;
	}
	
	public void setCurrentRoom(Room r) {
		this.currentRoom = r;
	}
	
	public Room getCurrentRoom() {
		return this.currentRoom;
	}
	
	public static String getCommand() {
		String line = scannerCommand.nextLine();
		String res = line;
		return res;
	}
		
	public void changeName() {
		String name = Dungeon.getCommand();
		player.setName(name);
		System.out.println("The name of your character will be " + name);
	}
	
	public Monster randomMonst() {
		return new Monster("Troll",rand.nextInt(200)+20,(new Weapon("Sword",this,rand.nextInt(75)+15)),rand.nextInt(90)+10);		
	}
	
	public void randomHiddenRoom(Room room,int nbHid){
		for(int i = 0;i<nbHid;i++) {
			if(Dungeon.rand.nextInt(4) == 0) {
				switch(Dungeon.rand.nextInt(5)) {
				case 0:
					room.setneighbors(this.randomInstruction(),new TrapRoom("Trap",true,this));
					break;
				case 1:
					room.setneighbors(this.randomInstruction(),new TreasureRoom("Treasure",true,this, (new Potion("Potion",this))));
					break;
				case 2:
					room.setneighbors(this.randomInstruction(),new TreasureRoom("Treasure",true,this, (new Bombs("Bombe",this,rand.nextInt(30)+10))));
					break;
				case 3:
					room.setneighbors(this.randomInstruction(),new TreasureRoom("Treasure",true,this, (new Weapon("Heavy Blade",this,rand.nextInt(150)+50))));
					break;
				default:
					room.setneighbors(this.randomInstruction(),  new MonsterRoom("Monster",true,this, this.randomMonst()));
				}
			}
		}
	}
	
	/**
	 * Init a Room table following the model in the string
	 * This method use this representation for initializing the table:
	 * 		E - EntranceRoom
	 * 		T - TrapRoom
	 * 		U - TreasureRoom with a potion
	 * 	 	V - TreasureRoom with a key
	 * 		W - TreasureRoom with a bomb
	 * 	 	X - TreasureRoom with a weapon
	 * 		M - MonsterRoom
	 * 		I - IntersectionRoom
	 * 		O - ExitRoom
	 * 		P - ExitRoomMonster
	 * 	  	Q - KeyRoom
	 * 		0 - null
	 *
	 * @param  tabRoom  The Room table we are initializing
	 * @param  line  the model the Room table is using
	 */
	private void initTabRoom(Room[] tabRoom,String line){
		for (int i = 0;i <= tabRoom.length-1; i++) {
			switch (line.charAt(i)) {
				case 'E':
					tabRoom[i] = new EntranceRoom("Entrance",false,this);
					break;
				case 'T':
					tabRoom[i] = new TrapRoom("Trap",false,this);
					break;
				case 'U':
					tabRoom[i] = new TreasureRoom("Treasure",false,this, (new Potion("Potion",this)));
					break;
				case 'V':
					tabRoom[i] = new TreasureRoom("Treasure",false,this, (new Key("Key",this)));
					break;
				case 'W':
					tabRoom[i] = new TreasureRoom("Treasure",false,this, (new Bombs("Bombe",this,rand.nextInt(30)+10)));
					break;
				case 'X':
					tabRoom[i] = new TreasureRoom("Treasure",false,this, (new Weapon("Sword",this,rand.nextInt(100)+10)));
					break;
				case 'M':
					tabRoom[i] = new MonsterRoom("Monster",false,this, this.randomMonst());
					break;
				case 'I':
					tabRoom[i] = new IntersectionRoom("Intersection",false,this);
					break;
				case 'O':
					tabRoom[i] = new ExitRoom("Exit",false,this);
					break;
				case 'P':
					tabRoom[i] = new ExitRoomMonster("ExitRoomMonster",false,this);
					break;
				case 'Q':
					tabRoom[i] = new KeyRoom("KeyRoom",false,this);
					break;
				case '0':
					tabRoom[i] = null;
					break;
			}
			if(tabRoom[i] != null)
				this.randomHiddenRoom(tabRoom[i], Dungeon.rand.nextInt(3));
		}
	}
		
		private void linkRoom(Room r1,char c,Room r2) {
			if (c == 'O') {
					r1.setneighbors("Est", r2);
					r2.setneighbors("Ouest", r1);	
			}
			else {
				r1.setneighbors("North", r2);
				r2.setneighbors("South", r1);	
			}
			
		}
		
		private void linkRoomTabLine(Room[] tab) {
			for(int i = 0; i <= tab.length-2;i++) {
				if(tab[i] != null && tab[i+1] != null) {
					linkRoom(tab[i],'O',tab[i+1]);
				}
			}
		}
		
		private void linkRoomTabCol(Room[] tab1,Room[] tab2) {
			for (int i = 0;i <= tab1.length-1;i++) {
				if(tab1[i] != null && tab2[i] != null)
					linkRoom(tab1[i],'N',tab2[i]);
			}
		}
		
		private FileReader loadLevel(String pathLvl) {
			FileReader fil = null;
			try {
				 fil = new FileReader(pathLvl);
			} catch (FileNotFoundException e) {
				System.out.println("Dungeon.loadLevel : file not found\n");
				e.printStackTrace();
			}
			return fil;	
		}
		
		private EntranceRoom searchEntranceRoom(Room[] tab) {
			int i = 0;
			while(i <= tab.length-1 ) {
				if(tab[i] != null) {
					if(tab[i].getType().equals("Entrance") ) {
						return (EntranceRoom) tab[i];
					}
				}
				i += 1;
			}
			return null;
		}
		
		public void createDungeon(String pathLvl) throws IOException {
			BufferedReader buffer = new BufferedReader(loadLevel(pathLvl)); //read the file
			String line = buffer.readLine();
			EntranceRoom ent = null;
			
			Room[] tabRoom = new Room[Integer.parseInt(line)]; //init a room table with the first line of the file
			Room[] tmp = new Room[tabRoom.length];
			
			line = buffer.readLine();
			int nbLigne = Integer.parseInt(line); //init a var with number of line in the file
			
			for(int i = 0;i <= nbLigne-1;i++) {
				line = buffer.readLine(); //took the first line
				initTabRoom(tabRoom,line); //init the room table with the correspondance letters-Room 
				
				linkRoomTabLine(tabRoom); //Link room in the table following the line scheme in the file
				if(i != 0) //This is just to not try to link with the first tmp full of null room
					linkRoomTabCol(tabRoom,tmp); //Link room in the table following the colonne scheme(last line is saved for that in tmp) in the file
				
				if(ent == null)
					ent = searchEntranceRoom(tabRoom);
				
				System.arraycopy(tabRoom, 0, tmp , 0, tabRoom.length);
			}

			this.currentRoom = ent;
		}
		
	
		public void interpretCommand() {
			System.out.println("What do you want to do ?\n");
			System.out.println("		type 'Go' to choose a room to go\n");
			System.out.println("		type 'Description' to have a description of this room\n");
			System.out.println("		type 'Inventory' to open the inventory and choose a object\n");
			System.out.println("		type 'GoBack' to return to the previous room \n");
			System.out.println("		type 'Statut' to see your character statut \n");
			boolean commandIsValid = false;
			while (!commandIsValid) {
				switch(Dungeon.getCommand()) {
				case "Go":
					this.go();
					commandIsValid = true;
					break;
				case "Description": 
					currentRoom.describeRoom();
					commandIsValid = true;
					break;
				case "Inventory":
					player.choiceObjets();
					commandIsValid = true;
					break;
					
				case "GoBack":
					this.goBack();
					commandIsValid = true;
					break;
					
				case "Statut":
					this.player.statut();
					commandIsValid = true;
					break;
					
				default:
					System.out.println("Incorrect! Choose a command between 'go','Description','Inventory','GoBack' or 'Statut'\n");
				}
			}
			
		}
		
		 private void go() {
			System.out.println("Where do you want to go ?\n");
			Room next;
			String com;
			
			boolean commandIsValid = false;
			while(!commandIsValid) {
				com = Dungeon.getCommand();
				next = currentRoom.go(com);
				if (next == null) {
					System.out.println("Invalid direction! 'goBack' for going back or choose a valid direction to go to the next room you want:\n");
					currentRoom.describeRoom();
				}
				else {
					this.roomCrossed.push(currentRoom);
					currentRoom = next;
					commandIsValid = true;
				}
			}
		}

		 public void goBack() {
			 if(this.roomCrossed.isEmpty()) 
				 System.out.println("You can't go back more");
			 else 
				 this.currentRoom = this.roomCrossed.pop();
		 }
		 
		 public String randomInstruction() {
			 String[] word1 = {"behind","above","below"};
			 String[] word2 = {"table","wall","carpet"};
			 String instruction = new String(word1[rand.nextInt(3)] + " the " + word2[rand.nextInt(3)]);
			 return instruction;
		 }
		 
		public void start() {
			while (!player.finishedTheGame()) {
				currentRoom.startEvent();
				if(!player.finishedTheGame())
					interpretCommand();
			}
			if(!player.isDead()){
				System.out.println("***Well played***");
				System.out.println("You finished this dungeon\n");
				player.setFinishedGame(false);
			}
			else
				System.out.println("***Game Over***\n");
			

		}
		
		public static void main(String [] args) throws IOException{
			Dungeon dg = new Dungeon();
			Player p1 = new Player("",150,new Weapon("sword",dg,Dungeon.rand.nextInt(30)+20),60);
			dg.setPlayer(p1);
			int level = 1;
			System.out.println("***Welcome to Dungeon,the most epic game ever!!***\n");
			System.out.println("Rule are simple:");
			System.out.println("	you start the game at the entrance of the dungeon and you have to go the exit");
			System.out.println("	ther are many room (monster,treasure,even trap!!) before the exit");
			System.out.println("	once you got the exit,another dungeon will start");
			System.out.println("	you have to do this until you arrive at the exit of the last to become the true hero");
			System.out.println("	but watch out,anything can happen!");
			System.out.println("	there can be hidden room,for example try to go under or above or behind a table if you find one to see what will happen....\n");
			System.out.println("***First,choose the name of your character***");
			dg.changeName();
			System.out.println("The game will start now,i hope you are ready....");
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			while(level != 6 && !p1.isDead()) {
				System.out.println("Level" + level);
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				dg.createDungeon("levels/Level" + level);
				dg.start();
				level += 1;
			}
			if(!p1.isDead()) {
				System.out.println("***Congratulations,you finished the game!***");
				System.out.println("You are now a true hero");
			}
			Dungeon.scannerCommand.close(); 
		}
	}
	