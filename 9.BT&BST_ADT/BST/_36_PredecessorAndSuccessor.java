import java.util.ArrayList;

public class _36_PredecessorAndSuccessor
{
	static // no need to import (referring the class in same package)
	Node_ADT rootNode;
	static int predecessor;
	static int successor;

	public static void main(String[] args)
	{
		rootNode = new Node_ADT(50);

		insert(rootNode, 20);
		insert(rootNode, 60);
		insert(rootNode, 25);
		insert(rootNode, 55);
		insert(rootNode, 80);
		insert(rootNode, 90);
		insert(rootNode, 100);
		insert(rootNode, 85);
		insert(rootNode, 15);

		ArrayList<Integer> inOrderArray = new ArrayList<>();
		storeInOrderInArray(rootNode, inOrderArray); // due to being a BSt in order gives sorted order
		System.out.println("In Order Array" + inOrderArray.toString());

		bruteForce_FindPredSuccess(inOrderArray, 25);

		System.out.println("Predecessor: " + predecessor);
		System.out.println("Successor: " + successor);

		// resetting values
		predecessor = -1;
		successor = -1;

		optimized_FindPredSuccess(rootNode, 60);

		System.out.println("Predecessor: " + predecessor);
		System.out.println("Successor: " + successor);

	}

	// TC=O(log N) using the BST to search
	// SC=O(1) due to not using any external ds
	//finds in order success of a single node only
	public static void optimized_FindPredSuccess(Node_ADT root, int key)
	{

		if (root == null)
		{
			return;
		}

		if (key < root.data)
		{
			successor = root.data;
			optimized_FindPredSuccess(root.left, key);
		}
		else if (key > root.data)
		{
			predecessor = root.data;
			optimized_FindPredSuccess(root.right, key);
		}
		else // key = root.data (FINDS FOR CHILDS)
		{
			if (root.right != null)
			{
				successor = findMax(root.right);
			}
			if (root.left != null)
			{
				predecessor = findMin(root.left);
			}

		}
	}

	// TC=O(N) due to searching the array SC=O(N) due to storing the inorder
	// traversal in an array
	public static void bruteForce_FindPredSuccess(ArrayList<Integer> inOrderArray, int key)
	{
		for (int i = 1; i <= inOrderArray.size() - 2; i++)
		{
			if (inOrderArray.get(i) == key)
			{
				predecessor = inOrderArray.get(i - 1);
				successor = inOrderArray.get(i + 1);
			}
		}
	}

	public static void storeInOrderInArray(Node_ADT root, ArrayList<Integer> inOrderArray)
	{

		// Base Case (Simplest Computation)
		if (root == null)
		{
			return;
		}

		storeInOrderInArray(root.left, inOrderArray); // RECURSION (left subtree)
		inOrderArray.add(root.data);
		storeInOrderInArray(root.right, inOrderArray); // RECURSION (right subtree)
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

	// InOrder Sucessor is node.rights left most node
	public static int findMax(Node_ADT root)
	{
		while (root.left != null)
		{
			root = root.left;
		}
		return root.data;
	}

	public static int findMin(Node_ADT root)
	{
		while (root.right != null)
		{
			root = root.right;
		}
		return root.data;
	}

}
