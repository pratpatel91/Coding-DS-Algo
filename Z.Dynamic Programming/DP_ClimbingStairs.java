//Variation of fibonacci
public class DP_ClimbingStairs
{
	//due to 1 varying factor aka stairs (we need a cache array)
	static int[] cacheArray = new int[10000];
	
	
	public static void main(String[] args)
	{
		System.out.println("waysToClimbStairs(4)=" + waysToClimbStairs(4));
		populatingCacheArrayForMemoization();
		System.out.println("memoization_waysToClimbStairs(4)="+memoization_waysToClimbStairs(4));
		System.out.println("tabulation_waysToClimbStairs(4)="+tabulation_waysToClimbStairs(4));
	}

	public static int waysToClimbStairs(int stairs)
	{
		if (stairs < 0)
		{
			return 0;
		}

		// base case(when we run out of stairs it is considered to be 1 valid way)
		if (stairs == 0)
		{
			return 1;
		}

		return waysToClimbStairs(stairs - 1) + waysToClimbStairs(stairs - 2) + waysToClimbStairs(stairs - 3);
	}

	

	//Add memoization TC=O(N) SC=O(N)
	
	public static void populatingCacheArrayForMemoization()
	{
		for (int i = 0; i < cacheArray.length; i++)
		{
			cacheArray[i] = -1;
		}
	}
	
	public static int memoization_waysToClimbStairs(int stairs)
	{
		//1.Base cases are the same as the recursive function
		if (stairs < 0)
		{
			return 0;
		}

		//1.1Base case(when we run out of stairs it is considered to be 1 valid way)
		if (stairs == 0)
		{
			return 1;
		}
		
		//2.Memorization logic
		if(cacheArray[stairs]==-1)
		{
			//2.1 storing the recurrence relationship into a variable to return
			int result = memoization_waysToClimbStairs(stairs-1)+memoization_waysToClimbStairs(stairs-2);
			return result;
		}
		else
		{  	//3.returning last element in the cacheArray
			return cacheArray[stairs];
		}
	}
	
	
	
	//Add tabulation TC=O(N) SC=O(N)
	public static int tabulation_waysToClimbStairs(int stairs)
	{
		//1.Base case is the same as the recursive function
		if (stairs < 0)
		{
			return 0;
		}

		// base case(when we run out of stairs it is considered to be 1 valid way)
		if (stairs == 0)
		{
			return 1;
		}
		
		//2.bottom up approach(populating starting elements of the cacheArray)
		cacheArray[0]=0; // base case added to the array
		
		cacheArray[1]=1; //handling stairs =1
		cacheArray[2]=2; //handling stairs =2
		cacheArray[3]=4; //handling stairs =3
		 
		
		//3.populating the rest of the cacheArray(using recurrence relation)
		//cacheArray is unnecessarily large (we are only storing till stairs)
		for(int i=4; i<=stairs; i++)
		{
			cacheArray[i]=cacheArray[i-1]+cacheArray[i-2]+cacheArray[i-3];
		}
		
		//4.returning last element in the cacheArray
		return cacheArray[stairs];
	}
}
