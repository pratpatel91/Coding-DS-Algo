import java.util.Arrays;

public class _17_MinimizeArrayDiff
{
	public static void main(String[] args)
	{
		//since we want to minimize the diff 
		int[] A = {1,2,3};
		int[] B = {4,2,1};
		computeMinDiffSumBetweenTwoArrays(A, B);
	}
	
	public static void computeMinDiffSumBetweenTwoArrays(int[] A, int[] B)
	{
		Arrays.sort(B);//sorting to minimize aka greedy approach
		
		int minDiff=0;
		for(int i=0;i<=A.length-1;i++)
		{
			minDiff=Math.abs(A[i]-B[i]);
		}
		System.out.println("MinDiff: "+minDiff);
	}

}
