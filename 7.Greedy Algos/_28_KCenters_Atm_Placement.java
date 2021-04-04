public class _28_KCenters_Atm_Placement
{

	public static void main(String[] args)
	{
		int[][] graph = { { 0, 10, 7, 6 }, { 10, 0, 8, 5 }, { 7, 8, 0, 12 }, { 6, 5, 12, 0 } };
		int atms = 2;
		atmPlacementForMinDist(graph,atms);
	}

	public static void atmPlacementForMinDist(int[][] graph, int atms)
	{
		int[] minDist = new int[graph[0].length]; //optimizing array
		
		for(int i=0;i<=minDist.length-1;i++)
		{
			minDist[i]=Integer.MAX_VALUE;
		}
		
		int[] atmPlaced = new int[atms];
		
		int maxDistToATM=0;
		
		for(int i=0;i<atms;i++)
		{
			atmPlaced[i]=maxDistToATM;
			//calculating min dist for all cities relative to placed ATM
			for(int j=0; j<=graph.length-1;j++)
			{
				System.out.println("minDist:"+minDist[j] + ", graph:"+graph[maxDistToATM][j]);
				minDist[j]=Math.min(minDist[j], graph[maxDistToATM][j]);
			}
			
			for(int k=0;k<=minDist.length-1;k++)
			{
				System.out.print(minDist[k]+" ");
			}
			System.out.println();
			
			maxDistToATM=furthestCity(minDist);
		}
		
		System.out.println("maxDistToATM:"+minDist[maxDistToATM]);
		
		for(int i=0;i<=atmPlaced.length-1;i++)
		{
			System.out.print(atmPlaced[i] + " ");
		}
	}
	
	public static int furthestCity(int[] array)
	{
		int max = Integer.MIN_VALUE;
		int minDist=0;
		
		for(int i=0;i<=array.length-1;i++)
		{
			if(array[i]>max)
			{
				max=array[i];
				minDist=i;
			}
		}
		return minDist;
	}
}
