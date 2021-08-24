
public class DP_MinPathInMatrix
{
	static int[][]dp = new int[100][100];
	
	public static void main(String[] args)
	{
		// declaration and initialization happen together for hardcoding
		int[][] cost = { { 1, 3, 3, 4 }, 
				         { 2, 1, 6, 1 }, 
				         { 2, 4, 8, 5 }, 
				         { 7, 6, 3, 5 } };

		System.out.println("b_minPath: " + b_minPath(cost, 0, 0));
		System.out.println("b_maxPath: " + b_maxPath(cost, 0, 0));
		
		for(int i=0; i<dp.length;i++)
		{
			for(int j=0; j<dp[0].length;j++)
			{
				dp[i][j]=-1;
			}
		}
		
		System.out.println("memo_minPath: " + memo_minPath(cost, 0, 0));
		System.out.println("tab_minPath: " + tab_minPath(cost, cost.length, cost[0].length));
		System.out.println("space Optimized minPath: " + spaceOptimizedTab_minPath(cost, cost.length, cost[0].length));
	}

	public static int b_minPath(int[][] cost, int row, int col)
	{
		// outside of the matrix
		if (row >= cost.length || col >= cost[0].length)
		{
			//System.out.println("row: " + row + ", col: " + col);
			return Integer.MAX_VALUE; //optimizing for min so initialized with max
		}
		// to reach the end we need to have AND condition (OR is a logic flaw)
		if (row == cost.length - 1 && col == cost[0].length - 1)
		{
			return cost[row][col];
		}
			int minCost = Math.min(b_minPath(cost, row + 1, col),
					Math.min(b_minPath(cost, row, col + 1), b_minPath(cost, row + 1, col + 1)));
			//System.out.println("currCost: "+ cost[row][col] + ", minCost: " + minCost);
			return cost[row][col] + minCost;
	}

	//Variation: Used Math.max instead of Math.min
	public static int b_maxPath(int[][] cost, int row, int col)
	{
		// outside of the matrix
		if (row >= cost.length || col >= cost[0].length)
		{
			//System.out.println("row: " + row + ", col: " + col);
			return Integer.MIN_VALUE; //optimizing for max so initialized with min
		}
		// to reach the end we need to have AND condition (OR is a logic flaw)
		if (row == cost.length - 1 && col == cost[0].length - 1)
		{
			return cost[row][col];
		}
			int maxCost = Math.max(b_minPath(cost, row + 1, col),
					Math.max(b_minPath(cost, row, col + 1), b_maxPath(cost, row + 1, col + 1)));
			//System.out.println("currCost: "+ cost[row][col] + ", minCost: " + minCost);
			return cost[row][col] + maxCost;
	}
	
	//memoization
	public static int memo_minPath(int[][] cost, int row, int col)
	{
		//out of bounds (base case)
		if (row >= cost.length || col >= cost[0].length)
		{
			return Integer.MAX_VALUE; //optimizing for min so initialized with max
		}
		//reached the end (base case)
		if (row == cost.length - 1 && col == cost[0].length - 1)
		{
			return cost[row][col];
		}
		if(dp[row][col]!=-1)
		{
			return dp[row][col];
		}
		else
		{
			int maxCost = Math.min(memo_minPath(cost, row + 1, col),
					Math.min(memo_minPath(cost, row, col + 1), memo_minPath(cost, row + 1, col + 1)));
			dp[row][col]=cost[row][col]+maxCost;
			return dp[row][col];
		}
	}
	//tabulation
	public static int tab_minPath(int[][] cost, int row, int col)
	{
		int[][] minCost = new int[row][col];

		for(int i=0; i<row; i++)
		{
			for(int j=0; j< col;j++)
			{
				if(i==0 && j==0)
				{
					minCost[i][j]=cost[i][j]; //cell value is the minCost
				}
				else if(j==0) //fill out the 1st row (col= fixed, row=varying)
				{
					minCost[i][j]=minCost[i-1][j]+cost[i][j];
				}
				else if (i==0) //fill out the 1st col(col= varying, row=fixed)
				{
					minCost[i][j]=minCost[i][j-1]+cost[i][j];
				}
				else //fill out the rest of the dp using recurrence relationship
				{
					minCost[i][j]=Math.min(minCost[i-1][j],Math.min(minCost[i][j-1], minCost[i-1][j-1]))+cost[i][j];
				}			
			}
		}
		return minCost[row-1][col-1];
	}
	
	//SC=O(1)
	public static int spaceOptimizedTab_minPath(int[][] cost, int row, int col)
	{
		//int[][] minCost = new int[row][col]; //no need to create a new matrix to store values

		for(int i=0; i<row; i++)
		{
			for(int j=0; j< col;j++)
			{
				if(i==0 && j==0)
				{
					cost[i][j]=cost[i][j]; //cell value is the minCost
				}
				else if(j==0) //fill out the 1st row (col= fixed, row=varying)
				{
					cost[i][j]=cost[i-1][j]+cost[i][j];
				}
				else if (i==0) //fill out the 1st col(col= varying, row=fixed)
				{
					cost[i][j]=cost[i][j-1]+cost[i][j];
				}
				else //fill out the rest of the dp using recurrence relationship
				{
					cost[i][j]=Math.min(cost[i-1][j],Math.min(cost[i][j-1], cost[i-1][j-1]))+cost[i][j];
				}			
			}
		}
		return cost[row-1][col-1];
	}
	
}
