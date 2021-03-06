
public class _20_SubarrayWithSumOfZero
{
	public static void main(String[] args)
	{
		int[] array = { 4, -2, 3, -1, 0 };
		// subArrayWithZeroSum(array);
		naiveSubArrayWithZeroSum(array);
	}

	// Brute Force TC=O(n^2)
	public static void naiveSubArrayWithZeroSum(int[] array)
	{
		boolean isSubArrayWithZeroSumTrue = false;

		for (int i = 0; i <= array.length - 1; i++)
		{
			int sum = 0;

			for (int j = i; j <= array.length - 1; j++)
			{
				sum = sum + array[j];

				if (sum == 0)
				{
					isSubArrayWithZeroSumTrue = true;
					System.out.println("Subarray with zero sum exists");
					break;
				}
				System.out.println("Sum: " + sum);
			}
			//breaks the outer for loop
			if (isSubArrayWithZeroSumTrue == true) //same condition as the inner for loop
			{
				System.out.println("Breaking the outer for loop");
				break;
			}
		}

		if (isSubArrayWithZeroSumTrue == false)
		{
			System.out.println("Subarray with zero sum doesnt exists");
		}

	}

	public static void subArrayWithZeroSum(int[] array)
	{
		// hashing to know if same value is encountered
		int[] hashArray = new int[10000000];

		int sum = 0;
		boolean isSubArrayWithZeroSumTrue = false; // assignment uses =

		for (int i = 0; i <= array.length - 1; i++)
		{
			sum += array[i];
			if (sum == 0 || array[i] == 0 || hashArray[sum] == 1)
			{
				System.out.println("Subarray with zero sum exists");
				isSubArrayWithZeroSumTrue = true;// assignment uses =
				break;
			}
			// sum is visited
			hashArray[sum] = 1;
		}
		if (isSubArrayWithZeroSumTrue == false) // checking uses ==
		{
			System.out.println("Subarray with zero sum doesnt exists");
		}
		// checking to see if the sum is zero
	}
}
