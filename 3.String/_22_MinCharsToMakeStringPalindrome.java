import org.w3c.dom.Text;

public class _22_MinCharsToMakeStringPalindrome
{

	public static void main(String[] args)
	{
		String text = "AAA";
		System.out.println("Answer from naive:"+naiveMinCharsNeededForPalindrome(text));
		optimizedMinCharsNeededForPalindrome(text);
//		int start =0;
//		int end = text.length()-1;
//		
//		System.out.println(isPalindrome(text,start,end));
//		
//		System.out.println(isPalindromeReverseString(text));
	}

	// TC=O(n^2) SC =O(1)
	public static int naiveMinCharsNeededForPalindrome(String text)
	{
		// traverse the entire string
		// iteration1: check AC
		// iteration2: check BC
		int answer = 0;

		for (int i = 0; i <= text.length() - 1; i++)
		{
			System.out.print("Current String to check for palindrome:");

//			//this is just to see the text
//			for (int j=i; j<=text.length()-1;j++)
//			{
//				System.out.print(text.charAt(j));
//			}

			System.out.println("");

			if (isPalindrome(text, i, text.length() - 1)) // TC=O(n)
			{
				return answer;
			} else
			{
				answer++; // finding more unbalanced characters
			}
		}
		return answer;
	}

	// TC=O(n) SC =O(1)
	public static boolean isPalindrome(String text, int start, int end)
	{
		while (start <= end) // = to handle single chars
		{
			System.out.println("Start:" + start + ", Start Char:" + text.charAt(start) + ", End:" + end + ", End Char:"
					+ text.charAt(end));
			if (text.charAt(start) != text.charAt(end))
			{
				return false;
			}
			// two pointers approach
			start++;
			end--;
		}
		return true;
	}

	// TC=O(n) SC =O(1)
	public static boolean isPalindromeReverseString(String text)
	{
		// using char array as strings are immutable (cannot be altered)
		System.out.println("..calling isPalindromeReverseString() ");

		// ------------String Reversal --------------/
		StringBuilder duplicateString = new StringBuilder();
		duplicateString.append(text); // "GABDBAG"
		String reverseString = duplicateString.reverse().toString();// to string method coverts string builder into a
																	// string

		// comparing original vs reversed strings
		for (int i = 0; i <= text.length() - 1; i++)
		{
			if (text.charAt(i) != reverseString.charAt(i))
			{
				return false;
			}
		}
		return true;
	}

	// OPTIMIZED KMP
	// TC= O(n) performs better in best case relative to above functions
	// SC=O(n) due to creating an LPS Array
	public static void optimizedMinCharsNeededForPalindrome(String text)
	{
		// ------------String Reversal --------------/
		StringBuilder duplicateString = new StringBuilder();
		duplicateString.append(text); // "GABDBAG"
		String reverseString = duplicateString.reverse().toString();// to string method coverts string builder into a
																	// string

		// creating a 2 length string (text + reverse text)
		StringBuilder combinedString = new StringBuilder();
		combinedString.append(text).append(",").append(reverseString);

		System.out.println("combinedstring:" + combinedString.toString());
		
		int prefixSuffixCharMatch = LongestPrefixSumArray(combinedString.toString());
		System.out.println("LPS:"+prefixSuffixCharMatch);

		System.out.println("Min Chars Needed to Make Palindrome:" + (text.length() - prefixSuffixCharMatch));
	}

	public static int LongestPrefixSumArray(String text)
	{
		// LPS array holds # of matching prefix and suffixes in the pattern
		int[] LPS = new int[text.length()];

		LPS[0] = 0;// 1st character in the pattern doesnt have a prefix

		// populating the LPS
		int j = 0;

		for (int i = 1; i <= text.length() - 1;)
		{
			if (text.charAt(i) == text.charAt(j))
			{
				j++;
				LPS[i] = j;
				i++;
			} else
			{
				if (j != 0)
				{
					j = LPS[j - 1]; // prevents index out of bounds
				} else
				{
					LPS[i] = 0;
					i++;
				}
			}
		}
		
//		//printing lps array
//		for(int i=0; i<=LPS.length-1;i++)
//		{
//			
//		}
		return LPS[text.length() - 1];
	}

}
