//Variation of fibonacci
public class DP_PlacingTiles
{
	//due to 1 varying factor aka stairs (we need a cache array)
	static int[] cacheArray = new int[10000];

	public static void main(String[] args)
	{
		System.out.println("waysToPlaceTiles(4)="+waysToPlaceTiles(4));
		
		populatingCacheArrayForMemoization();
		System.out.println("memoization_waysToPlaceTiles(4)="+memoization_waysToPlaceTiles(4));
		
		System.out.println("tabulation_waysToPlaceTiles(4)="+tabulation_waysToPlaceTiles(4));
	}
	
	// RECURSION TC=O(2^N) SC=O(1)
	public static int waysToPlaceTiles(int columns)
	{
		// base case (to prevent infinite loop in recursion) 
		if(columns < 0)
		{
			return 0;
		}
		
		//base case (ran out of space to place tiles)
		if (columns == 0)
		{
			return 1;
		}

		return waysToPlaceTiles(columns - 1) + waysToPlaceTiles(columns - 2);
	}
	
	//----------------To Do on June3
	//Add memoization
	
	public static void populatingCacheArrayForMemoization()
	{
		for (int i = 0; i < cacheArray.length; i++)
		{
			cacheArray[i] = -1;
		}
	}
	
	public static int memoization_waysToPlaceTiles(int columns)
	{
		//1.Base cases are the same as the recursive function
		if (columns < 0)
		{
			return 0;
		}

		//1.1base case (ran out of space to place tiles)
		if (columns == 0)
		{
			return 1;
		}
		
		//2.Memorization logic
		if(cacheArray[columns]==-1)
		{
			//2.1 storing the recurrence relationship into a variable to return
			int result = memoization_waysToPlaceTiles(columns-1)+memoization_waysToPlaceTiles(columns-2);
			return result;
		}
		else
		{  	//3.returning last element in the cacheArray
			return cacheArray[columns];
		}
	}
	
	//Add tabulation
	public static int tabulation_waysToPlaceTiles(int columns)
	{
		// base case (to prevent infinite loop in recursion) 
		if(columns < 0)
		{
			return 0;
		}
		
		//base case (ran out of space to place tiles)
		if (columns == 0)
		{
			return 1;
		}
		
		cacheArray[0]=0; //base case
		cacheArray[1]=1;
		cacheArray[2]=2;
		cacheArray[3]=4;
		
		for(int i=4; i<=columns; i++)
		{
			cacheArray[i]=cacheArray[i-1]+cacheArray[i-2]+cacheArray[i-3];
		}
		
		//4.returning last element in the cacheArray
		return cacheArray[columns];
		
	}
	
	
	
	
	
	
}
