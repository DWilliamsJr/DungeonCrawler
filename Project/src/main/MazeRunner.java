package main;

import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;

import controls.Keyboard;
import dungeon.Dungeon;
import dungeon.ItemSpawner;
import dungeon.MobSpawner;
import dungeon.k_Dungeon;
import dungeon.k_Room;
import dungeon.k_Spawner;
import entity.Player;
import entity.k_Item;
import entity.k_Mob;
import entity.k_Player;

public class MazeRunner implements k_MazeRunner {
	

	private double elapsedTime;
	private double startTime;
	private double endTime;
	
	private k_Player MC;
	private k_Dungeon Game;
	private k_Spawner<k_Mob> mobSpawner;
	private k_Spawner<k_Item> itemSpawner;
	private Window Screen;
	private Keyboard Kb;
	private short scoreboard;
		
	final public short maxNumNPCs = 5;
	final private short maxNumItems = 2;
	final private short mainRouteSize = 10;
	
	final private short numOfRoomtextures = 2;	
	final private String stdMainRouteTexture = "textures/dungeon.png";
	final private String stdRoomTexture = "textures/dungeon2.png";
	
	final private short numOfMobtextures = 2;
	final private String stdMobTextureOne = "textures/mob.png";
	final private String stdMobTextureTwo = "textures/badPotion.png";
	
	final private short numOfItemtextures = 3;
	final private String stdItemTextureOne = "textures/badPotion.png";
	final private String stdItemTextureTwo = "textures/potion.png";
	final private String stdItemTextureThree = "textures/key.png";
	
	final private short numOfPlayertextures = 1;
	final private String PlayerTextureOne = "textures/mob.png";
	
	final private short mobX = 50;
	final private short mobY = 50;
	
	final private short itemX = 50;
	final private short itemY = 50;
	
	final private short playerX = 50;
	final private short playerY = 50;
	
	final private double playerSpeed = .8;
	final private short playerHP = 10;
	
	final private short windowX = 1080;
	final private short windowY = 720;
	
	public MazeRunner()
	{
		Kb = new Keyboard();
		
		Screen = new Window(windowX, windowY, maxNumNPCs, maxNumItems, Kb, mobX, mobY, itemX, itemY
				, playerX, playerY);
		Game = new Dungeon(numOfRoomtextures);
		mobSpawner = new MobSpawner(maxNumNPCs, numOfMobtextures);
		itemSpawner = new ItemSpawner(maxNumItems, numOfItemtextures);
		MC = new Player(numOfPlayertextures, playerSpeed, playerHP);
		this.addTextures();
		MC.setPosition(windowX/2, windowY/2);
		scoreboard = 0;
	}
	
	public void gameLoop()
	{
		
		while(true)
		{
		Game.generateMainRoute(mainRouteSize, (short)0);
		this.updateLabel('b',Game.getCurrentRoom().getTexture(), (short)0, (short)0);
			while(gameOver() == false)
			{
				//update the game every 240 frames... roughly
				startTime = System.nanoTime();
				if( elapsedTime <= 250)
					{
						checkSpawners();
						checkPlayerPos();
						checkMob();
						checkItem();
						gameOver();
						
					}
				
				endTime = System.nanoTime();
				elapsedTime = (startTime + endTime) % (1000000000/240);
			}
			
				System.out.println("FINAL SCORE: " + scoreboard);
				System.out.println("WOULD YOU LIKE TO PLAY AGAIN???, yes/no" );
				Scanner kb = new Scanner(System.in);
			if(kb.nextLine().toLowerCase().compareTo("yes") == 0)
			{
				MC.setHP(playerHP);
				MC.setPosition((short)(windowX/2), (short)(windowY/2));
				scoreboard = 0;
				kb.reset();
				
			}
			else 
			{
				System.out.println("ok, thanks for playing" );
				kb.close();
				
				return;
			}
		}
	}
	
	public void addTextures()
	{
		Game.addRoomTexture(stdMainRouteTexture);
		Game.addRoomTexture(stdRoomTexture);
		
		mobSpawner.addTexture(stdMobTextureOne);
		mobSpawner.addTexture(stdMobTextureTwo);
		
		itemSpawner.addTexture(stdItemTextureOne);
		itemSpawner.addTexture(stdItemTextureTwo);
		itemSpawner.addTexture(stdItemTextureThree);
		
		MC.addPlayerTexture(PlayerTextureOne);
		
	}

	@Override
	public void genMobs() {
		mobSpawner.generate( numOfMobtextures, windowX, windowY);
		
	}

	@Override
	public void genItems()
	{
		itemSpawner.generate( numOfItemtextures, windowX, windowY);
	}

	@Override
	public void genRooms(char loc, short texture) {
		Game.createNewRoom(loc, texture);
	}
	
	public void roomChange(k_Room r)
	{
			// remove side room's if i'm returning to main room
		if(r.getIsMain() == true && Game.getCurrentRoom().getIsMain() == false)
		{
			System.out.println("REMOVE SIDE ROOM " );
			Game.removeCurrentRoom();
		}
		Game.setCurrentRoom(r);
		mobSpawner.clear();
		itemSpawner.clear();
		System.out.println("\r\nROOM NUMBER: " + r.roomID());
	}

