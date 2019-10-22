package dataStructures;
//works

public class Stack<dataType> implements k_Stack<dataType> {

	private k_LinkedList<dataType> stack;
	
	public Stack() {
		stack = new LinkedList<dataType>();
	}
	@Override
	public void push(dataType data) {
		
		stack.setTailNode(stack.newNode(data) );
	}

	@Override
	public dataType pop() {
		dataType pop = stack.getLast();
		stack.removeTail();
		return pop;
	}

	@Override
	public dataType peek() {
		return stack.getLast();
	}

	@Override
	public boolean isEmpty() {
		if(this.size() != 0)
		{
			return false;
		}
		return true;
	}

	@Override
	public short size() {
		try
		{
			return (short) (stack.getLength() + 1);
		}
		catch ( NullPointerException e)
		{
			return 0;
		}
		
	}

	

}
