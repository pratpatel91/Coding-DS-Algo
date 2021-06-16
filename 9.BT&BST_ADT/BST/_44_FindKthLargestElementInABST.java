import java.util.ArrayList;

public class _44_FindKthLargestElementInABST
{
	static // no need to import (referring the class in same package)
	Node_ADT rootNode;
	static int KthSmallest = -1;
	static int KthLargest=0;
	static int count =0;
	
	//Approach: we can store do an in order traversal which gives us all the 
	//ascending sorted elements to store in the array. Next we traverse the array
	//in reverse order and maintain a count in order to find the kth largest element
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
		System.out.println();
//		System.out.println("Largest Element: " + KthLargestElement(inOrderArray,1));
//		System.out.println("2nd Largest Element: " + KthLargestElement(inOrderArray,2));
//		System.out.println("3rd Largest Element: " + KthLargestElement(inOrderArray,3));
		
		//optimized_KthSmallestElement(rootNode,3);
		//System.out.println("3rd Smallest: " + KthSmallest);
		
		count =0;
		
		optimized_KthLargestElement(rootNode,3); //F5 (step into)
		//System.out.println("3rd Largest: " + KthLargest);
		
	}
	
	//TC=O(N)
	//SC=O(1)
	public static int optimized_KthLargestElement(Node_ADT root, int K)
	{
		if(root == null) //F5 (step into)
		{
			System.out.println("return -1"); //F6 (step over)
			return -1; //F5 (step into)
		}
		
		System.out.println("root.data="+root.data); //F6 (step over)
		
		//In Order
		int rightAnswer =optimized_KthLargestElement(root.right, K); //F5 (step into)

		System.out.println("rightAnswer="+rightAnswer); //F6 (step over)
		
		if(rightAnswer!=-1) //F5 (step into)
		{
			System.out.println("return rightAnswer="+rightAnswer); //F6 (step over)
			return rightAnswer; //F5 (step into)
		}
		System.out.println("count="+count);  //F6 (step over)
		count++; //F5 (step into)
		
		//-1 is initialized above to creatively set the kthsmallest only once
		//because breaking a recursive call is not possible
		if(count==K) //F5 (step into)
		{
			KthLargest = root.data; //F5 (step into)
			System.out.println("return KthLargest=" + KthLargest);  //F6 (step over)
			return  KthLargest; //F5 (step into)
		}
		return optimized_KthLargestElement(root.left, K); //F5 (step into)
	}
	
	
	//TC=O(N)
	//SC=O(1)
	public static int optimized_KthSmallestElement(Node_ADT root, int K)
	{
		if(root == null)
		{
			return -1;
		}
		
		//In Order
		int leftAnswer =optimized_KthSmallestElement(root.left, K);
		if(leftAnswer!=-1)
		{
			return leftAnswer;
		}
		count++;
		
		//-1 is initialized above to creatively set the kthsmallest only once
		//because breaking a recursive call is not possible
		if(count==K)
		{
			KthSmallest = root.data;
			return KthSmallest;
		}
		
		return optimized_KthSmallestElement(root.right, K);
	}
	
	
	
	//TC=O(N)
	//SC=O(N)
	//For Kth largest element we start from the end of the array and go up until K
	public static int KthLargestElement(ArrayList<Integer> inOrderArray, int K)
	{
		int count =1;
		
		for(int i=inOrderArray.size()-1;i>=0;i--)
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
