
public class _31_MinDistBetweenTwoNodes
{
	// no need to import (referring the class in same package)
	Node_ADT root;

	public static void main(String[] args)
	{
		_31_MinDistBetweenTwoNodes bt = new _31_MinDistBetweenTwoNodes();
		bt.root = new Node_ADT(1);
		bt.root.left = new Node_ADT(2);
		bt.root.right = new Node_ADT(3);
		bt.root.right.right = new Node_ADT(4);

		System.out.println("Min Dist Between 2 nodes: " + minDistBetweenTwoNodes(bt.root, bt.root.left, bt.root.right.right ));

	}

	public static int minDistBetweenTwoNodes(Node_ADT root, Node_ADT x, Node_ADT y)
	{
		Node_ADT lca = null;

		if (isNodePresent(root, y) && isNodePresent(root, x))
		{
			lca = findLCA(root, x, y);
		}
		else
		{
			return Integer.MIN_VALUE;
		}
		return findLevel(lca, x, 0) + findLevel(lca, y, 0);
	}

	public static Node_ADT findLCA(Node_ADT root, Node_ADT x, Node_ADT y)
	{
		if (root == null)
		{
			return null;
		}

		if (root == x || root == y)
		{
			return root;
		}

		Node_ADT left = findLCA(root.left, x, y);
		Node_ADT right = findLCA(root.right, x, y);

		if (left != null && right != null)
		{
			return root;
		}

		if (left != null)
		{
			return left;
		}

		if (right != null)
		{
			return right;
		}

		return null;
	}

	public static boolean isNodePresent(Node_ADT root, Node_ADT node)
	{
		if (root == null)
		{
			return false;
		}

		if (root == node)
		{
			return true;
		}
		return isNodePresent(root.left, node) || isNodePresent(root.right, node);
	}

	public static int findLevel(Node_ADT root, Node_ADT node, int level)
	{
		if (root == null)
		{
			return Integer.MIN_VALUE;
		}

		if (root == node)
		{
			return level;
		}

		int left = findLevel(root.left, node, level + 1);

		if (left != Integer.MIN_VALUE)
		{
			return left;
		}

		return findLevel(root.right, node, level + 1);
	}
}
