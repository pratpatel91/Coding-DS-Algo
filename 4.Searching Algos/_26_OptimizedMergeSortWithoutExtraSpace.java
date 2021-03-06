
public class _26_OptimizedMergeSortWithoutExtraSpace
{
	// TC=O(n+m)*log(n+m) n+m because we are merging two sorted arrays
	public static void main(String[] args)
	{
		int[] A = { 1, 3, 5, 7 };
		int[] B = { 0, 2, 6, 8, 9 };
		mergeTheTwoSortedArrays(A, B);
	}

	public static void mergeTheTwoSortedArrays(int[] A, int[] B)
	{
		// ----------------------Find the max in order to get a R=1-n-------------//
		int n = A.length;
		int m = B.length;

		int maxfromArray_A = arrayMax(A);
		int maxfromArray_B = arrayMax(B);
		int maxElement = Math.max(maxfromArray_A, maxfromArray_B);

		maxElement++;// X%n that gives us a R=0-(n-1) so doing X%n+1 gives us R=1-n

		// -------------element comparisons-------------------------------------//
		int i = 0;
		int j = 0;
		int k = 0; // elements encountered so far

		// Math Trick
		// 1st we do %max, 2nd we do * max and 3rd we do /max

		// A[] = [0.....n] B[]=[n+1........n+m]
		while (i < n && j < m && k < (n + m))
		{
			// 1st we do %max
			int currA = A[i] % maxElement;
			int currB = B[j] % maxElement;

			// based on element comparisons between arrays A&B we can populating
			// such that array As elements are smaller than array B
			if (currA <= currB)
			{
				if (k < n)
				{
					A[k] += (currA * maxElement); // store the smaller value in array A
				} else // k-n = (n+m)-n
				{
					B[k - n] += (currA * maxElement); // store the smaller value in array B
				}
				i++;
				k++; // k is incremented no matter what
			} else
			{
				if (k < n)
				{
					A[k] += (currB * maxElement); // store the smaller value in array A
				} else // k-n = (n+m)-n
				{
					B[k - n] += (currB * maxElement); // store the smaller value in array B
				}
				j++;
				k++; // k is incremented no matter what
			}
		}

		// storing the remaining elements into arrayA or arrayB
		while (i < n)
		{
			// 1st we do %max
			int currA = A[i] % maxElement;

			if (k < n)
			{
				A[k] += (currA * maxElement); // store the smaller value in array A
			} else // k-n = (n+m)-n
			{
				B[k - n] += (currA * maxElement); // store the smaller value in array B
			}
			i++;
			k++; // k is incremented no matter what
		}

		// storing the remaining elements into arrayB only
		while (j <m)
		{
			// 1st we do %max
			int currB = B[j] % maxElement;

			if (k < n)
			{
				B[k] += (currB * maxElement); // store the smaller value in array A
			} else // k-n = (n+m)-n
			{
				B[k - n] += (currB * maxElement); // store the smaller value in array B
			}
			j++;
			k++; // k is incremented no matter what
		}

		// 3rd we do /max
		for (i = 0; i < n; i++)
		{
			A[i] = A[i] / maxElement;
		}

		for (j = 0; j < m; j++)
		{
			B[j] = B[j] / maxElement;
		}
		printArray(A);
		printArray(B);
	}

	public static int arrayMax(int[] array)
	{
		int max = Integer.MIN_VALUE;

		for (int i = 0; i <= array.length - 1; i++)
		{
			int current = array[i];

			if (current > max)
			{
				max = current;
			}
		}

		return max;
	}

	public static void printArray(int[] array)
	{
		for (int i = 0; i <= array.length - 1; i++)
		{
			System.out.print(array[i] + " ");
		}
	}
}
