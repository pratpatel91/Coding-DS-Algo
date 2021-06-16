
public class _14_CheckForBalancedTree
{

	// no need to import (referring the class in same package)
	Node_ADT root;
	
	public static void main(String[] args)
	{
		_14_CheckForBalancedTree bt = new _14_CheckForBalancedTree();

		bt.root = new Node_ADT(20);

		bt.root.left = new Node_ADT(8);
		bt.root.right = new Node_ADT(22);

		bt.root.left.left = new Node_ADT(5);
		bt.root.left.right = new Node_ADT(3);
		bt.root.right.right = new Node_ADT(25);
		
		

		bt.root.left.right.left = new Node_ADT(10);
		bt.root.left.right.right = new Node_ADT(14);
		bt.root.right.right.right = new Node_ADT(50);
		
		bt.root.left.right.left.left = new Node_ADT(100);
		bt.root.right.right.right.right = new Node_ADT(60);
		
		bt.root.left.right.left.left.left = new Node_ADT(200);
		bt.root.right.right.right.right.right = new Node_ADT(80);
		
		/*
		 *   20 
		 *  /  \ 
		 *  8  22 
		 * / \  \ 
		 * 5 3  25 
		 *  / \  \
		 * 10 14  50
		 * /      \
		 *100      60  
	    * /         \
	  * 200         80 
		 * 
		 */
		System.out.println("is tree balanced?: " + bruteForce_isTreeBalanced(bt.root));
			
		System.out.println("is tree balanced?: " + optimized_isTreeBalanced(bt.root));
		System.out.println("is tree balanced?: " + isBalanced);
		
		System.out.println("BruteForce Visited Nodes: "+bruteForceCount + " Optimized Visited Nodes: "+optimizedCount);
	}
	
	//TC=O(N)
	public static int height(Node_ADT node)
	{
		bruteForceCount++;
		if(node== null)
		{
			return 0 ;
		}
		return Math.max(height(node.left),height(node.right))+1;
	}
	static int bruteForceCount=0;
	
	
	//TC=O(N^2) because for every node we are calculating the height aswell as if the node is balanced or not
	public static boolean bruteForce_isTreeBalanced(Node_ADT root)
	{
		if(root==null)
		{
			return true;
		}
		 bruteForceCount++;
		int leftHeight = height(root.left); //subtree
		//System.out.println("left Height:" + leftHeight);
		int rightHeight = height(root.right); //subtree
		//System.out.println("right Height:" + rightHeight);
		//isTreeBalanced(root.left) && isTreeBalanced(root.right) incrementally checks if the tree is balanced
		return (Math.abs(leftHeight-rightHeight)<=1 && bruteForce_isTreeBalanced(root.left) && bruteForce_isTreeBalanced(root.right));
	}
	
	static boolean isBalanced=true;
	static int optimizedCount=0;
	
	//TC=O(N)because for every node we are checking if the node is balanced or not only
	public static int optimized_isTreeBalanced(Node_ADT root)
	{
		if(root==null)
		{
			return 0;
		}
		
		optimizedCount++;
		int leftHeight = optimized_isTreeBalanced(root.left); //subtree
		//System.out.println("left Height:" + leftHeight);
		int rightHeight = optimized_isTreeBalanced(root.right); //subtree
	//	System.out.println("right Height:" + rightHeight);
		
		int balanceFactor=Math.abs(leftHeight-rightHeight);

		if(balanceFactor >1)
		{
			isBalanced=false;
		}
		
		//isTreeBalanced(root.left) && isTreeBalanced(root.right) incrementally checks if the tree is balanced
		return Math.max(leftHeight, rightHeight)+1;
	}

}
