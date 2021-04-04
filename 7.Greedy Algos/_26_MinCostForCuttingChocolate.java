import java.util.Arrays;

public class _26_MinCostForCuttingChocolate
{
	public static void main(String[] args)
	{
		int rows = 6;
		int cols = 4;
		int[] colsPrice = { 2, 1, 3, 1, 4 };
		int[] rowsPrice = { 4, 1, 2 };
		minCostToBreakIntoSinglePieces(colsPrice, rowsPrice, rows, cols);
	}

	public static void minCostToBreakIntoSinglePieces(int[] colsPrice, int[] rowsPrice, int rows, int cols)
	{
		int horizontalCut = 1;
		int verticalCut = 1;

		// Greedy: Sorting arrays (ascending sort) to find min
		Arrays.sort(colsPrice);
		Arrays.sort(rowsPrice);

		// iterating from the back to pick the maxCost
		int i = colsPrice.length - 1;
		int j = rowsPrice.length - 1;
		int minCost = 0;

		// iterating both arrays simultanously
		while (i >= 0 && j >= 0)
		{
			if (colsPrice[i] > rowsPrice[j])
			{ // performing vertical cut
				minCost += colsPrice[i] * verticalCut;
				i--;
				horizontalCut++;
			}
			else
			{
				// performing horizontal cut
				minCost += rowsPrice[j] * horizontalCut;
				j--;
				verticalCut++;
			}
		}

		// iterating the left overs of the cols Price arrays
		while (i >= 0)
		{
			// performing vertical cut
			minCost += colsPrice[i] * verticalCut;
			i--;
		}

		// iterating the left overs of the rows Price arrays
		while (j >= 0)
		{
			// performing horizontal cut
			minCost += rowsPrice[i] * horizontalCut;
			j--;
		}

		System.out.println("Min Cost:" + minCost);
	}

}
