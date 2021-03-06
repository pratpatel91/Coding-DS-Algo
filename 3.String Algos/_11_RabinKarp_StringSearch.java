
public class _11_RabinKarp_StringSearch
{
	public static void main(String[] args)
	{
		String text = "aab";
		String pattern = "ab";
		naiveStringSearch(text, pattern);

		// ---------Converting string into char arrays --------------//
		char[] txt = new char[text.length()];

		for (int i = 0; i <= text.length() - 1; i++)
		{
			char currentChar = text.charAt(i);
			txt[i] = currentChar;
		}

		char[] pat = new char[pattern.length()];

		for (int i = 0; i <= pattern.length() - 1; i++)
		{
			char currentChar = pattern.charAt(i);
			pat[i] = currentChar;
		}

		
		rabinKarpStringSearch(txt, pat);
	}

	// Brute Force TC=O(n*m) SC=O(1)
	public static void naiveStringSearch(String text, String pattern)
	{
		System.out.println("\n------Naive String Search---------------");
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
		} else
		{
			System.out.println("pattern isnt found in the text");
		}
	}

	// Optimized TC=O(m(n-m+1)) SC=O(n) due to creating a hash array
	// Using Hashing to do rabin karp string search
	public static void rabinKarpStringSearch(char[] txt, char[] pat)
	{
		System.out.println("\n------Rabin Karp String Search---------------");
		int textSize = txt.length;
		int patternSize = pat.length;			
		int prime =101;
		
		int patternHash=0;
		int textHash=0;
		int hashValue=hashValueOfPattern(pat);
		
		for(int i=0;i<patternSize;i++)
		{
			patternHash = (256*patternHash+pat[i])%prime;
			textHash = (256*textHash+txt[i])%prime;
			//System.out.println("patternHash:"+patternHash + ", textHash:"+textHash);
			//System.out.println("patchar:"+pat[i] + ", textchar:"+txt[i]);
		}

		for (int i = 0; i <= textSize - patternSize; i++)
		{
			System.out.println("patternHash:"+patternHash + ", textHash:"+textHash);
			if(patternHash == textHash)
			{
				System.out.println("\thashes are same so do char comparison");
				int j;
				for (j = 0; j < pat.length; j++)
				{
					if (txt[i + j] != pat[j])
					{
						break;
					} 
				}
				
				if(j==patternSize)
				{
					System.out.print("\tpattern found at i="+i + "\n");
				}
			}
			
			if(i<textSize-patternSize)
			{
				textHash=(256*(textHash-txt[i]*hashValue)+txt[i+patternSize])%prime;
				
				if(textHash <=0)
				{
					textHash=textHash+prime;
				}
			}
		}
	}

	public static int hashValueOfPattern(char[] pattern)
	{
		int prime = 101; // can be any prime number
		int hashValue = 1;
		int numCharsAllowed = 256;

		for (int i = 0; i < pattern.length - 1; i++)
		{
			hashValue = (hashValue * numCharsAllowed) % prime;
		}
		System.out.println("hashValue: " + hashValue);
		return hashValue;
	}

	public static void printArray(int[] array)
	{
		System.out.println("");
		for (int i = 0; i <= array.length - 1; i++)
		{
			System.out.print(array[i] + " ");
		}
	}

}
