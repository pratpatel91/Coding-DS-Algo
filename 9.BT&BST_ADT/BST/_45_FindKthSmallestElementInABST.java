import java.util.ArrayList;

public class _45_FindKthSmallestElementInABST
{
	static // no need to import (referring the class in same package)
	Node_ADT rootNode;
	
	//Approach: we can store do an in order traversal which gives us all the 
	//ascending sorted elements to store in the array. Next we traverse the array 
	//in forward order and maintain a count in order to find the kth smallest element
	public static void main(String[] args)
	{
		rootNode = new Node_ADT(50);

		insert(rootNode, 20);
		insert(rootNode, 60);
		insert(rootNode, 25);
		insert(rootNode, 55);
		insert(rootNode, 80);
		
		ArrayList<Integer> inOrderArray = new ArrayList<>();
		storeInOrderInArray(rootNode, inOrderArray); // due to being a BSt in order gives sorted order
		System.out.println("In Order Array" + inOrderArray.toString());
		
		System.out.println("Smallest Element: " + KthLargestElement(inOrderArray,1));
		System.out.println("2nd Smallest Element: " + KthLargestElement(inOrderArray,2));
		System.out.println("3rd Smallest Element: " + KthLargestElement(inOrderArray,3));
	}
	
	//TC=O(N)
	//For Kth smallest element we start from the start of the array and go up until K
	public static int KthLargestElement(ArrayList<Integer> inOrderArray, int K)
	{
		int count =1;
		
		for(int i=0;i<=inOrderArray.size()-1;i++)
		{
			if(count==K)
			{
				return inOrderArray.get(i);
			}
			count++;
		}
		return -1;
	}
	
	
	//SC=O(N)
	public static void storeInOrderInArray(Node_ADT root, ArrayList<Integer> inOrderArray)
	{
		
		// Base Case (Simplest Computation)
		if (root == null)
		{
			return;
		}

		storeInOrderInArray(root.left,inOrderArray); // RECURSION (left subtree)
		inOrderArray.add(root.data);
		storeInOrderInArray(root.right,inOrderArray); // RECURSION (right subtree)
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


