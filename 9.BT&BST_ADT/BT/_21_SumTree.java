public class _21_SumTree
{
	// no need to import (referring the class in same package)
	Node_ADT root;

	public static void main(String[] args)
	{
		_21_SumTree bt = new _21_SumTree();
		bt.root = new Node_ADT(3);
		bt.root.left = new Node_ADT(1);
		bt.root.right = new Node_ADT(2);
		System.out.println("IsSumTree?: "+isSumTree(bt.root));
	}

	//TC=O(N) processing every node once in the binary tree
	//SC=O(N) due to storing N nodes in a binary tree
	public static boolean isSumTree(Node_ADT root)
	{
		// base case handling simplest calculation (empty tree)
		if (root == null)
		{
			return false;
		}

		if (root.left == null && root.right == null)
		{
			return true;
		}

		int btSumWithoutRootNode = btSumWithoutRootNode(root);

		if (root.data == btSumWithoutRootNode)
		{
			return true;
		}
		return false;
	}

	public static int btSumWithoutRootNode(Node_ADT root)
	{
		if (root == null)
		{
			return 0;
		}

		return (btSumWithoutRootNode(root.left) + btSumWithoutRootNode(root.right));
	}

}
