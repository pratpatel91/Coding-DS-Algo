public class _5_RemoveLoop
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

	
	public LLNode_ADT removeLoop(LLNode_ADT headNode)
	{
		// a loop exists when the traversalNode doesnt point to null
		LLNode_ADT slowPointer = headNode;
		LLNode_ADT fastPointer = headNode;
		LLNode_ADT lastPointer = headNode;

		// using the traversalNode to traverse the linked list
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
			slowPointer = headNode; //resetting the slow pointer as the headNode
			
			while (slowPointer != fastPointer)
			{
				lastPointer=fastPointer;
				slowPointer=slowPointer.nextPointer; // moving 1 steps at a time
				fastPointer=fastPointer.nextPointer; // moving 1 steps at a time
			}
			System.out.println("sp_data:" + slowPointer.data +", lp_data:" + lastPointer.data);
			
			lastPointer.nextPointer=null; //breaking the loop
			
			return slowPointer; //loop found that why we are returning start of loop
		}
		else
		{
			return null; //no loop found
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
		_5_RemoveLoop ll = new _5_RemoveLoop();

		// populating the linked list
		for (int i = 1; i <= 6; i++)
		{

			ll.insertAtBack(i);
		}
		ll.printLinkedList();
		
		// creating a loop (connecting node (val:6) to node (val:3))
		lastNode.nextPointer = tempNode;

		// list
		ll.removeLoop(headNode);
		
		ll.printLinkedList();
		
		
		
		
	}

}
