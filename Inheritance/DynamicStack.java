package oops.Inheritance;

import oops.StackUsingArrays;

public class DynamicStack extends StackUsingArrays {

	public DynamicStack() throws Exception
	{
		this(DEFAULT_CAPACITY);		// Constructor of DynamicStack
	}
	
	public DynamicStack(int capacity) throws Exception
	{
		super(capacity);			// Reusing the code by calling the constructor of 
									// StackUsingArrays class by using the keyword " super "
									// super ---> PARENT CLASS
	}
	
	@Override
	public void push(int item) throws Exception
	{
		if(this.size() == this.data.length)
		{
			int [] arr = new int[2*this.data.length];
			
			for(int i = 0 ; i<this.size(); i++)
			{
				arr[i] = this.data[i];
			}
			this.data = arr;
		}
			super.push(item);
	}
}
