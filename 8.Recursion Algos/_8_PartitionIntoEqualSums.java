//Recursion (adding cache makes it a DP Problem)
public class _8_PartitionIntoEqualSums
{
	public static void main(String[] args)
	{
		int[] partitions = { 1, 5, 5, 12 };
		System.out.println(canPartition(partitions));
	}

	public static boolean canPartition(int[] partitions)
	{
		int sum = 0;
		
		for(int i=0; i<partitions.length;i++)
		{
			sum+=partitions[i];
		}
		
		if(sum %2 ==1) //odd check
		{
			return false;
		}
		return utilPartition(partitions,sum/2,0);
	}

	public static boolean utilPartition(int[] partitions, int sum, int currPos)
	{
		//two base cases
		if(sum == 0)
		{
			return true;
		}
		
		if(currPos==partitions.length && sum!=0)
		{
			return false;
		}
		
		if(partitions[currPos]>sum)
		{
			return utilPartition(partitions, sum, currPos+1);
		}
		//include OR exclude (common pattern in dp)
		return utilPartition(partitions, sum, currPos+1) || utilPartition(partitions, sum-partitions[currPos], currPos+1);
		
	}

	
}
