public class DP_0_1_Knapsack
{
	static int calls = 0;
	static int[][] cacheMatrix = new int[100][100]; // 100 > 4 (max weight) & 3 (max index)

	public static void main(String[] args)
	{
		int[] values = { 10, 15, 20, 30 };
		int[] weights = { 2, 1, 4, 2 };
		int capacity = 4;

		System.out.print(maxProfitKnapsack(values, weights, values.length, capacity) + "; called " + calls + "x");

		// populating the cacheMatrix with -1
		for (int i = 0; i < cacheMatrix.length; i++)
		{
			for (int j = 0; j < cacheMatrix[0].length; j++)
			{
				cacheMatrix[i][j] = -1;
			}
		}

		calls = 0;
		System.out.print("\n" + memoizedMaxProfixKnapsack(values, weights, values.length, capacity) + "; called "
				+ calls + "x\n");

		System.out.println("\nProfit:" + tabulatedMaxProfixKnapsack(values, weights, values.length, capacity));
	}

	// TC=O(2^N)
	// SC=O(1)
	public static int maxProfitKnapsack(int[] values, int[] weights, int index, int capacity)
	{
		if (capacity == 0 || index == 0)
		{
			return 0;
		}

		if (capacity < weights[index - 1])
		{
			calls++;
			// excluding (changing index only)
			return maxProfitKnapsack(values, weights, index - 1, capacity);
		}
		else
		{
			calls++;
			return Math.max(maxProfitKnapsack(values, weights, index - 1, capacity), // Exclude (changing index only)
					values[index - 1] + maxProfitKnapsack(values, weights, index - 1, capacity - weights[index - 1]));
			// include (changing index and capacity) ........2d cache matrix
		}
	}

	// TC=O(N^2)
	// SC=O(N^2) due to cache matrix
	public static int memoizedMaxProfixKnapsack(int[] values, int[] weights, int index, int capacity)
	{
		if (capacity == 0 || index == 0)
		{
			return 0;
		}

		// returns computed values (this decreases calls)
		if (cacheMatrix[index - 1][capacity] != -1)
		{
			return cacheMatrix[index - 1][capacity];
		}

		if (capacity < weights[index - 1])
		{
			calls++;
			// excluding (changing index only)
			int profit = memoizedMaxProfixKnapsack(values, weights, index - 1, capacity);
			cacheMatrix[index - 1][capacity] = profit;
			return profit;
		}
		else
		{
			calls++;

			int profit = Math.max(memoizedMaxProfixKnapsack(values, weights, index - 1, capacity), values[index - 1]
					+ memoizedMaxProfixKnapsack(values, weights, index - 1, capacity - weights[index - 1]));
			cacheMatrix[index - 1][capacity] = profit;
			return profit;
		}
	}

	// TC=O(N^2)
	// SC=O(N^2) due to cache matrix
	public static int tabulatedMaxProfixKnapsack(int[] values, int[] weights, int index, int capacity)
	{
		if (capacity == 0 || index == 0)
		{
			return 0;
		}

		int[][] dpMatrix = new int[100][100];

		for (int currItem = 0; currItem <= index; currItem++)
		{
			for (int currCapacity = 0; currCapacity <= capacity; currCapacity++)
			{
				if (currItem == 0 || currCapacity == 0)
				{
					dpMatrix[currItem][currCapacity] = 0;
				}
				else if (currCapacity >= weights[currItem - 1])
				{
					// Math.max(include,exclude)
					dpMatrix[currItem][currCapacity] = Math.max(
							values[currItem - 1] + dpMatrix[currItem - 1][currCapacity - weights[currItem - 1]],
							dpMatrix[currItem - 1][currCapacity]);
				}
				else
				{
					// excluding current item
					dpMatrix[currItem][currCapacity] = dpMatrix[currItem - 1][currCapacity];
				}

			}
		}

		for (int currItem = 0; currItem <= index; currItem++)
		{
			for (int currCapacity = 0; currCapacity <= capacity; currCapacity++)
			{
				System.out.print(dpMatrix[currItem][currCapacity] + " ");
			}
			System.out.println();
		}
		return dpMatrix[index][capacity];
	}

}
