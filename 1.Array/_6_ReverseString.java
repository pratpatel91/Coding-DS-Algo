public class _6_ReverseString
{
	public static void main(String[] args)
	{
		reverseString("Hello");
	}

	public static void reverseString(String originalString)
	{
		String reversedString = "";

		int stringLength = originalString.length() - 1;
		
		for (int i = stringLength; i >= 0; i--)
		{
			reversedString = reversedString + originalString.charAt(i);
			System.out.println(reversedString);
		}
	}
}
