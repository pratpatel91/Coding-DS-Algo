import java.util.Scanner;
//Dynamic Programming

public class _12_MinJumps
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();

		while (T > 0)
		{
			int N = input.nextInt();
			int[] array = new int[N];

			// takes array from the user
			for (int i = 0; i <= array.length - 1; i++)
			{
				array[i] = input.nextInt();
			}

			// -------------------------Core Logic ------------------------//
			int answer = minJumpsFromStartToEnd(array);

			if (answer == Integer.MAX_VALUE)
			{
				System.out.print("-1");// not possible to reach the end of the array
			} else
			{
				System.out.println(answer);
			}
		}
	}
	
	public static void printArray(int[] array)
	{
		System.out.println("\n");
		
		for (int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
		
		System.out.println("\n");
	}
	
	public static int minJumpsFromStartToEnd(int[] array)
	{
		int[] minJumpsArray = new int[array.length];

		// setting all the elements in the minJumpsArray to be infinity
		// 1st place requires 0 jumps aka i=1
		for (int i = 1; i <= minJumpsArray.length - 1; i++)
		{
			minJumpsArray[i] = Integer.MAX_VALUE;
		}

		// iterating the array
		// 1st place requires 0 jumps aka i=1
		for (int i = 1; i <= array.length - 1; i++)
		{
			// checking wether we can reach the last index
			for (int j = 0; j < i; j++)
			{
				// checking how many indexes we can reach from i
				if (i <= j + array[j])
				{
					minJumpsArray[i] = min(minJumpsArray[i], minJumpsArray[j] + 1);
				}
			}
		}
		printArray(minJumpsArray);
		
		// returning the last index
		return minJumpsArray[array.length - 1];
	}

	public static int min(int a, int b)
	{
		if (a < b)
		{
			return a;
		}
		return b;
	}
}
