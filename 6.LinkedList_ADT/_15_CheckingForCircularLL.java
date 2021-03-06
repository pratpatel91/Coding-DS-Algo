public class _15_CheckingForCircularLL
{
	// Declaring head and tail pointer as null.
	public static Node headPointer = null;
	public Node tailPointer = null;
	static int ll_size = 0;

	// Represents the node of list.
	public class Node
	{
		int data;
		Node next;

		public Node(int data)
		{
			this.data = data;
		}
	}

	public static void main(String[] args)
	{
		_15_CheckingForCircularLL ll = new _15_CheckingForCircularLL();
		ll.generateLL(ll); //SC=O(1) due to not creating any external data structures
		ll.printLL();
		System.out.println("Is the LL Circular? " + ll.isLLCircular()); //TC=O(N)

	}
	
	public _15_CheckingForCircularLL generateLL(_15_CheckingForCircularLL ll)
	{
		// populating the linked list
		for (int i = 1; i <= 4; i++)
		{
			ll.insertAtBack(i);
		}
		return ll;
	}
	
	// This function will add the new node at the end of the list.
	public void insertAtBack(int data)
	{
		// Create new node
		Node newNode = new Node(data);
		// Checks if the list is empty.
		if (headPointer == null)
		{
			// If list is empty, both head and tail point to the new node.
			headPointer = newNode;
			tailPointer = newNode;
			newNode.next = headPointer;
			ll_size++;
			System.out.println("ll size(first element): " + ll_size);

		} else
		{
			// tail will point to new node.
			tailPointer.next = newNode;
			// New node will become new tail.
			tailPointer = newNode;
			// Since, its a circular linked list tail will point to head.
			tailPointer.next = headPointer;
			ll_size++;
			System.out.println("ll size(subsequent elements): " + ll_size);
		}
	}

	// Displays all the nodes in the list
	public void printLL()
	{
		Node current = headPointer;
		if (headPointer == null)
		{
			System.out.println("List is empty");
		} else
		{
			System.out.print("LL: ");
			do
			{
				// Prints each node by incrementing pointer.
				System.out.print(current.data + " ");
				current = current.next;
			} while (current != headPointer);
			System.out.println();
		}
		System.out.println("ll size: " + ll_size);
	}

	public boolean isLLCircular()
	{		
		boolean isCircular = false;

		// An empty linked list is circular by default
		if (headPointer == null)
		{
			isCircular = true;
		}

		Node traversalNode = headPointer.next;

		//iterating the LL to see if the lastNode points to head(circular ll)
		while (traversalNode != null)
		{
			traversalNode = traversalNode.next;
			
			if(traversalNode == headPointer)
			{
				isCircular=true;
				break;
			}
		}
		return isCircular;
	}

}
