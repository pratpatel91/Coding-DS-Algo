import java.util.Scanner;

public class _14_FindMiddleElementIn_A_LL
{
	static Node head = null; // created a node to preserve heads info (iterative case)
	static int ll_size = 1;

	// resetting the ll for the next run
	_14_FindMiddleElementIn_A_LL()
	{
		ll_size = 1; // resetting the size to be 1 again
		head = null;// deleting the entire linked list
	}

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

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		_14_FindMiddleElementIn_A_LL ll_obj2 = new _14_FindMiddleElementIn_A_LL();
		ll_obj2.genLinkedList(ll_obj2, input);
		ll_obj2.printLinkedList(head);
		Node middleNode = ll_obj2.alternative_GetMiddleNode(head);
		System.out.println("\nLL Middle: " + middleNode.data);

		System.out.println("\n------------Another way to find middle node----------------");
		System.out.print("How many tests would you like to run?: ");
		int testCases = input.nextInt();
		_14_FindMiddleElementIn_A_LL ll;

		while (testCases != 0)
		{
			ll = new _14_FindMiddleElementIn_A_LL(); // resetting the ll for the next run
			ll.genLinkedList(ll, input); // TC=O(N) SC=O(1) due to creating no external data structures
			ll.printLinkedList(head); // TC=O(N)
			ll.printMiddleNode(head); // TC=O(N)
			testCases--;
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

	public _14_FindMiddleElementIn_A_LL genLinkedList(_14_FindMiddleElementIn_A_LL ll, Scanner input)
	{
		System.out.print("\nHow many elements would you like to store in your LL?: ");
		int sizeOfLL = input.nextInt();

		// populating the linked list
		for (int i = 1; i <= sizeOfLL; i++)
		{
			System.out.print("Enter ll element: ");
			int userInput = input.nextInt();
			ll.insertAtBack(userInput);
		}
		return ll;
	}

	public void printLinkedList(Node head)
	{
		// added a new node pointing void losing heads info
		Node traversalNode = head;
		System.out.print("LL: ");
		while (traversalNode != null)
		{
			System.out.print(traversalNode.data + " ");
			traversalNode = traversalNode.next; // updating the traversalNode pointer
			ll_size++;
		}
		// System.out.println("\nLL Size: " + ll_size);
	}

	public int computeMid()
	{
		int mid = 1;

		if (ll_size % 2 == 0) // checking for even number
		{
			mid = (ll_size / 2);
		} else if (ll_size % 2 == 1) // checking for odd number
		{
			mid = (ll_size / 2) + 1; // printing the second middle element
		} else // handles the case whem we have only 1 element in the LL
		{
			return mid;
		}

		return mid;
	}

	public void printMiddleNode(Node head)
	{
		// added a new node pointing void losing heads info
		Node traversalNode = head;

		int mid = computeMid();

		int iterator = 1;

		while (traversalNode != null)
		{
			// filter for printing the middle element
			if (iterator == mid)
			{
				System.out.println("\nLL Middle: " + traversalNode.data);
			}

			// traversing all the nodes in the LL
			traversalNode = traversalNode.next; // updating the traversalNode pointer
			iterator++;
		}
	}

	public Node alternative_GetMiddleNode(Node head)
	{
		Node fastRunner = head;
		Node slowRunner = head;
		// handling an empty linked list
		if (head == null)
		{
			System.out.println("Your Linked list is empty");
			return null;
		}

		while (fastRunner != null && fastRunner.next != null)
		{
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next.next;
		}
		return slowRunner;
	}

}
