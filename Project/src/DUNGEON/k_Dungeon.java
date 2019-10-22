package dungeon;

public interface k_Dungeon {

	public void createNewRoom(char x, short textureNum);
	
	public void generateMainRoute(short size, short textureNum);
	
	public k_Room getCurrentRoom();
	
	public void setCurrentRoom(k_Room CR);
	
	public void addRoomTexture(String texture);
	
	public void removeCurrentRoom();

}
