import java.util.Arrays;

public class _Old_DP_CoinChange
{
	// cacheMatrix[coinsArray.length+1][coinSetSum+1]
	static int[][] recursiveCacheMatrix = new int[4][7];

	public static void main(String[] args)
	{
		int[] coinsArray = { 2, 3, 5 };
		int coinSetsSum = 6;

		int ways = recursive_coinChangeWays(coinsArray, coinsArray.length, coinSetsSum);
		System.out.println("coins=" + Arrays.toString(coinsArray) + ", sum=" + coinSetsSum + ", " + ways + " ways");

		// populating the cacheMatrix with -1
		for (int i = 0; i < recursiveCacheMatrix.length; i++)
		{
			for (int j = 0; j < recursiveCacheMatrix[0].length; j++)
			{
				recursiveCacheMatrix[i][j] = -1;
			}
		}

		ways = memoized_coinChangeWays(coinsArray, coinsArray.length, coinSetsSum);
		System.out.println("coins=" + Arrays.toString(coinsArray) + ", sum=" + coinSetsSum + ", " + ways + " ways");

		System.out.println("tab_coinChangeWays=" + _1d_tab_coinChangeWays(coinsArray, coinSetsSum));
	}

	public static int recursive_coinChangeWays(int[] coinsArray, int index, int coinSetsSum)
	{
		// if sum=0 then 1 set of combo satisfies sum=4
		if (coinSetsSum == 0)
		{
			return 1;
		}
		// if sum=-1 then no set of combo exists that satisfies sum=4
		if (coinSetsSum < 0)
		{
			return 0;
		}
		// if index == or -1 then no set of combo exists that satisfies sum=4
		if (index <= 0)
		{
			return 0;
		}

		int coinsSumAfterInclude = recursive_coinChangeWays(coinsArray, index, coinSetsSum - coinsArray[index - 1]);
		int coinsSumAfterExclude = recursive_coinChangeWays(coinsArray, index - 1, coinSetsSum);
		System.out.println("Sum:" + (coinsSumAfterInclude + coinsSumAfterExclude));
		return coinsSumAfterInclude + coinsSumAfterExclude;
	}

	// memoization (2d only)
	public static int memoized_coinChangeWays(int[] coinsArray, int index, int coinSetsSum)
	{
		// 1.-----------Keeping the base conditions as the recursive solution---------//
		// 1.1 if sum=0 then 1 set of combo satisfies sum=4
		if (coinSetsSum == 0)
		{
			return 1;
		}
		// 1.2 if sum=-1 then no set of combo exists that satisfies sum=4
		if (coinSetsSum < 0)
		{
			return 0;
		}
		// 1.3 if index == or -1 then no set of combo exists that satisfies sum=4
		if (index <= 0)
		{
			return 0;
		}

		// 2.----------------------Memoizations Core Logic ----------------------//
		if (recursiveCacheMatrix[index][coinSetsSum] == -1) // if the cache is empty then store the 1st computation into
															// the cache
		{
			int coinsSumAfterInclude = memoized_coinChangeWays(coinsArray, index, coinSetsSum - coinsArray[index - 1]);
			int coinsSumAfterExclude = memoized_coinChangeWays(coinsArray, index - 1, coinSetsSum);
			int result = coinsSumAfterInclude + coinsSumAfterExclude;
			recursiveCacheMatrix[index][coinSetsSum] = result;
			return result;
		}
		else // else reuse the cache
		{
			return recursiveCacheMatrix[index][coinSetsSum];
		}
	}

	// Tabulated hw
	// Add tabulation (1d and 2d both)
	public static int _2d_tab_coinChangeWays(int[] coinsArray, int coinSetSum)
	{
		int[][] cacheMatrix = new int[coinsArray.length][coinSetSum];

		for (int i = 0; i < cacheMatrix.length; i++)
		{
			for (int j = 0; j < cacheMatrix[0].length; j++)
			{
				if (j == 0)
				{
					cacheMatrix[i][j] = 0;
				}
				else
				{
					cacheMatrix[i][j] = cacheMatrix[i - 1][j] + cacheMatrix[i - 1][j];
				}
			}
		}
		return cacheMatrix[coinsArray.length][coinSetSum];
	}

	// add space optimized
	static int _1d_tab_coinChangeWays(int[] coinsArray, int coinSetSum)
	{
		//cache array
		int[] cacheArray = new int[coinSetSum + 1];

		//basecase
		cacheArray[0] = 1;

		//logic for tabulation
		for (int currentCoin=0; currentCoin<=coinsArray.length-1; currentCoin++)
		{
			for (int i = currentCoin; i < (coinSetSum + 1); i++)
			{
				cacheArray[i] += cacheArray[i - currentCoin];
			}
		}
		return cacheArray[cacheArray.length - 1];
	}

}
