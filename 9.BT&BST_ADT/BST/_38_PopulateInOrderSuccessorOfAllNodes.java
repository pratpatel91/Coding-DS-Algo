
public class _38_PopulateInOrderSuccessorOfAllNodes
{
	static TreeNode rootNode, successorNode;

	static class TreeNode
	{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode next; // points to successor

		TreeNode(int data)
		{
			this.data = data;
			this.left = null;
			this.right = null;
			this.next = null;
		}
	}

	public static void main(String[] args)
	{
		rootNode = new TreeNode(50);

		insert(rootNode, 20);
		insert(rootNode, 60);
		insert(rootNode, 25);
		insert(rootNode, 55);
		insert(rootNode, 80);

		inOrder(rootNode);
		printSuccessor(rootNode.left); // starting print out from smallest node
	}

	public static void printSuccessor(TreeNode root)
	{
		int successor = -1;

		while (root != null)
		{
			if (root.next != null)
			{
				successor = root.next.data;
			}
			else
			{
				successor = -1;
			}
			System.out.println(root.data + "->" + successor);

			// moving forward
			root = root.next;
		}

	}

	public static void inOrder(TreeNode root)
	{
		if (root != null)
		{
			inOrder(root.right);
//			if (successorNode != null)
//			{
//				System.out.println("prev Node: " + root.data + ", prev Successor:" + successorNode.data);
//			}
			root.next = successorNode;
//			if (successorNode != null)
//			{
//				System.out.println("new Node: " + root.data + ", prev Successor:" + successorNode.data);
//			}
			successorNode = root;
//			if (successorNode != null)
//			{
//				System.out.println("prev Node: " + root.data + ", new Successor:" + successorNode.data);
//			}
			inOrder(root.left);
		}
	}

	public static TreeNode insert(TreeNode root, int value)
	{
		// Base case (Creating a new node for the first time)
		if (root == null)
		{
			root = new TreeNode(value);
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
