
public class DP_LCSOf3Strings
{
	static // int[s1.length+1][s2.length+1][s3.length+1]
	int[][][] dp = new int[20][20][20]; // tensor=3d array

	public static void main(String[] args)
	{
		String s1 = "geeks";
		String s2 = "geeksfor";
		String s3 = "geeksforgeeks";

		// 1.we are going from top/entire problem(start at i=length) to bottom/atomic
		// broken down problem (i=1)
		System.out.println("lcs_3Strings()=" + lcs_3Strings(s1, s2, s3, s1.length(), s2.length(), s2.length()));

		// fill dp with -1
		for (int i = 0; i < 20; i++)
		{
			for (int j = 0; j < 20; j++)
			{
				for (int k = 0; k < 20; k++)
				{
					dp[i][j][k] = -1;
				}
			}
		}

		// 2.we are going from top/entire problem(start at i=length) to bottom/atomic
		// broken down problem (i=1)
		System.out
				.println("memo_lcs_3Strings()=" + memo_lcs_3Strings(s1, s2, s3, s1.length(), s2.length(), s2.length()));

		// 2.we are going from bottom/atomic broken down problem (i=1) to top/entire
		// problem(start at i=length)
		// excluding arguuments from the tabulated function because we only needed
		// s1.length(), s2.length(), s2.length())
		// information when we were doing any recursion (regular recursion or memoized
		// recursion)
		System.out.println("tab_lcs_3Strings()=" + tab_lcs_3Strings(s1, s2, s3));

	}

	public static int lcs_3Strings(String s1, String s2, String s3, int i, int j, int k)
	{
		// simplest computation/base case
		if (i == 0 || j == 0 || k == 0)
		{
			return 0;
		}

		if (s1.charAt(i - 1) == s2.charAt(j - 1) && s2.charAt(i - 1) == s3.charAt(k - 1))
		{
			// 1+ here means we are accumulating the lcs
			return 1 + lcs_3Strings(s1, s2, s3, i - 1, j - 1, k - 1);
		}
		else
		{
			return Math.max(lcs_3Strings(s1, s2, s3, i - 1, j, k),
					Math.max(lcs_3Strings(s1, s2, s3, i, j - 1, k), lcs_3Strings(s1, s2, s3, i, j, k - 1)));

		}
	}

	public static int memo_lcs_3Strings(String s1, String s2, String s3, int i, int j, int k)
	{
		// simplest computation/base case
		if (i == 0 || j == 0 || k == 0)
		{
			return 0;
		}

		if (dp[i][j][k] == -1) // compute once to store in cache
		{
			if (s1.charAt(i - 1) == s2.charAt(j - 1) && s2.charAt(i - 1) == s3.charAt(k - 1))
			{
				// 1+ here means we are accumulating the lcs
				dp[i][j][k] = 1 + lcs_3Strings(s1, s2, s3, i - 1, j - 1, k - 1);
				return dp[i][j][k];
			}
			else
			{
				dp[i][j][k] = Math.max(lcs_3Strings(s1, s2, s3, i - 1, j, k),
						Math.max(lcs_3Strings(s1, s2, s3, i, j - 1, k), lcs_3Strings(s1, s2, s3, i, j, k - 1)));
				return dp[i][j][k];
			}
		}
		else // return the cached result(dont recompute again)
		{
			return dp[i][j][k];
		}
	}

	public static int tab_lcs_3Strings(String s1, String s2, String s3)
	{
		int[][][] dp = new int[s1.length() + 1][s2.length() + 1][s3.length() + 1]; // now the dp is no longer linked to
																					// recursion

		// nested for loops is simply to populate the cube dp
		//i <= s1.length() compares last char
		for (int i = 0; i <= s1.length(); i++)
		{
			for (int j = 0; j <= s2.length(); j++)
			{
				for (int k = 0; k <= s3.length(); k++)
				{
					// 1.Fill in the dp per the base conditions
					if (i == 0 || j == 0 || k == 0)
					{
						dp[i][j][k] = 0; // no comparison info to store within the dp
					}

					// 2.Fill in the dp per reccurence relationship
					else if (s1.charAt(i - 1) == s2.charAt(j - 1) && s2.charAt(j - 1) == s3.charAt(k - 1))
					{
						// 1+ here means we are accumulating the lcs
						// return 1 + lcs_3Strings(s1, s2, s3, i - 1, j - 1, k - 1);
						dp[i][j][k] = 1 + dp[i - 1][j - 1][k - 1];
					}
					else
					{
						// return Math.max(lcs_3Strings(s1, s2, s3, i - 1, j, k),
						// Math.max(lcs_3Strings(s1, s2, s3, i, j - 1, k), lcs_3Strings(s1, s2, s3, i,
						// j, k - 1)));
						dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
					}
				}
			}
		}
		// return bottom rightmost element of the cube dp (into the cube if the front =
		// visible of the cube)
		// return dp[s1.length()][s2.length()][s3.length()] gives index out of bounds
		// because
		// since all arrays start from 0 means the last element is found via
		// return dp[s1.length()-1][s2.length()-1][s3.length()-1]

		// -------------------Printing the 3d array-------------------------//
		for (int i = 0; i <= s1.length(); i++)
		{
			for (int j = 0; j <= s2.length(); j++)
			{
				for (int k = 0; k <= s3.length(); k++)
				{
					System.out.print(dp[i][j][k] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}

		return dp[s1.length()][s2.length()][s3.length()];

	}

}
