
public class _25_InversionArray
{

	public static void main(String[] args)
	{
		int [] array = {2,4,1,3,5};
		bruteForceinversionArray(array);
		
	}
	
	//inversion = # of elements that are not at their sorted position
	//{2,4,1,3,5} has 4 elements out of position
	//We want min swaps to sort the array
	//2 with {4,1,3,5} -> 1
	//4 with {1,3,5} -> 2
	//1 with {3,5} -> 0
	//3 with {5} -> 0
	//TC=O(n^2) SC=O(1)
	public static void bruteForceinversionArray(int[] array)
	{
		int inversionCount= 0;
		
		for(int i=0; i<=array.length-1; i++)
		{
			for(int j=i+1; j<=array.length-1; j++)
			{
				if(array[i]>array[j])
				{
					inversionCount++;
					
				}
			}
		}
		System.out.println(inversionCount);
	}
	
	//variation of merge sort
	//TC=O(n*logn) SC=O(n)
	public static void optimizedinversionArray(int[] array)
	{
		
	}
}
