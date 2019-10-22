package entity;
import java.util.Random;
import javax.swing.ImageIcon;

//todo
	// AI behavior
	// error checking
public class Mob implements k_Mob {
	
	private ImageIcon MobTexture;
	private double posX;
	private double posY;
	private double moveSpeed;
	private short mobAction;

	public Mob(ImageIcon texture, short mobAction, short x, short y)
	{
		this.setTexture( texture);
		this.setPosition(x, y);
		this.mobAction = mobAction;
		Random rand = new Random();
		moveSpeed = (rand.nextDouble() / 2) + .25;
	}

	@Override
	public short mobAction(short playerX, short playerY) {
		
			// follow player
		if(playerX > posX && playerY > posY)
		{
			this.posX = (this.posX + moveSpeed);
			this.posY = (this.posY + moveSpeed);
		}
		else if(playerX > posX && playerY < posY)
		{
			this.posX = (this.posX + moveSpeed);
			this.posY = (this.posY - moveSpeed);
		}
		else if(playerX < posX && playerY > posY)
		{
			this.posX = (this.posX - moveSpeed);
			this.posY = (this.posY + moveSpeed);
		}
		else if(playerX < posX && playerY < posY)
		{
			this.posX = (this.posX - moveSpeed);
			this.posY = (this.posY - moveSpeed);
		}
			
		else if(playerX == posX && playerY < posY)
		{
			this.posY = (this.posY - moveSpeed);
		}
		else if(playerX == posX && playerY > posY)
		{
			this.posY = (this.posY + moveSpeed);
		}
		
		else if(playerX < posX && playerY == posY)
		{
			this.posX = (this.posX - moveSpeed);
		}
		else if(playerX > posX && playerY == posY)
		{
			this.posX = (this.posX + moveSpeed);
		}
		
			// Player collision
		if(((posX - playerX) <= 35 && (posX - playerX) >= -35)
				&& ((posY - playerY) <= 35 && (posY - playerY) >= -35))
		{
			return (short)( (-mobAction - 1) * (mobAction + 1));
		}
		return 0;
	}

	@Override
	public ImageIcon getTexture() {
		return MobTexture;
	}

	@Override
	public void setTexture(ImageIcon texture) {
		MobTexture = texture;
	}

	@Override
	public void setPosition(double x, double y) {

		this.posX = x;
		this.posY = y;
	}

	@Override
	public double getY() {
		return this.posY;
	}

	@Override
	public double getX() {
		return this.posX;
	}

	@Override
	public short getHP() {
		// TODO Auto-generated method stub
		return 0;
	}

}
