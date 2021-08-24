import java.util.Arrays;
import java.util.Comparator;

public class DP_MaxLengthOfPairChain
{
	public int findLongestChain(int[][] pairs)
	{
		Arrays.sort(pairs, new Comparator<>()
		{
			public int compare(int[] p1, int[] p2)
			{
				if (p1[0] == p2[0])
				{
					return p1[1] - p2[1]; // ascending for second value
				}
				return p1[0] - p2[0]; // ascending for first value
			}
		});

		int[] lis = new int[pairs.length];

		lis[0] = 1; // assumption
		int maxLis = 1; // handling 1 pair inputs & decreasing pairs

		for (int i = 1; i < pairs.length; i++)
		{
			lis[i] = 1;

			for (int j = 0; j < i; j++)
			{
				if (pairs[i][0] > pairs[j][1] && lis[j] + 1 > lis[i])
				{
					lis[i] = lis[j] + 1;
					maxLis = lis[i];
				}

			}
		}
		return maxLis;
	}
}
