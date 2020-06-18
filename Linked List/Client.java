package linkedList;

public class Client {

	public static void main(String[] args) throws Exception {
		
		LinkedList list = new LinkedList();
		list.addLast(10);
		list.addLast(50);
		list.addFirst(20);
		list.addFirst(30);
		list.addFirst(40);
		list.display();
		
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println(list.getAt(3));
		System.out.println(list.removeFirst());
		list.display();
		System.out.println(list.removeLast());
		list.display();
		System.out.println(list.removeAt(1));
		list.display();
		list.addAt(40, 1);
		list.addFirst(50);
		list.display();
		list.reversePointers();
		list.display();
		list.reverseData();
		list.display();
		System.out.println(list.mid());
		list.addFirst(70);
		list.display();
		System.out.println(list.mid());
		System.out.println(list.KthNodeFromEnd(2));
		System.out.println(list.getFirst());
	}

}
