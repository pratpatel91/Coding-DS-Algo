/*
public class _28_FindAndDelete_Mid_In_O1_Time
{
	// Nested Class (LLNode is the ADT, int is the primitive data type)
	class Node
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

	class Stack_ADT
	{
		Node topOfStack; // head
		Node midOfStack;
		int counter;
	}

	Stack_ADT createStackObj()
	{
		Stack_ADT llStack = new Stack_ADT();
		llStack.counter = 0;
		llStack.topOfStack = null;
		llStack.midOfStack = null;
		return llStack;
	}

	void push(int data)
	{
		Node newNode = new Node(data);
		
		counter++;
		// Handling Stack with a single element
		if (topOfStack == null)
		{
			topOfStack = newNode;
			midOfStack = topOfStack;
		} else
		{
			newNode.prev = topOfStack;
			topOfStack.next = newNode;
			topOfStack = newNode;
			if (counter % 2 == 0) // if the counter is even
			{
				midOfStack = midOfStack.next; // updating mid when the size is even
			}
		}
	}

	// TC=O(1)
	public int getMidOfStack()
	{
		return midOfStack.data;
	}

	public int pop()
	{
		int topElement = -1;

		// Handling Stack with a single element
		if (topOfStack == null)
		{
			return topElement;
		} else
		{
			topElement = topOfStack.data;

			counter--;
			if (counter == 0)
			{
				topOfStack = null;
				midOfStack = null;
			} else // if we have values on the stack
			{
				topOfStack = topOfStack.prev; // resetting topOfStack to the prev value
				topOfStack.next = null;
				if (counter % 2 == 1) // if the counter is odd
				{
					midOfStack = midOfStack.prev;

				}
			}
		}
		return topElement;
	}

	// TC=O(1)
	public void deleteMidOfStack()
	{
		// 1,2,3,4,5,6,7 (mid =4)
		counter--;
		// 1,2,3,5,6,7
		//
		if (midOfStack.next != null)
		{
			midOfStack.next.prev = midOfStack.prev; // 5 points to 3
		}
		if (midOfStack.prev != null)
		{
			midOfStack.prev.next = midOfStack.next; // 3 points to 5
		}

		// -----Logic for shifting mid based on the size --------//
		if (counter % 2 == 1) // if the size is odd then we are updating mid to be prev element
		{
			midOfStack = midOfStack.prev;
		} else // if the size is even then we update mid as the next element
		{
			midOfStack = midOfStack.next;
		}
	}

	public void printStack(Node topOfStack)
	{
		Node traversalNode = topOfStack;

		while (traversalNode != null)
		{
			System.out.print(traversalNode.data + " ");
			traversalNode = traversalNode.prev;
		}
	}

	public static void main(String[] args)
	{
		System.out.println("------Stack (Using DLLS)--------");
		_28_FindAndDelete_Mid_In_O1_Time obj = new _28_FindAndDelete_Mid_In_O1_Time();
		Stack_ADT llStack = obj.createStackObj();

		for (int i = 1; i <= 7; i++)
		{
			llStack.push(i);
		}

		llStack.printStack(llStack.topOfStack);

		llStack.pop();

		llStack.printStack(llStack.topOfStack);
	}
}
*/