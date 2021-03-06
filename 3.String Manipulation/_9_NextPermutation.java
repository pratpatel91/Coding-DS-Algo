import java.util.Arrays;

public class _9_NextPermutation
{
	public static void main(String[] args)
	{
		int[] array = {1,2,3,6,5,4};
		genNextPermutation(array);
	}
	
	public static int[] genNextPermutation(int[] array)
	{
		//iterate the array starting from right to left
		// to see if the current element is larget than the previous
		//element in order to find the pivot
		
		//Reasons for not doing i>=0
		//1. i>=0 isnt used because we dont want to do descending order
		//2. when i=0 i-1 = -1 which gives out of bounds
		
		int i;
		
		for(i=array.length-1; i>0; i--)
		{
			int current = array[i];
			int previous = array[i-1];
			
			if(current > previous)
			{
				//i-1 is the pivot index
				break;
			}
		}
		
		int smallestValue = i;
		System.out.println("Pivot is array[i-1]:" + array[i-1] + ", index next to pivot" + i );
		
		if(i==0)
		{
			return array; //array is in descending order
		}
		
		//for loop to find the value that is greater 
		//than the pivot
		for(int j=i; j<=array.length-1;j++)
		{
			int current = array[j];
			int pivot= array[i-1];
			
			System.out.println("Pivot is array[i-1]:" + array[i-1] + ", current is array[j]:" + array[j]);
			
			if(current>pivot && current<array[smallestValue])
			{
				System.out.println("Previous smallest element was " + array[smallestValue]);
				smallestValue=j;
				System.out.println("Current smallest element is " + array[smallestValue]);
			}
		}
		System.out.println("Pivot is array[i-1]:" + array[i-1] + ", the element just greater than pivot is " + array[smallestValue]);
		
		
		swap(smallestValue,i-1,array);
		System.out.println("This array is not the next permutation");
		printArray(array);
		
		Arrays.sort(array,i,array.length);// sorting from a[i]...a[last]
		System.out.println("This array is the next permutation");
		printArray(array);
		return array;
	}
	
	public static void printArray(int[] array)
	{
		for(int i=0; i<=array.length-1;i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}
	
	
	
	public static void swap (int a, int b, int[] array)
	{
		int temp = array[a];
		array[a]=array[b];
		array[b]=temp;
	}

}
