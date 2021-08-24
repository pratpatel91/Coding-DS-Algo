import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class _60_MergeTwoBinaryMaxHeaps
{
	public static void main(String[] args)
	{
		int[] unsortedArray1 = { 10, 5, 6, 2 };
		int[] unsortedArray2 = { 12, 7, 9 };

		// ------------------------TC=O(N) SC= O(N+M) -------//
		PriorityQueue<Integer> maxHeapAPI = new PriorityQueue<Integer>(Collections.reverseOrder());
		int[] resultingUnsortedArray = storingUnsortedArraysIntoAResultingUnsortedArray(unsortedArray1, unsortedArray2);
		usingArrayDataToBuildAHeap(resultingUnsortedArray, maxHeapAPI);

	}

	// TC=O(N)
	// SC=O(N+M)
	public static int[] storingUnsortedArraysIntoAResultingUnsortedArray(int[] unsortedArray1, int[] unsortedArray2)
	{
		int[] resultingUnsortedArray = new int[unsortedArray1.length + unsortedArray2.length];
		int resultingPointer = 0;
		System.out.println("\n" + Arrays.toString(resultingUnsortedArray));
		System.out.println("resultingpointer:" + resultingPointer);

		// TC=O(N) for transfering one arrays data into another array
		for (int i = 0; i < unsortedArray1.length; i++)
		{
			resultingUnsortedArray[resultingPointer] = unsortedArray1[i];
			resultingPointer++;
		}
		System.out.println("\n" + Arrays.toString(resultingUnsortedArray));
		System.out.println("resultingpointer:" + (resultingPointer - 1));
		System.out.println("Last Element: " + resultingUnsortedArray[resultingPointer - 1]);

		// TC=O(N) for transfering one arrays data into another array
		for (int i = 0; i < unsortedArray2.length; i++)
		{
			resultingUnsortedArray[resultingPointer] = unsortedArray2[i];
			resultingPointer++;
		}
		System.out.println("\n" + Arrays.toString(resultingUnsortedArray));
		resultingPointer--;
		System.out.println("resultingpointer:" + resultingPointer);
		System.out.println("Last Element: " + resultingUnsortedArray[resultingPointer]);
		return resultingUnsortedArray;
	}

	// TC=O(N) storing arrays data to build a heap
	public static void usingArrayDataToBuildAHeap(int[] resultingUnsortedArray, PriorityQueue<Integer> maxHeapAPI)
	{
		System.out.println("Empty Max Heap: "+ maxHeapAPI);

		// TC=O(N) for building the heap
		for (int i = 0; i <= resultingUnsortedArray.length - 1; i++)
		{
			maxHeapAPI.add(resultingUnsortedArray[i]);// SC!=O(N) since array1 is given
		}
		System.out.println("Populated Max Heap:"+ maxHeapAPI);
	}
}
