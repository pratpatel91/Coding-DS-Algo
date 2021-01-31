
public class _16_FindPivotInSortedRotatedArray
{

	public static void main(String[] args)
	{
		int[] array = { 4, 5, 1, 2, 3 };
		System.out.println(binarySearch_findPivotinSortedRotatedArray(array));
	}
	//TC=O(log n) SC=O(1)
	public static int binarySearch_findPivotinSortedRotatedArray(int array[])
	{
		int left = 0;
		int right = array.length - 1;

		int pivot = 0;

		while (left < right)
		{
			int mid = left + (right - left) / 2;// to prevent int overflow error
			System.out.println("left:" + left + ", mid:" + mid + ", right:" + right);

			// -------Modified Binary Search----------//
			if (mid < right && array[mid] > array[mid + 1])
			{
				System.out.println("pivot is set to mid");
				pivot = mid;
				return pivot;
			}
			if (mid > left && array[mid] < array[mid - 1])
			{
				System.out.println("pivot is set to mid-1");
				pivot = mid - 1;
				return pivot;
			}
			// -------Regular Binary Search----------//
			if (array[left] >= array[mid])
			{
				System.out.println("right is set to mid-1");
				right = mid - 1;
			} else
			{
				System.out.println("left is set to mid+1");
				left = mid + 1;
			}
		}
		return -1;
	}
}
