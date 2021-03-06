public class _1_ReverseString
{

	public static void main(String[] args)
	{
		String originalWord = "abcdefg";
		
		// System.out.println(bruteForce_reverseString(originalWord));
		
		char[] stringArray = new char[originalWord.length()];
		
		//for loop to populate the stringarray
		//char[] stringArray= originalWord.toCharArray();
		
		for (int i=0; i<=originalWord.length()-1;i++)
		{
			stringArray[i]=originalWord.charAt(i);
		}
		
		System.out.println(twoPointers_reverseString(stringArray));
	}

	// BruteForce Method TC=O(n) SC=O(n)
	// Store the string into a character array
	// print the character array in reverse
	public static String bruteForce_reverseString(String originalWord)
	{
		// Since the string is internally stored as an array
		// this is why SC=O(n)
		String reversedWord = ""; // accumulator variable for string

		// -----------------------Populating reversedWord-------------------//
		// for loop to iterate all the elements of the string in a reverse manner
		// we are iterating in a reverse manner becase we want to store the
		// last element of the originalWord as the first element of the reversedWord
		for (int i = originalWord.length() - 1; i >= 0; i--)
		{
			// Accumulating via string concatenation
			reversedWord = reversedWord + originalWord.charAt(i);
		}
		return reversedWord;
	}

	// BruteForce Method TC=O(n) SC=O(1)
	public static char[] twoPointers_reverseString(char[] originalWord)
	{
		int left = 0; // index
		int right = originalWord.length - 1; // index
		//System.out.println("left: " + left + ", right: " + right);
		
		while (left <= right)
		{
			swapChars(originalWord,left,right);
			//System.out.println("left: " + left + ", right: " + right);
			left++;
			right--;
		}
		return originalWord;
	}
	
	public static void swapChars(char[] originalWord, int left, int right)
	{
		//Swapping elements in the string
		char temp = originalWord[left];
		originalWord[left]=originalWord[right];
		originalWord[right]=temp;
	}
	
	
}