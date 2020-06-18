package oops.Inheritance;

import oops.QueueUsingArrays;

public class DynamicQueue_Client {

	public static void main(String[] args) throws Exception {

		QueueUsingArrays queue = new DynamicQueue(5);
		for(int i = 1 ; i<= 5 ; i++)
		{
			queue.enqueue(i*10);
		}
		
		queue.display();
		queue.dequeue();
		queue.dequeue();
		queue.display();
		queue.enqueue(60);
		queue.enqueue(70);
		queue.enqueue(80);
		queue.display();
	}

}
