import java.util.Arrays;
import java.util.Scanner;

public class _10_MinimizeHeights
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int K = input.nextInt();
		int N = input.nextInt();

		int[] array = new int[N];

		// takes array from the user
		for (int i = 0; i <= array.length - 1; i++)
		{
			array[i] = input.nextInt();
		}

		// TBD- Switch out with max and min functions
		Arrays.sort(array);

		System.out.println(minimizeMaxMinDiff(array, K, N));

	}

	public static int minimizeMaxMinDiff(int[] array, int K, int N)
	{
		// 1.Find middle value
		int min = array[0];
		int max = array[array.length - 1];
		int middle = (min + max) / 2;

		// 2.logic for adding or subtracting k
		for (int i = 0; i <= array.length - 1; i++)
		{
			if (array[i] >= middle)
			{
				array[i] = array[i] - K;
			} else
			{
				array[i] = array[i] + K;
			}
		}

		Arrays.sort(array);

		min = array[0];
		max = array[array.length - 1];

		int minimizedDiff = max - min;

		return minimizedDiff;
	}
}
