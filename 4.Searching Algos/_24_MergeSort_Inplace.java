import java.util.Arrays;

public class _24_MergeSort_Inplace
{
	//TC=O(n^2logN) SC=O(1)
	public static void main(String[] args)
	{
		int[] array = { 1, 5, 6, 4, 7, 8 };
		int start = 0;
		int end = array.length - 1;
		int mid = (start + end) / 2;
		// --------------------Variation Problem -----------------------------------//
		System.out.println("Out of Place Elements:" + mergeTwoSortedArrays(array, start, mid, end));
	}

	public static int mergeTwoSortedArrays(int[] array, int start, int mid, int end)
	{
		int i = start; // left sorted array = [0.....mid]
		int j = mid + 1; // right sorted array = [mid+1......array.length-1]
		int outOfPlaceElements = 0;

		// checking to see if the array is sorted
		if (array[mid] <= array[mid + 1])
		{
			return 0; // array is sorted
		}
		System.out.println(Arrays.toString(array));
		// traversing both the sorted arrays till the end
		while (i <= mid && j <= end)
		{
			// checking if the current element of the left array is at its correct position
			if (array[i] <= array[j])
			{
				i++;
			} else // we need temp variable
			{
				int temp = array[j];
				int index = j;
				outOfPlaceElements++; // temp is an out of place element

				// shifting all the elements to the left by 1
				// in the right array to make it sorted again
				while (index > i)
				{
					// setting the current to previous aka left shifted by 1
					array[index] = array[index - 1];
					index--;

					// --------------------Variation Problem -----------------------------------//
					outOfPlaceElements++; // all the shifted elements are out of place element
				}
				System.out.println(Arrays.toString(array));
				array[i] = temp;
			}
		}
		System.out.println(Arrays.toString(array));
		return outOfPlaceElements;
	}
}
