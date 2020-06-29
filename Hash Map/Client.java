package hashMap;

public class Client {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		HashTable<String, Integer> map = new HashTable<>(5);
		
		map.put("USA" , 200);
		map.put("UK" , 150);
		map.put("India",300);
		map.put("China" , 350);
		
		map.display();
		System.out.println("--------------------------------");
		map.put("Sweden", 100);
		map.display();
		System.out.println("--------------------------------");
		map.put("India",325);
		map.display();
		
		System.out.println(map.get("USA"));
		System.out.println("--------------------------------");
		System.out.println(map.remove("India"));
		System.out.println(map.remove("RSA"));
		System.out.println("--------------------------------");
		map.display();
	}

}
