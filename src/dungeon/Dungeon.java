package dungeon;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import dungeon.util.*;

public class Dungeon {
	Player player;
	Room currentRoom;
	
	//Constructor
	public Dungeon(Player player) {
		this.player = player;
	}

	//Methods
	public void setCurrentRoom(Room r) {
		this.currentRoom = r;
	}
	
	public Room getCurrentRoom() {
		return this.currentRoom;
	}
	
	public String getCommand() {
		Scanner sc = new Scanner(System.in); 
		String line = sc.nextLine();
		sc.close();
		return line;
	}
	
	public void changeName() {
		System.out.println("Please,choose the name of your character\n");
		String name = this.getCommand();
		player.setName(name);
	}
	
	private Monster randomMonst() {
		Random rand = new Random();
		return new Monster("Troll",rand.nextInt(200),(new Weapon("Sword",rand.nextInt(75))),rand.nextInt(101));		
	}
	
	private void initTabRoom(Room[] tabRoom,String line){
		for (int i = 0;i <= tabRoom.length-1; i++) {
			switch (line.charAt(i)) {
				case 'E':
					tabRoom[i] = new EntranceRoom("Entrance"," ",false);
					break;
				case 'T':
					tabRoom[i] = new TrapRoom("Trap"," ",false);
					break;
				case 'B':
					tabRoom[i] = new TreasureRoom("Treasure"," ",false, (new Potion("Potion")));
					break;
				case 'M':
					tabRoom[i] = new MonsterRoom("Monster"," ",false, randomMonst());
					break;
				case 'I':
					tabRoom[i] = new IntersectionRoom("Intersection"," ",false);
					break;
				case 'O':
					tabRoom[i] = new ExitRoom("Exit"," ",false);
					break;
				case '0':
					tabRoom[i] = null;
					break;
				default:
					System.out.println("Dungeon.initTabRoom : incorrect character \n");
			}
		}
	}
		
		private void linkRoom(Room r1,char c,Room r2) {
			if (c == 'O') {
					r1.setneighbors("Est", r2);
					r2.setneighbors("Ouest", r1);	
			}
			else if (c == 'N') {
				r1.setneighbors("North", r2);
				r2.setneighbors("South", r1);	
			}
			
			else
				System.out.println("Dungeon.LinkRoom : invalid character \n");
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
				if(tab[i] instanceof EntranceRoom ) {
					return (EntranceRoom) tab[i];
				}
				else
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
		
	}
	

	
	
