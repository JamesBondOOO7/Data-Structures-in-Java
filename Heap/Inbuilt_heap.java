package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class Inbuilt_heap {

	public static void main(String[] args) {
		
		// By default it's min heap
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		heap.add(10);
		heap.add(5);
		heap.add(15);
		heap.add(25);
		heap.add(1);
		
		System.out.println(heap);
		
		heap.remove();
		System.out.println(heap);
		
		int max = 0;
		for(int val : heap)
		{
			if(val > max)
			{
				max = val;
			}
		}
		
		heap.remove(max);
		System.out.println(heap);
		
		System.out.println("*************************************");
		// Max heap
		
		PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(Collections.reverseOrder());

		maxheap.add(10);
		maxheap.add(5);
		maxheap.add(15);
		maxheap.add(25);
		maxheap.add(1);
		
		System.out.println(maxheap);
		System.out.println(maxheap.peek());
		maxheap.remove();
		System.out.println(maxheap);
	}

}
