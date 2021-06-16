import java.util.Arrays;

public class DP_UnboundedKnapsackDuplicateItems
{
	static int[][] dp = new int[100][100];

	public static void main(String[] args)
	{
		int[] values = { 1, 4, 5, 7 };
		int[] weights = { 1, 3, 4, 5 };
		int capacity = 8;
		System.out.println("unbound knapsack=" + unboundedKnapsack(values, weights, capacity, weights.length));
		populateDPForMemoization(dp, -1);
		System.out
				.println("memo_unbound knapsack=" + memo_unboundedKnapsack(values, weights, capacity, weights.length));
		System.out.println("tab_unbound knapsack=" + tab_unboundedKnapsack(values, weights, capacity, weights.length));
	}

	public static int unboundedKnapsack(int[] price, int[] weight, int capacity, int item)
	{
		// base case
		if (capacity == 0 || item == 0)
		{
			return 0;
		}

		if (capacity >= weight[item - 1])
		{
			return Math.max(unboundedKnapsack(price, weight, capacity, item - 1), // exclude
					price[item - 1] + unboundedKnapsack(price, weight, capacity - weight[item - 1], item));// include
		}
		else
		{
			return unboundedKnapsack(price, weight, capacity, item - 1);// exclusion
		}
	}

	public static void populateDPForMemoization(int[][] dp, int value)
	{
		for (int i = 0; i < dp.length; i++)
		{
			for (int j = 0; j < dp[0].length; j++)
			{
				dp[i][j] = value;
			}
		}
	}

	// memoization
	public static int memo_unboundedKnapsack(int[] price, int[] weight, int capacity, int items)
	{
		// base case
		if (capacity == 0 || items == 0)
		{
			return 0;
		}
		
		if (dp[capacity][items]!=-1)
		{
			return dp[capacity][items];
		}
		else
		{
			if(capacity>=weight[items-1])
			{
				int result = Math.max(memo_unboundedKnapsack(price, weight, capacity, items - 1), // exclude
						price[items - 1] + memo_unboundedKnapsack(price, weight, capacity - weight[items - 1], items));// include
				dp[capacity][items]=result;
				return result;
			}
			else
			{
				int result = memo_unboundedKnapsack(price, weight, capacity, items - 1);// exclusion
				dp[capacity][items]=result;
				return result;
			}
		}
	}

	// tabulation
	public static int tab_unboundedKnapsack(int[] price, int[] weight, int capacity, int items)
	{
		// exclusion is only changing items so dp=array
		int[] dp = new int[capacity + 1];

		// outer for loop is keeping weight fixed
		for (int wt = 0; wt <= capacity; wt++)
		{
			// inner loop iterates the items
			for (int item = 0; item < items; item++)
			{
				if (wt >= weight[item])
				{
					// System.out.println("currCapacity:"+wt+", currItemWeight:"+weight[item]+",
					// currItemPrice:"+price[item]+", dp_before:" + Arrays.toString(dp));
					dp[wt] = Math.max(dp[wt], dp[wt - weight[item]] + price[item]);
					// System.out.println("currCapacity:"+wt+",currItemWeight:"+weight[item]+",
					// currItemPrice:"+price[item]+", dp_after:" + Arrays.toString(dp));
				}
			}
		}
		return dp[capacity];
	}
}
