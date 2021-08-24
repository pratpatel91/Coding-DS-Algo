public class DP_FencePainting
{
	static int[] recursiveCachearray = new int[6];
	static int waysToPaintSameColorFence;
	static int waysToPaintDifferentColorFence;

	public static void main(String[] args)
	{
		int fences = 5;
		int colors = 3;
		System.out.println("waysToPaintFence(5,3)=" + waysToPaintFence(fences, colors));
		settingTheCacheToNegativeOnesForMemoization(recursiveCachearray);
		System.out.println("memo_waysToPaintFence(5,3)=" + memo_waysToPaintFence(fences, colors));
		System.out.println("tab_waysToPaintFence(5,3)=" + tab_waysToPaintFence(fences, colors));
		System.out.println("spaceOptimized_tab_paintFences(5,3)=" + spaceOptimized_tab_paintFences(fences, colors));
	}

	//Enumerating Combinations/Pure Recursion TC=O(2^N)
	public static int waysToPaintFence(int fences, int colors)
	{
		if (fences == 1)
		{
			return colors; // 1 fence is colored by # of colors
		}
		if (fences == 2)
		{
			return colors * colors; // 2 fences is a combination of 3*3 color choices
		}
		else
		{
			// ways to do same color + ways to do different colors
			// colors-1 # of leftover choices
			return (colors - 1) * (waysToPaintFence(fences - 1, colors) + waysToPaintFence(fences - 2, colors));
		}
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

	public static int memo_waysToPaintFence(int fences, int colors)
	{
		// step1: write the same base cases
		if (fences == 1)
		{
			return colors; // 1 fence is colored by # of colors
		}
		if (fences == 2)
		{
			return colors * colors; // 2 fences is a combination of 3*3 color choices
		}

		// step2: write the core logic for memoization
		if (recursiveCachearray[fences] == -1) // 2.1 if the cache is -1 then store recursive results in cache
		{
			waysToPaintSameColorFence = (colors - 1) * memo_waysToPaintFence(fences - 1, colors);
			waysToPaintDifferentColorFence = (colors - 1) * memo_waysToPaintFence(fences - 2, colors);
			recursiveCachearray[fences] = waysToPaintSameColorFence + waysToPaintDifferentColorFence;
			return recursiveCachearray[fences];
		}
		else
		{
			return recursiveCachearray[fences]; // 2.2 if the cache isnt -1 then reuse cache
		}
	}

	// Tabulation TC=O(N) SC=O(N)
	public static int tab_waysToPaintFence(int fences, int colors)
	{
		int[] cache = new int[fences + 1];
		
		// base case
		cache[1] = colors;
		cache[2] = colors * colors;

		//core logic for tabulation
		for (int i = 3; i <= cache.length - 1; i++)
		{
			cache[i] = (colors - 1) * (cache[i - 1] + cache[i - 2]);
		}
		return cache[fences];
	}

	// adhoc space optimized TC=O(N) SC=O(1)
	public static int spaceOptimized_tab_paintFences(int fences, int colors)
	{
		int same = colors;
		int diff = colors * (colors - 1);
		int totalWays = same + diff;

		for (int i = 3; i <= fences; i++)
		{
			same = diff;
			diff = totalWays * (colors - 1);
			totalWays = same + diff;
		}
		return totalWays;
	}
}
