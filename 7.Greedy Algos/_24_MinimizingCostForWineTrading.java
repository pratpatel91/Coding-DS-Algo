public class _24_MinimizingCostForWineTrading
{
	public static void main(String[] args)
	{
		// - means selling wine
		// + means buying wine
		int[] supplyDemand = { 5, -4, 1, -3, 1 };

		int work = 0;
		int minCost = 0;

		for (int i = 0; i <= supplyDemand.length - 1; i++)
		{
			work += supplyDemand[i];
			minCost += Math.abs(work);
		}
		System.out.println("Min Cost: " + minCost);
	}
}
