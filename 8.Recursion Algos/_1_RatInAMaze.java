import java.util.ArrayList;

//TC=O()
public class _1_RatInAMaze
{
	public static void main(String[] args)
	{
		int[][] maze = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };
		int c = maze[0].length; // columns
		int r = maze.length; // rows
		// boolean[][] visited = new boolean[r][c]; //default is all false values
		ArrayList<String> pathList = new ArrayList<>();
		String currentPath = "";

		// variables at right, constants at left
		printPaths(0, 0, currentPath, pathList, maze, r, c);

		// printing all the unique paths(as strings) TC=O(N)
		for (int i = 0; i <= pathList.size() - 1; i++)
		{
			System.out.println("Path: " + pathList.get(i));
		}

	}

	//TC=O(1)
	public static boolean isPlaceSafe(int x, int y, int r, int c, int[][] maze)
	{
		// Using Or condition to denote unsafe placement
		// due to zero based indexing x=r is unsafe
		if (x >= r || y >= c || x < 0 || y < 0 || maze[x][y] == 2 || maze[x][y]==0)
		{
			return false;
		}
		return true;
	}

	//TC=O(N^2)^4directions
	public static void printPaths(int x, int y, String currentPath, ArrayList<String> pathList, int[][] maze, int r,
			int c)
	{
		// Base case (reaches destination)
		if (x == r - 1 && y == c - 1)
		{
			pathList.add(currentPath);
			return;
		}

		if (isPlaceSafe(x, y, r, c, maze))
		{
			maze[x][y] = 2; // assumption (visited)

			// ----------------Trying to find all solutions ---------------//
			// checking up
			if (isPlaceSafe(x - 1, y, r, c, maze))
			{
				String direction = currentPath + 'U';
				printPaths(x - 1, y, direction, pathList, maze, r, c);
			}
			// checking bottom
			if (isPlaceSafe(x + 1, y, r, c, maze))
			{
				String direction1 = currentPath + 'D';
				printPaths(x + 1, y, direction1, pathList, maze, r, c);
			}
			// checking left
			if (isPlaceSafe(x, y - 1, r, c, maze))
			{
				String direction2 = currentPath + 'L';
				printPaths(x, y - 1, direction2, pathList, maze, r, c);
			}
			// checking right
			if (isPlaceSafe(x, y + 1, r, c, maze))
			{
				String direction3 = currentPath + 'R';
				printPaths(x, y + 1, direction3, pathList, maze, r, c);
			}

			maze[x][y] = 1; // updated assumption (UNDO)
		}

	}

}
