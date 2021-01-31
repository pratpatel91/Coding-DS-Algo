
public class _18_MaxProductSubarray
{
	public static void main(String[] args)
	{
		int[] array = { 6, -3, -10, 0, 2 };
		//printAllSubArraysInNCubed(array);
		//printAllSubArraysInNSquared(array);
		naiveMaxProductSubArray(array);
		//optimizedMaxProductSubArray(array);
	}

	// Brute Force Solution TC=O(n^2) SC=O(1)
	public static void naiveMaxProductSubArray(int[] array)
	{
		// 1.assuming that the answer is the first element of the array
		//we want to maximize the answer so we set it to -infinity in order to update it
		int maxSubArraySum = Integer.MIN_VALUE;

		// a.length-1 is written in order to acces the last element 
		
		//for(int i=0, i<array.length; i++);
		for (int i = 0; i <= array.length - 1; i++)
		{
			//int currentProduct = 1st element;
			int currentSubArraySum = array[i];

			//for (int j = i; j <= array.length - 1; j++)
			for (int j = i+1; j <= array.length - 1; j++)
			{
				
				currentSubArraySum = array[j] * currentSubArraySum;
				maxSubArraySum = max(maxSubArraySum, currentSubArraySum);
			}
		}

		System.out.println("Max Product Sub Array: " + maxSubArraySum);
	}
	// { 6, -3, -10, 0, 2 };
	public static void printAllSubArraysInNSquared(int[] array)
	{
		for (int i = 0; i <= array.length - 1; i++)
		{
			for (int j = i ; j <= array.length - 1; j++)
			{
				// going from i till j
//				for (int k = i; k <= j; k++)
//				{
//					System.out.print(array[k] + " ");
//				}
				System.out.print(array[j] + " ");
			}
			System.out.println("");
		}
	}
	
	public static void printAllSubArraysInNCubed(int[] array)
	{
		for (int i = 0; i <= array.length - 1; i++)
		{
			for (int j = i + 1; j <= array.length - 1; j++)
			{
				// going from i till j
				for (int k = i; k <= j; k++)
				{
					System.out.print(array[k] + " ");
				}
				System.out.println("");
			}
		}
	}

	public static void optimizedMaxProductSubArray(int[] array)
	{
		// 1.Initialize min,max and answer to be the first element
		int minProduct = array[0];
		int maxProduct = array[0];
		// System.out.println("Max Product: " + maxProduct);
		// System.out.println("Min Product: " + minProduct); = array[0];
		int maxSubArraySum = array[0];

		// 2.for loop to traverse the array
		// min sub array can be a single element so we are checking from i=1
		// TC=O(n), SC=O(1) due to no aux arrays created
		for (int i = 1; i <= array.length - 1; i++)
		{
			// swapping min,max values when encountering a negative element
			if (array[i] < 0)
			{
				// swap(maxProduct, minProduct);
				// Pass By Values (Changes dont get reflected into variables)
//				System.out.println("->Max Product: " + maxProduct);
//				System.out.println("->Min Product: " + minProduct);

				// swapping function
				int temp = maxProduct;
				maxProduct = minProduct;
				minProduct = temp;
//				System.out.println("-->Max Product: " + maxProduct);
//				System.out.println("-->Min Product: " + minProduct);
			}

			// similiar to kadanes algorithm
			maxProduct = max(maxProduct * array[i], array[i]);
			// incase if multiplication of negative numbers gives max product
			// to update in the next iteration of the for loop
			minProduct = min(minProduct * array[i], array[i]);
			maxSubArraySum = max(maxSubArraySum, maxProduct);
			// System.out.println("Max Product Sub Array: " + answer);
			// System.out.println("Max Product: " + maxProduct);
			// System.out.println("Min Product: " + minProduct);
		}

		System.out.println("Max Product Sub Array: " + maxSubArraySum);
	}

	// Pass By Values
//	public static void swap(int a, int b)
//	{
////		System.out.println("----------Before Swapping-----------");
////		System.out.println("Max Product: " + a);
////		System.out.println("Min Product: " + b);
//
//		int temp = a;
//		a = b;
//		b = temp;
//
////		System.out.println("----------After Swapping-----------");
////		System.out.println("Max Product: " + a);
////		System.out.println("Min Product: " + b);
//	}

	public static int max(int a, int b)
	{
		if (a > b)
		{
			return a;
		}
		return b;
	}

	public static int min(int a, int b)
	{
		if (a < b)
		{
			return a;
		}
		return b;
	}
}
