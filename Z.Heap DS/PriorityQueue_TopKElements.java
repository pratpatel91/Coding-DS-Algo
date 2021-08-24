import java.util.PriorityQueue;

public class PriorityQueue_TopKElements
{
	public static void main(String[] args)
	{
		int[] array = { 1, 2, 3, 4, 5 };
		getKthElementUsingHeaps(array, 2);
	}

	// TC=O(N log K)
	// SC=O(K) heap is only storing top K elements
	public static void getKthElementUsingHeaps(int[] array, int topKElementsIndex)
	{
		// 1.We create an empty priority queue
		PriorityQueue<Integer> minHeapAPI = new PriorityQueue<Integer>();

		// 2.We iterate the array
		for (int i = 0; i <= array.length - 1; i++)
		{
			// 2.1 while iterating the array we store the arrays data into the priority
			// queue
			minHeapAPI.add(array[i]);
		}
		System.out.println(minHeapAPI);

		// 3.We iterate the array
		for (int i = 0; i < topKElementsIndex; i++)
		{
			// we keep on popping elemnts off of the stack until we get to the kth element
			if (minHeapAPI.size() > topKElementsIndex)
			{
				minHeapAPI.poll();
			}
			System.out.println(minHeapAPI); // the minHeap will converge to display top K Elements
		}

	}
}
