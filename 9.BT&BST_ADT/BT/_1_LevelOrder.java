import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _1_LevelOrder
{
	// no need to import (referring the class in same package)
	Node_ADT root;

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

	public void reversedLevelOrder()
	{
		Queue<Node_ADT> qu = new LinkedList<>();
		Stack<Integer> s = new Stack<Integer>();

		qu.add(root);
		s.push(root.data);
		s.add(-1); // first level

		// traversing the queue
		while (!qu.isEmpty())
		{
			int size = qu.size();

			for (int i = 1; i <= size; i++)
			{
				Node_ADT front = qu.poll(); // removed from queue

				// System.out.println("parent:" + front.data);
				// System.out.print(front.data + " ");

				// order is critical here
				// adding right first and then left later
				if (front.right != null)
				{
					// System.out.print(front.data + "s right child is "+ front.right.data + " ");
					qu.add(front.right);
					s.add(front.right.data);

				}
				if (front.left != null)
				{
					// System.out.print(front.data + "s left child is "+ front.left.data + " ");
					qu.add(front.left);
					s.add(front.left.data);
				}
			}
			s.add(-1); // Delimiter/separator for changing levels
			// System.out.println("adding delimiter");
		}

		// reverse level order printout
		while (!s.isEmpty())
		{
			if (s.peek() == -1)
			{
				System.out.println(); // changing line to print another level
				s.pop();
				continue;
			}
			System.out.print(s.peek() + " ");
			s.pop();
		}
	}

	public static void main(String[] args)
	{
		_1_LevelOrder bt = new _1_LevelOrder();

		bt.root = new Node_ADT(1);
		bt.root.left = new Node_ADT(2);
		bt.root.right = new Node_ADT(3);
		bt.root.left.left = new Node_ADT(4);
		bt.root.left.right = new Node_ADT(5);
		bt.root.right.left = new Node_ADT(6);
		bt.root.right.right = new Node_ADT(7);
		bt.root.right.left.right = new Node_ADT(8);

		bt.levelOrder();
		System.out.println("-------------");
		bt.reversedLevelOrder();
	}

}
