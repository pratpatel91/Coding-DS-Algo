                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               import java.util.Arrays;

public class _13_MergeTwoSortedArrays
{
	public static void main(String[] args)
	{
		int[] a = { 1,2,3 };
		int[] b = { 4,5,6};
		// mergeTwoSortedArrays(a, b);
		// OptimizedWorstCase(a, b);
		OptimizedBestCases(a, b);
	}

	public static void printArray(int[] array)
	{
		System.out.println("\n");
		for (int i = 0; i <= array.length - 1; i++)
		{
			System.out.print(array[i] + " ");
		}
	}

	public static int max(int a, int b)
	{
		if (a > b)
		{
			return a;
		}
		return b;
	}

	public static void swap(int[] a, int[] b, int i, int j)
	{
		// need to create an addition temp variables to swap values of a and b
		int temp = a[i];
		a[i] = b[j];
		b[j] = temp;
	}

	// 1.Worst Case TC=O(n^2) due to bubble sort SC=0(n+m)

	// 2.Best Case TC=O(n logn) due to quick or merge sort SC=0(n+m)
	public static void mergeTwoSortedArrays(int[] a, int[] b)
	{
		int combinedSize = a.length + b.length;
		int[] mergedArray = new int[combinedSize];

		// new variable was created in order to merge array b after array a contigously
		int IndexOfMergedArray = 0;

		// for loop to copy content of array a into the mergedArray
		for (int i = 0; i <= a.length - 1; i++)
		{
			mergedArray[IndexOfMergedArray] = a[i];
			IndexOfMergedArray++;
		}

		// for loop to copy content of array b after array a into the mergedArray
		for (int i = 0; i <= b.length - 1; i++)
		{
			mergedArray[IndexOfMergedArray] = b[i];
			IndexOfMergedArray++;
		}

		// printArray(mergedArray);
		Arrays.sort(mergedArray); // TC= O(n log n)
		printArray(mergedArray);
	}

	// 3.Optimized- Worst Case TC=O(n logn) quick or merge sort SC=0(1) in place
	// swapping so no aux array is needed
	public static void OptimizedWorstCase(int[] a, int[] b)
	{
		// for loop to compare elements from array a to array b in order to swap them
		int i = 0, j = 0;
		int sizeArray_A = a.length - 1;
		int sizeArray_B = b.length - 1;

		// use = to check for corner case of handling last index so we dont get a=1,2,6
		// b=3,4,5
		while (i <= sizeArray_A && j <= sizeArray_B)
		{
			if (a[i] > b[j]) // we want arrays b's first element to be greater than array a elements
			{
				swap(a, b, i, j);
				// printArray(a);
				// printArray(b);
				i++;
				// wont increment j as array b will contains elements larger than array a
				Arrays.sort(b);
			} else // handles infinite loop when the arrays a & b are sorted to begin with
			{
				j++;
			}
		}

		printArray(a);
		printArray(b);

	}

	// 4.Optimized- Best Case TC=O(n+m) in place swapping instead of sorting SC=0(1)
	// in place swapping so no aux array is needed
	public static void OptimizedBestCases(int[] a, int[] b)
	{
		// 1.Find max between array a and arrayb
		int globalMax = Integer.MIN_VALUE;

		for (int i = 0; i <= a.length - 1; i++)
		{
			globalMax = max(globalMax, a[i]); // globalMax relative to array a only
		}

		for (int i = 0; i <= b.length - 1; i++)
		{
			globalMax = max(globalMax, b[i]);// globalMax relative to both arrays a&b (6)
		}

		// Using the Modulus Operator b%a then max range =0...a-1
		globalMax++; // incrementing by 1 shifts [0-5] to be [1-6] so we retain the value of 6

		int i = 0, j = 0, k = 0;

		int combinedLength = a.length + b.length;

		while (i < a.length && j < b.length && k < combinedLength)
		{
			int currentA = a[i] % globalMax; // 4%7=4, 5%7=5, 6%7=6
			int currentB = b[j] % globalMax; // 1%7=1, 2%7=2, 3%7=3

			if (currentB >= currentA)
			{
				if (k < a.length)
				{
					a[k] += (currentA * globalMax);
				} else
				{
					b[k - a.length] += (currentA * globalMax);
				}

				i++;
				k++;
			} else // if(currentB <= currentA)
			{
				if (k < a.length)
				{
					a[k] += (currentB * globalMax);
				} else
				{
					b[k - a.length] += (currentB * globalMax);
				}

				j++;
				k++;
			}
		}

		System.out.println("Value of i:" + i);
		System.out.println("Value of j:" + j);

		// another while loop to handle corner cases
		while (i < a.length)
		{
			int currentA = a[i] % globalMax; // 4%7=4, 5%7=5, 6%7=6

			if (k < a.length)
			{
				a[k] += (currentA * globalMax);
			} else
			{
				b[k - a.length] += (currentA * globalMax);
			}

			i++;
			k++;
		}
		
		System.out.println("Value of i:" + i);
		System.out.println("Value of j:" + j);
		
		// another while loop to handle corner cases
		while (j < b.length)
		{
			int currentB = b[j] % globalMax; // 1%7=1, 2%7=2, 3%7=3

			if (k < b.length)
			{
				a[k] += (currentB * globalMax);
			} else
			{
				b[k - a.length] += (currentB * globalMax);
			}

			j++;
			k++;
		}

		// displaying arrays
		for (i = 0; i < a.length; i++)
		{
			System.out.print(a[i] / globalMax + " "); // getting original value back via division
		}

		for (i = 0; i < b.length; i++)
		{
			System.out.print(b[i] / globalMax + " ");// getting original value back via division
		}

	}
}
