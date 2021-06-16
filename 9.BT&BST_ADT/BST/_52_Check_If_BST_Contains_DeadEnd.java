import java.util.HashSet;
import java.util.Iterator;

public class _52_Check_If_BST_Contains_DeadEnd
{
	static Node_ADT rootNode;
	
	public static void main(String[] args)
	{
		rootNode = new Node_ADT(8);

		insert(rootNode, 5);
		insert(rootNode, 9);
		insert(rootNode, 2);
		insert(rootNode, 7);
		insert(rootNode, 1);

		System.out.println("isDeadEnd: " +isDeadEnd(rootNode, 1, Integer.MAX_VALUE));
		
		isDeadEndNaive(rootNode);;
	}
	
	//Bruteforce 
	//1.store all the parent elements SC=O(N)
	//2.store all the leaf elements SC=O(N)
	//3.check to see if the leafs min and max values match any of the parents
	public static void isDeadEndNaive(Node_ADT root)
	{
		HashSet<Integer> hsParents = new HashSet<Integer>();
		HashSet<Integer> hsLeafs = new HashSet<Integer>();
		
		populateHashSet(root,hsParents, hsLeafs);
		
		
		Iterator<Integer> i = hsLeafs.iterator();
		
		//while iterating the hsLeafs we are finding min and max
		// and using those 2 pieces of info to see if it matches any parents
		while (i.hasNext())
		{
			int currValue=(int) i.next(); //casting to convert Int Class into primitive int data type
			int min = currValue-1;
			int max = currValue+1;
			
			if(hsParents.contains(min) && hsParents.contains(max))
			{
				System.out.println("Found dead end");
				break; //only need to report 1 not multiple dead ends
			}
		}
	}
	
	
	public static void populateHashSet(Node_ADT root, HashSet<Integer> hsParents, HashSet<Integer> hsLeafs)
	{
		if(root == null)
		{
			return;
		}
		
		if(root.left == null && root.right == null)
		{
			hsLeafs.add(root.data);
		}
		else
		{
			hsParents.add(root.data);
		}
		
		//preorder
		populateHashSet(root.left, hsParents, hsLeafs);
		populateHashSet(root.right, hsParents, hsLeafs);
	}

	//TC=O(N) optimized solution
	public static boolean isDeadEnd(Node_ADT root, int min, int max)
	{
		if(root==null)
		{
			return false;
		}
		
		if(min == max)
		{
			return true;
		}
		
		return isDeadEnd(root.left,min,root.data-1)
		|| isDeadEnd(root.right, root.data+1, max);
	}
	
	public static Node_ADT insert(Node_ADT root, int value)
	{
		// Base case (Creating a new node for the first time)
		if (root == null)
		{
			root = new Node_ADT(value);
			return root;
		}

		// placing all other nodes into the BST per constraints (left<root<right)
		if (value < root.data)
		{
			System.out.println("\tinserting " + value + " as a left child");
			root.left = insert(root.left, value); // RECURSION
		}
		else if (value > root.data)
		{
			System.out.println("\tinserting " + value + " as a right child");
			root.right = insert(root.right, value); // RECURSION
		}
		return root;
	}
	

}
