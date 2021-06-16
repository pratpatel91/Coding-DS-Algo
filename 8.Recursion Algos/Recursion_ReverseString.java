
public class Recursion_ReverseString
{
	static int i = 0;

	public static void main(String[] args)
	{
		String string = "prat";
		String reversedString =recursion_ReverseString(string);
		System.out.println("Reversed String: " + reversedString);
		
	}

	public static String recursion_ReverseString(String string)
	{
		if (string.length() == 0)
		{
			return string;
		}

		return recursion_ReverseString(string.substring(1))+string.charAt(0);
	}

}
