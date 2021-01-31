
public class PrintFrom1ToN
{
	public static final int N = 100;

	public static void main(String[] args)
	{
		print(N);

	}

	public static void print(int n)
	{
		if (n <= 0)
		{
			return;
		}

		print(n - 1);
		System.out.print(n);
		System.out.print(" ");
	}

}
