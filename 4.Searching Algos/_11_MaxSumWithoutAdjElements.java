
public class _11_MaxSumWithoutAdjElements
{
	public static void main(String[] args)
	{
		int[] array = { 5, 5, 10, 100, 10, 5 };
		dp_MaxSumExcludingAdjElements(array);
	}

	// DP Problem (problem statement has include and exclude conditions)
	// TC=O(n) SC=O(n) due to creating a cache array
	// this question is a variation of the fibonaci series (update line 30)
	public static void dp_MaxSumExcludingAdjElements(int[] array)
	{
		int[] dp_Cache = new int[array.length];

		// assumption
		dp_Cache[0] = array[0];
		// verifying if the assumption is correct
		dp_Cache[1] = Math.max(array[0], array[1]);

		// update our assumption throughout the remaining elements
		// since we have verified our assumptions up till i=1
		// we are restart from i=2
		for (int i = 2; i <= array.length - 1; i++)
		{
			// updating the assumption by checking
			// if the previous house gave max money
			// or if the current house + 2 houses back gives the max money
			dp_Cache[i] = Math.max(dp_Cache[i - 1], array[i] + dp_Cache[i - 2]);
		}
		System.out.println("Printing the input Array");
		printArray(array);
		System.out.println("\nPrinting the dp_Cache Array");
		printArray(dp_Cache);

		// dp_Cache[last index] contains the answer
		System.out.println("\nMax Money From Houses:" + dp_Cache[array.length - 1]);

	}

	public static void printArray(int[] array)
	{
		for (int i = 0; i <= array.length - 1; i++)
		{
			System.out.print(array[i] + " ");
		}
	}

}
