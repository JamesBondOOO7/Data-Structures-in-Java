package tree.Binary_Search_Tree;

public class Client {

	public static void main(String[] args) {
		
		int [] arr = { 10,20,30,40,50,60,70};
		BST bst = new BST(arr);
		bst.display();
		System.out.println(bst.find(20));
		System.out.println(bst.find(100));
		System.out.println(bst.max());
		bst.add(80);
		bst.add(0);
		bst.add(75);
		bst.display();
		bst.remove(40);
		System.out.println("*****************************");
		bst.display();
		int [] arr2 = { 10 , 30 };
		for(int i = 0 ; i<arr2.length ; i++)
		{
			bst.remove(arr2[i]);
		}
		System.out.println("*****************************");
		bst.display();
	}

}
