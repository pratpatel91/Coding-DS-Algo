import java.util.Arrays;

public class _30_SmallestNumber
{
	public static void main(String[] args)
	{
		int sum = 92;
		int digits = 27;
		greedy_smallestDigitsThatMeetSum(sum, digits);
	}

	public static void greedy_smallestDigitsThatMeetSum(int sum, int digits)
	{
		if (sum > digits * 9)
		{
			System.out.println("Digit Combo isnt possible to meet the sum");
			return;
		}
		if (sum == 0)
		{
			if (digits == 1)
			{
				System.out.println("0");
				return;
			}
			else
			{
				System.out.println("Digit Combo isnt possible to meet the sum");
				return;
			}
		}

		int[] minNums = new int[digits]; // handling trailing zeroes as default values
		System.out.println(Arrays.toString(minNums));
		sum--;

		// populate from the units place (aka back of array)
		for (int i = minNums.length-1; i >= 0; i--)
		{
			if (sum > 9)
			{
				minNums[i] = 9;
				sum = sum - 9;
			}
			else //handles inbetween zeroes
			{
				minNums[i] = sum;
				break;
			}
		}
		System.out.println(Arrays.toString(minNums));

		// most sig place is set to 1
		minNums[0] = 1;

		System.out.println(Arrays.toString(minNums));
	}

}
