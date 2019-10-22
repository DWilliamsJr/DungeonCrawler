package entity;

import javax.swing.ImageIcon;

public interface k_Entity {
	
	public ImageIcon getTexture();
	
	public void setTexture(ImageIcon texture);
	
	public void setPosition(double x, double y);
	
	public double getY();
	
	public double getX();
	
	public String toString();

}
