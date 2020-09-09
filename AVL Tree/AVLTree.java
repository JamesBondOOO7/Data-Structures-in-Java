package avlTree;

public class AVLTree {

	private class Node{
		
		int data;
		Node left;
		Node right;
		int height;
		
		public Node(int data)
		{
			this.data = data;
			this.height = 1;
		}
	}
	
	private Node root;
	int size;
	
	public AVLTree()
	{
		
	}
	
	public void insert(int item)
	{
		// Recursive function
		this.root = insert(this.root, item);
		this.size++;
	}

	private Node insert(Node node, int item) {
		
		if( node == null )
		{
			Node nn = new Node(item);
			return nn;
		}
		
		if( item > node.data )
		{
			node.right = insert(node.right, item);
		}
		else if( item < node.data )
		{
			node.left = insert(node.left, item);
		}
		
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		
		int bf = bf(node);
		
		// LL Case
		if( bf > 1 && item < node.left.data)
		{
			return rightRotate(node);
		}
		
		// RR Case
		else if( bf < -1 && item > node.right.data)
		{
			return leftRotate(node);
		}
		
		// LR
		else if( bf > 1 && item > node.left.data)
		{
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}
		
		// RL
		else if( bf < -1 && item < node.right.data)
		{
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}
		
		return node;
		
	}
	
	private int height(Node node)
	{
		if( node == null )
		{
			return 0;
		}
		
		return node.height;
	}
	
	private int bf(Node node)
	{
		if(node == null)
		{
			return 0;
		}
		
		return height(node.left) - height(node.right);
	}
	
	private Node rightRotate(Node c)
	{
		Node b = c.left;
		Node t3 = b.right;
		
		// Rotate
		b.right = c;
		c.left = t3;
		
		// Height update
		c.height = Math.max(height(c.left), height(c.right)) + 1;
		b.height = Math.max(height(b.left), height(b.right)) + 1;
		
		return b;
	}
	
	private Node leftRotate(Node c)
	{
		Node b = c.right;
		Node t2 = b.left;
		
		// Rotate
		b.left = c;
		c.right = t2;
		
		// Height Update
		c.height = Math.max(height(c.left), height(c.right)) + 1;
		b.height = Math.max(height(b.left), height(b.right)) + 1;
		
		return b;
	}
	
	public void display()
	{
		this.display(this.root);
	}
	
	private void display(Node node)
	{
		if(node == null)
		{
			return;
		}
		
		if( node.left != null )
		{
			System.out.print(node.left.data + " => ");
		}
		else
		{
			System.out.print("X => ");
		}
		
		System.out.print(node.data);
		
		if( node.right != null )
		{
			System.out.print(" <= " + node.right.data);
		}
		else
		{
			System.out.print(" <= X");
		}
		
		System.out.println();
		
		display(node.left);
		display(node.right);
	}
	
	
}




















