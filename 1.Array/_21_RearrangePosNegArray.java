
public class _21_RearrangePosNegArray
{

	public static void main(String[] args)
	{
		int[] array = { 1, 2, 3, -4, -1, 4 };
		//reArrangePosNegValues(array);
		bruteForceReArrangePosNegValues(array);
	}

	public static void printArray(int[] array)
	{
		for (int i = 0; i <= array.length - 1; i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println("\n");
	}
	//TC=O(n) SC=O(n) / O(array.length) due to creating two aux arrays
	public static void bruteForceReArrangePosNegValues(int array[])
	{
		int[] positiveArray = new int[array.length];
		int[] negativeArray = new int[array.length];
		
		int countNegatives = 0;
		int countPositives =0;
		
		//populating all negative elements into the negativeArray
		for (int i = 0; i < array.length; i++)
		{
			if(array[i]<0)
			{
				negativeArray[countNegatives]=array[i];
				countNegatives++;
			}
		}
		
		printArray(negativeArray);
		
		//populating all positive elements into the negativeArray
		for (int i = 0; i < array.length; i++)
		{
			if(array[i]>=0)
			{
				positiveArray[countPositives]=array[i];
				countPositives++;
			}
		}
		printArray(positiveArray);
		
		//Rewriting the Original array with the two arrays info
		//in a zipper merge fashion
		int pos_index = 0; //positive elements index
		int neg_index = 0;//negative elements index
		
		int i=0; //index to rewrite the original array
		//using a while loop (iterates over two variables)
		while(neg_index <countNegatives && pos_index <countPositives)
		{
			//1st, filling negatives into the original array
			array[i]=negativeArray[neg_index];
			i++;
			neg_index++;
			
			//2nd, filling positives into the original array
			array[i]=positiveArray[pos_index];
			i++;
			pos_index++;
		}
		while(neg_index <countNegatives)
		{
			//1st, filling negatives into the original array
			array[i]=negativeArray[neg_index];
			i++;
			neg_index++;
			
//			//2nd, filling positives into the original array
//			array[i]=positiveArray[pos_index];
//			i++;
//			pos_index++;
		}
		while(pos_index <countPositives)
		{
//			//1st, filling negatives into the original array
//			array[i]=negativeArray[neg_index];
//			i++;
//			neg_index++;
			
			//2nd, filling positives into the original array
			array[i]=positiveArray[pos_index];
			i++;
			pos_index++;
		}
		
		printArray(array);
		
	}

	public static void reArrangePosNegValues(int array[])
	{
		//TBD
		int[] newArray = new int[array.length];
		printArray(newArray);

		int newArray_index = 0;

		// 1st, filling all the negative values
		for (int i = 0; i < array.length; i++)
		{
			if (array[i] < 0)
			{
				newArray[newArray_index] = array[i];
				newArray_index += 2;
			}
		}
		printArray(newArray);

		// 2nd, filling all the positive values into a new array
		newArray_index = 1;

		// made it array.length-1 to prevent index out of bounds error
		// Index 7 out of bounds for length 6
		for (int i = 1; i < array.length; i++)
		{

			if (array[i] > 0)
			{
				newArray[newArray_index] = array[i];
				newArray_index += 2;
			}
			if (array[i] == 0)
			{
				newArray[newArray_index] = array[i];
				newArray_index++;
			}
		}
		printArray(newArray);

		// 3rd, Inserting every element from the newarray back into the original array
		for (int i = 0; i < newArray_index; i++)
		{
			array[i] = newArray[i];
		}
		printArray(newArray);
	}
}
