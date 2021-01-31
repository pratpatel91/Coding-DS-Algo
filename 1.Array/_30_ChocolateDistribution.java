import java.util.Scanner;
//ADHOC PROBLEM: Uses math (doesnt use algorithms)
public class _30_ChocolateDistribution
{
	public static void main(String[] args)
	{
		int[] array = { 3, 4, 1, 9, 56, 7, 9, 12 };
		printArray(array);
		bubbleSortArray(array);
		printArray(array);

		// taking user input
		Scanner input = new Scanner(System.in);
		int students = input.nextInt();

		System.out.println(optimizedGetChocolateDistribution(array, students));
	}
	//TC=O(n) SC=O(1) due to no aux data structures created
	public static int optimizedGetChocolateDistribution(int[] array, int students)
	{
		int minDiff = Integer.MAX_VALUE;
		int currentDiff = 0;

		if (students == array.length)
		{
			minDiff = array[array.length - 1] - array[0];
		}

		// i ranges from 0 to (array.length-1)-students
		for (int i = 0; i <= array.length - students; i++)
		{
			// array[5]-array[0]
			// array[6]-array[1]
			// array[students+i] allows us to control the offset
			currentDiff = array[students + i - 1] - array[i];

			// updating the currentDiff (inside the for loop)
			if (currentDiff <= minDiff)
			{
				minDiff = currentDiff;
			}
		}

		// min Diff is only updated once here which is wrong
//		//updating the currentDiff
//		if(currentDiff<=minDiff)
//		{
//			minDiff=currentDiff;
//		}

		return minDiff;

	}

	// TC=O(n^2)
	public static void bubbleSortArray(int[] array)
	{
		for (int i = 0; i <= array.length - 1; i++)
		{
			for (int j = i + 1; j <= array.length - 1; j++)
			{
				int temp = 0;

				if (array[i] > array[j])
				{
					// swapping logic
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	public static void printArray(int[] array)
	{
		for (int i = 0; i <= array.length - 1; i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.print("\n");
	}

}
