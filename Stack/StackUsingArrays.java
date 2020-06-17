package oops;

public class StackUsingArrays {

	protected int[] data ;
	protected int top;
	public static final int DEFAULT_CAPACITY = 10;
	
	public StackUsingArrays() throws Exception{
		this(DEFAULT_CAPACITY);
		
		// no " . " used
		// calls the constructor below which takes the integer value
	}
		
	public StackUsingArrays(int capacity) throws Exception {
		if(capacity < 1)
		{
			throw new Exception("Inavlid Capacity");
		}
		
		this.data = new int[capacity];
		this.top = -1;
	}
	
	public int size()
	{
		return this.top + 1;
		
		// size of stack = index of topmost element of the stack ( = top ) + 1
	}
	
	public boolean isEmpty()
	{
		return this.size()==0;
		// It calls size() and if its = 0
		// then it returns true
		// else false
	}
	
	public void push(int value) throws Exception {
		if(this.size() == this.data.length)
		{					// if size of stack = length of the array
							// then no element can be inserted
			throw new Exception("Stack is full");
		}
		this.top++;
		this.data[this.top] = value;
		
		// this function is used to enter the values in the stack
	}
	
	public int pop() throws Exception {
		if(this.size() == 0)
		{					// if size of stack = 0
							// no element can be deleted
			throw new Exception("Stack is Empty");
		}
		
		int rv = this.data[this.top];
		this.data[this.top] = 0;
		this.top--;
		return rv;
		
		// this function deletes the element from the stack
		// Deletion takes place from the top
	}
	
	public int top() throws Exception {
		if(this.size() == 0)
		{					// if size of stack = 0
			throw new Exception("Stack is Empty");
		}
		
		int rv = this.data[this.top];
		return rv;
		
		// this function returns the element at the top of the stack
	}
	
	public void display()
	{
		for(int i = this.top ; i>=0 ; i--)
		{
			System.out.print(this.data[i] + ", ");
		}
		System.out.println("END");
	}
	
}