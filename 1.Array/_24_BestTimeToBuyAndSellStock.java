
public class _24_BestTimeToBuyAndSellStock
{

	public static void main(String[] args)
	{
		int[] array = { 7, 1, 5, 3, 6, 4 };
		System.out.println(dayToSellStockFormaxProfit(array));
	}

	// Kadanes Algorithm (we need to figure out the largest subarray to get max
	// profit)
	public static int dayToSellStockFormaxProfit(int[] array)
	{
		int localMax = 0;
		int globalMax = 0;

		for (int i = 1; i <= array.length - 1; i++)
		{
			localMax = Math.max(0, localMax += array[i] - array[i - 1]);
			
			//resets globalMax
			globalMax = Math.max(localMax, globalMax);
		}
		return globalMax;
	}
}
