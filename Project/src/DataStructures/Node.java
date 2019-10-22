package dataStructures;

public class Node<dataType> implements k_Node<dataType> {
		
	private k_Node<dataType> previousNode;
	private k_Node<dataType> nextNode;
	private dataType data;
	
	public Node( dataType data) {
		this.setPrevNode(null);
		this.setNextNode(null);
		this.setData(data);
	}
	
	@Override
	public void setNextNode(k_Node<dataType> next) {
		this.nextNode =  next;
	}

	@Override
	public k_Node<dataType> getNextNode() {
		return nextNode;
	}

	@Override
	public void setPrevNode(k_Node<dataType> prev) {
		this.previousNode = prev;
	}

	@Override
	public k_Node<dataType> getPrevNode() {
		return previousNode;
	}

	@Override
	public void setData(dataType stuff) {
		this.data = stuff;
	}

	@Override
	public dataType getData() {
		// TODO Auto-generated method stub
		return data;
	}

}
