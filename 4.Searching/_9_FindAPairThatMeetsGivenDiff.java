import java.util.Arrays;

public class _9_FindAPairThatMeetsGivenDiff
{

	public static void main(String[] args)
	{
		int[] array = { 5, 20, 3, 2, 5, 80,42,36,100,22 };
		int diff = 78;
		//findPairOf2ThatSatifiesTheGivenDiff(array, diff);
		OptimizedFindPairOf2ThatSatifiesTheGivenDiff(array, diff);
	}

	//TC=O(n*logn)  SC=O(1)
	public static void findPairOf2ThatSatifiesTheGivenDiff(int[] array, int diff)
	{
		//1st sort the array TC=O(logn) (SORTING IS A PREREQ FOR TWO POINTERS APPROACH)
		printArray(array);
		Arrays.sort(array);
		printArray(array); 
		
		//Two pointers approach O(n)
		int i = 0;
		int j = array.length-1;

		while (i<=j) //<= handles single element
		{
			if(array[j]-array[i]==diff)
			{
				System.out.println("Pair found: "+array[i]+","+array[j]);
				//move onto doing the next iteration in the two pointers approach
				i++;
				j--;
			}
			else if (array[j]-array[i]>diff)
			{
				//we have to shift j to decrease diff
				j--;
			}
			else //if(array[j]-array[i]<diff)
			{
				//we have to shift i to increase diff
				i++;
			}
		}
		
	}
	
	//TC=O(n)  SC=O(maxElement+1+diff) due to creating an aux array
	public static void OptimizedFindPairOf2ThatSatifiesTheGivenDiff(int[] array, int diff)
	{
		int[] hashArray = hashArray(array);
		
		//array[j]-array[i]==diff
		//we have to check if array[j] and array[i] are present in the hash
		//so we iterate the hash array
		for(int i=0;i<=array.length-1;i++)
		{
			int firstNumInPair = array[i];
			//diff =  secondNumInPair -  firstNumInPair
			int secondNumInPair = firstNumInPair+ diff;
			System.out.println("secondNumInPair:"+secondNumInPair);
			if(hashArray[secondNumInPair]>0)
			{
				System.out.println("Pair found: {" + firstNumInPair + ", " +secondNumInPair + "}");
			}
		}
		
	}
	
	
	public static int[] hashArray(int[] array)
	{
		int maxElement =100;
		int diff =78;
		
		//creating the hash
		int[] hashArray = new int[maxElement+1+diff]; //size=179
		
		//populating the hash
		for(int i=0;i<=array.length-1;i++)
		{
			hashArray[array[i]]++;
		}
		return hashArray;
	}
	
	public static void printArray(int[] array)
	{
		System.out.println("");
		for(int i=0;i<=array.length-1;i++)
		{
			System.out.print(array[i]+" ");
		}
		System.out.println("\n");
	}

}
