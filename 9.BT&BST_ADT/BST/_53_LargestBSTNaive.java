
public class _53_LargestBSTNaive
{

	static Node_ADT rootNode;

	public static void main(String[] args)
	{
		rootNode = new Node_ADT(50);
//
//		insert(rootNode, 20);
//		insert(rootNode, 60);
//		insert(rootNode, 25);
//		insert(rootNode, 55);
//		insert(rootNode, 40);
		
		rootNode.left = new Node_ADT(20);
		rootNode.right = new Node_ADT(60);
		
		rootNode.left.right = new Node_ADT(25);
		rootNode.right.left = new Node_ADT(55);
		
		rootNode.right.right = new Node_ADT(40);

		System.out.println("largest bst: " + largestBST(rootNode));
	}
	// TC=O(N)
	public static int treeSize(Node_ADT root)
	{
		if (root == null)
		{
			return 0;
		}
		return treeSize(root.left) + treeSize(root.right) + 1;
	}
	
	// TC=O(N^2) due to running treeSize inside of isBST in the if condition
	public static int largestBST(Node_ADT root)
	{
		if(root == null)
		{
			return 0;
		}
		if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) //checking if a tree with root is a BST
		{
			System.out.println("tree size:" + treeSize(root));
			return treeSize(root);
		}
		//checking to find the largest bst subtree 
		
		return Math.max(largestBST(root.left), largestBST(root.right));
	}

	// TC=O(N)
	public static boolean isBST(Node_ADT root, int min, int max)
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
		// happens only once which is why its O(N)
		boolean isLeftBalanced = isBST(root.left, min, root.data - 1);
		boolean isRightBalanced = isBST(root.right, root.data + 1, max);

		return isLeftBalanced && isRightBalanced;
	}

	public static boolean isBST(Node_ADT root)
	{
		// TODO Auto-generated method stub
		return false;
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

}
