import java.util.Scanner;

public class _23_ReverseADLLOfNGroupSize
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

	Node reversedLinkedList(Node head, int K)
	{
		Node currentNode = head;

		int count = 1;

		while (count <= K)
		{
			//BASE CASE
			if(currentNode != null)
			{
				currentNode=currentNode.next;
				count++;
			}
			else //if we cant find group size of K
			{
				return head;
			}
		}
		//currentNode will point will point to the last Node of the current group
		
		//head will point will point to the first Node of the current group
		//head is updated due to reversal of DLL
		Node newHead=reverseDLL(head,currentNode);
		
		head.next=reversedLinkedList(currentNode,K);
		return newHead;
	}
	
	Node reverseDLL(Node first, Node last)
	{
		Node previousNode = last;
		
		while (first != last )
		{
			Node temp = first.next;
			first.next=previousNode;
			previousNode=first;
			first=temp;
		}
		return previousNode;
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
		_23_ReverseADLLOfNGroupSize ll = new _23_ReverseADLLOfNGroupSize();

		System.out.print("\nHow many elements will LL store?: ");
		int sizeOfLL = input.nextInt();

		// populating the linked list
		for (int i = 1; i <= sizeOfLL; i++)
		{
			System.out.print("Enter ll element: ");
			int userInput = input.nextInt();
			ll.insertAtBack(userInput);
		}
		ll.printLL(head);
		head=ll.reversedLinkedList(head, 2);
		ll.printLL(head);

	}

}
