import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class BST
{
	static TreeNode_ADT rootNode;

	class TreeNode_ADT
	{
		int data;
		TreeNode_ADT left;
		TreeNode_ADT right;

		TreeNode_ADT(int value)
		{
			data = value;
			left = null;
			right = null;
		}
	}

	// ADT Functionalities
	public TreeNode_ADT insert(TreeNode_ADT root, int value)
	{
		if (rootNode == null)
		{
			return new TreeNode_ADT(value); // create a new node
		}

		if (value < rootNode.data)
		{
			System.out.print("\tNode" + value + " inserted to the left\n");
			root.left = insert(root.left, value);
		}
		else if (value > rootNode.data)
		{
			System.out.print("\tNode" + value + " inserted to the right\n");
			root.right = insert(root.right, value);
		}

		return root;
	}

	public boolean find(TreeNode_ADT root, int value)
	{
		while (root != null)
		{
			if (root.data == value)
			{
				return true;
			}
			if (value < root.data)
			{
				root = root.left;
			}
			else
			{
				root = root.right;
			}
		}
		return false;
	}

	// ADT Functionalities
	public void printPreOrder(TreeNode_ADT root)
	{
		// Base Case (Simplest Computation)
		if (root == null)
		{
			return;
		}

		System.out.print(root.data + " ");
		printPreOrder(root.left); // RECURSION (left subtree)
		printPreOrder(root.right); // RECURSION (right subtree)
	}

	public void printInOrder(TreeNode_ADT root)
	{
		// Base Case (Simplest Computation)
		if (root == null)
		{
			return;
		}

		printInOrder(root.left); // RECURSION (left subtree)
		System.out.print(root.data + " ");
		printInOrder(root.right); // RECURSION (right subtree)
	}

	public void printPostOrder(TreeNode_ADT root)
	{
		// Base Case (Simplest Computation)
		if (root == null)
		{
			return;
		}

		printPostOrder(root.left); // RECURSION (left subtree)
		printPostOrder(root.right); // RECURSION (right subtree)
		System.out.print(root.data + " ");

	}

	// ADT Functionalities
	public void breadthFirstSearch(TreeNode_ADT root)
	{
		if (root == null)
		{
			return;
		}

		Queue<TreeNode_ADT> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty())
		{
			TreeNode_ADT node = q.remove();

			System.out.print(" " + node.data);

			if (node.left != null)
			{
				q.add(node.left);
			}

			if (node.right != null)
			{
				q.add(node.right);
			}
		}
	}

	public void depthFirstSearch(TreeNode_ADT root)
	{
		Stack<TreeNode_ADT> s = new Stack<>();
		s.add(root);

		while (s.isEmpty() == false)
		{
			TreeNode_ADT top = s.pop();
			if (top.right != null)
			{
				s.add(top.right);
			}
			if (top.left != null)
			{
				s.add(top.left);
			}
			System.out.print(" " + top.data);
		}
	}

	public static void main(String[] args)
	{
		BST bst = new BST();


		int[] treeElements = { 3, 2, 1 };

		for (int i = 0; i <= treeElements.length - 1; i++)
		{
			rootNode = bst.insert(rootNode, treeElements[i]);
		}

		System.out.print("\nbst.printPreOrder() = ");
		bst.printPreOrder(rootNode);

		System.out.print("\nbst.printInOrder() = ");
		bst.printInOrder(rootNode);

		System.out.print("\nbst.printPostOrder() = ");
		bst.printPostOrder(rootNode);

		System.out.print("\nbst.find(4) = " + bst.find(rootNode, 4));

		System.out.print("\nbst.breadthFirstSearch() = ");
		bst.breadthFirstSearch(rootNode);

		System.out.print("\nbst.depthFirstSearch() = ");
		bst.depthFirstSearch(rootNode);
	}
}
