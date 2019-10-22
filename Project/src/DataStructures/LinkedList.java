package dataStructures;
import dataStructures.Node;

public class LinkedList<dataType> implements k_LinkedList<dataType> {
	
	private k_Node<dataType> headNode;
	private k_Node<dataType> tailNode;
	
	public LinkedList() {
		headNode = null;
		tailNode = null;
	}
	public k_Node<dataType> getTailNode()
	{
		return tailNode;
	}
	public k_Node<dataType> getHeadNode()
	{
		return headNode;
	}
	public void setTailNode(k_Node<dataType> tail)
	{
		tail.setPrevNode(tailNode);
		tail.setNextNode(null);
		if(tailNode != null)
		{
			tailNode.setNextNode(tail);
		}
		
		tailNode = tail;
	}
	public void setHeadNode(k_Node<dataType> head)
	{
		head.setPrevNode(null);
		head.setNextNode(headNode);
		if(headNode != null)
		{
			headNode.setPrevNode(head);
		}
		
		headNode = head;
	}

	@Override
	public k_Node<dataType> newNode(dataType data) {
			k_Node<dataType> x = new Node<dataType>( data);
		return x;
	}

	@Override
	public dataType getFirst() {
		return headNode.getData();
	}

	@Override
	public dataType getLast() {
		return tailNode.getData();
	}

	@Override
	public short getLength() {
		
		k_Node<dataType> T_Node = tailNode;
		k_Node<dataType> H_Node = tailNode;
		short LLength = 0;
		
		while(T_Node.getPrevNode() != null)
			{
				LLength++;
				T_Node = T_Node.getPrevNode();
			}
		
		while(H_Node.getNextNode() != null)
		{
			LLength++;
			H_Node = H_Node.getNextNode();
		}
		
		return LLength;
	}

	@Override
	// havent checked tis yet
	public void removeNode(short index)throws IndexOutOfBoundsException {
		k_Node<dataType> R_Node = headNode;
		if(index > this.getLength()){
			throw new IndexOutOfBoundsException("index is greater than length: LinkedList, removeNode ");
		}
		for(short x = 0; x < index; x++)
			{
				R_Node = R_Node.getNextNode();
			}
		(R_Node.getPrevNode()).setNextNode(R_Node.getNextNode());
		R_Node = null;
		
	}

	@Override
	// havent checked tis yet
	public void insertNode(k_Node<dataType> node, short index)throws IndexOutOfBoundsException {
		k_Node<dataType> I_Node = headNode;
		if(index > this.getLength()){
			throw new IndexOutOfBoundsException("index is greater than length: LinkedList, insertNode ");
		}
		for(short x = 0; x < index; x++)
		{
			I_Node = I_Node.getNextNode();
		}
		node.setNextNode(I_Node.getNextNode());
		(I_Node.getNextNode()).setPrevNode(node);
		node.setPrevNode(I_Node);
		I_Node.setNextNode(node);
		
	}
	
	public void removeTail()
	{
		if(tailNode.getPrevNode() != null)
		{
			(tailNode.getPrevNode()).setNextNode(null);
		}
		
		tailNode = tailNode.getPrevNode();
	}
	
	public void removeHead()
	{
		if ((headNode.getNextNode()).getNextNode() != null )
		{
			((headNode.getNextNode()).getNextNode()).setPrevNode(null);
		}
		headNode = headNode.getNextNode();
	}


}
