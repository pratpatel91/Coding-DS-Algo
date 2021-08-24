import java.util.Arrays;

public class MinHeapSort
{
	//TC=O(N) + (N-1)*O(log N) = O(N * log N)
	public static void minHeapSort(int heapArray[])
	{
		int size = heapArray.length;

		// Build max heap is a O(N) process
		for (int i = size / 2 - 1; i >= 0; i--)
		{
			downHeapify(heapArray, size, i);
		}

		/// one by one extract an element from heap
		for (int i = size - 1; i >= 0; i--)
		{
			// swap(arr[i], arr[largest]);
			//move current root to end
			int temp = heapArray[0];
			heapArray[0] = heapArray[i];
			heapArray[i] = temp;

			//recursively heapify the reduced heap
			downHeapify(heapArray, i, 0);
		}
	}

	public static void downHeapify(int heapArray[], int size, int parent)
	{
		// Find largest among root, left child and right child
		int max = parent;
		int leftChild = 2 * parent + 1;
		int rightChild = 2 * parent + 2;
		
		if (leftChild < size && heapArray[leftChild] > heapArray[max])
		{
			max = leftChild;
		}
		if (rightChild < size && heapArray[rightChild] > heapArray[max])
		{
			max = rightChild;
		}
		// if parent isnt max
		if (parent != max)
		{
			//swap(arr[parent], arr[max]);
			int swap = heapArray[parent];
			heapArray[parent] = heapArray[max];
			heapArray[max] = swap;
			
			// recursively heapify the affected sub-tree
			downHeapify(heapArray, size, max);
		}
	}

	public static void main(String args[])
	{
		int array[] = { 1, 12, 9, 5, 6, 10 };
		System.out.println("Unsorted Array: " + Arrays.toString(array));
		minHeapSort(array);
		System.out.println("Min Heap Sorted Array: " + Arrays.toString(array));
	}
}
