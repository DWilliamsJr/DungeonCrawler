package dataStructures;

public class Queue<dataType> implements k_Queue<dataType> {
	
	private k_List<dataType> queue;
	
	public Queue(short size) {
		queue = new List<dataType>(size);
	}
	
	@Override
	public void enqueue(dataType data) {
		if(queue.getFrontIndex() != queue.getEndIndex() || queue.getFirstData() == null)
		{
			queue.setDataEnd(data);
			queue.setEndIndex();
		}
		else
		{
			System.out.println("sdafad your queue is full :)");
		}
		
	}

	@Override
	public dataType dequeue() {
		if(this.isEmpty() == false)
		{
			dataType x = queue.getFirstData();
			queue.removeIndex(queue.getFrontIndex());
			queue.setFrontIndex();
			return x;
		}
		else 
		{
			System.out.println("your queue is empty :)" );
			return null;
		}
		
	}

	@Override
	public dataType first() {
		return queue.getFirstData();
	}

	@Override
	public boolean isEmpty() {
		if(queue.getFrontIndex() == queue.getEndIndex() && queue.getFirstData() == null)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}

	@Override
		// BROKEN. DONT USE
	public short size() {
		return queue.getLength();
	}
	
	
}
