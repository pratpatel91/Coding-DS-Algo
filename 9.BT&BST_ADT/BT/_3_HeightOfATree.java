public class _3_HeightOfATree
{
	// no need to import (referring the class in same package)
	Node_ADT root;

	public static void main(String[] args)
	{
		_3_HeightOfATree bt = new _3_HeightOfATree();

		bt.root = new Node_ADT(1);
		bt.root.left = new Node_ADT(2);
		bt.root.right = new Node_ADT(3);
		bt.root.left.left = new Node_ADT(4);
		bt.root.left.right = new Node_ADT(5);
		bt.root.right.left = new Node_ADT(6);
		bt.root.right.right = new Node_ADT(7);
		bt.root.right.left.right = new Node_ADT(8);

		System.out.println(heightOfTree(bt.root));
	}

	public static int heightOfTree(Node_ADT root)
	{
		// base case (empty tree)
		if (root == null)
		{
			return 0;
		}
		// +1 indicates that have taken the curr node into account for calculating the
		// height
		return (Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1);
	}

}
