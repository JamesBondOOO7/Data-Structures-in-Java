package linkedList;

public class LinkedListAsA_Stack {

	private LinkedList stack;
	
	public LinkedListAsA_Stack() {
		this.stack = new LinkedList();	// Constructor
	}
	
	public int size()
	{
		return this.stack.size();
	}
	
	public boolean isEmpty()
	{
		return this.stack.isEmpty();
	}
	
	public void push(int item)
	{
		this.stack.addFirst(item);
	}
	
	public int pop() throws Exception
	{
		return this.stack.removeFirst();
	}
	
	public int top() throws Exception
	{
		return this.stack.getFirst();
	}
	
	public void display()
	{
		this.stack.display();
	}
}