	@Override
	public void checkPlayerPos() {
			
			Random rand = new Random();
			double playerX;
			double playerY;
			playerX = (MC.getX());
			playerY = (MC.getY());
			MC.setPosition( (playerX + Kb.getX()), (playerY + Kb.getY()));
			this.updateLabel('p', MC.getTexture(), playerX, playerY);
				
		// if the player enters the bounds of a door go to that room
		// create that room if it doesn't exist
					// top door
				if(playerY <= 50 )
					{
							// dont allow players to create more side rooms
							// if they're in a side room.
								// same for following statements
						if(Game.getCurrentRoom().getIsMain() == false &&
								Game.getCurrentRoom().getAdjRoom('T') == null)
						{
							MC.setPosition(playerX,(playerY + 1));
							return;
						}
							// create a side room if you're in the main room
								// same for following statements
						else if(Game.getCurrentRoom().getAdjRoom('T') == null)
						{
							this.genRooms('T', (short)( 1 +rand.nextInt(numOfRoomtextures-1)));
						}
						this.roomChange(Game.getCurrentRoom().getAdjRoom('T'));
						MC.setPosition(playerX, (windowY - 100) );
						System.out.println("Moved to Top Room");
						this.updateLabel('b',Game.getCurrentRoom().getTexture(), 0, 0);
					}
					// bottom door
				else if(playerY >= (windowY - 50) )
					{
						if(Game.getCurrentRoom().getIsMain() == false &&
								Game.getCurrentRoom().getAdjRoom('B') == null)
						{
							MC.setPosition(playerX,(playerY - 1));
							return;
						}
						else if(Game.getCurrentRoom().getAdjRoom('B') == null)
						{
							this.genRooms('B', (short)( 1 +rand.nextInt(numOfRoomtextures-1)));
						}
						this.roomChange(Game.getCurrentRoom().getAdjRoom('B'));
						MC.setPosition(playerX, 100 );
						System.out.println("Moved to Bottom Room");
						this.updateLabel('b',Game.getCurrentRoom().getTexture(), 0, 0);
					}
					// right door
				else if(playerX >= (windowX - 50)  )
					{
						if(Game.getCurrentRoom().getIsMain() == false &&
								Game.getCurrentRoom().getAdjRoom('R') == null)
						{
							MC.setPosition((playerX - 1),playerY);
							return;
						}
						else if(Game.getCurrentRoom().getAdjRoom('R') == null)
						{
							this.genRooms('R', (short)( 1 +rand.nextInt(numOfRoomtextures-1)));
						}
						this.roomChange(Game.getCurrentRoom().getAdjRoom('R'));
						MC.setPosition(100, playerY );
						System.out.println("Moved to Right Room");
						this.updateLabel('b',Game.getCurrentRoom().getTexture(), 0, 0);
					}
					// left door
				else if(playerX <= 50  )
					{
						if(Game.getCurrentRoom().getIsMain() == false &&
								Game.getCurrentRoom().getAdjRoom('L') == null)
						{
							MC.setPosition((float)(playerX + 1),playerY);
							return;
						}
						else if(Game.getCurrentRoom().getAdjRoom('L') == null)
						{
							this.genRooms('L', (short)( 1 +rand.nextInt(numOfRoomtextures-1)));
						}
						this.roomChange(Game.getCurrentRoom().getAdjRoom('L'));
						MC.setPosition((windowX - 100), playerY);
						System.out.println("Moved to Left Room");
						this.updateLabel('b',Game.getCurrentRoom().getTexture(), 0, 0);
					}
		}

	@Override
	public void checkSpawners() {
		if(mobSpawner.isEmpty() == true)
		{
			System.out.println("mobSpawner is empty");
			this.genMobs();
		}
		if(itemSpawner.isEmpty() == true)
		{
			System.out.println("itemSpawner is empty");
			this.genItems();
		}
	}

	@Override
	public void checkMob() {
		k_Mob m;
		m = mobSpawner.dequeue();
		
		if(m != null)
		{
			short mobAction = m.mobAction((short)MC.getX(), (short)MC.getY());
				
			if(mobAction == 0)
			{// if the mob isn't in range of the player enqueue it
				mobSpawner.enqueue(m);
				this.updateLabel('n', m.getTexture(), m.getX(), m.getY());
			}
			else
			{// if the mob hit's the player remove it
				
				this.updateLabel('n', null, m.getX(), m.getY());
				MC.setHP((short)(mobAction));
				setScoreboard((short) (-mobAction));
			}
		}
		m = null;
	}

	public void checkItem()
	{
		
		try {
			k_Item m;
			m = itemSpawner.dequeue();
				// check if player collided with item
			short itemEffect = m.itemEffect((short)MC.getX(), (short)MC.getY());
			
				// if yes use the item
			if(	itemEffect !=0)
				{
					if(itemEffect == 10 || itemEffect == -10)
					{	// item is a potion	
						MC.setHP(itemEffect);
					}
					else
					{	// item is a collectable
						System.out.println(itemEffect);
						setScoreboard((short)itemEffect);
					}
					m = null;
					return;
				}
			else //enqueue it
				{
					this.updateLabel('o', m.getTexture(), m.getX(), m.getY());
					itemSpawner.enqueue(m);
				}
		m = null;
		}
		catch(Exception e)
		{
			System.out.println("no more items on the screen" );
		}
		
	}
	
	
	@Override
	public void updateLabel(char label, ImageIcon texture, double X, double Y) {
		switch (label)
		{
		case 'n'://NPC LABEL
		case 'o'://OBJ LABEL
			{
				Screen.updateLabel(label, texture, X, Y);
				break;
			}
		case 'p'://PLAYER LABEL
			{
				Screen.updatePlayer(X, Y, texture);
				break;
			}
		case 'b'://BACKGROUND LABEL
			{
				Screen.setBackGround(texture);
				break;
			}
		default:
			{
				System.out.println("Invalid label: UpdateLabel- " + label);
			}
		}
	}
	
	@Override 
	public boolean gameOver()
	{
		if(MC.getHP() <= 0  || Game.getCurrentRoom().roomID() == this.mainRouteSize)
		{
			return true;
		}
		return false;
	}

	public void setScoreboard(short x)
	{
		scoreboard = (short) (scoreboard + x);
	}
}
