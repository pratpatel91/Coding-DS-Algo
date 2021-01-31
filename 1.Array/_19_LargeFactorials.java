
public class _19_LargeFactorials
{

	public static void main(String[] args)
	{
		// iterativeFactorial(50)= 0 because int data type experiences int overflow
		// we dont have any data type that can store multiplication of larger number

		// System.out.println(iterativeFactorial(50));
		largeNumberFactorial(50);
	}

	public static int iterativeFactorial(int n)
	{
		// -------Iterative Approach (aka for loops used)---------//
		int factorial = 1;// we know that 1! = 1 (breaking condition)

		// 5!=5*4*3*2*1=120
		for (int i = 1; i <= n; i++)
		{
			factorial = factorial * i;// accumulating variables value
		}

		return factorial;
	}

	public static void largeNumberFactorial(int n)
	{
		int[] array = new int[10000];

		// factorial of 1 =1
		array[0] = 1;

		int arraySizeDueToFactorial = 1;

		// for loop starts from i=2 (because n*1=n(identity))
		for (int i = 2; i <= n; i++)
		{
			arraySizeDueToFactorial = findingArraySize(i, array, arraySizeDueToFactorial);
		}

		printReverseArray(array, arraySizeDueToFactorial);

	}

	public static int findingArraySize(int x, int[] array, int size)
	{
		int carry = 0;

		for (int i = 0; i < size; i++)
		{
			int result = array[i] * x + carry;
			// we want to store the right most digit into the array
			array[i] = result % 10;
			// we want to store the left most digit into the carry
			carry = result / 10;
		}

		//
		while (carry != 0)
		{
			// we want to store the carry value into the array
			array[size] = carry % 10; // here size fill the left most decimal places
			// finding the remainder
			carry = carry / 10;
			// increasing size of the array by one
			size++;
		}
		return size;
	}

	public static void printReverseArray(int[] array, int size)
	{
		System.out.println("\n");
		for (int i = size - 1; i >= 0; i--)
		{
			System.out.print(array[i] + "");
		}
	}

}
