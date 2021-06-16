public class DP_LongestCommonSubSequence
{
	static int[][] cacheMatrix = new int[20][20];

	public static void main(String[] args)
	{
		String s1 = "ABCDGH";
		String s2 = "AEDFHR";

		// populating cache matrix to be -1 so that we know nothing is stored in it
		// nested for loops is for iterating matrix elements to set to -1 (not
		// traversing as thats for processing)
		
		//setting the cache for memoization
		for (int i = 0; i < cacheMatrix.length; i++)
		{
			for (int j = 0; j < cacheMatrix[0].length; j++)
			{
				cacheMatrix[i][j] = -1;
			}
		}

		System.out.println("longest char: " + recursiveLongestCommonSubSequence(s1, s2, s1.length(), s2.length()));
		System.out.println("longest char: " + memoizationLongestCommonSubSequence(s1, s2, s1.length(), s2.length()));

		
		//resetting the cache for tabulation
		for (int i = 0; i < cacheMatrix.length; i++)
		{
			for (int j = 0; j < cacheMatrix[0].length; j++)
			{
				cacheMatrix[i][j] = 0;
			}
		}

		System.out.println("longest char: " + tabulationLongestCommonSubSequence(s1, s2, s1.length(), s2.length()));

	}

	// TC=O(2^N)
	// SC=O(1) ..........internally SC=O(s1.len)-O(s1.len+s2.len)
	public static int recursiveLongestCommonSubSequence(String s1, String s2, int s1Len, int s2Len)
	{
		// function call takes in s1.length so the base case must be s1Len=0
		if (s1Len == 0 || s2Len == 0)
		{
			return 0;
		}

		if (s1.charAt(s1Len - 1) == s2.charAt(s2Len - 1))
		{
			// 1 indicates char match (here 2 things are changing thus we need a cache
			// matrix (not a cache array (which
			// indicates that 1 thing is changing))
			return 1 + recursiveLongestCommonSubSequence(s1, s2, s1Len - 1, s2Len - 1);
		}
		else
		{
			// use exclude pattern (if else condition wont work here)
			return Math.max(recursiveLongestCommonSubSequence(s1, s2, s1Len - 1, s2Len), // excluding last char in s1/
																							// including last char of s2
					recursiveLongestCommonSubSequence(s1, s2, s1Len, s2Len - 1)); // excluding last char in s2/
																					// including last char of s1
		}
	}

	// MEMOIZATION
	// TC=O(s1.len)-O(s1.len*s2.len)
	// SC=O(N^2) due to matrix creation
	public static int memoizationLongestCommonSubSequence(String s1, String s2, int s1Len, int s2Len)
	{
		// copied recursive solution + added cache array
		if (s1Len == 0 || s2Len == 0)
		{
			return 0;
		}

		if (cacheMatrix[s1Len][s2Len] != -1)
		{
			return cacheMatrix[s1Len][s2Len]; // return the processed cache Matrix
		}

		if (s1.charAt(s1Len - 1) == s2.charAt(s2Len - 1))
		{
			// converted recursive into memoized
			// removed return and stored the recursive call into a variable
			// update the cacheMatrix
			// returned longest subsequence till now

			int lcsTillNow = 1 + recursiveLongestCommonSubSequence(s1, s2, s1Len - 1, s2Len - 1);
			cacheMatrix[s1Len][s2Len] = lcsTillNow;
			return lcsTillNow;
		}
		else
		{
			// use exclude pattern (if else condition wont work here)
			int lcsTillNow = Math.max(recursiveLongestCommonSubSequence(s1, s2, s1Len - 1, s2Len), // excluding last
																									// char in s1/
					// including last char of s2
					recursiveLongestCommonSubSequence(s1, s2, s1Len, s2Len - 1)); // excluding last char in s2/
			// including last char of s1
			cacheMatrix[s1Len][s2Len] = lcsTillNow;
			return lcsTillNow;
		}
	}

	// TABULATION
	// TC=O(s1.len)-O(s1.len*s2.len)
	// SC=O(N^2) due to matrix creation
	public static int tabulationLongestCommonSubSequence(String s1, String s2, int s1Len, int s2Len)
	{
		// i<=s1Len instead of i<s1Len in order to store base case info
		for (int currS1Len = 0; currS1Len <= s1Len; currS1Len++)
		{
			for (int currS2Len = 0; currS2Len <= s2Len; currS2Len++)
			{
				// base cases (populating cacheMatrix with Os)
				if (currS1Len == 0 || currS2Len == 0)
				{
					cacheMatrix[currS1Len][currS2Len] = 0;
				}
				else if (s1.charAt(currS1Len-1) == s2.charAt(currS2Len-1))
				{
					cacheMatrix[currS1Len][currS2Len] = cacheMatrix[currS1Len - 1][currS2Len - 1] + 1;
				}
				else
				{
					cacheMatrix[currS1Len][currS2Len] = Math.max(cacheMatrix[currS1Len - 1][currS2Len],
							cacheMatrix[currS1Len][currS2Len - 1]);
				}
			}
		}

		// printing the matrix
		for (int i = 0; i <= s1Len; i++)
		{
			for (int j = 0; j <= s2Len; j++)
			{
				System.out.print(cacheMatrix[i][j] + " ");
			}
			System.out.println();
		}

		return cacheMatrix[s1Len][s2Len]; // bottom right cell contains answer

	}

}
