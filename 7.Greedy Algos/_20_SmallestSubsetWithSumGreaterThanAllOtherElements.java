import java.util.Arrays;

public class _20_SmallestSubsetWithSumGreaterThanAllOtherElements
{

	public static void main(String[] args)
	{
		int[] array = { 4, 4, 4, 4 };

		optimized_minSetWhoseSumIsLargerThanRestOfElements(array);
	}

	public static void optimized_minSetWhoseSumIsLargerThanRestOfElements(int[] array)
	{
		Arrays.sort(array);
		int arraySum = findArraySum(array);
		int targetArraySum = arraySum / 2; // arrays subset sum is compared to rest of elements sum

		int count = 0;
		int subsetSum = 0;

		// picking max values for the subset set sum (which is why the array was sorted)
		for (int i = array.length - 1; i >= 0; i--)
		{
			if (subsetSum <= targetArraySum)
			{
				subsetSum += array[i];
				System.out.println("Subset Element:" + array[i] + ", subsetSum:" + subsetSum);
				count++;
			}
			else // if(subsetSum>targetArraySum)
			{
				break;
			}
		}
		System.out.println("MinSubset:" + count);
	}

	public static int findArraySum(int[] array)
	{
		int sum = 0;

		for (int i = 0; i <= array.length - 1; i++)
		{
			sum += array[i];
		}
		return sum;
	}
}
