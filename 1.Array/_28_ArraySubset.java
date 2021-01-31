
public class _28_ArraySubset
{

	public static void main(String[] args)
	{
		int[] superSet = { 11, 1, 13, 21, 3, 7 };
		int[] subSet = { 1, 3, 7 };
		//bruteForceArraySubset(superSet, subSet);
		optimizedArraySubset(superSet, subSet);
	}
	//TC=O(n^2) SC=O(1)
	public static void bruteForceArraySubset(int[] superSet, int[] subSet)
	{
		int matchingElements = 0;

		// checking subset in the superset
		for (int i = 0; i <= subSet.length - 1; i++)
		{
			for (int j = i + 1; j <= superSet.length - 1; j++)
			{
				// if the count of matching elements = size of the subset
				// when we know that the subSet is actually a subset.
				if (subSet[i] == superSet[j])
				{
					matchingElements++;
				}
			}
		}

		if (matchingElements == subSet.length)
		{
			System.out.println("subset is a part of superset");
		}
		else
		{
			System.out.println("subset isnt a part of superset");
		}
	}
	
	//TC=O(n)=O(superset.size) SC=O(n) due to creating an aux hash array
	public static void optimizedArraySubset(int[] superSet, int[] subSet)
	{
		//-------------------------Hashing----------------------//
		//hashing over the superset
		// 10^6 is random but larger than superset[max]=21
		int[] hashedSuperSet = new int[1000000];
		
		for(int i=0; i<=superSet.length-1; i++)
		{
			hashedSuperSet[superSet[i]]++;
		}
		
		int matchingElements = 0;
		
		for(int i=0; i<=subSet.length-1; i++)
		{
			// checking subset in the hashedSuperset
			if(hashedSuperSet[subSet[i]]>=1)
			{
				matchingElements++;
			}
		}
		
		if (matchingElements == subSet.length)
		{
			System.out.println("subset is a part of superset");
		}
		else
		{
			System.out.println("subset isnt a part of superset");
		}
		
	}
	
	
}
