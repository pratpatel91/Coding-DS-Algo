
public class _39_FindLCAOf2NodesInABST
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
		insert(rootNode, 40);

		Node_ADT lca = findLCA(rootNode, 25, 40);
		System.out.println("findLCA(25,40)=" + lca.data);
		lca = findLCA(rootNode, 40, 55);
		System.out.println("findLCA(40,55)=" + lca.data);
	}

	public static Node_ADT findLCA(Node_ADT node, int n1, int n2)
	{
		if(node == null)
		{
			return null;
		}
		
		if (n1 > node.data && n2 > node.data)
		{
			return findLCA(node.right,n1,n2);
		}
		if (n1 < node.data && n2 < node.data)
		{
			return findLCA(node.left,n1,n2);
		}
		return node;
	}

	// TC=O(N) SC=O(N) ------------BT Code
//	public static Node_ADT findLCA(Node_ADT node, int n1, int n2)
//	{
//		//base case
//		if(node == null)
//		{
//			return null;
//		}
//		
//		if(node.data == n1 || node.data == n2)
//		{
//			return node;
//		}
//		
//		Node_ADT leftLCA = findLCA(node.left, n1,n2);
//		Node_ADT rightLCA = findLCA(node.right,n1,n2);
//		
//		if(leftLCA!=null && rightLCA != null)
//		{
//			return node;
//		}
//		
//		if(leftLCA!=null)
//		{
//			return leftLCA;
//		}
//		else
//		{
//			return rightLCA;
//		}
//	}

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
}
