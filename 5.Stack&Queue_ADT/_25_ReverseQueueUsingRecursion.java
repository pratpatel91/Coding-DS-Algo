import java.util.LinkedList;
import java.util.Queue;

public class _25_ReverseQueueUsingRecursion
{
	static Queue<Integer> queue;

	static void printQueue()
	{
		while (!queue.isEmpty())
		{
			System.out.print(queue.peek() + " ");
			queue.remove();
		}
	}

	static Queue<Integer> reverseQueue(Queue<Integer> q)
	{
		if (q.isEmpty())
		{
			return q;
		}

		int front = q.peek();
		q.remove();

		q = reverseQueue(q); //RECURSION

		q.add(front);

		return q;
	}

	public static void main(String args[])
	{
		queue = new LinkedList<Integer>();
		queue.add(56);
		queue.add(27); // 56,27
		queue = reverseQueue(queue) ;// 27,56
		printQueue();
	}
}