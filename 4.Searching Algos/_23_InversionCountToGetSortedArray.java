import java.util.Arrays;

public class _23_InversionCountToGetSortedArray
{

	public static void main(String[] args)
	{
		int[] array = { 9, 3, 7, 5, 6, 4, 8, 2 };
		// bruteForce_InversionCountToSortArray(array);
		System.out.println("Inv Count:" + mergeSort(array, 0, array.length - 1));
	}

	public static void bruteForce_InversionCountToSortArray(int[] array)
	{
		int inversionCount = 0;

		for (int i = 0; i <= array.length - 1; i++)
		{
			for (int j = i + 1; j <= array.length - 1; j++)
			{
				int currentElement = array[i];
				int nextElement = array[j];

				System.out.println("i,j:" + i + "," + j);
				// currentElement < nextElement means sorted
				// currentElement > nextElement means unsorted
				if (currentElement > nextElement)
				{
					inversionCount++;
				}
			}
		}
		System.out.println(inversionCount);
	}

	// TC=O(n*logn) SC=O(n) due to creating an aux array
	public static int mergeSort(int[] array, int start, int end)
	{
		// BASE CASE
		if (start >= end)
		{
			return 0; // single element is always sorted
		}

		int mid = (start + end) / 2;

		// array partioning logic
		int invLeft = mergeSort(array, start, mid); // RECURSIVE CALL
		int invRight = mergeSort(array, mid + 1, end); // RECURSIVE CALL
		int invAll = mergeTheTwoSortedArrays(array, start, end); // NOT RECURSIVE

		return (invLeft + invRight + invAll);
	}

	public static int mergeTheTwoSortedArrays(int[] array, int start, int end)
	{
		int mid = (start + end) / 2;

		// populating array [0-mid]
		int i = start;
		int j = mid + 1;
		int k = start;
		int invCount = 0; // denotes elements greater on the left size
		int[] temp = new int[1000]; // due to recursion so have to handle the dynamic growth/shrinkage of the array
									// size

		while (i <= mid && j <= end)
		{
			// comparing two halves
			if (array[j] >= array[i])
			{
				temp[k] = array[i]; // storing smaller element into temp
				k++;
				i++;
			} else
			{
				invCount += mid - i + 1; // counts all the elements greater on the left side
				temp[k] = array[j]; // storing smaller element into temp
				k++;
				j++;
			}
		}

		while (i <= mid) // 123(stores this) 456
		{
			temp[k] = array[i]; // storing smaller element into temp
			k++;
			i++;
		}

		while (j <= end) // 123 456(stores this)
		{
			invCount += mid - i + 1; // counts all the elements greater on the left side
			temp[k] = array[j]; // storing smaller element into temp
			k++;
			j++;
		}

		// overwriting the original array with the temp array
		for (int l = start; l <= end; l++)
		{
			array[l] = temp[l];
		}
		System.out.println("");

		// printing the array
		for (int l = start; l <= end; l++)
		{
			System.out.print(array[l] + " ");
		}
		System.out.println("");

		return invCount;
	}

}
