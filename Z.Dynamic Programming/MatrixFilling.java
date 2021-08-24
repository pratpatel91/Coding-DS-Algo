
public class MatrixFilling
{
	static int[][] matrix = new int[3][3];

	public static void main(String[] args)
	{
		printMatrix(matrix);
		fillMatrix(matrix, 1);
		printMatrix(matrix);

		fillMatrix(matrix, 1);
		fillTopRowOfMatrix(matrix, 2);
		printMatrix(matrix);

		fillMatrix(matrix, 1);
		fillLeftMostColumnOfMatrix(matrix, 2);
		printMatrix(matrix);

		fillMatrix(matrix, 1);
		printMatrix(matrix);
		printDiagonalsOfMatrix(matrix);
		//fillDiagonalsOfMatrix(matrix, 3);
	}

	public static void fillMatrix(int[][] matrix, int ones)
	{
		for (int i = 0; i <= matrix.length - 1; i++)
		{
			for (int j = 0; j <= matrix[0].length - 1; j++)
			{
				matrix[i][j] = ones;
			}
		}
	}

	public static void printMatrix(int[][] matrix)
	{
		System.out.println(); // blank space
		for (int i = 0; i <= matrix.length - 1; i++)
		{
			for (int j = 0; j <= matrix[0].length - 1; j++)
			{
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println(); // blank space
		}
	}

	public static void fillTopRowOfMatrix(int[][] matrix, int two)
	{
		for (int i = 0; i <= matrix.length - 1; i++)
		{
			for (int j = 0; j <= matrix[0].length - 1; j++)
			{
				if (i == 0)
				{
					matrix[i][j] = two;
				}
			}
		}
	}

	public static void fillLeftMostColumnOfMatrix(int[][] matrix, int two)
	{
		for (int i = 0; i <= matrix.length - 1; i++)
		{
			for (int j = 0; j <= matrix[0].length - 1; j++)
			{
				if (j == 0)
				{
					matrix[i][j] = two;
				}
			}
		}
	}
	
	public static void printDiagonalsOfMatrix(int[][] matrix)
	{
		System.out.println(); // blank space
		for (int i = 0; i <= matrix.length - 1; i++)
		{
			System.out.print(matrix[i][i] + " ");
		}
	}
	public static void fillDiagonalsOfMatrix(int[][] matrix, int three)
	{
		for (int i = 0; i <= matrix.length - 1; i++)
		{
			for (int j = 0; j <= matrix[0].length - 1; j++)
			{
				if (i == j)
				{
					matrix[i][j] = three;
				}
			}
		}
	}

}
