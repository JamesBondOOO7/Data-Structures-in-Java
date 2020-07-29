package heap;

import java.util.ArrayList;
import java.util.HashMap;

public class GenericHeap<T extends Comparable<T>> {
	
	ArrayList<T> data = new ArrayList<>();
	
	HashMap<T,Integer> map = new HashMap<>();
	public void add(T item)
	{
		data.add(item);
		map.put(item , this.data.size() - 1);
		upheapify(data.size() - 1);
	}
	

	private void upheapify(int ci) {
		
		int pi = (ci - 1)/2;
		
		if(isLarger(data.get(ci) , data.get(pi)) > 0)
		{
			swap(ci,pi);
			upheapify(pi);
			// After swapping the element's position gets interchanged
			// => we have to call recursion for further upheapification
			// Now index for child = pi
		}
	}


	private void swap(int i, int j) {
		
		T data_i = data.get(i);
		T data_j = data.get(j);
		
		data.set(i, data_j);
		data.set(j, data_i);
		
		map.put( data_i , j);
		map.put(data_j, i);
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
	
	public T remove()
	{
		swap(0,this.data.size() - 1);
		T rv = this.data.remove(this.data.size() - 1);
		
		downheapify(0);
		
		map.remove(rv);
		return rv;
	}


	private void downheapify(int pi) {
		
		int mini = pi;
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;
		
		if(lci < this.size() && isLarger(data.get(lci) , data.get(mini)) > 0 ) {
			mini = lci;
		}
		
		if( rci < this.size() && isLarger(data.get(rci) , data.get(mini)) > 0 )
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
	
	public T get()
	{
		return data.get(0);
		// get function returns the element with the highest priority
	}
	
	// if t is having higher priority then return +ve value 
	public int isLarger(T t , T o)
	{
		return t.compareTo(o);
	}
	
	public void updatePriority(T pair)
	{
		int index = map.get(pair);
		upheapify(index);
		
	}
}
