

public class _26_Convert_StringA_Into_StringB_Using_Min_Operations
{

	public static void main(String[] args)
	{
		String A = "EACBD";
		String B = "EABCD";
		System.out.println(minOperationsForAToMatchB(A, B));
	}

	public static int[] hashString(String string)
	{
		int[] hashArray = new int[26];

		for (int i = 0; i <= string.length() - 1; i++)
		{
			hashArray[string.charAt(i) - 'A']++;
		}
		return hashArray;
	}

	public static int minOperationsForAToMatchB(String A, String B)
	{
		int[] hash_A = hashString(A);
		int[] hash_B = hashString(B);

		// if the characters in the the strings are mismatching
		// then the hashing freq will also mismatch thus we can
		// return -1 here
		for (int i = 0; i <= hash_A.length - 1; i++)
		{
			if (hash_A[i] != hash_B[i])
			{
				return -1;
			}
		}

		// Handling 2 strings with different lengths
		int sizeA = A.length() - 1;
		int sizeB = B.length() - 1;

		// -------------Char comparison--------------------//
		int i = sizeA;
		int j = sizeB;
		int minOperations = 0;

		while (i >= 0)
		{
			//inner while loop needs i>=0 to prevent index out of bounds error
			while (i>=0 && A.charAt(i) != B.charAt(j))
			{
				System.out.println("String_A's Char:"+A.charAt(i)+" doesnt match String_B's Char:"+B.charAt(j));		
				minOperations++;
				System.out.println("Moving A_Char to the front:" + A.charAt(i) + ", minOperations:"+minOperations);
				i--;
			}
			//System.out.println("A_Char:"+A.charAt(i)+", B_Char:"+B.charAt(j));
			if (i>=0 && A.charAt(i) == B.charAt(j))
			{
				System.out.println("String_A's Char:"+A.charAt(i)+" matches String_B's Char:"+B.charAt(j));				
				i--;
				j--;
			}
		}
		return minOperations;
	}

}
