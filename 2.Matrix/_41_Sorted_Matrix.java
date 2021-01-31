import java.util.Arrays;
import java.util.Scanner;

public class _41_Sorted_Matrix
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int m_rows = input.nextInt();
		int n_cols = input.nextInt();

		int[][] matrix = new int[m_rows][n_cols];

		fillMatrix(matrix, m_rows, n_cols);
		transferDataFromMatrixToArray(matrix, m_rows, n_cols);
	}

	// TC=O(n*m), SC= O(n*m) n*m is analagous to n^2
	public static void fillMatrix(int[][] matrix, int m_rows, int n_cols)
	{
		Scanner input = new Scanner(System.in);

		// nested for loops is to iterate through all the elements of the matrix
		for (int i = 0; i < m_rows; i++)
		{
			for (int j = 0; j < n_cols; j++)
			{
				matrix[i][j] = input.nextInt();
			}
		}
	}

	// TC=o(n*m) SC=o(n*m) due to creating an array to store the matrix
	public static void transferDataFromMatrixToArray(int[][] matrix, int m_rows, int n_cols)
	{
		// ---------Brute Force Method for displaying the Sorted Matrix ----//
		// 1. store the matrix into an array
		// 2. sort the array
		// 3. print the sorted array

		// ------------1.Moving all elements from the matrix into an Array------------//
		// creating an array to store the sorted elements from the matrix
		int[] array = new int[m_rows * n_cols];

		int array_index = 0;

		// nested for loops is to iterate through all the elements of the matrix
		// TC=o(n*m)
		for (int i = 0; i < m_rows; i++)
		{
			for (int j = 0; j < n_cols; j++)
			{
				// array_index++; this would skip array[0]
				array[array_index] = matrix[i][j];
				array_index++; // grows from 0 to m*n
			}
		}

		// -------------------------------2.Sorting Array----------------------------//
		// TC=o(n*log n)
		Arrays.sort(array);

		// -------------------------------3.Print Array(Sorted matrix)----------------------//
		// TC=o(n*m)
		for (int i = 0; i <= array.length - 1; i++)
		{
			System.out.print(array[i] + " ");
		}
	}
}
