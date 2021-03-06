
public class _29_TrappingRainWater
{

	public static void main(String[] args)
	{
		int[] array = { 3, 0, 0, 2, 0, 4 };
		// bruteForceMaxWaterCollected(array);
		// betterMaxWaterCollected(array);
		bestMaxWaterCollected(array);
	}

	public static void bestMaxWaterCollected(int[] array)
	{
		// Two pointers approach(initializing)
		int start_index = 0;
		int end_index = array.length - 1;

		int maxLeft = 0;
		int maxRight = 0;
		int maxWaterCollected = 0; //scope allows us to print after the
		                           //while loop

		while (start_index <= end_index)
		{
			// moving the start index from left(start) to right(end)
			if (array[start_index] <= array[end_index])
			{
				if (array[start_index] > maxLeft)
				{
					maxLeft = array[start_index];
				} else // (array[start_index] <=maxLeft)
				{
					maxWaterCollected += maxLeft - array[start_index];
				}

				// update 1 of the 2 pointers
				start_index++;
			}
			// moving the end index from right(end) to left(start)
			//else if (array[start_index] > array[end_index]) creates a infinite loop
			else if (array[start_index] > array[end_index])
			{
				if (array[end_index] > maxRight)
				{
					maxRight = array[end_index];
				} else // (array[end_index] <= maxRight)
				{
					maxWaterCollected += maxRight - array[end_index];
				}

				// update the 2nd pointers
				end_index--;
			}
		}
		System.out.println(maxWaterCollected);
		
	}

	public static void betterMaxWaterCollected(int[] array)
	{
		// for loop to find maxLeft per each element
		// for loop start from i=1 so that we can calculate
		// maxL at index=0

		// creating an empty array
		int[] maxLeft = new int[array.length];

		// assumed that that first element is maxLeft at index=0
		maxLeft[0] = array[0];

		for (int i = 1; i <= array.length - 1; i++)
		{
			// comparing element before current with current element
			// in order to update maxLeft
			maxLeft[i] = max(maxLeft[i - 1], array[i]);
		}

		// for loop to find maxRight per each element

		// creating an empty array
		int[] maxRight = new int[array.length];

		// assumed that that first element is maxLeft at index=0
		maxRight[array.length - 1] = array[array.length - 1];

		for (int i = array.length - 2; i >= 0; i--)
		{
			// comparing element after current with current element
			// in order to update maxLeft
			maxRight[i] = max(maxRight[i + 1], array[i]);
		}

		// for loop to traverse each element to calculate the
		// accumulated watercollected
		// starting from i=0 because we want to compare the min
		// of maxL & maxR against all the elements in the array

		int waterCollected = 0; // scope allows us to print it
		// after the for loop
		for (int i = 0; i <= array.length - 1; i++)
		{
			waterCollected += min(maxLeft[i], maxRight[i]) - array[i];
		}

		// displaying the answer after the for loop
		System.out.println(waterCollected);
	}

	public static void bruteForceMaxWaterCollected(int[] array)
	{
		// due to tracking 2 values per each element(current value, minLeft) &
		// (current value,maxRight) we had to use a nested for loop

		// the outer for loop start from i=1 so that we can calculate
		// maxL at index=0

		int waterCollected = 0; // scope allows us to print it
								// after the for loop

		for (int i = 1; i <= array.length - 1; i++)
		{
			int maxLeft = array[i];

			// for loop handles updating maxLeft per each element
			// for(int j=i-1; j>=0 ; j--)
			for (int j = 0; j < i; j++)
			{
				// comparing left element with current element
				// in order to update maxLeft
				maxLeft = max(maxLeft, array[j]);
			}

			int maxRight = array[i];

			// for loop handles updating maxRight per each element
			for (int j = i + 1; j <= array.length - 1; j++)
			{
				// comparing right element with current element
				// in order to update maxRight
				maxRight = max(maxRight, array[j]);

			}
			System.out.println("maxL:" + maxLeft + ", maxR:" + maxRight + ", curr:" + array[i]);

			// updating the waterCollected per each element
			waterCollected += min(maxRight, maxLeft) - array[i];
		}

		// displaying the answer after the for loop
		System.out.println(waterCollected);
	}

	public static int min(int a, int b)
	{
		if (a > b)
		{
			return b;
		}
		return a;
	}

	public static int max(int a, int b)
	{
		if (a > b)
		{
			return a;
		}
		return b;
	}

}
