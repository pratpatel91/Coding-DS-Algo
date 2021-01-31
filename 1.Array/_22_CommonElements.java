
public class _22_CommonElements
{

	public static void main(String[] args)
	{
		int[] A = { 1, 5, 10, 20, 40, 80 };
		int[] B = { 6, 7, 20, 80, 100 };
		int[] C = { 3, 4, 15, 20, 30, 70, 80, 120 };

		// bruteForceCommonAcross3Arrays(A, B, C);
		optimizedCommonAcross3Arrays(A, B, C);
	}

	// TC=O(n^3) SC=O(1)
	public static void bruteForceCommonAcross3Arrays(int[] A, int[] B, int[] C)
	{
		for (int i = 0; i < A.length; i++)
		{
			for (int j = 0; j < B.length; j++)
			{
				for (int k = 0; k < C.length; k++)
				{
					if (A[i] == B[j] && A[i] == C[k]) // A[i]=B[k]=C[k]
					{
						System.out.println(A[i]);// print element A[i]
					}
				}
			}
		}
	}

	// TC=O(n) SC=O(n) / O(max(b[max], c[max])) due to creating 2 hash
	public static void optimizedCommonAcross3Arrays(int[] A, int[] B, int[] C)
	{

		int[] hashB = new int[1000000]; // MIN= Max of B + 1 and MAX= 10^6(random)
		int[] hashC = new int[1000000]; // MIN= Max of C + 1 and MAX= 10^6(random)

		// Hashing of Array B
		for (int i = 0; i < B.length; i++)
		{
			hashB[B[i]]++;
		}

		// Hashing of Array C
		for (int i = 0; i < C.length; i++)
		{
			hashC[C[i]]++;
		}

		// 1st, we iterate the array A (hashing is not needed because we are iterating
		// array A)
		for (int i = 0; i < A.length; i++)
		{
			if (hashC[A[i]] > 0 && hashB[A[i]] > 0) // A[i]=hashB[A[i]]=hashC[A[i]]
			{
				System.out.println(A[i]);// print element A[i]
			}
		}
	}

}
