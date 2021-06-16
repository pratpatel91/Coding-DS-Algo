
public class DP_EditDistance
{
	static int[][] dp = new int[100][100];

	public static void main(String[] args)
	{
		String s1 = "pratiksh";
		String s2="pratiksha";
		System.out.println("Edit Distance: " + editDistance(s1, s2, s1.length()-1, s2.length()-1));
		
		//setting dp to be -1
		for(int i=0; i<dp.length;i++)
		{
			for(int j=0; j<dp[0].length;j++)
			{
				dp[i][j]=-1;
			}
		}
		
		System.out.println("Memo Edit Distance: " + memo_editDistance(s1, s2, s1.length()-1, s2.length()-1));
		System.out.println("Tab Edit Distance: " + tab_editDistance(s1, s2, s1.length()-1, s2.length()-1));
	}

	public static int editDistance(String s1, String s2, int s1Pos, int s2Pos)
	{
		//insertion of s1
		if(s1Pos==0)
		{
			return s2Pos;
		}
		//deletion of s1
		if(s2Pos==0)
		{
			return s1Pos;
		}
		
		//if the last chars are matching then move to the next element
		if(s1.charAt(s1Pos-1)==s2.charAt(s2Pos-1))
		{
			return editDistance(s1, s2, s1Pos-1, s2Pos-1);
		}
		
		//if last chars arent matching then we have to do insert or deletion or replacement
		return 1+ Math.min(editDistance(s1, s2, s1Pos, s2Pos-1),
				Math.min(editDistance(s1, s2, s1Pos-1, s2Pos) , editDistance(s1, s2, s1Pos-1, s2Pos-1)));
	}
	
	public static int memo_editDistance(String s1, String s2, int s1Pos, int s2Pos)
	{
		//insertion of s1
		if(s1Pos==0)
		{
			return s2Pos;
		}
		//deletion of s1
		if(s2Pos==0)
		{
			return s1Pos;
		}
		
		
		//if the last chars are matching then move to the next element
		if(s1.charAt(s1Pos-1)==s2.charAt(s2Pos-1))
		{
			return memo_editDistance(s1, s2, s1Pos-1, s2Pos-1);
		}
		
		if(dp[s1Pos][s2Pos]==-1)
		{
			int result = 1+ Math.min(memo_editDistance(s1, s2, s1Pos, s2Pos-1),
					Math.min(memo_editDistance(s1, s2, s1Pos-1, s2Pos) , memo_editDistance(s1, s2, s1Pos-1, s2Pos-1)));
			dp[s1Pos][s2Pos]=result;
			return result;
		}
		else
		{
			return dp[s1Pos][s2Pos];
		}
	}
	
	public static int tab_editDistance(String s1, String s2, int s1Pos, int s2Pos)
	{
		int[][] dp = new int[100][100];
		
		//loop to populate dp matrix
		for(int i=0; i<=s1Pos;i++)
		{
			for(int j=0; j<=s2Pos;j++)
			{
				//control structure is used in order to prevent array out of bounds for the dp
				//first we filled in cells for the base case within the dp
				if(i==0 )
				{
					dp[i][j]=j; //insertion of s1
				}
				else if(j==0)
				{
					dp[i][j]=i; //deletion of s1
				}
				else if (s1.charAt(i-1)==s2.charAt(j-1))
				{
					dp[i][j]=dp[i-1][j-1]; //diagonal values when chars match
				}
				else 
				{
					//third we used the recurrence relationship to fill out the rest of the dp
					dp[i][j]=1+ Math.min(dp[i][j-1],Math.min(dp[i-1][j], dp[i-1][j-1]));
				}
			}
		}
		return dp[s1Pos][s2Pos]; //bottom rightmost cell contains the answer
	}
	
	
	
}
