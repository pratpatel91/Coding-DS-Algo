import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BT
{
	// no need to import (referring the class in same package)
	static Node_ADT root;

	public static void main(String[] args)
	{
		BT bt = new BT();
		bt.root = new Node_ADT(10);

		bt.root.left = new Node_ADT(20);
		bt.root.right = new Node_ADT(30);

		bt.root.left.left = new Node_ADT(40);
		bt.root.left.right = new Node_ADT(50);

		bt.root.right.left = new Node_ADT(60);
		bt.root.right.right = new Node_ADT(70);

		iterativeLevelOrder();
		// printPreOrder(root);
	}

	// ADT Functionalities
	public static void printPreOrder(Node_ADT root)
	{
		// Base Case (Simplest Computation)
		if (root == null)
		{
			return;
		}

		System.out.print(root.data + " ");
		printPreOrder(root.left); // RECURSION (left subtree)
		printPreOrder(root.right); // RECURSION (right subtree)
	}

	public static void iterativeLevelOrder()
	{
		if (root == null)
		{
			return;
		}

		Queue<Node_ADT> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty())
		{

			Node_ADT front = q.poll(); 

			System.out.print(front.data + " ");

			if (front.left != null)
			{
				q.add(front.left);
			}

			if (front.right != null)
			{
				q.add(front.right);
			}
		}
	}

//	public static void printQueue(Queue<Node_ADT> q)
//	{
//		//System.out.print("Queue: ");
//		Iterator<Node_ADT> queueIterator = q.iterator();
//		while (queueIterator.hasNext())
//		{
//			Node_ADT currNode = queueIterator.next();
//			// System.out.print(currNode.data + " ");
//		}
//		//System.out.println();
//	}
}
