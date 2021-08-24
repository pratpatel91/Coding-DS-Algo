
public class DP_ArrangeBuildings
{

	public static void main(String[] args)
	{
		System.out.println("tab_binStrings: "+ tab_arrangeBuildings(3));
		System.out.println("adhoc_binStrings: "+ adhoc_arrangeBuildings(3));
	}
	
	//TC=O(N) SC=O(N)
	public static int tab_arrangeBuildings(int length)
	{
		int[] waysToBuildOnLeft = new int[length+1];
		int[] waysToBuildOnRight= new int[length+1];
		
		waysToBuildOnLeft[1]=1;
		waysToBuildOnRight[1]=1;
		
		for(int i=2; i<=length;i++)
		{
			waysToBuildOnLeft[i]=waysToBuildOnLeft[i-1]+waysToBuildOnRight[i-1];
			waysToBuildOnRight[i]=waysToBuildOnLeft[i-1];
		}
		//variation from DP_BinaryStringWithoutConseq1s
		int totalWays= waysToBuildOnLeft[length]+waysToBuildOnRight[length];
		return totalWays*totalWays;
	}
	
	//TC=O(N) SC=O(1) a+b=c
	public static int adhoc_arrangeBuildings(int length)
	{
		int oldLeftWays = 1;
		int oldRightWays = 1;
		
		for(int i=2; i<=length;i++)
		{
			int newLeftWays = oldLeftWays + oldRightWays;
			int newRightWays =oldRightWays;
			
			oldLeftWays=newRightWays;
			oldRightWays=newLeftWays;
		}
		//variation from DP_BinaryStringWithoutConseq1s
		int total =oldLeftWays+oldRightWays;
		return total*total;
	}
}
