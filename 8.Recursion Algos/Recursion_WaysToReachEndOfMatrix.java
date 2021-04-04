public class Recursion_WaysToReachEndOfMatrix
{
	public static void main(String[] args)
	{
		int rows = 20;
		int cols = 35;
		System.out.println(waysToReachEnd(0, 0, rows, cols));
	}

	public static int waysToReachEnd(int x, int y, int rows, int cols)
	{
		// reached out of matrix
		if (x >= rows || y >= cols)
		{
			if(x>= rows)
			{
			//	System.out.println("OUT OF MATRIX: x=" + (x+1) + ", y=" + y);
			}
			if(y>=cols)
			{
			//	System.out.println("OUT OF MATRIX: x=" + x + ", y=" + (y+1));
			}
			return 0;
		}

		// reached at the end of the matrix (which is why and is used)
		if (x == rows - 1 && y == cols - 1)
		{
			//System.out.println("REACHED DEST: x=" + x + ", y=" + y); //BACKTRACKING
			return 1;
		}

		//System.out.println("x=" + (x+1) + ", y=" + y);
		int ans1 = waysToReachEnd(x + 1, y, rows, cols); // moved rightward
		//System.out.println("x=" + x + ", y=" + (y+1));
		int ans2 = waysToReachEnd(x, y + 1, rows, cols); // moved downward
		//System.out.println("----------------");
		return ans1 + ans2;
	}

}
