import java.util.HashMap;

public class _26_MaxSumOfNodesWithNoAdjElements
{
	// no need to import (referring the class in same package)
	Node_ADT root;
	
	public static void main(String[] args)
	{
		_26_MaxSumOfNodesWithNoAdjElements bt = new _26_MaxSumOfNodesWithNoAdjElements();

		bt.root = new Node_ADT(20);

		bt.root.left = new Node_ADT(8);
		bt.root.right = new Node_ADT(22);

		bt.root.left.left = new Node_ADT(5);
		bt.root.left.right = new Node_ADT(3);
		bt.root.right.right = new Node_ADT(25);

		bt.root.left.right.left = new Node_ADT(10);
		bt.root.left.right.right = new Node_ADT(14);

		bt.root.left.right.left.left = new Node_ADT(100);
		
		bt.root.left.right.left.left.left = new Node_ADT(200);
		
		/*
		 *   20 
		 *  /  \ 
		 *  8  22 
		 * / \  \ 
		 * 5 3  25 
		 *  / \ 
		 * 10 14
		 * /
	     *100
	    * /
	  * 200
	*/
		
		System.out.println("Max Sum: " + findSum(bt.root));
	}

	public static int getSumOfGrandChilds(Node_ADT root)
	{
		if(root==null)
		{
			return 0;
		}
		
		int leftGCSum = 0, rightGCSum=0;
		
		if(root.left != null)
		{
			leftGCSum=findSum(root.left.left)+findSum(root.left.right);
		}
		
		if(root.right!= null)
		{
			rightGCSum=findSum(root.right.left)+findSum(root.right.right);
		}

		return leftGCSum+rightGCSum;
		
	}
	
	static HashMap<Node_ADT,Integer> sumPairs = new HashMap<>();
	
	public static int findSum(Node_ADT root)
	{
		if(root == null)
		{
			return 0;
		}
		
		if(sumPairs.containsKey(root))
		{
			return sumPairs.get(root);
		}
		int sumWithRoot=root.data + getSumOfGrandChilds(root);
		int sumOnLeftOfRoot = findSum(root.left);
		int sumOnRightOfRoot=findSum(root.right);
		int sumExcludingRoot = sumOnLeftOfRoot +sumOnRightOfRoot;
		
		System.out.println("currNode:"+root.data + ", leftSum: " + sumOnLeftOfRoot + ", rightSum: " + sumOnRightOfRoot
						+ ", sum Excluding Root: " + sumExcludingRoot + ", sum Including Root: " + sumWithRoot);
		
		int maxSum=Math.max(sumWithRoot, sumExcludingRoot);
		sumPairs.put(root,maxSum);
		
		return maxSum;
	}
	
}
