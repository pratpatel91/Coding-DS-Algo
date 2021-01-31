import java.util.HashMap;

public class _13_PrintAllSubArraysWithZeroSum
{

	public static void main(String[] args)
	{
		int[] array = { 6, -1, -3, 4, -2, 2, 4, 6, -12, -7 }; //sum = 6,5,2,6,4,6,10,16,4,-3
		bruteForce_printallSubarraysWithZeroSums(array);
		optimized_printallSubarraysWithZeroSums(array);
	}
	//TC=O(n^2) SC=O(1)
	public static void bruteForce_printallSubarraysWithZeroSums(int[] array)
	{
		int zeroSubArrayCount = 0;

		for (int i = 0; i <= array.length - 1; i++)
		{
			int sumOfSubArrays = array[i];

			// individual elements are also sub arrays
			if (array[i] == 0)
			{
				zeroSubArrayCount++;
				// System.out.println("Subarray: [" + i + "]");

			}
			for (int j = i + 1; j <= array.length - 1; j++)
			{
				sumOfSubArrays += array[j];

				if (sumOfSubArrays == 0)
				{
					// System.out.println("Subarray: [" + i + " t0 " + j + "]");
					zeroSubArrayCount++;
				}
			}
		}
		System.out.println("Subarrays with Zero Sum:" + zeroSubArrayCount);
	}
	//TC=O(n) SC=O(n) due to creating a map which stores n values in worst case
	//Optimization because we have a sum value thats repeating which indicates
	//that we have a zero sum therefore we dont need to blindly calculate every single
	//sum to find the zero subarrays
	public static void optimized_printallSubarraysWithZeroSums(int[] array)
	{
		int zeroSubArrayCount = 0;

		// creating a hashmap (hash the current sum)
		// RHS is the interface part which needs data types to be specified
		//hashmap can handle negative values (hash arrays couldnt handle negative values)
		HashMap<Integer, Integer> hash_ArraySum = new HashMap<>();

		int currentArraySum = 0;

		for (int i = 0; i <= array.length - 1; i++)
		{
			currentArraySum += array[i];

			if (currentArraySum == 0)
			{
				zeroSubArrayCount++;
			}

			// if the key exists then give it a freq of 2
			System.out.println(" key:" + currentArraySum + ", isKeyPresent:" + hash_ArraySum.containsKey(currentArraySum));
			if (hash_ArraySum.containsKey(currentArraySum))
			{
				int value = hash_ArraySum.get(currentArraySum);
				System.out.println("key:" + currentArraySum + ", old value:" + value);
				zeroSubArrayCount += value;
				hash_ArraySum.put(currentArraySum, value + 1);
				System.out.println("key:" + currentArraySum + ", new value:" + (value+1));
			}
			// if the key doesnt exist then give it a freq of 1
			else
			{
				System.out.println("key not found in hm hence the value is 0");
				hash_ArraySum.put(currentArraySum, 1);
			}
		}
		System.out.println("Subarrays with Zero Sum:" + zeroSubArrayCount);
	}
}
