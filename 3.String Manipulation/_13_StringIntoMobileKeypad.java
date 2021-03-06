
public class _13_StringIntoMobileKeypad
{

	public static void main(String[] args)
	{
		String text = "PRATIKSH";
		stringToNumericSequence(text);
	}

	public static void stringToNumericSequence(String text)
	{
		String keypad[] = { "2", "22", "222", "3", "33", "333", "4", "44", "444", "5", "55", "555", "6", "66", "666",
				"7", "77", "777", "7777", "8", "88", "888", "9", "99", "999", "9999" };
		
		//iterating the string to find the respective keypad to concatente to the final
		//answer
		String accumulatingSequence = "";
		
		for (int i = 0; i <= text.length() - 1; i++)
		{
			char currentChar = text.charAt(i);
			int currentValue = getIndexFromChar(currentChar);
			accumulatingSequence+=keypad[currentValue]; //string concatenation
		}
		System.out.println(accumulatingSequence);
	}

	public static int getIndexFromChar(char element)
	{
		return element - 'A'; // '' means character and "" means string
	}
}
