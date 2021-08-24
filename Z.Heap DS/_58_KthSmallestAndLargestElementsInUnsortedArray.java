import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class _58_KthSmallestAndLargestElementsInUnsortedArray
{
	public static void main(String[] args)
	{
		int[] array = { 7, 10, 4, 3, 20, 15 };
		bruteForce_kthLargestElementInUnsortedArray(array, 3);
		best_MaxHeap_KthLargestElementInUnsortedArray(array, 3);
	}

	// TC= O(N*log N) due to using built in sorting algorithm
	// SC=O(1) due to not creating any extra data structure
	public static void bruteForce_kthLargestElementInUnsortedArray(int[] array, int K)
	{
		// using a built in sorting algorithm means TC=O(N log N)
		System.out.println("Unsorted Array: " + Arrays.toString(array));
		Arrays.sort(array);
		System.out.println("Sorted Array: " + Arrays.toString(array));

		// Next we search for the Kth Largest Array in the Sorted Array

		int kthLargestElement = array[array.length - 1]; // assumption

		for (int i = array.length - 1; i >= array.length - 1 - K + 1; i--)
		{
			System.out.println("Kth Largest: " + kthLargestElement + ", current Element: " + array[i]);
			kthLargestElement = Math.min(kthLargestElement, array[i]);
			System.out.println("Kth Largest: " + kthLargestElement + ", current Element: " + array[i]);
		}
		System.out.println(K + "th Largest Element=" + kthLargestElement);
	}

	// TC= O(N + K *log N)
	// SC=O(K) due to storing k elements in a maxHeap
	public static void best_MaxHeap_KthLargestElementInUnsortedArray(int[] unsortedArray, int k)
	{
		// 1.creating maxHeap (popping K elements off means finding Kth Largest)
		PriorityQueue<Integer> maxHeapAPI = new PriorityQueue<Integer>(Collections.reverseOrder());

		// 2.transfering the data from the array into maxHeap
		for (int i = 0; i <= unsortedArray.length - 1; i++)
		{
			maxHeapAPI.add(unsortedArray[i]);
		}

		int popFrequency = 0;
		int kthLargestElement = 0; // assumption

		System.out.println("\n------Using MaxHeap to find the " + k + "th Largest Element ------"); // space
		while (popFrequency < k)
		{
			System.out.println("Current MaxHeapAPI(stored in array): " + maxHeapAPI);
			int poppedElement = maxHeapAPI.poll();
			kthLargestElement = poppedElement;
			popFrequency++;
		}
		System.out.println(k + "th Largest Element=" + kthLargestElement);
	}

}
