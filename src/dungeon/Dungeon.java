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
	
	/**
	 * Get the player of this dungeon
	 * @return the player 
	 */
	public Player getPlayer() {
		return this.player;
	}
	
	/**
	 * Set the player of this dungeon
	 */
	public void setPlayer(Player p) {
		this.player = p;
	}
	
	/**
	 * Set the current room of this dungeon
	 */
	public void setCurrentRoom(Room r) {
		this.currentRoom = r;
	}
	
	/**
	 * Get the current room of this dungeon
	 * @return the current room
	 */
	public Room getCurrentRoom() {
		return this.currentRoom;
	}
	
	/**
	 * Allows the user to write in the console
	 * @return the line tapped by the user as a String
	 */
	public static String getCommand() {
		String line = scannerCommand.nextLine();
		String res = line;
		return res;
	}
		
	/**
	 * Change the name of the character. 
	 * This method is only use once after the dungeon is created
	 * @return the line tapped by the user as a String
	 */
	public void changeName() {
		String name = Dungeon.getCommand();
		player.setName(name);
		System.out.println("The name of your character will be " + name);
	}
	
	/**
	 * Returns a new monster with random statistics
	 * @return the monster with his random statistics
	 */
	public Monster randomMonst() {
		return new Monster("Troll",rand.nextInt(200)+20,(new Weapon("Sword",this,rand.nextInt(75)+15)),rand.nextInt(90)+10);		
	}
	
	/**
	 * Make randomly new hidden room at most nbHid for the room passed in parameter 
	 * @param room The room we are making randomly hidden room
	 * @param nbHid the maximum number of the room which can be created
	 */
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
	
	/**
	 * Link the 2 room given in parameter following the model of the link: Ouest-Est and the else for North-South 
	 * @param r1 The room which will be at the Ouest or the South for r2
	 * @param r2 The room which will be at the Est or the North for r1
	 * @param model The model for the link (Ouest-Est and the else for North-South)
	 */
		private void linkRoom(Room r1,String model,Room r2) {
			if (model == "Ouest-Est") {
					r1.setneighbors("Est", r2);
					r2.setneighbors("Ouest", r1);	
			}
			else if (model == "North-South")  {
				r1.setneighbors("North", r2);
				r2.setneighbors("South", r1);	
			}
			else throw new IllegalArgumentException("model incorrect");
		}
		
		/**
		 * Link all i and i+1 room contained in the tab with the method "linkRoom" with the model Ouest-Est
		 * @param tab The table room with the room we are linking
		 */
		private void linkRoomTabLine(Room[] tab) {
			for(int i = 0; i <= tab.length-2;i++) {
				if(tab[i] != null && tab[i+1] != null) {
					linkRoom(tab[i],"Ouest-Est",tab[i+1]);
				}
			}
		}
		
		/**
		 * Link all i room contained in the 2 table with the method "linkRoom" with the model North-South
		 * @param tab1 the table of room which will be at the South of room in tab2
		 * @param tab2 the table of room which will be at the North of room in tab1
		 */
		private void linkRoomTabCol(Room[] tab1,Room[] tab2) {
			for (int i = 0;i <= tab1.length-1;i++) {
				if(tab1[i] != null && tab2[i] != null)
					linkRoom(tab1[i],"North-South",tab2[i]);
			}
		}
		
		/**
		 * Read a txt file which contains the model of the dungeon we want to create and the return it if successfully loaded
		 * @param pathLvl the path for the file we are loading
		 * @return the level loaded as a FileReader
		 */
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
		
		/**
		 * Search for the entrance Room in the table tab in parameter. If found,return it;else null
		 * @param tab the table of room which we searching for the entrance 
		 * @return the room if found,else null
		 */
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
		
		/**
		 * Create the dungeon with the model of the file at the path given in parameter.
		 * This mean all the letter in the file are the room we are making;if they are close,we will link them (in line,Ouest-Est and in column North-South)
		 * The current Room is also set,its the entrance Room which would be found while making the dungeon
		 * @param pathLvl the path for the file we are loading
		 */
		public void createDungeon(String pathLvl) throws IOException {
			BufferedReader buffer = new BufferedReader(loadLevel(pathLvl)); //read the file
			String line = buffer.readLine(); //read the line
			EntranceRoom ent = null; 
			
			Room[] tabRoom = new Room[Integer.parseInt(line)]; //The first number is the length of the table we are initializing
			Room[] tmp = new Room[tabRoom.length]; //init another room table which will be used for copying tabRoom and then for linking room North-South
			
			line = buffer.readLine();
			int nbLine = Integer.parseInt(line); //The second number (line 2) is the number of the line of the dungeon
			
			for(int i = 0;i <= nbLine-1;i++) { //for all remaining line 
				line = buffer.readLine(); //took the next line
				initTabRoom(tabRoom,line); //init the room table with the correspondance letters-Room
				
				linkRoomTabLine(tabRoom); //Link room in the table following the model Ouest-Est
				if(i != 0) //This is just to not try to link with the first tmp full of null room
					linkRoomTabCol(tabRoom,tmp); //Link room in the table following the model North-South
				
				if(ent == null)
					ent = searchEntranceRoom(tabRoom); //We are searching for the entrance at each line until we found it
				
				System.arraycopy(tabRoom, 0, tmp , 0, tabRoom.length); //We make a copy of each Room in tabRoom, in tmp so we can make the link North-South for the next line
			}

			this.currentRoom = ent; 
		}
		
		/**
		 * Interpret the text tapped by user and launch the corresponding method 
		 */
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
		
		/**
		 * Change the current room depending of which direction selected by the user
		 * We also push the precedent current room in the stack of room Crossed for eventually going back later 
		 */
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

		/**
		 * Change the current room with the top of the stack of room Crossed early  
		 */
		 public void goBack() {
			 if(this.roomCrossed.isEmpty()) 
				 System.out.println("You can't go back more");
			 else 
				 this.currentRoom = this.roomCrossed.pop();
		 }
		 
		/**
		* Return a random string following the very small dictionary
		* @return the instruction randomly maked
		*/
		 public String randomInstruction() {
			 String[] word1 = {"behind","above","below"};
			 String[] word2 = {"table","wall","carpet"};
			 String instruction = new String(word1[rand.nextInt(3)] + " the " + word2[rand.nextInt(3)]);
			 return instruction;
		 }
		 
		 /**
		  * The main method: the game is launched until it finished by any other event (event of the trap room which instant kill the player,event of the exit room,...)
		  */
		public void start() {
			while (!player.finishedTheGame()) { //while the game is not finished 
				currentRoom.startEvent(); //we launch the event of the currentRoom 
				if(!player.finishedTheGame()) //if still alive,we interpret the next command the user tapped
					interpretCommand();
			}
			if(!player.isDead()){ //at the end,if the player is dead,it's a game over else,that means he finished the dungeon(that mean he actually finished the event of the exit Room of the current dungeon)
				System.out.println("***Well played***");
				System.out.println("You finished this dungeon\n");
				player.setFinishedGame(false);
			}
			else
				System.out.println("***Game Over***\n");
			

		}
		
		 /**
		  * The main: it will start a new dungeon until we arrive at the last dungeon
		  */		
		public static void main(String [] args) throws IOException{
			Dungeon dg = new Dungeon();
			Player p1 = new Player("",150,new Weapon("sword",dg,Dungeon.rand.nextInt(30)+20),60);
			dg.setPlayer(p1);
			int level = 1; //this variable is for loading levels
			System.out.println("***Welcome to Dungeon,the most epic game ever!!***\n");
			System.out.println("Rule are simple:");
			System.out.println("	you start the game at the entrance of the dungeon and you have to go the exit");
			System.out.println("	ther are many room (monster,treasure,even trap!!) before the exit");
			System.out.println("	once you got the exit,another dungeon will start");
			System.out.println("	you have to do this until you arrive at the exit of the last to become the true hero");
			System.out.println("	but watch out,anything can happen!");
			System.out.println("	there can be hidden room,for example try to go under or above or behind a table if you find one to see what will happen....\n");
			System.out.println("***First,choose the name of your character***");
			dg.changeName(); //we change the name of the character but it's called only here,so it's make looks it the first time we naming the character
			System.out.println("The game will start now,i hope you are ready....");
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			while(level != 6 && !p1.isDead()) { //we made 5 levels for the dungeon
				System.out.println("Level" + level);
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				dg.createDungeon("levels/Level" + level); //we load the dungeon depending of the variable level: level1 will be load if level = 1 or level2 if level = 2,.....
				dg.start(); //the dungeon start
				level += 1; //here,the dungeon is finished,so we are incrementing level to move to next level
			}
			if(!p1.isDead()) { 
				System.out.println("***Congratulations,you finished the game!***");
				System.out.println("You are now a true hero");
			}
			Dungeon.scannerCommand.close(); 
		}
	}
	