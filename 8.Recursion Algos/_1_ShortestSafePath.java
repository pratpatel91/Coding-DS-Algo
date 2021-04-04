import java.util.Arrays;

public class _1_ShortestSafePath
{
	// left, up, right, down
	static int[] x = { -1, 0, 1, 0 };
	static int[] y = { 0, 1, 0, -1 };
	static int minDist = Integer.MAX_VALUE;

	public static void main(String[] args)
	{
		int[][] matrix = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 }, { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 0, 1, 1, 1, 1, 0, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 }, };

		printMatrix(matrix);
		System.out.println("-------");
		markAdjCellsAsZeroes(matrix);
		printMatrix(matrix);

		// minDist=shortestSafePath(matrix);
		shortestSafePath(matrix);

	}

	public static void shortestSafePath(int[][] matrix)
	{
		boolean[][] isVisited = new boolean[matrix.length][matrix[0].length];

		for (int rowNum = 0; rowNum < matrix.length; rowNum++)
		{
			// visiting entire row
			if (matrix[rowNum][0] == 1)
			{
				for (int i = 0; i < matrix.length; i++)
				{
					//Arrays.fill(isVisited[i], false);
					for(int j=0; j<matrix[i].length;j++)
					{
						isVisited[i][j]=false;
					}
				}

				int dist = 0;

				findMinDist(matrix, isVisited, rowNum, 0, dist);

				// Row of 1s
				if (minDist == matrix[0].length)
				{
					break;
				}
			}
		}

		if (minDist != Integer.MAX_VALUE)
		{
			System.out.println("Min Dist: " + minDist);
		}
		else
		{
			System.out.println("Cant reach last col");
		}
	}

	public static void findMinDist(int[][] matrix, boolean[][] isVisited, int rowNum, int currCol, int dist)
	{
		if (currCol == matrix[0].length-1)
		{
			minDist = Math.min(minDist, dist);
		}
		// process of elimination (optimization)
		if (dist > minDist)
		{
			return;
		}

		// do
		isVisited[rowNum][currCol] = true;

		// recurr
		for (int dir = 0; dir < 4; dir++)
		{
			if (isSafePlaceToMove(rowNum + x[dir], currCol + y[dir], matrix)
					&& isMineOrAlreadyVisited(matrix, isVisited, rowNum + x[dir], currCol + y[dir]))
			{
				findMinDist(matrix, isVisited, rowNum + x[dir], currCol + y[dir], dist + 1);
			}
		}

		// undo
		isVisited[rowNum][currCol] = false;
	}

	public static void markAdjCellsAsZeroes(int[][] matrix)
	{
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[i].length; j++)
			{
				if (matrix[i][j] == 0)
				{
					for (int dir = 0; dir < 4; dir++)
					{
						if (isSafePlaceToMove(i + x[dir], j + y[dir], matrix))
						{
							matrix[i + x[dir]][j + y[dir]] = -1;
						}
					}
				}
			}
		}

		// prevents the entire matrix from being zeroes
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[i].length; j++)
			{
				if (matrix[i][j] == -1)
				{
					matrix[i][j] = 0;
				}
			}
		}

	}

	public static boolean isMineOrAlreadyVisited(int[][] matrix, boolean[][] isVisited, int x, int y)
	{
		if (matrix[x][y] == 0 || isVisited[x][y] == true)
		{
			return false;
		}
		return true;
	}

	public static boolean isSafePlaceToMove(int x, int y, int[][] matrix)
	{
		if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[x].length)
		{
			return true;
		}
		return false;
	}

	public static void printMatrix(int[][] matrix)
	{
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[i].length; j++)
			{
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println(); // changed line per row printouts
		}
	}
}
