
import java.util.Arrays;

public class quickSortAlgorithm
{
	public static void main(String[] args)
	{
		int[] inputArray = { 2, 4, 1, 3, 5 };
		quickSort(inputArray);
	}

	public static void quickSort(int[] inputArray)
	{
		partitionArrays(inputArray);
	}

	// partioning arrays
	public static void partitionArrays(int[] inputArray)
	{
		// ---------------1st we divide the arrays-----------------//
		printArray(inputArray);

		int[] leftArray = new int[inputArray.length];
		int[] rightArray = new int[inputArray.length];

		int pivotElement = inputArray[0];

		if (inputArray.length <= 1)
		{
			printArray(inputArray);// empty array or an array with size 1 is already sorted
		} else
		{ // array partioning logic
			for (int i = 1; i <= inputArray.length - 1; i++)
			{
				int currentElement = inputArray[i];

				if (pivotElement >= currentElement)
				{
					leftArray[i] = inputArray[i];
				} else if (pivotElement < currentElement)
				{
					rightArray[i] = inputArray[i];
				}
			}
		}
		printArray(leftArray);
		printArray(rightArray);

		// ---------------2nd we sort the arrays-----------------//
		Arrays.sort(leftArray);
		Arrays.sort(rightArray);
		printArray(leftArray);
		printArray(rightArray);

		// ---------------3rd we combine the arrays-----------------//
		mergeArrays(leftArray, pivotElement, rightArray);
	}

	public static void mergeArrays(int[] leftArray, int pivot, int[] rightArray)
	{
		int finalArraySize = (leftArray.length + 1 + rightArray.length);
		int[] finalArray = new int[finalArraySize];

		int globalIndex = 0;

		printArray(finalArray);

		// loading the left SubArray into the combined Array
		for (int i = 0; i <= leftArray.length - 1; i++)
		{
			finalArray[globalIndex] = leftArray[i];
			globalIndex++;
		}
		printArray(finalArray);

		// loading the pivot element into the combined Array
		finalArray[globalIndex] = pivot;
		globalIndex++;

		// loading the right SubArray into the combined Array
		for (int i = 0; i <= rightArray.length - 1; i++)
		{
			finalArray[globalIndex] = rightArray[i];
			globalIndex++;
		}
		printArray(finalArray);

		// displaying the final sorted combined array without any zeroes
		printArrayWithoutZeroes(finalArray);
	}

	public static void printArray(int[] array)
	{
		for (int i = 0; i <= array.length - 1; i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}

	public static void printArrayWithoutZeroes(int[] array)
	{
		for (int i = 0; i <= array.length - 1; i++)
		{
			if (array[i] != 0)
			{
				System.out.print(array[i] + " ");
			}
		}
		System.out.println("");
	}
}
