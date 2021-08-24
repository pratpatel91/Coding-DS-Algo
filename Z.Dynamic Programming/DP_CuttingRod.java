
public class DP_CuttingRod
{

	public static void main(String[] args)
	{
		int[] prices = { 1, 5, 8, 9, 10, 17, 17, 20 };
		int length = prices.length;
		System.out.println("maxProfitCuttingRods(prices, length)=" + maxProfitCuttingRods(prices, length));
		System.out.println("tab_maxProfit(prices, length)=" + tab_maxProfit(prices, length));
	}

	public static int maxProfitCuttingRods(int[] prices, int len)
	{
		if (len <= 0)
		{
			return 0;
		}

		int maxProfit = Integer.MIN_VALUE;

		for (int currLen = 0; currLen < len; currLen++)
		{
			int remainLen = len - currLen;
			maxProfit = Math.max(maxProfit, prices[currLen] + maxProfitCuttingRods(prices, remainLen - 1));
		}
		return maxProfit;
	}

	public static int tab_maxProfit(int[] prices, int len)
	{
		int[] cache = new int[len + 1];

		cache[0] = 0; // base case

		for (int currLen = 1; currLen <= len; currLen++)
		{
			int maxProfit = Integer.MIN_VALUE;

			for (int remainLen = 0; remainLen < currLen; remainLen++)
			{
				maxProfit = Math.max(maxProfit, prices[remainLen] + cache[currLen - remainLen - 1]);
			}
			cache[currLen] = maxProfit;
		}

		for (int i = 0; i <= cache.length - 1; i++)
		{
			System.out.print(cache[i] + " ");
		}
		System.out.println(); // blank space

		return cache[len];

	}
}
