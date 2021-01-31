public class _14_ProductOfOtherNumbers
{
	public static void main(String[] args)
	{
		int[] array = { 10, 2, 4, 0, 6, 9, 3 };
		// bruteForce_sumOfProductsExceptSelfIndex(array);
		optimized_sumOfProductsExceptSelfIndex(array);
	}

	// TC=O(n^2) SC= O(n)
	// A brute force approach would use two loops to multiply the integer at
	// every index by the integer at every nestedIndex, unless index == nestedIndex.
	public static void bruteForce_sumOfProductsExceptSelfIndex(int[] array)
	{
		int[] answerArray = new int[array.length];

		for (int i = 0; i <= array.length - 1; i++)
		{
			int elementsSumOfProduct = 1;

			for (int j = 0; j <= array.length - 1; j++)
			{
				// if the indexes dont match
				if (i != j)
				{
					// then the current element to the sum of Products
					elementsSumOfProduct *= array[j];
				}
				System.out.println("i,j: " + i + "," + j);
			}
			// storing the sumOfProducts back into the current index
			answerArray[i] = elementsSumOfProduct;
		}
		printArray(answerArray);
	}

	public static void printArray(int[] array)
	{
		for (int i = 0; i <= array.length - 1; i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}

	// 24=2*3*4
	// 12=1*3*4
	// 8=1*2*4
	// 6=1*2*3
	// we need to optimize this by getting rid of doing the same multiplications
	// TC=O(n) SC= O(1)
	public static void optimized_sumOfProductsExceptSelfIndex(int[] array)
	{
		printArray(array);

		int totalSumOfProduct = 1;

		int zeroElements = 0;
		// compute total product
		for (int i = 0; i <= array.length - 1; i++)
		{
			if (array[i] != 0)
			{ // non zero elements are added to the product
				totalSumOfProduct *= array[i];
			} else if (array[i] == 0)
			{
				zeroElements++;
			}
		}

		// divide total product with current element
		for (int i = 0; i <= array.length - 1; i++)
		{
			if (array[i] == 0 && zeroElements == 1) //case of 1 zero in the array
			{
				array[i] = totalSumOfProduct;
			} else if (zeroElements > 1)//case of 2 zeros in the array
			{
				array[i] = 0;
			} else
			{
				array[i] = totalSumOfProduct / array[i];
			}
		}
		printArray(array);
	}
}
