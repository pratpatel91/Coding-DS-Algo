import java.util.Scanner;

public class _2_SortArraysOf_0_1_2s
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

			arraySorter_0_1_2s(array);
		}
	}

	public static void arraySorter_0_1_2s(int[] array)
	{
		// initializing variables
		int low = 0;
		int middle = 0;
		int high = array.length - 1;

		while (middle <= high)
		{
			if (array[middle] == 0)
			{
				swap(array, low, middle);

				low++;
				middle++;
			} else if (array[middle] == 1)
			{
				middle++;
			} else if (array[middle] == 2)
			{
				swap(array, middle, high);

				high--;
			}
		}

		// displaying the array
		for (int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + ", ");
		}

	}

	public static void swap(int[] array, int a, int b)
	{
		System.out.println("Unswapped: a= " + array[a] + ", b= " + array[b]);

		// when a=2, b=2 swapping breaks down since XOR same # ^ same # = 0
		// so we include the if condition to check against that condition
		if (array[a] != array[b])
		{
			// XOR (bit manipulation aka swapping without temp variables)
			array[a] = array[a] ^ array[b];
			array[b] = array[a] ^ array[b];
			array[a] = array[a] ^ array[b];
		}

		System.out.println("Swapped: a= " + array[a] + ", b= " + array[b]);
	}
}
