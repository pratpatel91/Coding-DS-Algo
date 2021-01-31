
public class _2_ValueEqualToIndexValue
{

	public static void main(String[] args)
	{
		int[] array = { 1, 24, 2, 4, 56 };
		System.out.println(linearSearchForValueEqualToIndex(array));
		// due to the given array being unsorted we cant do binary search
		//due to not having a target we cant use bs (right or left selection)
	}

	// TC=O(n) SC=O(1)
	public static int linearSearchForValueEqualToIndex(int[] array)
	{
		for (int i = 0; i <= array.length - 1; i++)
		{
			// if value = index then return the index
			if (array[i] == i)
			{
				System.out.println("Using Linear Search value=index at i="+ i);
				return i;
			}
		}
		return -1;
	}

}
