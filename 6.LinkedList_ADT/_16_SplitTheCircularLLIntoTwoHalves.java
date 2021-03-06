import java.util.Scanner;

public class _16_SplitTheCircularLLIntoTwoHalves
{
	public static Node oldHeadNode = null;
	static int ll_size = 0;
	
	// Nested Class (Node is the ADT)
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
		
		_16_SplitTheCircularLLIntoTwoHalves ll = new _16_SplitTheCircularLLIntoTwoHalves(); 
		
		ll.generateLL(ll, input); //SC=O(1) due to not creating any external data structures
		ll.printLL(oldHeadNode);
		Node midNode = ll.getMiddleNode();
		System.out.println("\nMid Node: " + midNode.data);
		ll.printLeftHalfOfTheLL(midNode);
		ll.printRightHalfOfTheLL(midNode);		
	}
	
	public void insertAtBack(int data)
	{
		// 1st, we created a node
		Node newNode = new Node(data);

		if (oldHeadNode == null) // if the list is empty
		{
			oldHeadNode = newNode;
		} else
		{
			// added a new node pointing void losing heads info
			Node traversalNode = oldHeadNode;

			while (traversalNode.next != null)
			{
				traversalNode = traversalNode.next; // updating the traversalNode pointer
			}
			traversalNode.next = newNode;
		}
	}
	
	public _16_SplitTheCircularLLIntoTwoHalves generateLL(_16_SplitTheCircularLLIntoTwoHalves ll, Scanner input)
	{
		System.out.print("\nHow many elements to store in your LL?: ");
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
	
	public void printLL(Node head)
	{		
		//-----------Traversing the linked list-------------------//
		Node traversalNode = head;		// added a new node pointing void losing heads info
		System.out.print("LL: ");
		while (traversalNode != null)
		{
			System.out.print(traversalNode.data + " "); //displaying the current nodes data
			traversalNode = traversalNode.next; // iterating the linked list
		}		
	}
	
	public Node getMiddleNode()
	{
		Node fastRunner = oldHeadNode;
		Node slowRunner = oldHeadNode;
		// handling an empty linked list
		if (oldHeadNode == null)
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
	
	public void printLeftHalfOfTheLL(Node midNode)
	{		
		//-----------Traversing the linked list-------------------//
		Node traversalNode = oldHeadNode;		//starting the traversal at the first node

		System.out.print("First Half of LL: ");
		while (traversalNode != null)
		{
			//filter that stops traversing the linked list after the midNode is reached
			if(traversalNode == midNode)
			{
				break;
			}
			System.out.print(traversalNode.data + " "); //displaying the current nodes data
			traversalNode = traversalNode.next; // iterating the linked list
		}		
	}
	
	public void printRightHalfOfTheLL(Node midNode)
	{
		//-----------Traversing the linked list-------------------//
		Node newHeadNode =midNode; 	//starting the traversal at the midNode
		
		System.out.print("\nSecond Half of LL: ");
		while (newHeadNode != null)
		{
			System.out.print(newHeadNode.data + " "); //displaying the current nodes data
			newHeadNode = newHeadNode.next; // iterating the linked list
		}		
		
	}
}
