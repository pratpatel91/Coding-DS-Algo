import java.util.Scanner;
import java.util.Stack;
//Lines 40 & 63 contains equations for the core logic
public class _8_FindMinInStackInConstantTime
{
	static int currentMin = Integer.MAX_VALUE;
	static int currentMinAux = Integer.MAX_VALUE;
	static Stack<Integer> stack = new Stack<>();
	static Stack<Integer> st = new Stack<>(); //SC=O(N) aux stack
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();

		for (int i = 1; i <= N; i++)
		{
			int value = input.nextInt();
			PUSH(stack, value);
			
			if(currentMinAux > value)
			{
				currentMinAux =value;
				st.push(currentMinAux ); //SC=O(1)
			}
			else
			{
				st.push(currentMinAux); //SC=O(1)
			}
		}

		getMin();
		POP(stack);
		POP(stack);
		printStack(stack);
		getMin();
		System.out.println("--------Aux Stack-----------");
		printStack(st);
	}

	public static void PUSH(Stack<Integer> stack, int value)
	{
		if (stack.isEmpty())
		{
			stack.push(value); // API
			currentMin = value;
		} else if (value >= currentMin)
		{
			stack.push(value); // API
		} else
		{
			//adding a fakevalue into the stack
			// in order to find the previous min
			int fakeValue = value * 2 - currentMin;
			stack.push(fakeValue); // API
			currentMin = value;
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

	public static void POP(Stack<Integer> stack)
	{
		int topElement = stack.peek(); // API

		if (topElement < currentMin)
		{
			//finding the previous min
			currentMin = 2 * currentMin - topElement;
			stack.pop(); //API
		}
		else
		{
			stack.pop(); // API
		}
	}

	public static void getMin()
	{
		System.out.println("Min:" + currentMin);
	}
}
