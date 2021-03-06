import java.util.Scanner;

public class _7_RemoveDuplicatesFromASortedLL
{
	static LLNode_ADT head = null; // created a node to preserve heads info (iterative case)

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

	public LLNode_ADT removeDuplicates(LLNode_ADT head)
	{
		LLNode_ADT current = head;
		LLNode_ADT afterCurrent = head;

		while (current != null)
		{
			//traversing all the duplicates
			while (afterCurrent.next != null && current.data == afterCurrent.next.data)
			{
				afterCurrent = afterCurrent.next;
			}
			//severing the connection to all the duplicates
			current.next = afterCurrent.next; //severing the connection to remove duplicates
			afterCurrent = afterCurrent.next; 
			current = afterCurrent; 
		}
		return head; //printing only 1 element 
	}

	public static void main(String[] args)
	{
		// creating the linked list
		_7_RemoveDuplicatesFromASortedLL ll = new _7_RemoveDuplicatesFromASortedLL(); // head->null
		Scanner input = new Scanner(System.in);

		// populating the linked list
		for (int i = 1; i <= 10; i++)
		{
			int value = input.nextInt();
			ll.insertAtBack(value);
		}
		
		ll.printLinkedList(head);
		
		head=ll.removeDuplicates(head);
		
		ll.printLinkedList(head);
	}
}
