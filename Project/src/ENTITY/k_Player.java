package entity;

public interface k_Player extends k_Entity {

	public void setIndex(short s);
	
	public void addPlayerTexture(String texture);
	
	public short getHP();
	
	public void setHP(short Hp);
	
	public double getSpeed();
	
	public void setSpeed(double sp);
}
