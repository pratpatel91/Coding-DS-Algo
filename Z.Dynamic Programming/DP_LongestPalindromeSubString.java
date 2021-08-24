public class DP_LongestPalindromeSubString
{
	public static void main(String[] args)
	{
		String s = "babab";
		System.out.println("tab_LPS()=" + tab_LPS(s));
	}

	public static String tab_LPS(String s)
	{
		boolean[][] dp = new boolean[s.length()][s.length()];

		//Compares 1-2 length only
		for (int i = 0; i < dp.length; i++)
		{
			// filled diagonals with true (single char = palindrome of length=1)
			dp[i][i] = true;

			// i<dp.length-1 avoids index out of bounds due to doing i+1
			// i+1= dp.length-1+1 = dp.length
			if (i < dp.length - 1 && s.charAt(i) == s.charAt(i + 1))
			{
				dp[i][i + 1] = true;
			}

		}
		//Compares 3-rest of length
		for (int st = s.length()-3; st >=0; st--)
		{
			for (int ed = st+2; ed < s.length(); ed++)
			{
				if(s.charAt(st)==s.charAt(ed))
				{
					dp[st][ed]=dp[st+1][ed-1]; //true for downward diagonals
				}
				else
				{
					dp[st][ed]=false;
				}
			}
		}
		
		// print matrix
		for (int row = 0; row < s.length(); row++)
		{
			for (int col = 0; col < s.length(); col++)
			{
				System.out.print(dp[row][col] + " ");
			}
			System.out.println();
		}
		
		int maxLPSLength = Integer.MIN_VALUE;
		int start = -1;
		int end = -1;

		for (int row = 0; row < s.length(); row++)
		{
			for (int col = row; col < s.length(); col++)
			{
				if (dp[row][col] == true && col - row + 1 > maxLPSLength)
				{
					maxLPSLength = col - row + 1;
					start =row;
					end = maxLPSLength;
					System.out.println("Start:"+start + ", end:"+end);
				}
			}
		}
		return s.substring(start, end);
	}

}
