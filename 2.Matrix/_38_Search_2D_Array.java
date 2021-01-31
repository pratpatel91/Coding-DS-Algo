import java.util.Scanner;

public class _38_Search_2D_Array
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int m_rows = input.nextInt();
		int n_cols = input.nextInt();
		int target = input.nextInt();

		int[][] matrix = new int[m_rows][n_cols];

		fillMatrix(matrix, m_rows, n_cols);
		System.out.println(searchSortedMatrix(matrix, m_rows, n_cols, target));

	}

	// TC=O(n*m), SC= O(n*m) n*m is analagous to n^2
	public static void fillMatrix(int[][] matrix, int m_rows, int n_cols)
	{
		Scanner input = new Scanner(System.in);

		for (int i = 0; i < m_rows; i++)
		{
			for (int j = 0; j < n_cols; j++)
			{
				matrix[i][j] = input.nextInt();
			}
		}
	}

	// TC=O(n+m), SC= O(n*m) n*m is analagous to n^2
	public static boolean searchSortedMatrix(int[][] matrix, int m_rows, int n_cols, int target)
	{
		// 1. Due to the matrix being sorted col & row wise we can
		// start from the top right corner
		int i = 0; // pointing the 1st row
		int j = n_cols - 1; // pointing to the last col

		while (i < m_rows && j >= 0) // i is growing from 0 to m_rows & j is shrinking from n_cols to 0
		{
			if (matrix[i][j] == target)
			{
				return true;
			} else if (matrix[i][j] > target)
			{
				j--; // going left column wise
			} else if (matrix[i][j] < target)
			{
				i++; // going down row wise
			}
		}
		// after traversing all the elements in the matrix and not finding the target
		// we display false
		return false;

	}

}
