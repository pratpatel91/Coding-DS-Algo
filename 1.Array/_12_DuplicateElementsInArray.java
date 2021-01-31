public class _12_DuplicateElementsInArray
{

	public static void main(String[] args)
	{
		int[] array = { 1, 3, 4, 2, 2 };
		findDuplicatesUsingBruteForce(array); // function call
		findDuplicatesUsingHashArray(array); // function call
		System.out.println(findDuplicatesUsingNegation(array));
	}

	// Brute Force:
	// TC=O(n^2) due to nested for loops
	// SC=O(1) due to no aux data structure
	public static void findDuplicatesUsingBruteForce(int array[])
	{
		int arraySize = array.length - 1;

		System.out.print("\nDuplicate Elements Using BruteForce: ");

		for (int i = 0; i <= arraySize; i++)
		{
			for (int j = i + 1; j <= arraySize; j++)
			{
				if (array[i] == array[j])
				{
					System.out.print(array[i] + " ");
				}
			}
		}
	}

	// Better Approach (Using Hash Array):
	// TC=O(n) due to having single for loops
	// SC=O(n) due to creating an aux data structure (hash array)
	public static void findDuplicatesUsingHashArray(int array[])
	{
		System.out.print("\nDuplicate Elements Using HashArray: ");
		int arrayMax = arrayMax(array); // function call
		int[] hashArray = new int[arrayMax + 1];

		// for loop for creating the hash array {0,1,2,1,1}
		for (int i = 0; i <= array.length - 1; i++)
		{
			hashArray[array[i]]++;
		}

		// for loop for print duplicate elements in the hash array
		for (int i = 0; i <= hashArray.length - 1; i++)
		{
			if (hashArray[i] == 2)
			{
				System.out.println(hashArray[i] + " ");
			}
		}
	}

	public static int arrayMax(int[] array)
	{
		int arrayMax = Integer.MIN_VALUE;

		for (int i = 0; i <= array.length - 1; i++)
		{
			if (array[i] > arrayMax)
			{
				arrayMax = array[i];
			}
		}
		return arrayMax;
	}

	// Best Approach: TC=O(n), SC=O(1) using negation trick for duplicate problems
	public static int findDuplicatesUsingNegation(int array[])
	{
		int duplicate = 0;
		
		// 1.Traverse the array elements (negating indicies based on values)
		for (int i = 0; i <= array.length - 1; i++)
		{
			// using absolute value because array indicies are always positive
			if (array[abs(array[i])] > 0)
			{
				array[abs(array[i])] = -array[abs(array[i])]; // negation part
			}
			else
			{
				duplicate =array[i];
			}
		}

		return abs(duplicate);
	}

	public static int abs(int value)
	{
		if (value < 0)
		{
			return -value;
		}
		return value;
	}

}
