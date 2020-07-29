package heap;

import java.util.PriorityQueue;

public class Heap_Sort {

	public static void main(String[] args) {
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		heap.add(30);
		heap.add(20);
		heap.add(50);
		heap.add(40);
		heap.add(10);
		int[] arr = HeapSort(heap);
		for(int val : arr)
		{
			System.out.print(val + " ");
		}
	}

	public static int[] HeapSort(PriorityQueue<Integer> heap)
	{
		int [] arr = new int[heap.size()];
		int index = 0;
		while( ! heap.isEmpty())
		{
			arr[index] = heap.remove();
			index++;
		}
		return arr;
	}
}
