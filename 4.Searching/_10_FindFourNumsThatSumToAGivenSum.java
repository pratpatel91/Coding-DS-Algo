
public class _10_FindFourNumsThatSumToAGivenSum
{
	public static void main(String[] args)
	{
		int[] array = { 10, 2, 3, 4, 5, 7, 8 };
		int sum = 23;
		// bruteForce_4Sum(array, sum);
		Optimized_twoPointers_4Sum(array, sum);
	}

	// TC=O(n^4) SC=O(1)
	public static void bruteForce_4Sum(int[] array, int sum)
	{
		System.out.println("Given Sum:" + sum);
		for (int i = 0; i <= array.length - 4; i++)
		{
			for (int j = i + 1; j <= array.length - 3; j++)
			{
				for (int k = j + 1; k <= array.length - 2; k++)
				{
					for (int l = k + 1; l <= array.length - 1; l++)
					{
						if (array[i] + array[j] + array[k] + array[l] == sum)
						{
							System.out.println(
									"Pair found {" + array[i] + "," + array[j] + "," + array[k] + "," + array[l] + "}");
						}
					}
				}
			}
		}
	}

	// TC=O(n^3) SC=O(1)
	public static void Optimized_twoPointers_4Sum(int[] array, int sum)
	{
		// a+b+c+d=sum (constraint)

		boolean terminate = false; // boolean to control breaking the for loops in order to display the 1st pair
									// only

		// outer for loop to iterate the array (array.length - 3 indicates that we are
		// excluding the last 2 elements)
		for (int i = 0; i <= array.length - 3; i++) //TC=O(n)
		{
			int a = array[i];
			for (int j = i + 1; j <= array.length - 2; j++) //TC=O(n)
			{
				int b = array[j];

				// Two Pointers Approach TC=O(n)
				int left = j + 1;
				int right = array.length - 1;
				// due to fixing a and b, a+b+c+d=sum can be rewritten as c+d=sum-(a+b)
				int cd_Sum = sum - (a + b);
				// in a two pointer we dont know ahead of time how many time we have to update
				// pointers
				// which is why a while loop makes sense over a for loop
				while (left < right)// <= is used to handle the case where we have a single element
				{
					// two pointers provides c&d values
					int c = array[left];
					int d = array[right];

					if (c + d == cd_Sum)
					{
						System.out.println("Pair found: {" + a + "," + b + "," + c + "," + d + "}");
						terminate = true;
						break;// displaying the 1st pair only
					} else if (c + d > cd_Sum)
					{
						right--; // shifting right pointer to reduce the cd_Sum such that c+d=cd_Sum
					} else // if(c+d<cd_Sum)
					{
						left++; // shifting left pointer to increase the cd_Sum such that c+d=cd_Sum
					}
				}
				// breaking out of inner for loop (displaying the 1st pair only)
				if (terminate = true)
				{
					break;
				}
			}
			// breaking out of inner for loop (displaying the 1st pair only)
			if (terminate = true)
			{
				break;
			}
		}
	}
	
	
}
