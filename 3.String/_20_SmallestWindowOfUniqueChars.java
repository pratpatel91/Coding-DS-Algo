
public class _20_SmallestWindowOfUniqueChars
{

	public static void main(String[] args)
	{
		String text = "aabcbcdbca";
		System.out.println(smallestWindowOfUniqueChars(text));
	}

	public static int distinctChars(String text)
	{
		int[] hashArray = new int[26]; // 26 supports a-z

		int distinctChars = 0;

		// populating the hasharray
		for (int i = 0; i <= text.length() - 1; i++)
		{
			// filters out repeated chars
			if (hashArray[text.charAt(i) - 'a'] == 0)
			{
				distinctChars++;
				hashArray[text.charAt(i) - 'a']++;
			}
		}

		for (int i = 0; i <= hashArray.length - 1; i++)
		{
			if (hashArray[i] > 0)
			{
				System.out.println("char" + i + " " + hashArray[i] + " ");
			}
		}

		return distinctChars;
	}

	public static int smallestWindowOfUniqueChars(String text)
	{
		int distinctChars = distinctChars(text);

		int smallestWindow = text.length();

		int start = 0;
		int count = 0; // distinct chars in current window

		int[] hashArray = new int[26]; // 26 supports a-z

		for (int i = 0; i <= text.length() - 1; i++)
		{
			hashArray[text.charAt(i) - 'a']++;
			if (hashArray[text.charAt(i) - 'a'] == 1)
			{
				count++;
			}
			if (count == distinctChars)
			{
				// minimizing window (SLIDING WINDOW PROBLEM)
				while (hashArray[text.charAt(start) - 'a'] > 1)
				{
					System.out.println("start index:" + start + ", ending index:" + i);

					if (hashArray[text.charAt(start) - 'a'] > 1)
					{
						hashArray[text.charAt(start) - 'a']--; // decreasing frequency
					}
					start++;
				}

				int windowLength = i - start + 1; // +1 because indexing starts from i=0
				System.out.println("current window length:"+ windowLength +", previous window length:"+ smallestWindow);
				if (smallestWindow > windowLength)
				{
					smallestWindow = windowLength;
				}
				System.out.println("updated window length:"+ smallestWindow);
			}
		}
		return smallestWindow;
	}

}
