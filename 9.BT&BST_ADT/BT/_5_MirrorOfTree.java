public class _5_MirrorOfTree
{
	// no need to import (referring the class in same package)
	Node_ADT root;
	Node_ADT mirrorRoot;

	public static void main(String[] args)
	{
		_5_MirrorOfTree bt = new _5_MirrorOfTree();

		bt.root = new Node_ADT(1);
		bt.root.left = new Node_ADT(2);
		bt.root.right = new Node_ADT(3);
		bt.root.left.left = new Node_ADT(4);
		bt.root.left.right = new Node_ADT(5);
		bt.root.right.left = new Node_ADT(6);
		bt.root.right.right = new Node_ADT(7);
		bt.root.right.left.right = new Node_ADT(8);
		bt.preOrder(bt.root);
		
		System.out.println("\n-----");
		bt.mirrorRoot = bt.mirrorTree(bt.root);
		bt.preOrder(bt.mirrorRoot);
	}

	public Node_ADT mirrorTree(Node_ADT root)
	{
		if (root == null)
		{
			return null;
		}
		
		Node_ADT mirrorRoot = new Node_ADT(root.data);

		mirrorRoot.left = mirrorTree(root.right);
		mirrorRoot.right = mirrorTree(root.left);

		return mirrorRoot;
	}

	public void preOrder(Node_ADT root)
	{
		if (root == null)
		{
			return;
		}
		
		//Internally it uses a stack (iterative way requires an external stack to be created)
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

}
