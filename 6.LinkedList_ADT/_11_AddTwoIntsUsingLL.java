import java.util.Scanner;

public class _11_AddTwoIntsUsingLL
{
	static Node headA = null;
	static Node headB = null;

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

	static Node reversedLinkedList(Node head)
	{
		// initializing 3 pointers
		Node previousNode = null;
		Node currentNode = head;
		Node nextNode = null;

		while (currentNode != null)
		{
			nextNode = currentNode.next;
			// forming links
			currentNode.next = previousNode;
			// breaking the link
			previousNode = currentNode;
			// shifting the current pointer (i++)
			currentNode = nextNode;
		}

		head = previousNode; // making last element as the first node (aka head)
		return head;
	}

	public static void printLinkedList(Node head)
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

	public static int lengthLL(Node head)
	{
		// LL TRAVERSAL----------------//
		Node traversalNode = head;
		int size = 0;
		while (traversalNode != null)
		{
			traversalNode = traversalNode.next; // updating the traversalNode pointer
			size++;
		}
		return size;
	}
	//Extension of Adding 1 to a Linked List 
	public static Node addingNodesOfTwoLL(Node headA, Node headB)
	{
		int carry = 0; // carry should be zero
		Node currentA = headA;
		Node currentB = headB;

		Node newHead = null;
		Node tempNode = null;

		while (currentA != null && currentB != null)
		{
			int value = currentA.data + currentB.data + carry;
			int remainder = value % 10;
			carry = value / 10;

			// creating a new linked list
			if (newHead == null)
			{
				tempNode = new Node(remainder);
				newHead = tempNode;

			} else // inserting temp node at the back of the ll
			{
				Node tempNode_1 = new Node(remainder);
				tempNode.next = tempNode_1;
				tempNode = tempNode.next;
			}

			currentA = currentA.next; // updating the traversalNode pointer
			currentB = currentB.next; // updating the traversalNode pointer
		}
		if (carry > 0) // we are adding carry to the nodes data
		{
			Node carryNode = new Node(carry);
			tempNode.next = carryNode;
			tempNode = tempNode.next;
		}
		return newHead;
	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		// ----------------------------------------------------------------------------------//
		_11_AddTwoIntsUsingLL ll_A = new _11_AddTwoIntsUsingLL();

		System.out.print("\nHow many elements would you like to store in your LL?: ");
		int sizeOfLL_A = input.nextInt();

		// populating the linked list
		for (int i = 1; i <= sizeOfLL_A; i++)
		{
			System.out.print("Enter ll element: ");
			int userInput = input.nextInt();
			headA = ll_A.insertAtBack(userInput, headA);
		}

		// ----------------------------------------------------------------------------------//

		_11_AddTwoIntsUsingLL ll_B = new _11_AddTwoIntsUsingLL();

		System.out.print("\nHow many elements would you like to store in your LL?: ");

		int sizeOfLL_B = input.nextInt();

		// populating the linked list
		for (int i = 1; i <= sizeOfLL_B; i++)
		{
			System.out.print("Enter ll element: ");
			int userInput = input.nextInt();
			headB = ll_A.insertAtBack(userInput, headB);
		}

		// -----------------Appending zeroes to the shorter
		// ll----------------------------//
		int sizeA = lengthLL(headA);
		int sizeB = lengthLL(headB);

		if (sizeA > sizeB)
		{
			int diff = sizeA - sizeB;

			// appending zeroes to the front of the shorter ll (headB one in this case)
			while (diff > 0)
			{
				Node newNode = new Node(0);
				newNode.next = headB;
				headB = newNode;
				diff--;
			}
		} else // if(sizeB > sizeA)
		{
			int diff = sizeB - sizeA;

			// appending zeroes to the front of the shorter ll (headA one in this case)
			while (diff > 0)
			{
				Node newNode = new Node(0);
				newNode.next = headA;
				headA = newNode;
				diff--;
			}
		}
		printLinkedList(headA);
		printLinkedList(headB);
		// ----------------------------------------------------------------------------------//

		// 1st, reverse the ll
		headA = reversedLinkedList(headA);
		headB = reversedLinkedList(headB);

		Node result = addingNodesOfTwoLL(headA, headB);

		result = reversedLinkedList(result);

		System.out.print("\nLL(2 Nums added):");
		printLinkedList(result);

		input.close();
	}
}
