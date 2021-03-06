import java.util.Arrays;

public class _39_Median_Sorted_Matrix
{

	public static void main(String[] args)
	{
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		// rowSortedMatrixMedian(matrix);
		binarySearch_RowSortedMatrixMedian(matrix);
	}

	public static void printArray(int[] array)
	{
		// printing the array
		for (int i = 0; i <= array.length - 1; i++)
		{
			System.out.print(array[i] + " ");
		}
	}

	// Brute Force : TC = O(nm*log(nm)) SC=O(nm)
	public static void rowSortedMatrixMedian(int[][] matrix)
	{
		int rows = matrix.length;
		int cols = matrix[0].length;

		int[] matrixToArray = new int[rows * cols];

		int median = (rows * cols) / 2;

		int m_n_index = 0;// index to range from 0 -m*n

		for (int i = 0; i <= rows - 1; i++)
		{
			for (int j = 0; j <= cols - 1; j++)
			{
				matrixToArray[m_n_index] = matrix[i][j]; // storing matrix elements into the array
				m_n_index++;
			}
		}

		printArray(matrixToArray);
		Arrays.sort(matrixToArray);

		System.out.println("\n median: " + matrixToArray[median]);
	}

	// Optimized Approach
	// TC= O(n*log(m) SC=O(1)
	public static int binarySearch_RowSortedMatrixMedian(int[][] matrix)
	{
		// Due to Row Sorted Matrix (1st element of row = low and last element of row =
		// high)
		int rows = matrix.length;
		int cols = matrix[0].length;
		int low = Integer.MAX_VALUE;
		int high = Integer.MIN_VALUE;

		for (int i = 0; i <= rows - 1; i++)
		{
			// low is checked against the 1st element of the matrix row
			// iterating all the rows
			if (low > matrix[i][0])
			{
				low = matrix[i][0];
			}

			// high is checked against the last element of the matrix row
			// matrix[0].length-1 is accessing the index of the last element in the row
			// iterating all the rows

			if (high < matrix[i][cols - 1])
			{
				high = matrix[i][cols - 1];
			}
		}
		System.out.println("Low:" + low + ", High: " + high);
		// while loop for binary search
		int need_elements_less_than_median = (rows * cols) / 2;

		while (low < high)
		{
		int mid = (low + high) / 2;

		int count = 0;

		for (int i = 0; i <= rows - 1; i++)
		{
			// passing matrix rows
			count += upperbound(matrix[i], mid);
			System.out.println("Mid:" + mid + ", Count: " + count);
			
		}
		
		int median = (rows*cols)/2;
		
		if(count > median)
		{
			high=mid;
			
		}
		else
		{
			low=mid+1;
		}

		}
		return low;
	}

	public static int upperbound(int[] array, int target)
	{
		// binary search per row
		int low = 0;
		int high = array.length - 1;

		while (low < high)
		{
			int mid = (low + high) / 2;

			if (target > mid)
			{
				low = mid + 1; // [low ........mid+1]
			} else if (target < mid)
			{
				high = mid - 1; // [low ........mid-1]
			}

		}

		return low;

	}
}
