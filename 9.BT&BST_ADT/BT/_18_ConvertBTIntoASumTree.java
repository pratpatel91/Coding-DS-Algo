import java.util.LinkedList;
import java.util.Queue;

public class _18_ConvertBTIntoASumTree
{
	// no need to import (referring the class in same package)
	Node_ADT root;
	
	public static void main(String[] args)
	{
		_18_ConvertBTIntoASumTree bt = new _18_ConvertBTIntoASumTree();

		bt.root = new Node_ADT(20);

		bt.root.left = new Node_ADT(8);
		bt.root.right = new Node_ADT(22);

		bt.root.left.left = new Node_ADT(5);
		bt.root.left.right = new Node_ADT(3);
		bt.root.right.right = new Node_ADT(25);

		bt.root.left.right.left = new Node_ADT(10);
		bt.root.left.right.right = new Node_ADT(14);

		bt.root.left.right.left.left = new Node_ADT(100);
		
		bt.root.left.right.left.left.left = new Node_ADT(200);
		
		/*
		 *   20 
		 *  /  \ 
		 *  8  22 
		 * / \  \ 
		 * 5 3  25 
		 *  / \ 
		 * 10 14
		 * /
	     *100
	    * /
	  * 200
		 */
		bt.levelOrder();
		transformTree(bt.root);
		bt.levelOrder();
	}

	//
	public static int transformTree(Node_ADT root) 
	{
		if(root==null)
		{
			return 0;
		}
		
		//CRITICAL POINT (Stroring prev val)
		int prevValueOfNode = root.data; //without this prev values are lost (zeroes tree)
		
		int leftSum= transformTree(root.left);
		int rightSum=transformTree(root.right);
		root.data=leftSum+rightSum;
		
		return root.data+prevValueOfNode;
		
	}
	
	public void levelOrder()
	{
		Queue<Node_ADT> qu = new LinkedList<>();
		qu.add(root);

		// traversing the queue
		while (!qu.isEmpty())
		{
			int size = qu.size();

			for (int i = 0; i < size; i++)
			{
				Node_ADT front = qu.poll(); // removed from queue
				// System.out.println("parent:" + front.data);
				System.out.print(front.data + " ");

				// order is critical here
				// adding left first and then right later

				if (front.left != null)
				{
					// System.out.print(front.data + "s left child is "+ front.left.data + " ");
					qu.add(front.left);

				}
				if (front.right != null)
				{
					// System.out.print(front.data + "s right child is "+ front.right.data + " ");
					qu.add(front.right);
				}
				// System.out.println();
			}
			System.out.println();
		}
	}

}
