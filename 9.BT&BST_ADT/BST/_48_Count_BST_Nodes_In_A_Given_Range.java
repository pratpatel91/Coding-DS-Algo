
public class _48_Count_BST_Nodes_In_A_Given_Range
{
	static Node_ADT rootNode;
	static int count =0;
	
	public static void main(String[] args)
	{
		rootNode = new Node_ADT(50);

		insert(rootNode, 15);
		insert(rootNode, 20);
		insert(rootNode, 60);
		insert(rootNode, 25);
		insert(rootNode, 55);
		insert(rootNode, 80);
		
		nodesWithinRange(rootNode, 5,45);
		System.out.println("Count: " + count);

	}
	
	//No need to process subtrees to get the result so a preorder was used
	public static void nodesWithinRange(Node_ADT root, int low, int high)
	{
		// count =0;   //this is wrong because it always resets the count
		              //hence count should be a global variable to retain
		              //the updated value
		
		if(root==null)
		{
			return;
		}
		//----------------PREORDER------------------------------//
		//1.processing the node (means checking root.data)
		if(root.data >= low && root.data <=high)
		{
			count++;
		}
		
		//2.processing left and right 
		nodesWithinRange(root.left, low, high);
		nodesWithinRange(root.right, low, high);
		
		//cannot display count only once here as its recursive
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
