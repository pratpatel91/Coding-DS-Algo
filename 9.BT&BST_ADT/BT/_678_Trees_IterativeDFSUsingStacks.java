import java.util.Stack;

public class _678_Trees_IterativeDFSUsingStacks
{
	// no need to import (referring the class in same package)
	Node_ADT root;

	public static void main(String[] args)
	{
		_678_Trees_IterativeDFSUsingStacks bst = new _678_Trees_IterativeDFSUsingStacks();

		bst.root = new Node_ADT(1);
		bst.root.left = new Node_ADT(2);
		bst.root.right = new Node_ADT(3);
		bst.root.left.left = new Node_ADT(4);
		bst.root.left.right = new Node_ADT(5);

		//bst.iterativePreorder();
		//bst.iterativeInOrder();
		bst.iterativePostOrder();
	}

	// TC=O(N) due traversing all the nodes in a binary tree once
	// SC=O(N) due to creating an external stack ds
	public void iterativePostOrder()
	{
		// Handling an empty binary tree
		if (root == null)
		{
			return;
		}

		Stack<Node_ADT> stack = new Stack<>();
		stack.push(root); // 1. Push the root onto the stack

		System.out.print("\nPost Order: ");
		while (!stack.isEmpty())
		{
			// 2.Pop the current node from the stack
			Node_ADT currentNode = stack.peek();

			// 3.Push the left child onto the stack first
			if (currentNode.isLeafNode(currentNode))
			{
				Node_ADT top = stack.pop();
				System.out.print(top.data + " ");
			}
			else
			{
				if (currentNode.right != null)
				{
					stack.push(currentNode.right);
					currentNode.right = null;
				}

				// 4.Push the right child onto the stack second
				if (currentNode.left != null)
				{
					stack.push(currentNode.left);
					currentNode.left = null;
				}
			}
		}
	}
}


