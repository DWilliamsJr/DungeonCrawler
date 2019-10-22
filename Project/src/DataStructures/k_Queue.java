package dataStructures;

public interface k_Queue<dataType>  {

		public void enqueue(dataType data);
		
		public dataType dequeue();
		
		public dataType first();
		
		public boolean isEmpty();
		
		public short size();
		
}
