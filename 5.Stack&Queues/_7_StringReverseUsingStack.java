import java.util.Stack;

public class _7_StringReverseUsingStack
{

	public static void main(String[] args)
	{
		String input = "Pratiksh Patel";
		
		//creating the char array
		char[] charArray = new char[input.length()];
		
		//populating the char array to store the string
		for(int i=0; i<=charArray.length-1;i++)
		{
			char currentChar=input.charAt(i);
			charArray[i]=currentChar;
		}
		
		//------------------Stack---------------------//
		//creating a stack
		Stack<Character> stack = new Stack<>();
		
		//populating the stack
		for(int i=0; i<=charArray.length-1;i++)
		{
			stack.push(charArray[i]);
		}

		//displaying the stack in reverse by popping 
		//chars off of the stack
		while(!stack.isEmpty())
		{
			char top = stack.peek();
			stack.pop();
			System.out.print(top + " ");
		}
	}
}
