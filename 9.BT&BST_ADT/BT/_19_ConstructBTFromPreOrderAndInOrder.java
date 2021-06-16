
//If InOrder isnt given then we cant determine the childrens aka cant build the tree
public class _19_ConstructBTFromPreOrderAndInOrder
{
	public static void main(String[] args)
	{
		int[] preOrder = { 1, 6, 7, 8 };
		int[] inOrder = { 1, 6, 8, 7 }; //unsorted array (exclude binary search)
		
		Node_ADT root =buildBT(preOrder, inOrder,0,preOrder.length-1);
		postOrder(root);
	}

	//L,R,N
	public static void postOrder(Node_ADT root)
	{
		//base case (prevents stack overflow)
		if(root ==null)
		{
			return;
		}

		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}
	
	
	static int i=0;
	
	public static Node_ADT buildBT(int[] preOrder, int[]inOrder, int start, int end)
	{
		//base case of binary search
		if(start > end)
		{
			return null;
		}
		
		Node_ADT currNode = new Node_ADT(preOrder[i++]); //preOrder[0] then i++ makes it 1 (POST INCREMENT)
		
		//leaf node (no childs need to be searched)
		if(start == end)
		{
			return currNode;
		}
		
		//finding childrens of the currNode
		int index=search(inOrder,start,end,currNode.data);
		currNode.left=buildBT(preOrder,inOrder,start,index-1);
		currNode.right=buildBT(preOrder,inOrder,index+1,end);
		return currNode;
	}

	public static int search(int[] inOrder, int start, int end, int data)
	{
		for(int i=start;i<=end;i++)
		{
			if(inOrder[i]==data)
			{
				return i;
			}
		}
		return 0; //NOT FOUND
	}
	
	
	
	
}
