
public class _23_ImplementACircularQueue
{
	int front, rear;
	int array[];
	int queueSize;

	_23_ImplementACircularQueue(int size)
	{
		queueSize = size;
		array = new int[queueSize];
		front = -1;
		rear = -1;
	}

	// Check if the queue is full
	boolean isFull()
	{
		if (front == 0 && rear == queueSize - 1)
		{
			return true;
		}
		if (front == rear + 1)
		{
			return true;
		}
		return false;
	}

	// Check if the queue is empty
	boolean isEmpty()
	{
		if (front == -1)
			return true;
		else
			return false;
	}

	// Adding an element
	void addFromTheBack(int element)
	{
		if (isFull())
		{
			System.out.println("Queue is full");
		} else
		{
			if (front == -1)
				front = 0;
			rear = (rear + 1) % queueSize;
			array[rear] = element;
			System.out.println("Inserted " + element);
		}
	}

	// Removing an element
	int removeFromTheFront()
	{
		int element;
		if (isEmpty())
		{
			System.out.println("Queue is empty");
			return (-1);
		} else
		{
			element = array[front];
			if (front == rear)
			{
				front = -1;
				rear = -1;
			} /* Q has only one element, so we reset the queue after deleting it. */
			else
			{
				front = (front + 1) % queueSize;
			}
			return (element);
		}
	}

	void printCircularQueue()
	{
		/* Function to display status of Circular Queue */
		int i;
		if (isEmpty())
		{
			System.out.println("Empty Queue");
		} else
		{
			System.out.println("Front:" + front);
			System.out.print("Queue: ");
			for (i = front; i != rear; i = (i + 1) % queueSize)
				System.out.print(array[i] + " ");
			System.out.println(array[i]);
			System.out.println("Rear:" + rear);
		}
	}

	public static void main(String[] args)
	{
		_23_ImplementACircularQueue q = new _23_ImplementACircularQueue(2);

		q.removeFromTheFront();

		q.addFromTheBack(1);
		q.addFromTheBack(2);
		q.addFromTheBack(6);

		int front = q.removeFromTheFront();

		if (front != -1)
		{
			System.out.println("Deleted Element is " + front);
		}

		q.addFromTheBack(7);
		q.addFromTheBack(8);
		System.out.println();
		
		q.printCircularQueue();

	}

}