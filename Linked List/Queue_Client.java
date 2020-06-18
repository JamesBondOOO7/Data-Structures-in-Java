package linkedList;

public class Queue_Client {

	public static void main(String[] args) throws Exception {
		
		LinkedListAsA_Queue queue = new LinkedListAsA_Queue();
		for(int i = 1 ; i<=5 ; i++) {
			queue.enqueue(i*10);
			queue.display();
		}
		
		System.out.println(queue.front());
		// returns the element at front
		
		queue.dequeue();
		// front element gets removed
		
		System.out.println(queue.size());
		// returns the size of the queue
		
		queue.display();
		
		queue.dequeue();
		
		queue.enqueue(60);
		queue.enqueue(70);
		
		queue.display();
		
		System.out.println(queue.isEmpty());
		
		System.out.println(queue.front());
	}

	}

