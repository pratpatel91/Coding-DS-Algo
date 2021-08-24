
public class DP_LCSOfSubStrings
{
	static int[][] dp = new int[7][7];

	public static void main(String[] args)
	{
		String s1 = "ABCDGH";
		String s2 = "ACDGHR";
		// 1.we are going from top/entire problem(start at i=length) to bottom/atomic
		// broken down problem (i=1)

		// we want to track lcs for the substring to reset to 0 per iterative mismatchs
		// we want to end when s1 or s2 is exhausted so we dont accidentally reset the
		// counter again
		int count = 0; // lcsOfSubString

		System.out.println("lcs_subStrings()=" + lcs_subStrings(count, s1, s2, s1.length(), s2.length()));

		// fill dp with -1
		for (int i = 0; i < 7; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				dp[i][j] = -1;
			}
		}

		count = 0; // lcsOfSubString

		System.out.println("memo_lcs_subStrings()=" + memo_lcs_subStrings(count, s1, s2, s1.length(), s2.length()));
		System.out.println("tab_lcs_subStrings()=" + tab_lcs_subStrings(s1, s2));
	}

	public static int lcs_subStrings(int count, String s1, String s2, int i, int j)
	{
		// ------------------------------LCS Code is reused--------------//

		// simplest computation/base case
		if (i == 0 || j == 0)
		{
			return 0;
		}

		// updating count per continously iterative matches
		if (s1.charAt(i - 1) == s2.charAt(j - 1))
		{
			count = lcs_subStrings(count + 1, s1, s2, i - 1, j - 1);
			return count;
		}
		else // if the continous iterative match is broken, we resetted the count and we only
				// updated the count until s1 or s2 got exhausted
		{
			// resetting the count if the continuity is broken
			// if any string is exchausted then we stop (i - 1, j) or (i, j - 1)
			count = Math.max(count,
					Math.max(lcs_subStrings(count, s1, s2, i - 1, j), lcs_subStrings(count, s1, s2, i, j - 1)));
			return count;
		}
	}

	// Memoized Hw
	public static int memo_lcs_subStrings(int count, String s1, String s2, int i, int j)
	{
		// ------------------------------LCS Code is reused--------------//
		// --------Reused Base Case from the Recursive Code ---------//
		// simplest computation/base case
		if (i == 0 || j == 0)
		{
			return 0;
		}

		// ------------Core Logic of memoization -----------//
		if (dp[i][j] == -1) // compute once to store in cache
		{
			// -------------recursive logic to fill the cache matrix------//
			// updating count per continously iterative matches
			if (s1.charAt(i - 1) == s2.charAt(j - 1))
			{
				// count = lcs_subStrings(count + 1, s1, s2, i - 1, j - 1);
				dp[i][j] = memo_lcs_subStrings(count + 1, s1, s2, i - 1, j - 1);
				return dp[i][j];
			}
			else // if if the continous iterative matchching is broken or s1 or s2 is exhausted
			{
				// count = Math.max(count,Math.max(lcs_subStrings(count, s1, s2, i - 1, j),
				// lcs_subStrings(count, s1, s2, i, j - 1)));
				dp[i][j] = Math.max(count, Math.max(memo_lcs_subStrings(count, s1, s2, i - 1, j),
						memo_lcs_subStrings(count, s1, s2, i, j - 1)));
				return dp[i][j];
			}
		}
		else // return the cached result(dont recompute again)
		{
			return dp[i][j];
		}
	}

	// Tabulated Hw
	public static int tab_lcs_subStrings(String s1, String s2)
	{
		// ------------------------------LCS Code is reused--------------//
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];

		// nested for loops is simply to populate the matrix dp
		for (int i = 0; i <= s1.length(); i++)
		{
			for (int j = 0; j <= s2.length(); j++)
			{
				// 1.Fill in the dp per the base conditions
				if (i == 0 || j == 0)
				{
					dp[i][j] = 0; // no comparison info to store within the dp
				}

				// 2.Fill in the dp per reccurence relationship
				else if (s1.charAt(i - 1) == s2.charAt(j - 1))
				{
					dp[i][j] = 1 + dp[i - 1][j - 1];
				}
				else
				{
					dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i - 1][j], dp[i][j - 1]));
				}
			}
		}

		// printing the matrix
		for (int i = 0; i <= s1.length(); i++)
		{
			for (int j = 0; j <= s2.length(); j++)
			{
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}

		return dp[s1.length()][s2.length()];
	}
}
