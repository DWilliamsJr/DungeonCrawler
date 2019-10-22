package dataStructures;
import java.util.EmptyStackException;


public class List<dataType> implements k_List<dataType> {
	
	private short front;
	private short end;
	private short size;
		
	public Object[] dataList;
	
	public List(short size)	{
			dataList = new Object[size];
			this.front = 0;
			this.end = 0;
			this.size = size;
	}

	@Override
	public short getLength() {
		
		short countF = this.front;
		short countE = this.end;
		short length;
		for(length = 0; countF != countE; length++)
		{
			countF = (short) ((countF % this.size) + 1);
		}
		return length;
	}

	@Override
	@SuppressWarnings("unchecked")
	public dataType getFirstData() {
		try {
			return (dataType) dataList[this.front];
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("there's nothing on your list:	getFirstData, List");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	// didn't test yet
	public dataType getLastData() {
		try {
			if(dataList[this.end] == null)
			{
				throw new EmptyStackException();
			}
			return (dataType) dataList[this.end];
			
		}
		catch(EmptyStackException e)
		{
			System.out.println("empty list:	getLastData, List");
			e.printStackTrace();
			return null;
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("index out of bounds:	getLastData, List");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	// didn't test yet
	public dataType getDataAt(short index) {
		try {
			return (dataType) dataList[index];
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("That index is out of bounds:	getIndex, List");
			return null;
		}
	}

	@Override
	public void setDataAt(short index, dataType data) {
		try
		{
			dataList[index] = data;
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("That index is out of bounds:	setIndex, List");
		
		}
		
	}

	@Override
	public void setDataFirst(dataType data) {
		try {
		dataList[this.front] = data;
		}
		catch(IndexOutOfBoundsException e){
			System.out.println(" index out of bounds: setFirstData, List");
		}
	}
	
	@Override
	public void setDataEnd(dataType data) {
		try {
		dataList[this.end] = data;
		}
		catch(IndexOutOfBoundsException e){
			System.out.println(" Index out of bounds: setDataEnd, List ");
		}
	}

	@Override
	//fix
	public void removeIndex(short index) {
		try {
			dataList[index] = null;
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("That index is out of bounds:	removeIndex, List");
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public dataType viewIndex(short index)
	{
		try {
			return (dataType)dataList[index];
		}
		catch(NullPointerException e)
		{
			return null;
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("That index is out of bounds: 	view, List");
			return null;
		}
	}
	
	@Override
	public short getFrontIndex()
	{
		return this.front;
	}
	
	@Override
	public short getEndIndex()
	{
		return this.end;
	}
	
	@Override
	public void setFrontIndex()
	{
		this.front = (short)(((this.front + 1) % this.size) );
	}
	
	@Override
	public void setEndIndex()
	{
		this.end = (short) (((this.end + 1) % this.size) );
	}

}
