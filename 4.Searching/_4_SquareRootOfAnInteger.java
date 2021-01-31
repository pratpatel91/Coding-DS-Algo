
public class _4_SquareRootOfAnInteger
{

	public static void main(String[] args)
	{
		squareRoot(1);
		squareRoot(25);
	}

	// Square root of 25 is 5 because 5*5 =25
	public static void squareRoot(int n)
	{
		System.out.println("\n-->Finding the square root of " + n);
		// find first positive number i such that i*i is greater than x
		int i = 1;

		while (i * i <= n)
		{	//printing all the perfect squares from 1 to n
			System.out.println("Is " + i + "*" + i + "=" + n + "?");
			i++;
		}

		System.out.println("Square root of " + n + " is " + (i - 1));
	}
}
