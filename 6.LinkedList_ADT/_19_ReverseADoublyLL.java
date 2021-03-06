import java.util.Scanner;

public class _19_ReverseADoublyLL
{
	static Node head = null; // created a node to preserve heads info (iterative case)

	// Nested Class (LLNode is the ADT, int is the primitive data type)
	static class Node
	{
		int data;
		Node prev;
		Node next;

		// constructor
		Node(int data)
		{
			this.data = data;
			prev = null;
			next = null;
		}
	}

	public void insertAtBack(int data)
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

	Node reverseLL(Node head)
	{
		Node previousNode = null;
		Node currentNode = head;

		while (currentNode != null)
		{
			currentNode.prev = currentNode.next; //swapping left & right pointers
			currentNode.next = previousNode; //swapping left & right pointers
			previousNode = currentNode; // updating prev
			currentNode = currentNode.prev; // updating current
		}

		head = previousNode; // making last element as the new node (due to reversal)
		return head;
	}

	public void printLL(Node head)
	{
		// added a new node pointing void losing heads info
		Node traversalNode = head;

		while (traversalNode != null)
		{
			System.out.print(traversalNode.data + " ");
			traversalNode = traversalNode.next; // updating the traversalNode pointer
		}
		System.out.println();
	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		_19_ReverseADoublyLL ll = new _19_ReverseADoublyLL();

		System.out.print("\nHow many elements will LL store?: ");
		int sizeOfLL = input.nextInt();

		// populating the linked list
		for (int i = 1; i <= sizeOfLL; i++)
		{
			System.out.print("Enter ll element: ");
			int userInput = input.nextInt();
			ll.insertAtBack(userInput);
		}
		System.out.print("Original LL: ");
		ll.printLL(head);

		Node reverseLLHead = ll.reverseLL(head);
		
		System.out.print("Reversed LL: ");
		ll.printLL(reverseLLHead);
	}

}
