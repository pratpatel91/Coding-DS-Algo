import java.util.Scanner;

public class BackTracking_PlacingNQueens
{
	static int arrangements = 0;
	
	public static void main(String[] args)
	{
		int[][] board = new int[50][50];
		Scanner input = new Scanner(System.in);
		System.out.println("Enter num of Queens to Place?: ");
		int queens = input.nextInt();
		int queensPlaced = 0;
		System.out.println("Can place queens? " + solve_NQueens(board, queens, queensPlaced));
		System.out.println("# of Possible Arrangements:"+arrangements);
	}

	public static boolean solve_NQueens(int[][] board, int queens, int queensPlaced)
	{
		// base case
		if (queensPlaced == queens)
		{
			arrangements++;
			for (int i = 0; i < queens; i++)
			{
				for (int j = 0; j < queens; j++)
				{
					if (board[i][j] == 1)
					{
						System.out.print(" Q ");
					}
					else
					{
						System.out.print(" __ ");
					}
				}
				System.out.println();
			}
			System.out.println("-------------------------------------");			
		}

		for (int i = 0; i < queens; i++)
		{
			if (isPlaceSafe(board, queensPlaced, i, queens))
			{
				// 1.do queen placement
				board[queensPlaced][i] = 1;
				// 2.repeat queen placement
				boolean canPlaceNextQueen = solve_NQueens(board, queens, queensPlaced + 1);

				if (canPlaceNextQueen)
				{
					return true;

				}
				else
				{
					board[queensPlaced][i] = 0; // 3.undo latest queen placement
				}
			}

		}
		return false; // cannot place the queen
	}

	static boolean isPlaceSafe(int[][] board, int currRow, int currCol, int N)
	{
		// column wise check
		for (int i = 0; i < currRow; i++)
		{
			if (board[i][currCol] == 1)
			{
				return false;
			}
		}

		// diagonal wise check
		int x = currRow, y = currCol;
		while (x >= 0 && y >= 0)
		{
			if (board[x][y] == 1)
			{
				return false;
			}
			x--;
			y--;
		}

		// row wise check
		x = currRow;
		y = currCol;
		while (x >= 0 && y < N)
		{
			if (board[x][y] == 1)
			{
				return false;
			}
			x--;
			y++;
		}
		return true; // if all the 3 checks pass then return true
	}

}
