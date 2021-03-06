

import java.util.Stack;

class reverseStringUsingStack
{
	public static void main(String[] args)
	{
		String string = "prat";
		reverseStringViaStack(string);
	}

	public static void reverseStringViaStack(String string)
	{
		// 1.create an empty stack
		Stack<Character> stack = new Stack<Character>();

		// 2.convert the string into a char array
		char[] charArray = convertStringIntoCharArray(string);
		
		printArray(charArray);

		// 3.push all the elements from the char array
		// into the stack
		stackPush(stack, charArray);

		// 4.pop all the elements from the stack and
		// put them back into the char array
		for (int i = 0; i <= charArray.length - 1; ++i)
		{
			charArray[i] = stack.pop();
		}

		printArray(charArray);
	}
	
	public static void stackPush(Stack<Character> stack, char[] charArray)
	{
		for (int i = 0; i <= charArray.length - 1; i++)
		{
			stack.push(charArray[i]);
		}
	}

	public static void printArray(char[] array)
	{
		System.out.println("");

		for (int i = 0; i <= array.length - 1; i++)
		{
			System.out.print(array[i] + " ");
		}
	}
	
	public static char[] convertStringIntoCharArray(String string)
	{
		char[] charArray = new char[string.length()];
		
		for (int i = 0; i <= string.length() - 1; i++)
		{
			charArray[i]=string.charAt(i);
		}
		return charArray;
	}

}
