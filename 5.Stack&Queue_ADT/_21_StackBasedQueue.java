import java.util.Stack;

public class _21_StackBasedQueue
{
	// Implement queue using two stacks
	Stack<Integer> s1, s2;

	// Constructor reflects a stack based queue
	// SC_OVERALL=O(N) due to creating a stack
	public _21_StackBasedQueue()
	{
		s1 = new Stack<>();
		s2 = new Stack<>();
	}
	
	//TC_INSERT=O(N)
	void insertAtBack(Integer data)
	{
		// 1st, moving all elements from s1 to s2
		while (!s1.isEmpty())
		{
			Integer s1_top = s1.peek(); // getting the top element of s1
			s2.push(s1_top); // adding s1 to s2
			s1.pop(); // updating the top pointer
		}

		// 2nd, populate s1
		s1.push(data);

		// 3rd, moving all elements from s2 back to s1
		while (!s2.isEmpty())
		{
			Integer s2_top = s2.peek();// getting the top element of sw
			s1.push(s2_top); // adding s2 to s1
			s2.pop(); // updating the top pointer
		}
	}
	
	//TC_DELETE=O(1)
	public void removeFromFront()
	{
		// edge case (checking to see if the stack is empty)
		if (s1.isEmpty())
		{
			System.out.println("cant remove element from empty queue");
		} else // 4th removed s1 elements resemble the queue here
		{
			Integer s1_top_queue = s1.peek(); // getting the top element
			s1.pop(); // update the top pointer
			System.out.print(s1_top_queue + " "); // queue printout
		}
	}

	public static void main(String[] args)
	{
		int[] array = { 1, 2, 3 };

		// creating the queue
		_21_StackBasedQueue queue = new _21_StackBasedQueue();

		// populating the queue
		for (int i = 0; i <= array.length - 1; i++)
		{
			queue.insertAtBack(array[i]);
		}

		//printing the queue
		for (int i = 0; i <= array.length; i++)
		{
			queue.removeFromFront();
		}
	}
}