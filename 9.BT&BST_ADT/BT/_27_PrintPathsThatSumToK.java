import java.util.ArrayList;
import java.util.Arrays;

public class _27_PrintPathsThatSumToK
{
	// no need to import (referring the class in same package)
	Node_ADT root;
	
	public static void main(String[] args)
	{
		_17_GenDLLFromABT bt = new _17_GenDLLFromABT();

		bt.root = new Node_ADT(1);

		bt.root.left = new Node_ADT(3);
		bt.root.right = new Node_ADT(-1);

		bt.root.left.left = new Node_ADT(2);
		bt.root.left.right = new Node_ADT(1);
		bt.root.right.left= new Node_ADT(4);
		bt.root.right.right = new Node_ADT(5);

		bt.root.left.right.left = new Node_ADT(1);
		bt.root.right.left.left = new Node_ADT(1);
		bt.root.right.left.right = new Node_ADT(2);
		bt.root.right.right.right = new Node_ADT(6);
		
		printPathsWithTargetSum(bt.root, 5);
		
		System.out.println("List Size:"+nodes.size());
		
	}
	
	static //due to using recursion array list wasnt created within the function
	//as after the 2nd recursive call the arraylist info is lost
	ArrayList<Integer> nodes = new ArrayList<>();
	
	public static void printPathsWithTargetSum(Node_ADT root, int targetSum)
	{
		if(root == null)
		{
			return;
		}
		//pre order traversal
		nodes.add(root.data);
		printPathsWithTargetSum(root.left, targetSum);
		printPathsWithTargetSum(root.right,targetSum);
		
		int currSum=0;
		
		for(int i=nodes.size()-1;i>=0;i--)
		{
			currSum+=nodes.get(i);
			
			if(currSum == targetSum)
			{
				printPath(i);
			}	
		}
		nodes.remove(nodes.size()-1); //remove last element after lc and rc are processed
	}
	
	public static void printPath(int start)
	{
		//printing array list
		System.out.print("List of Nodes: ");
		for(int i=0; i<=nodes.size()-1;i++)
		{
			System.out.print(nodes.get(i)+ " ");
		}
		System.out.println();
		for(int i=start; i<=nodes.size()-1; i++)
		{
			System.out.print(nodes.get(i)+ " ");
		}
		System.out.println();
	}
}
