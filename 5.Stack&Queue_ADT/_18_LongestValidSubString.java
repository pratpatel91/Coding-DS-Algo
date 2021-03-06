public class _18_LongestValidSubString
{
	public static void main(String[] args)
	{
		String braces = ")(((()(";
		optimized_LongestValidSubString(braces);
	}

	// TC=O(N)
	// SC=O(1)
	public static void optimized_LongestValidSubString(String braces)
	{
		int close = 0;
		int open = 0;
		int maxValidLength = 0;
		
		//HANDLES ")()(((((" case
		for (int i = 0; i <= braces.length() - 1; i++)
		{
			char currChar = braces.charAt(i);

			if (currChar == '(')
			{
				open++;
			}
			if (currChar == ')')
			{
				close++;
			}

			if (open == close)
			{
				maxValidLength = Math.max((open + close), maxValidLength);
			} else if (close > open)
			{
				close = 0;
				open = 0;
			}
		}
		
		close = 0;
		open = 0;
		//HANDLES ")(((()(" case
		for (int i = braces.length() - 1; i >= 0; i--)
		{
			char currChar = braces.charAt(i);

			if (currChar == '(')
			{
				open++;
			}
			if (currChar == ')')
			{
				close++;
			}

			if (open == close)
			{
				maxValidLength = Math.max((open + close), maxValidLength);
			} else if (open > close)
			{
				close = 0;
				open = 0;
			}
		}
		System.out.println(maxValidLength);
	}
}
