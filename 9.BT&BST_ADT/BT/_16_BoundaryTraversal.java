
public class _16_BoundaryTraversal
{
	// no need to import (referring the class in same package)
	Node_ADT root;

	public static void main(String[] args)
	{
		_16_BoundaryTraversal bt = new _16_BoundaryTraversal();

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
		 * 
		 */
		//explicitly printing the root value
		if(bt.root!=null)
		{
			System.out.print(bt.root.data);
		}
		
		System.out.println("\n");
		printLeftBoundary(bt.root.left);
		System.out.println("\n");
		printLeafNodes(bt.root.left); // printing from left
		System.out.println("\n");
		printLeafNodes(bt.root.right); // printing from right
		System.out.println("\n");
		printRightBoundary(bt.root.right);
	}

	// NLR (pre order)
	public static void printLeftBoundary(Node_ADT root)
	{
		if (root != null) // Left Boundary is excluding the root
		{
			if (root.left != null)
			{
				System.out.print("LBLN:" + root.data + " "); //printing the node
				printLeftBoundary(root.left);  //traversing the left
			}
			else if (root.right != null)
			{
				System.out.print("LBRN:" + root.data + " ");//printing the node 
				printLeftBoundary(root.right);  //traversing the right
			}
		}
	}

	
	// RLN (post order)
	public static void printRightBoundary(Node_ADT root)
	{
		if (root != null) // Right Boundary is excluding the root
		{
			if (root.right != null)
			{
				printLeftBoundary(root.right);  //traversing the right
				System.out.print("RBRN:" + root.data + " "); //printing the node
			}
			else if (root.left != null)
			{
				printLeftBoundary(root.left); //traversing the left
				System.out.print("RBLN:" + root.data + " ");  //printing the node
			}
		}
	}
	
	
	// LNR (In order)
	public static void printLeafNodes(Node_ADT root)
	{
		if (root == null)
		{
			return;
		}

		if (root.left != null)
		{
			printLeafNodes(root.left);
		}

		// condition for the leaf node
		if (root.left == null && root.right == null)
		{
			System.out.print(root.data + " ");
		}

		if (root.right != null)
		{
			printLeafNodes(root.right);
		}
	}

}
