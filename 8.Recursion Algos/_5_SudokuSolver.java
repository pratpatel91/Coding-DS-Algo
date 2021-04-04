public class _5_SudokuSolver
{
  	public static void main(String[] args)
	{
		int[][] sudoku = { 
				{ 3, 0, 6, 5, 0, 8, 4, 0, 0 },
				{ 5, 2, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, 
				{ 9, 0, 0, 8, 6, 3, 0, 0, 5 }, 
				{ 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 7, 4 }, 
				{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
		
		System.out.println("sudokuSolver(sudoku) = " + sudokuSolver(sudoku));
		
		//print the sudoku solver (iterating the matrix)
		//int rows = sudoku.length;
		//int cols = sudoku[0].length;
		
		for(int rows=0; rows<9; rows++)
		{
			for(int cols=0;cols<9;cols++)
			{
				System.out.print(sudoku[rows][cols] + " ");
			}
			System.out.println(); //changing line to print another row
		}
	}
	
	public static boolean sudokuSolver(int[][] sudoku)
	{
		//findEmptyLocation(sudoku);
		int row =0;
		int col=0;
		boolean isEmpty= false;
		
		//finding the empty cells
		for(row=0;row<9;row++)
		{
			for(col=0;col<9;col++)
			{
				if(sudoku[row][col]==0)
				{
					isEmpty = true;
					break;
				}
			}
			if(isEmpty)
			{
				break;
			}
		}
		
		//getting the x,y coordinates of empty cell
		if(row==9 && col==9)
		{
			return true;
		}
		
		for(int num=1; num<=9;num++)
		{
			if(isNumSafeToPlace(sudoku,row,col,num))
			{
				//DO (placing the num)
				sudoku[row][col]=num;
				
				//RECUR (placing next nums)
				if(sudokuSolver(sudoku))
				{
					return true;
				}
				
				//UNDO (emptying the cell)
				sudoku[row][col]=0;
			}
		}
		return false;
	}
	
	//variables at the left, barely changing vars to the right
	public static boolean isNumSafeToPlace(int[][] sudoku, int row, int col, int num)
	{
		return (isNumSafeToPlaceInRow(sudoku,row,num) && isNumSafeToPlaceInCol(sudoku,col,num) 
				&& isNumSafeToPlaceInBox(sudoku, row-row%3, col-col%3,num)) ;
	}
	
	
	public static boolean isNumSafeToPlaceInRow(int[][] sudoku, int row, int num)
	{
		for(int col=0;col<9;col++)  //variable col, fixed row
		{
			if(sudoku[row][col]==num)
			{
				return false;
			}
		}
		return true;
	}
	
	
	public static boolean isNumSafeToPlaceInCol(int[][] sudoku, int col, int num)
	{
		for(int row=0;row<9;row++) //variable row, fixed col
		{
			if(sudoku[row][col]==num)
			{
				return false;
			}
		}
		return true;
	}
	
	public static boolean isNumSafeToPlaceInBox(int[][] sudoku, int boxRow, int boxCol, int num)
	{
		// iterating the 3x3 matrix (nested for loops)
		for(int row=0; row<3; row++)
		{
			for(int col=0; col<3; col++)
			{
				if(sudoku[boxRow+row][boxCol+col]==num)
				{
					return false;
				}
			}
		}
		return true;
	}
	
	
	public static boolean findEmptyLocation(int[][] sudoku)
	{
		//traversing the matrix(using nested for loops)
		//0= empty = true
		//1-9 not empty = false
		for(int i=0; i<=9;i++) //row iterator
		{
			for(int j=0; j<=9;j++) //column iterator
			{
				if(sudoku[i][j]==0)
				{
					return true;
				}
			}
		}
		return false; //cell isnt empty
	}

}
