public class _17_GenDLLFromABT
{
	// no need to import (referring the class in same package)
	Node_ADT root;
	
	public static void main(String[] args)
	{
		_17_GenDLLFromABT bt = new _17_GenDLLFromABT();

		bt.root = new Node_ADT(20);

		bt.root.left = new Node_ADT(8);
		bt.root.right = new Node_ADT(22);

		bt.root.left.left = new Node_ADT(5);
		bt.root.left.right = new Node_ADT(3);
		bt.root.right.right = new Node_ADT(25);

		bt.root.left.right.left = new Node_ADT(10);
		bt.root.left.right.right = new Node_ADT(14);

		bt.root.left.right.left.left = new Node_ADT(100);
		
		bt.root.left.right.left.left.left = new Node_ADT(200);
		
		/*
		 *   20 
		 *  /  \ 
		 *  8  22 
		 * / \  \ 
		 * 5 3  25 
		 *  / \ 
		 * 10 14
		 * /
	     *100
	    * /
	  * 200
	*/
		
		//DLL: 5,8,200,100,10,3,14,  20,   22,25
		
		inOrder(bt.root);
	System.out.println();
		btToDLL(bt.root);
		System.out.println("head.data="+head.data);
		System.out.println();
		printDLL(head);
		inOrder(bt.root);
	}
	static Node_ADT prev = null;
	static Node_ADT head = null;
	
	public static void btToDLL(Node_ADT root)
	{
		//base case
		if(root==null)
		{
			return;
		}
		
		btToDLL(root.left); //root is at 5
		
		//updating the root to point to the bottom leftmost node
		if(head == null)
		{
			head = root;
		}
		else
		{
			root.left=prev;
			prev.right=root;
		}
		prev=root; //updating prev
		
		btToDLL(root.right);
	}
	
	public static void inOrder(Node_ADT root)
	{
		// Base Case (Simplest Computation)
		if (root == null)
		{
			return;
		}

		inOrder(root.left); // RECURSION (left subtree)
		System.out.print(root.data + " ");
		inOrder(root.right); // RECURSION (right subtree)
	}
	
	public static void printDLL(Node_ADT head)
	{
		Node_ADT traversalNode= head;
		
		while(traversalNode!=null)
		{
			System.out.print(traversalNode.data + " ");
			traversalNode=traversalNode.right;
		}
		System.out.println();
	}
	

}
