import java.util.Scanner;

public class _9_MoveLastToFrontInLL
{
	static LLNode_ADT head = null;

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
	
	public LLNode_ADT moveLastToFront(LLNode_ADT head)
	{
		//two pointers
		LLNode_ADT lastNode = head;
		LLNode_ADT secondLastNode = null;
		
		//traversing the ll
		while(lastNode.next!= null)
		{
			secondLastNode=lastNode;
			lastNode=lastNode.next;
		}
		
		//after reaching the last node
		//we will change from last -> null to last ->head
		lastNode.next=head;
		//we will change from head -> secondLast to head -> first
		head=lastNode; //without this out output never prints the last node
		// going from secondLast ->4 to secondlast -> null
		secondLastNode.next=null; //avoids circular linked list
		
		return head; //head is now pointing to the first node
	}
	
	public static void main(String[] args)
	{
		// creating the linked list
		_9_MoveLastToFrontInLL ll = new _9_MoveLastToFrontInLL(); // head->null

		// populating the linked list
		for (int i = 1; i <= 5; i++)
		{
			ll.insertAtBack(i);
		}

		ll.printLinkedList(head);

		head = ll.moveLastToFront(head);
		
		ll.printLinkedList(head);
	}
	
	
}
