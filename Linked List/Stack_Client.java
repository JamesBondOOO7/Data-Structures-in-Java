package linkedList;

public class Stack_Client {

	public static void main(String[] args) throws Exception {
		LinkedListAsA_Stack stack = new LinkedListAsA_Stack();
		
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

