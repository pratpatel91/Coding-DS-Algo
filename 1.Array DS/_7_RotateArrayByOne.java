import java.util.Scanner;

public class _7_RotateArrayByOne
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();

		while (T > 0)
		{
			int arrayLength = input.nextInt();

			int[] array = new int[arrayLength];

			for (int i = 0; i <= arrayLength - 1; i++)
			{
				array[i] = input.nextInt();
			}

			// ---------------Algorithm---------------//
			moveRightByOne(array);
			printArray(array);
		}
	}

	// shift array elements to the right by one place
	public static void moveRightByOne(int[] array)
	{
		// 1.storing last element into a new variable
		int last = array[array.length - 1];

		// 2.method for shifting arrays by one
		for (int i = array.length - 1; i >0 ; i--)
		{
			array[i] = array[i - 1];
		}
		// replace first element with the value of last
		array[0] = last;
	}

	public static void printArray(int[] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
		//System.out.println("\n");
	}
}
