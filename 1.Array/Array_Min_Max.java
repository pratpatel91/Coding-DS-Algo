public class Array_Min_Max
{

	public static void main(String[] args)
	{
		//initialized the array
		int[] array = {1,2,3,4};
		
		findMinElementInTheArray(array);
		findMaxElementInTheArray(array);
	}

	public static void findMinElementInTheArray(int[] array)
	{
		int min = Integer.MAX_VALUE; // 2147483647
		
		System.out.println("Initialized Min: " + min);
		
		for (int i = 0; i <= array.length - 1; i++)
		{
			if (array[i] < min)
			{
				min = array[i];
			}
		}
		System.out.println("Min Value in array: " + min);
	}

	public static void findMaxElementInTheArray(int[] array)
	{
		int max = Integer.MIN_VALUE; //-2147483648
		
		System.out.println("Initialized Max: " + max);
		
		for (int i = 0; i <= array.length - 1; i++)
		{
			if (array[i] > max)
			{
				max = array[i];
			}
		}
		System.out.println("Max Value in array: " + max);
	}

}
