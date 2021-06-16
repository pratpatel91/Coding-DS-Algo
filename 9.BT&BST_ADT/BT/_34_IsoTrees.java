
public class _34_IsoTrees
{
	// no need to import (referring the class in same package)
	Node_ADT root1;
	Node_ADT root2;

	public static void main(String[] args)
	{
		_34_IsoTrees bt1 = new _34_IsoTrees();

		bt1.root1 = new Node_ADT(1);
		bt1.root1.left = new Node_ADT(2);
		bt1.root1.right = new Node_ADT(3);
		bt1.root1.left.left = new Node_ADT(4);
		bt1.root1.left.right = new Node_ADT(5);
		bt1.root1.right.left = new Node_ADT(6);
		bt1.root1.left.right.left = new Node_ADT(7);
		bt1.root1.left.right.right = new Node_ADT(8);

		_34_IsoTrees bt2 = new _34_IsoTrees();
		bt2.root2 = new Node_ADT(1);
		bt2.root2.left = new Node_ADT(3);
		bt2.root2.right = new Node_ADT(2);
		bt2.root2.right.right = new Node_ADT(5);
		bt2.root2.right.left = new Node_ADT(4);
		bt2.root2.left.right = new Node_ADT(6);
		bt2.root2.right.right.right = new Node_ADT(7);
		bt2.root2.right.right.left = new Node_ADT(8);

		System.out.println("Is tree Isomorphic?: " + isIsomorphic(bt1.root1, bt2.root2));

	}

	public static boolean isIsomorphic(Node_ADT root1, Node_ADT root2)
	{
		// empty trees
		if (root1 == null && root2 == null)
		{
			return true;
		}
		// structure change
		if (root1 == null || root2 == null)
		{
			return false;
		}
		// data mismatch
		if (root1.data != root2.data)
		{
			return false;
		}

		return ((root1.data == root2.data) //matching data
				&& (isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right)) //same iso structure
				|| (isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left))); //cross iso structure
	}

}
