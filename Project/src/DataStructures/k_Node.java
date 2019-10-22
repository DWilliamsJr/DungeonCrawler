package dataStructures;

public interface k_Node <dataType> {
	
	public k_Node<dataType> getNextNode();
	
	public k_Node<dataType> getPrevNode();
	
	public dataType getData();

	public void setPrevNode(k_Node<dataType> prev);

	public void setNextNode(k_Node<dataType> next);

	public void setData(dataType stuff);
	
}
