import java.util.Scanner;

public class _20_FindNodePairWithSumInLL
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

	public void printLL(Node head)
	{
		// added a new node pointing void losing heads info
		Node traversalNode = head;
		System.out.print("LL: ");
		while (traversalNode != null)
		{
			System.out.print(traversalNode.data + " ");
			traversalNode = traversalNode.next; // updating the traversalNode pointer
		}
		System.out.println();
	}

	public void twoPointers_NodePairsForSumInDoublyLL(Node head, int targetSum)
	{
		// --------------------------Analogous to TwoPointers for Arrays-------------//
		// NOTE: Two Pointers is the most optimal technique for a sorted array or a
		// sorted LL
		Node left = head;
		Node right = head;
		// 1st, we want to traverse the LL so that right points to the last node
		while (right.next != null)
		{
			right = right.next; // right++
		}
		// now right is at last node

		// 2nd, we are traversing the LL again however this time
		// we are updating the left and right nodes until we reach the given sum
		//(left.prev!= right && right.next!= left) get rids of redundant Node Pairs that satisfy the sum
		while (left != null && right != null && left.prev!= right && right.next!= left)
		{
			if (left.data + right.data == targetSum)
			{
				System.out.println("Node Paid Found: {" + left.data + ", " + right.data + "}");
				left = left.next;// left++
				right = right.prev;// right--
			} else if (left.data + right.data > targetSum)
			{
				right = right.prev; // right--
			} else // if (left.data + right.data < targetSum)
			{
				left = left.next; // left++
			}
		}
	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		_20_FindNodePairWithSumInLL ll = new _20_FindNodePairWithSumInLL();
		
		int targetSum=9;
		
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
		ll.twoPointers_NodePairsForSumInDoublyLL(head,targetSum);
		
	}

}
