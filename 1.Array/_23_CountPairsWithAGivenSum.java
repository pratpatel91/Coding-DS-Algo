
public class _23_CountPairsWithAGivenSum
{

	public static void main(String[] args)
	{
		int[] array = { 1, 2, 3, 4 };
		int sum = 3;
		// bruteForcegetCountOfSumPairs(array, sum);
		optimizedCountOfSumPairs(array, sum);
	}

	// TC=O(n^2) SC=O(1)
	public static void bruteForceCountOfSumPairs(int[] array, int sum)
	{
		int sumPairs = 0;

		// Consider all possible pairs and check their sums
		for (int i = 0; i <= array.length - 1; i++)
		{
			for (int j = i + 1; j <= array.length - 1; j++)
			{
				if ((array[i] + array[j]) == sum)
				{
					System.out.println("Pair: " + "(" + array[i] + " " + array[j] + ")");
					sumPairs++;
				}
			}
		}
		System.out.printf("SumPairs: " + sumPairs);
	}

	// TC=O(n) SC=O(n) created aux hash array
	public static void optimizedCountOfSumPairs(int[] array, int sum)
	{
		// 1.creating the hash of array
		int[] hashArray = new int[1000000]; // MIN SIZE=array[max]+1 ; 10^6 was chosen randomly

		// 2.Traverse the original array in the for loop
		for (int i = 0; i < array.length; i++)
		{
			// 3.Within the for loop we want to update the hash arrays elements
			// such that we update the frequencies of the elements
			// ++ indicates that we are adding frequences to the hasharray full of zeroes
			hashArray[array[i]]++;
		}

		// -------------------------------Core
		// Logic------------------------------------//
		int sumPairsWithDuplicates = 0;
		for (int i = 0; i < array.length; i++)
		{
			// a+b = sum
			// a = array[i]
			int b = sum - array[i];

			//b>0 ensures that we are never getting the run time error from accessing - indicies
			if (b>0 && hashArray[b] > 0)
			{
				sumPairsWithDuplicates += hashArray[b];
			}

			// same indicies (0,0) shouldnt be counted as sumPairs
			if (array[i] == b)
			{
				sumPairsWithDuplicates--;
			}
		}
		//dividing by 2 allows us to get uniqueSumPairs
		int sumPairsWithoutDuplicates = sumPairsWithDuplicates / 2;
		System.out.println("SumPairs(Without duplicates): " + sumPairsWithoutDuplicates);
	}

}
