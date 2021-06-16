
public class _49_ReplaceElementWithLeastGreaterElementOnRight
{
	static Node_ADT rootNode;
	static Node_ADT successor;
	
	public static void main(String[] args)
	{
		printGreaterElementOnRight();

	}
	
	public static void printGreaterElementOnRight()
	{
		
		int[] array = {50, 15,20,60,25,55,80};
		
		//insert from the back of the array
		// desc array + traversal from front works alternatively
		for(int i=array.length-1; i>=0;i--)
		{
			successor=null;
			
			rootNode=insert(rootNode,array[i]);
			if(successor == null)
			{
				array[i]=-1;
			}
			else
			{
				array[i]=successor.data;
			}
		}
		
		for(int i=0; i<=array.length-1;i++)
		{
			System.out.print(array[i] + " ");
		}
		
	}
	
	public static Node_ADT insert(Node_ADT root, int value)
	{
		// Base case (Creating a new node for the first time)
		if (root == null)
		{
			root = new Node_ADT(value);
		}

		// placing all other nodes into the BST per constraints (left<root<right)
		if (value < root.data)
		{
			successor=root; //before left insertion we want to preserve the root
			root.left = insert(root.left, value); // RECURSION
		}
		else if (value > root.data)
		{
			//predecessor=root;
			root.right = insert(root.right, value); // RECURSION
		}
		return root;
	}

}
