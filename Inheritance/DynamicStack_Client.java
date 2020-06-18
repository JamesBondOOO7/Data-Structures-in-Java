package oops.Inheritance;

import oops.StackUsingArrays;

public class DynamicStack_Client{

	public static void main(String[] args) throws Exception {
		StackUsingArrays stack = new DynamicStack();

		for(int i = 1 ; i<=5 ; i++)
		{
			stack.push(i * 10);
			stack.display();
		}
		
		stack.push(60);
		stack.push(70);
		stack.push(80);
		stack.display();
		stack.pop();
		stack.display();
	}

}
