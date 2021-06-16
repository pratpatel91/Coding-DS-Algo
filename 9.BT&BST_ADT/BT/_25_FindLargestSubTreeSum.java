
public class _25_FindLargestSubTreeSum
{
	// no need to import (referring the class in same package)
	Node_ADT root;
	
	public static void main(String[] args)
	{
		_25_FindLargestSubTreeSum bt = new _25_FindLargestSubTreeSum();

		bt.root = new Node_ADT(-2000);

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
		System.out.println("currSum: "+bt.largestSubTreeSum(bt.root));
		System.out.println("Max Sum: " + maxSum);
	}
	
	static int maxSum=Integer.MIN_VALUE;
	
	public int largestSubTreeSum(Node_ADT root)
	{
		if(root ==null)
		{
			return 0;
		}
		
		int currValue=root.data;
		int leftSum=largestSubTreeSum(root.left);
		int rightSum=largestSubTreeSum(root.right);
		System.out.println("Curr Value: " + currValue + ", lSUm: " + leftSum + ", rSum: " + rightSum);
		int currSum=currValue+leftSum+rightSum;
				
		maxSum=Math.max(currSum, maxSum);
		System.out.println("maxSum: " + maxSum);
		
		return currSum;
	}
}
