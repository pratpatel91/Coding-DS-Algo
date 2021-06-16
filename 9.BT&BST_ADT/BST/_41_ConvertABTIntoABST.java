import java.util.ArrayList;
import java.util.Collections;

public class _41_ConvertABTIntoABST
{
	Node_ADT root;
	static ArrayList<Integer> nodes = new ArrayList<>();
	int nodeCount=0;

	public static void main(String[] args)
	{
		_41_ConvertABTIntoABST bt = new _41_ConvertABTIntoABST();

		bt.root = new Node_ADT(1);
		bt.root.left = new Node_ADT(2);
		bt.root.right = new Node_ADT(3);
		bt.root.left.left = new Node_ADT(4);
		bt.root.left.right = new Node_ADT(5);
		bt.root.right.left = new Node_ADT(6);
		bt.root.right.right = new Node_ADT(7);
		bt.root.right.left.right = new Node_ADT(8);

		bt.inOrder(bt.root);

		bt.printInOrder(bt.root); //unsorted order means we have a BT
		System.out.println();
		
		Collections.sort(nodes);
		//System.out.println(nodes);
		
		bt.inOrderTraversal1(bt.root);
		
		bt.printInOrder(bt.root); //sorted order means we have a BST
	}

	public void printInOrder(Node_ADT root)
	{
		if (root == null)
		{
			return;
		}
		printInOrder(root.left);
		System.out.print(root.data + " "); // populating nodes array
		printInOrder(root.right);
	}

	public void inOrder(Node_ADT root)
	{
		if (root == null)
		{
			return;
		}
		inOrder(root.left);

		nodes.add(root.data); // populating nodes array

		inOrder(root.right);
	}
	
	public void inOrderTraversal1(Node_ADT root)
	{
		if (root == null)
		{
			return;
		}
		inOrderTraversal1(root.left);

		System.out.println("node value:"+nodes.get(nodeCount));
		root.data=nodes.get(nodeCount);
		nodeCount++;

		inOrderTraversal1(root.right);
	}

}
