package hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Intersection_Of_2_Arrays {

	public static void main(String[] args) {
		int [] arr = {1,1,3,9,2,2};
		int [] brr = {5,1,1,82,3,69,87};
		ArrayList<Integer> ans = getIntersection(arr, brr);
		for(int val: ans)
		{
			System.out.print(val + " ");
		}
	}

	public static ArrayList<Integer> getIntersection(int [] arr , int[] brr)
	{
		ArrayList<Integer> list = new ArrayList<>();
		HashMap<Integer, Boolean > map = new HashMap<>();
		for(int i = 0 ; i<arr.length ; i++)
		{
			map.put(arr[i],false);
		}
		
		for(int i = 0 ; i< brr.length ; i++)
		{
			if(map.containsKey(brr[i]))
			{
				map.put(brr[i] , true);
				//list.add(brr[i]);
				// Shorter approach
			}
		}
		
		Set<Map.Entry<Integer , Boolean>> entries = map.entrySet();
		for( Map.Entry<Integer , Boolean> entry : entries)
		{
			if(entry.getValue() == true)
			{
				list.add(entry.getKey());
			}
		}
		return list;
	}
}
