package dungeon;

import java.util.Random;
import javax.swing.ImageIcon;
import dataStructures.Queue;
import dataStructures.k_Queue;
import entity.Mob;
import entity.k_Mob;
import textures.EntityTextures;
import textures.k_EntityTextures;


public class MobSpawner implements k_Spawner<k_Mob> {

	private k_Queue<k_Mob> MobQueue;
	private short size;
	private k_EntityTextures mobTexture;
	
	public MobSpawner(Short size, short numText)
	{
		mobTexture = new EntityTextures(numText);
		this.setSize(size);
		MobQueue = new Queue<k_Mob>(size);
		System.out.println("MobSpawner Instance");
	}
	
	public short getSize() {
		return this.size;
	}
	
	public void setSize(short x) {
		this.size = x;
	}
	
	@Override
	public void generate(short textureNum, short windowX, short windowY) {
			// Fill the queue with mobs of various textures
		k_Mob mob;
		Random rand = new Random();
		short num = 0;
		for(short count = 0; count < this.getSize(); count++)
		{
			num = (short)(rand.nextInt(textureNum));
			mob = new Mob(mobTexture.getTexture(num), num,
					(short)(50 + rand.nextInt(windowX-150)), (short)(50 + rand.nextInt(windowY-150)));
			MobQueue.enqueue(mob);
		}
		System.out.println("gen mobs complete");
			
	}
	
	public void clear() {
		try {
			// delete all mobs currently in queue
		for(short x = 0; x < this.getSize(); x++)
		{
			if(MobQueue.dequeue() == null)
			{
				return;
			}
		}
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("INDEX OUT OF BOUNDS: MobSapwner, clearMobs");
		}
	}

	@Override
	public void enqueue(k_Mob m) {
		MobQueue.enqueue(m);

	}

	@Override
	public k_Mob dequeue() {
		return MobQueue.dequeue();
	}
	
	public boolean isEmpty()
	{
		return MobQueue.isEmpty();
	}
	
	public k_Mob getFirst()
	{
		return MobQueue.first();
	}
	
	public ImageIcon getTexture(short index)
	{
		return mobTexture.getTexture(index);
	}

	public void addTexture(String texture)
	{
		mobTexture.genTexture(texture);
	}

}
