package oops;

public class QueueUsingArrays {

	protected int [] data ;
	protected int front;
	protected int size;
	public static final int DEFAULT_CAPACITY = 10;
	
	public QueueUsingArrays() throws Exception{
		this(DEFAULT_CAPACITY);
	}
	
	public QueueUsingArrays(int capacity) throws Exception{
		if(capacity < 1)
		{
			throw new Exception("Invalid Capacity");
		}
		
		this.data = new int [capacity];
		this.front = 0;
		this.size = 0;
	}
	
	public int size()
	{
		return this.size;
	}
	
	public boolean isEmpty()
	{
		return this.size() == 0;
	}
	
	public void enqueue(int value) throws Exception
	{
		if(this.size() == this.data.length)
		{
			throw new Exception("Queue is full");
		}
		
		int ci = (this.front + this.size) % this.data.length;
		// refer notes for explanation
		this.data[ci] = value;
		this.size++;
		// this.front is not increased as it should point to the first entry in the queue
	}
	
	public int dequeue() throws Exception
	{
		if(this.size() == 0)
		{
			throw new Exception("Queue is empty");
		}
		
		int rv = this.data[this.front];
		this.data[this.front] = 0;
		this.size--;
		this.front = (this.front + 1)%this.data.length ;
		// refer notes for explanation
		return rv;
	}
	
	public int front() throws Exception
	{
		if(this.size() == 0)
		{
			throw new Exception("Queue is empty");
		}
		
		int rv = this.data[this.front];
		return rv;
	}
	
	public void display()
	{
		for(int i = 0 ; i<this.size ; i++)
		{
			int ci = (this.front + i) % this.data.length;
			System.out.print(this.data[ci] + "=>");
		}
		System.out.println("END");
	}
}
