import java.util.Arrays;

public class _35_Median
{
	public static void main(String[] args)
	{
		int[] array = { 1, 2, 3, 4 };
		Arrays.sort(array);
		System.out.println(median(array));
	}

	public static int median(int[] array)
	{
		int median = 0;

		
		int n = array.length; // n=4

		if (n % 2 == 0) // even case
		{
			//typed cased to int because accessing fractional indicies
			//gives an Index Out of Bounds Exception
			
			//n-1/2 gives error however (n-1)/2 works as intended
			int index1 = n/2;
			int index2 = (n-1)/2;
			median = (array[index1 ] + array[index2] / 2);
		} else
		{
			median = array[n / 2];
		}
		return median;
	}
	
}
