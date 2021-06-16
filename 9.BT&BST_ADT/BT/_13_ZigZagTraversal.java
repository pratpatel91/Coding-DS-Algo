import java.util.Stack;

public class _13_ZigZagTraversal
{
	// no need to import (referring the class in same package)
	Node_ADT root;

	public static void main(String[] args)
	{
		_13_ZigZagTraversal bt = new _13_ZigZagTraversal();

		bt.root = new Node_ADT(7);
		
		bt.root.left = new Node_ADT(9);
		bt.root.right = new Node_ADT(7);
		
		bt.root.left.left = new Node_ADT(8);
		bt.root.left.right = new Node_ADT(8);
		bt.root.right.left = new Node_ADT(6);
		
		bt.root.left.left.left = new Node_ADT(10);
		bt.root.left.left.right = new Node_ADT(9);
		
		zigZaglevelOrder(bt.root);
	}

	//TC=O(N) processing every node once
	public static void zigZaglevelOrder(Node_ADT root)
	{
		Stack<Node_ADT> ltoR = new Stack<>();
		Stack<Node_ADT> RtoL = new Stack<>();

		RtoL.push(root); // pushing root at level1
		
		while(!RtoL.isEmpty() || !ltoR.isEmpty()) //outer while loop continues level by level printout
		{
			while (!RtoL.isEmpty())
			{
				Node_ADT currNode = RtoL.pop(); // currently RtoL is populate and we want to process the childs

				// doing ltoR so we process left child first then right child second
				if (currNode.left != null)
				{
					ltoR.push(currNode.left);
				}

				if (currNode.right != null)
				{
					ltoR.push(currNode.right);
				}
				System.out.print(currNode.data + " ");
			}

			while (!ltoR.isEmpty())
			{
				// adding childrens onto the ltoR stack
				Node_ADT currNode = ltoR.pop();

				if (currNode.right != null)
				{
					RtoL.push(currNode.right);
				}

				if (currNode.left != null)
				{
					RtoL.push(currNode.left);
				}
				System.out.print(currNode.data + " ");
			}
		}
		

	}
}
