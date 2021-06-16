
public class _24_SumOfLongestPathFromRootToLeaf
{
	// no need to import (referring the class in same package)
	Node_ADT root;
	static int maxLen;
	static int maxSum;

	public static void main(String[] args)
	{
		_24_SumOfLongestPathFromRootToLeaf bt = new _24_SumOfLongestPathFromRootToLeaf();
		bt.root = new Node_ADT(4);
		bt.root.left = new Node_ADT(2);
		bt.root.right = new Node_ADT(5);
		bt.root.left.left = new Node_ADT(7);
		bt.root.left.right = new Node_ADT(1);
		bt.root.right.left = new Node_ADT(2);
		System.out.println("SumOfLongPathFromRootToLeaf: "+wrapperSumOfLongPathFromRootToLeaf(bt.root));
	}

	public static int wrapperSumOfLongPathFromRootToLeaf(Node_ADT root)
	{
		if (root == null)
		{
			return 0;
		}

		maxSum = Integer.MIN_VALUE;
		maxLen = 0;

		sumOfLongPathFromRootToLeaf(root, 0, 0);

		return maxSum;
	}

	public static void sumOfLongPathFromRootToLeaf(Node_ADT root, int sum, int len)
	{
		if (root == null)
		{
			if (maxLen < len)
			{
				maxLen = len;
				maxSum = sum;
			}
			else if (maxLen == len && maxSum < sum)
				maxSum = sum;
			return;
		}
		sumOfLongPathFromRootToLeaf(root.left, sum + root.data, len + 1);
		sumOfLongPathFromRootToLeaf(root.right, sum + root.data, len + 1);
	}
}