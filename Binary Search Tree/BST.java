package tree.Binary_Search_Tree;

public class BST {

	private class Node{
		
		int data;
		Node left;
		Node right;
		
		public Node() {
			
		}
	}
	
	private Node root;
	private int size;
	
	public BST(int [] arr) {
		
		this.root = constructBST(arr , 0 , arr.length - 1);
	
	}
	
	private Node constructBST(int[] arr, int lo, int hi) {
		
		if( lo > hi)
		{
			return null;
		}
		
		int mid = (lo + hi)/2;
		
		Node nn = new Node();
		nn.data = arr[mid];
		nn.left = constructBST(arr, lo, mid - 1);
		nn.right = constructBST(arr, mid + 1, hi);
		
		return nn;
	}
	
	public void display()
	{
		this.display(this.root);
	}
	
	private void display(Node node)
	{
		if( node == null)
		{
			return;
		}
		
		String str = "";
		if(node.left == null)
		{
			str += ".";
		}
		else
		{
			str += node.left.data;
		}
		
		str = str +" => " + node.data + " <= ";
		
		if(node.right == null)
		{
			str += ".";
		}
		else
		{
			str += node.right.data;
		}
		
		System.out.println(str);
		
		this.display(node.left);
		this.display(node.right);
	}
	
	public boolean find(int item)
	{
		return find(this.root , item);
	}
	
	private boolean find(Node node , int item)
	{
		if( node == null )
		{
			return false;
		}
		
		if( item > node.data)
		{
			return find(node.right, item);
		}
		else if( item < node.data)
		{
			return find(node.left , item);
		}
		else
		{
			return true;
		}
	}
	
	public int max()
	{
		return this.max(this.root);
	}
	
	private int max(Node node)
	{
		if( node.right == null)
		{
			return node.data;
		}
		
		return max(node.right);
	}
	
	public void add(int item)
	{
		this.add(this.root , item);
	}
	
	private void add( Node node , int item)
	{
		if( item > node.data )
		{
			if(node.right == null)
			{
				Node nn = new Node();
				nn.data = item;
				// Attachment step
				node.right = nn;
			}
			
			else
			{
				add(node.right , item);
			}
		}
		else
		{
			if(node.left == null)
			{
				Node nn = new Node();
				nn.data = item;
				// Attachment step
				node.left = nn;
			}
			
			else
			{
				add(node.left , item);
			}
		}
	}
	
	public void remove(int item)
	{
		this.remove(this.root , null , false , item);
	}

	// ilc --> Is my parent left or right
	private void remove(Node node, Node parent, boolean ilc, int item) {
		
		if( node == null)
		{
			return;		// when item is not present in the BST
		}
		
		if( item > node.data)
		{
			remove(node.right, node, false, item);
		}
		
		else if( item < node.data)
		{
			remove(node.left, node, true, item);
		}
		
		else
		{
			// Case 1
			
			if( node.left == null && node.right == null)
			{
				if(ilc)
				{
					parent.left = null;
				}else {
					parent.right = null;
				}
			}
			
			// Case 2
			
			else if( node.left == null && node.right != null)
			{
				if(ilc)
				{
						parent.left = node.right;
				}else {
						parent.right = node.right;
				}
			}
			// Case 3
			
			else if( node.left != null && node.right == null)
			{
				if(ilc)
				{
						parent.left = node.left;
				}else {
						parent.right = node.left;
				}
			}
			
			// Case 4
			
			// node.left != null && node.right != null
			else
			{
				int max = this.max(node.left);
				// either node.left max can take it's place
				// or node.right min can
				
				node.data = max;
				
				remove(node.left, node, true, max);
			}
		}
	}

}










