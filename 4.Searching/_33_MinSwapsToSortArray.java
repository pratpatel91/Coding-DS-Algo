import java.util.ArrayList;
import java.util.Collections;

//we don't need the comparator here because we are the 
//sorting the values based on increasing order (normal sorting)

public class _33_MinSwapsToSortArray
{
	public static void main(String[] args)
	{
		int[] array = { 2, 4, 5, 1, 3 };
		System.out.println(minSwapForSortingArray(array));
	}

	public static int minSwapForSortingArray(int[] array)
	{
		// --------------------------Preprocessing----------------------------------//
		// key=int, value=int
		ArrayList<int[]> oldIndexArray = new ArrayList<>();

		// populating old indicies
		for (int i = 0; i <= array.length - 1; i++)
		{
			// for every arraylist object we have a pair of array[i],i
			oldIndexArray.add(new int[] { array[i], i });
		}
		// sorting on the basis of a so we pass in a-b into the collection sort method
		Collections.sort(oldIndexArray, (a, b) -> (a[0] - b[0]));

		// --------------------------Core logic----------------------------------//
		int minSwap = 0;

		boolean[] visitedArray = new boolean[array.length];
		printArray(visitedArray);

		// populating the visited array based on old indicies
		for (int i = 0; i < array.length; i++)
		{
			int[] tempPairObj = oldIndexArray.get(i);

			if (visitedArray[i] == true || tempPairObj[1] == i)
			{
				continue; // old index is matching the new index so we dont do anything here
			} else
			{
				int cycles = 0;
				int j = i;

				while (visitedArray[j] == false)
				{
					System.out.println("current index:" + j);
					visitedArray[j] = true;
					System.out.println("visited index:" + visitedArray[j]);
					j = oldIndexArray.get(i)[1];
					System.out.println("next index:" + j);
					cycles++;
				}
				printArray(visitedArray);

				if (cycles > 0)
				{
					// (5,3) and (3,5) are two cycles but need 1 minswap
					minSwap += (cycles - 1);
				}
			}
		}
		return minSwap;
	}

	public static void printArray(boolean[] array)
	{
		for (int i = 0; i <= array.length - 1; i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}
}
