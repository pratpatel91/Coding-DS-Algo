
public class reverseStringUsingStringBuilder
{
	public static void main(String[] args)
	{
		//Input
		String string = "Prat";		
		
		//Function Call
		System.out.println(reverseString(string)); // ---------------------FUNCTION CALL----------------//
	}

	public static String reverseString(String string)
	{
		// 1st, we store the string into a character array
		char[] charArray = createCharacterArray(string); // ---------------------FUNCTION CALL----------------//
		
		
		//iterating a for loop backwards while storing the individual element
		//from the back and adding it onto the acucmulatingString
		String accumulatingReversedString = "";
		
		for (int i = charArray.length - 1; i >=0; i--)
		{
			accumulatingReversedString=accumulatingReversedString+charArray[i];
		}
		
		return accumulatingReversedString;
	}

	public static char[] createCharacterArray(String string)
	{
		char[] charArray = new char[string.length()];

		for (int i = 0; i <= string.length() - 1; i++)
		{
			charArray[i] = string.charAt(i);
		}
		return charArray;
	}

	public static void printArray(char[] charArray)
	{
		for (int i = 0; i <= charArray.length - 1; i++)
		{
			System.out.print(charArray[i] + " ");
		}
		System.out.println("");
	}
}
