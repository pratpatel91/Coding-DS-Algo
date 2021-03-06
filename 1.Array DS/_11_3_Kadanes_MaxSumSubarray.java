import java.util.Scanner;

//Dynamic Programming
public class _11_3_Kadanes_MaxSumSubarray
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();

		while (T > 0)
		{
			// Taking Data from user
			int N = input.nextInt(); // N is the array length

			int[] array = new int[N];

			for (int i = 0; i <= N - 1; i++)
			{
				array[i] = input.nextInt();
			}

			// Displaying the answer
			// System.out.println(TwoLoops_maxSumOfSubArray(array));
			System.out.println(OneLoop_maxSumOfSubArray(array));
		}
	}

	// Brute Force: TC = O(n^3) & SC = O(1) //we arent creating an auxilary array
	// (something on top of the given data structure)
	public static int ThreeLoops_maxSumOfSubArray(int[] array)
	{
		// FROM O Value which was capping maxSum from [0 --- +infinity]
		int maxSum_ijk = Integer.MIN_VALUE; // sum of subarrays (set to smallest neg #)

		for (int i = 0; i < array.length; i++)
		{
			// holding i constant while varying k
			for (int j = i; j < array.length; j++)
			{
				int currentSum_ij = 0; // sum of subarrays

				for (int k = i; k <= j; k++)
				{
					currentSum_ij = currentSum_ij + array[k];
				}

				if (currentSum_ij > maxSum_ijk)
				{
					maxSum_ijk = currentSum_ij;
				}
			}
		}
		return maxSum_ijk;
	}

	// Better: TC = O(n^2) & SC = O(1) //we arent creating an auxilary array
	// (something on top of the given data structure)
	public static int TwoLoops_maxSumOfSubArray(int[] array)
	{
		// FROM O Value which was capping maxSum from [0 --- +infinity]
		int maxSum_ijk = Integer.MIN_VALUE; // sum of subarrays (set to smallest neg #)

		for (int i = 0; i < array.length; i++)
		{
			int currentSum_ij = 0; // sum of subarrays (placing this outside of the loop
									// in order to accumulate the sum per each iteration)

			// holding i constant while varying k
			for (int j = i; j < array.length; j++)
			{
				currentSum_ij = currentSum_ij + array[j];

				if (currentSum_ij > maxSum_ijk)
				{
					maxSum_ijk = currentSum_ij;
				}
			}
		}
		return maxSum_ijk;
	}

	// Optimized: TC = O(n) & SC = O(1) //we arent creating an auxilary array
	// (something on top of the given data structure)
	public static int OneLoop_maxSumOfSubArray(int[] array)
	{
		// FROM O Value which was capping maxSum from [0 --- +infinity]
		int maxSum_ijk = Integer.MIN_VALUE; // sum of subarrays (set to smallest neg #)
		int currentSum_ij = 0; // sum of subarrays (placing this outside of the loop
								// in order to accumulate the sum per each iteration)

		for (int i = 0; i < array.length; i++)
		{
// -----------------------Old Lengthy Code------------------
//			currentSum_ij = currentSum_ij + array[i];
//			
//			if (array[i] > currentSum_ij)
//			{
//				currentSum_ij = array[i];
//			}
//
//			if (currentSum_ij > maxSum_ijk)
//			{
//				maxSum_ijk = currentSum_ij;
//			}

// -----------------------New Shorter Refactored Code------------------
			currentSum_ij = max(currentSum_ij + array[i], array[i]); // crux of dp
			maxSum_ijk = max(maxSum_ijk, currentSum_ij);
		}
		return maxSum_ijk;
	}

	public static int max(int a, int b)
	{
		if (a > b)
		{
			return a;
		}
		return b;
	}

}
