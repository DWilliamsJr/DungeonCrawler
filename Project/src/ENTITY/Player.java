package entity;
import javax.swing.ImageIcon;
import textures.EntityTextures;
import textures.k_EntityTextures;
		//make my instance of the player class static
		// and access the player move method inside my keyListener class
														//(same for mouse)


public class Player implements k_Player{
	
	public static double playerSpeed;
	private double playerX;
	private double playerY;
	private short playerHP;
	private short index;
	
	private k_EntityTextures playerTexture;
	
	public Player( short size, double speed, short playerHP)
	{
		playerTexture = new EntityTextures(size);
		System.out.println("player instance");
		playerX = 50;
		playerY = 50;
		this.playerHP = playerHP;
		index = 0;
		playerSpeed = speed;
	}

	@Override
	public void setPosition(double x, double y) {
		
		if(x > 0)
		{
			this.setIndex((short)0);
		}
		else if(x > 0)
		{
			this.setIndex((short)0);
		}
		if(y > 0)
		{
			this.setIndex((short)0);
		}
		else if(y < 0)
		{
			this.setIndex((short)0);
		}
		this.playerX =  x;
		this.playerY =  y;
		
	}
	
	public double getX()
	{
		return playerX;
	}
	
	public double getY()
	{
		return playerY;
	}


	@Override
	public ImageIcon getTexture() {
		return playerTexture.getTexture(index);
	}
	
	public void addPlayerTexture(String texture)
	{
		playerTexture.genTexture(texture);
	}

	@Override
	public void setTexture(ImageIcon texture) {}

	@Override
	public void setIndex(short s) {
		this.index = s;
		
	}

	@Override
	public short getHP() {
		return this.playerHP;
	}
	
	public void setHP(short Hp)
	{
			playerHP = (short) (playerHP + Hp);
			//System.out.println(playerHP);
	}

	@Override
	public double getSpeed() {
		return playerSpeed;
	}

	@Override
	public void setSpeed(double sp) {
		// TODO Auto-generated method stub
		
	}
	


	
}
