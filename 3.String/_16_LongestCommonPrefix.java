

import java.util.Arrays;

public class _16_LongestCommonPrefix
{
	public static void main(String[] args)
	{
		String[] array = { "flower","flow","flight" };
		sortArray(array); // TC=O(n log n)
		longestCommonPrefix(array); // TC=O(n)
	}

	public static void longestCommonPrefix(String[] array)
	{
		// Due to sorting (the elements are lexicographic)
		int firstWordsLength = array[0].length();
		int lastWordsLength = array.length - 1;

		String longestCommonPrefix = "";

		System.out.println("\n");

		// Due to sorting we only have to compare the end points (matching chars for the end points
		//takes into account all the elements in between thus it helps in calculating the longest common prefix)
		for (int i = 0; i < firstWordsLength; i++)
		{
			// If the characters match then add the character to the answer
			if (array[0].charAt(i) == array[lastWordsLength].charAt(i))
			{
				System.out.println("comparing " + array[0].charAt(i) + " against " + array[lastWordsLength].charAt(i));
				longestCommonPrefix += array[0].charAt(i);
			}
			// stopping the for loop incase if the characters dont match
			else
			{
				break;
			}
		}
		System.out.println("Longest Common Prefix:" + longestCommonPrefix);
	}

	public static void sortArray(String[] array)
	{
		System.out.print("\nBefore Sorting the Array: ");
		printArray(array);
		Arrays.sort(array);
		System.out.print("\nAfter Sorting the Array:");
		printArray(array);
	}

	public static void printArray(String[] array)
	{
		for (int i = 0; i <= array.length - 1; i++)
		{
			System.out.print(array[i] + " ");
		}
	}

}
