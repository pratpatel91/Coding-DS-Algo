
public class DP_LongestPalindromeSubsequence
{
	static int[][] dp = new int[10][10];

	public static void main(String[] args)
	{
		String s = "ABCDBA";

		System.out.println("lps()=" + lps(s, 0, s.length() - 1));

		for (int i = 0; i < 10; i++)
		{

			for (int j = 0; j < 10; j++)
			{
				dp[i][j] = -1;
			}
		}
		System.out.println("memo_lps()=" + memo_lps(s, 0, s.length() - 1));
		System.out.println("tab_lps()=" + tab_lps(s));
		
		/*------------------------ LPS With Min Char Deletes ---------*/
		/*
		int lps = memo_lps(s, 0, s.length() - 1);
		System.out.println("memo_lps()=" + lps);
		int charToRemove = s.length()-lps;                     //lps+charsToRemove=s.length()
		System.out.println("charToRemove=" + charToRemove);
		System.out.println("tab_lps()=" + tab_lps(s));
		*/
	}

	public static int lps(String s, int left, int right)
	{
		if (left > right)
		{
			return 0;
		}
		if (left == right)
		{
			return 1;
		}
		if (s.charAt(left) == s.charAt(right))
		{
			return 2 + lps(s, left + 1, right - 1);
		}
		else
		{
			return Math.max(lps(s, left + 1, right), lps(s, left, right - 1));
		}
	}

	public static int memo_lps(String s, int left, int right)
	{
		if (left > right)
		{
			return 0;
		}
		if (left == right)
		{
			return 1;
		}
		// --------Memo Core Logic -------//
		if (dp[left][right] == -1)
		{
			if (s.charAt(left) == s.charAt(right))
			{
				// return 2+lps(s,left+1,right-1);
				dp[left][right] = 2 + memo_lps(s, left + 1, right - 1);
				return dp[left][right];
			}
			else
			{
				// return Math.max(lps(s,left+1,right), lps(s,left,right-1));
				dp[left][right] = Math.max(memo_lps(s, left + 1, right), memo_lps(s, left, right - 1));
				return dp[left][right];
			}
		}
		else
		{
			return dp[left][right];
		}
	}

	public static int tab_lps(String s)
	{
		int[][] dp = new int[s.length()][s.length()]; // [7][7]

		for (int i = 0; i < dp.length; i++)
		{
			dp[i][i] = 1; // for a single char the longest palindrome subsequence=1
		}

		// [2-6] string comparision
		//Error in updating last column when i<dp.length only 
		for (int i = 2; i <= dp.length; i++)
		{
			for (int j = 0; j < s.length() - i + 1; j++)
			{
				int start = j;
				int end = j + i - 1;
				if (s.charAt(start) == s.charAt(end) && i == 2)
				{
					dp[start][end] = 2; // lps =2 for 2 matching chars
				}
				else if (s.charAt(start) == s.charAt(end))
				{
					dp[start][end] = dp[start + 1][end - 1] + 2; // updating lps
				}
				else
				{
					dp[start][end] = Math.max(dp[start][end - 1], dp[start + 1][end]);
				}
			}
		}
		// dp printout
		for (int i = 0; i <= dp.length - 1; i++)
		{
			for (int j = 0; j <= dp[0].length - 1; j++)
			{
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}

		return dp[0][s.length() - 1]; // topright most cell is the final answer
	}

}
