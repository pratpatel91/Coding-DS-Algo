class Node_ADT
{
	int data;
	Node_ADT left, right; // children pointers

	Node_ADT(int value)
	{
		data = value;
		left = right = null;
	}

	// ADT Functionalities
	public Node_ADT insert(Node_ADT root, int value)
	{
		if (root == null)
		{
			return new Node_ADT(value); // create a new node
		}

		if (value < root.data)
		{
			System.out.print("\tNode" + value + " inserted to the left\n");
			root.left = insert(root.left, value);
		}
		else if (value > root.data)
		{
			System.out.print("\tNode" + value + " inserted to the right\n");
			root.right = insert(root.right, value);
		}

		return root;
	}

	public boolean isLeafNode(Node_ADT node)
	{
		// leaf nodes cannot be empty nodes
		if (node == null)
		{
			return false;
		}
		// leaf nodes cannot have any right and left childs
		if (node.left == null && node.right == null)
		{
			return true;
		}
		return false;
	}
}


