public class reverseStringUsingACharacterArray
{
	public static void main(String[] args)
	{
		//Input
		String string = "Prat";		
		
		//Function Call
		reverseString(string); // ---------------------FUNCTION CALL----------------//
	}

	public static void reverseString(String string)
	{
		// 1st, we store the string into a character array
		char[] charArray = createCharacterArray(string); // ---------------------FUNCTION CALL----------------//

		// 2nd, we use a two pointers approach in order to swap elements to reverse the
		// character array
		int leftIndex = 0;
		int rightIndex = charArray.length - 1;

		System.out.println("leftIndex:" + leftIndex + ", rightIndex:" + rightIndex);
		printArray(charArray); // ---------------------FUNCTION CALL----------------//

		while (leftIndex < rightIndex)
		{
			// swap characters (leftIndex Character with rightIndex Character)
			char temp = charArray[leftIndex];
			charArray[leftIndex] = charArray[rightIndex];
			charArray[rightIndex] = temp;

			// move towards middle
			leftIndex++;
			rightIndex--;
			System.out.println("leftIndex:" + leftIndex + ", rightIndex:" + rightIndex);
			printArray(charArray); // ---------------------FUNCTION CALL----------------//
		}
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
