
public class DP_LPSWithMinCharDeletes
{
	static int[][] dp = new int[7][7];

	public static void main(String[] args)
	{
		String s1 = "abcdba";
		int minDeletes = 0; // tracking variable

		System.out.println("lpsMinDeletes(abcdba)=" + lpsMinDeletes(minDeletes, s1, 0, s1.length() - 1));

		for (int i = 0; i < 7; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				dp[i][j] = -1;
			}
		}
		System.out.println("memo_lpsMinDeletes(abcdba)=" + memo_lpsMinDeletes(minDeletes, s1, 0, s1.length() - 1));
		System.out.println("tab_lpsMinDeletes(abcdba)=" + tab_lpsMinDeletes(s1));
	}

	public static int lpsMinDeletes(int minDeletes, String s1, int left, int right)
	{
		// ----------------------------Base cases-----------//
		// left and right are used because its analagous to two pointers for palindrome
		if (left > right)
		{
			return 0;
		}
		if (left == right)
		{
			return 0; //single char is a palindrome
		}
		// --------------Reoccuring subproblems ----------//
		if (s1.charAt(left) == s1.charAt(right))
		{
			return lpsMinDeletes(minDeletes, s1, left + 1, right - 1);
		}
		else
		{
			return 1 + Math.min(lpsMinDeletes(minDeletes, s1, left + 1, right),
					lpsMinDeletes(minDeletes, s1, left, right - 1));
		}
	}

	public static int memo_lpsMinDeletes(int minDeletes, String s1, int left, int right)
	{
		// ----------------------------Base cases-----------//
		// left and right are used because its analagous to two pointers for palindrome
		if (left > right)
		{
			return 0;
		}
		if (left == right)
		{
			return 0;
		}

		if (dp[left][right] == -1)
		{
			// --------------Reoccuring subproblems ----------//
			if (s1.charAt(left) == s1.charAt(right))
			{
				// return lpsMinDeletes(minDeletes, s1, left + 1, right - 1);
				dp[left][right] = memo_lpsMinDeletes(minDeletes, s1, left + 1, right - 1);
				return dp[left][right];
			}
			else
			{
				// return 1 + Math.min(lpsMinDeletes(minDeletes, s1, left + 1, right),
				// lpsMinDeletes(minDeletes, s1, left, right - 1));
				dp[left][right] = 1 + Math.min(memo_lpsMinDeletes(minDeletes, s1, left + 1, right),
						memo_lpsMinDeletes(minDeletes, s1, left, right - 1));
				return dp[left][right];
			}
		}
		else
		{
			return dp[left][right];
		}
	}

	public static int tab_lpsMinDeletes(String s)
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

		return s.length()-dp[0][s.length() - 1]; // topright most cell is the final answer
	}

}
