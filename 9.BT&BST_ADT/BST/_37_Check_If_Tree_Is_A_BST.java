import java.util.ArrayList;

public class _37_Check_If_Tree_Is_A_BST
{
	static // no need to import (referring the class in same package)
	Node_ADT rootNode;
	static int min = Integer.MIN_VALUE; // cannot be in recursive call (prevents unintentional resetting)
	static int max = Integer.MAX_VALUE; // cannot be in recursive call (prevents unintentional resetting)

	public static void main(String[] args)
	{
		rootNode = new Node_ADT(50);

		rootNode.left = new Node_ADT(20);
		rootNode.right = new Node_ADT(60);

		rootNode.left.right = new Node_ADT(25);
		rootNode.right.left = new Node_ADT(55);

		rootNode.right.right = new Node_ADT(80);

		ArrayList<Integer> inOrderArray = new ArrayList<>();
		storeInOrderInArray(rootNode, inOrderArray); // due to being a BSt in order gives sorted order
		System.out.println("In Order Array" + inOrderArray.toString());

		System.out.println("bruteforce --> Is BT a BST?: " + isBT_A_BST(inOrderArray));

		System.out.println(bruteForce_IsBST(rootNode));
		
		System.out.println("Optimized--> Is BT a BST?: " + optimized_IsBST(rootNode, min, max));
		
		System.out.println("Optimized2--> Is BT a BST?: " + Optimized2_IsBST(rootNode, null, null));
	}
	
	
	//Pre Order (checking against root.data)
	public static boolean Optimized2_IsBST(Node_ADT root, Node_ADT leftNode, Node_ADT rightNode)
	{
		//empty tree is a balanced tree
		if(root == null)
		{
			return true;
		}
		
		if(leftNode!= null && leftNode.data >root.data)
		{
			return false;
		}
		
		if(rightNode != null && rightNode.data < root.data)
		{
			return false;
		}
		boolean isLeftBalanced = Optimized2_IsBST(root.left, leftNode, root);
		boolean isRightBalanced =Optimized2_IsBST(root.right, root, rightNode);
		//iff both the subtrees are balanced then the entire tree is balanced
		return isLeftBalanced && isRightBalanced;
	}
	
	

	//TC=O(N)
	public static boolean optimized_IsBST(Node_ADT root, int min, int max)
	{

		if (root == null)
		{
			return true;
		}

		if (min > root.data)
		{
			return false;
		}
		if (max < root.data)
		{
			return false;
		}
		//happens only once which is why its O(N)
		boolean isLeftBalanced = optimized_IsBST(root.left, min, root.data - 1);
		boolean isRightBalanced = optimized_IsBST(root.right, root.data + 1, max);

		return isLeftBalanced && isRightBalanced;
	}
	
	//TC=O(N^2) skewed tree worst case
	public static boolean bruteForce_IsBST(Node_ADT root)
	{
		// empty tree is always balanced
		if (root == null)
		{
			return true;
		}

		if (root.left != null && root.data < maxValue(root.left))
		{
			return false;
		}
		if (root.right != null && root.data > minValue(root.right))
		{
			return false;
		}

		if (!bruteForce_IsBST(root.left) || !bruteForce_IsBST(root.right))
		{
			return false;
		}

		return true;
	}
	//TC=O(log N)
	public static int maxValue(Node_ADT root)
	{
		int max = root.data;

		while (root != null)
		{
			max = root.data;
			root = root.right;
		}
		System.out.println("Max: " + max);
		return max;
	}

	public static int minValue(Node_ADT root)
	{
		int min = root.data;
		System.out.println("Min1: " + min);

		while (root != null)
		{
			min = root.data;
			root = root.left;
		}
		System.out.println("Min: " + min);
		return min;
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

	// SC=O(N) --BRUTEFORCE
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

	// TC=O(N) --BRUTEFORCE
	public static boolean isBT_A_BST(ArrayList<Integer> inOrderArray)
	{
		boolean isBST = true;

		// started at i=1 so that a[i-1]=a[0] which prevents index out of bounds error
		for (int i = 1; i <= inOrderArray.size() - 1; i++)
		{
			if (inOrderArray.get(i) < inOrderArray.get(i - 1))
			{
				isBST = false;
			}
		}
		return isBST;
	}
}
