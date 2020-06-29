package hashMap;

public class HashTable <K , V> {
	
	private class HTPair{
		K key;
		V value;
		
		public HTPair(K key , V value) {
			this.key = key;
			this.value = value;
		}
		
		public boolean equals(Object other)
		{
			//@SuppressWarnings("unchecked")
			HTPair op = (HTPair)other;
			return this.key.equals(op.key);
		}
		
		public String toString()
		{
			return "{" + this.key + "-" + this.value + "}";
		}
		
	}
	
	private LinkedList<HTPair>[] bucketArray ;
	private int size;
	public static final int DEFAULT_CAPACITY = 10;
	
	public HashTable() {
		this(DEFAULT_CAPACITY);
	}

//	@SuppressWarnings("unchecked")
	public HashTable(int capacity) {
		
		this.bucketArray = (LinkedList<HTPair>[])new LinkedList[capacity];
		this.size = 0;
	}
	
	public void put( K key , V value) throws Exception
	{
		// bi --> best index
		int bi = HashFunction(key);
		LinkedList<HTPair> bucket = this.bucketArray[bi];
		// means a LL(bucket) points at the LL present at the " bi th " index of the bucketArray
		
		HTPair pta = new HTPair(key, value);
		// pta --> pair to be added
		
		if( bucket == null)
		{
			// bucketArray[bi] == null
			bucket = new LinkedList<HTPair>();
			bucket.addLast(pta);
			this.bucketArray[bi] = bucket;
			this.size++;
		}
		else
		{
			int findAt = bucket.find(pta);
			if(findAt == -1)
			{
				bucket.addLast(pta);
				this.size++;
			}
			else
			{
				HTPair pair = bucket.getAt(findAt);
				pair.value = value;
			}
		}
		
		double lambda = (this.size * 1.0) / this.bucketArray.length;
		if(lambda > 0.75)
		{
			this.rehash();
		}
	}
	
	private void rehash() throws Exception {
		
		LinkedList<HTPair>[] oba = this.bucketArray;
		this.bucketArray = (LinkedList<HTPair>[]) new LinkedList[2 * oba.length];
		this.size = 0;
		// because we will again input the same values 
		// size = 0
		
		for( LinkedList<HTPair> ob : oba)
		{
			while( ob != null && !ob.isEmpty())
			{
				HTPair pair = ob.removeFirst();
				this.put(pair.key, pair.value);
			}
		}
	}

	public V get(K key) throws Exception{
		int bi = this.HashFunction(key);
		
		LinkedList<HTPair> bucket = bucketArray[bi];
		
		// ptf --> pair to find
		HTPair ptf = new HTPair(key , null);
		
		if(bucket == null)
		{
			return null;
		}
		else
		{
			int findAt = bucket.find(ptf);
			if(findAt == -1)
			{
				return null;
			}
			else
			{
				HTPair pair = bucket.getAt(findAt);
				return pair.value;
			}
		}
	}
	
	public V remove(K key) throws Exception
	{
		int bi = this.HashFunction(key);
		
		LinkedList<HTPair> bucket = bucketArray[bi];
		
		// ptr -- > pair to be removed
		HTPair ptr = new HTPair(key , null);
		
		if(bucket == null)
		{
			return null;
		}
		else
		{
			int findAt = bucket.find(ptr);
			if( findAt == -1)
			{
				return null;
			}
			else
			{
				HTPair pair = bucket.removeAt(findAt);
				this.size--;
				return pair.value;
			}
		}
	}
	
	private int HashFunction(K key)
	{
		int hc = key.hashCode();
		hc = Math.abs(hc);
		int bi = hc % this.bucketArray.length;
		return bi;
	}
	
	public void display() {
		for( LinkedList<HTPair> bucket : bucketArray)
		{
			if( bucket != null && !bucket.isEmpty() ) {
				bucket.display();
				System.out.println("**************************");
			}
			else
			{
				System.out.println("NULL");
				System.out.println("**************************");
			}
		}
	}
}
