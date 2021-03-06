import java.util.Arrays;

public class _6_FindRepeatingAndMissingElements
{
	public static void main(String[] args)
	{
		int[] array = { 1, 2, 3, 5, 5 };

		// bruteForce_findDuplicatesInArray(array);
		// bruteForce_findMissingInArray(array);
		// mathBetterApproach(array); //weakness: integer overflow
		// indexNegationBestApproach(array);
		hashing_findDuplicatesAndMissingElements(array);
	}

	public static void bruteForce_findDuplicatesInArray(int[] array)
	{
		for (int i = 0; i <= array.length - 1; i++)
		{
			for (int j = i + 1; j <= array.length - 1; j++)
			{
				int currentElement = array[i];
				int nextElement = array[j];
				if (currentElement == nextElement)
				{
					System.out.println("Duplicate Found:" + array[i]);
				}
			}
		}
	}

	// find missing number in array of size
	public static void bruteForce_findMissingInArray(int array[])
	{
		Arrays.sort(array);
		int answer = 0;

		for (int i = 0; i <= array.length - 1; i++)
		{
			int currentElement = array[i];
			if (currentElement != i + 1)
			{
				answer = i + 1;
				break;
			}
		}
		System.out.println("Missing Element:" + answer);
	}

	// https://javarevisited.blogspot.com/2018/04/how-to-find-k-missing-numbers-in-array-java.html#axzz6jxNbS4Ea

	// TC=O(n) SC=O(1) Math Approach
	// Due to the formula being Sum = N(N+1)/2 we know that doing int(N)*int(N) can
	// lead to int overflow

//	public static int sumOfAllNaturalNumbers(int arraySize)
//	{
//		int naturalSum = (arraySize*(arraySize+1))/2;
//		return naturalSum;
//	}
	// https://javahungry.blogspot.com/2018/12/find-the-missing-number-in-an-array.html
	public static void mathBetterApproach(int[] array)
	{
		int N = array.length;
		int naturalSum = (N * (N + 1)) / 2; // 1,2,3,4,5
		int naturalSumOfSquares = (N * (N + 1) * (2 * N + 1)) / 6; // 1,2,3,4,5
		System.out.println("Natural Sum:" + naturalSum + ", Sum of Squares:" + naturalSumOfSquares);

		for (int i = 0; i <= N - 1; i++)
		{
			naturalSum -= array[i];
			naturalSumOfSquares -= (array[i] * array[i]);
		}

		System.out.println("Natural Sum:" + naturalSum + ", Sum of Squares:" + naturalSumOfSquares);
		int missingElement = (naturalSum + naturalSumOfSquares) / 2;
		int repeatingElement = missingElement - naturalSum;

		System.out.println("Missing:" + missingElement + ", repeating:" + repeatingElement);

	}

	// TC=O(n) SC=O(1) Negation Approach
	public static void indexNegationBestApproach(int[] array)
	{
		for (int i = 0; i <= array.length - 1; i++)
		{
			int index = Math.abs(array[i]);

			// visiting an index for the first time (we negate it)
			if (array[index - 1] > 0)
			{
				array[index - 1] = -array[index - 1];
			} else // visiting an index for the second time (we undo the negation)
			{
				System.out.println("repeating:" + index);
			}
		}

		for (int i = 0; i <= array.length - 1; i++)
		{
			if (array[i] > 0)
			{
				System.out.println("missing:" + (i + 1));
			}
		}
	}

	// TC=O(n) SC=O(n) Hashing Approach
	public static void hashing_findDuplicatesAndMissingElements(int array[])
	{
		System.out.println(Arrays.toString(array));
		
		int arrayMax = arrayMax(array); // function call
		int[] hashArray = new int[arrayMax + 1];

		// for loop for creating the hash array {0,1,2,1,1}
		for (int i = 0; i <= array.length - 1; i++)
		{
			hashArray[array[i]]++;
		}


		System.out.println(Arrays.toString(hashArray));
		
		System.out.print("\nMissing Elements Using HashArray: ");
		// for loop for print duplicate elements in the hash array
		for (int i = 0; i <= hashArray.length - 1; i++)
		{
			if (i>0 && hashArray[i] == 0) //doesnt display 0 for missing elements
			{
				System.out.print(i + " ");
			}
		}

		System.out.print("\nDuplicate Elements Using HashArray: ");
		// for loop for print duplicate elements in the hash array
		for (int i = 0; i <= hashArray.length - 1; i++)
		{
			if (hashArray[i] == 2)
			{
				System.out.print(i+ " ");
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

}
