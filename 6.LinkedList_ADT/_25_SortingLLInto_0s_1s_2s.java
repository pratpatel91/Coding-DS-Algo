import java.util.Scanner;

public class _25_SortingLLInto_0s_1s_2s
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

	public static void printLinkedList(Node head)
	{
		// added a new node pointing void losing heads info
		Node traversalNode = head;
		System.out.print("LL: ");
		while (traversalNode != null)
		{
			System.out.print(traversalNode.data + " ");
			traversalNode = traversalNode.next; // updating the traversalNode pointer
		}
	}

	public void sort_0_1_2(Node head)
	{
		// added a new node pointing void losing heads info
		Node traversalNode = head;

		int countZeros = 0;
		int countOnes = 0;
		int countTwos = 0;
		// ---------------1st, Getting a count of all the 0s,1s and 2s in the LL
		// ------//
		while (traversalNode != null)
		{
			if (traversalNode.data == 0)
			{
				countZeros++;
			} else if (traversalNode.data == 1)
			{
				countOnes++;
			} else
			{
				countTwos++;
			}
			traversalNode = traversalNode.next; // updating the traversalNode pointer
		}

		// ------------------2nd, Updating the LL to be 0,1,2 sequentially ------//
		traversalNode = head; // resetting the traversalNode from last to first

		while (traversalNode != null)
		{
			while (countZeros > 0)
			{
				traversalNode.data = 0; // updating the nodes data
				traversalNode = traversalNode.next;
				countZeros--;
			}
			while (countOnes > 0)
			{
				traversalNode.data = 1;// updating the nodes data
				traversalNode = traversalNode.next;
				countOnes--;
			}
			while (countTwos > 0)
			{
				traversalNode.data = 2; // updating the nodes data
				traversalNode = traversalNode.next;
				countTwos--;
			}
		}

		// ----------------3rd, Printing the LL to be 0,1,2 sequentially ------//
		printLinkedList(head);
	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		_25_SortingLLInto_0s_1s_2s ll = new _25_SortingLLInto_0s_1s_2s();

		System.out.print("\nElements in LL?: ");
		int sizeOfLL = input.nextInt();

		// populating the linked list //1,2,2,1,2,0,2,2
		for (int i = 1; i <= sizeOfLL; i++)
		{
			System.out.print("Enter ll element: ");
			int userInput = input.nextInt();
			ll.insertAtBack(userInput);
		}

		ll.sort_0_1_2(head);
	}
}
