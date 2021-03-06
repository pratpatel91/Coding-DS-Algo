import java.util.Arrays;

public class _2_PalindromicString
{

	public static void main(String[] args)
	{
		String originalWord = "abccba";

		char[] charArray = new char[originalWord.length()];

		// for loop to populate the stringarray
		for (int i = 0; i <= originalWord.length() - 1; i++)
		{
			charArray[i] = originalWord.charAt(i);
		}

		System.out.println(bruteForce_isStringAPalindrome(charArray));
		System.out.println(twoPointers_isStringAPalindrome(charArray));
	}

	// TC=O(n) SC=O(n)
	public static boolean bruteForce_isStringAPalindrome(char[] charArray)
	{
		// Since the string is internally stored as an array
		// this is why SC=O(n)

		char[] reverseCharArray = new char[charArray.length];

		// -----------------------Populating reversedWord-------------------//
		// for loop to iterate all the elements of the string in a reverse manner
		// we are iterating in a reverse manner becase we want to store the
		// last element of the originalWord as the first element of the reversedWord
		int j = 0;

		for (int i = charArray.length - 1; i >= 0; i--)
		{
			// Accumulating via string concatenation
			reverseCharArray[j] = charArray[i];
			j++;
		}

		// displaying reversechar array
		for (int i = 0; i <= reverseCharArray.length - 1;i++)
		{
			//System.out.println(reverseCharArray[i]);

			if (reverseCharArray[i] != charArray[i])
			{
				return false;
			}
		}

		return true;
	}

	// TC=O(n) SC=O(1)
	public static boolean twoPointers_isStringAPalindrome(char[] charArray)
	{
		int left = 0; // index
		int right = charArray.length - 1; // index

		while (left <= right)
		{
			//post increment operator
			//charArray[0] != charArray[last]
			//charArray[0+1] != charArray[last-1]
			if (charArray[left++] != charArray[right--])
			{
				return false;
			}
			// avoid infinite while loop
			//left++;
			//right--;
		}
		return true;
	}

}
