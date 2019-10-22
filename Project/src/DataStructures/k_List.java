package dataStructures;

public interface k_List <dataType> {
	
	public short getLength( );
	
	public dataType getFirstData();
	
	public dataType getLastData();
	
	
	public dataType getDataAt(short index);
	
	public void setDataAt(short index, dataType data);
	
	public void setDataFirst(dataType data);
	
	public void setDataEnd(dataType data);
	
	public void removeIndex(short index);
	
	public dataType viewIndex(short index);
	
	
	public short getFrontIndex();
	
	public short getEndIndex();

	public void setFrontIndex();

	public void setEndIndex();
	
	
}
