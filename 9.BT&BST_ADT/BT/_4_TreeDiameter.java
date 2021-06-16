
public class _4_TreeDiameter
{
	// no need to import (referring the class in same package)
	Node_ADT root;

	public static void main(String[] args)
	{
		_4_TreeDiameter bt1 = new _4_TreeDiameter();

		bt1.root = new Node_ADT(1);
		bt1.root.left = new Node_ADT(2);
		bt1.root.right = new Node_ADT(3);
		bt1.root.left.left = new Node_ADT(4);
		
		System.out.println(bruteforce_treeDiameter(bt1.root));
		System.out.println(optimized_treeDiameter(bt1.root).dia);

	}

	public static int heightOfTree(Node_ADT root)
	{
		// base case (empty tree)
		if (root == null)
		{
			return 0;
		}
		// +1 indicates that have taken curr node into account for calculating height
		return (Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1);
	}

	//TC=O(N^2)
	//SC=O(1)
	public static int bruteforce_treeDiameter(Node_ADT root)
	{
		//empty tree is heightless
		if(root==null)
		{
			return 0;
		}
		//TC=O(N)
		int leftHeight =heightOfTree(root.left);
		int rightHeight = heightOfTree(root.right);
		
		//post order traversal
		int leftDia = bruteforce_treeDiameter(root.left);
		int rightDia = bruteforce_treeDiameter(root.right);
		
		//processing part
		int diaWithOutRoot = Math.max(leftDia, rightDia);
		int diaWithRoot = leftHeight+rightHeight+1;
		
		return (Math.max(diaWithOutRoot, diaWithRoot));
	}

	//binding data
	public static class DiaPair
	{
		int height;
		int dia;
	}
	
	
	//TC=O(N)
	//SC=O(1)
	public static DiaPair optimized_treeDiameter(Node_ADT root)
	{
		//empty tree is heightless
		if(root==null)
		{
			DiaPair dp = new DiaPair();
			dp.height=0;
			dp.dia=0;
			return dp;
		}
	
		//post order traversal
		DiaPair leftPair = optimized_treeDiameter(root.left);
		DiaPair rightPair = optimized_treeDiameter(root.right);
		
		//processing part
		DiaPair currPair = new DiaPair(); // storing h and d of the currnode
		currPair.height=(Math.max(leftPair.height, rightPair.height)+1);
		
		
		int diaWithoutRoot=Math.max(leftPair.dia, rightPair.dia);
		int diaWithRoot = leftPair.height+rightPair.height+1;
		
		currPair.dia=Math.max(diaWithoutRoot, diaWithRoot);
		return currPair;
	}
	
}
