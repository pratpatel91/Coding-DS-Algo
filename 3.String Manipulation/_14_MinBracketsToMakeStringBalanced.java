import java.util.Stack;

public class _14_MinBracketsToMakeStringBalanced
{
	// TC=O(N) SC=O(N) due to creating an array based stack
	public static void main(String[] args)
	{
		String brackets = "{{}}}}";
		System.out.println(countReversals(brackets));
	}

	public static int countReversals(String brackets)
	{

		Stack<Character> st = new Stack<Character>();

		for (int i = 0; i <= brackets.length()-1; i++)
		{

			if (brackets.charAt(i) == '{')
			{
				st.push('{');
			} else if (brackets.charAt(i) == '}')
			{
				// check if the stack is empty so peek
				// doesnt give underflow errors
				if (!st.isEmpty())
				{
					char top = st.peek();

					if (top == '{')
					{
						st.pop();

					}
				} else
				{
					st.push('}');
				}
			}
		}
		int openingBraces=0;
		int closingBraces=0;
		
		while(!st.isEmpty())
		{
			if(st.peek() == '{')
			{
				openingBraces++;
			}
			else if (st.peek() == '}')
			{
				closingBraces++;
			}
			System.out.println("OB:" + openingBraces + ", CB:"+ closingBraces);
			st.pop();//shrinks the length so that the while loop can stop
			
			
		}
		System.out.println("OB:" + openingBraces + ", CB:"+ closingBraces);

		if(openingBraces %2 !=0)
		{
			openingBraces++;
		}
		if(closingBraces %2 !=0)
		{
			closingBraces++;
		}
		
		int minReversal = (openingBraces/2)+(closingBraces/2);
		
		if(brackets.length()%2!=0) //for odd string length we return -1
		{
			return -1;
		}
		else //for even string length we return the answer
		{
			return minReversal;
		}

	}

}
