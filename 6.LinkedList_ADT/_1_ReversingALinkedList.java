public class _1_ReversingALinkedList
{
	static LLNode_ADT head = null; //created a node to preserve heads info (iterative case)
	static LLNode_ADT node; //created a node to preserve heads info (recursive case)

	// Nested Class (LLNode is the ADT, int is the primitive data type)
	static class LLNode_ADT
	{
		int data;
		LLNode_ADT next;

		// constructor
		LLNode_ADT(int data)
		{
			this.data = data;
			next = null;
		}
	}

	public void insertAtBack(int data)
	{
		// 1st, we created a node
		LLNode_ADT newNode = new LLNode_ADT(data);

		if (head == null)
		{
			head = newNode;
		} else
		{
			// added a new node pointing void losing heads info
			LLNode_ADT traversalNode = head;

			while (traversalNode.next != null)
			{
				traversalNode = traversalNode.next; // updating the traversalNode pointer
			}
			traversalNode.next = newNode;
		}
	}

	public void insertAtBack_1(int data)
	{
		// 1st, we created a node
		LLNode_ADT newNode = new LLNode_ADT(data);

		if (node == null)
		{
			node = newNode;
		} else
		{
			// added a new node pointing void losing heads info
			LLNode_ADT traversalNode = node;

			while (traversalNode.next != null)
			{
				traversalNode = traversalNode.next; // updating the traversalNode pointer
			}
			traversalNode.next = newNode;
		}
	}
	public void printLinkedList(LLNode_ADT head)
	{
		// LL TRAVERSAL----------------//
		// added a new node pointing void losing heads info
		LLNode_ADT traversalNode = head;
		int size = 0;

		while (traversalNode != null)
		{
			System.out.print(traversalNode.data + " ");
			size++;
			traversalNode = traversalNode.next; // updating the traversalNode pointer
		}
		System.out.println();
	}

	//iterative
	LLNode_ADT reversedLinkedList(LLNode_ADT head)
	{
		// initializing 3 pointers
		LLNode_ADT previousNode = null;
		LLNode_ADT currentNode = head;
		LLNode_ADT nextNode = null;

		while (currentNode != null)
		{
			nextNode = currentNode.next;
			// forming links
			currentNode.next = previousNode;
			// breaking the link
			previousNode = currentNode;
			// shifting the current pointer (i++)
			currentNode = nextNode;
			// System.out.println("Printing left side of linked list");
			// printLinkedList(previousNode);
			// System.out.println("Printing right side of linked list");
			// printLinkedList(currentNode);
		}

		head = previousNode; // making last element as the first node (aka head)
		return head;
	}

	LLNode_ADT recursive_reversedLinkedList(LLNode_ADT currentNode, LLNode_ADT previousNode)
	{
		// BASE CASES
		if (node == null) // empty or containing a single node
		{
			return node;
		}
		if (currentNode.next == null) // we have reached the last node of the linked list
		{
			node = currentNode; // setting head to be the last node for reversing the ll
			currentNode.next = previousNode;
			return node;
		}

		LLNode_ADT nextNode = currentNode.next;
		// forming links
		currentNode.next = previousNode;
		// breaking the link
		previousNode = currentNode;
		// shifting the current pointer (i++)
		currentNode = nextNode;
		recursive_reversedLinkedList(currentNode, previousNode);
		return node;
	}

	public static void main(String[] args)
	{
		_1_ReversingALinkedList ll = new _1_ReversingALinkedList(); // head->null

		// populating the linked list
		for (int i = 1; i <= 6; i++)
		{
			ll.insertAtBack(i);
		}

		// populating the linked list (recursion)
		for (int i = 1; i <= 6; i++)
		{
			ll.insertAtBack_1(i);
		}

		System.out.println("Original Linked List:");
		ll.printLinkedList(head);
		
		head = ll.reversedLinkedList(head);
		System.out.println("Iterative Reversed Linked List:");
		ll.printLinkedList(head);
		
		node =ll.recursive_reversedLinkedList(node, null);
		System.out.println("Recursive Reversed Linked List:");
		ll.printLinkedList(node);

	}

}
