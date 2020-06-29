package hashMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		
		// Inserting data in HashMap
		map.put("USA" , 200);
		map.put("UK" , 150);
		map.put("India",300);
		map.put("China" , 350);
		
		System.out.println(map);
		map.put("Sweden" , 100);
		System.out.println(map);
		
		// Updating existing key
		map.put("India",400);
		System.out.println(map);
		
		// Get the value
		System.out.println(map.get("India"));
		System.out.println(map.get("RSA"));
		
		// Remove the data
		map.remove("India");
		System.out.println(map);
		
		// Check whether key is present or not
		System.out.println(map.containsKey("India"));
		System.out.println(map.containsKey("USA"));
		
		// Displaying the keys ( using " SETS " )
		Set<String> keys = map.keySet();
		// Set --> only unique values possible
		System.out.println("---------- KEYS ----------");
		for( String key : keys)
		{
			System.out.println(key);
		}
		
		// Displaying the values ( using " COLLECTION " )1
		Collection<Integer> values = map.values();
		System.out.println("---------- VALUES ----------");
		for( Integer val : values)
		{
			System.out.println(val);
		}
		
		// Displaying keys and values together
		// Using " ENTRYSET "

		Set<Map.Entry<String, Integer>> entries = map.entrySet();
		System.out.println("---------- ENTRY_SET ----------");
		for(Map.Entry<String, Integer> entry : entries)
		{
			System.out.println(entry.getKey() + " => " + entry.getValue());
		}
		System.out.println(map);
		System.out.println(map.size());
	}

}
