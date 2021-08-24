import java.util.Arrays;

public class DP_LongestIncreasingSubsequence
{
	static int[] recursiveCacheArray = new int[7];

	public static void main(String[] args)
	{
		int[] array = { 50, 3, 10, 7, 40, 80 }; // LIS={3, 7, 40, 80}
		initializeDPForLIS(recursiveCacheArray, 1);
		settingTheCacheToNegativeOnesForMemoization(recursiveCacheArray);
		System.out.println("LIS_LongestIncreasingSubsequence=" + LIS(array, array.length - 1));
		System.out.println("memo_LongestIncreasingSubsequence=" + memo_LIS(array, array.length - 1));
		System.out.println("tab_LongestIncreasingSubsequence=" + tab_LIS(array));
	}

	// Enumerating Combinations/Pure Recursion TC=O(2^N)
	public static int LIS(int[] array, int currentIndex)
	{
		if (currentIndex == 0)
		{
			return 1; // LIS of a single element is 1
		}

		int maxLIS = 1;

		for (int j = 0; j < currentIndex; j++)
		{
			if (array[currentIndex] > array[j])
			{
				maxLIS = Math.max(maxLIS, LIS(array, j) + 1);
			}
		}
		return maxLIS;
	}

	// Memoization TC=O(N) SC=O(N)
	public static int memo_LIS(int[] array, int currentIndex)
	{
		// step1: write the same base cases
		if (currentIndex == 0)
		{
			return 1; // LIS of a single element is 1
		}

		// step2: write the core logic for memoization
		int maxLIS = 1;
		
		if (recursiveCacheArray[currentIndex] == -1) // 2.1 if the cache is -1 then store recursive results in cache
		{
			for (int j = 0; j < currentIndex; j++)
			{
				if (array[currentIndex] > array[j])
				{
					recursiveCacheArray[currentIndex] = Math.max(maxLIS, LIS(array, j) + 1);
				}
			}
			return recursiveCacheArray[currentIndex]; 
		}
		else
		{
			return recursiveCacheArray[currentIndex]; // 2.2 if the cache isnt -1 then reuse cache
		}
	}

	// Tabulation TC=O(N) SC=O(N)
	public static int tab_LIS(int[] array)
	{
		int[] LIS = new int[array.length];

		// base case
		initializeDPForLIS(LIS, 1);

		for (int right = 1; right < array.length; right++)
		{
			// increasing order check
			for (int left = 0; left < right; left++)
			{
				// System.out.println("left:"+input[left] + ", right:"+input[right]
				// + ", leftLIS:"+LIS[left]+ ", rightLIS:"+LIS[right]);
				if (array[right] > array[left] && (LIS[left] + 1) > LIS[right])
				{
					// System.out.println("Updating LIS Array:" + " leftLIS:"+LIS[left]+ ",
					// rightLIS:"+LIS[right]);
					// System.out.println("Before Updating LIS: " + Arrays.toString(LIS));
					LIS[right] = LIS[left] + 1; // updating with a larger LIS
					// System.out.println("After Updating LIS: "+Arrays.toString(LIS));
				}
			}
		}
		int maxLIS = getArrayMax(LIS);
		return maxLIS;
	}

	// ----------------Helper Functions --------------------------------------//
	public static void initializeDPForLIS(int[] array, int value)
	{
		for (int i = 0; i < array.length; i++)
		{
			array[i] = 1;
		}
	}

	public static int getArrayMax(int[] array)
	{
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < array.length; i++)
		{
			max = Math.max(max, array[i]);
		}
		return max;
	}

	public static void printArray(int[] lisArray)
	{
		System.out.println("---------Lis Array------------");
		for (int i = 0; i <= lisArray.length - 1; i++)
		{
			System.out.print(lisArray[i] + " ");
		}
		System.out.println();
	}

	public static void settingTheCacheToNegativeOnesForMemoization(int[] recursiveCachearray)
	{
		// step1: set the cache to -1
		for (int i = 0; i <= recursiveCachearray.length - 1; i++)
		{
			recursiveCachearray[i] = -1;
		}
	}
}
