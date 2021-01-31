
public class _25_PartitionSortArrayWithManyRepeatedElements
{
	public static void main(String[] args)
	{
		int[] array = { 2,2,1,3,4 };
		optimized_CountSort(array);
		
	}

	//TC=O(n) SC=O(n) due to creating an extra array for hashing purposes
	public static void optimized_CountSort(int[] array)
	{
		int[] hashArray = hashArray(array);
		//printArray(hashArray);
				
		for(int i=0; i<=hashArray.length-1;i++)
		{
			if(hashArray[i]>0)
			{
				System.out.print(i + " ");
			}
		}		
	}

	public static int[] hashArray(int[] array)
	{
		int max = max(array);

		int[] hashArray = new int[max + 1];

		for (int i = 0; i <= array.length - 1; i++)
		{
			int currentElement = array[i];
			hashArray[currentElement]++;
		}
		return hashArray;
	}

	public static int max(int[] array)
	{
		int max = Integer.MIN_VALUE;

		for (int i = 0; i <= array.length - 1; i++)
		{
			int currentElement = array[i];

			if (currentElement > max)
			{
				max = currentElement;
			}
		}
		return max;
	}

	public static void printArray(int[] array)
	{
		for (int i = 0; i <= array.length - 1; i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}
}
