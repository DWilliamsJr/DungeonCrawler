package dataStructures;

public interface k_LinkedList<dataType> {
	
	public k_Node<dataType> newNode(dataType data);
	
	public dataType getFirst();
	
	public k_Node<dataType> getHeadNode();
	
	public k_Node<dataType> getTailNode();
	
	public void setTailNode(k_Node<dataType> tail);
	
	public void setHeadNode(k_Node<dataType> head);
	
	public dataType getLast();
	
	public short getLength();
	
	public void removeTail();
	
	public void removeHead();

	public void removeNode(short index);
	
	public void insertNode(k_Node<dataType> node, short index);
}
