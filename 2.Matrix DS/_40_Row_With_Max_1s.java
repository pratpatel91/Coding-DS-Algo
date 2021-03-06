
public class _40_Row_With_Max_1s
{

	public static void main(String[] args)
	{
		int[][] matrix = { { 0, 1, 1, 1 }, { 0, 0, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 0, 0 } };
		// System.out.println(bruteForce_rowWithMaxOnes(matrix));
		//System.out.println(binarysearch_rowWithMaxOnes(matrix));
		System.out.println(twoPointers_rowWithMaxOnes(matrix));
	}
	//TC=O(n*m) SC=O(1)
	public static int bruteForce_rowWithMaxOnes(int[][] matrix)
	{
		int rows = matrix.length;
		int cols = matrix[0].length;

		int global_OnesCount_Per_Row = Integer.MIN_VALUE; // optimize value
		int rowWithMaxOnes = 0;

		for (int i = 0; i <= rows - 1; i++)
		{
			// Resets during each row
			int ones_count = 0;

			for (int j = 0; j <= cols - 1; j++)
			{

				if (matrix[i][j] == 1)
				{
					ones_count++;
				}

			}

			if (global_OnesCount_Per_Row < ones_count)
			{
				global_OnesCount_Per_Row = ones_count;
				rowWithMaxOnes = i;
			}
		}

		return rowWithMaxOnes;
	}

	// Binary Search per row HW
	//TC=O(nm *log(nm)) SC=O(1)
	public static int binarysearch_rowWithMaxOnes(int[][] matrix)
	{
		int rows = matrix.length;
		int cols = matrix[0].length;

		int rowWithMaxOnes = 0;
		int global_OnesCount_Per_Row = Integer.MIN_VALUE; // optimize value

		// iterate all the rows of the matrix
		for (int i = 0; i <= rows - 1; i++)
		{
			int first_index_of_One_in_Row = binarysearch_LowerBound(matrix[i]);

			System.out.println("first index of one: " + first_index_of_One_in_Row);
			System.out.println("# of ones: " + (cols - first_index_of_One_in_Row));
			if (first_index_of_One_in_Row != -1)
			{
				if (cols - first_index_of_One_in_Row > global_OnesCount_Per_Row)
				{
					global_OnesCount_Per_Row = cols - first_index_of_One_in_Row;
					rowWithMaxOnes = i;
				}
			}
		}
		return rowWithMaxOnes;
	}

	// lower bound = index of 1st occuring element
	// lower bound is a variation of binarysearch
	public static int binarysearch_LowerBound(int[] array)
	{
		int low = 0; // index
		int high = array.length - 1; // index
		int ans = -1;

		while (low <= high)
		{
			int mid = low + (high - low) / 2; // avoids int overflow

			if (mid == 0 || (array[mid - 1] == 0) && array[mid] == 1)
			{
				return mid;
			} else if (array[mid] == 0)
			{
				low = mid + 1;
			} else if (array[mid] == 1)
			{
				ans = mid;
				high = mid - 1;
			}
		}
		System.out.println("ans: " + ans);
		return ans;
	}

	// 2 Pointers approach HW
	//TC=O(n+m) SC=O(1)
	public static int twoPointers_rowWithMaxOnes(int[][] matrix)
	{
		// starting at the upper right of the matrix
		int i = 0;
		int j = matrix[0].length - 1;// index

		int rows = matrix.length;
		int cols = matrix[0].length;

		int rowWithMaxOnes = 0;
		int global_OnesCount_Per_Row = Integer.MIN_VALUE;

		// doing row wise binary search to find max ones
		// i is growing from 0 till rows
		// j is shrinking from cols till 0
		int index_of_One = Integer.MIN_VALUE;

		while (i < rows && j >= 0)
		{
			if (matrix[i][j] == 1)
			{
				index_of_One = j;
				j--;// going left

				// ------------Updating rowWithMaxOnes-------//
				int num_ones = cols - index_of_One;

				if (num_ones > global_OnesCount_Per_Row)
				{
					global_OnesCount_Per_Row = num_ones;
					rowWithMaxOnes = i;
				}
			} else if (matrix[i][j] == 0)
			{
				// row is not used to update maxOnes because
				// if current element is 0 then we wont get more ones
				// then the previous row

				i++; // going down
			}
		}
		return rowWithMaxOnes;
	}

}
