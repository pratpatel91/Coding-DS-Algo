
public class _53_LargestBSTOptimized
{
	static Node_ADT rootNode;

	// grouping info/ optimization to reduce TC from N^2 to N
	static class Info
	{
		int min;
		int max;
		int size;
		boolean isBST;

		public Info(int min, int max, int size, boolean isBST)
		{
			this.min = min;
			this.max = max;
			this.size = size;
			this.isBST = isBST;
		}
	}

	public static void main(String[] args)
	{
		rootNode = new Node_ADT(50);

		rootNode.left = new Node_ADT(20);
		rootNode.right = new Node_ADT(60);

		rootNode.left.right = new Node_ADT(25);
		rootNode.right.left = new Node_ADT(55);

		rootNode.right.right = new Node_ADT(40);

		System.out.println("largest bst: " + largestBST(rootNode));
	}

	// TC=O(N)
	public static int largestBST(Node_ADT root)
	{
		return isBST(root).size;
	}

	// TC=O(N)
	public static Info isBST(Node_ADT root)
	{

		if (root == null)
		{
			return new Info(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
		}

		Info Left = isBST(root.left);
		Info Right = isBST(root.right);
		Info info = null;
		System.out.println("Lefts Min:" + Left.min + ", Lefts Max:" + Left.max + ", Lefts TreeSize:" + Left.size);
		System.out.println("Rights Min:" + Right.min + ", Rights Max:" + Right.max + ", Rights TreeSize:" + Right.size);
		
		if (Left.isBST && Right.isBST && root.data > Left.max && root.data < Right.min)
		{
			int min = Math.min(root.data, Math.min(Left.min, Right.min));
			int max = Math.max(root.data, Math.max(Left.max, Right.max));

			int treeSize = Left.size + Right.size + 1;
			System.out.println("min:" + min + ", max:" + max + ", treeSize:" + treeSize);
			info = new Info(min, max, treeSize, true);
		}
		else
		{
			info = new Info(0, 0, Math.max(Left.size, Right.size), false);
		}

		return info;
	}

}
