import java.util.Scanner;
//IDE SPECIFIC DISPLAY ERROR 321654 instead of 32165487
public class _2_Revising_LL_of_KSize
{
	static LLNode_ADT headNode = null;

	// Nested Class (LLNode is the ADT, int is the primitive data type)
	static class LLNode_ADT
	{
		int data;
		LLNode_ADT nextPointer;

		// constructor
		LLNode_ADT(int data)
		{
			this.data = data;
			nextPointer = null;
		}
	}

	public void insertAtBack(int data)
	{
		// 1st, we created a node
		LLNode_ADT newNode = new LLNode_ADT(data);

		// if the linked list is empty then create a new ndoe
		if (headNode == null)
		{
			headNode = newNode;
		} else // if the linked list isnt empty then insert at front
		{
			// added a new node pointing void losing heads info
			LLNode_ADT traversalNode = headNode;

			while (traversalNode.nextPointer != null)
			{
				traversalNode = traversalNode.nextPointer; // updating the traversalNode pointer
			}
			traversalNode.nextPointer = newNode;
		}
	}

	public void printLinkedList()
	{
		// LL TRAVERSAL----------------//
		// added a new node pointing void losing heads info
		LLNode_ADT traversalNode = headNode;
		int size = 0;

		while (traversalNode != null)
		{
			System.out.print(traversalNode.data + " ");
			size++;
			traversalNode = traversalNode.nextPointer; // updating the traversalNode pointer
		}
		System.out.println("\nLength: " + size + " elements");
	}

	LLNode_ADT reversedLinkedList(LLNode_ADT head, int K)
	{
		// initializing 3 pointers
		LLNode_ADT previousNode = null;
		LLNode_ADT currentNode = head;
		LLNode_ADT nextNode = null;

		int count = 1;

		// handles the reversal for the current set of K Elements
		while (currentNode != null && count <= K)
		{
			nextNode = currentNode.nextPointer;
			// forming links
			currentNode.nextPointer = previousNode;
			// breaking the link
			previousNode = currentNode;
			// shifting the current pointer (i++)
			currentNode = nextNode;

			count++;
		}

		// handles the reversal for the next set of K Elements
		if (nextNode != null)
		{
			System.out.println("next val: " + nextNode.data);
			headNode.nextPointer = reversedLinkedList(nextNode, K);
		}

		return previousNode;
	}

	// Static indicates that the main method can run independent
	// of using objects
	public static void main(String[] args)
	{
		_2_Revising_LL_of_KSize ll = new _2_Revising_LL_of_KSize();

		int K = 3;

		Scanner input = new Scanner(System.in);

		// populating the linked list
		for (int i = 1; i <= 8; i++)
		{
			// int data=input.nextInt();
			ll.insertAtBack(i);
		}

		// displaying the populated linked list
		ll.printLinkedList();

		// reversing K Sized Linked List to get the updated headNode
		headNode = ll.reversedLinkedList(headNode, K);

		// displaying the populated linked list
		ll.printLinkedList();

	}

}
