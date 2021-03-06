public class _23_RotateADoublyLLByNNodes
{
	static Node head = null; // created a node to preserve heads info (iterative case)

	// Nested Class (LLNode is the ADT, int is the primitive data type)
	static class Node
	{
		char data;
		Node prev;
		Node next;

		// constructor
		Node(char data)
		{
			this.data = data;
			prev = null;
			next = null;
		}
	}

	public void insertAtBack(char data)
	{
		// 1st, we created a node
		Node newNode = new Node(data);

		if (head == null) // if the list is empty
		{
			head = newNode;
			return; // breaks out of the sequential flow after the else statement
		} else
		{
			// added a new node pointing void losing heads info
			Node traversalNode = head;

			while (traversalNode.next != null)
			{
				traversalNode = traversalNode.next; // insert at back
			}
			traversalNode.next = newNode; // forward linkage
			newNode.prev = traversalNode; // backward linkage
		}
	}

	public void printLL(Node head)
	{
		// added a new node pointing void losing heads info
		Node traversalNode = head;
		System.out.print("LL: ");
		while (traversalNode != null)
		{
			System.out.print(traversalNode.data + " ");
			traversalNode = traversalNode.next; // updating the traversalNode pointer
		}
		System.out.println();
	}

	public Node rotateDoublyLLByN_Nodes(Node head, int N)
	{
		Node traversalNode = head;
		int counter = 1; // starting from head aka 1st node

		// partially traversing from head till Nth node
		// By having (&& counter<N) when counter=N then the while loop
		// condition becomes false so we terminate the traversal hence its a
		// partial traversal of the ll
		while (traversalNode != null && counter < N)
		{
			traversalNode = traversalNode.next;
			counter++;
		}
		Node newLastNode = traversalNode; // b

		Node newHead = traversalNode.next; // c

		// picking up the traversal from N and going till the last Node
		while (traversalNode.next != null)
		{
			traversalNode = traversalNode.next;
		}

		Node oldLastNode = traversalNode;// h
		System.out.println("oldLast:"+oldLastNode.data); //h
		System.out.println("newLast:"+newLastNode.data); //b
		System.out.println("oldHead:"+head.data);//a
		System.out.println("newHead:"+newHead.data);//c

		oldLastNode.next = head; // h->a (connecting rotated elements to oldLastNode)
		head.prev = oldLastNode; // h<-a (connecting rotated elements to oldLastNode)
		newHead.prev = null; // NULL <- c (setting the first node)
		newLastNode.next = null; // b -> NULL (setting the last node)

		head=newHead; //resetting the head
		return head;
	}

	public static void main(String[] args)
	{
		_23_RotateADoublyLLByNNodes ll = new _23_RotateADoublyLLByNNodes();

		System.out.print("\nHow many elements will LL store?: ");
		char[] input = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };

		// populating the linked list
		for (int i = 0; i <= input.length - 1; i++)
		{
			ll.insertAtBack(input[i]);
		}

		ll.printLL(head);

		head=ll.rotateDoublyLLByN_Nodes(head, 2);

		ll.printLL(head);
	}

}
