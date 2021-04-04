import java.util.Arrays;

public class _21_ChocDist
{
	public static void main(String[] args)
	{
		int[] array = {2,1,4,5,7,9,23,6,32,10};
		int people =5;
		optimized_minChocDiff(array,people);
	}
	
	public static void optimized_minChocDiff(int[] array, int people)
	{
		//greedy approach (ascending sort)
		//1st bag is min
		//2nd bag is 2nd min
		Arrays.sort(array);
		
		int minDiff= Integer.MAX_VALUE;
		
		for(int i=0;i<=array.length-people;i++)
		{
			minDiff=Math.min((array[i+people-1]-array[i]),minDiff);
		}
		System.out.println("MinChocDiff:"+minDiff);
	}

	
}
