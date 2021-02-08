import java.util.Scanner;
import java.util.Stack;

public class _15_SortTheStack
{
	static Stack<Integer> stack = new Stack<>(); //SC=O(1) given data structure
	static Stack<Integer> auxStack = new Stack<>(); //SC=O(N)

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		// populating the stack
		for (int i = 0; i < 5; i++)
		{
			int val = input.nextInt(); // stored input
			stack.push(val); // pushing stored input into stack
		}
		sortStack(stack, auxStack);
	}
	
	public static void sortStack(Stack<Integer> stack, Stack<Integer> auxStack)
	{
		//Sorting analagous to bubble sorting
		while(!stack.isEmpty())
		{
			int topElement = stack.peek(); // API
			stack.pop();// API; updates top pointer to be top--
			
			while (!auxStack.isEmpty() && (auxStack.peek()<topElement) )
			{
				stack.push(auxStack.peek());
				auxStack.pop();
			}
			auxStack.push(topElement);
		}
		//printStack(auxStack);//reverse sorted stack
		
		//migrating the reverse sorted stack back into the original stack
		// in order to form a sorted stack
		while(!auxStack.isEmpty())
		{
			int topAuxElement = auxStack.peek();
			stack.push(topAuxElement);
			auxStack.pop();// API; updates top pointer to be top--
		}
		
		printStack(stack);//sorted stack
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
