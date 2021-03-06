
public class _27_KthElementOfTwoSortedArrays
{

	public static void main(String[] args)
	{
		int[] A = { 2, 3, 6, 7, 9 };
		int[] B = { 1, 4, 8, 10 };
		int k = 5;
		System.out.println(kthElementInSortedArrays(A, B, k));
	}

	public static int kthElementInSortedArrays(int[] A, int[] B, int k)
	{
		int n = A.length;
		int m = B.length;

		// For tracking element comparison
		int i = 0;
		int j = 0;

		while (i < n && j < m)
		{
			int currA = A[i];
			int currB = B[j];

			// comparing elements and picking answer to be smallest value
			if (currA >= currB)
			{
				if (k == 1)
				{
					return currB;
				} else
				{
					j++;// B[] contains the smaller element
				}
			} else
			{
				if (k == 1)
				{
					return currA;
				} else
				{
					i++;// A[] contains the smaller element
				}
			}
			k--;
		}

		while (i < n)
		{
			if (k == 1)
			{
				return A[i];
			} else
			{
				i++;
				k--;// A[] contains the smaller element
			}
		}

		while (j < m)
		{
			if (k == 1)
			{
				return B[j];
			} else
			{
				j++;
				k--;// A[] contains the smaller element
			}
		}

		return -1;
	}

//	public static int kthElementInSortedArrays(int[] A, int[] B, int k)
//	{
//		int sortedElement = 0;
//		int kthElement = 0;
//		int n = A.length;
//		int m = B.length;
//
//		// For tracking element comparison
//		int i = 0;
//		int j = 0;
//
//		while (i < n && j < m)
//		{
//			int currA = A[i];
//			int currB = B[j];
//
//			// comparing elements and picking answer to be smallest value
//			if (currA >= currB)
//			{
//				j++;// B[] contains the smaller element
//				kthElement = currB;
//			} else
//			{
//				i++;// A[] contains the smaller element
//				kthElement = currA;
//			}
//			sortedElement++;
//
//			if (sortedElement == k)
//			{
//				return kthElement;
//			}
//		}
//
//		while (i < n)
//		{
//			kthElement = A[i];
//			i++;
//			sortedElement++;
//
//			if (sortedElement == k)
//			{
//				return kthElement;
//			}
//		}
//		
//		while (j < m)
//		{
//			kthElement = B[j];
//			j++;
//			sortedElement++;
//
//			if (sortedElement == k)
//			{
//				return kthElement;
//			}
//		}
//
//		return -1;
//	}

}
