import java.util.LinkedList;
import java.util.Queue;

public class _54_FlattenBSTToSortedList
{
	static Node_ADT rootNode;
	static Node_ADT head = null;
	static Node_ADT prevNode=null;
	
	public static void main(String[] args)
	{
		rootNode = new Node_ADT(50);

		insert(rootNode, 20);
		insert(rootNode, 60);
		
		insert(rootNode, 25);
		insert(rootNode, 55);
		insert(rootNode, 80);
		
		//inOrder(rootNode);
		//System.out.println();
		//convertingBSTIntoDLL(rootNode);
		//System.out.println();
		//printDLL();
		
		//System.out.println();
		//levelOrder(rootNode);
		//System.out.println("head:"+head.data);
		//printDLL();
 		findMinNode(rootNode);
	}
	
	
	
	public static void findMinNode(Node_ADT root)
	{		
		Node_ADT traversalNode=root;
		
		while(traversalNode.left!=null)
		{
			System.out.print(traversalNode.data + " ");
			traversalNode=traversalNode.left;
		}
		System.out.println(traversalNode.data);
		
	}
	
	
	//BFS
	public static void levelOrder(Node_ADT root)
	{
		Queue<Node_ADT> qu = new LinkedList<>();
		qu.add(root);
		
		// traversing the queue
		while (!qu.isEmpty())
		{
			int size = qu.size();
			System.out.println("Size:"+size);
			for (int i = 0; i < size; i++)
			{
				//Node_ADT front = qu.poll(); // removed from queue
				// System.out.println("parent:" + front.data);

				Node_ADT front=qu.poll();
				System.out.print(front.data + " ");
				Node_ADT currNode=insertAtBack(front.data);
				if(prevNode == null)
				{
					head=currNode;
				}
				else
				{
					currNode.left=prevNode;
					prevNode.right=currNode;
				}
				prevNode=currNode;
				
				// order is critical here
				// adding left first and then right later
				
				//---------Forming DLL linkages -----------------------//
				if (front.left != null)
				{
					qu.add(front.left);
				}
				if (front.right != null)
				{
					qu.add(front.right);
				}
				// System.out.println();
			}
		}
	}
	
	public static Node_ADT insertAtBack(int data)
	{
		// 1st, we created a node
		Node_ADT newNode = new Node_ADT(data);

		if (head == null) // if the list is empty
		{
			head = newNode;
			return head; // breaks out of the sequential flow after the else statement
		} else
		{
			// added a new node pointing void losing heads info
			Node_ADT traversalNode = head;

			while (traversalNode.right != null)
			{
				traversalNode = traversalNode.right; // insert at back
			}
			traversalNode.right = newNode; // forward linkage
			newNode.left = traversalNode; // backward linkage
		}
		return newNode;
	}

	
	
	//DFS
	public static void inOrder(Node_ADT root)
	{
		if(root== null)
		{
			return;
		}
		
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
	
	public static void printDLL()
	{
		while(head!=null)
		{
			System.out.print(head.data + " ");
			head=head.right;
		}
	}
	
	
	public static void convertingBSTIntoDLL(Node_ADT root)
	{
		//Inorder Traversal 
		if(root == null)
		{
			return;
		}

		convertingBSTIntoDLL(root.left);
		
		//---------Forming DLL linkages -----------------------//
		if(head == null)
		{
			head=root;
		}
		else
		{
			root.left=prevNode;
			prevNode.right=root; //root is currNode
		}
		//after the linkages are finishes; we have to update prev
		prevNode=root; //now prevNode becomes currNode/root
		//----------------------------------------------------//
		
		System.out.print(root.data + " ");
		
		convertingBSTIntoDLL(root.right);
	}
	
	
	
	
	public static Node_ADT insert(Node_ADT root, int value)
	{
		// Base case (Creating a new node for the first time)
		if (root == null)
		{
			root = new Node_ADT(value);
			return root;
		}

		// placing all other nodes into the BST per constraints (left<root<right)
		if (value < root.data)
		{
			//System.out.println("\tinserting " + value + " as a left child");
			root.left = insert(root.left, value); // RECURSION
		}
		else if (value > root.data)
		{
			//System.out.println("\tinserting " + value + " as a right child");
			root.right = insert(root.right, value); // RECURSION
		}
		return root;
	}
}
