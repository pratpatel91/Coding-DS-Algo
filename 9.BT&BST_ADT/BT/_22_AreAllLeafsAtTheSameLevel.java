public class _22_AreAllLeafsAtTheSameLevel
{
	// no need to import (referring the class in same package)
	Node_ADT root;
	static int levelOfLeaf;
	
	public static void main(String[] args)
	{
		_21_SumTree bt = new _21_SumTree();
		bt.root = new Node_ADT(3);
		bt.root.left = new Node_ADT(1);
		bt.root.right = new Node_ADT(2);
		bt.root.left.left = new Node_ADT(1);
		System.out.println("AreLeavesAtSameLevel?: "+areLeavesAtSameLevel(bt.root,1));
	}

	//TC=O(N) processing every node once in the binary tree
	//SC=O(N) due to storing N nodes in a binary tree
	public static boolean areLeavesAtSameLevel(Node_ADT root, int level)
	{
		if(root==null)
		{
			return true;
		}
		if(root.left==null && root.right==null)
		{
			if(levelOfLeaf ==0)
			{
				levelOfLeaf=level;
				return true;
			}
			return levelOfLeaf == level;
		}
		return areLeavesAtSameLevel(root.left,level+1) && areLeavesAtSameLevel(root.right,level+1);
	}
}
