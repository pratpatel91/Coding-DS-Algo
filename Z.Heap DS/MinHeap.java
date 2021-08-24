import java.util.Arrays;

//Priority Heap Collection specifies min or max heap
public class MinHeap
{
	public static void main(String[] args)
	{
		int[] heapArray = { 10, 30, 20, 35 };
		System.out.println("Array: " + Arrays.toString(heapArray));
		heapSort(heapArray);
	}
	//TC=O(log N)
	public static void heapSort(int[] heapArray)
	{
		int arrayMin = heapArray.length;
		// heapifying parent and child only
		for (int parent = heapArray.length / 2 - 1; parent >= 0; parent--)
		{
			minHeap(heapArray, parent, heapArray.length);
		}

		// heapifying the remaining tree (excluding parent)
		for (int i = heapArray.length - 1; i > 0; i--)
		{
			// swapping first and last elements
			int firstelement = heapArray[0];
			heapArray[0] = heapArray[i];
			heapArray[i] = firstelement;
			minHeap(heapArray, 0, i);
			System.out.println("Array: " + Arrays.toString(heapArray));
		}
	}

	public static void minHeap(int[] heapArray, int parentIndex, int length)
	{
		int leftChildsIndex = 2 * parentIndex + 1;
		int rightChildsIndex = 2 * parentIndex + 2;

		int parentElement = heapArray[parentIndex];
		int smallestIndex = parentIndex;

		//if statement for handling index out of bounds
		int leftElement = Integer.MAX_VALUE;
		int rightElement = Integer.MAX_VALUE;
		if (leftChildsIndex < length)
		{
			leftElement = heapArray[leftChildsIndex];
		}
		if (rightChildsIndex < length)
		{
			rightElement = heapArray[rightChildsIndex];
		}

		if (leftElement != Integer.MAX_VALUE && parentElement < leftElement)
		{
			smallestIndex = leftChildsIndex;
		}
		if (rightElement != Integer.MAX_VALUE && heapArray[smallestIndex] < rightElement)
		{
			smallestIndex = rightChildsIndex;
		}

		if (parentIndex != smallestIndex)
		{
			//swap parent with smallest value for min heap
			heapArray[parentIndex] = heapArray[smallestIndex];
			heapArray[smallestIndex] = parentElement;
			minHeap(heapArray, smallestIndex, length);
		}
	}
}
