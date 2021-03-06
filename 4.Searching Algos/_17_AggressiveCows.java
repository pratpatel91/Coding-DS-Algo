import java.util.Arrays;
import java.util.Scanner;

public class _17_AggressiveCows
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();// test cases

		while (T > 0)
		{
			int num_Stalls = input.nextInt();
			int cows = input.nextInt();
			int[] stalls = new int[num_Stalls];

			for (int i = 0; i <= stalls.length - 1; i++)
			{
				stalls[i] = input.nextInt();
			}

			Arrays.sort(stalls);

			System.out.println(maxDistance(stalls, cows));
		}
	}

	public static int maxDistance(int[] stalls, int cows)
	{
		int low = 1;// min distance between stalls for 2 cows is 1
		int high = (stalls[stalls.length - 1] - stalls[0]);// max distance between stalls for 2 cows
		int maxDistance = Integer.MIN_VALUE;

		// Basic Binary Search (core logic is contained in isDistFeasible())
		while (low <= high)
		{
			int mid_dist = (low + high) / 2; // for int overflow mid=low+(high-low)/2
			//System.out.println("mid_dist:"+mid_dist);
			
			if (isDistFeasible(stalls, cows, mid_dist))
			{
				maxDistance = mid_dist;
				low = mid_dist + 1;// searching right half of the array to maximize maxDistance
				System.out.println("feasible distance:" + mid_dist + ", lets search in {" + low + "-" + high + "}");
			} else
			{
				high = mid_dist - 1;// searching left half of the array to maximize maxDistance
			}
		}
		return maxDistance;
	}

	public static boolean isDistFeasible(int[] stalls, int cows, int dist)
	{
		int cowPlaced = 1;
		int prev = 0;
		
		for (int i = 1; i <= stalls.length - 1; i++)
		{
			if (stalls[i] - stalls[prev] >= dist)
			{
				cowPlaced++;
				prev = i;
			}
			//optimization to make it run less than O(n) incase if we find the answer
			if (cowPlaced == cows)
			{
				System.out.println("dist:"+dist+", cowPlaced:"+cowPlaced);
				return true;
			}
			
		}
		System.out.println("dist:"+dist+", cowPlaced:"+cowPlaced);
		return false;
	}

}
