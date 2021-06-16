
public class _30_KthAncestor
{
	// no need to import (referring the class in same package)
	Node_ADT root;

	public static void main(String[] args)
	{
		_17_GenDLLFromABT bt = new _17_GenDLLFromABT();

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

		Node_ADT kAncestor = kthAncestor(bt.root, 200);
		
		if(kAncestor != null)
		{
			System.out.println(kAncestor.data);
		}
	}
	
	static Node_ADT found = null;
	static int K = 1; //static because we want the kthAncestor to be the same during recursion
	
	public static Node_ADT kthAncestor(Node_ADT root, int target)
	{
		if(root==null) //!root
		{
			return null;
		}
		
		if(root.data==target
				|| (found = kthAncestor(root.left, target))!=null 
		        || (found = kthAncestor(root.right, target))!=null )
		{
			System.out.print(root.data + ", ");
			if(K>0)
			{
				K--;
			}
			else if (K==0)
			{
				System.out.println("Kth Ancestor of "+ target + " is " + root.data);
				return null; //stopping the recursion after we found the kth ancestor
			}
			return root;
		}
		return null;
	}
}
