public class mergeSortAlgorithm
{
	public static void main(String args[])
	{
		int arr[] = { 9,3,7,5,6,8,4,2 };
		recursive_SortingSubArrays(arr, 0, arr.length - 1);
	}
	
	// TC=O(N*logN) SC = O(N)     
	// Divide the array into two subarrays, sorting them and then merging them
	public static void recursive_SortingSubArrays(int array[], int start, int end)
	{		
		System.out.println("Recursive Sorting...");
		if (start < end)
		{
			// m is the point where the array is divided into two subarrays
			int mid = (start + end) / 2;
			
			// TC=O(logN)
			recursive_SortingSubArrays(array, start, mid);  // sort the left sub array
			recursive_SortingSubArrays(array, mid + 1, end); // sort the right sub array

			iterative_MergingSubArrays(array, start, mid, end);  // merge both the sorted subarrays
		}
	}

	// Merge two subarrays L and M into arr
	public static void iterative_MergingSubArrays(int array[], int start, int mid, int end)
	{		
		System.out.println("Iterative Merging...");
		// creating empty subarrays
		int leftSubArray[] = new int[mid - start + 1];
		int rightSubArray[] = new int[end - mid];
		
		// populating the empty subarray using the original arrays elements
		for (int i = 0; i < (mid - start + 1); i++)
		{
			leftSubArray[i] = array[start + i];
		}
		
		// populating the empty subarray using the original arrays elements
		for (int j = 0; j < (end - mid); j++)
		{
			rightSubArray[j] = array[mid + 1 + j];
		}

		// merging the subarrays to form a combined array
		int i = 0, j = 0, k = start;

		// Until we reach either end of either L or M, pick larger among
		// elements L and M and place them in the correct position at A[p..r]
		while (i < mid - start + 1 && j < end - mid)
		{
			System.out.print("\nstarting from i:" + i + ", j:" + j + ", k:" + k + " ");
			if (leftSubArray[i] <= rightSubArray[j])
			{
				array[k] = leftSubArray[i];// storing smaller in the array
				i++;
			} else
			{
				array[k] = rightSubArray[j]; // storing smaller in the array
				j++;
			}
			k++;
		}
		
		// copying the remaining elements from left sub array into the array
		System.out.println("\n....restarting from i=" + i);
		for ( ; i < (mid - start + 1);i++)
		{
			array[k] = leftSubArray[i];
			k++;
		}
		
		// copying the remaining elements from left sub array into the array
		System.out.println("\n....restarting from j=" + j);
		for ( ; j < (end - mid);j++)
		{
			array[k] = rightSubArray[j];
			k++;
			
		}

		printArray(array);
	}

	public static void printArray(int array[])
	{
		for (int i = 0; i <= array.length - 1; i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}