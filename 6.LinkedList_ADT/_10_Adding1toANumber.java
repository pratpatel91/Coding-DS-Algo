import java.util.Scanner;

public class _10_Adding1toANumber
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

	LLNode_ADT reversedLinkedList(LLNode_ADT head)
	{
		// initializing 3 pointers
		LLNode_ADT previousNode = null;
		LLNode_ADT currentNode = head;
		LLNode_ADT nextNode = null;

		while (currentNode != null)
		{
			nextNode = currentNode.next;
			// forming links
			currentNode.next = previousNode;
			// breaking the link
			previousNode = currentNode;
			// shifting the current pointer (i++)
			currentNode = nextNode;
			// System.out.println("Printing left side of linked list");
			// printLinkedList(previousNode);
			// System.out.println("Printing right side of linked list");
			// printLinkedList(currentNode);
		}

		head = previousNode; // making last element as the first node (aka head)
		return head;
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

	public LLNode_ADT add_1_ToTheLinkedList(LLNode_ADT head)
	{
		int carry = 1;
		LLNode_ADT current = head;
		LLNode_ADT newHead = null;
		LLNode_ADT tempNode = null;

		while (current != null)
		{
			int value = current.data + carry;
			int remainder = value % 10;
			carry = value / 10;

			if (newHead == null)
			{
				tempNode = new LLNode_ADT(remainder);
				newHead = tempNode;

			} else // handles creation of node during the first visit
			{
				LLNode_ADT tempNode_1 = new LLNode_ADT(remainder);
				tempNode.next = tempNode_1;
				tempNode = tempNode.next;
			}

			current = current.next; // updating the traversalNode pointer

		}
		if (carry > 0) // we are adding carry to the nodes data
		{
			LLNode_ADT tempNode_1 = new LLNode_ADT(carry);
			tempNode.next = tempNode_1;
			tempNode = tempNode.next;
		}
		return newHead;
	}

	public static void main(String[] args)
	{
		// creating the linked list
		_10_Adding1toANumber ll = new _10_Adding1toANumber(); // head->null

		Scanner input = new Scanner(System.in);
		int T = input.nextInt();

		//int intCapacity = 99999999999999999999;
		
		while (T>0)
		{
			// populating the linked list
			for (int i = 1; i <= 20; i++)
			{
				int value = input.nextInt();
				ll.insertAtBack(value);
			}
			
			System.out.print("Original LL: ");
			ll.printLinkedList(head);
			head = ll.reversedLinkedList(head);

			head = ll.add_1_ToTheLinkedList(head);
			System.out.print("LL after adding 1: ");
			ll.printLinkedList(head);

			head = ll.reversedLinkedList(head);
			System.out.print("Answer LL: ");
			ll.printLinkedList(head);
			System.out.println("-----------");
			T--;
			head=null; // resetting the ll so we dont append to previous answer
		}

		input.close();
	}

}
