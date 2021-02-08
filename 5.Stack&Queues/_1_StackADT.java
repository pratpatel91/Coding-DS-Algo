//SC=O(N) due to creating an array
public class _1_StackADT
{
	// Instance Variables (shared across all objects)
	private int[] stackArray;
	private int stackSize;
	private int topOfStack;

	// constructor (object creation method)
	public _1_StackADT(int size)
	{
		System.out.println("Object Creation occurs...");
		topOfStack = -1; // calculates currentSize
		stackSize = size;
		stackArray = new int[size];
	}

	// cant use static here because our instance variables arent static
	// TC=O(1) due to having a top pointer
	public void pushOnTop(int data)
	{
		// if stack is full then dont add to the top
		if (!isFull())
		{
			System.out.println("Added to the Top:" + data);
			topOfStack++;
			stackArray[topOfStack] = data;
		} else
		{
			System.out.println("Cannot add element because the stack is full (Stack Overflow)");
		}
	}

	// TC=O(1) due to having a top pointer
	public int deleteFromTop()
	{
		// if stack is empty then dont remove from the top
		if (!isEmpty())
		{
			int topElement = stackArray[topOfStack];
			System.out.println("Removed from the top:" + topElement);
			topOfStack--;
			return topElement;
		} else
		{
			System.out.println("Cannot add element because the stack is empty (Stack Underflow)");
		}
		return -1;
	}

	public boolean isFull()
	{
		return (topOfStack == stackSize - 1); // index
	}

	public boolean isEmpty()
	{
		return (topOfStack == -1);
	}

	public void peek()
	{
		if (!isFull() && !isEmpty())
		{
			System.out.println("Top Element:" + stackArray[topOfStack]);
		}
	}

	public void displayStack()
	{
		System.out.println("");
		
		for(int i=0; i<=stackArray.length-1; i++)
		{
			System.out.print(stackArray[i] + " ");
		}
		System.out.println("\n");
	}
	
	public static void main(String[] args)
	{
		// creating the stack
		int size = 3;
		_1_StackADT queue = new _1_StackADT(size);

		// populating the stack
		queue.pushOnTop(1);
		queue.displayStack();
		
		queue.pushOnTop(2);
		queue.displayStack();
		
		queue.pushOnTop(3);
		queue.displayStack();
		
		queue.pushOnTop(4);// overflow
		queue.displayStack();

		queue.deleteFromTop(); // underflow
		queue.displayStack();
	}
}
