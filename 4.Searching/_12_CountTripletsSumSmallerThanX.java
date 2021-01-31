import java.util.Arrays;

public class _12_CountTripletsSumSmallerThanX
{
	public static void main(String[] args)
	{
		int[] array = { 1,3,4,5,7};
		int X = 12;//sum

		bruteForce_TripletSumSmallerThanX(array, X);
		twoPointersOptimized_TripletSumSmallerThanX(array, X);
	}

	// TC=O(n^3) SC=O(1)
	public static void bruteForce_TripletSumSmallerThanX(int[] array, int X)
	{
		System.out.println("Brute Force Approach:");
		int numTriplets=0;
		
		// due to finding triplets i know that i will need 3 for loops
		// this a TC of O(n^3)
		// outer loop will start from 0 and end at 3rd to last element
		// inner loop will end at the last element (a.length-1)
		for (int i = 0; i <= array.length - 3; i++)
		{
			for (int j = i + 1; j <= array.length - 2; j++)
			{
				for (int k = j + 1; k <= array.length - 1; k++)
				{
					if (array[i] + array[j] + array[k] < X)
					{
						//System.out.println("i,j,k: " + i+","+j+","+k);
						//System.out.println("Pair found {" + array[i] + "," + array[j] + "," + array[k] + "}");
						numTriplets++;
					}
				}
			}
		}
		System.out.println("Triplets Found:"+numTriplets); //displaying blank space
	}

	// Two Pointers Optimization TC=O(n^2) SC=O(1)
	public static void twoPointersOptimized_TripletSumSmallerThanX(int[] array, int X)
	{
		System.out.println("Optimized Approach:");
		int numTriplets=0;
		// Two Pointers Approach requires us to sort the array beforehand
		Arrays.sort(array);

		// outer loop will start from 0 and end at 3rd to last element
		for (int i = 0; i <= array.length - 3; i++)
		{
			// Two Pointers Approach
			int left = i + 1;
			int right = array.length - 1;

			int currentElement = array[i];

			//In two pointer we don't know ahead of time how many time we have to update
			// the left and right pointers which is why we use a while loop instead of a for loop
			
			while (left < right)
			{
				int tripletSum=currentElement + array[left] + array[right];//constraint
				
				// move the right pointer in order to decrease the sum
				if (tripletSum >= X)
				{					
					//System.out.println("i,left, right: " + i+","+left+","+right);
					right--;
				} else if (tripletSum< X) //print all the triplets if the tripletSum < X
				{
					//System.out.println("i,left, right:" + i+","+left+","+right);
					//System.out.println("\tPair found {" + currentElement + "," + array[left] + "," + array[right] + "}");
					numTriplets+=(right-left);
					left++; // increment low
				}
			}
		}
		System.out.println("Triplets Found:"+numTriplets); //displaying blank space
	}
}
