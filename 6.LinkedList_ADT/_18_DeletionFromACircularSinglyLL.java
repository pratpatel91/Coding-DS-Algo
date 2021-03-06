public class _18_DeletionFromACircularSinglyLL
{
	static Node head = null;

	// Nested Class (LLNode is the ADT, int is the primitive data type)
	public class Node
	{
		int data;
		Node next;

		// constructor
		Node(int data)
		{
			this.data = data;
			next = null;
		}
	}

	public void insertAtBack(int data)
	{
		// 1st, we created a node
		Node newNode = new Node(data);

		//if the linked list is empty then create a new ndoe
		if (head == null)
		{
			head = newNode;
		} else //if the linked list isnt empty then insert at front
		{
			// added a new node pointing void losing heads info
			Node traversalNode = head;

			while (traversalNode.next != null)
			{
				traversalNode = traversalNode.next; // updating the traversalNode pointer
			}
			traversalNode.next = newNode;
		}
	}

	public void deleteAtFront()
	{
		Node newHead = head.next;// 1st nodes pointer is severed
		
		 //code for supporting circular ll
		Node traversalNode = newHead;
		while (traversalNode.next != head)
		{
			traversalNode = traversalNode.next; 
		}
		//2nd, we want to do last.next=head in order to make the LL circular
		traversalNode.next=newHead;
		head=newHead;
	}

	public void deleteAtMiddle(int data, int place)
	{
		// 1st, we created a node
		Node currentNode = null;
		Node currentAfterCurrentNode = null;

		// added a new node pointing void losing heads info
		Node traversalNode = head;
		int size = 1;

		while (traversalNode.next != head && size <= place)
		{
			size++;
			if (size == place)
			{
				currentNode = traversalNode;
				currentAfterCurrentNode = currentNode.next.next;
			}
			traversalNode = traversalNode.next; // updating the traversalNode
		}
		currentNode.next = currentAfterCurrentNode;

	}

	public void deleteAtBack()
	{
		if (head == null)
		{
			return;
		} else
		{
			// added a new node pointing void losing heads info
			Node beforeLastNode = head;

			while (beforeLastNode.next.next != head)
			{
				beforeLastNode = beforeLastNode.next; // updating the traversalNode pointer
			}
			beforeLastNode.next = head; //code for supporting circular ll
		}
	}
	
	public void printLL()
	{
		// LL TRAVERSAL----------------//
		// added a new node pointing void losing heads info
		Node traversalNode = head;

		//traversalNode != null condition is for handling a singly LL
		//traversalNode.next !=head condition is for handling a circular singly LL

		while (traversalNode != null  && traversalNode.next !=head)
		{
			System.out.print(traversalNode.data + " ");
			traversalNode = traversalNode.next; // updating the traversalNode pointer
		}
		System.out.println(traversalNode.data); //printing the last node
	}
	
	public void makingLLCircular(Node head)
	{
		//1st, we want to traverse the LL in order to get to the last element
		Node traversalNode = head;
		while (traversalNode.next != null)
		{
			traversalNode = traversalNode.next; 
		}
		//2nd, we want to do last.next=head in order to make the LL circular
		traversalNode.next=head;
	}
	
	public static void main(String[] args)
	{
		_18_DeletionFromACircularSinglyLL ll = new _18_DeletionFromACircularSinglyLL(); // head->null

		for(int i=1; i<=7; i++)
		{
			ll.insertAtBack(i);
		}
		
		ll.makingLLCircular(head);
		ll.printLL();
		
		ll.deleteAtFront(); 
		ll.printLL();
		
		ll.deleteAtBack();
		ll.printLL();
		
		ll.deleteAtMiddle(5, 4);
		ll.printLL();

	}

}
