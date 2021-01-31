public class _21_IntermittenArrayWalkToFindMaxSum
{
	public static void main(String[] args)
	{
		int[] A = { 3, 5, 7, 9, 20, 25, 30, 40, 55, 56, 57, 60, 62 };
		int[] B = { 1, 4, 7, 11, 14, 25, 44, 47, 55, 57, 100 };

		int[] pSA = prefixSumArray(A);
		printArray(pSA);
		int[] pSB = prefixSumArray(B);
		printArray(pSB);
		System.out.println();
		System.out.println("Sum: " + doubleHelix(A, B, pSA, pSB));

	}

	// TC=O(N*logN) this is analogous to the outerloop iterating all elements of
	// array A
	// and the inner loop iterating logN elements of array B
	public static int doubleHelix(int[] A, int[] B, int[] pSA, int[] pSB)
	{
		boolean flag = false; // Atleast One Element From Array_A Found in Array_B
		int currentPSA = 0;
		int currentPSB = 0;
		int prevA = 0; // previous index when A[i]=B[position]
		int prevB = 0;// previous index when A[i]=B[position]
		int maxSum = 0;

		// iterating through array A (TC=O(N))
		for (int i = 0; i <= A.length - 1; i++)
		{
			int target = A[i];
			int position = binarySearch(B, target);

			if (position != -1)
			{
				if (flag == false)
				{
					flag = true;
					currentPSA = pSA[i];
					currentPSB = pSB[position];// A[i]=B[position]
				} else // subtract values to retain sums accuracy due to shifting between arrays
				{
					System.out.println("pSA[i]:" + pSA[i] + ", pSA[prevA]" + pSA[prevA]);
					System.out.println("pSB[position]:" + pSB[position] + ", pSB[prevB]" + pSB[prevB]);
					currentPSA = pSA[i] - pSA[prevA]; // updatedsum=currentsum-previoussum
					currentPSB = pSB[position] - pSB[prevB]; // updatedsum=currentsum-previoussum
				}
				prevA = i;
				prevB = position;
				System.out.println("currentPSA:" + currentPSA + ", currentPSB:" + currentPSB);
				maxSum += Math.max(currentPSA, currentPSB);
				System.out.println("maxSum :" + maxSum);
			}
		}
		// displaying answer
		if (flag == true)
		{
			System.out.println("pSA[i]:" + pSA[A.length-1] + ", pSA[prevA]" + pSA[prevA]);
			System.out.println("pSB[position]:" + pSB[B.length-1] + ", pSB[prevB]" + pSB[prevB]);
			currentPSA = pSA[A.length - 1] - pSA[prevA];
			currentPSB = pSB[B.length - 1] - pSB[prevB];
			maxSum += Math.max(currentPSA, currentPSB);
		} else // couldnt find common elements between arrays A&B
		{
			maxSum += Math.max(pSA[A.length - 1], pSB[B.length - 1]); // returning max value stored at the last index
		}

		return maxSum;
	}

	public static int binarySearch(int[] B, int target)
	{
		// initialization
		int left = 0;
		int right = B.length - 1;

		while (left <= right)
		{
			int mid = (left + right) / 2; // mid=[left+(right-left)]/2

			if (B[mid] == target)
			{
				return mid;
			} else if (B[mid] > target)
			{
				// target belongs to the left half
				// thus we change the right pointer
				right = mid - 1;
			} else
			{
				// target belongs to the tight half
				// thus we change the left pointer
				left = mid + 1;
			}
		}
		// if nothing is found then return a -1
		return -1;
	}

	public static int[] prefixSumArray(int[] array)
	{
		int[] prefixSumArray = new int[array.length];

		// 1st element in the prefix sum is array[0]
		prefixSumArray[0] = array[0];

		for (int i = 1; i <= array.length - 1; i++)
		{
			prefixSumArray[i] = prefixSumArray[i - 1] + array[i];
		}

		return prefixSumArray;
	}

	public static void printArray(int[] array)
	{
		for (int i = 0; i <= array.length - 1; i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}

}
