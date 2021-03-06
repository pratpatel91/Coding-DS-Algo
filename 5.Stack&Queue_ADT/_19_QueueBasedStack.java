import java.util.LinkedList;
import java.util.Queue;

public class _19_QueueBasedStack
{
	// Implement stack using two queues
	Queue<Integer> q1, q2;

	// Constructor reflects a queue based stack
	// SC_OVERALL=O(N) due to creating a stack
	public _19_QueueBasedStack()
	{
		q1 = new LinkedList<>();
		q2 = new LinkedList<>();
	}

	//TC_INSERT=O(N)
	void pushOnTop(Integer data)
	{	
		// 1st, moving all elements from q1 to q2
		while (!q1.isEmpty())
		{
			Integer q1_front=q1.peek(); //getting the front element of q1
			q2.add(q1_front); //adding q1 to q2
			q1.poll();  // update the front pointer
		}
		
		//2nd, populate q1
		q1.add(data);
		
		//3rd, moving all elements from q2 back to q1
		while (!q2.isEmpty())
		{
			Integer q2_front=q2.peek(); //getting the front element of q2
			q1.add(q2_front); //adding q2 to q1
			q2.poll();  // update the front pointer
		}
	}
	
	//TC_DELETE=O(1)
	public void removeFromTop()
	{
		//edge case (checking to see if the queue is empty)
		if (q1.isEmpty())
		{
			System.out.println("Underflow!!");
		}
		else //4th removed q1 elements resemble the stack here
		{
		Integer q1_front_stack = q1.peek(); //get the front element
		q1.poll(); // update the front pointer
		System.out.println(q1_front_stack); //stack printout
		}
	}
	
	public static void main(String[] args)
	{
		int[] array = { 1, 2, 3 };

		// creating the stack
		_19_QueueBasedStack stack = new _19_QueueBasedStack();

		// populating the stack
		for (int i = 0; i <= array.length - 1; i++)
		{
			stack.pushOnTop(array[i]);
		}
		
		// printing the stack
		for (int i = 0; i <= array.length; i++)
		{
			stack.removeFromTop();
		}
	}
}