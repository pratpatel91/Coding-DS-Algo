import java.util.Arrays;
import java.util.Stack;

public class _33_NextSmallestToTheRight
{
	public static void main(String[] args)
	{
		int[] array = { 4, 5, 2, 0 };
		System.out.print("Input Array: ");
		printArray(array);
		bruteforce_NextSmallestElementToTheRight(array);
		stack_NextSmallestElementToTheRight(array);
	}

	// TC=O(N^2) SC=O(1)
	public static void bruteforce_NextSmallestElementToTheRight(int[] array)
	{
		System.out.println("\n\n...bruteforce_NextSmallestToTheRight(array)");
		int[] nextSmallestElementToTheRightArray = new int[array.length];

		for (int i = 0; i <= array.length - 1; i++)
		{
			for (int j = i + 1; j <= array.length - 1; j++)
			{
				if (array[i] > array[j])
				{
					nextSmallestElementToTheRightArray[i] = array[j];
					break;
				}
				nextSmallestElementToTheRightArray[i]=0;
			}
		}
		nextSmallestElementToTheRightArray[array.length - 1] = -1;
		System.out.print("nextSmallestElementToTheRightArray: ");
		printArray(nextSmallestElementToTheRightArray);
	}

	public static void printArray(int[] array)
	{
		for (int i = 0; i <= array.length - 1; i++)
		{
			System.out.print(array[i] + " ");
		}
	}

	// TC=O(N) SC=O(N) due to creating a stack data structure
	public static void stack_NextSmallestElementToTheRight(int[] array)
	{
		System.out.println("\n");
		System.out.println("...findNextGreaterElements(array)");
		int[] nextSmallestElementToTheRightArray = new int[array.length];
		Arrays.fill(nextSmallestElementToTheRightArray, -1);

		// create an empty stack
		Stack<Integer> s = new Stack<>();

		// traversing all the array elements
		for (int i = 0; i < array.length; i++)
		{

			// Keep popping elements from the stack smaller than the current
			// element, and set their next greater element to the current element

			while (!s.isEmpty() && array[s.peek()] > array[i])
			{
				nextSmallestElementToTheRightArray[s.pop()] = array[i];
			}

			// push current "index" into the stack
			s.push(i);
		}
		System.out.print("nextSmallestElementToTheRightArray: ");
		printArray(nextSmallestElementToTheRightArray);
	}

}
