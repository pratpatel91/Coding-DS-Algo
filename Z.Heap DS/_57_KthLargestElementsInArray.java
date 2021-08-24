import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class _57_KthLargestElementsInArray
{
	public static void main(String[] args)
	{
		int[] array = { 12, 5, 787, 1, 23 };
		int k = 2;
		bruteForce_kthLargestArrayElement(array, k);
		best_MaxHeap_KthLargestArrayElement(array, k);
	}

	// TC= O(N*log N) due to using built in sorting algorithm
	// SC=O(1) due to not creating any extra data structure
	public static void bruteForce_kthLargestArrayElement(int[] array, int K)
	{
		System.out.println("\n------Searching for Kth Largest Array in a Sorted Array ------");
		System.out.println(Arrays.toString(array));
		//1.sort the array
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		
		int kLargestElement = 0;
		int kCounter=0;

		//2.sorted array means end of array is k=1 largest element
		//sorted array means front of array is k=1 smallest element
		for (int i = array.length - 1; i >=K; i--)
		{
			if(kCounter==K)
			{
				break;
			}
			kLargestElement = array[i];
			System.out.println(K + "th Largest Element=" + kLargestElement);
			kCounter++;
		}
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
}
