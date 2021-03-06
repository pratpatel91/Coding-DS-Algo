import java.util.Scanner;

class BST
{
	static TreeNode root;
	
	class TreeNode
	{
		int data;
		TreeNode left;
		TreeNode right;
	}

	BST()
	{
		root = null;
	}

	public TreeNode createNewNode(int value)
	{
		TreeNode newNode = new TreeNode();
		newNode.data = value;
		newNode.left = null;
		newNode.right = null;
		return newNode;
	}

	public TreeNode insert(TreeNode root, int value)
	{
		if (root == null)
		{  
			return createNewNode(value);
		}

		if (value < root.data)
		{
			System.out.print("\tNode" + value+ " inserted to the left\n");
			root.left = insert(root.left, value);
		} else if (value > root.data)
		{
			System.out.print("\tNode" + value+ " inserted to the right\n");
			root.right = insert(root.right,value);
		}

		return root;
	}
	
	public void printInOrderTraversal(TreeNode root)
	{
		if (root != null)
		{
		printInOrderTraversal(root.left);
		System.out.print(root.data + " ");
		printInOrderTraversal(root.right);
		}
		else if (root == null)
		{
			return;
		}
	}
	
	public static void main(String[] args)
	{
		BST bst = new BST();

		Scanner input = new Scanner(System.in);
		System.out.print("BST Size?: ");
		int treeSize = input.nextInt();
		
		for (int i = 1; i <= treeSize; i++)
		{
			System.out.print("Node val?: ");
			int value = input.nextInt();
			root = bst.insert(root,value);
		}
		
		bst.printInOrderTraversal(root);
	}
}
