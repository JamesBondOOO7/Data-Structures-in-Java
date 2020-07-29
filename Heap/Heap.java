package heap;

import java.util.ArrayList;

public class Heap {
	
	ArrayList<Integer> data = new ArrayList<Integer>();
	
	public void add(int item)
	{
		data.add(item);
		upheapify(data.size() - 1);
	}
	

	private void upheapify(int ci) {
		
		int pi = (ci - 1)/2;
		
		if(data.get(ci) < data.get(pi))
		{
			swap(ci,pi);
			upheapify(pi);
			// After swapping the element's position gets interchanged
			// => we have to call recursion for further upheapification
			// Now index for child = pi
		}
	}


	private void swap(int i, int j) {
		
		int data_i = data.get(i);
		int data_j = data.get(j);
		
		data.set(i, data_j);
		data.set(j, data_i);
	}
	
	public void display()
	{
		System.out.println(data);
	}
	
	public int size()
	{
		return data.size();
	}
	
	public boolean isEmpty()
	{
		return this.size() == 0;
	}
	
	public int remove()
	{
		swap(0,this.data.size() - 1);
		int rv = this.data.remove(this.data.size() - 1);
		
		downheapify(0);
		return rv;
	}


	private void downheapify(int pi) {
		
		int mini = pi;
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;
		
		if(lci < this.size() && data.get(lci) < data.get(mini)) {
			mini = lci;
		}
		
		if( rci < this.size() && data.get(rci) < data.get(mini))
		{
			mini = rci;
		}
		
		if(mini != pi)
		{
			swap(mini , pi);
			downheapify(mini);
		}
		
		// The above if condition also includes the base case of the recursion as when mini == pi
		// we will not enter this condition again
	}
	
	public int get()
	{
		return data.get(0);
		// get function returns the element with the highest priority
	}
}
