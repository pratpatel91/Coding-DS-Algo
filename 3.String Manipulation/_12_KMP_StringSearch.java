
public class _12_KMP_StringSearch
{

	public static void main(String[] args)
	{
		String text = "nitnipnitnis";
		String pattern = "nitnis";
		// naiveStringSearch(text, pattern);
		knuthMorisPratStringSearch(text, pattern);
	}

	// Brute Force TC=O(n*m) SC=O(1)
	public static void naiveStringSearch(String text, String pattern)
	{
		System.out.println("------naive String Search---------------");
		int textSize = text.length();
		int patternSize = pattern.length();

		System.out.println("Pattern: " + pattern);
		System.out.print("Text: " + text);

		System.out.println("");

		// allows us to reset matchedChars per every substring
		int matchedChars = 0;

		// Core Logic
		for (int i = 0; i <= textSize - patternSize; i++)
		{
			System.out.println("");
			matchedChars = 0;
			System.out.print("Resetting matched char: " + matchedChars + "\n");
			for (int j = 0; j < pattern.length(); j++)
			{
				if (text.charAt(i + j) != pattern.charAt(j))
				{
					System.out.println("Mismatch Char");
				} else
				{
					System.out.println("Matched Char");
					matchedChars++;
				}
				System.out.print("Matched char: " + matchedChars + "\n");
			}
		}
		// Decision Making Logic
		if (matchedChars == patternSize)
		{
			System.out.println("pattern found in the text");
		}
		System.out.println("-------------------------------------------");
	}

	// Optimized TC=O(m+n) SC=O(n) due to creating a shift array
	// Using arrays to do KMP string search
	public static void knuthMorisPratStringSearch(String text, String pattern)
	{
		int[] LPS = LongestPrefixSumArray(pattern);
		
		// printing the lps array
		for (int i = 0; i <= LPS.length - 1; i++)
		{
			System.out.print(LPS[i] + " ");
		}
		
		int i=0;
		int j=0;
		
		for(i=0; i<=text.length()-1;)
		{
			//independant block
			if(pattern.charAt(j)==text.charAt(i))
			{
				System.out.print("\npat char: " + pattern.charAt(j) + ", txt char: " + text.charAt(i));
				System.out.print(", i:" + i +", j:"+j);
				i++;
				j++;
			}
			
			//dependant block
			if(j==pattern.length())
			{
				System.out.println("\n\tPattern starts at i="+ (i-j));
				j=LPS[j-1] ; 
				
			}
			else if (pattern.charAt(j)!=text.charAt(i))
			{
				if (j != 0)
				{
					j = LPS[j - 1]; // prevents index out of bounds
				} else
				{
					i++;
				}
			}
		}
	}

	public static int[] LongestPrefixSumArray(String pattern)
	{
		// LPS array holds # of matching prefix and suffixes in the pattern
		int[] LPS = new int[pattern.length()];

		LPS[0] = 0;// 1st character in the pattern doesnt have a prefix

		// populating the LPS
		int j = 0;

		for (int i = 1; i <= pattern.length() - 1;)
		{
			if (pattern.charAt(i) == pattern.charAt(j))
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

		return LPS;

	}
}
