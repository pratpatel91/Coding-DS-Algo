
public class _15_BishuAndSoldiers
{

	public static void main(String[] args)
	{
		int[] soldiers = { 1, 2, 3, 4, 5, 6, 7 };
		int powerLevel = 10;
		killCountAndSumOfSoldierPower(soldiers,powerLevel);
	}
	//TC was reduced from O(n^2) to O(n) due to calculating prefixSum
	public static void killCountAndSumOfSoldierPower(int[] array, int powerLevel)
	{
		int[] prefixSum = prefixSum(array);

		// computed prefixsum because
		// for repeated queries we want to reduce TC of O(n^2)
		// down to a TC of O(n)
		int answer = 0;

		if (powerLevel >=array.length)
		{
			System.out.println("Killed:"+array.length+", sumOfPower:"+prefixSum[array.length-1]);
		}
		else //if (powerLevel <array.length)
		{
			System.out.println("Killed:"+powerLevel+", sumOfPower:"+prefixSum[powerLevel-1]);
		}

	}

	public static int[] prefixSum(int[] array)
	{
		int[] prefixSum = new int[array.length];

		int accumSum = 0;

		for (int i = 0; i <= array.length-1; i++)
		{
			accumSum += array[i];
			prefixSum[i] = accumSum;
		}
		return prefixSum;
	}

}
