public class Recursion_SumFrom1ToN
{
	public static void main(String[] args)
	{
		int N = 4;
		System.out.println(SumFrom1ToN(N));
	}

	public static int SumFrom1ToN(int N)
	{
		if (N == 1)
		{
			return  1;
		}
		return N +  SumFrom1ToN(N - 1);
	}
	//Alternative Lengthy Code
	/*
	int sum = 0;

	if (N == 1)
	{
		sum = 1;
	}
	else if (N > 1)
	{
		sum = N + SumFrom1ToN(N - 1);
	}
	return sum;
	*/
}
