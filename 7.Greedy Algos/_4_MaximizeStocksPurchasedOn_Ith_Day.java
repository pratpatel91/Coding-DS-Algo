import java.util.Arrays;

public class _4_MaximizeStocksPurchasedOn_Ith_Day
{
	public static void main(String[] args)
	{
		int[] stockPrices = { 20, 10, 7, 25, 30, 120, 90, 80 }; 
		int limit = 150;
		greedyApproach_findMaxStocks(stockPrices, limit);
	}

	public static void greedyApproach_findMaxStocks(int[] stockPrices, int limit)
	{
		// 1st, we sort the array TC=O(N*logN)
		Arrays.sort(stockPrices);

		int maxStocks = 0; // accumulating variable
		// TC=O(N)
		// traverse the asc sorted array to update maxStocks
		for (int i = 0; i <= stockPrices.length - 1; i++)
		{
			int day = i + 1;
			int currentStockPrice = stockPrices[i];
			//Binding Data prevents nested if else logic 
			if (limit > currentStockPrice)
			{
				int numStocks = limit / currentStockPrice;

				if (numStocks <= day)
				{
					maxStocks += numStocks;
					limit -= (numStocks * currentStockPrice);
				}
				else if (limit >= (day * currentStockPrice))
				{
					maxStocks += day;
					limit -= (day * currentStockPrice);
				}
			}
		}
		System.out.println("Max Stocks:" + maxStocks);
	}
}
