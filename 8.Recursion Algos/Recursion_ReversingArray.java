public class Recursion_ReversingArray
{
	public static void main(String[] args)
	{
		int[] array = {1,2,3};
		iterative_reverseArrayUsingTwoPointers(array);
		System.out.println("\n");
		recursive_reverseArrayUsingTwoPointers(array, 0, array.length-1);
	}

	public static void iterative_reverseArrayUsingTwoPointers(int[] array)
	{
		int start =0;
		int end=array.length-1;
		
		System.out.println("Original Array");
		printArray(array);
		
		while(start<end)
		{
			//reversing start[start] with array[end]
			int temp = array[start];
			array[start]=array[end];
			array[end]=temp;
			start++;
			end--;
		}
		System.out.println("\nReversed Array(Using Iterative)");
		printArray(array);
	}
	
	public static void recursive_reverseArrayUsingTwoPointers(
			int[] array, int start, int end)
	{		
		System.out.println("\nArray(Using Recursive)");
		printArray(array);
		
		if (start < end)
		{
			//reversing start[start] with array[end]
			int temp = array[start];
			array[start]=array[end];
			array[end]=temp;
			recursive_reverseArrayUsingTwoPointers(array, start+1, end-1);
		}
	}
	
	public static void printArray(int[] array)
	{
		for(int i=0;i<=array.length-1;i++)
		{
			System.out.print(array[i] + " ");
		}
	}
}
