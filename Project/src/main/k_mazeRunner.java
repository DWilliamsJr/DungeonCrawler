package main;

import javax.swing.ImageIcon;

import dungeon.k_Room;

public interface k_MazeRunner {
	
	public void genMobs();
	
	public void genItems();
	
	public void genRooms(char loc, short texture);
	
	public void roomChange(k_Room r);
	
	public void checkPlayerPos();
	
	public void checkSpawners();
	
	public void addTextures();
	
	public void checkMob();
	
	public void checkItem();
	
	public void updateLabel(char label, ImageIcon texture, double X, double Y);
	
	public void gameLoop();
	
	public boolean gameOver();
	
	public void setScoreboard(short score);

}
