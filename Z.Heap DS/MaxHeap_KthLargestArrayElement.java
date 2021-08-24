import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeap_KthLargestArrayElement
{
	public static void main(String[] args)
	{
		int[] array = { 7, 5, 76, 2, 4 };
		usingTheBuiltInSortingAlgorithm(array);
		bruteForce_searchingForKthLargestElementInASortedArray(array, 2);
		bruteForce_searchingForKthSmallestElementInASortedArray(array, 2);
		best_MaxHeap_KthLargestArrayElement(array, 2);
		best_MinHeap_KthSmallestArrayElement(array, 2);
	}

	// TC= O(N*log N) due to using built in sorting algorithm
	// SC=O(1) due to not creating any extra data structure
	public static void bruteForce_searchingForKthLargestElementInASortedArray(int[] array, int K)
	{
		System.out.println("\n------Searching for Kth Largest Array in a Sorted Array ------");
		// print the kth largest element
		// 1st Kth Largest Element is the max Element at the end of array
		int lastIndex = array.length - 1;
		int kthLargestElement = array[array.length - 1]; // assumption

		for (int i = lastIndex; i >= lastIndex - K + 1; i--)
		{
			System.out.println("Kth Largest: " + kthLargestElement + ", current Element: " + array[i]);
			kthLargestElement = Math.min(kthLargestElement, array[i]);
			System.out.println("Kth Largest: " + kthLargestElement + ", current Element: " + array[i]);
		}
		System.out.println(K + "th Largest Element=" + kthLargestElement);
	}

	// TC= O(N*log N) due to using built in sorting algorithm
	// SC=O(1) due to not creating any extra data structure
	public static void bruteForce_searchingForKthSmallestElementInASortedArray(int[] array, int K)
	{
		// print the kth smallest element
		// 1st Kth Smallest Element is the min Element at the start of array
		System.out.println("\n------Searching for Kth Smallest Array in a Sorted Array ------");
		int firstIndex = 0;
		int kthSmallestElement = array[0];

		for (int i = firstIndex; i <= K - 1; i++)
		{
			System.out.println("Kth Smallest: " + kthSmallestElement + ", current Element: " + array[i]);
			kthSmallestElement = Math.max(kthSmallestElement, array[i]);
			System.out.println("Kth Smallest: " + kthSmallestElement + ", current Element: " + array[i]);
		}
		System.out.println(K + "th Smallest Element=" + kthSmallestElement);
	}

	// TC= O(N + K *log N)
	public static void best_MaxHeap_KthLargestArrayElement(int[] unsortedArray, int k)
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

	// TC= O(N + K *log N)
	public static void best_MinHeap_KthSmallestArrayElement(int[] unsortedArray, int k)
	{
		// 1.creating minHeap (popping K elements off means finding Kth Smallest)
		PriorityQueue<Integer> minHeapAPI = new PriorityQueue<>();

		// 2.transfering the data from the array into minHeap
		for (int i = 0; i <= unsortedArray.length - 1; i++)
		{
			minHeapAPI.add(unsortedArray[i]);
		}

		int popFrequency = 0;
		int kthSmallestElement = 0; // assumption

		System.out.println("\n------Using MinHeap to find the " + k + "th Smallest Element ------"); // space
		while (popFrequency < k)
		{
			System.out.println("Current MinHeapAPI(stored in array): " + minHeapAPI);
			int poppedElement = minHeapAPI.poll();
			kthSmallestElement = poppedElement;
			popFrequency++;
		}
		System.out.println(k + "th Smallest Element=" + kthSmallestElement);
	}

	// --Helper function(Applies to brute force searching sorted array only--//
	// TC= O(N*log N) due to using built in sorting algorithm
	public static void usingTheBuiltInSortingAlgorithm(int[] array)
	{
		// Sorting the array means TC=O(N log N)
		System.out.println("Sorting the array using a built in sorting algorithm------");
		System.out.println("Unsorted Array: " + Arrays.toString(array));
		Arrays.sort(array);
		System.out.println("Sorted Array: " + Arrays.toString(array));
	}
}
