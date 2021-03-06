
public class _19_SmallestFactorialWithNTrailingZeroes
{

	public static void main(String[] args)
	{
		int desiredZeroes = 12;// # of trailing zeroes
		System.out.println("Smallest Factorial:"+binarySearch(desiredZeroes));
	}

	public static int binarySearch(int desiredZeroes)
	{
		int low = 1;
		int high = 1000000;// 10^6 > 10^4 limit

		while (low != high)
		{
			int mid = (low + high) / 2;

			if (currentZeroes(mid, desiredZeroes) >= desiredZeroes)
			{
				// searching left side of the array
				high = mid;

			} else if (currentZeroes(mid, desiredZeroes) < desiredZeroes)
			{
				// searching right side of the array
				low = mid + 1;
			}
		}
		return high;
	}

	// solve computes the # of trailing zeroes
	public static int currentZeroes(int mid, int desiredTrailingZeroes)
	{
		int zeroCount = 0;
		// while loop is used because
		// the amount of division by 5 is uncertain to begin with

		while (mid / 5 > 0)
		{
			zeroCount += mid / 5;
			// reduce mid by 1/5 and this makes the TC=O(log5N)
			mid = mid / 5;
		}
		return zeroCount;
	}
}
