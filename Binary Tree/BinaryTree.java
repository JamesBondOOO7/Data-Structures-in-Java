package tree.BinaryTree;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

import tree.BinaryTree.BinaryTree.DiaPair;

public class BinaryTree {
	private class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data , Node left , Node right) {
		
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	private Node root;
	private int size;
	
	BinaryTree()
	{
		Scanner sc = new Scanner(System.in);
		this.root = takesInput(sc, null, false);
	}
	
	
	/*
	 * isLeftOrRight :
	 * 
	 * Left child ---> true
	 * Right child --> false
	 * 
	 */
	private Node takesInput(Scanner sc , Node parent , boolean isLeftOrRight)
	{
		if(parent == null)
		{
			System.out.println("Enter the data for the root node ");
		}
		else
		{
			if(isLeftOrRight)
			{
				System.out.println("Enter the data of left child of(parent) " + parent.data);
			}
			else
			{
				System.out.println("Enter the data of right child of(parent) " + parent.data);
			}
		}
		
		int nodeData = sc.nextInt();
		Node np = new Node(nodeData,null,null);
		// This node has no left and right child
		// We will ask the user for this
		this.size++;
		
		
		// Input for the child data for the current node i.e. np
		
		// Left child branch
		System.out.println("Do you have left child of " + np.data);
		boolean choice = sc.nextBoolean();
		
		
		if( choice )
		{
			// Parent node's (np's) left child branch
			np.left = takesInput(sc, np, true);
		}
		
		// Right child branch
		System.out.println("Do you have right child of " + np.data);
		choice = false;
		choice = sc.nextBoolean();
				
		if( choice )
		{
			// Parent node's (np's) right child branch
			np.right = takesInput(sc, np, false);
		}
		
		return np;
	}
	
	// public -> as root is private 
	// so that client can't make any changes
	public void display()
	{
		this.display(this.root);
	}
	 
	private void display(Node node) {
		String str = "";
		
		if(node.left != null)
		{
			str = str + node.left.data + " => ";
		}
		else
		{
			str = str + "END => ";
		}
		
		str = str + node.data;
		
		if(node.right != null)
		{
			str = str + " <= " + node.right.data;
		}
		else
		{
			str = str + " <= END";
		}
		
		System.out.println(str);
		
		
		// Recursive calls
		if(node.left != null)
		{
			this.display(node.left);
		}
		
		if(node.right != null)
		{
			this.display(node.right);
		}
	}
	
	public int height()
	{
		return this.height(this.root);
	}
	private int height(Node node)
	{
		if( node == null)
		{
			return -1;
		}
		// height of left sub tree
		int lh = this.height(node.left);
		
		//height of right sub tree
		int rh = this.height(node.right);
		
		int max = lh>rh?lh:rh;
		
		return max+1;
	}
	
	public void preOrder()
	{
		this.preOrder(this.root);
		System.out.println("END");
	}
	
	private void preOrder(Node node)
	{
		if(node == null)
		{
			return;
		}
		
		System.out.print(node.data + ", ");
		this.preOrder(node.left);
		this.preOrder(node.right);
		return;
	}
	
	public void postOrder()
	{
		this.postOrder(this.root);
		System.out.println("END");
	}
	
	private void postOrder(Node node)
	{
		if(node == null)
		{
			return;
		}
		
		this.postOrder(node.left);
		this.postOrder(node.right);
		System.out.print(node.data + ", ");
		return;
	}
	
	public void inOrder()
	{
		this.inOrder(this.root);
		System.out.println("END");
	}
	
	private void inOrder(Node node)
	{
		if(node == null)
		{
			return;
		}
		
		this.inOrder(node.left);
		System.out.print(node.data + ", ");
		this.inOrder(node.right);
		return;
	}
	
	// *************************************************
	public void levelOrder()
	{
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(this.root);
		
		while(!queue.isEmpty())
		{
			Node rv = queue.removeFirst();
			System.out.print(rv.data + ", ");
			if( rv.left != null)
			{
				queue.addLast(rv.left);
			}
			
			if( rv.right != null)
			{
				queue.addLast(rv.right);
			}
		}
		System.out.println("END");
	}
	// *************************************************
	
	public boolean isBST()
	{
		return this.isBST(this.root , Integer.MIN_VALUE , Integer.MAX_VALUE);
	}
	
	private boolean isBST(Node node , int min , int max)
	{
		if(node == null)
		{
			return true;
		}
		
		// Checking range of each node
		if( node.data < min || node.data > max )
		{
			return false;
		}
		
		// Recursive calls for left and right nodes
		else if( !isBST( node.left , min , node.data))	// i.e == false
		{
			return false;
		}
		else if( !isBST(node.right, node.data , max))	//	i.e == false
		{
			return false;
		}
		
		return true;
	}
	
	public void inOrder_Iterative()
	{
		this.inOrder_Iterative(this.root);
	}
	
	// *************************************************
	private void inOrder_Iterative(Node node)
	{
		if( node == null)
		{
			System.out.println("END");
		}
		
		Stack<Node> stack = new Stack<>();
		while(true)
		{
			if(node != null)
			{
				stack.push(node);
				node = node.left;
			}
			else
			{
				if(stack.isEmpty())
				{
					break;
				}
				else
				{
					node = stack.pop();
					System.out.print(node.data + ", ");
					node = node.right;
				}
			}
		}
		System.out.println("END");
	}
	// *************************************************
	
	public int leafNodesSum()
	{
		return this.leafNodesSum(this.root);
	}
	private int leafNodesSum(Node node)
	{
		if(node == null)
		{
			return 0;
		}
		if(node.left == null && node.right == null)
		{
			return node.data;
		}
		return leafNodesSum(node.left) + leafNodesSum(node.right);
	}
	
	public int diameter()
	{
		return this.diameter(this.root);
	}
	
	//O(n*n)
	private int diameter(Node node)
	{
		if(node == null)
		{
			return 0;
		}
		
		int case1 = this.height(node.left) + this.height(node.right) + 2;
		int case2 = this.diameter(node.left);
		int case3 = this.diameter(node.right);
		
		int ans = Math.max(case1, Math.max(case2, case3));
		
		return ans;
	}
	
	/*
	 *  A better approach for calculating the diameter
	 *  Diameter --> T(n) = O(n*n)
	 *  
	 *  but with this approach 
	 *  T(n) = O(n)
	 *  
	 */
	
	public int diameterBtr()
	{
		return this.diameterBtr(this.root).diameter;
	}
	
	// O(n)
	private DiaPair diameterBtr(Node node)
	{
		if( node == null)
		{
			DiaPair base = new DiaPair(-1, 0);
			return base;
		}
		
		DiaPair lp = diameterBtr(node.left);	// Left Pair (Height , Diameter)
		DiaPair rp = diameterBtr(node.right);	// Right Pair(Height , Diameter)
		
		DiaPair myAnsp = new DiaPair();
		
		// Same height function formula
		myAnsp.height = Math.max(lp.height, rp.height) + 1;
		
		
		// Same diameter function formula
		// i.e Max( Case1 , Max(Case2 , Case3))
		myAnsp.diameter = Math.max(lp.height + rp.height + 2, Math.max(lp.diameter, rp.diameter));
		
		return myAnsp;
	}
	
	// Class for diameterBtr function
	public class DiaPair{
		int height;
		int diameter;
		public DiaPair() {
		
		}
		public DiaPair(int height , int diameter)
		{
			this.height = height;
			this.diameter = diameter;
		}
	}
}



