
public class _4_NegativeNumbers
{
	public static void main(String[] args)
	{
		int array[] = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
		ShiftNegativesToTheLeft(array);
	}

	public static void ShiftNegativesToTheLeft(int[] array)
	{
		int left = 0;

		for (int i = 0; i <= array.length - 1; i++)
		{
			int right = i;

			if (array[right] < 0)
			{
				if (left != right)
				{
					swap(array, left, right);
					left++;
				}
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
		// System.out.println("Unswapped: a= " + array[a] + ", b= " + array[b]);

		// when a=2, b=2 swapping breaks down since XOR same # ^ same # = 0
		// so we include the if condition to check against that condition
		if (array[a] != array[b])
		{
			// XOR (bit manipulation aka swapping without temp variables)
			array[a] = array[a] ^ array[b];
			array[b] = array[a] ^ array[b];
			array[a] = array[a] ^ array[b];
		}

		// System.out.println("Swapped: a= " + array[a] + ", b= " + array[b]);
	}

}
