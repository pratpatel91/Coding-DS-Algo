import java.util.Scanner;

public class _16_IntersectionOfTwoSortedLLs
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

	public static Node commonElementsInLL(Node headA, Node headB)
	{
		Node newHead = null;
		Node tempNode = null;
		Node currentA = headA;
		Node currentB = headB;
		
		int[] commonElementsHash = new int[10000];
		
		//Hashing currentA LL
		while(currentA != null)
		{
			int value = currentA.data;
			commonElementsHash[value]++;
			currentA=currentA.next; //infinite loop without this update of pointer
		}
		
		//Hashing currentB LL
		while(currentB != null)
		{
			int value = currentB.data;
			
			//adding to hash
			if(commonElementsHash[value]>0)
			{
				if(newHead == null)
				{
					newHead=new Node(value);
					tempNode=newHead;
				}
				else
				{
					Node newNode = new Node(value);
					tempNode.next=newNode;
					tempNode=tempNode.next;
				}
			}
			currentB=currentB.next; //infinite loop without this update of pointer
		}
		
		return newHead;
	}

	
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		// ----------------------------------------------------------------------------------//
		_16_IntersectionOfTwoSortedLLs ll_A = new _16_IntersectionOfTwoSortedLLs();

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

		_16_IntersectionOfTwoSortedLLs ll_B = new _16_IntersectionOfTwoSortedLLs();

		System.out.print("\nHow many elements would you like to store in your LL?: ");

		int sizeOfLL_B = input.nextInt();

		// populating the linked list
		for (int i = 1; i <= sizeOfLL_B; i++)
		{
			System.out.print("Enter ll element: ");
			int userInput = input.nextInt();
			headB = ll_A.insertAtBack(userInput, headB);
		}

		input.close();
		
		Node commonElementsLLHead = commonElementsInLL(headA, headB);
		
		System.out.print("\nElements common to both LLS: ");
		printLinkedList(commonElementsLLHead);
		
		
	}

}
