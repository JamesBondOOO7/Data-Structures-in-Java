package oops.Inheritance;

public class DynamicQueue_Reverse {

	public static void main(String[] args) throws Exception {
		DynamicQueue queue = new DynamicQueue();

		for(int i = 1 ; i<=5 ; i++)
		{
			queue.enqueue(i * 10);
		}
		queue.display();
		reverseQueue(queue);
		queue.display();
	}
	public static void reverseQueue( DynamicQueue queue) throws Exception
	{
		if( queue.size() == 0)
		{
			return;
		}
		int item = queue.dequeue();
		reverseQueue(queue);
		queue.enqueue(item);
	}
}
