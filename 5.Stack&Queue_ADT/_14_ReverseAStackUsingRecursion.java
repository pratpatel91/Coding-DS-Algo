import java.util.Stack;

public class _14_ReverseAStackUsingRecursion
{
	static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args)
	{
		// populating the stack
		for (int i = 1; i <= 5; i++)
		{
			stack.push(i);
		}

		reverseStack(stack);
		printStack(stack);
	}

	public static void insertBottomOfStack(Stack<Integer> stack, int value)
	{
		// BASE CASE (aka stopping condition)
		if (stack.isEmpty())
		{
			stack.push(value);
		} else
		{
			int topElement = stack.peek(); // API
			System.out.println("Insert Bottom(): Top element before recursion:" + topElement);
			stack.pop(); // API; updates top pointer to be top--
			insertBottomOfStack(stack, value);// RECURSION
			System.out.println("Insert Bottom(): Top element after recursion:" + topElement);
			stack.push(topElement); // BACKTRACKING aka undo
		}
	}
	//2^N RECURSIONis when we have 2 function calls
	//3^N RECURSION is when we have 3 function calls
	public static void reverseStack(Stack<Integer> stack)
	{
		if (!stack.isEmpty()) // BASE CASE
		{
			int topElement = stack.peek(); // API
			System.out.println("Top element before recursion:" + topElement);
			stack.pop(); // API; updates top pointer to be top--
			reverseStack(stack); // RECURSION TC=O(N)
			System.out.println("Top element after recursion:" + topElement);
			insertBottomOfStack(stack, topElement);
		}
	}

	public static void printStack(Stack<Integer> stack)
	{
		while (!stack.isEmpty())
		{
			int topElement = stack.peek(); // API
			stack.pop(); // API; updates top pointer to be top--
			System.out.println(topElement);
		}
	}

}
