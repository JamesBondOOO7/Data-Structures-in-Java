package oops;

public class StackUsingArrays_Reverse {

	public static void main(String[] args) throws Exception {
		
		StackUsingArrays stack = new StackUsingArrays(5);
		
		for(int i = 1 ; i<=5 ; i++)
		{
			stack.push(i*10);
		}
		stack.display();
		
		StackUsingArrays helper = new StackUsingArrays(5);
		//reverseStack(stack, helper);
		revStackCB(stack, helper, 0);
		stack.display();
	}
	public static void revStackCB(StackUsingArrays stack , StackUsingArrays helper , int index) throws Exception 
	{
		if(stack.isEmpty())
		{
			return;
		}
		int item = stack.pop();
		revStackCB(stack, helper, index + 1);
		helper.push(item);
		if(index == 0)
		{
			while(!helper.isEmpty())
			{
				stack.push(helper.pop());
			}
		}
		return;
	}
	
	
	public static void reverseStack (StackUsingArrays stack , StackUsingArrays helper) throws Exception
	{
		int count = stack.size() - 1;
		for(int i = 0 ; i<stack.size() ; i++)
		{
			int rv = stack.pop();
			for(int j = 0 ; j<count ; j++)
			{
				helper.push(stack.pop());
			}
			
			stack.push(rv);
			for(int j = 0 ; j<count; j++)
			{
				stack.push(helper.pop());
			}
			count--;
		}
		
	}

}
