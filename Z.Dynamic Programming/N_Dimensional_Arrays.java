
public class N_Dimensional_Arrays
{
	public static void main(String[] args)
	{
		int[] _1d_array1 = createPopulatePrintAndSaveThe1DArray();
		int[] _1d_array2 = createPopulatePrintAndSaveThe1DArray();
		int[][] _2d_array = createPopulatePrintAndSaveThe2DArray();
	}

	public static int[] createPopulatePrintAndSaveThe1DArray()
	{
		System.out.println("-------------1d Array--------------");
		// 1.creating the 1d array
		int[] _1d_array = new int[3];

		// 2.populating the 1d array
		for (int i = 0; i <= _1d_array.length - 1; i++)
		{
			_1d_array[i] = (i + 1);
		}

		// 3.displaying the 1d array
		for (int i = 0; i <= _1d_array.length - 1; i++)
		{
			System.out.print(_1d_array[i] + " ");
		}
		System.out.println(); // space
		return _1d_array;
	}

	public static int[][] createPopulatePrintAndSaveThe2DArray()
	{
		System.out.println("-------------2d Array--------------");
		// 1.creating the matrix
		int[][] _2d_array = new int[2][3];

		// 2.Populating the matrix
		int value = 1;
		for (int i = 0; i <= _2d_array.length - 1; i++)
		{
			for (int j = 0; j <= _2d_array[0].length - 1; j++)
			{
				_2d_array[i][j] = value;
				value++;
			}
			value = 1;
		}

		// 3.displaying the matrix
		for (int i = 0; i <= _2d_array.length - 1; i++)
		{
			for (int j = 0; j <= _2d_array[0].length - 1; j++)
			{
				System.out.print(_2d_array[i][j] + " ");
			}
			System.out.println(); // space
		}
		return _2d_array;
	}
}
