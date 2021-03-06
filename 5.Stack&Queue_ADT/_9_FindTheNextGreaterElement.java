import java.util.Stack;

public class _9_FindTheNextGreaterElement
{

	public static void main(String[] args)
	{
		int[] array = {4,3,2,1};
		NextGreaterElement(array);
	}
	
	public static void NextGreaterElement(int[] array)
	{
		Stack<Integer> stack = new Stack<>();
		
		stack.push(0);
		
		for(int i=1; i<=array.length-1;i++)
		{
			while(!stack.empty() && array[i]>array[stack.peek()])
			{
				System.out.println(array[i] + " is larger than " +array[stack.peek()]);
				stack.pop(); // popping all the elements smaller than array[i]
			}
			stack.push(i);
		}
		
		//case of not having greater elements to the right
		while(!stack.empty())
		{
			System.out.println("for " + array[stack.peek()] + " no greater element exists --> -1");
			stack.pop(); // stops the while loop
		}
	}
	
	
	
	

}
