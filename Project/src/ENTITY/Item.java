package entity;

import javax.swing.ImageIcon;

public class Item implements k_Item {
	
	private short effect;
	private ImageIcon ItemTexture;
	private double posX;
	private double posY;
		
	public Item(ImageIcon texture, short effect, short x, short y)
	{
		this.setTexture( texture);
		this.setPosition(x, y);
		this.setItemEffect(effect);
	}
	@Override
	public ImageIcon getTexture() {
		return this.ItemTexture;
	}

	@Override
	public void setTexture(ImageIcon texture) {
		this.ItemTexture = texture;
		
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
	public short itemEffect(short mcX, short mcY) {
		if(	  mcX >= posX - 50 
				&& mcY >= posY - 50
				&& mcX <= posX + 20 
				&& mcY <= posY + 20)
		{
			return effect;
		}
		return 0;
		
	}
	
	@Override
	public void setItemEffect(short effect)
	{
		if(effect == 0)
		{
			this.effect = -10;
		}
		else if(effect == 1)
		{
			this.effect = 10;
		}
		else
		{
			this.effect = (short)(effect * effect);
		}
	}

}
