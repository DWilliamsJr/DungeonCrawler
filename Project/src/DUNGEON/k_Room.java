package dungeon;

import javax.swing.ImageIcon;

public interface k_Room{
	
	public void setAdjRoom(k_Room room, char id);
	
	public k_Room getAdjRoom(char R);
	
	public void setIsMain(boolean set);
	
	public boolean getIsMain();
	
	public ImageIcon getTexture();
	
	public void setTexture(ImageIcon texture);
	
	public short roomID();

}
