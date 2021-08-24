import java.util.Arrays;

public class DP_MaxSumLIS
{

	public static void main(String[] args)
	{
		int[] input = { 1, 101, 2, 3, 100 };
		tabMaxLIS(input);
	}

	public static int tabMaxLIS(int[] input)
	{
		int[] LIS = new int[input.length];

		// base case
		initializeDPForLIS(input, LIS);

		for (int right = 1; right < input.length; right++)
		{
			// increasing order check
			for (int left = 0; left < right; left++)
			{
				System.out.println("left:" + input[left] + ", right:" + input[right] + ", leftLIS:" + LIS[left]
						+ ", rightLIS:" + LIS[right]);
				if (input[right] > input[left] && (LIS[left] + input[right]) > LIS[right])
				{
					System.out.println("Updating LIS Array:" + " leftLIS:" + LIS[left] + ", rightLIS:" + LIS[right]);
					System.out.println("Before Updating LIS: " + Arrays.toString(LIS));
					LIS[right] = LIS[left] + input[right]; // updating with a larger LIS
					System.out.println("After Updating LIS: " + Arrays.toString(LIS));
				}
			}
		}
		int maxLIS = getArrayMax(LIS);
		return maxLIS;
	}

	// ----------------Helper Functions --------------------------------------//
	public static void initializeDPForLIS(int[] array, int[] lis)
	{
		for (int i = 0; i < array.length; i++)
		{
			lis[i] = array[i];
		}
	}

	public static int getArrayMax(int[] array)
	{
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < array.length; i++)
		{
			max = Math.max(max, array[i]);
		}
		return max;
	}
}
