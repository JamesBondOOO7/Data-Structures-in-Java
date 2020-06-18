package linkedList;

public class LinkedList {
	
	private class Node{		// private + inner class so that it is only accessed by 
							// the LINKEDLIST class
		private int data;
		private Node next;
	}
	
	private Node head;		// Stores the address of starting node
	private Node tail;		// Stores the address of the last node
	private int size;		// Keeps the track of its size
	
	// O(n)
	public void display() {
		Node temp = this.head;	// temp -> pointing at FIRST NODE's address 

		while( temp != null)	// At LAST NODE temp.next = null
		{
			System.out.print(temp.data + ", ");
			temp = temp.next;
		}
		System.out.println("END");
	}
	
	// O(1)
	public int getFirst() throws Exception
	{
		if(this.size == 0)
		{
			throw new Exception("Linked List is empty");
		}
		return this.head.data;
	}
	
	// O(1)
	public int getLast() throws Exception
	{
		if(this.size == 0)
		{
			throw new Exception("Linked List is empty");
		}
		return this.tail.data;
	}
	
	// O(n)
	public int getAt(int index) throws Exception
	{
		if(this.size == 0)
		{
			throw new Exception(" Linked List is Empty ");
		}
		
		if(index < 0 || index >= this.size)
		{
			throw new Exception(" Invalid Index ");
		}
			Node temp = this.head;
		for(int i = 0 ; i<index ; i++)
		{
			temp = temp.next;
		}
		
		// After loop execution temp -> required index
		return temp.data;
	}
	
	// O(n)
	private Node getNodeAt(int index) throws Exception
	{
		// ONLY USED WITHIN THE CLASS
		// CAN'T KEEP IT PUBLIC AS THE CLIENT CLASS CAN MANPULATE THE DATA
		if(this.size == 0)
		{
			throw new Exception(" Linked List is Empty ");
		}
		
		if(index < 0 || index >= this.size)
		{
			throw new Exception(" Invalid Index ");
		}
			Node temp = this.head;
		for(int i = 0 ; i<index ; i++)
		{
			temp = temp.next;
		}
		
		// After loop execution temp -> required index
		return temp;
	}
	
	// O(1)
	public void addLast(int item)
	{
		Node nn = new Node();	// New node creation
		nn.data = item;			// Updating the value
		nn.next = null;		// Last node stores null as there aren't any nodes after it
		// BY DEFAULT IT'S NULL
		
		
		// Updating the summary object
		
		if(this.size == 0)
		{
			this.head = nn;
			this.tail = nn;
			// i.e for 1st node head and tail point on the same node	
			this.size++;
		}
		
		else
		{	// attachment step
			this.tail.next = nn;	
			// the previous node stores the address of the present node
			
			this.tail = nn;
			// the tails points towards the present/Last node

			this.size++;
		}
	}
	
	// O(1)
	public void addFirst(int item)
	{
		Node nn = new Node();
		nn.data = item;
		nn.next = null;// By default it's null
		
		
		// updating summary object
		if(this.size == 0)
		{
			this.head = nn;
			this.tail = nn;
			this.size++;
		}
		
		else
		{
			// attachment step
			nn.next = this.head;
			// new node's next = previous front node address 
			// which is stored by head
			
			this.head = nn;
			// Now the front node is the node entered
			
			this.size++;
		}
	}

	// O(n)
	public void addAt(int item , int index) throws Exception
	{
		if(index < 0 || index >= this.size + 1)
		{
			throw new Exception(" Invalid index ");
		}
		else if(index == 0)
		{
			this.addFirst(item);
		}
		else if(index == this.size)
		{
			this.addLast(item);
		}
		else
		{
			// create a new node
			Node nn = new Node();
			nn.data = item;
			nn.next = null;
			
			// attach
			Node nm1 = this.getNodeAt(index - 1);
			Node np1 = this.getNodeAt(index);
			
			nm1.next = nn;
			nn.next = np1;
			
			// summary object update
			this.size++;
		}
	}

	//O(1)
	public int removeFirst() throws Exception
	{
		if(this.size == 0)
		{
			throw new Exception(" Linked List is Empty ");
		}
		
		int rv = this.head.data;
		
		if(this.size == 1)
		{
			this.head = null;
			this.tail = null;
			this.size = 0;
		}
		
		else
		{
			this.head = this.head.next;
			this.size--;
		}
		return rv;
	}

	// O(n)
	public int removeLast() throws Exception
	{
		if(this.size == 0)
		{
			throw new Exception(" Linked List is Empty ");
		}
		
		int rv = this.tail.data;
		
		if(this.size == 1)
		{
			this.head = null;
			this.tail = null;
			this.size = 0;
		}
		
		else
		{
			Node lm1 = this.getNodeAt(this.size - 2);
			// lm1 -> second last node
			this.tail = lm1;
			this.tail.next = null;
			this.size--;
		}
		return rv;
	}

	// O(n)
	public int removeAt(int index) throws Exception
	{
		if(index < 0 || index >= this.size)
		{
			throw new Exception(" Invalid Index ");
		}
		
		if(index == 0)
		{
			return this.removeFirst();
		}
		
		else if(index == this.size - 1)
		{
			return this.removeLast();
		}
		
		else
		{
			Node del = this.getNodeAt(index);
			Node delm1 = this.getNodeAt(index - 1);
			
			int rv = del.data;
			delm1.next = del.next;
			del.data = 0;
			this.size--;
			return rv;
		}
	}

	public void reverseData() throws Exception
	{
		// In this we are just reversing the data while the addresses remain as it is
		
		int left = 0;
		int right = this.size - 1;
		
		while( left < right)
		{
			Node ln = this.getNodeAt(left);		// ln -> left node
			Node rn = this.getNodeAt(right);	// rn -> right node
			
			int temp = ln.data;
			ln.data = rn.data;
			rn.data = temp;
			
			left++;
			right--;
		}
		
	}
	
	public void reversePointers() throws Exception
	{
		Node prev = this.head;
		Node curr = prev.next;
		
		while( curr != null )
		{
			Node ahead = curr.next;
			curr.next = prev;
			
			prev = curr;
			curr = ahead;
		}
		
		// swap head and tail
		Node t = this.head;
		this.head = this.tail;
		this.tail = t;
		
		this.tail.next = null;
	}

	public int mid() throws Exception
	{
		if(this.size == 0)
		{
			throw new Exception(" List is Empty ");
		}
		
		Node slow = this.head;
		Node fast = this.head;
		
		// fast moves with twice the speed of slow
		// So when fast reaches the end => slow reaches the mid
		
		while( fast.next != null && fast.next.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow.data;
	}

	public int size()
	{
		return this.size;
	}

	public boolean isEmpty()
	{
		return this.size() == 0;
	}

	public int KthNodeFromEnd( int K) throws Exception
	{
		if( K<=0 || K>this.size)
		{
			throw new Exception(" Invalid Input ");
		}
		// Restriction - can't use the instance or function of size
		// My Approach - reverse ; Kth node ; reverse
		// wrong as reverse uses size 
		
		Node slow = this.head;
		Node fast = this.head;
		
		for(int i = 0 ; i<K ; i++)
		{
			fast = fast.next;
		}
		
		while( fast != null)
		{
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow.data;
	}
}
