import java.util.Arrays;

public class _5_MinAndMaxCostForMaxCandyCoverage
{
	public static void main(String[] args)
	{
		int[] candyCost = { 6, 4, 3, 2, 5, 1 };
		int freeCandies = 2;
		int minCost = 0;
		int maxCost = 0;

		Arrays.sort(candyCost);
		
		int kindsOfCandies =candyCost.length;
		
		for(int i=0; i<kindsOfCandies;i++)
		{
			minCost+=candyCost[i];
			kindsOfCandies-=freeCandies;
		}
		System.out.println("Min Cost:" + minCost);
		
		kindsOfCandies =0;
		for(int i=candyCost.length-1; i>=kindsOfCandies;i--)
		{
			maxCost+=candyCost[i];
			kindsOfCandies+=freeCandies;
		}
		System.out.println("Max Cost:" + maxCost);
		
		
	}

}
