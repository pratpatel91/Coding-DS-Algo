import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class PairNode
{
	int lvl;
	int val;

	PairNode(int val, int lvl)
	{
		this.lvl = lvl;
		this.val = val;
	}
}

public class _10_TopViewOfBT
{
	// no need to import (referring the class in same package)
	Node_ADT root;
	static TreeMap<Integer, PairNode> candidates = new TreeMap<>();

	public static void main(String[] args)
	{
		_10_TopViewOfBT bt = new _10_TopViewOfBT();

		bt.root = new Node_ADT(20);

		bt.root.left = new Node_ADT(8);
		bt.root.left.left = new Node_ADT(5);

		bt.root.right = new Node_ADT(22);
		bt.root.right.right = new Node_ADT(25);
		bt.root.left.right = new Node_ADT(3);

		bt.root.left.right.left = new Node_ADT(10);
		bt.root.left.right.right = new Node_ADT(14);

		int level = 0;
		int maxLevel = -1;
		topView(bt.root);
		System.out.println("-------");
		bottomView(bt.root);
	}

	public static void topView(Node_ADT root)
	{
		recursivePrintTopView(root, 0, 0);

		for (Map.Entry<Integer, PairNode> hdMap : candidates.entrySet())
		{
			System.out.println(hdMap.getValue().val + " " + hdMap.getValue().lvl);
		}
	}

	public static void bottomView(Node_ADT root)
	{
		recursivePrintBottomView(root, 0, 0);

		for (Map.Entry<Integer, PairNode> hdMap : candidates.entrySet())
		{
			System.out.println(hdMap.getValue().val + " " + hdMap.getValue().lvl);
		}
	}

	public static void recursivePrintTopView(Node_ADT root, int level, int hd)
	{
		// base case
		if (root == null)
		{
			return;
		}

		// processing node based on levels
		if (candidates.get(hd) == null) // bottom view:
		{
			candidates.put(hd, new PairNode(root.data, level)); // adding root at level 0
		}
		else if (candidates.get(hd).lvl > level)
		{
			candidates.put(hd, new PairNode(root.data, level));
		}
		recursivePrintTopView(root.left, level + 1, hd - 1);
		recursivePrintTopView(root.right, level + 1, hd + 1);
	}

	public static void recursivePrintBottomView(Node_ADT root, int level, int hd)
	{
		// base case
		if (root == null)
		{
			return;
		}

		// processing node based on levels
		if (candidates.get(hd) == null) // bottom view:
		{
			candidates.put(hd, new PairNode(root.data, level)); // adding root at level 0
		}
		else if (candidates.get(hd).lvl < level)
		{
			candidates.put(hd, new PairNode(root.data, level));
		}
		recursivePrintBottomView(root.left, level + 1, hd - 1);
		recursivePrintBottomView(root.right, level + 1, hd + 1);
	}

	public static void iterativePrintTopView(Node_ADT root)
	{
		Queue<Node_ADT> q = new LinkedList<>();

		q.add(root);

		// 7,9,8,10
		while (root.left != null)
		{
			q.add(root.left);
		}

		// 10,8,9,7
	}

}
