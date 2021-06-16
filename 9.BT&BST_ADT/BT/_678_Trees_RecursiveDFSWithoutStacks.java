public class _678_Trees_RecursiveDFSWithoutStacks
{
	// no need to import (referring the class in same package)
	Node_ADT root;

	public static void main(String[] args)
	{
		_678_Trees_RecursiveDFSWithoutStacks bst = new _678_Trees_RecursiveDFSWithoutStacks();

		bst.root = new Node_ADT(1);
		bst.root.left = new Node_ADT(2);
		bst.root.right = new Node_ADT(3);
		bst.root.left.left = new Node_ADT(4);
		bst.root.left.right = new Node_ADT(5);

		System.out.print("Pre Order: ");
		bst.recursivePreOrder(bst.root);
		System.out.print("\nIn Order: ");
		bst.recursiveInOrder(bst.root);
		System.out.print("\nPost Order: ");
		bst.recursivePostOrder(bst.root);

	}

	public void recursivePreOrder(Node_ADT root)
	{
		if (root != null)
		{
			System.out.print(root.data + " ");
			recursivePreOrder(root.left); // RECURSION (left subtree)
			recursivePreOrder(root.right); // RECURSION (right subtree)
		}
	}

	public void recursiveInOrder(Node_ADT root)
	{
		if (root != null)
		{
			recursiveInOrder(root.left); // RECURSION (left subtree)
			System.out.print(root.data + " ");
			recursiveInOrder(root.right); // RECURSION (right subtree)
		}
	}

	public void recursivePostOrder(Node_ADT root)
	{
		if (root != null)
		{
			recursivePostOrder(root.left); // RECURSION (left subtree)
			recursivePostOrder(root.right); // RECURSION (right subtree)
			System.out.print(root.data + " ");
		}
	}
}
