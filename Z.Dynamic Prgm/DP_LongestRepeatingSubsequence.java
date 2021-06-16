public class DP_LongestRepeatingSubsequence
{
	public static void main(String[] args)
	{
		String s = "axxxy";
		System.out.println("lRS(axxxy)=" + lRS(s, s.length(), s.length()));
		System.out.println("memo_lRS(axxxy)=" + memo_lRS(s, s.length(), s.length()));
		System.out.println("tab_lRS(axxxy)=" + tab_lRS(s, s.length(), s.length()));
	}

	// TC=O(2^N) SC=O(N)
	public static int lRS(String s, int i, int j)
	{
		// base case
		if (i == 0 || j == 0)
		{
			return 0;
		}
		// In LRS corresponding chars can't have the same index
		if (i != j && s.charAt(i - 1) == s.charAt(j - 1))
		{
			return 1 + lRS(s, i - 1, j - 1); // include i,j and move to the next element
		}
		int excludeLastCharOfI = lRS(s, i, j - 1);
		int excludeLastCharOfJ = lRS(s, i - 1, j);
		// Recurrence relationship
		return Math.max(excludeLastCharOfI, excludeLastCharOfJ);
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

	// TC=O(N^2) due to matrix traversal SC=O(N^2) due to matrix creation
	public static int memo_lRS(String s, int i, int j)
	{
		int[][] dp = new int[i + 1][j + 1];

		populateDPForMemoization(dp, -1);

		// base case
		if (i == 0 || j == 0)
		{
			return 0;
		}

		// In LRS corresponding chars can't have the same index
		if (i != j && s.charAt(i - 1) == s.charAt(j - 1))
		{
			return 1 + memo_lRS(s, i - 1, j - 1); // include i,j and move to the next element
		}

		// memoization core logic
		if (dp[i][j] == -1)
		{
			int excludeLastCharOfI = lRS(s, i, j - 1);
			int excludeLastCharOfJ = lRS(s, i - 1, j);
			// Recurrence relationship
			int result = Math.max(excludeLastCharOfI, excludeLastCharOfJ);
			dp[i][j] = result;
			return result;
		}
		else
		{
			return dp[i][j];
		}
	}

	// TC=O(N^2) due to matrix traversal SC=O(N^2) due to matrix creation
	public static int tab_lRS(String s, int i, int j)
	{
		int[][] dp = new int[i + 1][j + 1];

		// tabulation core logic
		for (int currI = 1; currI <= i; currI++)
		{
			for (int currJ = 1; currJ <= j; currJ++)
			{
				// base case
				if (currI == 0 || currJ == 0)
				{
					dp[currI][currJ] = 0;
				}
				// In LRS corresponding chars can't have the same index
				if (currI != currJ && s.charAt(currI - 1) == s.charAt(currJ - 1))
				{
					dp[currI][currJ] = 1 + dp[currI - 1][currJ - 1];
				}
				else // Recurrence relationship
				{
					dp[currI][currJ] = Math.max(dp[currI - 1][currJ], dp[currI][currJ - 1]);
				}
			}
		}
		// bottom right cell contains answer
		return dp[i][j];
	}
}
