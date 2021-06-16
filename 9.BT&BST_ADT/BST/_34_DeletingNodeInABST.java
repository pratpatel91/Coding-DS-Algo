
public class _34_DeletingNodeInABST
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

		delete(rootNode, 50);
		System.out.println();
		inOrder(rootNode);

	}

	public static Node_ADT delete(Node_ADT root, int key)
	{
		if (root == null)
		{
			return null;
		}

		if (key > root.data)
		{
			root.right = delete(root.right, key);
		}
		else if (key < root.data)
		{
			root.left = delete(root.left, key);
		}
		else
		{
			// case1: deleting a node with no childs
			if (root.left == null && root.right == null)
			{
				return null;
			}
			// case2: deleting a node with 1 child
			else if (root.left == null)
			{
				return root.right;
			}
			else if (root.right == null)
			{
				return root.left;
			}
			// case3: deleting a node with 2 childs
			else if (root.left != null && root.right != null)
			{
				//------Alternative code to find the successor------//
//				Node_ADT traversalNode = root.right;
//				
//				// inOrderSuccessor is used to maintain
//				// bst property LC<Node<RC
//				Node_ADT inOrderSuccessor = root.right; // 60
//
//				// finding the right nodes left most child if it exists
//				while (traversalNode != null)
//				{
//					inOrderSuccessor = traversalNode;
//					traversalNode = traversalNode.left;
//				}
				
				int successorValue = findMin(root.right);
				
				System.out.println("successor Value: "+successorValue);
				root.data = successorValue; // 2 nodes have same values here

				// deleting the other node with the same value
				root.right = delete(root.right, successorValue);
			}
		}
		return root;
	}
	
	public static int findMin(Node_ADT root)
	{
		while(root.left != null)
		{
			root=root.left;
		}
		return root.data;
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
}
