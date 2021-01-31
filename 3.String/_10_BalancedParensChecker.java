import java.util.Stack;

public class _10_BalancedParensChecker {

	public static void main(String[] args) {
		String parenthesis = "([])";
		System.out.println(isParensBalanced(parenthesis));
	}
	
	public static boolean isParensBalanced(String parenthesis)
	{
		//Stack is an Abstract data type
		// so we need to specify the datatype for implementation
		Stack<Character> stack = new Stack<>();
		
		//for loop to iterate the strings elements
		for(int i=0; i<=parenthesis.length()-1; i++)
		{
			char current = parenthesis.charAt(i);
			
			if(current == '(' || current == '{' || current =='[')
			{
				//for any opening brace push it blindly onto the stack
				stack.push(current);
			}
			else 
			{
				//pop from a populated stack
				if(!stack.isEmpty() && checkChars(current,stack.peek()))
				{
					stack.pop();
				}
				else // if the chars are mismatching then return false
				{
					return false;
				}
			}
		}
		//empty stack means that balanced chars were all popped off
		// and that we dont have any mismatching chars left in the stack

		return stack.isEmpty();
	}
	
	public static boolean checkChars(char current, char top)
	{
		//top elements are all opening braces
		//current elements are all closing braces
		if(current==')'&& top=='(')
		{
			return true;
		}
		if(current=='}'&& top=='{')
		{
			return true;
		}
		if(current==']'&& top=='[')
		{
			return true;
		}
		return false;
	}

}
