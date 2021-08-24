import java.util.Arrays;

public class DP_MinCoinsToMakeAValue
{
	public static void main(String[] args)
	{
		int[] coins = { 1, 2, 3 };
		int amount = 15;
		// System.out.println("minCoinsToGetValue(15,{1,2,3})=" +
		// minCoinsToGetValue(amount, coins));
		System.out.println("tab_minCoins(15,{1,2,3})=" + tab_minCoins(amount, coins));
	}

	public static int minCoinsToGetValue(int amount, int[] coins)
	{
		// base case
//		if (amount < 0)
//		{
//			return Integer.MAX_VALUE;
//		}
		if (amount == 0)
		{
			return 0;
		}

		int globalMin = Integer.MAX_VALUE; // updated per each recursive call so its a local var

		for (int i = 0; i <= coins.length - 1; i++)
		{
			// System.out.println("curr Coin:"+coins[i] + ", curr Amount:"+amount+",
			// answer:"+globalMin);
			if (coins[i] <= amount)
			{
				int minCoins = minCoinsToGetValue(amount - coins[i], coins);
				System.out.println("curr Coin:" + coins[i] + ", curr Amount:" + amount + ", answer:" + minCoins);
				if (minCoins != Integer.MAX_VALUE && minCoins + 1 < globalMin)
				{
					globalMin = minCoins + 1; // 1 coin is min
				}
			}
		}
		return globalMin;
	}

	public static int tab_minCoins(int amount, int[] coins)
	{
		// repetition of largest coins gives min # of coins that satisfy an amount
		// due to repetition we know that dp=1d array
		int[] cache = new int[amount + 1];

		// base case
		cache[0] = 0;
		
		for(int i=1; i<=cache.length-1;i++)
		{
			cache[i]=Integer.MAX_VALUE;
		}

		for (int coin = 0; coin < coins.length; coin++)
		{
			for (int currAmt = coins[coin]; currAmt <= amount; currAmt++)
			{
				int remainAmt = currAmt - coins[coin];
				int minCoinToMakeRemainAmt = cache[remainAmt];
				int totalCoins = minCoinToMakeRemainAmt + 1;
				cache[currAmt] = Math.min(cache[currAmt], totalCoins);
			}
		}
		System.out.println(Arrays.toString(cache));
		return cache[amount];
	}
}
