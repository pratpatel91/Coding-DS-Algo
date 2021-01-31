
public class _31_SmallestSubarrayWithSumGreaterThanX
{

	public static void main(String[] args)
	{
		int[] array = { 1, 4, 45, 6, 0, 19 };
		int sum = 51;
		// bruteForcegetCountOfSumPairs(array, sum);
		 System.out.println(bruteForceSmallestSubarrayLargerThanSum(array, sum));
		//System.out.println(optimizedSmallestSubarrayLargerThanSum(array, sum));

	}

	// TC=O(n) SC=O(1)
	// nested while loops
	public static int optimizedSmallestSubarrayLargerThanSum(int[] array, int sum)
	{
		// initializations
		int currentSum = 0;
		int length = Integer.MAX_VALUE; // we want to minimize this
		int start_index = 0; // starting index
		int i = 0;
		int n = array.length - 1; // size of the array

		while (i <= n)
		{
			// updating current sum
			while (currentSum <= sum && i <= n)
			{
				currentSum += array[i];
				i++;// breaking condition
			}

			while (currentSum > sum && start_index < n)
			{
				//System.out.println("i: "+i +", array[i]: "+array[i]+", array[i-1]: "+array[i-1]);
				System.out.print("start_index: "+start_index + ", array[start_index]: "+ array[start_index]);
				System.out.println(" array[i-1]: "+array[i-1]);
				int cLength = i - start_index;
				
				if (length > cLength)
				{
					length = cLength;
				}
				// csum=csum-array[start_index];
				currentSum -= array[start_index];
				start_index++;
			}
		}
		return length;
	}

	// TC=O(n^2) SC=O(1)
	public static int bruteForceSmallestSubarrayLargerThanSum(int[] array, int sum)
	{
		// we want to minize the length so we set it to the max value
		int length = Integer.MAX_VALUE;
		// int length = 0;
		// int length = Integer.MIN_VALUE;

		// selecting the start
		for (int i = 0; i <= array.length - 1; i++)
		{
			int subArraySum = 0;
			// selecting the end
			for (int j = i + 1; j <= array.length - 1; j++)
			{
				subArraySum += array[j];

				// int currentLength = 0;
				if (subArraySum > sum)
				{
					int currentLength = j - i; // keep the datatype close to the condition
					System.out.println("subArraySum>sum found:" + currentLength);

					// after calculating the currentLength we check the update condition next
					if (currentLength < length)
					{
						length = currentLength;
					}
				}
//	            WILL NOT UPDATE LENGTH SO ITS THE WRONG APPROACH
//				if (currentLength < length)
//				{
//					length = currentLength;
//				}

				// System.out.println();
			}
		}
		return length;
	}

}
