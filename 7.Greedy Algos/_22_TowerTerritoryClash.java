import java.util.Arrays;

public class _22_TowerTerritoryClash
{
	public static void main(String[] args)
	{
		//tower positions
		int[] x = {3,8,11};
		int[] y = {8,2,6};
		
		//board size
		int row = 15;
		int cols=8;
		
		Arrays.sort(x);
		Arrays.sort(y);
		
		int max_X=Integer.MIN_VALUE;
		int max_Y=Integer.MIN_VALUE;
		
		// length-2 so  that i+1+1 gives length-1
		for(int i=0;i<=x.length-2;i++)
		{
			max_X=Math.max(max_X,x[i+1]-x[i]);
			max_Y=Math.max(max_Y,y[i+1]-y[i]); // since x and y are the same array size
		}
		
		int clashes=(max_X-1)*(max_Y-1);
		
		System.out.println("Clashes:"+clashes);
	}

}
