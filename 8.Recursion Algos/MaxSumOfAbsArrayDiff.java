public class MaxSumOfAbsArrayDiff
{
	static int finalAnswer = 0;

	public static void main(String[] args)
	{
		int[] array = { 1, 2, 4, 8 };
		absArraySumDiff(array);
		bubbleSort(array, 0, array.length - 1);
		genArrayPermutations(array, 0, array.length - 1);
		System.out.println("\n\nMax Sum of Abs Diff of Any Permutations: " + finalAnswer);
	}

	public static int absArraySumDiff(int[] array)
	{
		int sumOfElementDiffs = 0;

		for (int i = 0; i <= array.length - 2; i++)
		{
			int diff = Math.abs(array[i] - array[i + 1]);
			sumOfElementDiffs += diff;
		}

		int lastDiffTerm = Math.abs(array[array.length - 1] - array[0]);

		sumOfElementDiffs = sumOfElementDiffs + lastDiffTerm;

		System.out.println("Arrays Sum of Element Diffs: " + sumOfElementDiffs);

		return sumOfElementDiffs;
	}

	// TC=O(N*N!) due to finding all elements combinations
	public static void genArrayPermutations(int[] array, int cPos, int end)
	{
		// BASE CASE
		if (cPos == end)
		{
			printArray(array);
			int answer = absArraySumDiff(array);

			if (finalAnswer < answer)
			{
				finalAnswer = answer;
			}
		}
		else
		{
			bubbleSort(array, cPos, end);

			for (int i = cPos; i <= end; i++)
			{
				// do
				swap(array, cPos, i);
				// recurr permutation for next position
				genArrayPermutations(array, cPos + 1, end);
				// undo
				swap(array, cPos, i);
			}
		}
	}

	// TC=O(N^2)
	public static void bubbleSort(int[] array, int cPos, int end)
	{
		for (int i = cPos; i <= end - 1; i++)
		{
			for (int j = i + 1; j <= end; j++)
			{
				if (array[i] > array[j])
				{
					swap(array, i, j);
				}
			}
		}
	}

	public static void swap(int[] array, int a, int b)
	{
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	public static void printArray(int[] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
