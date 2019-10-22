package dungeon;

import javax.swing.ImageIcon;

public interface k_Spawner<DataType> {

	public void generate( short textureNum, short x, short y );

	public void enqueue(DataType I);
	
	public DataType dequeue();
	
	public boolean isEmpty();
	
	public void clear();
	
	public void setSize(short size);
	
	public short getSize();
	
	public DataType getFirst();
	
	public void addTexture(String texture);

	public ImageIcon getTexture(short mobAction);
}
