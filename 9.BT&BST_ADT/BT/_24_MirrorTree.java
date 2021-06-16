
public class _24_MirrorTree
{
	// no need to import (referring the class in same package)
	Node_ADT root1;
	Node_ADT root2;

	public static void main(String[] args)
	{
		_24_MirrorTree bt1 = new _24_MirrorTree();

		bt1.root1 = new Node_ADT(1);
		bt1.root1.left = new Node_ADT(2);
		bt1.root1.right = new Node_ADT(3);
		bt1.root1.left.left = new Node_ADT(4);

		_24_MirrorTree bt2 = new _24_MirrorTree();
		bt2.root2 = new Node_ADT(1);
		bt2.root2.left = new Node_ADT(3);
		bt2.root2.right = new Node_ADT(2);
		bt2.root2.right.right = new Node_ADT(4);


		System.out.println("Is tree Isomorphic?: " + isMirror(bt1.root1, bt2.root2));
	}

	//Simplier Variation of isIsomorphic
	public static boolean isMirror(Node_ADT root1, Node_ADT root2)
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

		return ((root1.data == root2.data) // matching data
				&& (isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left))); // mirror structure
	}

}
