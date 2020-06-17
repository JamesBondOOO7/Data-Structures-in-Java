package oops;

public class StackUsingArrays_Client {

	public static void main(String[] args) throws Exception {
		StackUsingArrays stack = new StackUsingArrays(5);
		// StackUsingArrays [] s = new StackUsingArrays [8];
		for(int i = 1 ; i<=5 ; i++)
		{
			stack.push(i * 10);
			stack.display();
		}
	System.out.println(stack.isEmpty());
	
	System.out.println(stack.size());
	// returns size of the stack
	
	System.out.println(stack.top());
	// returns the top most element
	
	// stack.push(89);
	// gives exception
	
	stack.pop();
	stack.display();
	// top most element i.e 50 gets popped off from the stack
	
	System.out.println(stack.size());
	System.out.println(stack.top());
	
	}

}
