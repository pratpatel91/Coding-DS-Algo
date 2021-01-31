public class _30_BinarySearch_PaintersPartition
{
	public static void main(String[] args)
	{
		int requiredPainters = 2; // K
		int boards = 4; // N
		int[] array = { 10, 20, 30, 40 };
		bs_paintersPartitionForMinTime(array, requiredPainters);
	}

	public static void bs_paintersPartitionForMinTime(int[] array, int requiredPainters)
	{
		int minPaintingTime = Integer.MAX_VALUE;

		// binary search initialization
		int left = arrayMax(array);
		int right = arraySum(array);

		// basic binary search
		while (left <= right)
		{
			int mid = (left + right) / 2;
			System.out.println("left:" + left + ", mid:" + mid + ", right:" + right);
			
			// core logic for painters partioning
			int neededPainters = numberOfPainters(array, mid);

			if (neededPainters > requiredPainters)
			{
				left = mid + 1;
			} else
			{
				minPaintingTime = mid; // after 1st solution is found, keep minimizing paint time
				right = mid - 1;
			}
		}
		System.out.println(minPaintingTime);
	}

	public static int numberOfPainters(int[] array, int mid)
	{
		int sumTime = 0;
		int numPainters = 1;

		for (int i = 0; i <= array.length - 1; i++)
		{
			sumTime += array[i];

			if (sumTime > mid)
			{
				sumTime = array[i];
				numPainters++;
			}
		}
		return numPainters;
	}

	public static int arrayMax(int[] array)
	{
		int max = Integer.MIN_VALUE;

		for (int i = 0; i <= array.length - 1; i++)
		{
			if (array[i] > max)
			{
				max = array[i];
			}
		}
		return max;
	}

	public static int arraySum(int[] array)
	{
		int sum = 0;

		for (int i = 0; i <= array.length - 1; i++)
		{
			sum = sum + array[i];
		}
		return sum;
	}
}
