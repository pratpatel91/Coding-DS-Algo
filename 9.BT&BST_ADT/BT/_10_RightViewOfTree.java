import java.util.LinkedList;
import java.util.Queue;

public class _10_RightViewOfTree
{
	// no need to import (referring the class in same package)
	Node_ADT root;

	public static void main(String[] args)
	{
		_10_RightViewOfTree bt = new _10_RightViewOfTree();

		bt.root = new Node_ADT(1);
		bt.root.left = new Node_ADT(2);
		bt.root.right = new Node_ADT(3);
		bt.root.left.left = new Node_ADT(4);
		bt.root.left.right = new Node_ADT(5);
		bt.root.right.left = new Node_ADT(6);
		bt.root.right.right = new Node_ADT(7);
		bt.root.right.left.right = new Node_ADT(8);
		bt.rightViewLevelOrder();
	}

	public void rightViewLevelOrder()
	{
		Queue<Node_ADT> qu = new LinkedList<>();
		qu.add(root);
		int level = 1;

		// traversing the queue
		while (!qu.isEmpty())
		{
			int size = qu.size();
			System.out.println("level #" + level + ", num elements:" + size);
			level++;

			// number of nodes in current level = i
			for (int i = 1; i <= size; i++)
			{
				Node_ADT front = qu.poll(); // removed from queue

				// ----------------------------------------------------

				if (i == size)
				{
					System.out.print(front.data + " ");
				}
				// ---------------------------------------------------

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
