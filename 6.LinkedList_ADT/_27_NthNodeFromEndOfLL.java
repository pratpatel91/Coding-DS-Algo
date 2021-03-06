import java.util.Scanner;

public class _27_NthNodeFromEndOfLL
{
	static Node head = null; // created a node to preserve heads info (iterative case)
	
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
	public void insertAtBack(int data)
	{
		// 1st, we created a node
		Node newNode = new Node(data);

		if (head == null) // if the list is empty
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
	}
		
	public int printNthNodeFromTheEndOfLL(Node head, int N)
	{
		// added a new node pointing void losing heads info
		Node first = head;
		Node second = head;
		int counter =0;
		int size = 0;
		
		System.out.print("LL: ");
		while (first.next != null && counter <(N-1))
		{
			System.out.print(first.data + " ");
			first = first.next; // updating the traversalNode pointer
			counter++;
			size++;
			//System.out.println("Size: " + size);
		}
		System.out.println();

		while (first.next != null )
		{
			first=first.next;
			second=second.next;
			size++;
			//System.out.println("-- Size: " + size);
		}
		//handling edge case 
		if(N>size)
		{
			return -1;
		}
		return second.data;
	}
	
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		_27_NthNodeFromEndOfLL ll = new _27_NthNodeFromEndOfLL();
		
		int N = 2;
		
		System.out.print("\nElements in LL?: ");
		int sizeOfLL = input.nextInt();

		// populating the linked list
		for (int i = 1; i <= sizeOfLL; i++)
		{
			System.out.print("Enter ll element: ");
			int userInput = input.nextInt();
			ll.insertAtBack(userInput);
		}
		int nthNodeFromEnd=ll.printNthNodeFromTheEndOfLL(head,N);
		System.out.print(N+"thNodeFromEnd:" + nthNodeFromEnd);

	}

}
