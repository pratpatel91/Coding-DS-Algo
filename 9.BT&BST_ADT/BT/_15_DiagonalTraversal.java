import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class _15_DiagonalTraversal
{
	// no need to import (referring the class in same package)
	Node_ADT root;

	public static void main(String[] args)
	{
		_15_DiagonalTraversal bt = new _15_DiagonalTraversal();

		bt.root = new Node_ADT(20);

		bt.root.left = new Node_ADT(8);
		bt.root.right = new Node_ADT(22);
		
		bt.root.left.left = new Node_ADT(5);
		bt.root.left.right = new Node_ADT(3);
		bt.root.right.right = new Node_ADT(25);


		bt.root.left.right.left = new Node_ADT(10);
		bt.root.left.right.right = new Node_ADT(14);
		
		/*
						20
					  /    \
					8		22
				  /  \        \  
				5	  3		  25
				    /  \
				   10  14 
	  */
		
		diagonalTraversal(bt.root);
	}
	
	public static void diagonalTraversal(Node_ADT root)
	{
		Map<Integer,ArrayList<Integer>> diagonalNodes = new HashMap<>();
		
		printDiagonal(root,0,diagonalNodes); //populates the map
		
		//printing the hashmap
		for(int i=0; i<diagonalNodes.size();i++)
		{
			System.out.println("hd_Diag:"+i + ", values:"+diagonalNodes.get(i));
		}
	}
	
	//Printing Diagonals and populating the Map (preorder traversal)
	public static void printDiagonal(Node_ADT root, int hd,Map<Integer,ArrayList<Integer>> diagonalNodes )
	{
		//base case (empty bt)
		if(root == null)
		{
			return;
		}
		
		ArrayList<Integer> currNodesWithSameHd = diagonalNodes.get(hd);
		
		if(currNodesWithSameHd == null)
		{
			currNodesWithSameHd= new ArrayList<Integer>();
			currNodesWithSameHd.add(root.data);
		}
		else //populate the existing list
		{
			currNodesWithSameHd.add(root.data);
		}
		
		//populating the nodes with same hd into the map
		diagonalNodes.put(hd, currNodesWithSameHd);
		
		printDiagonal(root.left, hd+1,diagonalNodes); //left diagonal traversal (root.left is similar to i++ in a for loop)
		printDiagonal(root.right, hd,diagonalNodes); //right diagonal traversal (NOTE: hd remains constant here)
		                                             //(root.right is similar to i++ in a for loop)
	}
	
	
	

}
