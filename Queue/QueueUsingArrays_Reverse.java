package oops;

public class QueueUsingArrays_Reverse {

	public static void main(String[] args) throws Exception {
		
		QueueUsingArrays queue = new QueueUsingArrays(5);
		
		for(int i = 1 ; i<=5 ; i++)
		{
			queue.enqueue(i * 10);
		}
		queue.dequeue();
		queue.dequeue();
		
		queue.enqueue(60);
		queue.enqueue(70);
		
		queue.display();
		
		revqueue(queue);
		queue.display();
		
	}
	public static void revqueue(QueueUsingArrays queue) throws Exception
	{
		if(queue.isEmpty())
		{
			return;
		}
		int item = queue.dequeue();
		revqueue(queue);
		queue.enqueue(item);		
		return;
	}
}
