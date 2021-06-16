
public class DP_EqualPartionSum
{
	static boolean[][] dp = new boolean[1000][1000];
	
	public static void main(String[] args)
	{
		int[] array = { 1, 5, 11, 2 };

		int arraySum = 0;

		for (int i = 0; i < array.length; i++)
		{
			arraySum += array[i];
		}
		
		
		for(int i=0; i<dp.length; i++)
		{
			for(int j=0; j<dp[0].length;j++)
			{
				dp[i][j]=false;
			}
		}
		
		
		
		if (arraySum % 2 != 0 || isSubsetSum(arraySum / 2, array, array.length) == false)
		{
			System.out.println("recursive: array cannot be partioned into equal sums");
		}
		else if (isSubsetSum(arraySum / 2, array, array.length) == true)
		{
			System.out.println("recursive: array can be partioned into equal sums");
		}
		
		
		if(arraySum%2==0)
		{
			System.out.println("memo: isSubset partioned? " +memo_isSubsetSum(arraySum/2, array, array.length));
		}
		else
		{
			System.out.println("memo: array can be partioned into equal sums");
		}
		
		if(arraySum%2==0)
		{
			System.out.println("tab: isSubset partioned? " +tab_isSubsetSum(arraySum/2, array, array.length));
		}
		else
		{
			System.out.println("tab: array can be partioned into equal sums");
		}
		

	}
	//TC=O(2^N) SC=O(1)
	public static boolean isSubsetSum(int arraySum, int[] array, int index)
	{
		if(arraySum ==0)
		{
			return true;
		}
		if(arraySum<0 || index==0)
		{
			return false;
		}
		
		//starting from the back of the array
		//include || exclude
		return isSubsetSum(arraySum-array[index-1], array, index-1) || isSubsetSum(arraySum, array, index-1);
	}
	
	//memoized
	public static boolean memo_isSubsetSum(int arraySum, int[] array, int index)
	{
		if(arraySum ==0)
		{
			return true;
		}
		if(arraySum<0 || index==0)
		{
			return false;
		}
		
		if(dp[arraySum][index]==false)
		{
			boolean result =memo_isSubsetSum(arraySum-array[index-1], array, index-1) || memo_isSubsetSum(arraySum, array, index-1);
			dp[arraySum][index]=result;
			return result;
		}
		else
		{
			return dp[arraySum][index];
		}
	}
	
	public static boolean tab_isSubsetSum(int arraySum, int[] array, int index)
	{
		int[][] cache= new int[arraySum+1][index+1];
		
		//variable rows (fixed cols)
		for(int sum=1; sum<=arraySum;sum++)
		{
			dp[sum][0]=false;
		}
		
		//variable columns (fixed rows)
		for(int ele=0; ele<=array.length-1;ele++)
		{
			dp[0][ele]=true;
		}
		
		//skipping row1 and col1 for the matrix
		for(int sum=1; sum<=arraySum; sum++)
		{
			for(int ele=1; ele<=array.length;ele++)
			{
				//excluding current element
				dp[sum][ele]=dp[sum][ele-1];
				
				//including current element
				if(sum>=array[ele-1])
				{
					dp[sum][ele]=dp[sum][ele]||dp[sum-array[ele-1]][ele-1];
				}
			}
		}
		
		return dp[arraySum][array.length];
	}

}
