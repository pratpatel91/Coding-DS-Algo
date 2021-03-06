import java.util.Stack;

public class _13_InsertAtBottomInStack
{
	static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args)
	{
		// populating the stack
		for (int i = 1; i <= 5; i++)
		{
			stack.push(i);
		}

		//printStack(stack);
		insertBottomOfStack(stack, 6);
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
			System.out.println("Top element before recursion:" + topElement);
			stack.pop(); // API; updates top pointer to be top--
			insertBottomOfStack(stack, value);// RECURSION
			System.out.println("Top element after recursion:" + topElement);
			stack.push(topElement); // BACKTRACKING aka undo
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
