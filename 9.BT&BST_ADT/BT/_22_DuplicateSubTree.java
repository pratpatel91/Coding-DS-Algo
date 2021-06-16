import java.util.ArrayList;
import java.util.List;

public class _22_DuplicateSubTree
{
	// no need to import (referring the class in same package)
	Node_ADT root;

	public static void main(String[] args)
	{
		_22_DuplicateSubTree bt = new _22_DuplicateSubTree();

		bt.root = new Node_ADT(1);

		bt.root.left = new Node_ADT(2);
		bt.root.right = new Node_ADT(3);

		bt.root.left.left = new Node_ADT(4);
		bt.root.left.right = new Node_ADT(5);
		bt.root.right.right = new Node_ADT(2);

		bt.root.right.right.left = new Node_ADT(4);
		bt.root.right.right.right = new Node_ADT(5);
		System.out.println(isDuplicateSubTree(bt.root));
		
	}
	
	static boolean hasDuplicates = false;
	static List<String> subTrees = new ArrayList<>();
	
	//BruteForce TC=O(N^2) SC=O(N)
	//Inorder Array is used to generate all subarray sums
	//Matching subarray sums are the duplicate subtree
	
	//optimized
	//TC=O(N)
	//SC=O(N)
	public static boolean isDuplicateSubTree(Node_ADT root)
	{
		findDuplicate(root);
		return hasDuplicates;
	}
	
	public static String findDuplicate(Node_ADT root)
	{
		if(hasDuplicates || root==null)
		{
			return "";
		}
		
		String leftSubTree = findDuplicate(root.left);
		String rightSubTree = findDuplicate(root.right);
		String currTree = root.data+leftSubTree+rightSubTree;
		
		if(hasDuplicates == false && currTree.length()>1 && 
				subTrees.contains(currTree))
		{
			hasDuplicates=true;
		}
		subTrees.add(currTree);
		return currTree;
	}
}
