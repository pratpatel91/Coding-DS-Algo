
public class Recursion_IntToBinary
{
	public static void main(String[] args)
	{
		intToBinary(10);
	}

	public static void intToBinary(int num)
	{
		if (num == 0)
		{
			return;
		}

		intToBinary(num / 2); // HEAD RECURSION
		System.out.print(num % 2 + " ");

	}
}
