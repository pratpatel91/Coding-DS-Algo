public class LinkedList
{
	LLNode_ADT headPointer = null;

	// Nested Class (LLNode is the ADT, int is the primitive data type)
	public class LLNode_ADT
	{
		int data;
		LLNode_ADT nextPointer;

		// constructor
		LLNode_ADT(int data)
		{
			this.data = data;
			nextPointer = null;
		}
	}

	public void insertAtFront(int data)
	{
		// 1st, Create a newNode with given value
		LLNode_ADT newNode = new LLNode_ADT(data);
		
		//2nd, if the list is empty then make the head point to the new node
		if (headPointer == null)
		{
			headPointer = newNode;
		} 
		//3rd, if the  list isnt empty 
		else 
		{
		// 2nd, forming a connection between temp node and head node
		newNode.nextPointer = headPointer;
		// 3rd, set head to temp
		headPointer = newNode; // head and temp is pointing to same location
		}
	}

	public void insertAtBack(int data)
	{
		// 1st, we created a node
		LLNode_ADT newNode = new LLNode_ADT(data);

		//if the linked list is empty then create a new ndoe
		if (headPointer == null)
		{
			headPointer = newNode;
		} else //if the linked list isnt empty then insert at front
		{
			// added a new node pointing void losing heads info
			LLNode_ADT traversalNode = headPointer;

			while (traversalNode.nextPointer != null)
			{
				traversalNode = traversalNode.nextPointer; // updating the traversalNode pointer
			}
			traversalNode.nextPointer = newNode;
		}
	}

	public void insertAtMiddle(int data, int place)
	{
		// 1st, we created a node
		LLNode_ADT newNode = new LLNode_ADT(data);

		LLNode_ADT currentNode = null;
		LLNode_ADT afterCurrentNode = null;

		// added a new node pointing void losing heads info
		LLNode_ADT traversalNode = headPointer;
		int size = 0;

		while (traversalNode != null && size <= place)
		{
			size++;
			if (size == place)
			{
				currentNode = traversalNode;
				afterCurrentNode = currentNode.nextPointer;
			}
			traversalNode = traversalNode.nextPointer; // updating the traversalNode
		}
		currentNode.nextPointer = newNode;
		newNode.nextPointer = afterCurrentNode;

	}

	public void deleteAtFront()
	{
		headPointer = headPointer.nextPointer;// 1st nodes pointer is severed
	}

	public void deleteAtMiddle(int data, int place)
	{
		// 1st, we created a node
		LLNode_ADT newNode = new LLNode_ADT(data);
		LLNode_ADT currentNode = null;
		LLNode_ADT currentAfterCurrentNode = null;

		// added a new node pointing void losing heads info
		LLNode_ADT traversalNode = headPointer;
		int size = 0;

		while (traversalNode != null && size <= place)
		{
			size++;
			if (size == place)
			{
				currentNode = traversalNode;
				currentAfterCurrentNode = currentNode.nextPointer.nextPointer;
			}
			traversalNode = traversalNode.nextPointer; // updating the traversalNode
		}
		currentNode.nextPointer = currentAfterCurrentNode;

	}

	public void deleteAtBack()
	{
		if (headPointer == null)
		{
			return;
		} else
		{
			// added a new node pointing void losing heads info
			LLNode_ADT beforeLastNode = headPointer;

			while (beforeLastNode.nextPointer.nextPointer != null)
			{
				beforeLastNode = beforeLastNode.nextPointer; // updating the traversalNode pointer
			}
			beforeLastNode.nextPointer = null;
		}
	}
	
	public void printLinkedList()
	{
		// LL TRAVERSAL----------------//
		// added a new node pointing void losing heads info
		LLNode_ADT traversalNode = headPointer;
		int size = 0;

		while (traversalNode != null)
		{
			System.out.print(traversalNode.data + " ");
			size++;
			traversalNode = traversalNode.nextPointer; // updating the traversalNode pointer
		}
		System.out.println("\nLength: " + size + " elements");
	}
	
	//CANNOT HAVE NON STATIC VARIABLES IN A STATIC METHOD
	public boolean linearSearch_LinkedList(int value)
	{
		// LL TRAVERSAL----------------//
		// added a new node pointing void losing heads info
		LLNode_ADT traversalNode = headPointer; 

		while (traversalNode != null)
		{
			if (traversalNode.data == value)
			{
				return true;
			}
			// updating the traversalNode pointer
			traversalNode = traversalNode.nextPointer;
		}
		return false;
	}

	public static void main(String[] args)
	{
		LinkedList ll = new LinkedList(); // head->null
		System.out.println("\nInserting at Front");
		ll.insertAtFront(1); // temp=1->null ........... head->1
		ll.insertAtFront(2);// temp=2->head ........... head->2->1
		ll.insertAtFront(3);// temp=3->head ........... head->3->2->1
		ll.insertAtFront(4);// temp=4->head ........... head->4->3->2->1
		ll.insertAtFront(5);// temp=5->head ........... head->5->4->3->2->1

		System.out.println("\nInserting at Back");
		ll.insertAtBack(6);
		ll.insertAtBack(7);
		ll.insertAtBack(8);
		ll.insertAtBack(9);
		ll.printLinkedList();

		System.out.println("\nInserting at Middle after 1");
		ll.insertAtMiddle(55, 5);
		ll.printLinkedList();

		System.out.println("\nDeleting Middle Element after 1");
		ll.deleteAtMiddle(55, 5);
		ll.printLinkedList();

		System.out.println("\nDeleting from the front");
		ll.deleteAtFront();
		ll.printLinkedList();

		System.out.println("\nDeleting from the back");
		ll.deleteAtBack();
		ll.printLinkedList();
		
		System.out.println("\nSearching for 6 in the linked list");
		int value=6;
		if(ll.linearSearch_LinkedList(value))
		{
			System.out.println(value +" is present in the linked list");
		}
		else
		{
			System.out.println(value +" isnt present in the linked list");
		}
		
		System.out.println("\nSearching for 55 in the linked list");
		value =55;
		if(ll.linearSearch_LinkedList(value))
		{
			System.out.println(value +" is present in the linked list");
		}
		else
		{
			System.out.println(value +" isnt present in the linked list");
		}
	}

}
