import java.util.Arrays;

public class _29_BinarySearch_EKO_TreeCutting
{

	public static void main(String[] args)
	{
		int[] treeHeights = { 4, 42, 40, 26, 46 };
		int woodRequired = 20;

		// In order to use binary search we need to first
		// sort the array
		Arrays.sort(treeHeights);

		System.out.println(bs_optimalSawHeight(treeHeights, woodRequired));
	}

	public static int bs_optimalSawHeight(int[] treeHeights, int woodRequired)
	{
		int optimalSawHeight = 0;
		int left_Height = 1;// the min required wood is 1
		int right_Height = treeHeights[treeHeights.length - 1];

		// if i did while(left_Height < right_Height) then
		// i would have to set left_Height = mid_Height in order to avoid an infinite while loop
		
		while (left_Height <= right_Height) // mid_height < mid_Height-1
		{
			int accumWoodCut = 0;

			int mid_Height = (right_Height + left_Height) / 2;

			for (int i = 0; i <= treeHeights.length - 1; i++)
			{
				if (treeHeights[i] > mid_Height)
				{
					accumWoodCut += (treeHeights[i] - mid_Height);
				}
			}

			// Decision Making Logic for Printing the Answer
			if (accumWoodCut >= woodRequired)
			{
				optimalSawHeight = mid_Height;
				left_Height = mid_Height + 1;
			} else // if we havent cut enough wood to meet the requirement
			{
				right_Height = mid_Height - 1;
			}
		}
		return optimalSawHeight;
	}

}
