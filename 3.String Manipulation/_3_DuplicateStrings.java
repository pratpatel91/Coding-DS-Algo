
public class _3_DuplicateStrings
{

	public static void main(String[] args)
	{
		String originalWord = "abb";

		char[] charArray = new char[originalWord.length()];

		// for loop to populate the stringarray
		for (int i = 0; i <= originalWord.length() - 1; i++)
		{
			charArray[i] = originalWord.charAt(i);
		}

		bruteForce_isStringDuplicate(charArray);
	}

	public static void bruteForce_isStringDuplicate(char[] charArray)
	{
		int[] charFreq = new int[26]; // 255 supports A-Z, a-z + misc
										// 26 supports a-z

		// populating charFreq
		for (int i = 0; i <= charArray.length - 1; i++)
		{
			charFreq[charArray[i] - 'a']++;
		}

		// displaying charFreq
		for (int i = 0; i <= charFreq.length - 1; i++)
		{
			if (charFreq[i] > 0)
			{
				int asciOfA = 'a'; //97
				int i_smallChars = i + asciOfA;
				char character = (char) i_smallChars;
				System.out.println("char: " + character + ", freq: " + charFreq[i]);
			}
		}
	}

}
