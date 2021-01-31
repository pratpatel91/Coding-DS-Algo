
public class _3_SearchInARotatedArray
{
	public static void main(String[] args)
	{
		// rotated sorted array 
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };

		int target = 2;

		System.out.println(binarySearchInARotatedArray(nums, target));
	}

	// TC=O(logn)
	public static int binarySearchInARotatedArray(int[] nums, int target)
	{
		// Two Pointers Approach for Binary Search
		int left = 0;
		int right = nums.length - 1;

		while (left <= right)
		{
			int mid = (right + left) / 2;//pivot

			if (nums[mid] == target)
			{
				return mid;
			}

			// if the left half of the array is sorted
			if (nums[left] < nums[mid])
			{
				if (target>=nums[left] && target <=nums[mid])
				{
					right = mid ; //search the left half
				} else
				{
					left = mid + 1; //search the right half
				}
			} 
			else //  if the right half of the array is sorted
			{
				if (target>=nums[mid] && target <=nums[right])
				{
					left=mid; //search the right half
				} else
				{
					right=mid-1; //search the left half
				}
			}
		}
		return -1;
	}
}
