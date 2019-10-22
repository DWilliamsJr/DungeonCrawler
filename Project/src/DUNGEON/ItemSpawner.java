package dungeon;

import java.util.Random;
import javax.swing.ImageIcon;
import dataStructures.Queue;
import dataStructures.k_Queue;
import entity.Item;
import entity.k_Item;
import textures.EntityTextures;
import textures.k_EntityTextures;

public class ItemSpawner implements k_Spawner<k_Item> {

	private k_Queue<k_Item> ItemQueue;
	private short size;
	private k_EntityTextures ItemTexture;
	
	public ItemSpawner(Short size, short numText)
	{
		ItemTexture = new EntityTextures(numText);
		this.setSize(size);
		ItemQueue = new Queue<k_Item>(size);
		System.out.println("ItemSpawner Instance");
	}

	@Override
	public void generate(short effect, short windowX, short windowY ) {
			// Fill the queue with items of various textures
		k_Item Item;
		Random Rand = new Random();
		short num;
		for(short count = 0; count < this.getSize(); count++)
		{
			num = (short)Rand.nextInt(effect);
			Item = new Item(ItemTexture.getTexture(num), num, (short)(50 +Rand.nextInt(windowX-150)), 
					(short)(50 + Rand.nextInt(windowY-150)));
			ItemQueue.enqueue(Item);
		}
		System.out.println("gen Item complete");
		
	}

	@Override
	public void enqueue(k_Item I) {
		ItemQueue.enqueue(I);
		
	}

	@Override
	public k_Item dequeue() {
		return ItemQueue.dequeue();
	}

	@Override
	public boolean isEmpty() {
		return ItemQueue.isEmpty();
	}

	@Override
	public void clear() {
		try {// delete all items currently in queue
			for(short x = 0; x < this.getSize(); x++)
			{
				if(ItemQueue.dequeue() == null)
				{
					return;
				}
			}
			}
			catch(IndexOutOfBoundsException e)
			{
				System.out.println("INDEX OUT OF BOUNDS: ItemSapwner, clearItems");
			}
	}

	@Override
	public k_Item getFirst() {
		return ItemQueue.first();
	}

	@Override
	public void addTexture(String texture) {
		ItemTexture.genTexture(texture);
		
	}
	
	public void setSize(short size)
	{
		this.size = size;
	}
	
	public short getSize()
	{
		return this.size;
	}

	@Override
	public ImageIcon getTexture(short x) {
		return null;
	}
	

}
