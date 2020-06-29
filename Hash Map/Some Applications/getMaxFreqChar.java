package hashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class getMaxFreqChar {

	public static void main(String[] args) {
		
		String str = "aaabbccddaabc";
		System.out.println(getMaxFreq(str));
		
	}
	public static char getMaxFreq(String str)
	{
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0 ; i<str.length() ; i++)
		{
			char ch = str.charAt(i);
			if(map.containsKey(ch))
			{
				int val = map.get(ch);
				map.put(ch, val + 1);
			}
			else
			{
				map.put(ch,1);
			}
		}
		
		Set<Map.Entry<Character , Integer>> entries = map.entrySet();
		int max = Integer.MIN_VALUE;
		char ans = '\0';
		for(Map.Entry<Character , Integer> entry : entries)
		{
			if( entry.getValue() > max)
			{
				ans = entry.getKey();
				max = entry.getValue();
			}
		}
		
		return ans;
	}
}
