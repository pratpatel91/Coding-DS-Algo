
public class _30_LowestCommonAncestor
{
	// no need to import (referring the class in same package)
	Node_ADT root;
	
	public static void main(String[] args)
	{
		_30_LowestCommonAncestor bt = new _30_LowestCommonAncestor();

		bt.root = new Node_ADT(1);
		bt.root.left = new Node_ADT(2);
		bt.root.right = new Node_ADT(3);
		bt.root.left.left = new Node_ADT(4);
		bt.root.left.right = new Node_ADT(5);
		bt.root.right.left = new Node_ADT(6);
		bt.root.left.right.left = new Node_ADT(7);
		bt.root.left.right.right = new Node_ADT(8);
		
		Node_ADT answer =LCA(bt.root,2,5);
		System.out.println("LCA(2,5)="+answer.data);
		answer =LCA(bt.root,2,8);
		System.out.println("LCA(2,8)="+answer.data);
		answer =LCA(bt.root,6,8);
		System.out.println("LCA(6,8)="+answer.data);
	}
	
	
	public static Node_ADT LCA(Node_ADT root, int node1, int node2)
	{
		if(root == null)
		{
			return null;
		}
		
		if(root.data == node1 || root.data == node2)
		{
			return root;
		}
		
		Node_ADT answerOnLeftSide = LCA(root.left,node1,node2);
		Node_ADT answerOnRightSide = LCA(root.right,node1,node2);
		
		if(answerOnLeftSide !=null && answerOnRightSide!=null)
		{
			return root;
		}
		else if (answerOnLeftSide != null)
		{
			return answerOnLeftSide; //LCA is on left
		}
		else
		{
			return answerOnRightSide; //LCA is on right
		}
	}

}
