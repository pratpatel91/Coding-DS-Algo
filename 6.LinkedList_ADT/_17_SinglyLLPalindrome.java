import java.util.Scanner;

public class _17_SinglyLLPalindrome
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
		
	Node reversedLinkedList(Node head)
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
			// System.out.println("Printing left side of linked list");
			// printLinkedList(previousNode);
			// System.out.println("Printing right side of linked list");
			// printLinkedList(currentNode);
		}

		head = previousNode; // making last element as the first node (aka head)
		return head;
	}
	
	public Node getMiddleNode(Node head)
	{
		Node fastRunner = head;
		Node slowRunner = head;
		// handling an empty linked list
		if (head == null)
		{
			System.out.println("Your Linked list is empty");
			return null;
		}
		//if (fastRunner is null) {even LL} 
		//if (fastRunner.next is null) {odd LL} 
		while (fastRunner != null && fastRunner.next != null)
		{
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next.next;
		}
		
		Node secondHalfHead = null;
		
		//-Pay attention here ----------//
		if(fastRunner== null)
		{
			secondHalfHead=slowRunner; //even LLS new Head
		}
		else if (fastRunner.next == null)
		{
			secondHalfHead=slowRunner.next; //odd LLs new Head
		}
		
		return secondHalfHead;
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
		}
		// System.out.println("\nLL Size: " + ll_size);
	}
	
	
	public boolean isTheLLAPalindrome(Node head)
	{
		// if the ll is empty or if the ll has 1 node them its a palindrome by default
		if(head == null || head.next==null)
		{
			return true;  // its a palindrome
		}
		Node firstHalfHead = head;
		
		//1st, we find the mid in order to split the ll into two halves
		Node secondHalfHead = getMiddleNode(head);
		
		//2nd, we reverse second half of the ll
		secondHalfHead = reversedLinkedList(secondHalfHead);
		 
		
		//3rd, we compare the first half to the reversed second half
		//and if they both match then we have a palindrome
		while(secondHalfHead != null)
		{
			if(secondHalfHead.data == firstHalfHead.data)
			{
				firstHalfHead=firstHalfHead.next;//update pointer
				secondHalfHead=secondHalfHead.next; //update pointer
			}
			else
			{
				return false; // not a palindrome
			}
		}
		return true; // its a palindrome
	}

	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		_17_SinglyLLPalindrome ll = new _17_SinglyLLPalindrome();
		
		System.out.print("\nHow many elements would you like to store in your LL?: ");
		int sizeOfLL = input.nextInt();

		// populating the linked list
		for (int i = 1; i <= sizeOfLL; i++)
		{
			System.out.print("Enter ll element: ");
			int userInput = input.nextInt();
			ll.insertAtBack(userInput);
		}
		ll.printLinkedList(head);
		
		System.out.println("\nIs LL A Palindrome?: " + ll.isTheLLAPalindrome(head));
		
		
		
		

	}

}
