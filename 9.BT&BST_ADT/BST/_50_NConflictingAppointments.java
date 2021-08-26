
public class _50_NConflictingAppointments
{

	static class Pair
	{
		int startTime;
		int endTime;

		Pair(int startTime, int endTime)
		{
			this.startTime = startTime;
			this.endTime = endTime;
		}
	}
	static class TreeNodeADT
	{
		Pair pairNode; // TreeNode uses Pair data
		TreeNodeADT left;
		TreeNodeADT right;
		int maxTillNow = Integer.MIN_VALUE;

		TreeNodeADT(int startTime, int endTime)
		{
			this.pairNode = new Pair(startTime, endTime);
			left = null;
			right = null;
		}
	}
	static TreeNodeADT newNode(Pair pairNode)
	{
		TreeNodeADT node = new TreeNodeADT(pairNode.startTime, pairNode.endTime);
		return node;
	}
	static TreeNodeADT insert(TreeNodeADT root, Pair pairNode)
	{
		if (root == null)
		{
			return newNode(pairNode);
		}
		int low = root.pairNode.startTime;

		// insert as left child
		if (pairNode.startTime < low)
		{
			root.left = insert(root.left, pairNode);
		}
		// insert as right child
		else if (pairNode.startTime > low)
		{
			root.right = insert(root.right, pairNode);
		}
		if (pairNode.endTime > root.maxTillNow)
		{
			root.maxTillNow = pairNode.endTime;
		}
		return root;
	}

	public static boolean isConflict(Pair pair1, Pair pair2)
	{
		if (pair2.endTime > pair1.startTime && pair1.endTime > pair2.startTime)
		{
			return true;
		}
		return false;
	}
	public static void printConflicts(Pair[] pairArray, int events)
	{
		TreeNodeADT root = null; // rootPair

		//placing the first pair into the BST as root
		root = insert(root, pairArray[0]);

		//conflicting pairs are used to build the BST
		for (int i = 1; i <= events - 1; i++)
		{
			Pair conflictedWith = isRangeOverlap(root, pairArray[i]);
			if(conflictedWith != null)
			{
				System.out.println(pairArray[i].startTime + "-" + pairArray[i].endTime + " has conflicted with "
						+ conflictedWith.startTime + "-" + conflictedWith.endTime);
			}
			//inserting conflicting pair to the tree
			root=insert(root,pairArray[i]);
		}
	}
	public static Pair isRangeOverlap(TreeNodeADT root, Pair pair)
	{
		if (root == null)
		{
			return null;
		}
		if (isConflict(root.pairNode, pair))
		{
			return root.pairNode;
		}
		if (root.left != null && root.left.maxTillNow >= pair.startTime)
		{
			return isRangeOverlap(root.left, pair);
		}
		return isRangeOverlap(root.right, pair);
	}
	public static void main(String[] args)
	{
		// created a list of pairs
		Pair[] pairArray = new Pair[6];
		pairArray[0] = new Pair(1, 5);
		pairArray[1] = new Pair(3, 7);
		pairArray[2] = new Pair(2, 6);
		pairArray[3] = new Pair(10, 15);
		pairArray[4] = new Pair(5, 6);
		pairArray[5] = new Pair(4, 100);
		printConflicts(pairArray, pairArray.length);
	}
}
