
import java.util.ArrayList;
import java.util.List;

//Variation of _22_DuplicateSubTree
public class _31_PrintDuplicateSubTrees
{
	// no need to import (referring the class in same package)
	Node_ADT root;

	public static void main(String[] args)
	{
		_31_PrintDuplicateSubTrees bt = new _31_PrintDuplicateSubTrees();

		bt.root = new Node_ADT(1);

		bt.root.left = new Node_ADT(2);
		bt.root.right = new Node_ADT(3);

		bt.root.left.left = new Node_ADT(4);
		bt.root.right.left = new Node_ADT(2);
		bt.root.right.right = new Node_ADT(4);

		bt.root.right.left.left = new Node_ADT(4);

		System.out.println(printDuplicates(bt.root));
		
	}
	
	static List<String> subTrees = new ArrayList<>();
	
	//BruteForce TC=O(N^2) SC=O(N)
	//Inorder Array is used to generate all subarray sums
	//Matching subarray sums are the duplicate subtree
	
	//optimized
	//TC=O(N)
	//SC=O(N)
	public static String printDuplicates(Node_ADT root)
	{
		if(root==null)
		{
			return "";
		}
		
		String leftSubTree = printDuplicates(root.left);
		String rightSubTree = printDuplicates(root.right);
		String currTree = root.data+leftSubTree+rightSubTree;
		
		if(currTree.length()>=1 && 
				subTrees.contains(currTree))
		{
			System.out.print("Found Subtree: " + currTree + " ");
			subTrees.remove(currTree);
		}
		if(!subTrees.contains(currTree))
		{
			subTrees.add(currTree);
		}

		return currTree;
	}
}
