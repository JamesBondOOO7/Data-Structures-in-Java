package tree.GenericTree;

import java.util.ArrayList;
import java.util.Scanner;

public class GenericTree {
	
	// Defining type of node of the GENERIC TREE
	private class Node{
		int data;
		ArrayList<Node> children;
		
		// Constructor for node class
		public Node(int data) {
			
			this.data = data;
			this.children = new ArrayList<>();
		}
	}
	
	private Node root;
	private int size;
	
	//Constructor for Generic tree's node
	public GenericTree() {
		Scanner sc = new Scanner(System.in);
		this.root = takeInput(sc,null,0);
		// for no parent node is created then ---> null
		// 0 -> position of the child in the arraylist
		// as in the parent level only one child will be there which is 
		// the parent itself
	}
	
	private Node takeInput(Scanner sc , Node parent , int ithchild)
	{
		if(parent == null)
		{
			System.out.println("Enter the data for the root node");
		}
		else
		{
System.out.println("Enter the data for the " + ithchild +"th child of(the parent) " + parent.data);
		}
		
		// value of parent node at the current level
		int nodedata = sc.nextInt();

		// Creating the parent node
		Node np = new Node(nodedata);
		
		this.size++;
		
		// Input the number of children for the parent
		System.out.println("Enter the number of children for " + np.data);
		int children = sc.nextInt();
		
		// Executing the Generic tree for each child
		// for the current parent node
		for(int i = 0 ; i<children ; i++)
		{
			// recursive call for the children ---> parent of the next level
			Node child = takeInput(sc, np, i);
			
			// Adding the value of all the children in the parent's Arraylist
			np.children.add(child);
		}
		
		return np;
	}
	
	public void display()
	{
		this.display(this.root);
	}
	
	private void display(Node node)
	{
		String str = node.data + " => ";
		for(int i = 0 ; i<node.children.size(); i++)
		{
			str = str + node.children.get(i).data +  ", ";
		}
		
		str = str + "END";
		System.out.println(str);
		
		// Recursive call for other nodes
		for(int i = 0 ; i<node.children.size();i++)
		{
			display(node.children.get(i));
		}
	}
}