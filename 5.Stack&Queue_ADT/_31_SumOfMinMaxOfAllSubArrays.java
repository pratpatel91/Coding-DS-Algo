import java.util.Deque;
import java.util.LinkedList;

public class _31_SumOfMinMaxOfAllSubArrays
{
	static Deque<Integer> dqMin = new LinkedList<Integer>();
	static Deque<Integer> dqMax = new LinkedList<Integer>();

	public static void main(String[] args)
	{
		int[] array = { 2, 5, -1, 7, -3, -1, -2 };
		int windowSize = 4;
		System.out.println(minMaxSumOfAllSubArrays(array, windowSize));
	}

	//TC=O(N) doe to a single for loop
	//SC=O(1) due to the two deques storing 1 value at a time
	public static int minMaxSumOfAllSubArrays(int[] array, int windowSize)
	{
		// Sliding Window Problem
		// 1st, we want to process the 1st window size

		for (int i = 0; i < windowSize; i++) // i=1 to i<=windowSize
		{
			// array[dqMin.peek()] dq is only storing indicies not actual min or max
			while (!dqMin.isEmpty() && array[dqMin.peekLast()] > array[i])
			{
				dqMin.removeLast();

			}
			dqMin.addLast(i); // adding index

			while (!dqMax.isEmpty() && array[dqMax.peekLast()] < array[i])
			{
				dqMax.removeLast();

			}
			dqMax.addLast(i); // adding index
			
			//printing the window elements
//			System.out.print(array[i] +" ");
		}
		System.out.println();
		System.out.println("currMin:" + array[dqMin.peek()] + ",currMax:" + array[dqMax.peek()]);

		// 2nd, we slide the window till end of the array
		int minMaxSum = 0;

		for (int i = windowSize; i <= array.length - 1; i++)
		{
			//printing the window elements
//			for(int j=i-windowSize+1; j<=i;j++)
//			{
//				System.out.print(array[j] +" ");
//			}
//			System.out.println();
			
			// minMax per each window
			minMaxSum += array[dqMin.peek()] + array[dqMax.peek()];

			// removing elements not in the current window
			while (!dqMin.isEmpty() && dqMin.peekLast() <= i - windowSize)
			{
				dqMin.removeLast();
			}

			while (!dqMax.isEmpty() && dqMax.peekLast() <= i - windowSize)
			{
				dqMax.removeLast();
			}

			// array[dqMin.peek()] dq is only storing indicies not actual min or max
			while (!dqMin.isEmpty() && array[dqMin.peekLast()] > array[i])
			{
				dqMin.removeLast();
			}
			dqMin.addLast(i); // adding index

			while (!dqMax.isEmpty() && array[dqMax.peekLast()] < array[i])
			{
				dqMax.removeLast();
			}
			dqMax.addLast(i); // adding index
			
			System.out.println("currMin:" + array[dqMin.peek()] + ",currMax:" + array[dqMax.peek()]);
		}

		// answer for the last window
		minMaxSum += array[dqMin.peek()] + array[dqMax.peek()];

		return minMaxSum;
	}

}
