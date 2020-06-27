package tree.BinaryTree;

public class BT_Client {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.display();
		// Input :
		// 50 true 25 true 38 false false true 48 true 18 false false false true 45 true 85 false false true 60 false false
		System.out.println("The height of the tree is " + tree.height());
		System.out.println("PRE ORDER");
		tree.preOrder();
		System.out.println("POST ORDER");
		tree.postOrder();
		System.out.println("IN ORDER");
		tree.inOrder();
		System.out.println("IN ORDER ITERATIVE");
		tree.inOrder_Iterative();
		System.out.println("LEVEL ORDER");
		tree.levelOrder();
		System.out.println(tree.isBST());
		System.out.println(tree.leafNodesSum());
		System.out.println("Diameter of tree is : " + tree.diameter());
		System.out.println("Diameter(Better) of tree is : " + tree.diameterBtr());
	}

}
