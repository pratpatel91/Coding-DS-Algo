import java.util.Arrays;

public class _22_SubsetSum
{
	// Meet in the Middle Problem(breaks 2^n into 2^n/2 in this case):
	// create 2 different arrays because a single array is too large

	// TC=O(2^n*log(2^n)) so its a N*logN problem where N=2^n

	// CANT USE DP DUE TO HAVING OVERLAP ISSUES
	public static void main(String[] args)
	{
		int[] array = { -1, 2, 3 };
		int min = -1; // array range
		int max = 2;// array range
		// int[] subsetSum = generateSubsetSum(array);
		// System.out.println(Arrays.toString(subsetSum));
		System.out.println(numOfSubsetInRange(array, min, max));
	}

	public static int numOfSubsetInRange(int[] array, int min, int max)
	{
		int mid = (array.length) / 2;

		int[] leftSubArray = generateSubsetSum(array, 0, mid);

		// terinary operator:    mid%2==1?mid+1:mid
				
		/*
		if (mid % 2 == 1) // odd elements
		{
			mid = mid + 1;
		}
		else //even elements
		{
			mid=mid;
		}
		*/
		
		int[] rightSubArray = generateSubsetSum(array, mid, mid%2==1?mid+1:mid);

		System.out.println(Arrays.toString(leftSubArray));

		Arrays.sort(rightSubArray); // right subarray is sorted to do binary search on

		System.out.println(Arrays.toString(rightSubArray));

		int numSubsets = 0;

		// the leftSubArray doesnt have to be sorted
		for (int i = 0; i <= leftSubArray.length - 1; i++)
		{
			// searching the sorted rightSubArray
			int targetMin = min - leftSubArray[i];
			int targetMax = max - leftSubArray[i];
			System.out.println("targetMin:" + targetMin + ", targetMax:" + targetMax);
			int low = lowerBoundOfArray(rightSubArray, targetMin);
			int high = upperBoundOfArray(rightSubArray, targetMax);
			System.out.println("low:" + low + ", high:" + high);
			numSubsets += (high - low);
		}
		return numSubsets;
	}
	

	// binary search
	// target=min-a[i] or max-a[i]
	public static int lowerBoundOfArray(int[] rightSubArray, int target)
	{
		int left = -1;
		int right = rightSubArray.length - 1;
		int lowerBound = -1; // assumption:target is not found in the right subarray

		while (left + 1 < right)
		{
			int mid = left + (right - left) / 2;

			if (rightSubArray[mid] >= target)
			{
				lowerBound = mid;
				right = mid; // search left 1/2 of the array
			} else
			{
				left = mid;// search right 1/2 of the array
			}
		}
		return lowerBound;
	}

	// binary search
	// target=min-a[i] or max-a[i]
	public static int upperBoundOfArray(int[] rightSubArray, int target)
	{
		int left = -1;
		int right = rightSubArray.length - 1;
		int upperBound = -1; // assumption:target is not found in the right subarray

		while (left + 1 < right)
		{
			int mid = left + (right - left) / 2;

			if (target >= rightSubArray[mid])
			{
				upperBound = mid;
				left = mid;// search right 1/2 of the array
			} else
			{
				right = mid; // search left 1/2 of the array
			}
		}
		return (upperBound + 1);
	}

	public static int[] generateSubsetSum(int[] array, int start, int n)
	{
		// one of the array is iterated for all sets and within that array 2^n
		// another array is iterated using binary search(log(2^n) thus the overall
		// TC = O(2^n*log(2^n))

		int[] subsetSum = new int[(int) Math.pow(2, n)];

		// generating all the subsets
		for (int i = 0; i < Math.pow(2, n); i++)
		{
			int sum = 0;

			for (int j = 0; j < n; j++)
			{
				if ((i & (1 << j)) != 0)
				{
					sum += array[j + start];
				}

			}
			subsetSum[i] = sum;
		}
		return subsetSum;
	}

}
