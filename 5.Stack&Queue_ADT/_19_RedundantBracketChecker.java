import java.util.Stack;

public class _19_RedundantBracketChecker
{
	//(b) BRACES DOESNT HAVE AN OPERATOR SO ITS REDUNDANT
	//(a+b) BRACES HAS AN OPERATOR SO ITS NOT REDUNDANT 
	public static void main(String[] args)
	{
		String braces = "(a)";
		optimized_RedundantBraces(braces);
	}

	// TC=O(N) due to string traversal
	// SC=O(N) due to creating a stack
	public static void optimized_RedundantBraces(String braces)
	{
		Stack<Character> stack = new Stack<>();

		boolean isRedundant = false;

		// string traversal
		for (int i = 0; i <= braces.length() - 1; i++)
		{
			char currChar = braces.charAt(i);
			if (currChar != ')')
			{
				stack.push(currChar);
			} else
			{
				boolean isOperatorPresent = false;

				while (stack.peek() != '(')
				{
					if (isOperator(stack.peek()))
					{
						isOperatorPresent = true;
					}
					stack.pop();
				}
				if (isOperatorPresent == false)
				{
					isRedundant = true;
					break;
				}
			}
		}
		System.out.println("Is Redundancy Present?: " + isRedundant);
	}

	public static boolean isOperator(Character c)
	{
		return (c == '+' || c == '-' || c == '/' || c == '*');
	}
}
