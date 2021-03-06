
public class FindLengthOfLastWord
{
	public static void main(String[] args)
	{
		String name = "Pratiksh Patel";
		displayingTheStringForward(name);
		displayingTheStringBackwards(name);
		findingLengthOfTheLastWord(name);
	}

	public static void displayingTheStringForward(String name)
	{
		System.out.println("---traversing the string forward---");
		for (int i = 0; i <= name.length() - 1; i++)
		{
			char currentChar = name.charAt(i);
			System.out.println(currentChar);
		}
	}

	public static void displayingTheStringBackwards(String name)
	{
		System.out.println("---traversing the string backwards---");
		for (int i = name.length() - 1; i >= 0; i--)
		{
			char currentChar = name.charAt(i);
			System.out.println(currentChar);
		}
	}

	public static void findingLengthOfTheLastWord(String name)
	{
		System.out.println("---finding the length of the last word---");
		int lastWordsLength = 0;

		//traversing the string backwards
		for (int i = name.length() - 1; i >= 0; i--)
		{
			char currentChar = name.charAt(i);

			//during the backward string traversal
			//keep on displaying the character and increasing the last words length until we see empty characters
			while(currentChar != ' ')
			{
				System.out.println(currentChar);
				lastWordsLength++;
				break;
			} 
			
			if(currentChar == ' ')
			{
				System.out.println("due to encountering an empty character we are going to stop the for loop");
				break;
			}
		}
		System.out.println("Length Of Last Word:" + lastWordsLength);
	}

}
