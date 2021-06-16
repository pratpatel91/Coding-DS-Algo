
public class RecursiveTraversal
{
	// no need to import (referring the class in same package)
	Node_ADT root;
	
	public static void main(String[] args)
	{
		 RecursiveTraversal bt = new RecursiveTraversal();
		bt.root = new Node_ADT(4);
		bt.root.left = new Node_ADT(2);
		bt.root.right = new Node_ADT(5);
		traverseNodes(bt.root); //F5 (Step Into)
	}

	
	public static void traverseNodes(Node_ADT root)
	{		
		if(root == null) //F5 (Step Into)
		{
			return;
		}
		traverseNodes(root.left); // F5 (Step Into)
		System.out.println("Root is " + root.data); // F6 (Step over)
	}

	
}
