public class LoopLengthInLinkedList
{

	static LLNode_ADT headNode = null;
	static LLNode_ADT tempNode = null;
	static LLNode_ADT lastNode = null;

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

	public int lengthOfLoop(LLNode_ADT headNode)
	{
		// a loop exists when the traversalNode doesnt point to null

		LLNode_ADT slowPointer = headNode;
		LLNode_ADT fastPointer = headNode;
		int loopLength=0;

		//detecting the while loop
		while (slowPointer != null && fastPointer != null && fastPointer.nextPointer != null)
		{
			slowPointer = slowPointer.nextPointer; // moving 1 steps at a time
			fastPointer = fastPointer.nextPointer.nextPointer; // moving 2 steps at a time
			if (slowPointer == fastPointer)
			{
				break;
			}
		}
		if (slowPointer == fastPointer)
		{
			slowPointer = headNode; // resetting the slow pointer as the headNode

			//traversing the loop
			while (slowPointer != fastPointer)
			{
				loopLength++;
				slowPointer = slowPointer.nextPointer; // moving 1 steps at a time
				fastPointer = fastPointer.nextPointer; // moving 1 steps at a time
			}
			loopLength++;
			return loopLength; // loop found that why we are returning start of loop
		}
		return loopLength; //no loop found so loopLength=0
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

			// creating a loop (connecting node (val:6) to node (val:3))
			if (data == 3)
			{
				tempNode = newNode; // storing address of node with val=3
			}

			if (data == 6)
			{
				lastNode = newNode; // storing address of node with val=6
			}
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

	public static void main(String[] args)
	{
		LoopLengthInLinkedList ll = new LoopLengthInLinkedList();

		// populating the linked list
		for (int i = 1; i <= 6; i++)
		{

			ll.insertAtBack(i);
		}
		ll.printLinkedList();
		
		// creating a loop (connecting node (val:6) to node (val:3))
		lastNode.nextPointer = tempNode;

		// ll.printLinkedList(); // looping create infinite loop for printing the linked
		// list

		System.out.println("Length of loop in llist: " + ll.lengthOfLoop(headNode));
	}

}
