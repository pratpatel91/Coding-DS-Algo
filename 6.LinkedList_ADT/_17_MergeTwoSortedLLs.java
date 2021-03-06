import java.util.Scanner;

public class _17_MergeTwoSortedLLs
{
	static Node head = null;

	// Nested Class (LLNode is the ADT, int is the primitive data type)
	static class Node
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

	public Node insertAtBack(int data, Node head)
	{

		// 1st, we created a node
		Node newNode = new Node(data);

		if (head == null)
		{
			head = newNode;
		} else
		{
			// added a new node pointing void losing heads info
			Node traversalNode = head;

			while (traversalNode.next != null)
			{
				traversalNode = traversalNode.next; // updating the traversalNode pointer
			}
			traversalNode.next = newNode;
		}
		return head;
	}

	public void printLinkedList(Node head)
	{
		// LL TRAVERSAL----------------//
		Node traversalNode = head;

		while (traversalNode != null)
		{
			System.out.print(traversalNode.data + " ");
			traversalNode = traversalNode.next; // updating the traversalNode pointer
		}
		System.out.println();
	}

	public Node mergeTwoSortedLLS(Node firstLLHead, Node secondLLHead)
	{
		//BASE CASE
		if(firstLLHead == null)
		{
			return secondLLHead;
		}
		if(secondLLHead == null)
		{
			return firstLLHead;
		}
		
		//RECURSION
		if(firstLLHead.data < secondLLHead.data)
		{
			firstLLHead.next=mergeTwoSortedLLS(firstLLHead.next, secondLLHead);
			return firstLLHead;
		}
		secondLLHead.next=mergeTwoSortedLLS(firstLLHead, secondLLHead.next);
		return secondLLHead;
	}

	public Node mergeSortLL(Node head)
	{
		// BASE CASE (Simplest/atomic Problem to solve)
		// the simplest case is when
		// an empty ll is considered sorted
		// or when a 1 element ll is also considered sorted
		if (head == null || head.next == null)
		{
			return head;
		}
		Node midNode = getMiddle(head);

		// here we only have the left half of the ll (NOT THE BASE CASE)
		if (midNode == null)
		{
			return head;
		}
		
		Node firstLLHead = head;
		Node secondLLHead = midNode.next; // respecifying the head to traverse the right half of the ll
		midNode.next = null; // breaks the linked list into left half and right half

		firstLLHead=mergeSortLL(firstLLHead); // RECURSION
		secondLLHead=mergeSortLL(secondLLHead); // RECURSION
		
		//-----------------ERROR that created stack overflow for recursion -------------------//
		//function enter a stack and never gets popped due to unfinished work (not executing Return statement)
		//so stack calls keep on adding and we exceed the stack memory capacity which is what triggers
		// stack overflow (Running out of memory allocated for stack memory)
		//mergeSortLL(firstLLHead); // RECURSION
		//mergeSortLL(secondLLHead); // RECURSION

		return mergeTwoSortedLLS(firstLLHead, secondLLHead);
	}

	public Node getMiddle(Node head)
	{
		if (head == null)
		{
			return null;
		}

		Node slow = head;
		Node fast = head;

		// fast.next!=null handles odd case
		// fast.next.next!=null handles even case
		while (fast.next != null && fast.next.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow; // since fast is going at 2x (when fast is at end; slow will be at mid)
	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		// NOT APPLICABLE FOR ARGS ERROR means incorrect class name for creating an
		// object
		_17_MergeTwoSortedLLs ll = new _17_MergeTwoSortedLLs();

		System.out.print("\nHow many elements will LL hold?: ");
		int sizeOfLL_A = input.nextInt();

		// populating the linked list
		for (int i = 1; i <= sizeOfLL_A; i++)
		{
			System.out.print("Enter ll element: ");
			int userInput = input.nextInt();
			head = ll.insertAtBack(userInput, head);
		}

		head = ll.mergeSortLL(head);
		ll.printLinkedList(head);
	}

}
