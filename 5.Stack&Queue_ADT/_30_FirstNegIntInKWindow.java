import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class _30_FirstNegIntInKWindow
{
	static Deque<Integer> dq = new LinkedList<>();

	public static void main(String[] args)
	{
		int[] array =
		{ 12, -1, -7, 8, -15, 30, 16 };
		int windowSize = 3;
		firstNegIntSequence(array, windowSize);
	}

	//SLIDING WINDOW ALGORITHM
	public static void firstNegIntSequence(int[] array, int windowSize)
	{
		int i;

		// 1st inserted all the neg K Elements
		for (i = 0; i <= windowSize - 1; i++)
		{
			// adding neg elements to the deque
			if (array[i] < 0)
			{
				dq.add(i);// adding from the back
			}
		}

		//not resetting i (continuation)
		// (; i <= array.length - 1; i++)
		// (i=windowSize; i <= array.length - 1; i++)
		for (i=windowSize; i <= array.length - 1; i++)
		{
			if (!dq.isEmpty())
			{
				int frontElement = dq.peek();
				System.out.println("frontElement: " + array[frontElement]);
			} else
			{
				System.out.println("no neg elements in the current window");
			}

			// removing elements not present in current window
			while (!dq.isEmpty() && dq.peek() < (i - windowSize + 1))
			{
				int frontElement = dq.peek();
				System.out.println("removing element not in current window: " + array[frontElement]);
				dq.remove(); //assumed that the peek is removed
			}
			
			if(array[i]<0)
			{
				dq.add(i);// adding from the back
			}
		}
		
		//checking the last window
		if (!dq.isEmpty())
		{
			int frontElement = dq.peek();
			System.out.println("frontElement: " + array[frontElement]);
		} else
		{
			System.out.println("no neg elements in the current window");
		}
		

	}

}
