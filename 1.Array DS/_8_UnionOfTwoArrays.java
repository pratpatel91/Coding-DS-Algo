import java.util.Scanner;

public class _8_UnionOfTwoArrays
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();

		while (T > 0)
		{
			int arrayLength_A = input.nextInt();
			int arrayLength_B = input.nextInt();

			int[] array_A = new int[arrayLength_A];
			int[] array_B = new int[arrayLength_B];

			for (int i = 0; i <= arrayLength_A - 1; i++)
			{
				array_A[i] = input.nextInt();
			}

			for (int i = 0; i <= arrayLength_B - 1; i++)
			{
				array_B[i] = input.nextInt();
			}

			System.out.println(unionOfTwoArrays(array_A, array_B));
		}
	}
	//TC=O(n) due to 1 for loop
	//SC = O(maxvalue of arrayA or arrayB)
	public static int unionOfTwoArrays(int[] array_A, int[] array_B)
	{
		// hashing (set to a size that is larger than max value)
		int[] hashArray = new int[100000];

		int unionCount = 0;

		for (int i = 0; i < array_A.length; i++)
		{
			// checking for unique values
			if (hashArray[array_A[i]] == 0)
			{
				unionCount++;
				hashArray[array_A[i]]++;
			}
		}

		for (int i = 0; i < array_B.length; i++)
		{
			// checking for unique values
			if (hashArray[array_B[i]] == 0)
			{
				unionCount++;
				hashArray[array_B[i]]++;
			}
		}
		return unionCount;
	}

}
