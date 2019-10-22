package dungeon;
import java.util.Random;

import textures.EntityTextures;
import textures.k_EntityTextures;

//todo
	//error checking

public class Dungeon implements k_Dungeon {
	
	private k_Room currentRoom;
	private k_EntityTextures roomTexture;

	public Dungeon(short numText) {
		roomTexture = new EntityTextures(numText);
			//this.generateMainRoute(size, texture);
		
		System.out.println("dungeon instance");
	}
	
	@Override
	public void createNewRoom(char x, short textureNum) {
		k_Room newRoom = new Room(false, roomTexture.getTexture(textureNum), (short)0);
		
		// create a new room
		// set the current room as the new rooms adj room
		switch (x)
		{	
			case 'R':
			case 'r':
			{
				currentRoom.setAdjRoom(newRoom, x);
				newRoom.setAdjRoom(currentRoom, 'l');
				System.out.println("new room created- R");
				break;
			}
			case 'L':
			case 'l':
			{
				currentRoom.setAdjRoom(newRoom, x);
				newRoom.setAdjRoom(currentRoom, 'r');
				System.out.println("new room created- L");
				break;
			}
			case 'B':
			case 'b':
			{
				currentRoom.setAdjRoom(newRoom, x);
				newRoom.setAdjRoom(currentRoom, 't');
				System.out.println("new room created- B");
				break;
			}
			case 'T':
			case 't':
			{
				currentRoom.setAdjRoom(newRoom, x );
				newRoom.setAdjRoom(currentRoom, 'b');
				System.out.println("new room created- T");
				break;
			}
			default:
			{
				System.out.println("RoomCreation failed: Dungeon, CreateRoom. Char x = " + x);
			}
		}
	}

	public void generateMainRoute(short size, short textureNum)
	{
		// randomly generate the main route
		k_Room headRoom = new Room(true, roomTexture.getTexture(textureNum), (short)0);
		k_Room nextRoom;
		this.setCurrentRoom(headRoom);
		Random Rand = new Random();
		char prev = 'x';
		short rand = 0;
		
		for(short x = 0; x < size; x++)
		{
			nextRoom = new Room(true, roomTexture.getTexture(textureNum), (short)(x+1));
			while(true){
				
				rand =  ((short) Rand.nextInt(12));
				if(rand >= 0 && rand <= 3 && prev != 'L')
				{
					headRoom.setAdjRoom(nextRoom, 'r');
					nextRoom.setAdjRoom(headRoom, 'l');
					System.out.println("new MAIN room created- R");
					prev = 'R';
					break;
				}
				else if(rand >= 4 && rand <= 6 && prev != 'B' )
				{
					headRoom.setAdjRoom(nextRoom, 't');
					nextRoom.setAdjRoom(headRoom, 'b');
					System.out.println("new MAIN room created- T");
					prev = 'T';
					break;
				}
				else if(rand >= 7 && rand <= 8 && prev != 'T')
				{
					headRoom.setAdjRoom(nextRoom, 'b');
					nextRoom.setAdjRoom(headRoom, 't');
					System.out.println("new MAIN room created- B");
					prev = 'B';
					break;
				}
				else if(rand >= 9 && rand <= 11 && prev != 'R')
				{
					headRoom.setAdjRoom(nextRoom, 'l');
					nextRoom.setAdjRoom(headRoom, 'r');
					System.out.println("new MAIN room created- L");
					prev = 'L';
					break;
				}
			}
			
			headRoom = nextRoom;
		}
		System.out.println("Main route Finished");
	}
	
	public void addRoomTexture(String texture)
	{
		roomTexture.genTexture(texture);
	}
	
	@Override
	public void setCurrentRoom(k_Room CR)
	{
		this.currentRoom = CR;
	}
	
	@Override
	public k_Room getCurrentRoom()
	{
		return this.currentRoom ;
	}
	
	public void removeCurrentRoom()
	{
		this.currentRoom = null;
	}
		
}
