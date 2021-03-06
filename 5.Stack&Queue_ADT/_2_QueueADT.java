//SC=O(N) due to creating an array
public class _2_QueueADT
{
	// Instance Variables (shared across all objects)
	private int[] queueArray;
	private int currentSize;
	private int queueSize;
	private int frontOfQueue;
	private int backOfQueue;


	// constructor
	public _2_QueueADT(int size)
	{
		System.out.println("Object Creation occurs...");
		queueSize = size;
		currentSize = 0;
		frontOfQueue = 0;
		backOfQueue = queueSize - 1; // index
		queueArray = new int[queueSize];
	}

	// insertBack is enque
	//TC=O(1) due to having the back pointer
	public void insertAtBack(int data)
	{
		if (!isQueueFull())
		{
			System.out.println("Added to the back:" + data);
			backOfQueue = (backOfQueue + 1) % queueSize; // shift back pointer from 0 to size-1
			queueArray[backOfQueue] = data;
			currentSize++;
		} else
		{
			System.out.println("Queue is full");
		}
	}

	// deleteFront is deque
	//TC=O(1) due to having the front pointer
	public void deleteFromFront()
	{
		if (!isQueueEmpty())
		{
			int frontElement = queueArray[frontOfQueue];
			System.out.println("Removed from the front:" + frontElement);
			frontOfQueue = (frontOfQueue + 1) % queueSize; // shift front pointer from size-1 to 0
			currentSize--;
		} else
		{
			System.out.println("Queue is empty");
		}
	}

	public void front()
	{
		if (!isQueueEmpty())
		{
			System.out.println("front element:" + queueArray[frontOfQueue]);
		}
	}

	public void back()
	{
		if (!isQueueFull())
		{
			System.out.println("back element:" + queueArray[backOfQueue]);
		}
	}

	public boolean isQueueFull()
	{
		return (currentSize == queueSize);
	}

	public boolean isQueueEmpty()
	{
		return (currentSize == 0);
	}

	public static void main(String[] args)
	{
		// creating the queue
		int size = 5;
		_2_QueueADT queue = new _2_QueueADT(size);

		// populating the queue
		queue.insertAtBack(1);
		queue.front();
		queue.back();
		queue.insertAtBack(2);
		queue.front();
		queue.back();
		queue.insertAtBack(3);
		queue.insertAtBack(4);
		queue.insertAtBack(5);
		queue.insertAtBack(6); // queue is full

		// iterating the queue
		while (!queue.isQueueEmpty())
		{
			queue.deleteFromFront();
		}

		queue.deleteFromFront();

	}

}
