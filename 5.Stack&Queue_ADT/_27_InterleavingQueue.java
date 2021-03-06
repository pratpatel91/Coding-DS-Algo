import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _27_InterleavingQueue
{
	// Corner cases : adding when its full & removing when its empty
	static Queue<Integer> q = new LinkedList<>();
	static Stack<Integer> s = new Stack<>();

	public static void main(String[] args)
	{
		int[] input =
		{ 1, 2, 3, 4, 5, 6 };// MUST HAVE EVEN SIZE FOR INTERLEAVING
		populateQueue(input); // due to being a global variable we not need to assign it back into a variable
		printQueue();
		interleavingQueues();
		printQueue();
	}

	public static void interleavingQueues()
	{
		int half = q.size() / 2;

		// s= {} q={1,2,3,4,5,6}
		for (int i = 1; i <= half; i++)
		{
			s.push(q.peek()); // pushing all the queue elements onto the stack
			q.poll();
		}

		// s= {(bottom)1,2,3(top)} q={4,5,6}
		while (!s.isEmpty())
		{
			q.add(s.peek()); // pushing all the stack elements onto the queue
			s.pop();
		}

		// s= {} q={4,5,6,3,2,1}
		for (int i = 1; i <= half; i++)
		{
			q.add(q.peek());
			q.poll();
		}
		// s= {} q={3,2,1,4,5,6}
		
		for (int i = 1; i <= half; i++)
		{
			s.push(q.peek()); // pushing all the queue elements onto the stack
			q.poll();
		}
		
		//analagous to 2 seperate arrays
		// s= {3,2,1} q={4,5,6}
		// answer = {1,4,2,5,3,6}
		while (!s.isEmpty())
		{
			q.add(s.peek()); // pushing all the stack elements onto the queue
			s.pop();
			q.add(q.peek());
			q.poll();
		}
		// s= {} q={1,4,2,5,3,6}		
	}

	public static void populateQueue(int[] input)
	{
		for (int i = 0; i <= input.length - 1; i++)
		{
			int currentElement = input[i];
			q.add(currentElement);
		}

		printQueue();
	}

	public static void printQueue()
	{
		// Iterator is analagous to a for loop for predefined classes
		Iterator<Integer> queue = q.iterator();

		// stops when it faces a null pointer O(N)
		while (queue.hasNext())
		{
			System.out.print(queue.next() + " ");
		}
		System.out.println();
	}
}
