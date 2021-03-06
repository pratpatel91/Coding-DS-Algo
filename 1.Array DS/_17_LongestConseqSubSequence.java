import java.util.Arrays;

public class _17_LongestConseqSubSequence
{
	public static void main(String[] args)
	{
		int[] array = { 2, 6, 1, 9, 4, 5, 3 };
		System.out.println(longestConseqSubSequence(array));
	}

	public static int longestConseqSubSequence(int[] array)
	{
		int currentMaxConseqCount = 1; // 1 element is also a subsequence
		int answer = 0;

		// sorting before finding consecutive subsequence
		Arrays.sort(array); // 1,2,3,4,5,6,9

		for (int i = 0; i < array.length - 1; i++)
		{
			// checking to see if the next element is consecutive
			if (array[i + 1] == array[i] + 1) // a[2]=a[1]+1
			{
				currentMaxConseqCount++;
			} else
			{
				currentMaxConseqCount = 1;
			}
			if (currentMaxConseqCount > answer)
			{
				answer = currentMaxConseqCount;// 2,3,4,5,6
			}
		}

		return answer; // 6
	}

}
