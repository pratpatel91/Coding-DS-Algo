public class _22_FindingValueInABST
{
	static // no need to import (referring the class in same package)
	Node_ADT rootNode;

	public static void main(String[] args)
	{
		
		rootNode = new Node_ADT(50);

		insert(rootNode, 20);
		insert(rootNode, 60);
		insert(rootNode, 25);
		insert(rootNode, 55);
		insert(rootNode, 80);

		inOrder(rootNode); // due to being a BSt in order gives sorted order

		Node_ADT foundNode = search(rootNode, 55);
		
		if(foundNode != null)
		{
			System.out.println("\nFound Node: " + foundNode.data + " in the BST");
		}
		
		int minValue = computeMinNode(rootNode);
		int maxValue = computeMaxNode(rootNode);
		System.out.println("Min: " + minValue + ", Max: " + maxValue);
	}
	
	public static Node_ADT insert(Node_ADT root, int value)
	{
		// Base case (Creating a new node for the first time)
		if (root == null)
		{
			root = new Node_ADT(value);
			return root;
		}

		// placing all other nodes into the BST per constraints (left<root<right)
		if (value < root.data)
		{
			System.out.println("\tinserting " + value + " as a left child");
			root.left = insert(root.left, value); // RECURSION
		}
		else if (value > root.data)
		{
			System.out.println("\tinserting " + value + " as a right child");
			root.right = insert(root.right, value); // RECURSION
		}
		return root;
	}
	
	public static Node_ADT search(Node_ADT root, int value)
	{
		
		if (root.data == value || root == null)
		{
			return root;
		}
		
		//Similar to a recursive binary search
		if (root.data < value)
		{
			return search(root.right, value);
		}
		return search(root.left, value);
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
	
	public static int computeMinNode(Node_ADT root)
	{
		Node_ADT traversalNode = null;
		
		while(root!=null)
		{
			traversalNode=root; //assigning the node prior to the null node
			root=root.left; //traversal process
		}
		return traversalNode.data;
	}
	
	public static int computeMaxNode(Node_ADT root)
	{
		Node_ADT traversalNode = null;
		
		while(root!=null)
		{
			traversalNode=root; //assigning the node prior to the null node
			root=root.right; //traversal process
		}
		return traversalNode.data;
	}

}
