import java.util.Stack;

public class _12_PostFixEvalUsingStack
{
	public static void main(String[] args)
	{
		String input = "231*+9-";
		System.out.println(postFixStackEval(input));
	}

	public static int postFixStackEval(String input)
	{
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i <= input.length() - 1; i++)
		{
			char currentChar = input.charAt(i);

			if (isOperator(currentChar))
			{
				int A = stack.peek();
				stack.pop();
				int B = stack.peek();
				stack.pop();

				if (currentChar == '+')
				{
					stack.push(B + A);
				}
				if (currentChar == '-')
				{
					stack.push(B - A);
				}
				if (currentChar == '*')
				{
					stack.push(B * A);
				}
				if (currentChar == '/')
				{
					stack.push(B / A);
				}
			} else // if the current char is an integer
			{
				int digit = convertCharToDigit(currentChar);
				stack.push(digit);
			}
		}
		return stack.peek();
	}

	public static int convertCharToDigit(char c)
	{
		System.out.println("ASCI char:" + (int) c + ", ASCI of zero: " + (int) '0');
		return (c - '0'); // ASCI Value of 48 is 0
	}

	public static boolean isOperator(char c)
	{
		if (c == '+' || c == '-' || c == '*' || c == '/')
		{
			return true;
		}
		return false;
	}

}
