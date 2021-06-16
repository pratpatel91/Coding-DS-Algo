import java.util.LinkedList;
import java.util.Queue;

public class _678_Trees_IterativeBFSUsingQueues
{
	// no need to import (referring the class in same package)
	Node_ADT root;
	
	public static void main(String[] args)
	{
		_678_Trees_IterativeBFSUsingQueues bst = new _678_Trees_IterativeBFSUsingQueues();

		bst.root = new Node_ADT(1);
		bst.root.left = new Node_ADT(2);
		bst.root.right = new Node_ADT(3);
		bst.root.left.left = new Node_ADT(4);
		bst.root.left.right = new Node_ADT(5);
		
		bst.iterativeLevelOrder(); //BFS Traversal
	}

	// TC=O(N) due traversing all the nodes in a binary tree once
	// SC=O(N) due to creating an external queue ds
	public void iterativeLevelOrder()
	{
		if (root == null)
		{
			return;
		}

		Queue<Node_ADT> queue = new LinkedList<>();
		queue.add(root);
		
		System.out.print("Level Order: ");
		while (!queue.isEmpty())
		{
			Node_ADT currentNode = queue.remove();

			System.out.print(currentNode.data + " ");

			if (currentNode.left != null)
			{
				queue.add(currentNode.left);
			}

			if (currentNode.right != null)
			{
				queue.add(currentNode.right);
			}
		}
	}
}
