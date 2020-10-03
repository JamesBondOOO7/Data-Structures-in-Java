package segment_Tree;

public class SegmentTree {
	
	private class Node{
		int data;
		int startInterval;
		int endInterval;
		Node left;
		Node right;
	}
	
	Node root ;
	
	public SegmentTree(int[] arr) {
		this.root = constructTree(arr , 0 , arr.length - 1);
	}

	private Node constructTree(int[] arr , int si , int ei) {
		
		if( si == ei)
		{
			Node leafNode = new Node();
			leafNode.data = arr[si];
			leafNode.startInterval = si;
			leafNode.endInterval = ei;
			
			// By default they are null
			leafNode.left = null;
			leafNode.right = null;
			
			return leafNode;
		}
		Node node = new Node();
		node.startInterval = si;
		node.endInterval = ei;
		
		int mid = (si + ei)/2;
		
		node.left = constructTree(arr, si, mid);
		node.right = constructTree(arr, mid+1, ei);
		
		node.data = node.left.data + node.right.data;
		return node;
	}
	
	public void display()
	{
		this.display(this.root);
	}
	
	private void display(Node node)
	{
		String str = "";
		if( node.left != null )
		{
			str = str + "Interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and Data = " + node.left.data + " => ";
		}
		else
		{
			str = str + "No Left Child => ";
		}
		
		str = str + "Interval=[" + node.startInterval + "-" + node.endInterval + "] and Data = " + node.data;
		
		if( node.right != null )
		{
			str = str + " <= Data = " + node.right.data + " and Interval=[" + node.right.startInterval + "-" + node.right.endInterval + "]";
		}
		else
		{
			str = str + " <= No Right Child";
		}
		
		System.out.println(str);
		
		if( node.left != null )
		{
			this.display(node.left);
		}
		
		if( node.right != null )
		{
			this.display(node.right);
		}
		
	}
	
	public int query(int qsi , int qei)
	{
		return query(root , qsi , qei);
	}

	private int query(Node node, int qsi, int qei) {
		
		
		// Node completely lies inside the query
		// Thus this case always contributes to the actual answer
		if(node.startInterval >= qsi && node.endInterval <= qei)
		{
			return node.data;
		}
		
		// this is completely outside the query interval
		// No contribution -- return the default value
		else if( node.startInterval > qei || node.endInterval < qsi)
		{
			return 0;
		}
		
		//Overlapping case
		// si or ei may lie in the query interval
		else
		{
			int leftans = query(node.left, qsi, qei);
			int rightans = query(node.right , qsi , qei);
			
			return leftans + rightans;
		}
	}
	
	// Updation
	public void update(int index , int value)
	{
		this.root.data = update(root, index, value);
	}
	
	private int update(Node node , int index , int value)
	{
		if( index >= node.startInterval && index <= node.endInterval )
		{
			if(node.startInterval == index && node.endInterval == index)
			{
				node.data = value;
			}
			else
			{
				int leftvalue = update(node.left, index, value);
				int rightvalue = update(node.right, index, value);
				
				node.data = leftvalue + rightvalue;
			}
		}
		
		return node.data;
	}
}






