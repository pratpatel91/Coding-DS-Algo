
public class DP_ReachAGivenScore
{
	static int[] recursiveCachearray = new int[11];

	public static void main(String[] args)
	{
		int score = 10;
		System.out.println("waysToReachScore(10)=" + waysToReachScore(score));
		settingTheCacheToNegativeOnesForMemoization(recursiveCachearray);
		System.out.println("memo_waysToReachScore(10)=" + memo_waysToReachScore(score));
		System.out.println("tab_waysToReachScore(10)=" + tab_waysToReachScore(score));
	}

	public static int waysToReachScore(int score)
	{
		// corner case
		if (score < 0)
		{
			return 0;
		}

		// base case
		if (score == 0)
		{
			return 1;
		}
		return waysToReachScore(score - 3) + waysToReachScore(score - 5) + waysToReachScore(score - 10);
	}

	// Memoization TC=O(N) SC=O(N)
	public static void settingTheCacheToNegativeOnesForMemoization(int[] recursiveCachearray)
	{
		// step1: set the cache to -1
		for (int i = 0; i <= recursiveCachearray.length - 1; i++)
		{
			recursiveCachearray[i] = -1;
		}
	}
	
	public static int memo_waysToReachScore(int score)
	{
		// step1: write the same corner case
		if (score < 0)
		{
			return 0;
		}

		// step2: write the same base case
		if (score == 0)
		{
			return 1;
		}
		
		// step3: write the core logic for memoization
		if(recursiveCachearray[score]==-1) // 3.1 if the cache is -1 then store recursive results in cache
		{
			int recursiveResult = memo_waysToReachScore(score-3)+memo_waysToReachScore(score-5)+memo_waysToReachScore(score-10);
			recursiveCachearray[score]=recursiveResult;
			return recursiveCachearray[score];
		}
		else
		{
			return recursiveCachearray[score]; // 3.2 if the cache isnt -1 then reuse cache
		}
	}
	
	// Tabulation TC=O(N) SC=O(N)
	public static int tab_waysToReachScore(int score)
	{
		int[] cache = new int[score + 1];

		cache[0] = 1; // base case

		for (int i = 3; i <= cache.length - 1; i++)
		{
			cache[i] = cache[i] + cache[i - 3];
		}

		for (int i = 5; i <= cache.length - 1; i++)
		{
			cache[i] = cache[i] + cache[i - 5];
		}

		for (int i = 10; i <= cache.length - 1; i++)
		{
			cache[i] = cache[i] + cache[i - 10];
		}
		return cache[score];
	}

}
